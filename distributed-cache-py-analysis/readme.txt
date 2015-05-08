to run

[Eugene@Eugene-T530:/cygdrive/c/projects/py-cache-perf]$ python gen_histogram1.py
[Eugene@Eugene-T530:/cygdrive/c/projects/py-cache-perf]$ python3 pivot_table.py


&

[Eugene@Eugene-T530:/cygdrive/c/projects/py-cache-perf]$ python3
Python 3.2.3 (default, Jul 23 2012, 16:48:24)
[GCC 4.5.3] on cygwin
Type "help", "copyright", "credits" or "license" for more information.
>>> from pandas import *
>>> import pandas as pd
>>> import numpy as np
>>> df = pd.read_csv('alllogs.csv')
>>> pivot_table(df, values='time', rows=['parallelSize','loopSize','dataSize','preloadSize'], cols=['cacheType'], aggfunc=np.max)
