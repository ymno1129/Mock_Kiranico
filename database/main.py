import sys
from buildDatabase import build
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
    #print (sys.version)
    #runWikiWorm()
    url = "https://monsterhunterworld.wiki.fextralife.com/file/Monster-Hunter-World/purgations_atrocity.png"
    url = "https://monsterhunterworld.wiki.fextralife.com/Great+Sword"
    response = requests.get(url, headers = {'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; WOW64; rv:20.0) Gecko/20100101 Firefox/20.0'})
    print (response.content.decode('utf-8'))