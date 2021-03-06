# -*- coding: utf-8 -*-
"""01. 파이썬 - 모듈.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1aezXngzYdWCwyUXICZUI-7nt0-mUVifa

# 모듈
관련 있는 형식이나 기능을 모아서 정의한 코드 집합

파이썬에서는 하나의 파이썬 파일(.py)로 정의

* 표준 모듈

  파이썬을 설치하면 기본적으로 사용 가능한 모듈

* 외부 모듈

  별도의 설치를 해야 사용 가능한 모듈

* 사용자 정의 모듈

  개발자(파이썬 사용자)가 직접 정의한 모듈

# 패키지

배포의 단위

파이썬에서는 파이썬 파일들을 포함하는 폴더

# 프레임워크

비슷한 형태의 프로그램의 기본 구조와 골격을 정의해 놓은 것

#진입점(Entry Point)

프로그램을 실행시켰을 때 시작하는 지점

name에는 진입점이 무엇인지 알 수 있다. ( __ name __ : __ main __ )
"""

import sys
# 전역변수에 path 추가 - corab에서 google drive 사용 위해서
sys.path.append('/content/drive/MyDrive/seSac/python/module')
sys.path

# 모듈 자체를 import
import dummy

dummy.print_n("hello", 3)
dummy.print_list([1,2,3])

"""# from 모듈이름 import *
모듈에 있는 모든 이름을 직접 사용할 수 있다.

하지만 다른 모듈에 같은 이름이 있을 때 모호할 수 있다.
"""

# 특정 모듈의 함수를 직접적으로 import
from dummy import print_n, print_list

print_n("yahoo", 3)
print_list([1,2,3])

from dummy import * # 모듈 내 모든 요소 이름을 직접 사용하겠다. 다른 모듈과 이름 충돌이 날 수 있다.

print_n("yahoo", 3)

import dummy as dm
dm.print_n("yahoo", 3)

if __name__ == "__main__": # 현재 파일의 main이 진입점일 때 수행하시오.
  print_n("hello", 3)
  print_list([1,2,3])

import dummy2 as d2

d2.dprint('hello', 3)