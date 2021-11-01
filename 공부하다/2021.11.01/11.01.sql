--상호연관 서브쿼리 
--메인 쿼리의 컬럼을 참조하는 서브쿼리 
--메인 쿼리의 조회된 각 행마다 한번씩 실행된다. 
--메인쿼리의 행의 결과가 10 인경우 서브쿼리도 10번 실행이 된다. 
--(각 행마다 조건식이 실행된다.)
--WHERE 조건식의 연산결과가 TRUE로 판정되는 행만 최종적으로 조회된다. 

--ex) 직원들의 직종아이디별 평균급여를 조회했을 대 자식이 속한 직종아이디의 
--평균 급여보다 급여를 많이 받는 사원의 아이디, 이름 급여를 조회하기 

SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID, SALARY
FROM EMPLOYEES X--사원을 조회, 행이 107개가 존재
WHERE SALARY > (SELECT AVG(SALARY)
    FROM EMPLOYEES Y
    WHERE Y.JOB_ID = X.JOB_ID--여기에 직종아이디가 들어가야함 , 외부 행의 107를 사용하고 싶음
    --JOB_ID 의 평균에 대해서 계산을 각기 진행하는 것, 각 행마다 실행되는 것이 중요함
    ); --자신이 속한 직종아이디의 평균급여보다 많이 받는 사람들 , 매행마다 사용됨, X의 행의 갯수만큼 107번 실행됨
--상호연관 서브쿼리라고 함, 

-- 관리자의 아이디, 이름, 직종아이디, 해당 관리자의 관리하는 직원의 수를 조회하기 
SELECT X.EMPLOYEE_ID,X.FIRST_NAME, X.JOB_ID, --COUNT(*)는 ERROR남
(SELECT COUNT(*) FROM EMPLOYEES Y WHERE Y.MANAGER_ID = X.EMPLOYEE_ID) CNT --처음 매니저 ID가 100,101,102번째의 직원의 수를 COUNT함
FROM EMPLOYEES X
WHERE X.EMPLOYEE_ID IN (SELECT DISTINCT MANAGER_ID
FROM EMPLOYEES 
WHERE MANAGER_ID IS NOT NULL); --매니저의수가 출력됨

SELECT COUNT(*)
FROM EMPLOYEES
WHERE MANAGER_ID = 100;--100Q번이 관리하는 사원의 수가 출력됨

--인라인 뷰로 작성함
SELECT X.EMPLOYEE_ID,X.FIRST_NAME, X.JOB_ID, 
(SELECT COUNT(*) FROM EMPLOYEES Y WHERE Y.MANAGER_ID = X.EMPLOYEE_ID) CNT
FROM EMPLOYEES X , (SELECT MANAGER_ID, COUNT(*) CNT
                    FROM EMPLOYEES
                    GROUP BY MANAGER_ID ) Y
WHERE X.EMPLOYEE_ID = Y.MANAGER_ID 
AND X.EMPLOYEE_ID IN (SELECT DISTINCT MANAGER_ID
FROM EMPLOYEES 
WHERE MANAGER_ID IS NOT NULL);
------------------------------------------------------------------------------
--어디에서 많이 사용될까?
--게시글의 댓글을 표시할 때 사용됨, 게시글 테이블만들때부터 댓글, 평점에 대한 칸을 추가해서 연산해서 반영시켜 COUNT가 되도록 작성함
--게시글 테이블에 좋아요, COLUMN을 생성시켜서, INSERT시 변경될 수 있도록 변경하는 것이 중요하다. 
--상호연관커리는 쉽게 사용할 것이 아니다. 

------------------------------------------------------------------------------
--TOP-N분석 
--테이블의 행을 특정 컬럼의 값을 기준으로 정렬했을 때 지정된 순위에 포함되는 행을 조회하는것 
--급여를 많이 받는 사람 3명, 급여를 제일 적게 받는 사람 3명 조회시 사용함 
--ROWNUM(의사 컬럼 :Pseudo column) :조회된 결과에 대해서 순번을 붙이는 컬럼이다. 


--직원들 중에서 급여를 가장 많이 받는 상위 5명의 직원을 조회하기, 직원아이디, 이름, 급여 

SELECT ROWNUM, EMPLOYEE_ID, FIRST_NAME, SALARY --ROWNUM으로 숫자가 부여됨을 확인, 숫자순위를 찾으면됨
FROM
(SELECT EMPLOYEE_ID, FIRST_NAME, SALARY
FROM EMPLOYEES
ORDER BY SALARY DESC) --내림차순으로 인라인뷰로 정렬함
WHERE ROWNUM <= 5; --ROWNUMB은 가상의 테이블에 대해서 순번을 매겼을 때 5개까지만 가져와라.
--순번이 매겨진것에서 가져오는 것이 아닌 가상의 테이블에서 순번을 IF매기면 5개까지만 가져오라는 WHERE절
--SELECT ROWNUM따로 작성하지 않아도 상관없음, 단지 보여주기 위함으로 작성함.

SELECT EMPLOYEE_ID, FIRST_NAME, SALARY --ROWNUM으로 숫자가 부여됨을 확인, 숫자순위를 찾으면됨
FROM
(SELECT EMPLOYEE_ID, FIRST_NAME, SALARY
FROM EMPLOYEES
ORDER BY SALARY DESC) --내림차순으로 인라인뷰로 정렬함
WHERE ROWNUM <= 5; --의사컬럼(Pseudocolumns)으로 조회되는 행에 대해서 순서가 부여되는 컬럼이지만, 허위의 컬럼이라는 의미다.
--같은 값이 나오는 것을 확인 할 수 있음, 

--관리하는 직원수가 가장 많은 상위 3명의 관리자 아이디와 관리하는 직원수를 조회하기 

SELECT MANAGER_ID, CNT
FROM (SELECT MANAGER_ID, COUNT(*) CNT
        FROM EMPLOYEES
        GROUP BY MANAGER_ID
        ORDER BY CNT DESC)
WHERE ROWNUM <= 3; --상위를 ROWNUM으로 가져오는 것은 2위가 5그룹으로 중복이 되면 3그룹이 누락이 될 수 있음
--이런문제를 극복하고 싶음  -->RANK가 등장함 
------------------------------------------------------------------------------
--분석함수를 사용해서 행을 조회하기 

--급여를 기준으로 내림차순 정렬한 다음, 조회된 행에 순위 혹은 순번을 부여한다. 
SELECT SALARY, 
        RANK() OVER (ORDER BY SALARY DESC) "RANK",
        DENSE_RANK() OVER(ORDER BY SALARY DESC) "DENSC_RANK",
        ROW_NUMBER() OVER(ORDER BY SALARY DESC) "ROW_NUMBER"
FROM EMPLOYEES;
--RANC() -- 중간에 중복이 있으면 1,2,2,4 , 순위가 빠질 수 있음 --3등까지 출력시 3개
--DENSE_RANK() -- 중복이 있어도 순위가 빠지지 않음 1,2,2,3,4,5 (연속적인 출력) --3등까지 출력시 4개
--순위가 달라짐 
--ROW_NUMBER() --중복과 순위가 상관없이 1부터 쭉 출력됨 --같은 값이 나오지 않음

--PARTITION BY 컬럼명을 사용하면 지정된 컬럼명내에서 급여를 기준으로 내림차순으로 정렬한 다음 조회된 행에 순위 혹은 순번을 부여한다. 
SELECT DEPARTMENT_ID, SALARY, 
        RANK()      OVER(PARTITION BY DEPARTMENT_ID ORDER BY SALARY DESC) "RANK",
        DENSE_RANK() OVER(PARTITION BY DEPARTMENT_ID ORDER BY SALARY DESC) "DENSC_RANK",
        ROW_NUMBER() OVER(PARTITION BY DEPARTMENT_ID ORDER BY SALARY DESC) "ROW_NUMBER"
FROM EMPLOYEES;

--PARTITION BY를 사용하면 그 안에서 순위를 매기는 방법, 컬럼값을 기준으로 DEPARTMENT_ID로 나눈 후 
--그 내에서 순위를 매기는 방법 --사용시에 좋은점
--직원들의 급여를 내림차순으로 정렬했을 때 순위 7위까지 조회하기, RANK() 함수
SELECT *
FROM (SELECT RANK() OVER(ORDER BY SALARY DESC) SALARY_RANK,
            EMPLOYEE_ID,
            FIRST_NAME,
            SALARY
            FROM EMPLOYEES)
WHERE SALARY_RANK <= 7; --조회된 행의 갯수 : 8개
--직원들의 급여를 내림차순으로 정렬했을 때 순위 7위까지 조회하기 
SELECT *
FROM (SELECT DENSE_RANK() OVER(ORDER BY SALARY DESC) SALARY_RANK,
            EMPLOYEE_ID,
            FIRST_NAME,
            SALARY
            FROM EMPLOYEES)
WHERE SALARY_RANK <= 7; --7위까지 구했는데, --조회된 행의 갯수 : 9개
--상황에 맞게 사용하면 된다. 

--직원들의 급여를 내림차순으로 정렬했을때 7번째 행까지 조회하기 
SELECT *
FROM (SELECT ROW_NUMBER() OVER(ORDER BY SALARY DESC) SALARY_RANK,
            EMPLOYEE_ID,
            FIRST_NAME,
            SALARY
            FROM EMPLOYEES)
WHERE SALARY_RANK <= 7; -- 조회된 행의 갯수 : 7개 확실하게 7개의 값이 출력된다. 

--TOP-N분석은 중간값을 출력할 수 없다. 분석함수를 사용하면,  중간값을 출력할 수 있다. 
--직원들의 급여를 내림차순으로 정렬했을때 11~20위까지 조회하기 
SELECT *
FROM (SELECT DENSE_RANK() OVER(ORDER BY SALARY DESC) SALARY_RANK,
            EMPLOYEE_ID,
            FIRST_NAME,
            SALARY
            FROM EMPLOYEES)
WHERE SALARY_RANK >= 11 AND SALARY_RANK <= 20 ;  --조회된 행의 갯수 : 21개

--직원들의 급여를 내림차순으로 정렬했을때 11~12위까지 조회하기 
SELECT *
FROM (SELECT ROW_NUMBER() OVER(ORDER BY SALARY DESC) SALARY_RANK,
            EMPLOYEE_ID,
            FIRST_NAME,
            SALARY
            FROM EMPLOYEES)
WHERE SALARY_RANK >= 11 AND SALARY_RANK <= 20 ; -- 조회된 행의 갯수 :항상 10개
--행의 갯수만큼만 조회시 

--직원들의 급여를 내림차순으로 정렬했을때 11~12위까지 조회하기 
SELECT *
FROM (SELECT RANK() OVER(ORDER BY SALARY DESC) SALARY_RANK,
            EMPLOYEE_ID,
            FIRST_NAME,
            SALARY
            FROM EMPLOYEES)
WHERE SALARY_RANK >= 11 AND SALARY_RANK <= 20 ; --통계의 결과를 표시할 때 , 조회된 행의 갯수 10개
--WEB에서 PAGING처리시 이 함수를 많이 사용한다. 
----------------------------------------------------------------------------
--계층 검색
--계층형 쿼리를 이용해서 상/하 관계에 있는 데이터를 조회한다. 

--100번 직원의 하위에 위치하고 있는 직원 조회하기 
SELECT LEVEL, EMPLOYEE_ID, LPAD('-',(LEVEL-1)*5,'-') || FIRST_NAME
FROM EMPLOYEES
START WITH EMPLOYEE_ID = 100
CONNECT BY PRIOR EMPLOYEE_ID = MANAGER_ID AND LEVEL <= 2; --CONNECT BY에 또 다른 조건을 붙일 수 있다.

--101번 직원의 하위에 위치하고 있는 직원 조회하기 
SELECT LEVEL, EMPLOYEE_ID, LPAD('-',(LEVEL-1)*5,'-') || FIRST_NAME
FROM EMPLOYEES
START WITH EMPLOYEE_ID = 101 
CONNECT BY PRIOR EMPLOYEE_ID = MANAGER_ID AND LEVEL <= 2; --니나다음인 LEVEL 2까지만 설정가능함

-- 205번 직원의 상위에 위치하고 있는 매니저 조회하기 
SELECT LEVEL , EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
START WITH EMPLOYEE_ID = 205
CONNECT BY PRIOR MANAGER_ID = EMPLOYEE_ID;
--자기자신이 제일 TOP LEVEL, 상사순위가 LEVEL에서 깊어진다. 
--SHELLY - >NEENA - >STEVEN 
------------------------------------------------------------------------------
--LEVEL과 CONNECT BY로 연속된 숫자/ 날짜 생성하기 
--START WITH없이 CONNECT BY만 존재함 

SELECT LPAD(LEVEL,2,'0') MONTH
FROM DUAL
CONNECT BY LEVEL <= 31; --0시부터 24시까지 값이 출력되게 하려면 이런 방법으로 연속된 숫자를 출력할 수 있다. 

--2004년에 입사한 직원들이 월별로 몇명씩 입사했는지 조회하기 
SELECT TO_NUMBER(Y.MONTH) MONTH, NVL(X.CNT,0) CNT --NULL이없는 Y의 MONTH를 출력하고, NULL값은 0으로 변경함
FROM (SELECT TO_CHAR(HIRE_DATE, 'MM') MONTH, COUNT(*) CNT
      FROM EMPLOYEES --월별로 입사한 부분을 출력함 --중간에 빠질 수 있음
      WHERE HIRE_DATE > '2004/01/01' AND HIRE_DATE < TO_DATE('2004/12/31') + 1
      GROUP BY TO_CHAR(HIRE_DATE, 'MM')) X, 
     (SELECT LPAD(LEVEL, 2, '0') MONTH
      FROM DUAL
      CONNECT BY LEVEL <= 12) Y --1~12월까지 출력되는 부분(무조건) : 인라인뷰 서브쿼리 
WHERE X.MONTH(+) = Y.MONTH --NULL값이 포함될 수 있도록 OUTER JOIN을 이용하여 출력함, Y에 있는것을 다나오게 하기 위해서 (+)사용함
ORDER BY Y.MONTH ASC;

--물건이 중간에 빠지고 들어왔지만 빠진날짜없이 전체 출력으로 특정날짜를 출력하고 싶음
--2021/10/01~2021/10/31사이의 날짜를 생성하기 
SELECT TO_DATE('2021/10/01','YYYY/MM/DD') + LEVEL -1
FROM DUAL 
CONNECT BY LEVEL <= TO_DATE('2021/10/31') - TO_DATE('2021/10/01')+1;
--연속된 날짜, 연속된 월, 누락된 날짜, 누락된 월을 표시하고 싶을 때 유용하게 사용할 수 있다. 
--관리자프로그램상에서 매출액을 표현하는 부분시 표현할때 유용하게 사용가능함

--직원들 급여 1000달러 단위로 구분해서 급여별 인원수를 조회하기 
SELECT Y.SALARY, NVL(CNT, 0) NVL
FROM (SELECT TRUNC(SALARY,-3) SALARY , COUNT(*) CNT
                FROM EMPLOYEES 
                GROUP BY TRUNC(SALARY, -3)) X, --직원급여 구하는 공식
            (SELECT LEVEL*1000 SALARY 
                FROM DUAL --1000부터 24000까지나오는 공식을 LEVEL *1000으로 1을 1000부터로 만들었다. 
                CONNECT BY LEVEL <= 24 ) Y
 WHERE X.SALARY(+) = Y.SALARY
ORDER BY 1; --값이 누락되지않고 결과를 얻어낼 수 있는, 그래프나 차트를 그릴때 사용할 수 있다. 

SELECT LPAD(SALARY/1000,2,'*')
FROM EMPLOYEES;

------------------------------------------------------------------------------------------
--사용자 생성 및 권한관리 