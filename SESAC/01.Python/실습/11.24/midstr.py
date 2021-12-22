# 2021-11-24 실습
# midstr
# 주어진 문자열의 a번째에서부터 b개를 취하여 주는 프로그램을 짜시오

s = input("대상 문자열 입력")
a = int(input("시작 지점 입력"))
b = int(input("취할 갯수 입력"))

slen = len(s)

# 시작 지점이 0, 음수이거나 문자열보다 클 때
if a <= 0 or a > slen :
    print("잘못된 a값입니다.")

# 취할 문자 갯수가 0, 음수이거나 남은 문자열보다 클 때
elif b <= 0 or b > slen-a+1 :
    print("잘못된 b값입니다.")

# 결과 = 문자열[시작 지점 : 시작지점 + 취할 갯수]
else :
    result = s[a-1:a-1+b]
    print("결과 문자열은 {0} 입니다".format(result))
