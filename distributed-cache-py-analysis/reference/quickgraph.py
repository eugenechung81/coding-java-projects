import numpy as np
from pandas import *

ts = Series(np.random.randn(1000), index=date_range('1/1/2000', periods=1000))
ts = ts.cumsum()
ts.plot()
