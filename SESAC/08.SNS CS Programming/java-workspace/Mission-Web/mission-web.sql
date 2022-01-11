/*
    �� ������Ʈ�� �Խ��� ���̺� ����(tbl_board)
    �Խ��ǹ�ȣ  no       ������     �⺻Ű
    ����       title    ������     �ʼ��׸�
    �ۼ���     writer   ������     �ʼ��׸�
    ����       content  ������     �ʼ��׸�
    ��ȸ��     view_cnt  ������     �⺻��(0)
    �����     reg_date  ��¥��     �⺻��(���糯¥)
*/

create table tbl_board(
no number(5) primary key
, title varchar2(400) not null
, writer varchar2(100) not null
, content varchar2(4000) not null
, view_cnt number(5) default 0
, reg_date date default sysdate
);

-- �Խ��ǹ�ȣ
create sequence seq_tbl_board_no nocache
start with 1
increment by 1;
    
select * from tbl_board;

-- ������ ���� ������ insert

insert into tbl_board(no, title, writer, content)
values(seq_tbl_board_no.nextval, '�����Դϴ�', 'ȫ�浿', '�����Դϴ�');

insert into tbl_board(no, title, writer, content)
values(seq_tbl_board_no.nextval, 'sql����', 'ȫ�浿', 'sqldeveloper���� ����');

commit;


-- �÷� �̸� ����
alter table tbl_board
rename column regdate to reg_date;

desc tbl_board;


-- Ÿ�� ����, �̹� �����Ͱ� ���� ��� ���� �Ұ�!
alter table tbl_board
modify reg_date varchar2(1000);