class invalidA(Exception) :
    def __init__(self, a) :
        super().__init__('시작 지점이 문자열보다 큽니다.:{0}'.format(a))

class invalidB(Exception) :
    def __init__(self, b) :
        super().__init__('취할 문자의 갯수가 큽니다.:{0}'.format(b))

def midstr(s, a, b) :
    result = ""
    if a > len(s) :
        raise invalidA(a)
    elif b > len(s)-a+1 :
        raise invalidB(b)
    else :
        result = result + s[a-1:a+b-1]
    return result


s = input("대상 문자열 입력 : ")
a = int(input("시작 지점 입력 : "))
b = int(input("취할 갯수 입력 : "))

try :
    result = midstr(s, a, b)
except invalidA as err :
    print("예외가 발생했습니다. {0} 입니다.".format(err))
except invalidB as err :
    print("예외가 발생했습니다. {0} 입니다.".format(err))
else :
    print("결과 문자열은 {0} 입니다.".format(result))
