/*
t_books
   - 책 정보 테이블
   - book_code(책 고유 코드)
   - title(책제목)
   - writer(저자)
   - publisher(출판사)
   - available_book(빌릴 수 있는 권수)

t_user
   - 회원 정보
   - id(아이디)
   - password(비밀번호)
   - name(이름)
   - birth(생년월일)
   - phone(핸드폰번호)
   - lending_book_num(빌린 책 수)
   - is_manager(매니저여부, 0:일반회원, 1:매니저)

t_manage
   - 대출내역
   - no(순서)
   - book_code(빌린 책 코드)
   - id (빌린 사람 id)
   - lend_date(빌린날)
   - deadline(반납할 날)
   - return_date(실제 반납한 날)
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
,lending_book_num number(1) default 0 not null -- 설정 필요
,is_manager number(10) default 0 not null --0값도 넣고 null도 방지하고
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

