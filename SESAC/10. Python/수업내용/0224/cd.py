# 시나리오 s:
#     학생이 연속으로 5회 공부하면 아이큐가 1 올라간다.

class Student:
  def __init__(self):
    print("__init__")
  def __del__(self):
    print("__del__")

print("===1===")
s1 = Student()
print("===2===")
s2 = Student()
print("===3===")