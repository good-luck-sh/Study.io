--SELECT문의 기본구조
--SELECT * 혹은 컬럼명
--FROM 테이블명; 

-- 지정한 테이블의 모든 행, 모든 열 조회하기 
SELECT *
FROM DEPARTMENTS;

--직원(EMPLOYEES)테이블의 모든 행, 모든 열 조회하기 
SELECT *
FROM EMPLOYEES;

--국가(COUNTRIES)테이블의 모든 행, 모든 열 조회하기 
SELECT *
FROM COUNTRIES;
--------------------------------------------------------------------------------
--테이블의 모든 행, 지정한 열 조회하기 
--SELECT 컬럼명, 컬럼명, 컬럼명, ...(내가 보고싶은 열을 개별적으로 지정후)
--FROM 테이블명; 전체적인 열을 출력하겠다.

--직원(EMPLOYEES)테이블에서 직원아이디, 직원이름, 입사일, 급여를 지정하기 
--직원아이디: EMPLOYEE_ID, 직원이름:FIRST_NANE ,입사일:HIRE_DATE,급여:SALARY
SELECT EMPLOYEE_ID,FIRST_NAME,HIRE_DATE,SALARY
FROM EMPLOYEES;

--직원(EMPLOYEES)테이블에서 직원아이디, 직원이름, 전화번호, 이메일을 조회하기 
--전화번호 :PHONE_NUMBER, 이메일:EMAIL
SELECT EMPLOYEE_ID, FIRST_NAME, PHONE_NUMBER, EMAIL
FROM EMPLOYEES;

--부서(DEPARTMENT)테이블에서 부서아이디, 부서명 조회하기 
SELECT DEPARTMENT_ID, DEPARTMENT_NAME 
FROM DEPARTMENTS;

--직종(JOBS)테이블에서 직종아이디, 직종제목 조회하기 
SELECT JOB_ID, JOB_TITLE
FROM JOBS;
--소재지(LOCATIONS)테이블에서 소재지 아이디, 주소, 도시명 조회하기 
SELECT LOCATION_ID, STREET_ADDRESS, CITY
FROM LOCATIONS;

------------------------------------------------------------------------------
--SELECT절 에서 산술연산자 사용하기 (+,-,*,/)

--직원테이블에서 직원이름, 직원급여, 직원 연봉 조회하기 
--직원연봉은 급여*12로 가정한다. 
SELECT FIRST_NAME, SALARY, SALARY * 12
FROM EMPLOYEES;

--직종테이블(JOBS)에서 직종아이디, 최저급여, 최고급여, 최저급여의 차이를 조회하기 
SELECT JOB_ID, MIN_SALARY, MAX_SALARY, MAX_SALARY - MIN_SALARY
FROM JOBS;
--직원테이블에서 직원아이디, 이름, 급여, 10%인상된 급여, 인상된 금액을 조회하기 
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, SALARY*1.1, SALARY*1.1-SALARY
FROM EMPLOYEES;

-----------------------------------------------------------------------------
--SELECT 절의 컬럼명에 별칭 사용하기 
--SELECT 컬럼명 AS 별칭, 컬럼명 AS 별칭, 컬럼명 AS별칭
--FROM 테이블명;

--SELECT 컬럼명 별칭, 컬럼명 별칭, 컬럼명 별칭(AS를 생략해도 됨)
--FROM 테이블명;

-- * 만약 별칭에 공백이나 특수문자가 포함되어있는 경우 ""로 감싸야 한다. 

--별칭의 필요 이유, SELECT절에서 연산식을 사용한 경우 
--연산식이 컬럼NAME으로 바뀌기 때문에 식별확인이 어려움 그래서 별칭을 작성하게 된다. 
SELECT EMPLOYEE_ID AS 직원아이디, FIRST_NAME AS 이름, SALARY AS 급여, SALARY*12 AS 연봉
FROM EMPLOYEES;
--컬럼의 이름이 변경이 된 것이 아닌, 지정해준 이름의 별칭명으로 출력되는 것뿐임,한글은 잘 작성하지 않음

--직종테이블에서 직종아이디, 최저급여, 최고급여, 최고급여와 최저급여 차이를 조회하기 
SELECT JOB_ID 아이디, MIN_SALARY 최저급여, MAX_SALARY 최고급여, MAX_SALARY - min_salary "급여 차이"
FROM JOBS;
-- * 별칭에 공백을 포함시키지 말자

--------------------------------------------------------------------
--중복된 결과 제거하기 
--SELECT DISTINCT 컬럼명, 컬럼명, ...
--FROM 테이블명;


--직원테이블에서 직원들이 소속된 부서아이디 조회하기 
SELECT DISTINCT DEPARTMENT_ID
FROM EMPLOYEES;
--어떤 부서에 소속되어있는지만 확인하면 되기 때문에 같은 값이 여러개가 나올 필요가 없다. 중복으로 107행이 출력됨
--DISTINCT를 사용하면 NULL이 출력된다. 자바의 NULL 과 ORACLE SQL의 NULL의 차이점
--JAVA에서 NULL : 참조변수가 가지는 값, 참조변수가 객체를 참조하고 있지 않다. 
--ORACLE에서 NULL : 그 컬럼의 값이 결정되지 않았다

--------------------------------------------------------------------------
--행을 제한하기 (데이터 필터링하기)
--SELECT 컬럼명,컬럼명,컬럼명,...
--FROM 테이블명
--WHERE 조건식;( 크다, 작다, 조건 형태)
-- * 조건식의 값이 TRUE로 판정되는 행만 조회된다. 
-- * 조건식에서는 비교연산자와 논리연산자, 기타연산자들이 사용된다. 
-- * 비교연산자 : > < >= <= =(같다라는 의미로 사용함) != , <>(같지않다)
-- * 논리연산자 : AND OR NOT(키워드를 사용하면 됨 ,직접적인 키워드를 사용함)

-- (직원테이블에서) 급여를 15_000달러 이상 받은 직원들의 
-- 직원아이디, 이름, 급여를 조회하기 
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY  
FROM EMPLOYEES
WHERE SALARY >= 15000;

--60번 부서에서 일하는 직원들의 직원아이디, 직원이름, 직종아이디를 조회하기 
-- * EMPLOYEES 테이블의 DEPARTMENT_ID는 직원의 소속부서 아이디다. 
-- * 60번 부서에서 일하는 직원은 EMPLOYEES의 DEPARTMENT_ID가 60인 직원을 조회하는 것이다.
SELECT EMPLOYEE_ID, LAST_NAME, JOB_ID
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 60;

-- 세일즈 매니저(SA_MAN)로 종사하고 있는 직원의 아이디, 이름, 전화번호, 이메일을 조회하기 
SELECT EMPLOYEE_ID, LAST_NAME, PHONE_NUMBER, EMAIL
FROM EMPLOYEES
WHERE JOB_ID = 'SA_MAN';

-- 아래의 select문의 조회된 결과가 없다.
SELECT EMPLOYEE_ID, LAST_NAME, PHONE_NUMBER, EMAIL
FROM EMPLOYEES
WHERE JOB_ID = 'sa_man';
--소문자로 적었을 경우 값이 나오지 않음
-- * 오라클의 키워드와 식별자 (테이블명, 컬럼명, 별칭 등)은 대소문자를 구분하지 않는다. 
-- * 테이블에 저장된 값은 대소문자를 엄격하게 구분한다 

--------------------------------------------------------------------------------
--WHERE 절에서 여러개의 조건으로 행을 필터링하기 
--SELECT 컬럼명, 컬럼명, 컬럼명
--FROM 테이블명
--WHERE 조건식1 AND 조건식2 AND 조건식3
-- * 각 조건식은 비교연산자, 논리연산자, 기타연산자를 사용해서 true/ false로 판정되는 조건식이다. 

-- 80번 부서에 소속되어 있고, 급여를 3000달러 이하로 받은 직원들의 
-- 직원아이디, 직원이름, 입사일자, 급여를 조회하기 
SELECT EMPLOYEE_ID, FIRST_NAME, HIRE_DATE, SALARY
FROM EMPLOYEES
WHERE SALARY <= 3000 
AND DEPARTMENT_ID = 50;

--직원들중에서 급여를 10000달러 이상 15000달러 미만으로 받는 직원들의 직원아이디, 이름, 직종아이디, 급여를 조회하기 
