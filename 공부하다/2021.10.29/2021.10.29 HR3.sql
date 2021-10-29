--인라인뷰 

--부서별 인원수를 조회해서 부서별 인원수가 10명 미만이 부서의 아이디, 부서명, 인원수를 조회하기
SELECT V.DEPARTMENT_ID, D.DEPARTMENT_NAME, V.CNT -- 가상의 테이블에서 추출함
FROM ( --이것자체를 가상의 테이블로 봄, 이 쿼리의 실행결과가 출력됨 V라는 가상의 테이블
SELECT DEPARTMENT_ID, COUNT(*) CNT --함수는 실행결과에 별칭을 주는 것이 쿼리실행에 편하다.
FROM EMPLOYEES
WHERE DEPARTMENT_ID IS NOT NULL
GROUP BY DEPARTMENT_ID ) V , DEPARTMENTS D
WHERE V.CNT < 10; --별칭을 가져와서 조건식을 건다.

--쿼리 안에 존재하는 쿼리 : 서브쿼리라고 부른다. 
--서브쿼리내에 인라인뷰가 존재하는 것임

--인덱스

 SELECT ROWID, EMPLOYEE_ID, FIRST_NAME
 FROM EMPLOYEES;
 --AAAStQ AAH AAAAGl AAA
 --오브젝트 번호 (테이블에 따라 다르다)
 --파일번호 (같은 파일에 저장된 번호다.)
 --블록번호 
 --행번호 (슬록번호 )
 SELECT ROWID, PRODUCT_NO, PRODUCT_NAME
 FROM TB_SAMPLE_PRODUCTS;
 --AAAS83 AAH AAAAIGAAA
 
 --인덱스 
 --ROWID와 연관성이 있다. 
 SELECT *
 FROM TB_SAMPLE_FOODS
 WHERE FOOD_NO = 5001;
 ----음식 이름에 대해서 인덱스를 생성해보자 , 인덱스 명뒤에는 IDX를 많이 붙임
 CREATE INDEX FOOD_NAME_IDX
 ON TB_SAMPLE_FOODS(FOOD_NAME);
 
  SELECT *
 FROM TB_SAMPLE_FOODS
 WHERE FOOD_NAME = '진라면';