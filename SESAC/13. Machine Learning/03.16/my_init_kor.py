#!sudo apt-get install -y fonts-nanum
#!sudo fc-cache -fv
#!rm ~/.cache/matplotlib -rf
# 1. 최초 실행 후 런타임 재기동 하시고,
# 2. 런타임 재기동 후 주석 처리하세요.

from google.colab import drive
drive.mount('/content/drive')

import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
import matplotlib as mpl

mpl.rcParams['axes.unicode_minus'] = False
mpl.rcParams['font.family'] = "NanumBarunGothic"

#%matplotlib inline
