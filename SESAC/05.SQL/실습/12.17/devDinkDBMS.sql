

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