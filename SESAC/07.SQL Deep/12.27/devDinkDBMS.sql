/* 12.27 실습내용 */

/* INSERT - 테이블에 새로운 행(Row, Record) 삽입 */

INSERT INTO DEPT VALUES(50,'연구소1','서울'); -- 컬럼명 생략시 전체컬럼대상으로 삽입
INSERT INTO DEPT(DEPTNO,DNAME,LOC) VALUES(51,'연구소2','대전'); -- 2번이 더 좋음(컬럼명과 VALUE를 1:1로 매핑)
SELECT * FROM DEPT; -- 신규 삽입 데이터 조회
-- INSERT INTO DEPT VALUES('중부영업점','대구'); -- ERROR, 테이블명 없는데 값 2개뿐
-- INSERT INTO DEPT(DNAME,LOC) VALUES('중부영업점','대구'); -- 정의된 크기보다 값이 큼
INSERT INTO DEPT(DNAME,LOC) VALUES('중부지점','대구'); --DEPTNO 생략됨, NULL들어감
INSERT INTO DEPT(DEPTNO,DNAME,LOC) VALUES(52, '북부지점',NULL);
-- 명시적으로 NULL 넣어줌, NULL or ''
INSERT INTO DEPT(DEPTNO,DNAME,LOC) VALUES(53, '남부지점','');
-- INSERT시 특정 COLUM에 NULL 삽입방법 (암시적)
INSERT INTO DEPT(DEPTNO,DNAME) VALUES(54,'서부지점'); -- 대상 컬럼 생략
SELECT DEPTNO,DNAME,NVL(LOC,'미지정지역') AS LOC FROM DEPT; -- 결과 조회
COMMIT; 


/* UPDATE - 테이블 내에 저장된 기존 컬럼(들)(Column, Field) 수정 */

UPDATE DEPT SET DNAME = ' M연구소' WHERE DEPTNO = 50; -- 단일 컬럼 변경
UPDATE DEPT SET DNAME = ' T연구소', LOC='인천' WHERE DEPTNO = 51; -- 복수 컬럼 변경
SELECT * FROM DEPT WHERE DEPTNO IN (50,51); -- 변경내역조회
COMMIT; -- 변경사항 반영(저장
UPDATE DEPT SET LOC='미개척지'; -- WHERE절 생략시 전체 ROW 대상
SELECT * FROM DEPT;
ROLLBACK; -- 해당 변경사항 영구히 취소
SELECT * FROM DEPT; -- 결과 확인
select dname, replace(dname,' ','*') from dept; -- dname 컬럼에 공백문자 저장
update dept set dname=trim(dname); -- set 절에 함수 사용가능
select dname, replace(dname,' ','*') from dept;
commit;


/* DELETE - 테이블내에 저장된 기존 행(Row, Record) 삭제 */
DELETE FROM DEPT WHERE LOC IS NULL or DEPTNO IS NULL;
SELECT * FROM DEPT;
commit;
DELETE DEPT; -- WHERE절 생략시 전체 ROW 삭제
-- FROM 생략 가능 , Delete Syntax Diagram을 읽어 확인
SELECT * FROM DEPT;
ROLLBACK; -- 해당 변경사항 취소
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