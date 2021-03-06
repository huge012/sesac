# -*- coding: utf-8 -*-
"""02.파이썬-자료형-숫자.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1IExbU27vBRLd5q3RWxsS1bLyMGCEIPco

#정수
"""

print(12, 0o12, 0x12) # 12 : 십진수, 0o12 : 8진수, 0x12 : 16진수

print(type(12), type(0o12), type(0x12)) # 각 진법 표현은 전부 int형

"""#실수"""

print(3.14, 1.234e6) # 3.14 : 부동소수점 표기, 1.234e6 : 지수 표현, 1.234 * 10^6

print(type(3.14), type(1.234e6)) # 두 표기법 모두 float형

"""#수와 관계있는 연산"""

print("8 + 3 = ", 8+3)
print("8 - 3 = ", 8-3)
print("8 * 3 = ", 8*3)
print("8 / 3 = ", 8/3)

print("8 // 5 = ", 8//5) # 몫
print("8 % 5 = ", 8%5) # 나머지

# 나머지 연산자는 로테이션 목적으로 자주 사용됨
i = 0
i = (i + 1) % 5
print(i)
i = (i + 1) % 5
print(i)
i = (i + 1) % 5
print(i)
i = (i + 1) % 5
print(i)
i = (i + 1) % 5
print(i)
i = (i + 1) % 5
print(i)
i = (i + 1) % 5
print(i)
i = (i + 1) % 5
print(i)
i = (i + 1) % 5
print(i)

"""#복소수"""

print(2+3j) # 허수 표현을 j로 함

cv = 2+3j
print("실수부 : ", cv.real, ", 허수부 : ", cv.imag)