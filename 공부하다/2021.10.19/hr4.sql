-- �μ����̺��� ��� �μ� ������ ��ȸ�ϱ�
SELECT DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATRION_ID
FROM DEPARTMENTS;
-- �μ����̺��� ��ġ���̵� 1700���� �ƴ� �μ� ���� ��ȸ�ϱ�
SELECT DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATRION_ID
FROM DEPARTMENTS 
WHERE LOCATION_ID != 1700;
-- 100����� �����ϴ� �μ����� ��ȸ�ϱ�
SELECT DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATRION_ID
FROM DEPARTMENTS
WHERE MANAGER_ID = 100;
-- �μ����� 'IT'�� �μ��� ���� ��ȸ�ϱ�
SELECT  DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATRION_ID
FROM DEPARTMENTS
WHERE DEPARTMENT_NAME = 'IT';
-- ��ġ���̵� 1700���� ������ �ּ�, �����ȣ, ���ø�, �����ڵ带 ��ȸ�ϱ�
SELECT STREET_ADDRESS, POSTAL_CODE, CITY, COUNTRY_ID
FROM LOCATIONS
WHERE LOCATION_ID = 1700;
-- �ּұ޿��� 2000�̻� 5000������ ������ �������̵�, ��������, �ּұ޿�, �ִ�޿� ��ȸ�ϱ�
SELECT JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY
FROM JOBS
WHERE MIN_SALARY BETWEEN 2000 AND 5000;
-- �ִ�޿��� 20000���� �ʰ��ϴ� ������ ���̵�, ��������, �ּұ޿�, �ִ�޿� ��ȸ�ϱ�
SELECT JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY
FROM JOBS
WHERE MAX_SALARY > 20000;

-- 100�������� �����ϴ� ����� ���̵�, �̸�, �μ����̵��� ��ȸ�ϱ�
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID
FROM EMPLOYEES
WHERE MANAGER_ID = 100;
-- 80�� �μ����� �ٹ��ϰ� �޿��� 8000�� �̻� �޴� ����� ���̵�, �̸�, �޿�, Ŀ�̼�����Ʈ ��ȸ�ϱ�
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, COMMISSION_PCT
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 80 AND SALARY >= 8000;

-- ������ SA_REP�̰�, Ŀ�̼�����Ʈ�� 0.25�̻��� ����� ���̵�, �̸�, �޿�, Ŀ�̼�����Ʈ�� ��ȸ�ϱ�
SELECT EMPLOYEE_ID, FIRST_NAME,SALARY, COMMISSION_PCT
FROM EMPLOYEES
WHERE JOB_ID = 'SA_REP' AND COMMISSION_PCT >= 0.25;
-- 80�� �μ��� �ٹ��ϰ�, �޿��� 10000�� �̻��� ����� ���̵�, �̸�, �޿�, ������ ��ȸ�ϱ�
SELECT EMPLOYEE_ID, FIRST_NAME ,SALARY ,(SALARY + SALARY*COMMISSION_PCT)*12 AS ANNUAL_SALARY
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 80 AND SALARY >= 10000 ;
-- ���� = (�޿� + �޿�xĿ�̼�)x12��
-- 80�� �μ��� �ٹ��ϰ�, 147�� �������� �����ϴ� ��� �߿��� Ŀ�̼��� 0.1�� ����� ������̵�, �̸�, ����, �޿�, Ŀ�̼�����Ʈ�� ��ȸ�ϱ�
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID, SALARY, COMMISSION_PCT
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 80 AND MANAGER_ID = 147 AND COMMISSION_PCT = 0.1;
-- ������� �����ϴ� ������ �ߺ����� ��ȸ�ϱ�
SELECT DISTINCT JOB_ID
FROM EMPLOYEES;
-- ������� �Ҽӵ� �μ����̵� ��� ��ȸ�ϱ�
SELECT DISTINCT DEPARTMENT_ID
FROM EMPLOYEES
WHERE DEPARTMENT_ID IS NOT NULL;

-- ���������� ���� å������ å��ȣ, ����, ����, ���� ��ȸ�ϱ�
SELECT BOOK_NO, BOOK_TITLE, BOOK_WRITER, BOOK_PRICE
FROM TB_EXCEL_BOOKS
WHERE BOOK_REVIEW_SCORE IS NULL;
-- å ���� '��ü'�� ���Ե� å������ å��ȣ, ����, ����, ���� ��ȸ�ϱ�
SELECT BOOK_NO, BOOK_TITLE, BOOK_WRITER, BOOK_PRICE
FROM TB_SAMPLE_BOOKS
WHERE BOOK_TITLE LIKE '%��ü%';
-- û��̵�� ���ǻ翡�� ������ å �߿��� ���� '��ü'�� ���ԵǾ� �ְ�, ������ 4���� �̸��� å�� å��ȣ, ����, ����, ����, ���ΰ��� ��ȸ�ϱ� 
SELECT BOOK_NO, BOOK_TITLE, BOOK_WRITER, BOOK_PRICE, BOOK_DISCOUNT_PRICE
FROM TB_SAMPLE_BOOKS
WHERE BOOK_PUBLISHER = 'û��̵��'
AND BOOK_TITLE LIKE '%��ü%' AND  BOOK_PRICE < 40000;