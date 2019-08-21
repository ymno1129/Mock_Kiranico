import sys
from buildDatabase import build, buildHHNotesRelations, buildAmmoMap, buildWeaponImageMap, processWeaponImageMap, generateSharpness, getUniqueNotes
from MHWiki_Worm import MHWiki_Worm
from urllib.request import urlopen, Request
import requests
from PIL import Image
from io import BytesIO

def runDatabase():
    sql = build()
    with open('mhw.sql', 'w') as output:
        output.write(sql)

def runWikiWorm():
    worm = MHWiki_Worm()
    worm.parseWeaponPage()

def process():
    out_lines = []
    with open("./body.txt", 'r') as input:
        lines = input.readlines()
        print (len(lines))
        for line in lines:
            line = line.strip()
            if (len(line) == 0): continue
            field_name = line.split()[-1][:-1]
            annot = "@Column(name = \"%s\")" % field_name
            out_lines.append(annot)
            out_lines.append(line)
            print (annot)
            print (line)



if __name__ == "__main__":
    getUniqueNotes()