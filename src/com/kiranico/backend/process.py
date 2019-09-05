import json
import os

print (os.path.exists("armorset_img.json"))

to_write = []

with open("armorset_img.json", 'r') as input:
    lines = input.readlines()
    for line in lines:
        new_name = line.strip().lower() + ".png"
        new_line = "\"%s\": \"%s\"," % (line.strip(), new_name)
        to_write.append(new_line)
        
with open("armorset_img_test.txt", 'w') as output:
    output.write("{\n")
    for line in to_write:
        output.write(line + "\n")
    output.write("}")