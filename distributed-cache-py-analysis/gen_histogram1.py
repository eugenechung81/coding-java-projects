#!/usr/bin/env python
import numpy as np
import matplotlib.mlab as mlab
import matplotlib.pyplot as plt
from pandas import *
import pandas as pd
import numpy as np

#df = pd.read_csv('alllogs-1000.csv')
df = pd.read_csv('alllogs-perf1.csv')

#mu, sigma = 100, 15
#mu = df['time'].mean()
#mu = 500000
#sigma = df['time'].std() 
#mu = 1000000
#sigma = 250000
#x = mu + sigma*np.random.randn(10000)
#x = df['time']

#df_filtered = df[(df['cacheType']=='Hazelcast') & (df['parallelSize']==100) & (df['loopSize']==25) & (df['dataSize']=='small') & (df['preloadSize']==0)]
#df_filtered = df[(df['parallelSize']==100) & (df['loopSize']==25) & (df['dataSize']=='small') & (df['preloadSize']==0)]
#df_filtered = df[(df['cacheType']=='Hazelcast') & (df['parallelSize']==100) & (df['loopSize']==25) & (df['preloadSize']==0)]
#df_filtered = df[(df['cacheType']=='Hazelcast') & (df['parallelSize']==100) & (df['loopSize']==25)]
# df_filtered = df[(df['cacheType']=='Hazelcast') & (df['loopSize']==25)]
# df_filtered = df[(df['cacheType']=='Hazelcast') & (df['parallelSize']==100) & (df['preloadSize']==0) & (df['dataSize']=='large') ]

# df_filtered = df[(df['cacheType']=='Infinispan') & (df['parallelSize']==100) & (df['loopSize']==25) & (df['preloadSize']==0) & (df['dataSize']=='large')]
# df_filtered = df[(df['cacheType']=='Infinispan') & (df['loopSize']==25)]
# df_filtered = df[(df['cacheType']=='Infinispan') & (df['parallelSize']==100) ]
df_filtered = df[(df['cacheType']=='Infinispan') & (df['parallelSize']==100) & (df['preloadSize']==0) & (df['dataSize']=='large') ]

x = df_filtered['time']

# the histogram of the data
n, bins, patches = plt.hist(x, 5000, normed=0, facecolor='green', alpha=0.50)

# add a 'best fit' line
# y = mlab.normpdf( bins, mu, sigma)
#y = mlab.normpdf( bins, mu, sigma)
#l = plt.plot(bins, y, 'r--', linewidth=2)

plt.xlabel('Time(nano)')
plt.ylabel('Occurances')
plt.title(r'$\mathrm{Histogram\ of\ Cache Performance:}\ \mu=,\ \sigma=$')
plt.axis([0, 4000000, 0, 100000])
plt.grid(True)

plt.show()
