# 실습한 주어진 문자열(s) 에서 a 번째에서 b 개릏 취하여 주는 코드를
# midstr(s, a, b) 함수로 바꾼 후에
# invalid parameter a 와 b를 예외 처리로 구현 하시오.

class invalidA(Exception):
    def __init__(self, a):
        super().__init__('잘못된 시작 지점 입력로 인해 예외가 발생했습니다.')

class invalidB(Exception):
    def __init__(self, b):
        super().__init__('잘못된 취할 개수 입력로 인해 예외가 발생했습니다.')


def midstr(s, a, b):
    result = ""
    if a > len(s):
        raise invalidA(a)
    elif b > len(s) - a + 1:
        raise invalidB(b)
    else:
        result = result + s[a - 1:a + b - 1]
    return result

s = input("대상 문자열 입력: ")
a = int(input("시작 지점 입력: "))
b = int(input("취할 갯수 입력: "))


try:
    result = midstr(s, a, b)
except invalidA as err:
    print("잘못된 시작 지점 입력로 인해 예외가 발생했습니다.".format(err))
except invalidB as err:
    print("잘못된 취할 개수 입력로 인해 예외가 발생했습니다.".format(err))
else:
    print("결과 문자열은 {0}입니다.".format(result))
