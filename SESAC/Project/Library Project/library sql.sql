/*
t_books
   - å ���� ���̺�
   - book_code(å ���� �ڵ�)
   - title(å����)
   - writer(����)
   - publisher(���ǻ�)
   - available_book(���� �� �ִ� �Ǽ�)

t_user
   - ȸ�� ����
   - id(���̵�)
   - password(��й�ȣ)
   - name(�̸�)
   - birth(�������)
   - phone(�ڵ�����ȣ)
   - lending_book_num(���� å ��)
   - is_manager(�Ŵ�������, 0:�Ϲ�ȸ��, 1:�Ŵ���)

t_manage
   - ���⳻��
   - no(����)
   - book_code(���� å �ڵ�)
   - id (���� ��� id)
   - lend_date(������)
   - deadline(�ݳ��� ��)
   - return_date(���� �ݳ��� ��)
*/

create table t_books(
book_code number(10) primary key
,title varchar2(40) not null
,writer varchar2(20) not null
,publisher varchar2(20) not null
,available_book number(1) default 1 not null );

create table t_user(
id varchar2(20)
,password varchar2(20) not null
,name varchar2(20) not null
,birth date
,phone number(20)
,lending_book_num number(1) default 0 not null -- ���� �ʿ�
,is_manager number(10) default 0 not null --0���� �ְ� null�� �����ϰ�
,constraint t_user_PK primary key(id, phone) 
);

create table t_manage(
no number primary key    --i++
,book_code number(10)
,id varchar2(10) not null
,lend_date date default sysdate not null
,deadline date default sysdate+7 not null
,return_date date
);


create sequence Numbering
    start with 1
    increment by 1;
select Numbering.nextval from dual;

