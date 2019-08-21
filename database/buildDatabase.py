
from json import load as jsonLoad
from json import dump
from csv import reader as csvReader
from os.path import exists as pathExists
from PIL import Image, ImageDraw, ImageOps

import os

config_path = "./build_config.json"

def createTable(name, table_info):
    columns = table_info["columns"]
    primary = table_info["primary"]
    cols = []
    for col in columns:
        line = "`" + col + "` " + columns[col]
        line += " DEFAULT NULL" if col not in primary else " NOT NULL"
        cols.append(line)
    sql = "create table if not exists `%s` (" + len(columns) * "%s," + "PRIMARY KEY (" + (len(primary) - 1) * "`%s`," + "`%s`));"
    args = [name] + cols + list(primary.keys())
    sql = sql % tuple(args)
    return sql

def insertionsFromCSV(name, table_info):
    path = table_info["path"]
    assert pathExists(path), "csv file [%s] missing" % (path)
    columns = table_info["columns"]
    with open(path, 'r') as input:
        reader = csvReader(input)

        #number of rows in the csv
        rows = 0

        #Lines of insertion
        lines = []

        for idx, row in enumerate(reader):
            if idx == 0:
                continue
            rows += 1
            line = "(" + (len(row) - 1) * "%s,"
            line += "%s)"
            args = []
            for item in row:
                print (item, len(item))
                if len(item) == 0:
                    args.append("NULL")
                elif item.isdigit():
                    args.append(item)
                elif item == "FALSE" or item == "TRUE":
                    args.append('1') if item == "TRUE" else args.append('0')
                else:
                    args.append("'%s'" % (item.replace('\'', '')))
            line = line % (tuple(args))
            lines.append(line)
            #if idx == 3: break

        col_names = list(columns.keys())
        insertion_header = "insert into `%s` (" + (len(col_names) - 1) * "`%s`," + "`%s`) values "
        insertion_header = insertion_header % tuple([name] + col_names)
        insertion_body = ','.join(["%s"] * (rows)) + ';'
        insertion_body = insertion_body % tuple(lines)
        insertion = insertion_header + insertion_body
        return insertion

def build():
    assert pathExists(config_path), "build config file missing!"

    sql = ""
    with open(config_path, 'r') as input:
        config = jsonLoad(input)

    for table_name in config:
        if not config[table_name]["active"]: continue

        table_info = config[table_name]

        create_sql = createTable(table_name, table_info)
        sql += "\n" + create_sql

        insertion_sql = insertionsFromCSV(table_name, table_info)
        sql += "\n" + insertion_sql

    return sql

def buildHHNotesRelations():
    melody_path = "./source_data/weapons/weapon_melody_combined.csv"
    weapons_path = "./source_data/weapons/weapon_base.csv"
    all_melodies = []
    with open(melody_path, 'r') as input:
        reader = csvReader(input)
        for idx, row in enumerate(reader):
            if idx == 0: continue
            all_melodies.append(row[0])

    weapon_melody_dict = {}
    with open(weapons_path, 'r') as input:
        reader = csvReader(input)
        for idx, row in enumerate(reader):
            if idx == 0 or row[2] != 'hunting-horn': continue
            weapon_name = row[1]
            weapon_name = weapon_name.replace('\'', '')
            print (weapon_name)
            weapon_notes = row[-3]
            #print (weapon_name, weapon_notes, all_melodies[0])

            weapon_melody = {}
            for c in weapon_notes:
                weapon_melody[c] = 1

            for melody in all_melodies:
                feasible = True
                for c in melody:
                    if c not in weapon_melody:
                        feasible = False
                        break
                if feasible:
                    if weapon_name not in weapon_melody_dict:
                        weapon_melody_dict[weapon_name] = [melody]
                    else:
                        weapon_melody_dict[weapon_name].append(melody)
    with open("weapon_all_melodies.json", 'w') as output:
        dump(weapon_melody_dict, output, separators=(',\n', ':'))

    idx = 0
    for weapon in weapon_melody_dict:
        #print (weapon, sorted(weapon_melody_dict[weapon], key=lambda x:len(x)))
        idx += 1
        if (idx == 10): break

def buildAmmoMap():
    path = "./source_data/weapons/bowgun_ammo_map.json"
    output_path = "./source_data/weapons/name_ammo_map.json"
    reverse_map = {}
    with open(path, 'r') as input:
        jobj = jsonLoad(input)
        for key in jobj:
            weapons = jobj[key]
            for w in weapons:
                w = w.replace('\'', '')
                reverse_map[w] = key

    with open(output_path, 'w') as output:
        dump(reverse_map, output, separators=(',\n', ':'))

def buildWeaponImageMap():
    path = "./source_data/weapons/weapon_base.csv"
    output_path = "./source_data/weapons/weapon_image_map.json"
    output_weapons = []
    with open(path, 'r') as input:
        reader = csvReader(input)
        for idx, row in enumerate(reader):
            if idx == 0: continue
            if idx >= 1253: break
            weapon_name = row[1]

            output_weapons.append(weapon_name)

    with open(output_path, 'w') as output:
        output.write("{\n")
        line = "\"%s\":\"\",\n"
        for weapon in output_weapons:
            weapon = weapon.replace("\"", '').replace("\'", '')
            output.write(line % weapon)
        output.write("}")

def processWeaponImageMap():
    input_path = "./source_data/weapons/weapon_image_map.json"
    output_path = "./source_data/weapons/test_map.json"
    output_lines = []
    with open(input_path, 'r') as input:
        jobj = jsonLoad(input)
        for weapon_name in jobj:
            words = weapon_name.split()
            image_name = []
            for w in words:
                if len(w) != w.count('I'): image_name.append(w.lower())
            image_name = '_'.join(image_name) + ".png"
            print (weapon_name, image_name)
            output_lines.append(("\"%s\": \"%s\",\n" % (weapon_name, image_name)))
    with open(output_path, 'w') as output:
        output.write("{\n")
        for line in output_lines:
            output.write(line)
        output.write("\n}")

def generateSharpness():
    data_path = "./source_data/weapons/weapon_sharpness.csv"
    output_dir = "./source_data/weapons/sharpness_imgs/"

    width = 200
    height = 15

    with open(data_path, 'r') as input:
        reader = csvReader(input)
        for idx, row in enumerate(reader):
            if idx == 0: continue
            weapon_name = row[0].replace('\"', '').replace('\'', '')
            #if weapon_name != "Anguish": continue
            red, orange, yellow, green, blue, white = [int(e) / 2 for e in row[2:8]]
            img = Image.new("RGB", (width, height), (0, 0, 0))
            draw = ImageDraw.Draw(img)
            tmp = 0
            if red != 0:
                draw.rectangle([(tmp, 0), (tmp + red, height)], fill='red')
                tmp += red
            if orange != 0:
                draw.rectangle([(tmp, 0), (tmp + orange, height)], fill='orange')
                tmp += orange
            if yellow != 0:
                draw.rectangle([(tmp, 0), (tmp + yellow, height)], fill='yellow')
                tmp += yellow
            if green != 0:
                draw.rectangle([(tmp, 0), (tmp + green, height)], fill='green')
                tmp += green
            if blue != 0:
                draw.rectangle([(tmp, 0), (tmp + blue, height)], fill='blue')
                tmp += blue
            if white != 0:
                draw.rectangle([(tmp, 0), (tmp + white, height)], fill='white')
                tmp += white

            img_outlined = ImageOps.expand(img, 2, 0)
            filename = '_'.join([e.lower() for e in weapon_name.split()]) + ".png"
            output_path = os.path.join(output_dir, filename)
            img_outlined.save(output_path)

            #if tmp == 400: print (weapon_name)

def getUniqueNotes():
    path = "./source_data/weapons/weapon_melody_notes.csv"
    all_letters = {}
    with open(path, 'r') as input:
        reader = csvReader(input)
        for idx, row in enumerate(reader):
            if idx == 0: continue
            notes = row[1]
            for c in notes:
                if c not in all_letters: all_letters[c] = 1
    print (all_letters.keys())