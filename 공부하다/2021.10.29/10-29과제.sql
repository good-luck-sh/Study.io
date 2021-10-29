-- 'Executive' �μ��� ��� ����� ���̵�� �̸��� ����, �μ���ȣ�� ��ȸ�ϱ�
SELECT E.EMPLOYEE_ID, E.FIRST_NAME, E.JOB_ID, E.DEPARTMENT_ID
FROM DEPARTMENTS D, EMPLOYEES E
WHERE D.DEPARTMENT_NAME = (SELECT DEPARTMENT_NAME 
FROM DEPARTMENTS 
WHERE DEPARTMENT_NAME = 'Executive')
AND D.DEPARTMENT_ID = E.DEPARTMENT_ID;
-- 'Neena' ���� ���� �޿��� �޴� ����� ���̵�, �̸�, �޿��� ��ȸ�ϱ�
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY
FROM EMPLOYEES 
WHERE SALARY > (SELECT SALARY
                FROM EMPLOYEES
                WHERE FIRST_NAME = 'Neena');
-- �޿��� ���� ���� �޴� ������ ���̵�, �̸�, �������̵�, �޿��� ��ȸ�ϱ�
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID, SALARY
FROM EMPLOYEES 
WHERE SALARY = (SELECT MAX(SALARY)
                FROM EMPLOYEES);
-- ��ü ������ ��ձ޿� 2�� �̻��� �޴� ������ ���̵�, �̸�, �޿��� ��ȸ�ϱ�
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY >
(SELECT AVG(SALARY)*2 AS DOUBLE_PAY
FROM EMPLOYEES);
-- ��ü ����� ��ձ޿����� �޿��� ���� �ް�, �̸��� 50�� �μ����� �ٹ��ϴ� ������ ���̵�, �̸�, �޿��� ��ȸ�ϱ�
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY > (SELECT AVG(SALARY)
FROM EMPLOYEES)
AND DEPARTMENT_ID = 50;
-- ������� ��ü ��պ��� ���� �޿��� ���� ������� ���̵�, �̸�, �޿�, �޿������ ��ȸ�ϱ�
SELECT E.EMPLOYEE_ID, E.FIRST_NAME, E.SALARY, S.GRADE
FROM EMPLOYEES E, SALARY_GRADE S
WHERE SALARY < (SELECT AVG(SALARY)
                FROM EMPLOYEES);
-- 80�� �μ��� �ٹ��ϰ�, 80�� �μ��� �����޿��� �޴� ����� ���̵�, �̸�, �������̵�, �޿�, �μ����̵� ��ȸ�ϱ�
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID, SALARY, DEPARTMENT_ID
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 80
AND SALARY = (SELECT MIN(SALARY)
    FROM EMPLOYEES
    WHERE DEPARTMENT_ID = 80);
-- 'Neena'���� ����޴� ����� ���� �Ŵ������� �����ϴ� ������ ���̵�, �̸�, �Ŵ����� ���̵�, �Ŵ����� �̸��� ��ȸ�ϱ�
SELECT EMP.EMPLOYEE_ID,EMP.FIRST_NAME, MGP.EMPLOYEE_ID, MGP.FIRST_NAME
FROM EMPLOYEES EMP, EMPLOYEES MGP 
WHERE EMP.MANAGER_ID = MGP.EMPLOYEE_ID
AND MGP.FIRST_NAME = 'Neena'
AND MGP.EMPLOYEE_ID = (SELECT MANAGER_ID
    FROM EMPLOYEES----�ٽ�
    WHERE EMPLOYEE_ID = 101);

-- 'Ismael'�� ���� �ؿ� �Ի��߰�, ���� �μ��� �ٹ��ϴ� ������ ���̵�, �̸�, �Ի���, �μ����̵� ��ȸ�ϱ�
SELECT EMPLOYEE_ID,FIRST_NAME,HIRE_DATE,DEPARTMENT_ID
FROM EMPLOYEES
WHERE( TO_CHAR(HIRE_DATE,'YYYY'),DEPARTMENT_ID )= (SELECT TO_CHAR(HIRE_DATE,'YYYY'), DEPARTMENT_ID
                                    FROM EMPLOYEES
                                    WHERE FIRST_NAME = 'Ismael'
                                    );


-- �μ��� ��ձ޿��� ������� �� 'Ismael'�� �ٹ��ϴ� �μ��� ��ձ޿����� �޿��� ���� �޴� �μ��� ���̵�� ��ձ޿��� ��ȸ�ϱ�
SELECT DEPARTMENT_ID, TRUNC(AVG(SALARY))
FROM EMPLOYEES
WHERE SALARY > (SELECT AVG(SALARY)
            FROM EMPLOYEES
            WHERE FIRST_NAME = 'Ismael')
GROUP BY DEPARTMENT_ID
ORDER BY 2 ;

-- 100�� �Ŵ������� �����ϴ� ������ ������� ��ȸ�ϱ�
SELECT COUNT(*) 
FROM EMPLOYEES
WHERE MANAGER_ID = 100;

-- �μ��� �ְ�޿��� ��ȸ���� �� �ְ�޿��� 15000�� �Ѵ� �μ��� ���̵�� �ְ�޿��� ��ȸ�ϱ�
SELECT DEPARTMENT_ID, MAX(SALARY)
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID
HAVING MAX(SALARY) > 15000;
-- ���� �޿��� �������� �޿� ����� ��ȸ���� ��, �޿���޺� �������� ��ȸ�ϱ�
SELECT S.GRADE, COUNT(*)
FROM EMPLOYEES E, SALARY_GRADE S
WHERE E.SALARY >= S.MIN_SALARY AND E.SALARY <= S.MAX_SALARY
GROUP BY S.GRADE
ORDER BY 1;
-- ���� ���� ������ �Ի��� �ؿ� �� �ؿ� �Ի��� �������� ��ȸ�ϱ�
SELECT TO_CHAR(HIRE_DATE,'YYYY') , MIN(COUNT(*))
FROM EMPLOYEES
GROUP BY 
HAVING COUNT(*) = 
    (SELECT TO_CHAR(HIRE_DATE,'YYYY'), COUNT(*)
    FROM EMPLOYEES
    GROUP BY TO_CHAR(HIRE_DATE,'YYYY'));


-- �Ҽ� �μ��� ��ձ޿����� ���� �޿��� �޴� ������ ���̵�� �����̸�, �޿�, �� �μ��� ��� �޿��� ��ȸ�ϱ�

-- ������ ��ձ޿��� ������� �� ��ձ޿��� ���� ���� ������ ��ձ޿��� ��ȸ�ϱ�



-- ������ ��ձ޿��� ������� �� ��ձ޿��� ���� ���� ������ ���̵�, ��������, �� ������ �����޿�, �� ������ �ִ�޿��� ��ȸ�ϱ�





