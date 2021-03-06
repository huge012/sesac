# -*- coding: utf-8 -*-
"""01. 파이썬 - 클래스(캡슐화).ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1PBwBNjqY-BVN_0srf_FIBnMC8Gv8E-71

# 구조체 캡슐화

데이터를 멤버로 구성하는 캡슐화

절차식 언어에서 캡슐화하는 방법
"""

from dataclasses import dataclass

@dataclass
class Product:
  weight : int = None # (멤버 필드 이름) : (형식 이름) = (초기화값)
  price : int = None

pen = Product()
pen.weight = 100
pen.price = 1000
print("무게 : ", pen.weight, "가격 : ", pen.price)

"""# 클래스 캡슐화

멤버 데이터와 멤버 메서드를 캡슐화할 수 있다

OOP에서 캡슐화하는 방법
"""

class Student:
  def __init__(self, num, name): # 생성자, 객체가 만들어질 때 호출되는 함수
    # num, name, iq는 멤버 변수
    self.num = num # self : 객체 자신을 가리킴
    self.name = name
    self.iq = 0
    
  # 멤버 메서드
  def introduce(self):
    print(f"번호 : {self.num}, 이름 : {self.name}, 아이큐는 {self.iq}")
  def study(self):
    self.iq += 1
    print(f"{self.name} 공부합니다. 끄적끄적..")

s1 = Student(1, "홍길동")
s1.introduce()
s1.study()
s1.study()
s1.study()
s1.introduce()

"""# 정보 은닉

캡슐화 과정에서 특정 멤버의 가시성을 차단하는 방법 - 멤버 앞에 __ 붙이면 은폐(private)

사용하는 곳에서 직접 사용하지 못하며 형식 내부에서만 사용하게 하는 기법

데이터 신뢰성을 높이는 방법으로 사용한다.
"""

# 시나리오 S:
#   학생이 연속으로 5회 공부하면 아이큐가 1 올라간다.

class Student:
  def __init__(self, name):
    self.name = name
    self.__iq = 100
    self.__scnt = 0 # 연속으로 공부한 횟수
  def study(self):
    self.__scnt += 1
    if self.__scnt == 5:
      self.__iq += 1
      self.__scnt = 0
  def introduce(self):
    print(f"이름은 {self.name}, 아이큐는 {self.__iq}, scnt: {self.__scnt}")

s1 = Student("홍길동")
s1.introduce()
s1.study()
s1.study()
s1.study()
s1.study()
s1.study()
# print(s1.__iq) 정보 은닉한 멤버에 접근할 수 없다.
s1.__iq = 10293
s1.introduce()

"""## 특별한 멤버 - 생성자, 소멸자

객체를 생성할 때 생성자(__ init __)을 호출한다.

객체가 소멸할 때 소멸자(__ del __)을 호출한다.

해당 객체를 소멸하는 것은 가비지 수집기가 알아서 수행한다. (C와 C++에서는 개발자가 직접 소멸시켜야 하는 부담이 있다.)
"""

# 시나리오 s:
#     학생이 연속으로 5회 공부하면 아이큐가 1 올라간다.

class Student:
  def __init__(self): # 객체 생성될 때 실행되는 함수
    print("__init__")
  def __del__(self): # 객체 삭제될 때 실행되는 함수
    print("__del__")

print("===1===")
s1 = Student()
print("===2===")
s2 = Student()
print("===3===")
exit(0)

"""## 데이터 신뢰성을 높이는 멤버 - 설정자, 접근자

멤버 필드의 가시성을 차단하고 필요하면 설정자와 접근자를 제공하자.

설정자(setter) - 멤버 필드에 값을 설정하는 메서드, set_멤버필드명

접근자(getter) - 멤버 필드에 값을 확인하는 메서드, get_멤버필드명
"""

class Student:
  def __init__(self, name, num): # 생성자 메서드
    self.__name = name
    self.__num = num
    self.__kor = 0
    self.__eng = 0
    self.__math = 0
  def get_name(self):
    return self.__name
  def get_num(self):
    return self.__num
  def set_kor(self, score):
    self.__kor = score
  def get_kor(self):
    return self.__kor
  def set_eng(self, score):
    self.__eng = score
  def get_eng(self):
    return self.__eng
  def set_math(self, score):
    self.__math = score
  def get_math(self):
    return self.__math
  def tostr(self):
    return f"이름:{self.__name}, 번호:{self.__num}, 국어:{self.__kor}, 영어:{self.__eng}, 수학:{self.__math}"

s1 = Student("홍길동", 3)
print(s1.tostr())
s1.set_kor(90)
s1.set_eng(100)
s1.set_math(89)
print(s1.tostr())