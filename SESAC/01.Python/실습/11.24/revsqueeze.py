# 2021-11-24 실습
# revsqueeze
# 주어진 리스트에서 또 다른 주어진 리스트를 제거하고 역순화시킨 리스트 출력

import sys

s = list(input("대상 문자열 입력 : "))
t = list(input("제거할 문자열 입력 : "))

if len(t) != 1 :
    print("제거할 문자열을 잘못 입력했습니다.")
    sys.exit(0)

#   1. result에 결과 새로 저장하는 방식

result = []

# for문
#for i in s :
#    if i != t[0] :
#        result.extend(i) # 1개씩 따오는 것이므로 append(i)로도 가능!


# while문
i = 0
while (i < len(s)) :
    if s[i] != t[0] :
        result.extend(s[i])
    i += 1

result.reverse()
print("결과 문자열은 {0} 입니다".format(result))


#   2. s 리스트를 바로 수정하는 방식 : count, remove 사용

#n = s.count(t[0])

#for i in range(0, n):
#    s.remove(t[0])

#s.reverse()

#print("결과 문자열은 {0} 입니다".format(s))
