

/* DBMS 테스트 */

SELECT *FROM TAB;
SELECT COUNT(*) FROM EMP_LARGE;
SELECT COUNT(*) FROM BONUS_LARGE;
SELECT COUNT(*) FROM CUSTOMER;


/* SELECT LIST - 원하는 부분 골라서 뽑아내기 */

select * from emp;
select empno, ename, job, mgr, hiredate, sal, comm, deptno from emp;
select empno, ename, job, sal from emp; /* 몇 개만 골라서 볼 수 있음 */
select sal, job, empno, ename from emp; /* column 순서 상관 없음 */
select empno, empno, empno, ename, job, sal from emp; /* 같은 column 중복사용가능 */
select empno, sal, 8, 'ORACLE' from emp; /* 숫자 데이터, 문자 데이터 컬럼 만들어서 조회 가능 */


/* Alias - 별칭 달아주기 */

select ename, sal, sal*12, comm, comm+300 from emp;
select sal, sal+300*12, (sal+300)*12 from emp;
select ename, sal+200 bonus, sal*12 as annual_SAL, comm, comm+300 "Special Bonus" from emp;
select ename, comm+300 as "Special Bonus" from emp;
select ename, comm+300 보너스 from emp;


/* 문자열 합성 연산자 - 문자열 합성하기 */

SELECT ENAME||JOB FROM EMP;
SELECT DNAME||' 부서는 '||LOC||' 지역에 위치합니다.' as LOC FROM DEPT;
SELECT ENAME, SAL, SAL*100, SAL||'00', to_char(SAL)||'00' FROM EMP;


/* DUAL - 더미 테이블 */

Desc dual
SELECT * FROM dual;
SELECT sysdate FROM dual;
SELECT 143475*127363 as 원래숫자, to_char(143475*127363, '999,999,999,999') as 컴마 FROM dual;


/* WHERE - 조건 달아주기, 원하는 ROW(레코드)만 조회 */

SELECT * FROM EMP WHERE DEPTNO = 10;
SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE SAL > 2000;
SELECT SAL,EMPNO,ENAME FROM EMP, SALGRADE WHERE DEPTNO = 10 AND SAL > 2000;
SELECT DEPTNO,SAL,EMPNO,ENAME FROM EMP WHERE DEPTNO = 10;
SELECT DEPTNO,SAL,EMPNO,ENAME FROM EMP WHERE SAL > 2000;
SELECT DEPTNO,SAL,EMPNO,ENAME FROM EMP WHERE DEPTNO = 10 AND SAL > 2000;
SELECT DEPTNO,SAL,EMPNO,ENAME FROM EMP WHERE DEPTNO = 10 OR SAL > 2000;
SELECT DEPTNO,ENAME,JOB FROM EMP WHERE JOB = 'MANAGER';
SELECT DEPTNO,ENAME,JOB FROM EMP WHERE 1=1;
SELECT DEPTNO,ENAME,JOB FROM EMP WHERE 1=2;


/* ORDER BY - 정렬, ASC(default) 오름차순 / DESC 내림차순 */

SELECT * from emp order by comm desc;
SELECT DEPTNO,ENAME,SAL,HIREDATE FROM EMP ORDER BY ENAME; 
SELECT DEPTNO,ENAME,SAL,HIREDATE FROM EMP ORDER BY SAL;
SELECT DEPTNO,ENAME,SAL,HIREDATE FROM EMP ORDER BY SAL ASC;
SELECT DEPTNO,ENAME,SAL,HIREDATE FROM EMP ORDER BY SAL DESC; 
SELECT DEPTNO,JOB,ENAME FROM EMP ORDER BY DEPTNO;
SELECT DEPTNO,JOB,ENAME FROM EMP ORDER BY DEPTNO;
SELECT DEPTNO,JOB,ENAME FROM EMP ORDER BY DEPTNO,JOB; 
SELECT DEPTNO,JOB,ENAME FROM EMP ORDER BY DEPTNO,JOB desc;


/* DISTINCT - 중복 필터링 */

SELECT JOB FROM EMP;
SELECT DISTINCT JOB FROM EMP;
SELECT DISTINCT DEPTNO, JOB FROM EMP; 
SELECT DISTINCT DEPTNO, JOB FROM EMP ORDER BY DEPTNO;


/* FUNCTION - 함수, 단일행 함수 / 그룹행 함수 */

SELECT ENAME,LENGTH(ENAME),UPPER(ENAME),LOWER(ENAME) FROM EMP;
SELECT COUNT(*),COUNT(SAL),SUM(SAL),AVG(SAL),MIN(SAL),MAX(SAL) FROM EMP;


/* GROUP BY - 기준 컬럼으로 데이터를 그룹핑 */

SELECT DEPTNO,COUNT(*) FROM SCOTT.EMP GROUP BY DEPTNO;
SELECT DEPTNO, AVG(SAL) ,SUM(SAL) FROM EMP GROUP BY DEPTNO;
SELECT DEPTNO,AVG(SAL) ,SUM(SAL) FROM EMP
GROUP BY DEPTNO
ORDER BY DEPTNO;

SELECT DEPTNO,ROUND(AVG(SAL),1) ,SUM(SAL) FROM EMP 
GROUP BY DEPTNO
ORDER BY DEPTNO;

/* 과제 */
SELECT DEPTNO, MAX(SAL), MIN(SAL) FROM EMP
GROUP BY DEPTNO
ORDER BY DEPTNO;


/* HAVING - GROUP BY 결과 데이터에 대한 조건 */

SELECT DEPTNO,ROUND(AVG(SAL),1) ,SUM(SAL) FROM 
EMP 
GROUP BY DEPTNO
HAVING SUM(SAL) >= 9000
ORDER BY DEPTNO DESC;


/* NULL - 연산불가, 비교불가, 적용불가, NULL 제어 함수 */

SELECT 300+400, 300+NULL, 300/NULL FROM dual;
SELECT ENAME,SAL,COMM,COMM + SAL*0.3 as bonus FROM EMP; 

SELECT ENAME,SAL,COMM FROM EMP WHERE SAL > 1000;
SELECT ENAME,SAL,COMM FROM EMP WHERE COMM > -1;
SELECT ENAME,SAL,COMM FROM EMP WHERE COMM = null; 
SELECT ENAME,SAL,COMM FROM EMP WHERE COMM is null;
SELECT ENAME,SAL,COMM FROM EMP WHERE COMM is not null;

SELECT ENAME,length(ENAME),COMM,length(COMM) FROM EMP;

SELECT nvl(COMM,-1), decode(COMM,null,-999,COMM) FROM EMP;

SELECT count(COMM) FROM EMP;
SELECT decode(COMM, null, -1, COMM) FROM EMP WHERE COMM >= 0;

/*과제*/
SELECT COMM FROM EMP;
SELECT count(COMM), round(avg(COMM)) FROM EMP WHERE COMM > 0; /* 0 빼기 */
SELECT count(decode(COMM, 0, null, COMM)), avg(decode(COMM, 0, null, COMM)) FROM EMP; /* decode로 0을 null로 바꿈 */
SELECT decode(COMM, null, 0, COMM) + 300 FROM EMP; /* null을 0으로 바꿔서 300 더하기 */


/* DESC EMP - NOT NULL 체크 가능, NOT NULL 레코드를 세면 모든 수 COUNT 가능 */
SELECT COUNT(*), COUNT(EMPNO), COUNT(MGR) FROM EMP; 
SELECT MGR FROM EMP;
DESC EMP;

/* 그룹행 함수 들어가면 NULL을 무시함 */
SELECT DEPTNO, EMPNO, NVL(COMM, 0)
FROM EMP
WHERE DEPTNO = 10
ORDER BY DEPTNO DESC;


/* DECODE */

SELECT DEPTNO,ENAME,SAL,
DECODE(DEPTNO,10,0.1,20,0.2,30,0.3,0.5) * SAL AS BONUS 
FROM EMP ORDER BY DEPTNO;
SELECT DEPTNO, DECODE(DEPTNO,10,0.1,20,0.2,30,0.3,0.5) AS BONUS FROM EMP;

SELECT DEPTNO,ENAME,SAL,
    CASE    WHEN SAL >= 5000 THEN 'HIGH'
            WHEN SAL >= 2500 THEN 'MID'
            WHEN SAL < 2500 THEN 'LOW'
            ELSE
                'UNKNOWN'
    END
FROM EMP
ORDER BY DEPTNO;


/* 12/24 */
/* ROWNUM */


SELECT ROWNUM,ENAME,DEPTNO,SAL FROM EMP; /* ROWNUM은 절대적인 숫자 X, 조회된 순서대로 순번을 매김 */
SELECT ROWNUM, ENAME, DEPTNO, SAL FROM EMP ORDER BY DEPTNO, SAL;
SELECT ROWNUM,ENAME,DEPTNO,SAL FROM EMP WHERE DEPTNO IN (10,20) ORDER BY DEPTNO,SAL; /* ROWNUM 실행 후 ORDER BY 실행,  */

SELECT ROWNUM, ENAME,DEPTNO,SAL FROM EMP;
SELECT ENAME,DEPTNO,SAL FROM EMP WHERE ROWNUM = 1;
SELECT ENAME,DEPTNO,SAL FROM EMP WHERE ROWNUM = 5; /* 무조건 1부터 나와야함, 중간부터 조회 불가 */
SELECT ENAME,DEPTNO,SAL FROM EMP WHERE ROWNUM > 5;
SELECT ENAME,DEPTNO,SAL FROM EMP WHERE ROWNUM <= 5;
SELECT ENAME,DEPTNO,SAL FROM EMP WHERE ROWNUM < 5;

/* SubQuery를 공부한후 최상위 급여자 5명을 조회하는 SQL문을 작성하시요 */
SELECT ROWNUM, ENAME, DEPTNO, SAL
FROM (
    SELECT ENAME, DEPTNO, SAL
    FROM EMP
    ORDER BY SAL DESC
    )
WHERE ROWNUM <= 5;


/* 논리연산자 AND OR NOT */

SELECT ENAME,JOB,SAL,DEPTNO FROM EMP WHERE DEPTNO = 10 AND SAL > 2000; -- DEPTNO 10 이고 SAL>2000
SELECT ENAME,JOB,SAL,DEPTNO FROM EMP WHERE DEPTNO = 10 OR SAL > 2000; -- DEPTNO 10 또는 SAL>2000
SELECT ENAME,JOB,SAL,DEPTNO FROM EMP WHERE SAL > 2000 OR SAL > 2000; -- 같은 조건 두개
SELECT ENAME,JOB,SAL,DEPTNO FROM EMP 
WHERE DEPTNO = 10 AND SAL > 2000 OR JOB = 'CLERK'; -- (DEPTNO 10 이고 SAL > 2000) 또는 JOB = 'CLERK' 
SELECT ENAME,JOB,SAL,DEPTNO FROM EMP
WHERE (DEPTNO = 10 AND SAL > 2000) OR JOB = 'CLERK'; 
SELECT ENAME,JOB,SAL,DEPTNO FROM EMP 
WHERE DEPTNO = 10 AND (SAL > 2000 OR JOB = 'CLERK'); -- DEPTNO 10이고 (SAL>2000이거나 JOB='CLERK')
SELECT EMPNO,ENAME, JOB,SAL,DEPTNO FROM EMP WHERE DEPTNO = 10 AND SAL > 2000;
SELECT ENAME,JOB,SAL FROM EMP WHERE SAL > 2000; 
SELECT ENAME,JOB,SAL FROM EMP WHERE JOB != 'CLERK'; -- job이 cleak가 아닌 사람들
SELECT ENAME,JOB,SAL FROM EMP WHERE JOB NOT IN('CLERK','MANAGER'); -- JOB이 CLEAK도 MANAGER도 아닌 사람들
SELECT ENAME,JOB,SAL FROM EMP WHERE SAL > 2000 OR JOB = 'CLERK'; 
SELECT ENAME,JOB,SAL FROM EMP WHERE SAL > 2000 AND JOB = 'CLERK';
SELECT ENAME,JOB,SAL FROM EMP WHERE SAL > 2000 OR SAL > 2000; 
SELECT ENAME,JOB,SAL, DEPTNO FROM EMP WHERE SAL > 2000 or JOB = 'CLERK' and DEPTNO >= 20; -- (SAL > 2000 이거나 JOB CLERK인 사람) 중 DEPTNO 20인 사람
SELECT ENAME,JOB,SAL FROM EMP WHERE SAL > 2000 or ( JOB = 'CLERK' and DEPTNO >= 20 );
SELECT ENAME,JOB,SAL FROM EMP WHERE ( SAL > 2000 or JOB = 'CLERK') and DEPTNO >= 20;


/* BETWEEN 연산자 */

SELECT EMPNO,ENAME,SAL FROM EMP WHERE SAL between 1000 and 2000; -- 숫자,범위 1000 < SAL < 2000
SELECT EMPNO,ENAME,SAL FROM EMP WHERE SAL >= 1000 and SAL <= 2000; -- 차이점?
SELECT EMPNO,ENAME,HIREDATE,SAL FROM EMP WHERE SAL between 2000 and 1000; -- 이유는?

SELECT EMPNO,ENAME,HIREDATE,SAL FROM EMP WHERE ENAME between 'C' and 'K'; -- 문자 
SELECT EMPNO,HIREDATE,SAL FROM EMP WHERE HIREDATE between '81/02/20' and '82/12/09'; -- 암시적 데이터 타입 지정
SELECT ENAME,HIREDATE FROM EMP
WHERE HIREDATE between to_date('1981/02/20','yy/mm/dd') and to_date('1982/12/09','yy/mm/dd'); -- 명시적 데이터 타입 지정, 연도는 4자리로 입력
SELECT ENAME,HIREDATE FROM EMP;

/* IN - 리스트 안에 있는 데이터와 비교 */

SELECT EMPNO,ENAME,JOB FROM EMP WHERE EMPNO in (7369,7521,7654); -- 숫자
SELECT EMPNO,ENAME,JOB FROM EMP WHERE EMPNO = 7369 or EMPNO = 7521 or EMPNO=7654;
SELECT EMPNO,ENAME,JOB FROM EMP WHERE JOB in ('clerk','manager'); -- 문자 대소문자 구분해줘야 함
SELECT EMPNO,ENAME,JOB FROM EMP WHERE JOB in ('CLERK','MANAGER');
SELECT EMPNO,ENAME,HIREDATE FROM EMP WHERE HIREDATE in ('81/05/01','81/02/20'); -- 날짜
SELECT EMPNO,ENAME,JOB,DEPTNO FROM EMP 
WHERE (JOB,DEPTNO) in (('MANAGER',20),('CLERK',20));


/* LIKE - 문자 패턴 매칭 연산자, 정확한 값을 몰라도 찾을 수 있음
  % : 0개 이상의 모든 문자
  _ : 1개의 모든 문자 */

SELECT ENAME FROM EMP WHERE ENAME like 'A%'; -- pattern matching
SELECT ENAME FROM EMP WHERE ENAME like '_A%'; 
SELECT ENAME FROM EMP WHERE ENAME like '%L%E%';
SELECT ENAME FROM EMP WHERE ENAME like '%LE%';
SELECT ENAME FROM EMP WHERE ENAME like '%A%';
SELECT ENAME FROM EMP WHERE ENAME NOT like '%A%';

SELECT ENAME,HIREDATE FROM EMP WHERE HIREDATE like '81%'; --? 날짜
-- SELECT ENAME,SAL FROM EMP WHERE SAL like 2%; -- ? 숫자는 안 됨, 문자 타입의 숫자만 됨
SELECT ENAME,SAL FROM EMP WHERE SAL like '2%'; -- ? 숫자 like 문자


/* 함수 */

/* single row function */
SELECT ENAME,EMPNO,SAL,COMM FROM EMP; -- 14건
SELECT ENAME,LOWER(ENAME),UPPER(LOWER(ENAME)),LENGTH(ENAME), -- 14건
ABS(SAL-EMPNO),COMM 
FROM EMP;
SELECT ENAME,substr(ENAME,1,3) FROM EMP
WHERE HIREDATE between to_date('1981/01/01','yyyy/mm/dd') and to_date('1982/12/31','yyyy/mm/dd')
ORDER BY LENGTH(ENAME);


/* group row function */
SELECT AVG(SAL),SUM(SAL),SUM(COMM),COUNT(*) FROM EMP; -- 1건
SELECT DEPTNO,COUNT(*),SUM(SAL),AVG(SAL) FROM EMP -- GROUPING
GROUP BY DEPTNO;
SELECT DEPTNO,JOB,COUNT(*),SUM(SAL),AVG(SAL) FROM EMP
GROUP BY DEPTNO,JOB
ORDER BY DEPTNO;


/* 단일행 함수 - 문자 함수 */
SELECT ENAME, lower(ENAME) ,upper(ENAME), initcap(ENAME) FROM EMP;
SELECT ENAME, substr(ENAME,1,3), substr(ENAME,4), substr(ENAME,-3,2) FROM EMP;
SELECT ENAME, instr(ENAME,'A'), instr(ENAME,'A',2), instr(ENAME,'A',1,2) FROM EMP; --문자위치
SELECT ENAME, rpad(ENAME,10,'*'), lpad(ENAME,10,'+') FROM EMP;
SELECT ENAME,REPLACE(ENAME,'S','s') FROM EMP;
SELECT ENAME, concat(ENAME,JOB), ENAME||JOB FROM EMP;
SELECT ltrim(' 대한민국 '), rtrim(' 대한민국 '), trim(' 대한민국 ') FROM dual;
SELECT length('abcd'), substr('abcd',2,2), length('대한민국'), substr('대한민국',2,2) FROM dual;
SELECT lengthB('abcd'), substrb('abcd',2,2), lengthb('대한민국'), substrb('대한민국',3,3) FROM dual;
SELECT length('abcd'), vsize('abcd'), length('대한민국'), vsize('대한민국') FROM dual; -- vsize() : 바이트 크기를 반환


/* 단일행 함수 - 숫자 함수 */
SELECT round(45.923,2), round(45.923,1), round(45.923,0), round(45.923), round(45.923,-1) FROM dual; -- round(숫자, 소숫점자리 반올림)
SELECT trunc(45.923,2), trunc(45.923,1), trunc(45.923,0), trunc(45.923), trunc(45.923,-1) FROM dual; -- trunc(숫자, 소숫점자리 버림)
SELECT mod(100,3), mod(100,2) FROM dual; -- 나머지
SELECT ENAME,SAL,SAL*0.053 as tax,round(SAL*0.053,0) as r_tax FROM EMP; --급여의5.3%세금,원단위
SELECT CEIL(-45.594),CEIL(-45.294),CEIL(45.294),
ROUND(-45.594),ROUND(-45.294),ROUND(45.594) FROM DUAL; -- 절대값연산
SELECT FLOOR(45.245),FLOOR(-45.245),FLOOR(45.545),FLOOR(-45.545) FROM DUAL;


/* 단일행 함수 - DATE type 함수 : 날짜는 연산 가능 */
SELECT sysdate,sysdate+7, sysdate-2, sysdate+1/24 FROM dual; -- sysdate+7 : 일주일 뒤, sysdate-2 : 2일 전, sysdate+1/24 (하루의 1/24, 1시간)
SELECT deptno,ename, trunc(sysdate-hiredate) as work_day FROM emp ORDER BY deptno,work_day DESC; --DATE는 날짜와 시간 정보를 가지고 있다.
SELECT ename,sysdate,hiredate FROM emp; -- 왜 날짜만 보이고 시간은 보이지 않는가? : 포맷 설정이 잘못되어 있음
SELECT ename,to_char(sysdate,'YYYY-MM-DD:HH24:MI:SS'),to_char(hiredate,'YYYY-MM-DD:HH24:MI:SS')
FROM emp;
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD:HH24:MI:SS';
SELECT ename,sysdate,hiredate FROM emp; 
SELECT SYSDATE FROM DUAL;


/* 단일행 함수 - 날짜 함수 : 오늘날짜 기준 계산 */
SELECT HIREDATE,months_between(sysdate,HIREDATE),months_between(HIREDATE,sysdate) FROM EMP;
SELECT HIREDATE,trunc(months_between(sysdate,HIREDATE)),trunc(months_between(HIREDATE,sysdate)) FROM EMP;
-- 찌꺼기 일자 처리: trunc(months_between(sysdate,HIREDATE))
SELECT sysdate, add_months(sysdate,3), add_months(sysdate,-1) FROM dual;
SELECT sysdate, last_day(sysdate), next_day(sysdate,'일요일'), next_day(sysdate,2) FROM dual; -- 1 일요일 2 월요일 ... 7 토요일
SELECT sysdate,round(sysdate,'YEAR'),round(sysdate,'MONTH'),round(sysdate,'DAY'),round(sysdate) --round(sysdate,'DAY')
FROM dual;
-- 06월30일전/후 , 15일전/후 ,수요일 전/후 , 전은 = 의 의미를 포함하고 있다.
-- 11시59분 일때는 오늘 12:00은 내일…
SELECT sysdate,trunc(sysdate,'YEAR'),trunc(sysdate,'MONTH'),trunc(sysdate,'DAY'),trunc(sysdate)
FROM dual;
SELECT to_char(sysdate,'MM"월"DD"일“ ') as mmdd1, to_char(sysdate,'MM')||'월'||to_char(sysdate,'DD')||'일' as mmdd2 FROM dual;
SELECT 
EXTRACT(YEAR FROM SYSDATE), EXTRACT(MONTH FROM SYSDATE),EXTRACT(DAY FROM SYSDATE)
FROM DUAL; -- 연월일 뽑기


/* 단일행 함수 - 변환 함수 : 명시적/암시적 */
SELECT SYSDATE, TO_CHAR(SYSDATE,'YEAR'),TO_CHAR(SYSDATE,'Year'),
TO_CHAR(SYSDATE,'YYYY'),TO_CHAR(SYSDATE,'YY') FROM DUAL;
SELECT TO_CHAR(SYSDATE,'MONTH'),TO_CHAR(SYSDATE,'MON'), -- MONTH:9자, MON:3자
TO_CHAR(SYSDATE,'Mon'),TO_CHAR(SYSDATE,'mon'),
TO_CHAR(SYSDATE,'MM'),TO_CHAR(SYSDATE,'mm') FROM DUAL;
SELECT SYSDATE,
TO_CHAR(SYSDATE,'DAY'), TO_CHAR(SYSDATE,'Day'),TO_CHAR(SYSDATE,'DY'), TO_CHAR(SYSDATE,'dy'), 
TO_CHAR(SYSDATE,'DD'),TO_CHAR(SYSDATE,'dd') FROM DUAL; -- DY:day(요일), dd:날짜(일)
SELECT 123456, TO_CHAR(123456,'999999'), LENGTH(TO_CHAR(123456,'999999')),
LENGTH(TO_CHAR(123456,'fm999999')) -- fm: remove padded blanks('-'부호를 위한 공백자리 없애줌)
FROM DUAL;
SELECT TO_CHAR(12345*123.45,'999,999.99'),TO_CHAR(12345*123.45,'99,999,999.99') FROM DUAL; -- 대상 숫자보다 포맷이 짧아서 #으로 보임
-- 대부분 자릿수 제한을 해줌
SELECT TO_CHAR(SAL,'$999,999'), REPLACE(TO_CHAR(SAL,'$999,999'),' ','?'),
TO_CHAR(SAL,'L999,999'), TO_CHAR(SAL,'999,999L'), TO_CHAR(SAL,'fm999,999L') -- L : 지역통화단위
FROM EMP; -- replace : 공백을 ?로 치환, L은 부호

desc emp; -- 각 값마다 저장할 수 있는 범위 지정(데이터 통제)

/* 그룹행 함수 : null은 무시하고 진행 */
SELECT MIN(ENAME),MAX(ENAME),MIN(SAL),MAX(SAL),MIN(HIREDATE),MAX(HIREDATE) FROM EMP;
-- ENAME:문자, SAL:숫자,HIREDATE:날짜, min, max 함수는 문자/숫자/날짜 데이터 전부 사용 가능, 연산자 함수 오버로딩
SELECT COUNT(*),COUNT(EMPNO),COUNT(MGR),COUNT(COMM) FROM EMP;
-- count(comm) : null 무시하고 갯수 카운트
SELECT COUNT(JOB),COUNT(ALL JOB),COUNT(DISTINCT JOB),SUM(SAL),SUM(DISTINCT SAL)
FROM EMP;
-- count(distinct job) -> distinct 먼저 연산, job 종류 갯수 count
SELECT COUNT(*), SUM(COMM), SUM(COMM)/COUNT(*),AVG(COMM),SUM(COMM)/COUNT(COMM) 
FROM EMP;
-- sum(comm)/count()-커미션 0인 사원까지 포함, agv(comm) 평균 커미션, sum(comm)/count(comm) -> avr()함수와 동일
select avg(decode(comm, 0, null, comm)) from emp; -- 커미션 0인 사람을 null로 치환한 후 평균 계산
select avg(comm) from emp where comm > 0; -- where로 조건 걸어서 계산

-- 그룹행함수 와 NULL 그리고 NVL , 효율적인 계산방안은 ?
SELECT SAL,COMM FROM EMP;
SELECT
    SUM(NVL(COMM,0)) AS SUM_COMM1, -- null을 0으로 치환해서 더함, group행 함수에 null 있으면 null이 실행되지 않으므로 nvl 사용할 필요 X, 비효율적
    SUM(COMM) AS SUM_COMM2, -- comm 더함 (null skip)
    NVL(SUM(COMM),0) AS SUM_COMM3  -- comm 더해서(null skip) null을 0으로 치환, NVL 1번 실행됨, 효율성 크게 떨어지진 않으나 불필요한 부분
FROM EMP;
