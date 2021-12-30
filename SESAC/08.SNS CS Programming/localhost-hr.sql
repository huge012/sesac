/* 12.30 실습 */

/* 테이블 생성 - commit 안해도 생성됨 */
create table t_test(
    id varchar2(30) primary key, -- unique + not null, 유일해야 하며 비어있으면 안 됨
    name varchar2(100) not null
);

/* drop - 삭제, drop table - 테이블 삭제 */
drop table t_test;

select * from tab;
desc employees;
desc t_test;
select * from t_test;

select * from employees;

/* 행 삽입 */
-- insert into 테이블(컬럼, 컬럼) values(내용, 내용);
insert into t_test(id, name)
values('hong', '홍길동');

select * from t_test;
commit;

update t_test set name = '홍개똥' where id = 'hong';
rollback;

select * from employees;

select employee_id, first_name, e.department_id, department_name
from employees e, departments d
where e.department_id = d.department_id;

select department_name as job_title, salary
from employees e, departments d
where e.department_id = d.department_id and salary >= 10000;

select job_title, round(avg(salary)) as avg_sal
from (
    select department_name as job_title, salary
    from employees e, departments d
    where e.department_id = d.department_id and salary >= 10000)
group by job_title
order by avg_sal desc;



select department_name as job_title, salary
from employees e, departments d
where e.department_id = d.department_id;