아래에 정의된 내용으로 테이블을 생성하세요

-----------------------------------------------------------
테이블명 : TBL_MEMBER
-----------------------------------------------------------
컬럼명		    데이터타입         크기       제약조건
-----------------------------------------------------------
ID 				VARCHAR2        20       PRIMARY KEY
NAME 			VARCHAR2        20       NOT NULL
PASSWORD 		VARCHAR2        20       NOT NULL
EMAIL_ID 		VARCHAR2        30
EMAIL_DOMAIN 	VARCHAR2        20
TEL1 			CHAR            3
TEL2 			CHAR            4
TEL3 			CHAR			4
POST 			CHAR			7
BASIC_ADDR 		VARCHAR2		200
DETAIL_ADDR 	VARCHAR2		200
TYPE            CHAR			1  		 default 'U',
REG_DATE 		DATE 					 default sysdate
-----------------------------------------------------------