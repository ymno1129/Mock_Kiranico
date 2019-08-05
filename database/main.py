import sys
from buildDatabase import build, buildHHNotesRelations
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

if __name__ == "__main__":
    #runDatabase()
    buildHHNotesRelations()
