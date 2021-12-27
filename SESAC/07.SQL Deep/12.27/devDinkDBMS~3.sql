/* 트랜잭션과 읽기 일관성 (2) */
/* 
    읽기 일관성
    트랜잭션의 고립성에 의해 변경이 진행중인 불안정한 상태의 데이터는 볼 수 없고,
    항상 안정적인 상태의 데이터를 조회하는 특성
*/

SELECT DEPTNO, SAL FROM EMP WHERE DEPTNO = 10; -- 2번, (1) 파일의 수정내용이 보이지 않음

SELECT DEPTNO, SAL FROM EMP WHERE DEPTNO = 10; -- 5번, (1) 파일 커밋 후 수정내용으로 보임


/* 트랜잭션과 Row Level Lock (2) */
/* 해당 트랜잭션이 DDL 수행 중일 때 다른 트랜잭션에서 수정하지 못하도록 ROW에 LOCK을 걸어서 보존 */

DELETE FROM EMP WHERE DEPTNO = 20; -- 2번
DELETE FROM EMP WHERE DEPTNO = 10; -- 3번

ROLLBACK; -- 6번