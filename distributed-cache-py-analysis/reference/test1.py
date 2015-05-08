import csv
from collections import defaultdict
reader = csv.DictReader(open('alllogs.csv', newline=''))
cities = defaultdict(int)
for row in reader:
    cities[row["parallelSize"]] += int(row["time"])
    # print("time:",row["time"])

writer = csv.writer(open('results.csv', 'w', newline = ''))
writer.writerow(["parallelSize", "time"])
writer.writerows([city, cities[city]] for city in cities)
print("Done.")
