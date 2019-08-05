import requests
import json
from html.parser import HTMLParser

class MyHTMLParser(HTMLParser):
    def handle_starttag(self, tag, attrs):
        print("Encountered a start tag:", tag)

    def handle_endtag(self, tag):
        print("Encountered an end tag :", tag)

    def handle_data(self, data):
        print("Encountered some data  :", data)


class MHWiki_Worm:
    def __init__(self):
        self.wiki_base_url = "https://monsterhunterworld.wiki.fextralife.com/"
        self.weapon_types = ["Great+Sword", "Long+Sword"]

    def parseWeaponPage(self):
        for type in self.weapon_types:
            url = self.wiki_base_url + type
            try:
                print ("url = ", url)
                response = requests.get(url)
                html_str = (response.text)
                print (html_str)
                return
                parser = MyHTMLParser()
                parser.feed(html_str)

            except Exception as e:
                print (e)