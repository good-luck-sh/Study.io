--��ȣ���� �������� 
--���� ������ �÷��� �����ϴ� �������� 
--���� ������ ��ȸ�� �� �ึ�� �ѹ��� ����ȴ�. 
--���������� ���� ����� 10 �ΰ�� ���������� 10�� ������ �ȴ�. 
--(�� �ึ�� ���ǽ��� ����ȴ�.)
--WHERE ���ǽ��� �������� TRUE�� �����Ǵ� �ุ ���������� ��ȸ�ȴ�. 

--ex) �������� �������̵� ��ձ޿��� ��ȸ���� �� �ڽ��� ���� �������̵��� 
--��� �޿����� �޿��� ���� �޴� ����� ���̵�, �̸� �޿��� ��ȸ�ϱ� 

SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID, SALARY
FROM EMPLOYEES X--����� ��ȸ, ���� 107���� ����
WHERE SALARY > (SELECT AVG(SALARY)
    FROM EMPLOYEES Y
    WHERE Y.JOB_ID = X.JOB_ID--���⿡ �������̵� ������ , �ܺ� ���� 107�� ����ϰ� ����
    --JOB_ID �� ��տ� ���ؼ� ����� ���� �����ϴ� ��, �� �ึ�� ����Ǵ� ���� �߿���
    ); --�ڽ��� ���� �������̵��� ��ձ޿����� ���� �޴� ����� , ���ึ�� ����, X�� ���� ������ŭ 107�� �����
--��ȣ���� ����������� ��, 

-- �������� ���̵�, �̸�, �������̵�, �ش� �������� �����ϴ� ������ ���� ��ȸ�ϱ� 
SELECT X.EMPLOYEE_ID,X.FIRST_NAME, X.JOB_ID, --COUNT(*)�� ERROR��
(SELECT COUNT(*) FROM EMPLOYEES Y WHERE Y.MANAGER_ID = X.EMPLOYEE_ID) CNT --ó�� �Ŵ��� ID�� 100,101,102��°�� ������ ���� COUNT��
FROM EMPLOYEES X
WHERE X.EMPLOYEE_ID IN (SELECT DISTINCT MANAGER_ID
FROM EMPLOYEES 
WHERE MANAGER_ID IS NOT NULL); --�Ŵ����Ǽ��� ��µ�

SELECT COUNT(*)
FROM EMPLOYEES
WHERE MANAGER_ID = 100;--100Q���� �����ϴ� ����� ���� ��µ�

--�ζ��� ��� �ۼ���
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
--��𿡼� ���� ���ɱ�?
--�Խñ��� ����� ǥ���� �� ����, �Խñ� ���̺��鶧���� ���, ������ ���� ĭ�� �߰��ؼ� �����ؼ� �ݿ����� COUNT�� �ǵ��� �ۼ���
--�Խñ� ���̺� ���ƿ�, COLUMN�� �������Ѽ�, INSERT�� ����� �� �ֵ��� �����ϴ� ���� �߿��ϴ�. 
--��ȣ����Ŀ���� ���� ����� ���� �ƴϴ�. 

------------------------------------------------------------------------------
--TOP-N�м� 
--���̺��� ���� Ư�� �÷��� ���� �������� �������� �� ������ ������ ���ԵǴ� ���� ��ȸ�ϴ°� 
--�޿��� ���� �޴� ��� 3��, �޿��� ���� ���� �޴� ��� 3�� ��ȸ�� ����� 
--ROWNUM(�ǻ� �÷� :Pseudo column) :��ȸ�� ����� ���ؼ� ������ ���̴� �÷��̴�. 


--������ �߿��� �޿��� ���� ���� �޴� ���� 5���� ������ ��ȸ�ϱ�, �������̵�, �̸�, �޿� 

SELECT ROWNUM, EMPLOYEE_ID, FIRST_NAME, SALARY --ROWNUM���� ���ڰ� �ο����� Ȯ��, ���ڼ����� ã�����
FROM
(SELECT EMPLOYEE_ID, FIRST_NAME, SALARY
FROM EMPLOYEES
ORDER BY SALARY DESC) --������������ �ζ��κ�� ������
WHERE ROWNUM <= 5; --ROWNUMB�� ������ ���̺� ���ؼ� ������ �Ű��� �� 5�������� �����Ͷ�.
--������ �Ű����Ϳ��� �������� ���� �ƴ� ������ ���̺��� ������ IF�ű�� 5�������� ��������� WHERE��
--SELECT ROWNUM���� �ۼ����� �ʾƵ� �������, ���� �����ֱ� �������� �ۼ���.

SELECT EMPLOYEE_ID, FIRST_NAME, SALARY --ROWNUM���� ���ڰ� �ο����� Ȯ��, ���ڼ����� ã�����
FROM
(SELECT EMPLOYEE_ID, FIRST_NAME, SALARY
FROM EMPLOYEES
ORDER BY SALARY DESC) --������������ �ζ��κ�� ������
WHERE ROWNUM <= 5; --�ǻ��÷�(Pseudocolumns)���� ��ȸ�Ǵ� �࿡ ���ؼ� ������ �ο��Ǵ� �÷�������, ������ �÷��̶�� �ǹ̴�.
--���� ���� ������ ���� Ȯ�� �� �� ����, 

--�����ϴ� �������� ���� ���� ���� 3���� ������ ���̵�� �����ϴ� �������� ��ȸ�ϱ� 

SELECT MANAGER_ID, CNT
FROM (SELECT MANAGER_ID, COUNT(*) CNT
        FROM EMPLOYEES
        GROUP BY MANAGER_ID
        ORDER BY CNT DESC)
WHERE ROWNUM <= 3; --������ ROWNUM���� �������� ���� 2���� 5�׷����� �ߺ��� �Ǹ� 3�׷��� ������ �� �� ����
--�̷������� �غ��ϰ� ����  -->RANK�� ������ 
------------------------------------------------------------------------------
--�м��Լ��� ����ؼ� ���� ��ȸ�ϱ� 

--�޿��� �������� �������� ������ ����, ��ȸ�� �࿡ ���� Ȥ�� ������ �ο��Ѵ�. 
SELECT SALARY, 
        RANK() OVER (ORDER BY SALARY DESC) "RANK",
        DENSE_RANK() OVER(ORDER BY SALARY DESC) "DENSC_RANK",
        ROW_NUMBER() OVER(ORDER BY SALARY DESC) "ROW_NUMBER"
FROM EMPLOYEES;
--RANC() -- �߰��� �ߺ��� ������ 1,2,2,4 , ������ ���� �� ���� --3����� ��½� 3��
--DENSE_RANK() -- �ߺ��� �־ ������ ������ ���� 1,2,2,3,4,5 (�������� ���) --3����� ��½� 4��
--������ �޶��� 
--ROW_NUMBER() --�ߺ��� ������ ������� 1���� �� ��µ� --���� ���� ������ ����

--PARTITION BY �÷����� ����ϸ� ������ �÷������� �޿��� �������� ������������ ������ ���� ��ȸ�� �࿡ ���� Ȥ�� ������ �ο��Ѵ�. 
SELECT DEPARTMENT_ID, SALARY, 
        RANK()      OVER(PARTITION BY DEPARTMENT_ID ORDER BY SALARY DESC) "RANK",
        DENSE_RANK() OVER(PARTITION BY DEPARTMENT_ID ORDER BY SALARY DESC) "DENSC_RANK",
        ROW_NUMBER() OVER(PARTITION BY DEPARTMENT_ID ORDER BY SALARY DESC) "ROW_NUMBER"
FROM EMPLOYEES;

--PARTITION BY�� ����ϸ� �� �ȿ��� ������ �ű�� ���, �÷����� �������� DEPARTMENT_ID�� ���� �� 
--�� ������ ������ �ű�� ��� --���ÿ� ������
--�������� �޿��� ������������ �������� �� ���� 7������ ��ȸ�ϱ�, RANK() �Լ�
SELECT *
FROM (SELECT RANK() OVER(ORDER BY SALARY DESC) SALARY_RANK,
            EMPLOYEE_ID,
            FIRST_NAME,
            SALARY
            FROM EMPLOYEES)
WHERE SALARY_RANK <= 7; --��ȸ�� ���� ���� : 8��
--�������� �޿��� ������������ �������� �� ���� 7������ ��ȸ�ϱ� 
SELECT *
FROM (SELECT DENSE_RANK() OVER(ORDER BY SALARY DESC) SALARY_RANK,
            EMPLOYEE_ID,
            FIRST_NAME,
            SALARY
            FROM EMPLOYEES)
WHERE SALARY_RANK <= 7; --7������ ���ߴµ�, --��ȸ�� ���� ���� : 9��
--��Ȳ�� �°� ����ϸ� �ȴ�. 

--�������� �޿��� ������������ ���������� 7��° ����� ��ȸ�ϱ� 
SELECT *
FROM (SELECT ROW_NUMBER() OVER(ORDER BY SALARY DESC) SALARY_RANK,
            EMPLOYEE_ID,
            FIRST_NAME,
            SALARY
            FROM EMPLOYEES)
WHERE SALARY_RANK <= 7; -- ��ȸ�� ���� ���� : 7�� Ȯ���ϰ� 7���� ���� ��µȴ�. 

--TOP-N�м��� �߰����� ����� �� ����. �м��Լ��� ����ϸ�,  �߰����� ����� �� �ִ�. 
--�������� �޿��� ������������ ���������� 11~20������ ��ȸ�ϱ� 
SELECT *
FROM (SELECT DENSE_RANK() OVER(ORDER BY SALARY DESC) SALARY_RANK,
            EMPLOYEE_ID,
            FIRST_NAME,
            SALARY
            FROM EMPLOYEES)
WHERE SALARY_RANK >= 11 AND SALARY_RANK <= 20 ;  --��ȸ�� ���� ���� : 21��

--�������� �޿��� ������������ ���������� 11~12������ ��ȸ�ϱ� 
SELECT *
FROM (SELECT ROW_NUMBER() OVER(ORDER BY SALARY DESC) SALARY_RANK,
            EMPLOYEE_ID,
            FIRST_NAME,
            SALARY
            FROM EMPLOYEES)
WHERE SALARY_RANK >= 11 AND SALARY_RANK <= 20 ; -- ��ȸ�� ���� ���� :�׻� 10��
--���� ������ŭ�� ��ȸ�� 

--�������� �޿��� ������������ ���������� 11~12������ ��ȸ�ϱ� 
SELECT *
FROM (SELECT RANK() OVER(ORDER BY SALARY DESC) SALARY_RANK,
            EMPLOYEE_ID,
            FIRST_NAME,
            SALARY
            FROM EMPLOYEES)
WHERE SALARY_RANK >= 11 AND SALARY_RANK <= 20 ; --����� ����� ǥ���� �� , ��ȸ�� ���� ���� 10��
--WEB���� PAGINGó���� �� �Լ��� ���� ����Ѵ�. 
----------------------------------------------------------------------------
--���� �˻�
--������ ������ �̿��ؼ� ��/�� ���迡 �ִ� �����͸� ��ȸ�Ѵ�. 

--100�� ������ ������ ��ġ�ϰ� �ִ� ���� ��ȸ�ϱ� 
SELECT LEVEL, EMPLOYEE_ID, LPAD('-',(LEVEL-1)*5,'-') || FIRST_NAME
FROM EMPLOYEES
START WITH EMPLOYEE_ID = 100
CONNECT BY PRIOR EMPLOYEE_ID = MANAGER_ID AND LEVEL <= 2; --CONNECT BY�� �� �ٸ� ������ ���� �� �ִ�.

--101�� ������ ������ ��ġ�ϰ� �ִ� ���� ��ȸ�ϱ� 
SELECT LEVEL, EMPLOYEE_ID, LPAD('-',(LEVEL-1)*5,'-') || FIRST_NAME
FROM EMPLOYEES
START WITH EMPLOYEE_ID = 101 
CONNECT BY PRIOR EMPLOYEE_ID = MANAGER_ID AND LEVEL <= 2; --�ϳ������� LEVEL 2������ ����������

-- 205�� ������ ������ ��ġ�ϰ� �ִ� �Ŵ��� ��ȸ�ϱ� 
SELECT LEVEL , EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
START WITH EMPLOYEE_ID = 205
CONNECT BY PRIOR MANAGER_ID = EMPLOYEE_ID;
--�ڱ��ڽ��� ���� TOP LEVEL, �������� LEVEL���� �������. 
--SHELLY - >NEENA - >STEVEN 
------------------------------------------------------------------------------
--LEVEL�� CONNECT BY�� ���ӵ� ����/ ��¥ �����ϱ� 
--START WITH���� CONNECT BY�� ������ 

SELECT LPAD(LEVEL,2,'0') MONTH
FROM DUAL
CONNECT BY LEVEL <= 31; --0�ú��� 24�ñ��� ���� ��µǰ� �Ϸ��� �̷� ������� ���ӵ� ���ڸ� ����� �� �ִ�. 

--2004�⿡ �Ի��� �������� ������ ��� �Ի��ߴ��� ��ȸ�ϱ� 
SELECT TO_NUMBER(Y.MONTH) MONTH, NVL(X.CNT,0) CNT --NULL�̾��� Y�� MONTH�� ����ϰ�, NULL���� 0���� ������
FROM (SELECT TO_CHAR(HIRE_DATE, 'MM') MONTH, COUNT(*) CNT
      FROM EMPLOYEES --������ �Ի��� �κ��� ����� --�߰��� ���� �� ����
      WHERE HIRE_DATE > '2004/01/01' AND HIRE_DATE < TO_DATE('2004/12/31') + 1
      GROUP BY TO_CHAR(HIRE_DATE, 'MM')) X, 
     (SELECT LPAD(LEVEL, 2, '0') MONTH
      FROM DUAL
      CONNECT BY LEVEL <= 12) Y --1~12������ ��µǴ� �κ�(������) : �ζ��κ� �������� 
WHERE X.MONTH(+) = Y.MONTH --NULL���� ���Ե� �� �ֵ��� OUTER JOIN�� �̿��Ͽ� �����, Y�� �ִ°��� �ٳ����� �ϱ� ���ؼ� (+)�����
ORDER BY Y.MONTH ASC;

--������ �߰��� ������ �������� ������¥���� ��ü ������� Ư����¥�� ����ϰ� ����
--2021/10/01~2021/10/31������ ��¥�� �����ϱ� 
SELECT TO_DATE('2021/10/01','YYYY/MM/DD') + LEVEL -1
FROM DUAL 
CONNECT BY LEVEL <= TO_DATE('2021/10/31') - TO_DATE('2021/10/01')+1;
--���ӵ� ��¥, ���ӵ� ��, ������ ��¥, ������ ���� ǥ���ϰ� ���� �� �����ϰ� ����� �� �ִ�. 
--���������α׷��󿡼� ������� ǥ���ϴ� �κн� ǥ���Ҷ� �����ϰ� ��밡����

--������ �޿� 1000�޷� ������ �����ؼ� �޿��� �ο����� ��ȸ�ϱ� 
SELECT Y.SALARY, NVL(CNT, 0) NVL
FROM (SELECT TRUNC(SALARY,-3) SALARY , COUNT(*) CNT
                FROM EMPLOYEES 
                GROUP BY TRUNC(SALARY, -3)) X, --�����޿� ���ϴ� ����
            (SELECT LEVEL*1000 SALARY 
                FROM DUAL --1000���� 24000���������� ������ LEVEL *1000���� 1�� 1000���ͷ� �������. 
                CONNECT BY LEVEL <= 24 ) Y
 WHERE X.SALARY(+) = Y.SALARY
ORDER BY 1; --���� ���������ʰ� ����� �� �� �ִ�, �׷����� ��Ʈ�� �׸��� ����� �� �ִ�. 

SELECT LPAD(SALARY/1000,2,'*')
FROM EMPLOYEES;

------------------------------------------------------------------------------------------
--����� ���� �� ���Ѱ��� 