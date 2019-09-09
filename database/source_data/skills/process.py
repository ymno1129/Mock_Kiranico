from csv import reader as csvReader

with open('skill_base.csv', 'r') as input:
    reader = csvReader(input)
    colors = {}
    for idx, row in enumerate(reader):
        if idx == 0: continue
        color = row[1]
        colors[color] = 1
    print (colors)
