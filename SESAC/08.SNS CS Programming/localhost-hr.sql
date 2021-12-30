/* 12.30 �ǽ� */

/* ���̺� ���� - commit ���ص� ������ */
create table t_test(
    id varchar2(30) primary key, -- unique + not null, �����ؾ� �ϸ� ��������� �� ��
    name varchar2(100) not null
);

/* drop - ����, drop table - ���̺� ���� */
drop table t_test;

select * from tab;
desc employees;
desc t_test;
select * from t_test;

select * from employees;

/* �� ���� */
-- insert into ���̺�(�÷�, �÷�) values(����, ����);
insert into t_test(id, name)
values('hong', 'ȫ�浿');

select * from t_test;
commit;

update t_test set name = 'ȫ����' where id = 'hong';
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