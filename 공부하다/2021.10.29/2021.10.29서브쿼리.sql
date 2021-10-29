--������ �������� 
--�ٸ� SQL�� ���Ե� SQL���̴�. 
--SELECT��, FROM��, WHERE��, HAVING������ ����� �� �ִ�. 

-- WHERE���̳� HAVING������ ���Ǵ� ���������� ���ǽ��� ���� ���� �����Ѵ�. 
-- ���ǽĿ��� ���Ǵ� ���� SQL �������� ȹ��Ǵ� ��쿡 ���������� ����Ѵ�. 
--SQL�������θ� ȹ��Ǵ� ��쿡!

--100�� ����� ���� �μ����� ���ϴ� ����� ���̵�, �̸� ��ȸ�ϱ� 
--1. 100������� ���ϴ� �μ� ��ȸ�ϱ� 
SELECT DEPARTMENT_ID
FROM EMPLOYEES
WHERE EMPLOYEE_ID = 100; --90���� ���ϴ� ���� �� �� ����
--2. 90�� �μ����� ���ϴ� ���� ��ȸ�ϱ� 
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 90;  --2�ܰ踦 ���ľ��� �� �� �ִ�. 

--100�� ����� ���� �μ����� ���ϴ� ����� ���̵�, �̸� ��ȸ�ϱ� 

SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE DEPARTMENT_ID = (SELECT DEPARTMENT_ID
                        FROM EMPLOYEES
                        WHERE EMPLOYEE_ID = 100); --�� �κи� ����� 90���� ��µ�
                        
--��ü������ ��ձ޿����� ���� �ݿ��� �޴� �������̵�, �̸� , �޿��� ��ȸ�ϱ� 
--1. ��ü�������� ��ձ޿� ��ȸ�ϱ� 
SELECT AVG(SALARY)
FROM EMPLOYEES;
--2. 6461.8317���� ���� �޿��� �޴� �������̵�, �̸� �޿��� ��ȸ�ϱ� 
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY < '6461.8317';

--��ü������ ��ձ޿����� ���� �ݿ��� �޴� �������̵�, �̸� , �޿��� ��ȸ�ϱ�,���������� ����ؼ� ��ȸ�ϱ� 
SELECT EMPLOYEE_ID, FIRST_NAME,SALARY
FROM EMPLOYEES
WHERE SALARY < (SELECT AVG(SALARY)
                FROM EMPLOYEES);
                
--100����� ���� �ؿ� �Ի��߰�, ��ü������ ��ձ޿����� �޿��� ���� �޴� ����� ���̵�, �޿��� ��ȸ�ϱ� 
--������ 2���� 

SELECT EMPLOYEE_ID, HIRE_DATE, SALARY
FROM EMPLOYEES
WHERE TO_CHAR(HIRE_DATE,'YYYY') = --100����� �Ի����� 
(SELECT TO_CHAR(HIRE_DATE,'YYYY')
FROM EMPLOYEES
WHERE EMPLOYEE_ID = '100')

AND SALARY > --��ü����� ��ձ޿� 
(SELECT AVG(SALARY)
                FROM EMPLOYEES);
--��ü ������ �޿��� �λ��Ű��, �λ�ݾ��� ��ü������ ��ձ޿��� 10%��ŭ �λ��Ų��. 
UPDATE EMPLOYEES
SET SALARY = SALARY +(SELECT TRUNC(AVG(SALARY)*0.1)
                        FROM EMPLOYEES);
                        --�޿��� �λ��Ű�� ���̱� ������ �������� ó����, ���������� UPDATE�� ����ص� ��
SELECT FIRST_NAME, SALARY
FROM EMPLOYEES;

-------------------------------------------------------------------------------
--������ ��������

--�ڽ��� �����ϴ� ������ ����� ���� �ִ� �������� ���̵�, �̸��� ��ȸ�ϱ� 
--1. �ڽ��� �����ϴ� ������ ����� ���� �ִ� ������ ���̵� ��ȸ�ϱ�  -- ��ȸ����� �������̴�.
SELECT DISTINCT EMPLOYEE_ID --����� �������� ����, ������ ��������
FROM JOB_HISTORY;
--2. ������ ����� ���� �ִ� �������� ���̵�, �̸�, ���� ������ ��ȸ�ϱ� 
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID
FROM EMPLOYEES
WHERE EMPLOYEE_ID IN(101,102,114,122,176,200,201); --������ ���� ����� �����Է��� ����. �׷��� IN�̶�� �����ڰ� ��
-- =�� ��1���� ���ϱ� ���ؼ� �ۼ��ϴ� ���̴� �翬�� IN�� �ۼ��ϴ� ���� ����
--�ڽ��� �����ϴ� ������ ����� ���� �ִ� �������� ���̵�, �̸�, �������̵�,�����������̵� ��ȸ�ϱ� (������ �������� ���, ������ �������� ������ �����)
SELECT EMPLOYEE_ID, FIRST_NAME,JOB_ID
FROM EMPLOYEES
WHERE EMPLOYEE_ID IN(SELECT DISTINCT EMPLOYEE_ID --H�� �ش�κ��� ���������ۿ� ��� H�� ������ �� ����. 
                FROM JOB_HISTORY);

--�ڽ��� �����ϴ� ������ ����� ���� �ִ� �������� ���̵�, �̸�, �������̵�,�����������̵� ��ȸ�ϱ�(���� ���--���������� ������� �ʾƵ� ����)
SELECT DISTINCT E.EMPLOYEE_ID, E.FIRST_NAME, E.JOB_ID, H.JOB_ID
FROM EMPLOYEES E, JOB_HISTORY H
WHERE E.EMPLOYEE_ID = H.EMPLOYEE_ID;
--������ ���ʿ� �ִ� ���� ������ ����, ���ʿ� �־�߸� ����� ���´�. 
--������ ����� �������� ������������ ������ ����ϴ� ���� ����. 
--������������ ������ ����Ѵ�. 
-- ������������ ����� ���� JOIN�� ����ϴ� ���� ����. 
--�������� Ǯ���ִ°��� ���������� ����� �� ������, ���������� ���� main�������� ������ �� ����. 
--��ȣ�ȿ����� ����ϰ� ���̴�. �������� Ǯ���� ���� �� ���� ������ �ǵ��� ������ ����ϴ� ���� ������ 
--�ǵ��� ������ ����ϴ� ���� ����. 

--30�� �μ��� �Ҽӵ� ��� ������ �޿����� �޿��� ���� �޴� 60�� �μ� �Ҽ��� ������ ��ȸ�ϱ� 
--30�� �μ��� �Ҽӵ� ������ �ִ�޿����� �޿��� ���� �޴� 60�� �μ� �Ҽ��� ������ ��ȸ�ϱ� 
SELECT *
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 60
AND SALARY > ALL(SELECT SALARY
                FROM EMPLOYEES
                WHERE DEPARTMENT_ID = 30); --������ �������ǿ� 2���̻��� ���� ���ϵǾ����ϴ�. ERROR�� �߻�
--�������Լ��� ������ ALL�� ����� �ȳ���
--���������� ��ȸ�� �޿����ٴ� ������ ��ü���� ���ƾ��Ѵٴ� �ǹ� ALL (11646���� ���ƾ� ����)
--���� �Ʒ��� ������
--30�� �μ��� �Ҽӵ� ��� ������ �޿����� �޿��� ���� �޴� 60�� �μ� �Ҽ��� ������ ��ȸ�ϱ� 
--30�� �μ��� �Ҽӵ� ������ �ִ�޿����� �޿��� ���� �޴� 60�� �μ� �Ҽ��� ������ ��ȸ�ϱ�
SELECT *
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 60
AND SALARY > (SELECT MAX(SALARY)
                FROM EMPLOYEES
                WHERE DEPARTMENT_ID = 30);
--30�� �μ��� �Ҽӵ� ���� �� �ƹ��� �� ���� �޿����� �޿��� ���� �޴� 60�� �μ� �Ҽ��� ������ ��ȸ�ϱ� 
--30�� �μ��� �Ҽӵ� ������ �ּұ޿����� �޿��� ���� �޴� 60�� �μ� �Ҽ��� ������ ��ȸ�ϱ�

SELECT *
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 60
AND SALARY > ANY(SELECT SALARY
                FROM EMPLOYEES
                WHERE DEPARTMENT_ID = 30);
                
 --�������Լ��� ������ ALL�� ����� �ȳ���
 --ANY�� ���������� �ϳ��� ������ ���� 
 --30�� �μ��� �Ҽӵ� ���� �� �ƹ��� �� ���� �޿����� �޿��� ���� �޴� 60�� �μ� �Ҽ��� ������ ��ȸ�ϱ� 
--30�� �μ��� �Ҽӵ� ������ �ּұ޿����� �޿��� ���� �޴� 60�� �μ� �Ҽ��� ������ ��ȸ�ϱ�
 SELECT *
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 60
AND SALARY > (SELECT MIN(SALARY)
                FROM EMPLOYEES
                WHERE DEPARTMENT_ID = 30);
--���� ANY�� MIN�� ������ ���� ���� �������� �����ص� ��  ALL���ٴ� MAX�� �� ���� �� ����
--ANY���ٴ� MIX�� ����ϴ� ���� �������� ���ؼ��� �� ����

---------------------------------------------------------------------------------------------
-- ���߿� �������� 
--SELECT *
--FROM TABLE
--WHERE (COL1, COL2) IN (SELECT COL3, COL4
--                          FROM TABLE)
--�������� �����ϰ�, �����ڴ� IN�� ����� 
--��������� �����ұ�?

--�μ��� ���� �޿��� ��ȸ�ϱ� 
SELECT DEPARTMENT_ID, MIN(SALARY)
FROM EMPLOYEES
WHERE DEPARTMENT_ID IS NOT NULL
GROUP BY DEPARTMENT_ID
ORDER BY DEPARTMENT_ID;

--�ڽ��� �Ҽӵ� �μ����� �����޿��� �޴� ����� �μ����̵�, ������̵�, �޿��� ��ȸ�ϱ� 
--�μ������� �����޿��޴� ����� ���������� �ּ� ����� ���Ͽ� ��ȸ�ϰڴ�
SELECT DEPARTMENT_ID, EMPLOYEE_ID, FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE (DEPARTMENT_ID, SALARY) IN(SELECT DEPARTMENT_ID, MIN(SALARY)
                                    FROM EMPLOYEES
                                    WHERE DEPARTMENT_ID IS NOT NULL
                                    GROUP BY DEPARTMENT_ID)
ORDER BY DEPARTMENT_ID ASC;

--------------------------------------------------------------------------------
--HAVING ������ �������� ����ϱ� 
--HAVING������ �μ��� ������� ��ȸ���� �� ������� 5�������� �μ��� ���̵�� ������� ��ȸ�ϱ� 
SELECT DEPARTMENT_ID, COUNT(*)
FROM EMPLOYEES
WHERE DEPARTMENT_ID IS NOT NULL
GROUP BY DEPARTMENT_ID
HAVING COUNT(*) <= 5
ORDER BY 1;
--�׷�׷��� ������� COUNT�� ������Ѽ� ����� 5�����ϴ� HAVING�� ����ؼ� �����
--�μ��� ������� ��ȸ���� �� ������� ���� ���� �μ��� ���̵�� ������� ��ȸ�ϱ� 

SELECT MAX(COUNT(*))
FROM EMPLOYEES
WHERE DEPARTMENT_ID IS NOT NULL --COUNT 2�� �����ϰ� ��
GROUP BY DEPARTMENT_ID; -- �ϴ� �μ����� ����� ��ȸ�ؾ��ϱ� ������ ��������� ����ؾ���, ���⼭ ���� ���� �μ��� ã�ƾ���

SELECT DEPARTMENT_ID, COUNT(*)
FROM EMPLOYEES
WHERE DEPARTMENT_ID IS NOT NULL
GROUP BY DEPARTMENT_ID      --COUNT1��
HAVING COUNT(*) =(45); ----���� �Ʒ��� ��������Ѵ�. COUNT�� 2�������ϰ� ��

SELECT DEPARTMENT_ID, COUNT(*)
FROM EMPLOYEES
WHERE DEPARTMENT_ID IS NOT NULL
GROUP BY DEPARTMENT_ID      --COUNT1��
HAVING COUNT(*) =(SELECT MAX(COUNT(*))
                FROM EMPLOYEES
                WHERE DEPARTMENT_ID IS NOT NULL
                 GROUP BY DEPARTMENT_ID); --�̷��� �ۼ��� �ؼ� ����� �������� GROUP BY�� 2���۵�
                 
--WITH��
--SQL�� �������� ������ �̸����� ĳ�� (�ӽú���) �Ѵ�. 
--���������� ����ϴ� SQL������ �ݺ������� ����Ǵ� SQL�� ���ؼ� WITH���� ����ϸ� ���� ������ ���ȴ�. 
--WITH������ ������ ������ ���̺��� �Ʒ� SELECT������ ����� �� �ִ�. 
--WITH���� �ܵ����� ����� �� ����. 
--WITH  ��Ī1
--AS (SELECT ��),
--��Ī2
--AS (SELECT ��)
--SELECT COL, COL
--FROM ��Ī1�� ��Ī2�� �����ͼ� ����ϸ� �ȴ�. 
--WHERE ���ǽ�
--WITH���� ����ؼ� �μ��� ������� ��ȸ���� �� ������� ���� ���� �μ��� ���̵�� ������� ��ȸ�ϱ� 
WITH DEPT_EMP_CNT --������ ���̺��� �Ʒ����� ����
AS ( --SQL�������� ���� ��Ī���� ������ ������ �䰡 ������ ����
    SELECT DEPARTMENT_ID AS DEPT_ID, COUNT(*) AS CNT
    FROM EMPLOYEES
    WHERE DEPARTMENT_ID IS NOT NULL
    GROUP BY DEPARTMENT_ID
),  --,�� �̿��Ͽ� �߰��� ���� �ȴ�.
    JOB_EMP_CNT 
    AS(
    SELECT JOB_ID, COUNT(*) AS CNT
    FROM EMPLOYEES
    GROUP BY JOB_ID
    )--������ �Ǿ����� �ʱ� ������ ����� �� �� ������ �������� ����ص� �ȴ�. 
SELECT DEPT_ID, CNT --WITH���� �̿��Ͽ� ���̵�� DEPT_ID�� CNT�� ��Ī�� �ۼ���
FROM DEPT_EMP_CNT--WITH���� ������ ������ ���̺��� ������
WHERE CNT = (SELECT MAX(CNT)
FROM DEPT_EMP_CNT);
