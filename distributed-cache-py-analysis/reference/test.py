import csv
from collections import defaultdict
reader = csv.DictReader(open('test.csv', newline=''))
cities = defaultdict(int)
for row in reader:
    cities[row["CITY"]] += int(row["AMOUNT"])

writer = csv.writer(open('out.csv', 'w', newline = ''))
writer.writerow(["CITY", "AMOUNT"])
writer.writerows([city, cities[city]] for city in cities)
