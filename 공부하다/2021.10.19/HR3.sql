--------------------------------------------------------------------------
--���̺��� �� �����ϱ� ���̺� ����� Ư�� ������ ���� �����Ѵ�. 
--DELETE FROM ���̺��
--[WHERE ���ǽ�]; -- WHERE���� �����ϸ� ���̺��� ��� ���� �����ȴ�. WHERE�� ���� DELETE������ �����ϴ� ��� ���� ����. 
--���̺� ����� ��� �����͸� ������ ��� 
--TRUNCATE�� ����ؼ� �����͸� �ǵ��� �� ������ �����Ѵ�. 

--�������� ���̺��� ������ �л��� ������ �����ϱ� 
DELETE FROM TB_SCORES
WHERE STUDENT_NAME = '������';
--����� 80�� �̸��� �л��� ���� ������ �����ϱ� 
DELETE FROM TB_SCORES
WHERE AVERAGE_SCORE < 80;

--������ �����ߴ� ��� �۾��� ���̺� �ݿ��� ��ҽ�Ų��.
ROLLBACK;

--�ߺ����� ������ ��� ���̺��� ��ȸ�Ѵ�. 
SELECT DISTINCT *
FROM TB_SCORES;

------------------------------------------------------------------------------
-- DML�ǽ��ϱ� 
-- å���� ���̺� �����ϱ� 
-- å���� (��ȣ, ����, ����, ���ǻ�, ����, ���ΰ���, ���, �Ǹſ���)
--  ��ȣ :    BOOK_NO             NUMBER          5       PRIMARY KEY,
--  ���� :    BOOK_TITLE          VARCHAR2        250     NOTNULL,
--  ���� :    BOOK_WRITER         VARCHAR2        100     NOTNULL,
--  ���ǻ� :  BOOK_PUBLISHER       VARCHAR2        100  
--  ���� :    BOOK_PRICE             NUMBER         7,
--  ���ΰ��� : BOOK_DISCOUNT_PRICE    NUMBER        7,
--  ���  :   BOOK_STOCK            NUMBER          4,
--  �Ǹſ��� : BOOK_ON_SALE         VARCHAR2        30

--0.���� ���̺� �����ϱ� 
--DROP TABLE ���̺��; 
--�����뿡�� �ǵ����� ���� ����������, SQL���������� ������ ���̺� �����ϱ�� ����. 

--1. CREATE TABLE ������ ����ؼ� ���̺� �����ϱ� 
-- ���̺� ���� TB_SAMPLE_BOOKS�̴�. 

CREATE TABLE TB_SAMPLE_BOOKS (
    BOOK_NO NUMBER(5,0) PRIMARY KEY,
    BOOK_TITLE VARCHAR2(250) NOT NULL,
    BOOK_WRITER VARCHAR2(100) NOT NULL,
    BOOK_PUBLISHER VARCHAR2(100),
    BOOK_PRICE NUMBER(7,0),
    BOOK_DISCOUNT_PRICE NUMBER(7,0),
    BOOK_STOCK NUMBER(4,0), --DEFAULT 10
    BOOK_ON_SALE VARCHAR2(30) --DEFAULT '�Ǹ���' ���� DEFAULT���� ���س����� �Է����� �ʾƵ���
);
--2. INSERT INTO ������ �̿��ؼ� TB_SAMPLE_BOOKS ���̺� å���� �߰��ϱ� 
--������ �� å�忡 �����ִ� å ���� �ؼ� ������ �߰��ϱ� 
--å ������ �߰��� �� å��ȣ�� �ߺ����� �߰����� �ʵ��� �Ѵ�. 
--���� , ���� ����, ���, �Ǹſ��δ� ������ ������ �����Ѵ�. 
INSERT INTO TB_SAMPLE_BOOKS(BOOK_NO,BOOK_TITLE, BOOK_WRITER, BOOK_PUBLISHER, BOOK_PRICE, BOOK_DISCOUNT_PRICE, BOOK_STOCK, BOOK_ON_SALE)
VALUES(100,'��ü�غ���','�����','û��̵��',35000,25000,5,'����غ���');

INSERT INTO TB_SAMPLE_BOOKS(BOOK_NO, BOOK_TITLE, BOOK_WRITER, BOOK_PUBLISHER, BOOK_PRICE, BOOK_DISCOUNT_PRICE, BOOK_STOCK, BOOK_ON_SALE)
VALUES (200,'��Ὺ��','�̸��','�����',37000,12000,4,'�ֹ���');

INSERT INTO TB_SAMPLE_BOOKS VALUES (300,'������κ�����','������','���̴�',39000,3000,2,'�����');
INSERT INTO TB_SAMPLE_BOOKS VALUES (301,'��ȸ������õ�����','������','������',25000,1000,10,'�����');
INSERT INTO TB_SAMPLE_BOOKS VALUES(201,'����������','�迵��','�Ͻ���',25000,15000,2,'�����');

--3.COMMIT�� �����ؼ� �߰��� å������ ���̺� �ݿ���Ų��. 
COMMIT;

--4. TB_SAMPLE_BOOKS���̺� ����� ��� å ������ ��ȸ�Ѵ�.
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

