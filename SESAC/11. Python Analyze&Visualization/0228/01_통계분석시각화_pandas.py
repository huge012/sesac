# -*- coding: utf-8 -*-
"""01. 통계분석시각화 - pandas.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1CXaRI6-zvvm8vYGhtxQS1qh8l1XDxDKi

# Series

numpy 데이터 프레임은 matrix로 구성

각 행렬의 한 줄을 편하게 읽기 위해 Series 사용

실제로 많이 사용되는 자료구조는 아님
"""

import pandas as pd

"""s = pd.Series(seq_data)"""

s = pd.Series([1, 2, 3, 4, 5])
print(s)

print(s.index) # 인덱스 정보

print(s.values) # 값 정보

s = pd.Series(["홍길동", "강감찬", "을지문덕"])
print(s)
print(s.index)
print(s.values)

subjects = ['국어', '영어', '수학']
# 원하는 인덱스 주고싶을 때, 시퀀스 값을 묶어서 넘겨주고 지정된 인덱스 값을 키워드로 넘겨주기
s = pd.Series([90, 85, 39], index=subjects)
print(s)

"""결측치를 무엇으로 표현할 것인가?
- np.nan
- None
- 0
- 기타 값
"""

import numpy as np

# 데이터 없을 때의 표현법
s1 = pd.Series([np.nan, 10, 30])
s2 = pd.Series([None, 10, 30])
s3 = pd.Series([0, 10, 30])
s4 = pd.Series([-1, 10, 30])

print(s1)  # Nan으로 들어감
print('----------------')
print(s2)  # Nan으로 들어감
print('----------------')
print(s3)  # 0으로 들어감
print('----------------')
print(s4)  # -1로 들어감

print(np.nan == np.nan)  # nan끼리는 같지 않음, 비교 자체가 안 됨
print(None == None)  # None과 None은 같다고 취급
print(np.nan is np.nan)
print(None is None)

a = [1, 2, 3]
b = [1, 2, 3]
c = a
print(a == b)  # 값을 비교
print(a is b)  # 참조를 비교
print(a == c)  # 값을 비교
print(a is c)  # 참조를 비교
print(b == c)  # 값을 비교
print(b is c)  # 참조를 비교

"""##날짜 시퀀스"""

s = pd.date_range(start='2019-01-01', end='2022-02-28')
print(s)

s = pd.date_range(start='2019/01/01', end='2022.02.28')
print(s)

s = pd.date_range(start='2019/01/01', end='2022.02.28', freq='2D') # 2일 주기
print(s)

s = pd.date_range(start='2019/01/01', end='2022.02.28', freq='2B') # 2달 주기
print(s)

s = pd.date_range(start='2019/01/01', end='2022.02.28', freq='2W') # 2주 주기
print(s)

"""#DataFrame

df = pd.DataFrame(data)

data는 maxrix 형태
"""

df = pd.DataFrame([["홍길동", 90, 80, 70], ["강감찬", 80, 78, 90]])
print(df)

print(df.index)  # 인덱스, 0부터 2까지 순차적으로 증가 (0, 1)

print(df.columns)  # 컬럼, 0부터 4까지 순차적으로 증가 (0, 1, 2, 3)

print(df.values)  # 가지고 있는 값

# 인덱스명, 컬럼명 지정하기
nums = [1, 2]
cnames = ["이름", "국어", "수학", "영어"]
df = pd.DataFrame([["홍길동", 90, 80, 70], ["강감찬", 80, 78, 90]], index = nums, columns = cnames)
print(df)

# 딕셔너리 형태로 테이블 데이터 입력 가능, 컬럼명 자동 지정됨
table_data = {"연도":[np.nan, 2020, 2021],
              "매출":[100, None, 120]}
df = pd.DataFrame(table_data)
print(df)

print(df.info())

print(df.describe())

"""##Series 데이터 연산"""

s1 = pd.Series([1, 2, 3, 4, 5])
s2 = pd.Series([7, 8, 9, 10, 11])
s3 = s1 + s2 # 같은 줄 같은 열의 값을 더해줌
print(s1)
print(s2)
print(s3)

s1 = pd.Series([1, 2, 3, 4, 5])
s2 = pd.Series([7, 8, 9, 10])
s3 = s1 + s2  # 인덱스가 안 맞을 경우 결과값엔 NaN 들어감
print(s1)
print(s2)
print(s3)

# 연산 More

s1 = pd.Series([1, 2, 3, 4], index=['a', 'b', 'c', 'd'])
s2 = pd.Series([2, 3, 7, 8], index=['a', 'c', 'd', 'e'])
s3 = s1 + s2
print(s3)

"""#DataFrame 데이터 연산"""

data1 = {"홍길동": [90, 85, 70],
        "강감찬": [90, 80, 65],
        "이순신": [100, 100, 100]}
df1 = pd.DataFrame(data1)

data2 = {"홍길동": [100, 75, 80],
        "강감찬": [90, 85, 75],
        "을지문덕": [95, 100, 95]}
df2 = pd.DataFrame(data2)

df3 = df1 + df2

print(df1)
print(df2)
print(df3)

df3.describe()

print(df3.mean())
print('-------------------')
print(df3.mean(axis=1))

df3.var()

"""df.head([n]) 앞쪽 데이터를 확인 (디폴트 n = 5)
df.tail([n]) enl쪽 데이터를 확인 (디폴트 n = 5)
"""

df = pd.read_csv('/content/drive/MyDrive/seSac/python/iris.csv')
print(df)

df.head(10) # 위에서부터 n개, default = 5

df.tail(3) # 아래에서부터 n개, default = 5

df[50:55]  # row = 레코드 개념, 하나의 row = 하나의 데이터

df.loc[50:55]

print(df['petal.length'][0])
#print(df[0]['petal.length'])

print(df.loc[0]['petal.length'])

df.T  # 전치행렬

"""#데이터 통합하기"""

data = {"국어":[100, 38, 45, 90],
       "영어":[90, 80, 75, 80]}
df = pd.DataFrame(data)
print(df)

data2 = {"국어":[75, 80],
       "영어":[65, 70]}
df2 = pd.DataFrame(data2)
print(df2)

rdf = df.append(df2) # df에 df2를 합친 새로운 데이터프레임을 반환한다. 원본은 바뀌지 않는다.
print(df)
print(rdf)

rdf = df.append(df2, ignore_index = True)  # 합치는 데이터프레임들의 인덱스를 무시한다
print(rdf)

data3 = {"국어":[75, 80]}
df3 = pd.DataFrame(data3)
print(df3)

rdf = df.append(df3)
print(rdf)

print(df)

data4 = {"수학":[90, 85, np.nan, 88]}
df4 = pd.DataFrame(data4)
print(df4)

rdf = df.join(df4)
print(rdf)

"""#결측치 표현"""

value = np.nan
print(value)

value2 = None
print(value2)

se1 = pd.Series(['홍길동', '강감찬', np.nan, '을지문덕'])
se1.isnull()  # 결측치 여부 확인

se1[0] = np.nan
print(se1)

se1[1] = None
print(se1)

se1.isnull()

# 전처리 과정에서 결측 데이터 제외하기
se2 = se1.dropna()
print(se2)

se1.notnull()

se3 = se1[se1.notnull()]
print(se3)

df1 = pd.DataFrame([[1, np.nan, 3, 4], [np.nan, np.nan, np.nan, np.nan], [3, 4, 1, 1]])
print(df1)

#하나라도 결측치일 때, 해당 Row(index)를 삭제
df2 = df1.dropna()
print(df2)

# 모든 컬럼이 결측치일 때 해당 Row(index)를 삭제하시오.
df3 = df1.dropna(how = 'all')
print(df3)

df1.iloc[1][0] = 2
df4 = df1.dropna(axis = 1)  # 결측치 없는 행을 추출
print(df1)
print(df4)

df5 = df1.fillna(0) # 결측치를 원하는 값으로 변동
print(df5)