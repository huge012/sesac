# 2021-11-26 실습
# decorate
# 기존 문자열 비교 함수 strcmp(s,t)를 데코레이트해 문자열의 공백을 무시하고 비교하는 함수만들기

func = strcmp
deco(strcmp) -> stricmp(

def deco(func) :
    def stricmp(*args, **kwargs) :
        a = args[0].replace(" ", "")
        b = args[1].replace(" ", "")
        return (func(a,b))
    return stricmp

@deco
def strcmp(s, t) :
    for i in range(min(len(s), len(t))) :
        if ord(s[i]) > ord(t[i]) :
            return 1
        elif ord(s[i]) < ord(t[i]) :
            return -1

    if len(s) > len(t) :
        return 1
    elif len(s) < len(t) :
        return -1
    else :
        return 0

s = input("첫번째 문자열 입력 : ")
t = input("두번째 문자열 입력 : ")

print(strcmp(s, t))


#def deco(func) :
#    def stricmp(*args, **kwargs) :
#        newargs = []
#        for s in args :
#            newargs.append(s.replace(" ", ""))
#        return func(*newargs, **kwargs)
#    return stricmp
