

/* DBMS �׽�Ʈ */

SELECT *FROM TAB;
SELECT COUNT(*) FROM EMP_LARGE;
SELECT COUNT(*) FROM BONUS_LARGE;
SELECT COUNT(*) FROM CUSTOMER;


/* SELECT LIST - ���ϴ� �κ� ��� �̾Ƴ��� */

select * from emp;
select empno, ename, job, mgr, hiredate, sal, comm, deptno from emp;
select empno, ename, job, sal from emp; /* �� ���� ��� �� �� ���� */
select sal, job, empno, ename from emp; /* column ���� ��� ���� */
select empno, empno, empno, ename, job, sal from emp; /* ���� column �ߺ���밡�� */
select empno, sal, 8, 'ORACLE' from emp; /* ���� ������, ���� ������ �÷� ���� ��ȸ ���� */


/* Alias - ��Ī �޾��ֱ� */

select ename, sal, sal*12, comm, comm+300 from emp;
select sal, sal+300*12, (sal+300)*12 from emp;
select ename, sal+200 bonus, sal*12 as annual_SAL, comm, comm+300 "Special Bonus" from emp;
select ename, comm+300 as "Special Bonus" from emp;
select ename, comm+300 ���ʽ� from emp;


/* ���ڿ� �ռ� ������ - ���ڿ� �ռ��ϱ� */

SELECT ENAME||JOB FROM EMP;
SELECT DNAME||' �μ��� '||LOC||' ������ ��ġ�մϴ�.' as LOC FROM DEPT;
SELECT ENAME, SAL, SAL*100, SAL||'00', to_char(SAL)||'00' FROM EMP;


/* DUAL - ���� ���̺� */

Desc dual
SELECT * FROM dual;
SELECT sysdate FROM dual;
SELECT 143475*127363 as ��������, to_char(143475*127363, '999,999,999,999') as �ĸ� FROM dual;


/* WHERE - ���� �޾��ֱ�, ���ϴ� ROW(���ڵ�)�� ��ȸ */

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


/* ORDER BY - ����, ASC(default) �������� / DESC �������� */

SELECT * from emp order by comm desc;
SELECT DEPTNO,ENAME,SAL,HIREDATE FROM EMP ORDER BY ENAME; 
SELECT DEPTNO,ENAME,SAL,HIREDATE FROM EMP ORDER BY SAL;
SELECT DEPTNO,ENAME,SAL,HIREDATE FROM EMP ORDER BY SAL ASC;
SELECT DEPTNO,ENAME,SAL,HIREDATE FROM EMP ORDER BY SAL DESC; 
SELECT DEPTNO,JOB,ENAME FROM EMP ORDER BY DEPTNO;
SELECT DEPTNO,JOB,ENAME FROM EMP ORDER BY DEPTNO;
SELECT DEPTNO,JOB,ENAME FROM EMP ORDER BY DEPTNO,JOB; 
SELECT DEPTNO,JOB,ENAME FROM EMP ORDER BY DEPTNO,JOB desc;


/* DISTINCT - �ߺ� ���͸� */

SELECT JOB FROM EMP;
SELECT DISTINCT JOB FROM EMP;
SELECT DISTINCT DEPTNO, JOB FROM EMP; 
SELECT DISTINCT DEPTNO, JOB FROM EMP ORDER BY DEPTNO;


/* FUNCTION - �Լ�, ������ �Լ� / �׷��� �Լ� */

SELECT ENAME,LENGTH(ENAME),UPPER(ENAME),LOWER(ENAME) FROM EMP;
SELECT COUNT(*),COUNT(SAL),SUM(SAL),AVG(SAL),MIN(SAL),MAX(SAL) FROM EMP;


/* GROUP BY - ���� �÷����� �����͸� �׷��� */

SELECT DEPTNO,COUNT(*) FROM SCOTT.EMP GROUP BY DEPTNO;
SELECT DEPTNO, AVG(SAL) ,SUM(SAL) FROM EMP GROUP BY DEPTNO;
SELECT DEPTNO,AVG(SAL) ,SUM(SAL) FROM EMP
GROUP BY DEPTNO
ORDER BY DEPTNO;

SELECT DEPTNO,ROUND(AVG(SAL),1) ,SUM(SAL) FROM EMP 
GROUP BY DEPTNO
ORDER BY DEPTNO;

/* ���� */
SELECT DEPTNO, MAX(SAL), MIN(SAL) FROM EMP
GROUP BY DEPTNO
ORDER BY DEPTNO;


/* HAVING - GROUP BY ��� �����Ϳ� ���� ���� */

SELECT DEPTNO,ROUND(AVG(SAL),1) ,SUM(SAL) FROM 
EMP 
GROUP BY DEPTNO
HAVING SUM(SAL) >= 9000
ORDER BY DEPTNO DESC;


/* NULL - ����Ұ�, �񱳺Ұ�, ����Ұ�, NULL ���� �Լ� */

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

/*����*/
SELECT COMM FROM EMP;
SELECT count(COMM), round(avg(COMM)) FROM EMP WHERE COMM > 0; /* 0 ���� */
SELECT count(decode(COMM, 0, null, COMM)), avg(decode(COMM, 0, null, COMM)) FROM EMP; /* decode�� 0�� null�� �ٲ� */
SELECT decode(COMM, null, 0, COMM) + 300 FROM EMP; /* null�� 0���� �ٲ㼭 300 ���ϱ� */


/* DESC EMP - NOT NULL üũ ����, NOT NULL ���ڵ带 ���� ��� �� COUNT ���� */
SELECT COUNT(*), COUNT(EMPNO), COUNT(MGR) FROM EMP; 
SELECT MGR FROM EMP;
DESC EMP;

/* �׷��� �Լ� ���� NULL�� ������ */
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


SELECT ROWNUM,ENAME,DEPTNO,SAL FROM EMP; /* ROWNUM�� �������� ���� X, ��ȸ�� ������� ������ �ű� */
SELECT ROWNUM, ENAME, DEPTNO, SAL FROM EMP ORDER BY DEPTNO, SAL;
SELECT ROWNUM,ENAME,DEPTNO,SAL FROM EMP WHERE DEPTNO IN (10,20) ORDER BY DEPTNO,SAL; /* ROWNUM ���� �� ORDER BY ����,  */

SELECT ROWNUM, ENAME,DEPTNO,SAL FROM EMP;
SELECT ENAME,DEPTNO,SAL FROM EMP WHERE ROWNUM = 1;
SELECT ENAME,DEPTNO,SAL FROM EMP WHERE ROWNUM = 5; /* ������ 1���� ���;���, �߰����� ��ȸ �Ұ� */
SELECT ENAME,DEPTNO,SAL FROM EMP WHERE ROWNUM > 5;
SELECT ENAME,DEPTNO,SAL FROM EMP WHERE ROWNUM <= 5;
SELECT ENAME,DEPTNO,SAL FROM EMP WHERE ROWNUM < 5;

/* SubQuery�� �������� �ֻ��� �޿��� 5���� ��ȸ�ϴ� SQL���� �ۼ��Ͻÿ� */
SELECT ROWNUM, ENAME, DEPTNO, SAL
FROM (
    SELECT ENAME, DEPTNO, SAL
    FROM EMP
    ORDER BY SAL DESC
    )
WHERE ROWNUM <= 5;


/* �������� AND OR NOT */

SELECT ENAME,JOB,SAL,DEPTNO FROM EMP WHERE DEPTNO = 10 AND SAL > 2000; -- DEPTNO 10 �̰� SAL>2000
SELECT ENAME,JOB,SAL,DEPTNO FROM EMP WHERE DEPTNO = 10 OR SAL > 2000; -- DEPTNO 10 �Ǵ� SAL>2000
SELECT ENAME,JOB,SAL,DEPTNO FROM EMP WHERE SAL > 2000 OR SAL > 2000; -- ���� ���� �ΰ�
SELECT ENAME,JOB,SAL,DEPTNO FROM EMP 
WHERE DEPTNO = 10 AND SAL > 2000 OR JOB = 'CLERK'; -- (DEPTNO 10 �̰� SAL > 2000) �Ǵ� JOB = 'CLERK' 
SELECT ENAME,JOB,SAL,DEPTNO FROM EMP
WHERE (DEPTNO = 10 AND SAL > 2000) OR JOB = 'CLERK'; 
SELECT ENAME,JOB,SAL,DEPTNO FROM EMP 
WHERE DEPTNO = 10 AND (SAL > 2000 OR JOB = 'CLERK'); -- DEPTNO 10�̰� (SAL>2000�̰ų� JOB='CLERK')
SELECT EMPNO,ENAME, JOB,SAL,DEPTNO FROM EMP WHERE DEPTNO = 10 AND SAL > 2000;
SELECT ENAME,JOB,SAL FROM EMP WHERE SAL > 2000; 
SELECT ENAME,JOB,SAL FROM EMP WHERE JOB != 'CLERK'; -- job�� cleak�� �ƴ� �����
SELECT ENAME,JOB,SAL FROM EMP WHERE JOB NOT IN('CLERK','MANAGER'); -- JOB�� CLEAK�� MANAGER�� �ƴ� �����
SELECT ENAME,JOB,SAL FROM EMP WHERE SAL > 2000 OR JOB = 'CLERK'; 
SELECT ENAME,JOB,SAL FROM EMP WHERE SAL > 2000 AND JOB = 'CLERK';
SELECT ENAME,JOB,SAL FROM EMP WHERE SAL > 2000 OR SAL > 2000; 
SELECT ENAME,JOB,SAL, DEPTNO FROM EMP WHERE SAL > 2000 or JOB = 'CLERK' and DEPTNO >= 20; -- (SAL > 2000 �̰ų� JOB CLERK�� ���) �� DEPTNO 20�� ���
SELECT ENAME,JOB,SAL FROM EMP WHERE SAL > 2000 or ( JOB = 'CLERK' and DEPTNO >= 20 );
SELECT ENAME,JOB,SAL FROM EMP WHERE ( SAL > 2000 or JOB = 'CLERK') and DEPTNO >= 20;


/* BETWEEN ������ */

SELECT EMPNO,ENAME,SAL FROM EMP WHERE SAL between 1000 and 2000; -- ����,���� 1000 < SAL < 2000
SELECT EMPNO,ENAME,SAL FROM EMP WHERE SAL >= 1000 and SAL <= 2000; -- ������?
SELECT EMPNO,ENAME,HIREDATE,SAL FROM EMP WHERE SAL between 2000 and 1000; -- ������?

SELECT EMPNO,ENAME,HIREDATE,SAL FROM EMP WHERE ENAME between 'C' and 'K'; -- ���� 
SELECT EMPNO,HIREDATE,SAL FROM EMP WHERE HIREDATE between '81/02/20' and '82/12/09'; -- �Ͻ��� ������ Ÿ�� ����
SELECT ENAME,HIREDATE FROM EMP
WHERE HIREDATE between to_date('1981/02/20','yy/mm/dd') and to_date('1982/12/09','yy/mm/dd'); -- ����� ������ Ÿ�� ����, ������ 4�ڸ��� �Է�
SELECT ENAME,HIREDATE FROM EMP;

/* IN - ����Ʈ �ȿ� �ִ� �����Ϳ� �� */

SELECT EMPNO,ENAME,JOB FROM EMP WHERE EMPNO in (7369,7521,7654); -- ����
SELECT EMPNO,ENAME,JOB FROM EMP WHERE EMPNO = 7369 or EMPNO = 7521 or EMPNO=7654;
SELECT EMPNO,ENAME,JOB FROM EMP WHERE JOB in ('clerk','manager'); -- ���� ��ҹ��� ��������� ��
SELECT EMPNO,ENAME,JOB FROM EMP WHERE JOB in ('CLERK','MANAGER');
SELECT EMPNO,ENAME,HIREDATE FROM EMP WHERE HIREDATE in ('81/05/01','81/02/20'); -- ��¥
SELECT EMPNO,ENAME,JOB,DEPTNO FROM EMP 
WHERE (JOB,DEPTNO) in (('MANAGER',20),('CLERK',20));


/* LIKE - ���� ���� ��Ī ������, ��Ȯ�� ���� ���� ã�� �� ����
  % : 0�� �̻��� ��� ����
  _ : 1���� ��� ���� */

SELECT ENAME FROM EMP WHERE ENAME like 'A%'; -- pattern matching
SELECT ENAME FROM EMP WHERE ENAME like '_A%'; 
SELECT ENAME FROM EMP WHERE ENAME like '%L%E%';
SELECT ENAME FROM EMP WHERE ENAME like '%LE%';
SELECT ENAME FROM EMP WHERE ENAME like '%A%';
SELECT ENAME FROM EMP WHERE ENAME NOT like '%A%';

SELECT ENAME,HIREDATE FROM EMP WHERE HIREDATE like '81%'; --? ��¥
-- SELECT ENAME,SAL FROM EMP WHERE SAL like 2%; -- ? ���ڴ� �� ��, ���� Ÿ���� ���ڸ� ��
SELECT ENAME,SAL FROM EMP WHERE SAL like '2%'; -- ? ���� like ����


/* �Լ� */

/* single row function */
SELECT ENAME,EMPNO,SAL,COMM FROM EMP; -- 14��
SELECT ENAME,LOWER(ENAME),UPPER(LOWER(ENAME)),LENGTH(ENAME), -- 14��
ABS(SAL-EMPNO),COMM 
FROM EMP;
SELECT ENAME,substr(ENAME,1,3) FROM EMP
WHERE HIREDATE between to_date('1981/01/01','yyyy/mm/dd') and to_date('1982/12/31','yyyy/mm/dd')
ORDER BY LENGTH(ENAME);


/* group row function */
SELECT AVG(SAL),SUM(SAL),SUM(COMM),COUNT(*) FROM EMP; -- 1��
SELECT DEPTNO,COUNT(*),SUM(SAL),AVG(SAL) FROM EMP -- GROUPING
GROUP BY DEPTNO;
SELECT DEPTNO,JOB,COUNT(*),SUM(SAL),AVG(SAL) FROM EMP
GROUP BY DEPTNO,JOB
ORDER BY DEPTNO;


/* ������ �Լ� - ���� �Լ� */
SELECT ENAME, lower(ENAME) ,upper(ENAME), initcap(ENAME) FROM EMP;
SELECT ENAME, substr(ENAME,1,3), substr(ENAME,4), substr(ENAME,-3,2) FROM EMP;
SELECT ENAME, instr(ENAME,'A'), instr(ENAME,'A',2), instr(ENAME,'A',1,2) FROM EMP; --������ġ
SELECT ENAME, rpad(ENAME,10,'*'), lpad(ENAME,10,'+') FROM EMP;
SELECT ENAME,REPLACE(ENAME,'S','s') FROM EMP;
SELECT ENAME, concat(ENAME,JOB), ENAME||JOB FROM EMP;
SELECT ltrim(' ���ѹα� '), rtrim(' ���ѹα� '), trim(' ���ѹα� ') FROM dual;
SELECT length('abcd'), substr('abcd',2,2), length('���ѹα�'), substr('���ѹα�',2,2) FROM dual;
SELECT lengthB('abcd'), substrb('abcd',2,2), lengthb('���ѹα�'), substrb('���ѹα�',3,3) FROM dual;
SELECT length('abcd'), vsize('abcd'), length('���ѹα�'), vsize('���ѹα�') FROM dual; -- vsize() : ����Ʈ ũ�⸦ ��ȯ


/* ������ �Լ� - ���� �Լ� */
SELECT round(45.923,2), round(45.923,1), round(45.923,0), round(45.923), round(45.923,-1) FROM dual; -- round(����, �Ҽ����ڸ� �ݿø�)
SELECT trunc(45.923,2), trunc(45.923,1), trunc(45.923,0), trunc(45.923), trunc(45.923,-1) FROM dual; -- trunc(����, �Ҽ����ڸ� ����)
SELECT mod(100,3), mod(100,2) FROM dual; -- ������
SELECT ENAME,SAL,SAL*0.053 as tax,round(SAL*0.053,0) as r_tax FROM EMP; --�޿���5.3%����,������
SELECT CEIL(-45.594),CEIL(-45.294),CEIL(45.294),
ROUND(-45.594),ROUND(-45.294),ROUND(45.594) FROM DUAL; -- ���밪����
SELECT FLOOR(45.245),FLOOR(-45.245),FLOOR(45.545),FLOOR(-45.545) FROM DUAL;


/* ������ �Լ� - DATE type �Լ� : ��¥�� ���� ���� */
SELECT sysdate,sysdate+7, sysdate-2, sysdate+1/24 FROM dual; -- sysdate+7 : ������ ��, sysdate-2 : 2�� ��, sysdate+1/24 (�Ϸ��� 1/24, 1�ð�)
SELECT deptno,ename, trunc(sysdate-hiredate) as work_day FROM emp ORDER BY deptno,work_day DESC; --DATE�� ��¥�� �ð� ������ ������ �ִ�.
SELECT ename,sysdate,hiredate FROM emp; -- �� ��¥�� ���̰� �ð��� ������ �ʴ°�? : ���� ������ �߸��Ǿ� ����
SELECT ename,to_char(sysdate,'YYYY-MM-DD:HH24:MI:SS'),to_char(hiredate,'YYYY-MM-DD:HH24:MI:SS')
FROM emp;
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD:HH24:MI:SS';
SELECT ename,sysdate,hiredate FROM emp; 
SELECT SYSDATE FROM DUAL;


/* ������ �Լ� - ��¥ �Լ� : ���ó�¥ ���� ��� */
SELECT HIREDATE,months_between(sysdate,HIREDATE),months_between(HIREDATE,sysdate) FROM EMP;
SELECT HIREDATE,trunc(months_between(sysdate,HIREDATE)),trunc(months_between(HIREDATE,sysdate)) FROM EMP;
-- ��� ���� ó��: trunc(months_between(sysdate,HIREDATE))
SELECT sysdate, add_months(sysdate,3), add_months(sysdate,-1) FROM dual;
SELECT sysdate, last_day(sysdate), next_day(sysdate,'�Ͽ���'), next_day(sysdate,2) FROM dual; -- 1 �Ͽ��� 2 ������ ... 7 �����
SELECT sysdate,round(sysdate,'YEAR'),round(sysdate,'MONTH'),round(sysdate,'DAY'),round(sysdate) --round(sysdate,'DAY')
FROM dual;
-- 06��30����/�� , 15����/�� ,������ ��/�� , ���� = �� �ǹ̸� �����ϰ� �ִ�.
-- 11��59�� �϶��� ���� 12:00�� ���ϡ�
SELECT sysdate,trunc(sysdate,'YEAR'),trunc(sysdate,'MONTH'),trunc(sysdate,'DAY'),trunc(sysdate)
FROM dual;
SELECT to_char(sysdate,'MM"��"DD"�ϡ� ') as mmdd1, to_char(sysdate,'MM')||'��'||to_char(sysdate,'DD')||'��' as mmdd2 FROM dual;
SELECT 
EXTRACT(YEAR FROM SYSDATE), EXTRACT(MONTH FROM SYSDATE),EXTRACT(DAY FROM SYSDATE)
FROM DUAL; -- ������ �̱�


/* ������ �Լ� - ��ȯ �Լ� : �����/�Ͻ��� */
SELECT SYSDATE, TO_CHAR(SYSDATE,'YEAR'),TO_CHAR(SYSDATE,'Year'),
TO_CHAR(SYSDATE,'YYYY'),TO_CHAR(SYSDATE,'YY') FROM DUAL;
SELECT TO_CHAR(SYSDATE,'MONTH'),TO_CHAR(SYSDATE,'MON'), -- MONTH:9��, MON:3��
TO_CHAR(SYSDATE,'Mon'),TO_CHAR(SYSDATE,'mon'),
TO_CHAR(SYSDATE,'MM'),TO_CHAR(SYSDATE,'mm') FROM DUAL;
SELECT SYSDATE,
TO_CHAR(SYSDATE,'DAY'), TO_CHAR(SYSDATE,'Day'),TO_CHAR(SYSDATE,'DY'), TO_CHAR(SYSDATE,'dy'), 
TO_CHAR(SYSDATE,'DD'),TO_CHAR(SYSDATE,'dd') FROM DUAL; -- DY:day(����), dd:��¥(��)
SELECT 123456, TO_CHAR(123456,'999999'), LENGTH(TO_CHAR(123456,'999999')),
LENGTH(TO_CHAR(123456,'fm999999')) -- fm: remove padded blanks('-'��ȣ�� ���� �����ڸ� ������)
FROM DUAL;
SELECT TO_CHAR(12345*123.45,'999,999.99'),TO_CHAR(12345*123.45,'99,999,999.99') FROM DUAL; -- ��� ���ں��� ������ ª�Ƽ� #���� ����
-- ��κ� �ڸ��� ������ ����
SELECT TO_CHAR(SAL,'$999,999'), REPLACE(TO_CHAR(SAL,'$999,999'),' ','?'),
TO_CHAR(SAL,'L999,999'), TO_CHAR(SAL,'999,999L'), TO_CHAR(SAL,'fm999,999L') -- L : ������ȭ����
FROM EMP; -- replace : ������ ?�� ġȯ, L�� ��ȣ

desc emp; -- �� ������ ������ �� �ִ� ���� ����(������ ����)

/* �׷��� �Լ� : null�� �����ϰ� ���� */
SELECT MIN(ENAME),MAX(ENAME),MIN(SAL),MAX(SAL),MIN(HIREDATE),MAX(HIREDATE) FROM EMP;
-- ENAME:����, SAL:����,HIREDATE:��¥, min, max �Լ��� ����/����/��¥ ������ ���� ��� ����, ������ �Լ� �����ε�
SELECT COUNT(*),COUNT(EMPNO),COUNT(MGR),COUNT(COMM) FROM EMP;
-- count(comm) : null �����ϰ� ���� ī��Ʈ
SELECT COUNT(JOB),COUNT(ALL JOB),COUNT(DISTINCT JOB),SUM(SAL),SUM(DISTINCT SAL)
FROM EMP;
-- count(distinct job) -> distinct ���� ����, job ���� ���� count
SELECT COUNT(*), SUM(COMM), SUM(COMM)/COUNT(*),AVG(COMM),SUM(COMM)/COUNT(COMM) 
FROM EMP;
-- sum(comm)/count()-Ŀ�̼� 0�� ������� ����, agv(comm) ��� Ŀ�̼�, sum(comm)/count(comm) -> avr()�Լ��� ����
select avg(decode(comm, 0, null, comm)) from emp; -- Ŀ�̼� 0�� ����� null�� ġȯ�� �� ��� ���
select avg(comm) from emp where comm > 0; -- where�� ���� �ɾ ���

-- �׷����Լ� �� NULL �׸��� NVL , ȿ������ ������� ?
SELECT SAL,COMM FROM EMP;
SELECT
    SUM(NVL(COMM,0)) AS SUM_COMM1, -- null�� 0���� ġȯ�ؼ� ����, group�� �Լ��� null ������ null�� ������� �����Ƿ� nvl ����� �ʿ� X, ��ȿ����
    SUM(COMM) AS SUM_COMM2, -- comm ���� (null skip)
    NVL(SUM(COMM),0) AS SUM_COMM3  -- comm ���ؼ�(null skip) null�� 0���� ġȯ, NVL 1�� �����, ȿ���� ũ�� �������� ������ ���ʿ��� �κ�
FROM EMP;
