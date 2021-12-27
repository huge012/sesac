/* 12.27 �ǽ����� */

/* INSERT - ���̺� ���ο� ��(Row, Record) ���� */

INSERT INTO DEPT VALUES(50,'������1','����'); -- �÷��� ������ ��ü�÷�������� ����
INSERT INTO DEPT(DEPTNO,DNAME,LOC) VALUES(51,'������2','����'); -- 2���� �� ����(�÷���� VALUE�� 1:1�� ����)
SELECT * FROM DEPT; -- �ű� ���� ������ ��ȸ
-- INSERT INTO DEPT VALUES('�ߺο�����','�뱸'); -- ERROR, ���̺�� ���µ� �� 2����
-- INSERT INTO DEPT(DNAME,LOC) VALUES('�ߺο�����','�뱸'); -- ���ǵ� ũ�⺸�� ���� ŭ
INSERT INTO DEPT(DNAME,LOC) VALUES('�ߺ�����','�뱸'); --DEPTNO ������, NULL��
INSERT INTO DEPT(DEPTNO,DNAME,LOC) VALUES(52, '�Ϻ�����',NULL);
-- ��������� NULL �־���, NULL or ''
INSERT INTO DEPT(DEPTNO,DNAME,LOC) VALUES(53, '��������','');
-- INSERT�� Ư�� COLUM�� NULL ���Թ�� (�Ͻ���)
INSERT INTO DEPT(DEPTNO,DNAME) VALUES(54,'��������'); -- ��� �÷� ����
SELECT DEPTNO,DNAME,NVL(LOC,'����������') AS LOC FROM DEPT; -- ��� ��ȸ
COMMIT; 


/* UPDATE - ���̺� ���� ����� ���� �÷�(��)(Column, Field) ���� */

UPDATE DEPT SET DNAME = ' M������' WHERE DEPTNO = 50; -- ���� �÷� ����
UPDATE DEPT SET DNAME = ' T������', LOC='��õ' WHERE DEPTNO = 51; -- ���� �÷� ����
SELECT * FROM DEPT WHERE DEPTNO IN (50,51); -- ���泻����ȸ
COMMIT; -- ������� �ݿ�(����
UPDATE DEPT SET LOC='�̰�ô��'; -- WHERE�� ������ ��ü ROW ���
SELECT * FROM DEPT;
ROLLBACK; -- �ش� ������� ������ ���
SELECT * FROM DEPT; -- ��� Ȯ��
select dname, replace(dname,' ','*') from dept; -- dname �÷��� ���鹮�� ����
update dept set dname=trim(dname); -- set ���� �Լ� ��밡��
select dname, replace(dname,' ','*') from dept;
commit;


/* DELETE - ���̺��� ����� ���� ��(Row, Record) ���� */
DELETE FROM DEPT WHERE LOC IS NULL or DEPTNO IS NULL;
SELECT * FROM DEPT;
commit;
DELETE DEPT; -- WHERE�� ������ ��ü ROW ����
-- FROM ���� ���� , Delete Syntax Diagram�� �о� Ȯ��
SELECT * FROM DEPT;
ROLLBACK; -- �ش� ������� ���
SELECT * FROM DEPT;


-- SINGLE LIGE COMMENT
/*
    SQL SCRIPT TEST
*/

SELECT *FROM TAB;
SELECT count(*) from EMP;

DESC SALGRADE

DELETE FROM DEPT WHERE DEPTNO IS NULL;
ROLLBACK;

select sys_context('userenv','sid') from dual;