
from json import load as jsonLoad
from csv import reader as csvReader
from os.path import exists as pathExists

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