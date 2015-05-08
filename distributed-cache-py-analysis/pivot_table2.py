from pandas import *
import pandas as pd
import numpy as np

df = pd.read_csv('alllogs.csv')

# PRINT 
#print(pivot_table(df, values='time', rows=['parallelSize','loopSize','dataSize','preloadSize','className'], cols=['cacheType'], aggfunc=np.mean))

# OUTPUT TO CSV
pivot_table(df, values='time', rows=['parallelSize','loopSize','dataSize','preloadSize','className'], cols=['cacheType'], aggfunc=np.mean).to_csv('p_mean.csv')
pivot_table(df, values='time', rows=['parallelSize','loopSize','dataSize','preloadSize','className'], cols=['cacheType'], aggfunc=np.median).to_csv('p_median.csv')
pivot_table(df, values='time', rows=['parallelSize','loopSize','dataSize','preloadSize','className'], cols=['cacheType'], aggfunc=np.std).to_csv('p_std.csv')
pivot_table(df, values='time', rows=['parallelSize','loopSize','dataSize','preloadSize','className'], cols=['cacheType'], aggfunc=np.min).to_csv('p_min.csv')
pivot_table(df, values='time', rows=['parallelSize','loopSize','dataSize','preloadSize','className'], cols=['cacheType'], aggfunc=np.max).to_csv('p_max.csv')

