# -*- coding: utf-8 -*-
"""04.파이썬-자료형-변수와 기본 입력 input.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1PwENoxpBTJfFQ2OGLV2huCbNUfxe4SJM

# 변수
"""

# c 코드
# int korea = 90;
# int math = 85;
# int sum = korea + math;

korea = 90
math = 85
sum = korea + math
print("국어 : ", korea, ", 수학 : ", math, ", 합계 : ", sum)

"""#기본 입력 input"""

korea = input("국어 점수 :")
math = input("수학 점수 :")
print("국어:", korea, "수학:", math, "합계:", korea+math) # korea+math 를 문자열의 합으로 봄

print(type(korea), type(math))

# 변수를 형변환(casting)
korea = int(korea)
math = int(math)
print("국어:", korea, "수학:", math, "합계:", korea+math)

korea = int(input("국어 점수 :"))
math = int(input("수학 점수 :"))
print("국어:", korea, "수학:", math, "합계:", korea+math)

# float 형변환
fstr1 = "12.34"
fstr2 = "3.14"
f1 = float(fstr1)
f2 = float(fstr2)
print("f1 :", f1, ", f2 :", f2, ", f1 * f2 = ", f1*f2)

print("korea :", korea, ", type :", type(korea))
k_str = str(korea)
print("k_str :", k_str, ", type :", type(k_str))