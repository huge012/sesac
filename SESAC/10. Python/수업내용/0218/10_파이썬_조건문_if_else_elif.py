# -*- coding: utf-8 -*-
"""파이썬 조건문 - if else elif.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1QMu90PoFNiqStYQ6KbbdPBCBqBSh5a4f

# if else
if 조건:

....조건이 참일 때 수행할 구문

else:

....조건이 거짓일 때 수행할 구문
"""

num = int(input("정수:"))
if num%2==0:
  print("짝수")
else:
  print("홀수")
print("...")

"""# if elif else
if 조건1:

....조건1이 참일 때 수행할 구문

elif 조건2:

....조건2가 참일 때 수행할 구문

.

.

.

else:

....모든 조건이 거짓일 때 수행할 구문
"""

score = int(input("국어 점수:"))
if score>=90:
  print("A")
elif score>=80:
  print("B")
elif score>=70:
  print("C")
elif score>=60:
  print("D")
else:
  print("F")
print("...")