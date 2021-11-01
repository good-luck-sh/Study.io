--HR계정의 EMPLOYEES 테이블의 데이터를 조회하기 
SELECT EMPLOYEE_ID, FIRST_NAME
FROM HR.EMPLOYEES;

--HR계정의 DEPARTMENTS 테이블의 데이터를 조회하기 
--HTA 계정의 DEPARTMENTS 테이블에 대한 객체 권한이 없기 때문에 DEPARTMENTS 테이블을 엑세스할 수 없다.
SELECT DEPARTMENT_ID, DEPARTMENT_NAME
FROM HR.DEPARTMENTS; --따로 GRANT하지 않아서 확인할 수 없다.
--실제 테이블에 대한 ACCESS가 아닌 HTA에는 가상의 TABLE만 볼 수 있도록 하여, 업무로직에 대한 
--정보만 확인할 수 있도록 하기 때문에 보안성을 높일 수 있게 만들 수 있다. 

--SYNONYM(동의어)
--데이터 베이스 객체에 대한 별칭을 정의하는 것
--다른 사용자의 데이터베이스 객체를 사용할 때 동의어를 정의해서 사용한다.

--동의어를 사용하는 목적 
--1.복잡한 데이터베이스 객체명을 짧은 이름으로 대체할 수 있어서, SQL이 간단해진다. 
--2.참조하는 객체에 대한 SQL을 동의어로 사용해서 작성했다면, 참조하는 데이터베이스 객체명이 변경되더라도 
--동의어만 변경하면 사용중인 SQL문읗 수정할 필요가 없다. 
--3.동의어가 정의되어 있으면, 데이터베이스 객체에 대한 소유주, 서버명, 데이터베이스 객체의 실제 이름등을
--모르더라도 사용할 수 있다. 

--HR계정의 EMPLOYEES 테이블에 대한 동의어 정의하기 
--CREATE SYNONYM 별칭
--FOR 데이터베이스객체

--HR계정의 EMPLOYEES 테이블을 참조하는 동의어 정의하기 
CREATE SYNONYM HR_EMP FOR HR.EMPLOYEES;