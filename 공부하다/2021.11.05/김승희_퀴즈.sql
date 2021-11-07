-- departments ���̺��� ��� ��, ��� ���� ��ȸ�ϱ�
SELECT DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID
FROM DEPARTMENTS;

-- departments ���̺��� �μ����̵�, �μ����� ��ȸ�ϱ�
SELECT DEPARTMENT_ID, DEPARTMENT_NAME
FROM DEPARTMENTS;

-- ������ ���̵�, �̸�, �޿�, ������ ��ȸ�ϱ�
-- ������ �޿�*12��.
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, SALARY*12 AS ANNUAL_SALARY
FROM EMPLOYEES;

-- �������� �ð� �ִ� �������̵� �ߺ����� ��ȸ�ϱ�
SELECT DISTINCT JOB_ID
FROM EMPLOYEES;

-- �������� �Ҽӵ� �μ��̸��� �ߺ����� ��ȸ�ϱ�
SELECT DISTINCT DEPARTMENT_NAME
FROM DEPARTMENTS;

-- 90�� �μ����� �ٹ��ϰ� �ִ� ������ ���̵�, �̸�, �������̵� ��ȸ�ϱ�
SELECT  EMPLOYEE_ID, FIRST_NAME, JOB_ID 
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 90;

-- �޿��� 15000�޷� �̻� �޴� ������ ���̵�, �̸�, �޿��� ��ȸ�ϱ�
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY >= 15000;

-- �޿��� 2500�޷� �̻� 3500�޷� ���Ϸ� �޴� ������ ���̵�, �̸�, �޿��� ��ȸ�ϱ�
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY >= 2500 AND SALARY <= 3500;

-- Ŀ�̼��� �޴� �������̵�� �̸�, �޿�, Ŀ�̼�, ������ ��ȸ�ϱ�
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, COMMISSION_PCT, SALARY*12 AS ANNUAL_SALARY
FROM EMPLOYEES
WHERE COMMISSION_PCT IS NOT NULL;

-- ������ �޿�*12 + �޿�*Ŀ�̼�*12��. Ŀ�̼� �ݾ��� �Ҽ����Ʒ��� ������.
SELECT TRUNC(SALARY*12+SALARY*COMMISSION_PCT*12) AS ANNUAL_SALARY
FROM EMPLOYEES
WHERE COMMISSION_PCT IS NOT NULL;

-- ������ �����Ǿ� ���� �ʴ� ������ ���̵�, �̸�, �޿�, �޿�, ����� ��ȸ�ϱ�
SELECT DISTINCT EMP.EMPLOYEE_ID, EMP.FIRST_NAME, EMP.SALARY, S.GRADE
FROM EMPLOYEES EMP , EMPLOYEES MEP, SALARY_GRADE S
WHERE EMP.EMPLOYEE_ID = MEP.MANAGER_ID
AND EMP.SALARY >= S.MIN_SALARY AND EMP.SALARY<= MAX_SALARY
AND EMP.MANAGER_ID IS NULL;


-- �޿��� 10000�޷� �̻� �ް�, �������̵� 'MAN'���� ������ ������ ���̵�, �̸�, �������̵�, �޿��� ��ȸ�ϱ�
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID, SALARY
FROM EMPLOYEES
WHERE SALARY >= 10000
AND JOB_ID LIKE '%_MAN%';

-- 10,20,40�� �μ��� �Ҽӵ� �������� ���̵�, �̸�, �ҼӺμ����� ��ȸ�ϱ�
SELECT E.EMPLOYEE_ID, E.FIRST_NAME, D.DEPARTMENT_NAME
FROM DEPARTMENTS D, EMPLOYEES E
WHERE D.DEPARTMENT_ID = E.DEPARTMENT_ID
AND E.DEPARTMENT_ID IN(10 ,20 ,40);

-- �޿��� 10000�޷� �̻� �޴� �������� �μ��̸�, �޿�, �������̵�, �̸��� ��ȸ�ϱ� 
SELECT D.DEPARTMENT_ID, E.SALARY, E.JOB_ID, E.FIRST_NAME 
FROM EMPLOYEES E, DEPARTMENTS D
WHERE E.SALARY >= 10000
AND E.DEPARTMENT_ID = D.DEPARTMENT_ID;

-- �μ��̸��� ��������, �޿��� ���� ������������ �����ؼ� ��ȸ�Ͻÿ�.
SELECT D.DEPARTMENT_NAME, E.SALARY
FROM DEPARTMENTS D, EMPLOYEES E
WHERE D.DEPARTMENT_ID = E.DEPARTMENT_ID
ORDER BY D.DEPARTMENT_NAME ASC , E.SALARY DESC;

-- ������ �������� �������� �ٹ� �������� ��ȸ�ؼ� �������̵�, �̸�, �Ի���, �ٹ��������� ��ȸ�ϱ�
SELECT EMPLOYEE_ID, FIRST_NAME, HIRE_DATE, ((TO_DATE(SYSDATE)+1)-HIRE_DATE)/30 AS REFERENCE_MONTH
FROM EMPLOYEES;

-- �ٹ����� ���� �Ҽ������ϴ� ������, �ٹ��������� �������� �������� �����ϱ�(���� ������ �پ��־� ���� �������� �߰��ȰŶ�� �����ϰ� ������ Ǯ�����ϴ�.)
SELECT EMPLOYEE_ID, FIRST_NAME, HIRE_DATE, TRUNC(((TO_DATE(SYSDATE)+1)-HIRE_DATE)/30) AS REFERENCE_MONTH
FROM EMPLOYEES
ORDER BY HIRE_DATE DESC;

-- ������ �������� ���������� �Ի��� ����� ���̵�, �̸�, �Ի����� ��ȸ�ϱ�
SELECT EMPLOYEE_ID, FIRST_NAME, HIRE_DATE,TO_CHAR(HIRE_DATE,'DD')
FROM EMPLOYEES
WHERE TO_CHAR(SYSDATE,'DD') - TO_CHAR(HIRE_DATE,'DD') >= 7  ;

--  2007�� ��ݱ⿡ �Ի��� ������� ���̵�, �̸�, �Ի���, �������̵� ��ȸ�ϱ�
SELECT EMPLOYEE_ID,FIRST_NAME,HIRE_DATE,JOB_ID
FROM EMPLOYEES
WHERE HIRE_DATE >= '2007/01/01' AND HIRE_DATE <= TO_DATE('2007/06/30')+1;
-- �Ի����� �������� �������� �����ϱ�
SELECT EMPLOYEE_ID,FIRST_NAME,HIRE_DATE,JOB_ID
FROM EMPLOYEES
WHERE HIRE_DATE >= '2007/01/01' AND HIRE_DATE <= TO_DATE('2007/06/30')+1
ORDER BY HIRE_DATE ASC;

-- ��� ������� ������̵�, �̸�, �޿�, Ŀ�̼�, ����, �޿������ ��ȸ�ϰ� �޿���޿� ���� ������������ ��ȸ�Ѵ�.
-- ������ �޿�*12 + �޿�*Ŀ�̼�*12��. Ŀ�̼� �ݾ��� �Ҽ����Ʒ��� ������.
SELECT E.EMPLOYEE_ID, E.FIRST_NAME, E.SALARY, E.COMMISSION_PCT , E.SALARY*12 + TRUNC(E.SALARY*12*NVL(E.COMMISSION_PCT,0)) AS ANNUAL_SALARY , S.GRADE
FROM EMPLOYEES E, SALARY_GRADE S
WHERE E.SALARY >= S.MIN_SALARY AND E.SALARY <= S.MAX_SALARY
ORDER BY S.GRADE DESC;

-- �޿��� 15000�޷� �̻� ������ 10% �޿��λ�, 10000�޷� �̻� ������ 15% �޿��λ�, �׿ܴ� 20% �޿��� �λ�� ������ ��ȸ�ϱ�
-- ������̵�, �̸�, �޿�, �λ�� �޿��� ��ȸ�Ѵ�. case  ~ when ���
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY,
CASE
    WHEN SALARY >= 15000 THEN (SALARY * 0.1) + SALARY
    WHEN SALARY >= 10000 THEN (SALARY * 0.15) + SALARY
    ELSE (SALARY * 0.2) + SALARY
END AS UPGRADE_SALARY
FROM EMPLOYEES;

-- �μ���ȣ�� 10���� ��� 10% �޿��λ�, 20���� ��� 15% �޿��λ�, �׿� 20% �޿��� �λ�� ���� ��ȸ�ϱ�
-- ������̵�, �̸�, �޿�, �λ�� �޿��� ��ȸ�Ѵ�. decode() �Լ� ���
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, 
DECODE(DEPARTMENT_ID, 10, (SALARY*0.1)+SALARY,
                      20, (SALARY*0.15)+SALARY,
                      (SALARY*0.2)+SALARY) AS UPGRADE_SALARY
FROM EMPLOYEES;

-- ������̵�, ����̸�, ����� �Ҽӵ� �μ���ȣ�� �μ��̸��� ��ȸ�ϱ�
SELECT E.EMPLOYEE_ID, E.FIRST_NAME, E.DEPARTMENT_ID, D.DEPARTMENT_NAME
FROM EMPLOYEES E, DEPARTMENTS D
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID;

-- �μ����̵�, �μ��̸�, �μ�����ھ��̵�, �μ������ �̸� ��ȸ�ϱ�
SELECT D.DEPARTMENT_ID, D.DEPARTMENT_NAME, D.MANAGER_ID ,M.FIRST_NAME
FROM DEPARTMENTS D, EMPLOYEES M
WHERE D.MANAGER_ID = M.EMPLOYEE_ID;

-- ����� ���̵�, ����̸�, �ҼӺμ� ���̵�, �ҼӺμ��̸�, �ҼӺμ��� ��ġ�� ���� ��ȸ�ϱ�
SELECT E.EMPLOYEE_ID, E.FIRST_NAME, E.DEPARTMENT_ID, D.DEPARTMENT_NAME, L.CITY
FROM EMPLOYEES E, DEPARTMENTS D, LOCATIONS L
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID
AND D.LOCATION_ID = L.LOCATION_ID;

-- �μ����̵�, �μ��̸�, �μ�����ھ��̵�, �μ������ �̸�, �� �μ��� ��ġ�� ���� ��ȸ�ϱ�
SELECT D.DEPARTMENT_ID, D.DEPARTMENT_NAME, D.MANAGER_ID, M.FIRST_NAME, L.CITY
FROM EMPLOYEES M , DEPARTMENTS D, LOCATIONS L
WHERE M.EMPLOYEE_ID = D.MANAGER_ID
AND D.LOCATION_ID = L.LOCATION_ID;

-- ��� ���̵�, ����̸�, �ڽ��� �Ŵ��� ���̵�, �Ŵ��� �̸� ��ȸ�ϱ�
SELECT E.EMPLOYEE_ID, E.FIRST_NAME, E.MANAGER_ID, M.FIRST_NAME
FROM EMPLOYEES E, EMPLOYEES M
WHERE M.EMPLOYEE_ID = E.MANAGER_ID;

-- ����� �߿��� �޿��� ���� ���� �޴� ���� 3���� �������̵�, �̸�, �޿��� ��ȸ�ϱ�
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY
FROM (SELECT EMPLOYEE_ID, FIRST_NAME, SALARY
FROM EMPLOYEES
ORDER BY SALARY DESC)
WHERE ROWNUM <= 3;

-- ��ü ������ ��ձ޿����� ���� �޿��� �޴� ����� ���̵�, �̸�, �������̵�, �޿��� ��ȸ�ϱ�
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID, SALARY
FROM EMPLOYEES
WHERE SALARY > (SELECT AVG(SALARY)
                FROM EMPLOYEES);


-- �μ��� �޿������ ��ȸ�ؼ� �μ����̵�, ��ձ޿��� ǥ���ϱ�
-- ��ձ޿��� �Ҽ������� �κ��� �ݿø��Ѵ�.
SELECT DEPARTMENT_ID ,TRUNC(AVG(SALARY))
FROM EMPLOYEES
WHERE DEPARTMENT_ID IS NOT NULL
GROUP BY DEPARTMENT_ID
ORDER BY 1;

-- ������� ���� ���� �μ� 2���� �μ����̵�, �μ���, ������� ��ȸ�ϱ�
 SELECT DEPARTMENT_ID,DEPARTMENT_NAME, CNT
FROM (SELECT E.DEPARTMENT_ID, D.DEPARTMENT_NAME, COUNT(*) AS CNT
 FROM DEPARTMENTS D, EMPLOYEES E
 WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID
 GROUP BY E.DEPARTMENT_ID, D.DEPARTMENT_NAME
 ORDER BY CNT DESC)
 WHERE ROWNUM <= 2;
    
-- 80�� �μ��� �Ҽӵ� ������� �޿� ������ �������� �����ؼ� ��ŷ, ������̵�, �̸�, �޿��� ��ȸ�ϱ�
SELECT RANK() OVER(ORDER BY SALARY ASC) "RANK", EMPLOYEE_ID, FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 80;

-- ������� �޿������� �����ϰ�, ������ �ο����� �� 6~10��°�� ���ϴ� ������� ����, ������̵�, �̸�, �޿��� ��ȸ�ϱ�
SELECT ROW_NUMBERS, EMPLOYEE_ID, FIRST_NAME, SALARY
FROM(SELECT ROW_NUMBER() OVER(ORDER BY SALARY DESC) ROW_NUMBERS ,
    EMPLOYEE_ID, FIRST_NAME, SALARY
    FROM EMPLOYEES) 
WHERE ROW_NUMBERS >= 6 AND ROW_NUMBERS <= 10;

-- Employees ���̺��� �����ں� ������� ����ϰ�, �� �������� �̸��� �����ϴ� ������� ��ȸ�ϱ�

SELECT M.MANAGER_ID, E.FIRST_NAME, CNT
FROM (SELECT MANAGER_ID, COUNT(*) AS CNT
FROM EMPLOYEES 
WHERE MANAGER_ID IS NOT NULL
GROUP BY MANAGER_ID
) M , EMPLOYEES E
WHERE M.MANAGER_ID = E.EMPLOYEE_ID;
