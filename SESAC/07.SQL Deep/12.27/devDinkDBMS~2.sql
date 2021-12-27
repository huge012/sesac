/* 트랜잭션과 읽기 일관성 (1) */
/* 
    읽기 일관성
    트랜잭션의 고립성에 의해 변경이 진행중인 불안정한 상태의 데이터는 볼 수 없고,
    항상 안정적인 상태의 데이터를 조회하는 특성
*/

UPDATE EMP SET SAL = 0 WHERE DEPTNO = 10; -- 1번

SELECT DEPTNO, SAL FROM EMP WHERE DEPTNO = 10; -- 3번, 커밋 전부터 본인의 수정한 내용이 보임

COMMIT; -- 4번

SELECT DEPTNO, SAL FROM EMP WHERE DEPTNO = 10; -- 6번, 커밋 후에도 수정한 뒤의 내용이 보임


/* 트랜잭션과 Row Level Lock (1) */
/* 해당 트랜잭션이 DDL 수행 중일 때 다른 트랜잭션에서 수정하지 못하도록 ROW에 LOCK을 걸어서 보존 */

UPDATE EMP SET SAL = 9999 WHERE DEPTNO = 10; -- 1번
SELECT DEPTNO, SAL FROM EMP WHERE DEPTNO = 10;

COMMIT; -- 4번