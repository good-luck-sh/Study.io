--문자함수 
--대/소문자 변환
SELECT FIRST_NAME, LOWER(FIRST_NAME), UPPER(FIRST_NAME)
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 60;

--문자열 잘라내기 
--SUBSTR(컬럼명, 시작위치) : 시작위치부터 끝까지 잘라낸다.
--SUBSTR(컬럼명, 시작위치, 길이) : 시작위치부터 지정된 길이만큼 잘라낸다.
SELECT JOB_ID, SUBSTR(JOB_ID, 1, 2) , SUBSTR(JOB_ID, 4)
FROM JOBS;

--문자열 길이 조회하기 
--LENGTH(컬럼명)  : 해당 컬럼에 저장된 값의 길이를 반환한다. 
SELECT JOB_ID, LENGTH(JOB_ID)
FROM EMPLOYEES
ORDER BY LENGTH(JOB_ID) DESC;

SELECT JOB_ID, LENGTH(JOB_ID) JOB_ID_LENGTH
FROM EMPLOYEES
ORDER BY JOB_ID_LENGTH DESC; --위에 보다는 이 부분이 한번만 계산할 수 있어서 더 이득임 


SELECT JOB_ID, LENGTH(JOB_ID) JOB_ID_LENGTH
FROM EMPLOYEES
ORDER BY 2 DESC;

-- 문자열 채우기
--LPAD (컬럼명, 전체길이, '패딩문자') : 문자열의 길이가 전체길이만큼 되도록 왼쪽에 패딩문자를 채운다.
--RPAD (컬럼명, 전체길이, '패딩문자') : 문자열의 길이가 전체길이만큼 되도록 오른쪽에 패딩문자를 채운다.
SELECT FIRST_NAME, LPAD(FIRST_NAME, 15, '*'), RPAD(FIRST_NAME, 15, '*')
FROM EMPLOYEES; --LPAD는 왼쪽으로 ,RPAD는 오른쪽으로 글자가 15글자가 안될 경우 나머지는 *로 표현한다.

SELECT LPAD('1234', 10, '0'), LPAD('12', 10, '0'), LPAD(123456,10,'0')
FROM DUAL; --10자에서 나머지는 전부 0으로 채워라 


--DUAL은 오라클에 내장된 1행 1열짜리 테이블이다. 
--DUMMY 라는 테이블이름을 가지고 있고, 간단한 연산의 결과를 조회할 경우 테이블이름을 조회해야할텐데, 
--SELECT는 다른 테이블을 적으면 조회한 행의 갯수만큼의 전체 값이 출력하게 된다. 
--그렇기 때문에 오라클에서 제공해준 1행 1열짜리 행이다.시스템 테이블에 있는 것 중에서 접근이 허용된 DUBBMY TABLE이다. 
SELECT * 
FROM DUAL; 

--문자열 연결하기 
--CONCENT (컬럼명1, 컬럼명 2 ) : 지정된 컬럼의 값들을 서로 이어붙인다. 
--컬럼명1|| 컬럼명2 || 컬럼명3 ||...||컬럼명 N : N개의 컬럼의 값들을 서로 이어붙인다. 
SELECT FIRST_NAME, LAST_NAME, CONCAT(FIRST_NAME, LAST_NAME), --딱 2개만 작성할 수 있다. 
FIRST_NAME || ' ' || LAST_NAME AS "연결" --이렇게 연결하면 여러개를 쓸 수 있기 때문에 이 방법을 추천한다. 
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 60;


--불필요한 공백 없애기 
--trim(컬럼명 ) : 지정된 컬럼의 값 왼쪽, 오른쪽에 위치한 무의미한 공백을 제거한다. 
SELECT trim ('                              abc             abc             abc             ')
from dual; --문자와 문자사이는 없앨 수 없다. 

--문자열 바꾸기 
--replace(컬럼명, 찾는 문자열, 대체할 문자열) : 지정한 컬럼에서 특정문자열을 찾아서 다른 문자열로 대체시킨다. 
SELECT FIRST_NAME, REPLACE(LOWER(FIRST_NAME), 'a', '*') --단일행함수는 중첩해서 사용할 수 있다. 
FROM EMPLOYEES;

--문자열 찾기 
--INSTR(컬럼명, '찾는 문자열') : 지정한 컬럼에서 찾는 문자의 위치를 반환한다. 
SELECT FIRST_NAME, INSTR(FIRST_NAME, 'e') 
FROM EMPLOYEES;
--원래 사용하던 글자를 찾는 것이 아닌, 문자가 들은게 몇개인지 출력하는 기능
-----------------------------------------------------------------------------
-- 숫자 함수 
-- 반올림하기(컬럼명) : 숫자를 일의 자리까지로 반올림한다. 
-- 반올림하기 (컬럼명, 자리수) : 숫자를 지정된 자리수까지 반올림한다.
                            -- 자리수가 양의 정수면 소숫점 자리수'
                            -- 자리수가 음의 정수면 일의 자리, 십의 자리, 백의 자리 등으로 반올림한다. 
                            --                      -1        -2          -3
SELECT ROUND(123.45), ROUND(123.45, 1),ROUND(123.45, 0),ROUND(123.45, -1), ROUND(123.45, -2)
FROM DUAL; --123, 123.5,123,120,123.45  -를 붙이면 10의 자리 100의 자리로 표현된다. 

--소수점값 버리기  
--TRUNC(컬럼명) : 소수점부를 반올림 하지 않고, 무조건 버린다. 
SELECT ROUND(123.45), ROUND(123.55) , TRUNC(123.45), TRUNC(123.55)
FROM DUAL; --ROUND는 반올림으로 소수점을 없애지만 TRUNC의 경우 증가 없이 소수점값을 버린다.

--천장값과 바닥값 구하기 
-- CEIL : 자신보다 큰 정수 중에서 가장 작은 수를 반환한다. 
-- FLOOR : 자신보다 작은 정수 중에서 가장 큰 정수를 반환한다. 
SELECT ROUND(2.6), TRUNC(2.6), CEIL(2.6), FLOOR(2.5)
FROM DUAL;
--반올림 값이기 때문에 ROUND 는 3이출력, TRUNC는 그냥 잘라내기로 2가 출력, CEIL은 2.6보다 가장 큰 정수값에서 가장 작은 수이니까 3이반환
--FLOOR은 2.5에서 자신보다 작은 정수중 에서 가장 큰 정수를 반환하니까 2의 값이 출력된다. 

--나머지 구하기 
-- MODE(숫자1, 숫자2) : 첫번째 숫자를 두번째 숫자로 나눗셈을 수행하고, 나머지를 반환한다.
SELECT MOD(10,3) , MOD(5,3)
FROM DUAL; -- JAVA에서는 % 연산자와 동일함 , 이런연산을 MODULAR연산자라고 한다. 

----------------------------------------------------------------------------------------------
--닐짜 함수 :괄호가 없는 함수는 인자가 없는 함수이다. 따로 입력하지 않는다. 인자를 전달하는 경우만()있다. 
--자바는 매개변수가 없어도 ()가 있지만 SQL은 다르다. 
--SYSDATE : 시스템의 현재 날짜와 시간정보를 반환하는 함수 
SELECT SYSDATE 
FROM DUAL; -- 환경 설정 변경 후 좀더 자세하게 출력되었다. 2021/10/25 11:15:24, 년월일시분초로 설정하였다 

--날짜 반올림 및 시간정보 지우기 
--ROUND(날짜) : 해당 날짜의 시간이 정오를 넘었을 경우 다음날 0시 0분 0초가 반환된다. 
--정오를 넘었기 때문에 2021/10/26 00:00:00의 값이 변경되었다. 
--TRUNC(날짜) : 해당 날짜의 모든 시간정보를 0으로 바꾼 값이 반환된다. 
--시간이 0으로 바뀌어서 2021/10/25 00:00:00의 값이 출력되었다. 
SELECT SYSDATE , ROUND(SYSDATE) AS TIMEPLUS, TRUNC(SYSDATE) AS ALLTIME
FROM DUAL;

-- MONTHS_BETWEEN(날짜1, 날짜2) : 두 날짜 사이의 개월수를 반환한다. 
SELECT FIRST_NAME, HIRE_DATE, MONTHS_BETWEEN(SYSDATE, HIRE_DATE)
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 60;
SELECT FIRST_NAME, HIRE_DATE, CEIL(MONTHS_BETWEEN(SYSDATE, HIRE_DATE)) AS MONTHS
--단일행함수 중첩으로 CEIL값으로 출력할 수 있다.  
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 60;

--ADD_MONTHS(날짜, 개월수) : 날짜에서 지정된 개월수만큼 변경된 날짜를 반환한다. 
SELECT SYSDATE , ADD_MONTHS(SYSDATE, -3), ADD_MONTHS(SYSDATE,3)
FROM DUAL; --(-3)넣으면 지금시점전의 개월수, +3을 넣게 되면 지금으로부터 3개월 후를 반환한다. 

--LAST_DAY(날짜) : 해당 날짜가 속한 달의 맨 마지막 날짜를 반환한다. 
SELECT SYSDATE, LAST_DAY(SYSDATE)
FROM DUAL; 
-- 그달의 마지막의 날을 출력한다. 시작날짜의 경우 1일부터 시작하지만 맨 마지막날짜는 각달마다 다르다.

--날짜 연산 
--날짜와 숫자로 연산 : 일수단위로 나눌 수 있게 됨
--날짜 + 숫자 : 날짜에서 지정된 숫자만큼 경과된 날짜를 반환한다. 
--날짜 - 숫자 : 날짜에서 지정된 숫자만큼 이전 날짜를 반환한다. 
--날짜 - 날짜 : 두 날짜 사이의 일수를 반환한다. 
--날짜 + 날짜 : 오류 
--숫자/24 : 시간단위로 나눌 수 있게 됨
--날짜 + 숫자/24 : 날짜에서 지정된 시간만큼 경과된 날짜를 반환한다. 
-- 연산에서 숫자는 하루를 의미한다. 숫자/24으로 나눌 경우 시간으로 들어간다. 
--날짜 - 숫자/24 : 날짜에서 지정된 시간만큼 이전 날짜를 반환한다. 
--시간의 경우 예금조회, 결제 날짜 조회등으로 많은 사용을 하게 된다. 기억을 하고 있는 편이 좋다. 
SELECT SYSDATE,
    SYSDATE + 1/24 AS "1시간 이후 날짜", 
    SYSDATE + 6/24 AS "6시간 이후 날짜",
    SYSDATE + 1 AS "하루 증가된 날짜",
    TRUNC(SYSDATE) - 3 AS "3일 전 날짜", -- 시간은 00: 00: 00으로 출력된다.  
    TRUNC(SYSDATE) - 7 AS "1주일 전 날짜" -- 시간은 00: 00: 00으로 출력된다.  
FROM DUAL;

SELECT FIRST_NAME, HIRE_DATE, TRUNC(SYSDATE)- HIRE_DATE AS "총 근무일 수 "
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 60;

-----------------------------------------------------------------------------------
-- 기타함수 
-- NVL(컬럼명, NULL일때 대체 할 값) : 지정된 컬럼값이 NULL일 때 대체값이 반환된다. NULL이 아니면 컬럼값이 반환된다. 
--                                컬럼값과 대체할 값은 데이터타입이 같은 값이다. 
--                                NULL값을 포함하는 사칙연산의 최종연산결과는 항상 NULL이다. 
                            --    사칙연산식에 NULL값을 포함하는 컬럼이 포함되어 있다면 
                            --    NVL함수를 사용해서 NULL값을 적절한 값으로 대체한 후 연산해야 된다. 
SELECT NVL(10, 0), NVL(NULL, 0) AS NULL -- 앞의값이 10이면 원래값이 출력, NULL로 지정시 0으로 출력된다. 
FROM DUAL;
--언제 사용할 까?
--모든 직원들의 이름, 급여, 커미션, 연봉을 조회하기 
--NULL값이 포함된 사칙연산에서 사용을 한다. NULL값이 포함될 경우 값이 이상하게 조회되기 때문이다.
--연봉 : 급여*12 + 급여*커미션*12
 SELECT FIRST_NAME, SALARY, COMMISSION_PCT, SALARY*12+SALARY*COMMISSION_PCT*12
 FROM EMPLOYEES;
 --어떤 값이던지 NULL + X = NULL, NULL - X = NULL, NULL * X = NULL, NULL / 10 = NULL 이다. 
 --그렇기 때문에 전체 연산의 결과가 NULL이 된다. 
 SELECT FIRST_NAME, SALARY, COMMISSION_PCT, SALARY*12+SALARY*NVL(COMMISSION_PCT, 0)*12
 FROM EMPLOYEES;
 --NULL값을 포함하고 있는 것을 NVL로 감싸서 대체할 값으로 입력하고 작성해주면 출력이 가능하다. 

--NVL2(컬럼명, 값1, 값2) : 지정된 컬럼의 값이 NULL이 아니면 값1, NULL이면 값2가 반환된다. 
--                      값1과 값2는 데이터 타입이 같은 값이다. 

--커미션 수령여부를 'YES/NO'값으로 조회하기 
SELECT FIRST_NAME, COMMISSION_PCT, NVL2(COMMISSION_PCT, 'YES', 'NO')
FROM EMPLOYEES;

--CASE ~ WHEN ~ THEH ~ ELSE(함수는 아님)
--CASE ~ WHEN 용법 1 (IF문과 유사)
--CASE
    -- WHEN 조건식1 THEN 표현식1   --조건식1이 참이면 표현식 1이 최종결과가 된다. 
    -- WHEN 조건식2 THEN 표현식2   --조건식2이 참이면 표현식 2이 최종결과가 된다. 
    -- WHEN 조건식3 THEN 표현식3   --조건식3이 참이면 표현식 3이 최종결과가 된다. 
    -- ELSE 표현식4               --조건식1, 조건식2, 조건식3이 모두 FALSE로 판정되면 표현식4의 최종결과가 된다. 
-- END

--CASE ~ WHEN 용법 2 (SWITCH문과 유사)
--CASE 값
    -- WHEN 값1 THEN 표현식1   -- 값이 값1과 일치하면 표현식 1이 최종결과가 된다. 
    -- WHEN 값2 THEN 표현식2   -- 값이 값2과 일치하면 표현식 2이 최종결과가 된다. 
    -- WHEN 값3 THEN 표현식3   -- 값이 값3과 일치하면 표현식 3이 최종결과가 된다. 
    -- ELSE 표현식4            --값1, 값2, 값3 이 모두 일치하지 않으면 표현식4의 최종결과가 된다. 
-- END

--급여에 따른 세금 계산하기 
-- 이름, 급여, 세금을 조회하기 
-- 세금은 20000달러 초과 : 50% , 15000달러 초과 40% , 10000달러 초과 30%, 5000달러 초과 20%, 그외 10%다.
SELECT FIRST_NAME, SALARY,
CASE 
    WHEN SALARY > 20000 THEN SALARY * 0.5
    WHEN SALARY > 15000 THEN SALARY * 0.4
    WHEN SALARY > 10000 THEN SALARY * 0.3
    WHEN SALARY > 5000 THEN SALARY * 0.2
    ELSE SALARY *0.1
    END AS TAX  --별칭을 입력시 END다음에 작성을 해야한다. CASE와 END까지가 하나의 표현식이다.
FROM EMPLOYEES
ORDER BY SALARY DESC;

--TB_SAMPLE_PRODUCTS 테이블에서 카테고리별 포인트 지급액을 조회하기 
--카테고리가 스마트폰인 경우 1000점, 노트북인 경우 500점, 가방인 경우 700점, 스마트 워치인 경우 600점 그외는 200점
SELECT PRODUCT_CATEGORY, PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_DISCOUNT_PRICE,
    CASE PRODUCT_CATEGORY
    WHEN '스마트폰' THEN 1000
    WHEN '노트북' THEN 500
    WHEN '가방' THEN 700
    WHEN '스마트 워치 ' THEN 600
    ELSE 200
    END AS POITNT
FROM TB_SAMPLE_PRODUCTS; 
--SWITCH문은 EQCUALS비교만 가능하다. 같다는 비교만 가능하다. 

-- SWITCH문과 유사한 형태를 가지고 있다면, DECODE를 많이 사용하지만, 
--대소관계를 비교할 경우 CASE~ WHEN~ THEN~ ELSE~ END를 많이 사용한다.

--DECODE 사용방법 1
--DECODE(컬럼명,  값1, 표현식1, -- 컬럼의 값이 값1과 일치하면 표현식1이 최종결과가 된다. 
--               값2, 표현식2, -- 컬럼의 값이 값2과 일치하면 표현식2이 최종결과가 된다. 
--               값3, 표현식3) -- 컬럼의 값이 값3과 일치하면 표현식3이 최종결과가 된다. 
--           컬럼의 값이 값1, 값2, 값3 모두와 일치하지 않으면 NULL이 최종결과가 된다.



--DECODE 사용방법 2
--DECODE(컬럼명,  값1, 표현식1, -- 컬럼의 값이 값1과 일치하면 표현식1이 최종결과가 된다. 
--               값2, 표현식2, -- 컬럼의 값이 값2과 일치하면 표현식2이 최종결과가 된다. 
--               값3, 표현식3, -- 컬럼의 값이 값3과 일치하면 표현식3이 최종결과가 된다. 
--                  표현식4)   -- 컬럼의 값이 값1, 값2, 값3 모두와 일치하지 않으면 표현식4가 최종결과가 된다. 

--TB_SAMPLE_PRODUCTS 테이블에서 카테고리별 포인트 지급액을 조회하기 
--카테고리가 스마트폰인 경우 1000점, 노트북인 경우 500점, 가방인 경우 700점, 스마트 워치인 경우 600점 그외는 200점

SELECT PRODUCT_CATEGORY, PRODUCT_NAME, PRODUCT_PRICE, 
        DECODE(PRODUCT_CATEGORY, '스마트폰',1000,
        '노트북', 500,
        '태블릿', 700,
        '스마트워치', 600 , 
         200) AS POINT
FROM TB_SAMPLE_PRODUCTS;

------------------------------------------------------------------------------------------
-- 변환함수 (데이터 형변환)
-- 오라클의 아래의 4가지 변환을 지원한다. 
-- NUMBER ->VARCHAR2 숫자 -> 문자
-- VARCHAR2-> NUMBER 문자 -> 숫자
-- 날짜 -> 문자
-- 문자 -> 날짜
-- 묵시적 변환 : RDBMS가 자동으로 데이터타입을 변환해주는 것
-- 명시적 변환 : 변환함수를 사용해서 데이터타입을 변환하는 것 

--묵시적 변환
SELECT '1000' * 10 , '1000'-10, '1000' + 10, '1000'/10      --문자'1000'이 숫자 1000으로 변환
FROM DUAL;

SELECT *
FROM EMPLOYEES
WHERE EMPLOYEE_ID = 100;                                    --숫자 100이 EMPLOYEE_ID의 타입과 같은타입으로 변환

SELECT *
FROM EMPLOYEES
WHERE EMPLOYEE_ID = '100';                                  --문자'100'이 EMPLOYEE_ID의 타입과 같은타입으로 변환
--위와 동일한 값이 찾아짐, 묵시적으로 문자를 숫자로 변경함
--묵시적 변환
SELECT *
FROM EMPLOYEES
WHERE HIRE_DATE >= '2007/01/01';-- 적어놓은것이 날짜형식에 맞으면 변환시켜줌, --문자 '2007/01/01'이 HIRE_DATE의 타입과 같 은타입으로 변환
SELECT *
FROM EMPLOYEES
WHERE HIRE_DATE >= '2007-01-01';-- 적어놓은것이 날짜형식에 맞으면 변환시켜줌 --문자 '2007-01-01'이 HIRE_DATE의 타입과 같 은타입으로 변환
SELECT *
FROM EMPLOYEES
WHERE HIRE_DATE >= '2007.01.01';-- 적어놓은것이 날짜형식에 맞으면 변환시켜줌--문자 '2007.01.01'이 HIRE_DATE의 타입과 같 은타입으로 변환
--연산의 적합한 타입으로 값이 변환되는 것

--명시적 변환
--포맷팅된 문자 --> 숫자 : TO_NUMBER('포맷팅된 문자','패턴')
SELECT TO_NUMBER('1,000','9,999') * 10 -->TO_CHAR('문자','패턴')은 문자가 지정된 패턴의 숫자형식일 때  숫자로 변환      
FROM DUAL; 

--명시적 형변환
--숫자 -> 포맷팅된 문자 : TO_CHAR(숫자,'포맷팅패턴')
--패턴 문자 : 0 숫자 하나와 대응, 정수부에서 해당 자리에 숫자가 없어도 0이 출력된다. 
--패턴 문자 : 9 숫자 하나와 대응, 정수부에서 해당 자리에 숫자가 없으면 출력되지 않는다. 
--패턴 문자 : , 자리수 
--패턴 문자 : . 소수점
SELECT TO_CHAR(1000000000,'9,999,999,999'), TO_CHAR(10000,'9,999,999'),TO_CHAR(1000,'0,000,000')
FROM DUAL; 
--9의 형태와 숫자가 변환할 갯수만큼 있어야한다. 
--9로 작성해도되고, 0으로 작성해도 되지만, 0으로 작성하면 남은자리에 0을 입력한다. 
--소수점을 이용할때, 정밀도를 위해서 0을 작성 정수를 다룰때는 9를 입력하는 것이 좋다
-- 명시적 형변화 
SELECT TO_CHAR(123.456,'999.99'), TO_CHAR(123.456,'000.00'), TO_CHAR(123.4,'999.99'), TO_CHAR(123.4,'000.00')
FROM DUAL;
--정수에는 9와 0이 차이점이 있지만 소수점 이하로는 동일하게 표현된다. 

--명시적 형변환
--날짜 -> 포맷팅된 문자열  : 원하는 포맷형태로 바꿀 수 있다. 
--패턴 문자 : yyyy혹은 YYYY 년 
--패턴 문자 : mm혹은 MM     월
--패턴 문자 : DD혹은 dd     일
--패턴 문자 : am혹은 AM     오전/오후
--패턴 문자 : HH혹은 hh     시간(1~12)
--패턴 문자 : hh24혹은 HH24 시간(0~23)
--패턴 문자 : MI혹은 mi      분
--패턴 문자 : SS혹은 ss      초

--날짜 - >포맷팅된 문자
SELECT SYSDATE, TO_CHAR(SYSDATE,'yyYY/MM/DD'), TO_CHAR(SYSDATE, 'HH24:MI:SS'),TO_CHAR(SYSDATE,'AM HH:MI:SS')
FROM DUAL;                  --대/소문자 구별하지 않음, 24시 분초, 오전/오후 시분초 , 무조건 갯수는 2개를 적어야한다. 

--포맷팅된 문자 -> 날짜 (오늘날짜부터 TO_DATE의 설정날짜를 뺌) :24.67819444444444444444444444444444444444
SELECT SYSDATE - TO_DATE('2021/10/01')
FROM DUAL;

--2007년 상반기에 입사한 사원들의 목록을 조회
SELECT *
FROM EMPLOYEES
WHERE HIRE_DATE >= '2007/01/01' AND HIRE_DATE < '2007/07/01';
--2007년 상반기에 입사한 사원들의 목록을 조회
SELECT *
FROM EMPLOYEES
WHERE HIRE_DATE >= '2007/01/01' AND HIRE_DATE < TO_DATE('2007/06/30') + 1; -- 6/30 00시 00분 00초 -> +1을해서 6/30일까지 포함
--7월 00시 00분전까지 입사한 사람을 알아봐야하기 때문에 이렇게도 쿼리를 짤 수 있다. 

--2007년 1월 1일 부터 3월 31일 사이에 입사한 사원
SELECT *
FROM EMPLOYEES
WHERE HIRE_DATE >= '2007/01/01' AND HIRE_DATE < TO_DATE('2007/03/31') + 1;
--특정구간에 날짜를 구할때 사용한다. 

---------------------------------------------------------------------------------
--다중행 함수 
--SUM(컬럼명)          :해당컬럼값의 합계를 반환한다. NULL인 행은 제외한다. 
--AVG(컬럼명)          :해당컬럼의 평균값을 반환한다. NULL인 행은 제외한다.
--MAX(컬럼명)          :해당컬럼의 최대값을 반환한다. NULL인 행은 제외한다.
--MIN(컬럼명)          :해당컬럼의 최소값을 반환한다. NULL인 행은 제외한다.
--COUNT(* 혹은 컬럼명) : 행의 갯수를 반환한다. *인 경우 해당 컬럼의 값이 NULL이어도 포함시킨다. 
--컬럼명을 적으면 해당 컬럼이 NULL이면 제외된다. 

--GROUP BY와 함께사용하면 강력한 힘을 보인다. 

--60번 부서에 소속된 직원들의 총급여를 조회하기 
SELECT SUM(SALARY)
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 60;

--60번 부서에 소속된 직원들의 평균급여를 조회하기 
SELECT AVG(SALARY)
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 60;

--60번 부서에 소속된 직원들의 최대급여,최소급여를 조회하기 
SELECT MAX(SALARY), MIN(SALARY)
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 60;

--전체 사원의 수를 조회하기 --EMPLOYEES의 모든 행의 갯수를 셈
SELECT COUNT(*) -- NULL전체의 행을 셈
FROM EMPLOYEES;

--커미션을 받은 사원의 수를 조회하기 
SELECT COUNT(COMMISSION_PCT)
FROM EMPLOYEES; --NULL이 아닌 COMMISSION의 행을 COUNT함
--커미션을 받은 사원의 수를 조회하기 
SELECT COUNT(*)
FROM EMPLOYEES
WHERE COMMISSION_PCT IS NOT NULL; --NULL이 아닌 행을 먼저 찾고 그다음 그 수를 COUNT함 
--결과가 한 행이 조회 됨

--여러개의 행에 대해서 결과를 1개만 출력하기 때문에 다중행 함수라고 한다. 
--단일행 함수와 CLOUMN명을 함께 사용할 수 없다. 

SELECT FIRST_NAME, MAX(SALARY)
FROM EMPLOYEES;  -- ORA-00937:단일 그룹의 그룹함수가 아닙니다 ERROR가 남 

SELECT FIRST_NAME
FROM EMPLOYEES;  ---행이 107개가 출력됨

SELECT MAX(SALARY) 
FROM EMPLOYEES; --행이 1개가 출력됨

--다중행 함수는 행그룹당 한 행만 결과가 나오기 때문에 다중행함수가 아닌 것과 같이 사용할 수 없다.

--급여를 가장 많이 받은 사람의 이름과 급여를 조회하기 
--서버쿼리 (SUB_QUERY)
SELECT FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY = (SELECT MAX(SALARY)
                FROM EMPLOYEES);
                --먼저 ()의 SELECT문을 통해 SALARY MAX의 값을 찾고, 그 찾은 값에서 이름과 급여를 출력한다. 
    --SELECT의 조건결과가 조건식의 기준이 된다. 
    --다중행함수는 결과가 한개가 나온다. 
