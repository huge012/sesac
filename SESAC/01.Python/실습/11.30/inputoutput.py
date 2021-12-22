# 2021-11-30 실습
# 파일 입출력, 텍스트 파일 입출력, 파일 암호화 및 암호 해독

import os

inFp, outFp = None, None   # input 파일, output 파일 오픈
inStr, outStr = '', ''   # input, output 문자열
i = 0   # 인덱스
secu = 0   # 암호화, 해독 플래그

secuYN = input("1. 암호화 2. 암호해석 중 선택 : ")
inFname = input("입력 파일명 입력 : ")
outFname = input("출력 파일명 입력 : ")

# input 파일 존재하는지 확인
try :
    if not os.path.exists(inFname) :
        raise Exception('{0}은/는 미존재 파일'.format(inFname))

# 존재하지 않을 경우
except Exception as err :
    print('예외 발생 : {0}'.format(err))

# 존재할 경우
else :
    if secuYN == '1' :
        secu = 100
    elif secuYN == '2' :
        secu = -100

    inFp = open('C:/Users/user/Desktop/실습/11.30/'+inFname, 'r', encoding='utf-8')
    outFp = open('C:/Users/user/Desktop/실습/11.30/'+outFname, 'w', encoding='utf-8')

    while True :
        inStr = inFp.readline()   # input 파일에서 한 줄씩 읽어오기
        if not inStr :   # 파일 끝일 경우
            break
        outStr = ''   # output 파일에 입력할 문자열
        
        # 문자열 하나씩 암호화
        for i in range(len(inStr)) :
            outStr = outStr+chr(ord(inStr[i])+secu)
        outFp.write(outStr) # 문자열 output 파일에 입력

    inFp.close()
    outFp.close()
    print('%s --→ %s 변환 완료'%(inFname, outFname))
