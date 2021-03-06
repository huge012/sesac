# -*- coding: utf-8 -*-
"""01.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1yV6PvX6ny4LSFmk8PhYIDCSmVwXg0cD6
"""

#!sudo apt-get install -y fonts-nanum # !:호스트 명령어 실행, sudo:super user 명령어, apt-get:우분투 명령어
#!sudo fc-cache -fv # 폰트 캐시 재생성 -강제생성 및 로그띄어줌
#!rm ~/.cache/matplotlib -rf # matplotlib 캐시메모리 정보 삭제
# 1. 최초 실행 후 런타임 재기동 하시고,
# 2. 런타임 재기동 후 주석처리 하세요.

# Commented out IPython magic to ensure Python compatibility.
# %run my_init_kor.py
# %run my_init.py
# %matplotlib inline

"""## 데이터 준비하기"""

# 도미 데이터
bream_length = [25.4, 26.3, 26.5, 29.0, 29.0, 29.7, 29.7, 30.0, 30.0, 30.7, 31.0, 31.0, 
                31.5, 32.0, 32.0, 32.0, 33.0, 33.0, 33.5, 33.5, 34.0, 34.0, 34.5, 35.0, 
                35.0, 35.0, 35.0, 36.0, 36.0, 37.0, 38.5, 38.5, 39.5, 41.0, 41.0]
bream_weight = [242.0, 290.0, 340.0, 363.0, 430.0, 450.0, 500.0, 390.0, 450.0, 500.0, 475.0, 500.0, 
                500.0, 340.0, 600.0, 600.0, 700.0, 700.0, 610.0, 650.0, 575.0, 685.0, 620.0, 680.0, 
                700.0, 725.0, 720.0, 714.0, 850.0, 1000.0, 920.0, 955.0, 925.0, 975.0, 950.0]

# 빙어 데이터
smelt_length = [9.8, 10.5, 10.6, 11.0, 11.2, 11.3, 11.8, 11.8, 12.0, 12.2, 12.4, 13.0, 14.3, 15.0]
smelt_weight = [6.7, 7.5, 7.0, 9.7, 9.8, 8.7, 10.0, 9.9, 9.8, 12.2, 13.4, 12.2, 19.7, 19.9]

# 생선 데이터
length = bream_length + smelt_length
weight = bream_weight + smelt_weight

# 리스트 내포
fish_data = [ (l, w) for l, w in zip(length, weight) ]

# 정답 준비(target, label), 양성 클래스 : 1, 음성 클래스 : 0
fish_target = [1]*len(bream_length) + [0]*len(smelt_length)
print(len(fish_data)), print(len(fish_target))

"""## 훈련하기"""

from sklearn.neighbors import KNeighborsClassifier

kn = KNeighborsClassifier() # k=5

kn.fit(fish_data, fish_target)

kn.effective_metric_

kn._fit_X

kn._fit_X.shape

dir(kn)

x, y = 2, 3
x + y

_

for _ in range(5):
  print('Hello')

class MyClass(object):
  def __init__(self):
    pass
  def test_method(self):
    pass

my_obj = MyClass()
my_obj.test_method()

1000000

1_000_000

attrs = dir(kn)

import re

p = re.compile('_[a-z]+')
for attr in attrs:
  if p.match(attr):
    print(attr)

kn3 = KNeighborsClassifier(n_neighbors=3)
kn3.fit(fish_data, fish_target)

kn49 = KNeighborsClassifier(n_neighbors=49)
kn49.fit(fish_data, fish_target)

"""## 평가하기"""

kn.predict([[30, 500], [25, 100], [29, 50], [32, 70]]) # 리스트를 넣으면 numpy로 자동 형변환시켜줌

kn.score(fish_data, fish_target) # 정확도 계산, 실제 학습내용에 대해 학습 내용을 평가하면 당연히 전부 맞음

kn3.score(fish_data, fish_target)

kn49.score(fish_data, fish_target)

35/49

from sklearn.metrics import accuracy_score

accuracy_score(fish_target, kn.predict(fish_data))  # y_true:target, y_pred:predict() 예측값을 가지고 실제 값과 비교해줌
# score()의 경우, 함수 내에서 재학습함, score() 하기 전 fit()할 경우 학습을 이중으로 하게 됨

"""## 연습"""

kn = KNeighborsClassifier()
kn.fit(fish_data, fish_target)

for n in range(5, 50):
  # k-최근접 이웃 개수 설정
  kn.n_neighbors = n
  # 점수 계산
  score = kn.score(fish_data, fish_target)
  # 100% 정확도에 미치지 못하는 이웃 개수 출력
  if score < 1:
    print(n, score)
    break

from sklearn.neighbors import KNeighborsClassifier

clsifier = KNeighborsClassifier()
clsifier.fit(fish_data, fish_target)

for n in range(5, 50):
  clsifier.n_neighbors = n
  score = clsifier.score(fish_data, fish_target)
  if score < 1 :
    print(f"n: {n} => {score}")
    break