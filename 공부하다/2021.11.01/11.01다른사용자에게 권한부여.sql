--다른 사용자에게 데이터베이스 객체를 엑세스할 수 있는 권한 부여하기 
--HTA 사용자에게 EMPLOYEES테이블의 데이터를 조회할 수 있는 권한 부여하기 
GRANT SELECT
ON EMPLOYEES
TO HTA;

--HTA 사용자에게 HR 사용자의 모든 테이블의 데이터를 조회할 수 있는 권한 부여하기 
GRANT SELECT 
ON DEPARTMENTS
TO HTA;

