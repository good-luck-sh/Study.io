--트랜젝션 처리하기 

SELECT *
FROM TB_SAMPLE_FOODS;                       --1번트렌젝션의 시작

UPDATE TB_SAMPLE_FOODS
SET FOOD_PRICE = 4000
WHERE FOOD_NO = 5001;                       

SELECT *
FROM TB_SAMPLE_FOODS
WHERE FOOD_NO = 5001;
--1번 트랜잭션의 실행문
--트랜젝션 처리하기 
INSERT INTO TB_SAMPLE_FOODS VALUES(FOOD_SEQ.NEXTVAL,'새우깡',1000,1000,'판매중',3002);   --1번트랜잭션시작
--1번 트랜잭션의 실행문
INSERT INTO TB_SAMPLE_FOODS VALUES(FOOD_SEQ.NEXTVAL,'초코파이',700,1000,'판매중',3002);
--1번 트랜잭션의 실행문
INSERT INTO TB_SAMPLE_FOODS VALUES(FOOD_SEQ.NEXTVAL,'꼬북칩',1500,100,'판매중',3002);
--1번 트랜잭션의 실행문
INSERT INTO TB_SAMPLE_FOODS VALUES(FOOD_SEQ.NEXTVAL,'칸쵸',2000,50,'판매중',3002);
--1번 트랜잭션의 실행문
SELECT *
FROM TB_SAMPLE_FOODS; --INSERT, DELETE, UPDATE만 트랜잭션의 대상이다. 
--1번 트랜잭션의 실행문 수행결과 데이터 베이스 반영
COMMIT;         --DML작업결과 반영, 진행중이던 1번 트랜잭션의 종료, 2번 트랜잭션 시작
                --1번 트랜잭션이 종료되었기 때문에 1번 트랜잭션의 실행문 수행결과를 다시 되돌리거나 할 수 없다. 
-- 2번 트랜잭션의 실행문
UPDATE TB_SAMPLE_FOODS
SET FOOD_PRICE = 3800
WHERE FOOD_NO IN(5001,5002);
--2번 트랜잭션의 실행문
UPDATE TB_SAMPLE_FOODS
SET FOOD_PRICE = 4000
WHERE FOOD_NO IN(5003,5006);
--2번 트랜잭션의 실행문
INSERT INTO TB_SAMPLE_FOODS VALUES(FOOD_SEQ.NEXTVAL,'매운곱창볶음밥',4500,50,'판매중',3001);

--2번 트랜잭션의 실행문 수행결과 데이터베이스 반영 취소, 위에서 실행한 1번 트랜잭션의 실행문 실행결과를 취소할 수 없다.
ROLLBACK;                    --DML작업결과 취소, 진행중이던 2번 트랜젝션 종료,3번 트랜잭션 시작
COMMIT; --DML작업결과 반영, 진행중이던 3번 트랜잭션의 종료, 4번 트랜잭션의 시작
        --해당 COMMIT명령어로 2번 트랜잭션의 실행문 실행결과를 데이터베이스에 반영시킬 수 없다. 
        --COMMIT 실행전에 실행한 ROLLBACK 명령때문에 2번트랜잭션은 완전 종료 되었기 때문에 
        --2번 트랜잭션과 관련된 어떤 작업도 실행할 수 없다.
        --2번 트랜잭션에서 실행했던 작업을 데이터베이스에 반영하고 싶다면 새로운 트랜잭션이 시작된 다음에 
        --다시 실행문들을 실행하고, COMMIT을 실행하면 된다. 
        
--4번 트랜잭션의 실행문
UPDATE TB_SAMPLE_FOODS
SET FOOD_PRICE = 3800
WHERE FOOD_NO IN(5001,5002);
--4번 트랜잭션의 실행문
UPDATE TB_SAMPLE_FOODS
SET FOOD_PRICE = 4000
WHERE FOOD_NO IN(5003,5006);
--4번 트랜잭션의 실행문
INSERT INTO TB_SAMPLE_FOODS VALUES(FOOD_SEQ.NEXTVAL,'매운곱창볶음밥',4500,50,'판매중',3001);     

COMMIT;

insert into tb_sample_food_customers(customer_no, customer_name, customer_tel )
values 
(customer_seq.nextval ,'홍길동' ,'010-1111-3333');
COMMIT;

SELECT FOODORDER_SEQ.NEXTVAL FROM DUAL;
