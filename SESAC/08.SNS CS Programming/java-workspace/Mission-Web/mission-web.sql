/*
    웹 프로젝트용 게시판 테이블 생성(tbl_board)
    게시판번호  no       정수형     기본키
    제목       title    문자형     필수항목
    작성자     writer   문자형     필수항목
    내용       content  문자형     필수항목
    조회수     view_cnt  정수형     기본값(0)
    등록일     reg_date  날짜형     기본값(현재날짜)
*/

create table tbl_board(
no number(5) primary key
, title varchar2(400) not null
, writer varchar2(100) not null
, content varchar2(4000) not null
, view_cnt number(5) default 0
, reg_date date default sysdate
);

-- 게시판번호
create sequence seq_tbl_board_no nocache
start with 1
increment by 1;
    
select * from tbl_board;

-- 수업을 위한 데이터 insert

insert into tbl_board(no, title, writer, content)
values(seq_tbl_board_no.nextval, '제목입니다', '홍길동', '내용입니다');

insert into tbl_board(no, title, writer, content)
values(seq_tbl_board_no.nextval, 'sql삽입', '홍길동', 'sqldeveloper에서 삽입');

commit;


-- 컬럼 이름 변경
alter table tbl_board
rename column regdate to reg_date;

desc tbl_board;


-- 타입 변경, 이미 데이터가 있을 경우 변경 불가!
alter table tbl_board
modify reg_date varchar2(1000);