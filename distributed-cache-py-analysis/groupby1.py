## {{{ http://code.activestate.com/recipes/577535/ (r2)
#How to do aggregates using groupby, defaultdict and Counter on flat files
#This Example computes groups for:
#region, count(region), sum(sales), avg(sales), max(sales), min(sales)
#
#By Nestor Nissen

from csv import DictReader
from operator import itemgetter
from itertools import groupby
from collections import defaultdict, Counter

rawdata = '''
Region,City,Sales
Scotland,Edinburgh,20000
Scotland,Glasgow,12500
Wales,Cardiff,29700
Wales,Bangor,12800
England,London,90000
England,Manchester,45600
England,Liverpool,29700
England,Liverpool,100
'''.splitlines()[1:]



# indata = list(DictReader(rawdata))
indata = list(DictReader(open('alllogs.csv', newline='')))

print('Using sort and groupby:')
counts = []
sums = []
avgs = []
maxs = []
mins = []
ordered_data = sorted(indata, key=itemgetter('cacheType','parallelSize'))
for region, group in groupby(ordered_data, key=itemgetter('cacheType','parallelSize')):
    group_list = list(group)
    count = sum(1 for city in group_list)
    total = sum(int(city['time']) for city in group_list)
    maxsale = max(int(city['time']) for city in group_list)
    minsale = min(int(city['time']) for city in group_list)
    counts.append((region, count))
    sums.append((region, total))
    avgs.append((region, total/count))
    maxs.append((region, maxsale))
    mins.append((region, minsale))
print('count:',counts, '\nsum:',sums, '\navg:',avgs,
      '\nmax:',maxs, '\nmin:',mins, '\n')

print('Using counter:')
counts = list(Counter(map(itemgetter('Region'), indata)).items())
print('count:',counts)
## end of http://code.activestate.com/recipes/577535/ }}}

