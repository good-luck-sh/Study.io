--------------------------------------------------------------------------
--테이블의 행 삭제하기 테이블에 저장된 특정 데이터 행을 제거한다. 
--DELETE FROM 테이블명
--[WHERE 조건식]; -- WHERE절을 생략하면 테이블의 모든 행이 삭제된다. WHERE절 없이 DELETE구문을 실행하는 경우 거의 없다. 
--테이블만 남기고 모든 데이터를 삭제할 경우 
--TRUNCATE를 사용해서 데이터를 되돌릴 수 없도록 제거한다. 

--성적정보 테이블에서 김유신 학생의 정보를 삭제하기 
DELETE FROM TB_SCORES
WHERE STUDENT_NAME = '김유신';
--평균이 80점 미만이 학생의 성적 정보를 삭제하기 
DELETE FROM TB_SCORES
WHERE AVERAGE_SCORE < 80;

--위에서 수행했던 모든 작업의 테이블 반영을 취소시킨다.
ROLLBACK;

--중복값을 제거한 모든 테이블을 조회한다. 
SELECT DISTINCT *
FROM TB_SCORES;

------------------------------------------------------------------------------
-- DML실습하기 
-- 책정보 테이블 정의하기 
-- 책정보 (번호, 제목, 저자, 출판사, 가격, 할인가격, 재고, 판매여부)
--  번호 :    BOOK_NO             NUMBER          5       PRIMARY KEY,
--  제목 :    BOOK_TITLE          VARCHAR2        250     NOTNULL,
--  저자 :    BOOK_WRITER         VARCHAR2        100     NOTNULL,
--  출판사 :  BOOK_PUBLISHER       VARCHAR2        100  
--  가격 :    BOOK_PRICE             NUMBER         7,
--  할인가격 : BOOK_DISCOUNT_PRICE    NUMBER        7,
--  재고  :   BOOK_STOCK            NUMBER          4,
--  판매여부 : BOOK_ON_SALE         VARCHAR2        30

--0.기존 테이블 삭제하기 
--DROP TABLE 테이블명; 
--휴지통에서 되돌리는 것은 가능하지만, SQL쿼리에서는 삭제된 테이블 복원하기는 없다. 

--1. CREATE TABLE 구문을 사용해서 테이블 생성하기 
-- 테이블 명은 TB_SAMPLE_BOOKS이다. 

CREATE TABLE TB_SAMPLE_BOOKS (
    BOOK_NO NUMBER(5,0) PRIMARY KEY,
    BOOK_TITLE VARCHAR2(250) NOT NULL,
    BOOK_WRITER VARCHAR2(100) NOT NULL,
    BOOK_PUBLISHER VARCHAR2(100),
    BOOK_PRICE NUMBER(7,0),
    BOOK_DISCOUNT_PRICE NUMBER(7,0),
    BOOK_STOCK NUMBER(4,0), --DEFAULT 10
    BOOK_ON_SALE VARCHAR2(30) --DEFAULT '판매중' 으로 DEFAULT값을 정해놓으면 입력하지 않아도됨
);
--2. INSERT INTO 구문을 이용해서 TB_SAMPLE_BOOKS 테이블에 책정보 추가하기 
--여러분 집 책장에 꽂혀있는 책 참고 해서 여러개 추가하기 
--책 정보를 추가할 때 책번호는 중복값이 추가되지 않도록 한다. 
--가격 , 할인 가격, 재고, 판매여부는 임의의 값으로 정의한다. 
INSERT INTO TB_SAMPLE_BOOKS(BOOK_NO,BOOK_TITLE, BOOK_WRITER, BOOK_PUBLISHER, BOOK_PRICE, BOOK_DISCOUNT_PRICE, BOOK_STOCK, BOOK_ON_SALE)
VALUES(100,'인체해부학','노명희','청담미디어',35000,25000,5,'배송준비중');

INSERT INTO TB_SAMPLE_BOOKS(BOOK_NO, BOOK_TITLE, BOOK_WRITER, BOOK_PUBLISHER, BOOK_PRICE, BOOK_DISCOUNT_PRICE, BOOK_STOCK, BOOK_ON_SALE)
VALUES (200,'재료역학','이명대','대원사',37000,12000,4,'주문중');

INSERT INTO TB_SAMPLE_BOOKS VALUES (300,'현대노인복지론','진석범','학이당',39000,3000,2,'배송중');
INSERT INTO TB_SAMPLE_BOOKS VALUES (301,'사회복지실천기술론','김윤재','동문사',25000,1000,10,'배송중');
INSERT INTO TB_SAMPLE_BOOKS VALUES(201,'프리물리학','김영유','북스힐',25000,15000,2,'배송중');

--3.COMMIT을 실행해서 추가된 책정보를 테이블에 반영시킨다. 
COMMIT;

--4. TB_SAMPLE_BOOKS테이블에 저장된 모든 책 정보를 조회한다.
SELECT * 
FROM TB_SAMPLE_BOOKS;

CREATE TABLE TB_EXCEL_BOOKS (
    BOOK_NO NUMBER(5) PRIMARY KEY,
    BOOK_TITLE VARCHAR2(250) NOT NULL,
    BOOK_WRITER VARCHAR2(250) NOT NULL,
    BOOK_PUBLISHER VARCHAR2(250),
    BOOK_PRICE NUMBER(7),
    BOOK_DISCOUNT_PRICE NUMBER(7),
    BOOK_POINT NUMBER(5),
    BOOK_REVIEW_SCORE NUMBER(3, 1),
    BOOK_SAIL_SCORE NUMBER(8)
);

