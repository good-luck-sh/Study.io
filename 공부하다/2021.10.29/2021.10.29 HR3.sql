--�ζ��κ� 

--�μ��� �ο����� ��ȸ�ؼ� �μ��� �ο����� 10�� �̸��� �μ��� ���̵�, �μ���, �ο����� ��ȸ�ϱ�
SELECT V.DEPARTMENT_ID, D.DEPARTMENT_NAME, V.CNT -- ������ ���̺��� ������
FROM ( --�̰���ü�� ������ ���̺�� ��, �� ������ �������� ��µ� V��� ������ ���̺�
SELECT DEPARTMENT_ID, COUNT(*) CNT --�Լ��� �������� ��Ī�� �ִ� ���� �������࿡ ���ϴ�.
FROM EMPLOYEES
WHERE DEPARTMENT_ID IS NOT NULL
GROUP BY DEPARTMENT_ID ) V , DEPARTMENTS D
WHERE V.CNT < 10; --��Ī�� �����ͼ� ���ǽ��� �Ǵ�.

--���� �ȿ� �����ϴ� ���� : ����������� �θ���. 
--������������ �ζ��κ䰡 �����ϴ� ����

--�ε���

 SELECT ROWID, EMPLOYEE_ID, FIRST_NAME
 FROM EMPLOYEES;
 --AAAStQ AAH AAAAGl AAA
 --������Ʈ ��ȣ (���̺� ���� �ٸ���)
 --���Ϲ�ȣ (���� ���Ͽ� ����� ��ȣ��.)
 --��Ϲ�ȣ 
 --���ȣ (���Ϲ�ȣ )
 SELECT ROWID, PRODUCT_NO, PRODUCT_NAME
 FROM TB_SAMPLE_PRODUCTS;
 --AAAS83 AAH AAAAIGAAA
 
 --�ε��� 
 --ROWID�� �������� �ִ�. 
 SELECT *
 FROM TB_SAMPLE_FOODS
 WHERE FOOD_NO = 5001;
 ----���� �̸��� ���ؼ� �ε����� �����غ��� , �ε��� ��ڿ��� IDX�� ���� ����
 CREATE INDEX FOOD_NAME_IDX
 ON TB_SAMPLE_FOODS(FOOD_NAME);
 
  SELECT *
 FROM TB_SAMPLE_FOODS
 WHERE FOOD_NAME = '�����';