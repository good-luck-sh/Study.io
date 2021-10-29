--VIEW(가상의 테이블 )정의하기 
CREATE OR REPLACE VIEW EMP_SALARY_DETAIL_VIEW
AS
SELECT E.EMPLOYEE_ID, E.FIRST_NAME, E.JOB_ID, E.DEPARTMENT_ID, D.DEPARTMENT_NAME, E.COMMISSION_PCT, S.GRADE,
    E.SALARY*12+E.SALARY*NVL(COMMISSION_PCT, 0)*12 ANNUAL_SALARY
FROM EMPLOYEES E, DEPARTMENTS D , SALARY_GRADE S
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID
AND E.SALARY >= S.MIN_SALARY AND E.SALARY <= S.MAX_SALARY
WITH READ ONLY;
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID, DEPARTMENT_ID, DEPARTMENT_NAME, COMMISSION_PCT, GRADE, annual_SALARY
FROM EMP_SALARY_DETAIL_VIEW;
--모든 사원의 사원아이디, 이름, 직종아이디, 부서아이디, 부서명, 급여, 커미션, 급여등급, 연봉
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID, DEPARTMENT_ID, DEPARTMENT_NAME, COMMISSION_PCT, GRADE, annual_SALARY
FROM EMP_SALARY_DETAIL_VIEW
WHERE EMPLOYEE_ID = 100;

--전달 받은 사원아이디에 해당하는 사원의 사원아이디, 이름, 직종아이디, 부서아이디, 부서명, 급여, 커미션, 급여등급, 연봉
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID, DEPARTMENT_ID, DEPARTMENT_NAME, COMMISSION_PCT, GRADE, annual_SALARY
FROM EMP_SALARY_DETAIL_VIEW
WHERE DEPARTMENT_ID = 50;
--전달 받은 부서아이디에 소속되어 있는 사원의 사원아이디, 이름, 직종아이디, 부서아이디, 부서명, 급여, 커미션, 급여등급, 연봉
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID, DEPARTMENT_ID, DEPARTMENT_NAME, COMMISSION_PCT, GRADE, annual_SALARY
FROM EMP_SALARY_DETAIL_VIEW
WHERE GRADE = 'C';
--전달 급여등급에 해당하는 사원의 사원아이디, 이름, 직종아이디, 부서아이디, 부서명, 급여, 커미션, 급여등급, 연봉

--사원아이디, 사원의 전체이름, 전화번호, 이메일, 입사일, 직종아이디, 급여, 급여등급, 연봉, 부서아이디, 부서명, 근무지역
-- E               E           E         E     E      J        E      S       E      E           D       L
--관리자 아이디, 관리자명
--    E            E
CREATE OR REPLACE VIEW EMP_DETAILS_VIEW
AS 
SELECT 
    EMP.EMPLOYEE_ID     AS EMP_ID,
    EMP.FIRST_NAME || ' ' || EMP.LAST_NAME    AS EMP_NAME,
    EMP.PHONE_NUMBER        AS EMP_TEL,
    EMP.EMAIL           AS EMP_EMAIL,
    EMP.HIRE_DATE       AS EMP_HIRE_DATE,
    EMP.JOB_ID          AS EMP_JOB_ID,
    J.JOB_TITLE         AS EMP_JOB_TITLE,
    EMP.SALARY          AS EMP_SALARY,
    EMP.COMMISSION_PCT  AS EMP_COMMISSION,
    S.GRADE             AS EMP_SALARY_GRADE,
    EMP.SALARY*12 + EMP.SALARY*NVL(EMP.COMMISSION_PCT, 0)*12  AS EMP_ANNUAL_SALARY,
    D.DEPARTMENT_ID           AS EMP_DEPT_ID,
    D.DEPARTMENT_NAME           AS EMP_DEPT_NAME,
    L.CITY                      AS EMP_CITY,
    MGR.EMPLOYEE_ID             AS MGR_ID,
    MGR.FIRST_NAME || ' ' || MGR.LAST_NAME AS MGR_NAME
FROM
EMPLOYEES EMP,      --직원테이블
DEPARTMENTS D,      --부서테이블
JOBS J,         --직종테이블
EMPLOYEES MGR, -- 관리자 테이블
LOCATIONS L,    --근무지 테이블
SALARY_GRADE S      --급여등급테이블
WHERE 
EMP.JOB_ID = J.JOB_ID       -- 직원의 직종아이디와 직종테이블의 직종아이디가 동일한 행끼리 연결
AND EMP.SALARY >= S.MIN_SALARY AND EMP.SALARY <= S.MAX_SALARY -- 직원의 급여가 급여등급테이블의 최소급여, 최대급여 범위내에 위치하는 행끼리 연결
AND D.LOCATION_ID = L.LOCATION_ID (+)  --직원이 소속된 부서의 위치아이디와 근무지 테이블의 위치아이디가 동일한 행끼리 연결
AND EMP.DEPARTMENT_ID = D.DEPARTMENT_ID(+) -- 직원의 소속부서아이디와 부서테이블의 부서아이디가 동일한 행끼리 연결
AND EMP.MANAGER_ID = MGR.EMPLOYEE_ID(+) --직원의 관리자 아이디와 관리자 테이블의 아이디가 동일한 행끼리 연결
WITH READ ONLY;
