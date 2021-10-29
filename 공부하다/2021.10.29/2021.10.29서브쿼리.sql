--단일행 서브쿼리 
--다른 SQL에 포함된 SQL문이다. 
--SELECT절, FROM절, WHERE절, HAVING절에서 사용할 수 있다. 

-- WHERE절이나 HAVING절에서 사용되는 서브쿼리는 조건식의 사용될 값을 제공한다. 
-- 조건식에서 사용되는 값이 SQL 실행으로 획득되는 경우에 서브쿼리를 사용한다. 
--SQL실행으로만 획득되는 경우에!

--100번 사원과 같은 부서에서 일하는 사원의 아이디, 이름 조회하기 
--1. 100번사원이 일하는 부서 조회하기 
SELECT DEPARTMENT_ID
FROM EMPLOYEES
WHERE EMPLOYEE_ID = 100; --90번에 일하는 것을 알 수 있음
--2. 90번 부서에서 일하는 직원 조회하기 
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 90;  --2단계를 거쳐야지 알 수 있다. 

--100번 사원과 같은 부서에서 일하는 사원의 아이디, 이름 조회하기 

SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE DEPARTMENT_ID = (SELECT DEPARTMENT_ID
                        FROM EMPLOYEES
                        WHERE EMPLOYEE_ID = 100); --이 부분만 실행시 90값이 출력됨
                        
--전체직원의 평균급여보다 적은 금여를 받는 직원아이디, 이름 , 급여를 조회하기 
--1. 전체지구언의 평균급여 조회하기 
SELECT AVG(SALARY)
FROM EMPLOYEES;
--2. 6461.8317보다 적은 급여를 받는 직원아이디, 이름 급여를 조회하기 
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY < '6461.8317';

--전체직원의 평균급여보다 적은 금여를 받는 직원아이디, 이름 , 급여를 조회하기,서브쿼리를 사용해서 조회하기 
SELECT EMPLOYEE_ID, FIRST_NAME,SALARY
FROM EMPLOYEES
WHERE SALARY < (SELECT AVG(SALARY)
                FROM EMPLOYEES);
                
--100사원과 같은 해에 입사했고, 전체직원의 평균급여보다 급여를 많이 받는 사원의 아이디, 급여를 조회하기 
--조건이 2개임 

SELECT EMPLOYEE_ID, HIRE_DATE, SALARY
FROM EMPLOYEES
WHERE TO_CHAR(HIRE_DATE,'YYYY') = --100사원이 입사한해 
(SELECT TO_CHAR(HIRE_DATE,'YYYY')
FROM EMPLOYEES
WHERE EMPLOYEE_ID = '100')

AND SALARY > --전체사원의 평균급여 
(SELECT AVG(SALARY)
                FROM EMPLOYEES);
--전체 직원의 급여를 인상시키기, 인상금액은 전체직원의 평균급여의 10%만큼 인상시킨다. 
UPDATE EMPLOYEES
SET SALARY = SALARY +(SELECT TRUNC(AVG(SALARY)*0.1)
                        FROM EMPLOYEES);
                        --급여를 인상시키는 것이기 때문에 수정으로 처리함, 서브쿼리는 UPDATE로 사용해도 됨
SELECT FIRST_NAME, SALARY
FROM EMPLOYEES;

-------------------------------------------------------------------------------
--다중행 서브쿼리

--자신이 종사하던 직종이 변경된 적이 있는 직원들의 아이디, 이름을 조회하기 
--1. 자신이 종사하던 직종이 변경된 적이 있는 직원의 아이디 조회하기  -- 조회결과가 다중행이다.
SELECT DISTINCT EMPLOYEE_ID --결과가 여러개가 나옴, 다중행 서브쿼리
FROM JOB_HISTORY;
--2. 직종이 변경된 적이 있는 직원들의 아이디, 이름, 현재 직종을 조회하기 
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID
FROM EMPLOYEES
WHERE EMPLOYEE_ID IN(101,102,114,122,176,200,201); --위에서 나온 결과를 전부입력한 것임. 그래서 IN이라는 연산자가 옴
-- =은 값1개를 비교하기 위해서 작성하는 것이니 당연히 IN을 작성하는 것이 맞음
--자신이 종사하던 직종이 변경된 적이 있는 직원들의 아이디, 이름, 직종아이디,예전직종아이디 조회하기 (다중행 서브쿼리 사용, 다중행 서브쿼리 연산자 사용함)
SELECT EMPLOYEE_ID, FIRST_NAME,JOB_ID
FROM EMPLOYEES
WHERE EMPLOYEE_ID IN(SELECT DISTINCT EMPLOYEE_ID --H의 해당부분이 서브쿼리밖에 없어서 H를 조죄할 수 없다. 
                FROM JOB_HISTORY);

--자신이 종사하던 직종이 변경된 적이 있는 직원들의 아이디, 이름, 직종아이디,예전직종아이디를 조회하기(조인 사용--서브쿼리를 사용하지 않아도 나옴)
SELECT DISTINCT E.EMPLOYEE_ID, E.FIRST_NAME, E.JOB_ID, H.JOB_ID
FROM EMPLOYEES E, JOB_HISTORY H
WHERE E.EMPLOYEE_ID = H.EMPLOYEE_ID;
--조인은 한쪽에 있는 것이 나오지 않음, 양쪽에 있어야만 결과가 나온다. 
--조인을 사용할 수있으면 서브쿼리보다 조인을 사용하는 것이 좋다. 
--서브쿼리보다 조인을 장려한다. 
-- 값을가공없이 사용할 때는 JOIN을 사용하는 것이 좋다. 
--조인으로 풀수있는것은 서브쿼리로 사용할 수 있지만, 서브쿼리의 값을 main쿼리에서 가져올 수 없다. 
--괄호안에서만 사용하고 끝이다. 조인으로 풀리는 것이 더 많기 때문에 되도록 조인을 사용하는 것이 좋지만 
--되도록 조인을 사용하는 것이 좋다. 

--30번 부서에 소속된 모든 직원의 급여보다 급여를 많이 받는 60번 부서 소속의 직원을 조회하기 
--30번 부서에 소속된 직원의 최대급여보다 급여를 많이 받는 60번 부서 소속의 직원을 조회하기 
SELECT *
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 60
AND SALARY > ALL(SELECT SALARY
                FROM EMPLOYEES
                WHERE DEPARTMENT_ID = 30); --단일행 하위질의에 2개이상의 행이 리턴되었습니다. ERROR가 발생
--다중행함수로 변경후 ALL은 결과가 안나옴
--서브쿼리로 조회된 급여보다는 무조건 전체보다 높아야한다는 의미 ALL (11646보다 높아야 나옴)
--위와 아래와 동일함
--30번 부서에 소속된 모든 직원의 급여보다 급여를 많이 받는 60번 부서 소속의 직원을 조회하기 
--30번 부서에 소속된 직원의 최대급여보다 급여를 많이 받는 60번 부서 소속의 직원을 조회하기
SELECT *
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 60
AND SALARY > (SELECT MAX(SALARY)
                FROM EMPLOYEES
                WHERE DEPARTMENT_ID = 30);
--30번 부서에 소속된 직원 중 아무나 한 명의 급여보다 급여를 많이 받는 60번 부서 소속의 직원을 조회하기 
--30번 부서에 소속된 직원의 최소급여보다 급여를 많이 받는 60번 부서 소속의 직원을 조회하기

SELECT *
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 60
AND SALARY > ANY(SELECT SALARY
                FROM EMPLOYEES
                WHERE DEPARTMENT_ID = 30);
                
 --다중행함수로 변경후 ALL은 결과가 안나옴
 --ANY는 서브쿼리중 하나라도 높으면 나옴 
 --30번 부서에 소속된 직원 중 아무나 한 명의 급여보다 급여를 많이 받는 60번 부서 소속의 직원을 조회하기 
--30번 부서에 소속된 직원의 최소급여보다 급여를 많이 받는 60번 부서 소속의 직원을 조회하기
 SELECT *
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 60
AND SALARY > (SELECT MIN(SALARY)
                FROM EMPLOYEES
                WHERE DEPARTMENT_ID = 30);
--서로 ANY와 MIN과 동일함 서로 저런 형식으로 변경해도 됨  ALL보다는 MAX가 더 보일 수 있음
--ANY보다는 MIX를 사용하는 것이 가독성을 위해서라도 더 좋음

---------------------------------------------------------------------------------------------
-- 다중열 서브쿼리 
--SELECT *
--FROM TABLE
--WHERE (COL1, COL2) IN (SELECT COL3, COL4
--                          FROM TABLE)
--여러열을 연결하고, 연산자는 IN을 사용함 
--언제사용이 가능할까?

--부서별 최저 급여를 조회하기 
SELECT DEPARTMENT_ID, MIN(SALARY)
FROM EMPLOYEES
WHERE DEPARTMENT_ID IS NOT NULL
GROUP BY DEPARTMENT_ID
ORDER BY DEPARTMENT_ID;

--자신이 소속된 부서에서 최저급여를 받는 사원의 부서아이디, 사원아이디, 급여를 조회하기 
--부서에서의 최저급여받는 사람을 서브쿼리로 둬서 사원을 비교하여 조회하겠다
SELECT DEPARTMENT_ID, EMPLOYEE_ID, FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE (DEPARTMENT_ID, SALARY) IN(SELECT DEPARTMENT_ID, MIN(SALARY)
                                    FROM EMPLOYEES
                                    WHERE DEPARTMENT_ID IS NOT NULL
                                    GROUP BY DEPARTMENT_ID)
ORDER BY DEPARTMENT_ID ASC;

--------------------------------------------------------------------------------
--HAVING 절에서 서브쿼리 사용하기 
--HAVING절에서 부서별 사원수를 조회했을 때 사원수가 5명이하인 부서의 아이디와 사원수를 조회하기 
SELECT DEPARTMENT_ID, COUNT(*)
FROM EMPLOYEES
WHERE DEPARTMENT_ID IS NOT NULL
GROUP BY DEPARTMENT_ID
HAVING COUNT(*) <= 5
ORDER BY 1;
--그룹그룹을 지어놓고 COUNT를 적용시켜서 사용함 5명이하는 HAVING을 사용해서 출력함
--부서별 사원수를 조회했을 때 사원수가 가장 많은 부서의 아이디와 사원수를 조회하기 

SELECT MAX(COUNT(*))
FROM EMPLOYEES
WHERE DEPARTMENT_ID IS NOT NULL --COUNT 2번 진행하게 됨
GROUP BY DEPARTMENT_ID; -- 일단 부서별로 사원을 조회해야하기 때문에 여기까지는 사용해야함, 여기서 제일 많은 부서를 찾아야함

SELECT DEPARTMENT_ID, COUNT(*)
FROM EMPLOYEES
WHERE DEPARTMENT_ID IS NOT NULL
GROUP BY DEPARTMENT_ID      --COUNT1번
HAVING COUNT(*) =(45); ----위와 아래를 합쳐줘야한다. COUNT도 2번진행하게 됨

SELECT DEPARTMENT_ID, COUNT(*)
FROM EMPLOYEES
WHERE DEPARTMENT_ID IS NOT NULL
GROUP BY DEPARTMENT_ID      --COUNT1번
HAVING COUNT(*) =(SELECT MAX(COUNT(*))
                FROM EMPLOYEES
                WHERE DEPARTMENT_ID IS NOT NULL
                 GROUP BY DEPARTMENT_ID); --이렇게 작성은 해서 결과는 나왔지만 GROUP BY을 2번작동
                 
--WITH절
--SQL의 실행결과를 지정된 이름으로 캐싱 (임시보관) 한다. 
--서브쿼리를 사용하는 SQL문에서 반복적으로 실행되는 SQL에 대해서 WITH절을 사용하면 실행 성능이 향상된다. 
--WITH절에서 정의한 가상의 테이블의 아래 SELECT문에서 사용할 수 있다. 
--WITH절은 단독으로 사용할 수 없다. 
--WITH  별칭1
--AS (SELECT 문),
--별칭2
--AS (SELECT 문)
--SELECT COL, COL
--FROM 별칭1나 별칭2를 가져와서 사용하면 된다. 
--WHERE 조건식
--WITH절을 사용해서 부서별 사원수를 조회했을 때 사원수가 가장 많은 부서의 아이디와 사원수를 조회하기 
WITH DEPT_EMP_CNT --가상의 테이블이 아래같이 생김
AS ( --SQL실행결과를 위의 별칭으로 저장함 가상의 뷰가 자지고 있음
    SELECT DEPARTMENT_ID AS DEPT_ID, COUNT(*) AS CNT
    FROM EMPLOYEES
    WHERE DEPARTMENT_ID IS NOT NULL
    GROUP BY DEPARTMENT_ID
),  --,를 이용하여 추가로 만들어도 된다.
    JOB_EMP_CNT 
    AS(
    SELECT JOB_ID, COUNT(*) AS CNT
    FROM EMPLOYEES
    GROUP BY JOB_ID
    )--연결이 되어있지 않기 때문에 사용은 할 수 없지만 복수개를 사용해도 된다. 
SELECT DEPT_ID, CNT --WITH절을 이용하여 아이디와 DEPT_ID와 CNT를 별칭을 작성함
FROM DEPT_EMP_CNT--WITH절에 설정한 가상의 테이블을 가져옴
WHERE CNT = (SELECT MAX(CNT)
FROM DEPT_EMP_CNT);
