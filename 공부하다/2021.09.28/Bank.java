package com.example;


public class Bank{
    private Account[] database = new Account[100];
    private int position = 0;

    public Bank() {
        database[position++] = new Account("101-11-000001", "김수영", 1234, 1_000_000L, 23, 0.01);
        database[position++] = new Account("101-11-000002", "김민수", 1234, 1_500_000L, 10, 0.02);
        database[position++] = new Account("101-11-000003", "김윤주", 1234, 2_500_000L, 12, 0.01);
        database[position++] = new Account("101-11-000004", "김민수", 1234, 4_000_000L, 24, 0.015);
        database[position++] = new Account("101-11-000005", "이루리", 1234, 7_000_000L, 35, 0.011);
        database[position++] = new Account("101-11-000006", "운지영", 1234, 8_000_000L, 36, 0.013);
        database[position++] = new Account("101-11-000007", "박문치", 1234, 6_500_000L, 5, 0.018);
        database[position++] = new Account("101-11-000008", "최정윤", 1234, 1_000_000L, 12, 0.02);
        database[position++] = new Account("101-11-000009", "소수빈", 1234, 1_200_000L, 16, 0.021);
        database[position++] = new Account("101-11-000010", "서자영", 1234, 1_001_000L, 20, 0.023);
        database[position++] = new Account("101-11-000011", "소수빈", 1234, 1_020_000L, 30, 0.03);
        database[position++] = new Account("101-11-000012", "최정윤", 1234, 3_200_000L, 8, 0.025);
        database[position++] = new Account("101-11-000013", "서자영", 1234, 5_000_000L, 9, 0.02);
        database[position++] = new Account("101-11-000014", "박세진", 1234, 2_100_000L, 21, 0.001);
        database[position++] = new Account("101-11-000015", "김윤주", 1234, 3_020_000L, 28, 0.008);
        database[position++] = new Account("101-11-000016", "김수영", 1234, 5_000_000L, 30, 0.01);
        database[position++] = new Account("101-11-000017", "최유리", 1234, 3_000_000L, 27, 0.02);
    }
/**
 * 계좌아이디를 전달받아서 계좌정보를 반환하는 기능
 * @param accId 계좌아이디
 * @return 계좌정보 , 계좌 아이디가 잘못되었을 경우 null값을 회신한다. 
 */
	 private Account getAccount(String accId) { //private로 선언되었기 때문에 not used이기 때문에 노란줄이 감
		 //발견된 Account객체의 주소값을 저장할 참조변수 선언
		 Account foundAccount = null;
		 //database배열에 저장된 Account객체의 주소값을 참조변수 account에 저장한다. 
 		 for(Account databases : database) {
 			 //Account참조변수에 대입된 값이 null아니고, account가 참조하는 객체의 아이디와 비밀번호가 일치하면 
 			 if(databases != null && databases.getId().equals(accId)) {
 				 //현재 조회된 account객체의 주소값을 foundAccount참조변수에 대입한다. 
 				 foundAccount = databases;
 				//계좌 아이디와 일치하는 계좌정보를 찾았음으로 반복을 중단한다. 
 				 break;
 			 }
 			 }
 		 return foundAccount;
 		 }
	 
    /**
     * 전계좌 조회하기
     * 소유자명을 전달받아서 해당 소유자의 모든 계좌정보를 화면에 출력한다.
     * @param ownerName 소유자명
     */
    public void displayMyAccounts(String ownerName) {
    	//소유자의 이름을 입력해야지 계좌 정보를 출력해줌
    	//System.out.println("### [ " + ownerName + "]님 전계좌 조회");
    	
    	for (Account databases : database) {
    		//배열에 저장된 databases 객체의 주소값을 순서대로 가져와서 databases참조변수에 대입한다. 
    		if(databases == null) { //account!=null 이면 (조회된 Account객체의 주소값이 null이 아니면)
				break; //String accountOwnerName = account.getOwner();//입력해줌 , 강사님입력(조회된 Account객체의 소유주이름을 조회한다. )
				//조회된 계좌의 소유주 이름과 매개변수로 전달받은 소유주 이름이 일치하면
			} 
    		if(databases.getOwner().equals(ownerName)) {
    			//account참조변수가 참조하는 Account객체의 계좌아이디, 잔액, 납입기간을 화면에 출력한다
    			System.out.println("------------------------");
    			System.out.println("계좌번호 : "+databases.getId());
    			System.out.println("이름 : "+databases.getOwner());
    			System.out.println("현재 잔액 : "+databases.getBalance());
    			System.out.println("납입 기간 : "+databases.getDepositPeriod());
    			System.out.println("이자율 : "+databases.getInterestRate());
   			
    			
    			}
    		}
    	}


    /**
     * 계좌상세정보 조회하기
     * 계좌아이디와 비밀번호를 전달받아서 상세 계좌정보를 출력한다.<br />
     * 지정된 계좌아이디가 없는 경우 오류 메세지를 표시한다.<br />
     * 비밀번호가 틀린 경우 오류 메세지를 표시한다.
     * @param id 계좌 아이디
     * @param password 비밀번호
     */
    public void displayAccountInfo(String id, int password) {

    	System.out.println("["+id+"]를 조회합니다. ");
    	Account account = this.getAccount(id);
    	if (account ==null) {
    		System.out.println("### 오류 : 일치하는 계좌정보가 존재하지 않습니다. ");
    		return;//빠른 종료
    	}
    	if(account.getPassword() != password) {
    		System.out.println("### 오류 : 비밀번호가 일치하지 않습니다. ");
    		return; // 빠른종료
    	}
    	System.out.println("------------------------");
		System.out.println("계좌번호 : "+account.getId());
		System.out.println("이름 : "+account.getOwner());
		System.out.println("현재 잔액 : "+account.getBalance());
		System.out.println("납입 기간 : "+account.getDepositPeriod());
		System.out.println("이자율 : "+account.getInterestRate());
		
    }
	
    /**
     * 비밀번호 변경하기
     * 계좌아이디, 이전 비밀번호, 새 비밀번호를 전달받아서 계좌의 비밀번호를 변경한다.<br />
     * 지정된 계좌아이디가 없는 경우 오류 메세지를 표시한다.<br />
     * 비밀번호가 틀린 경우 오류 메세지를 표시한다. <br />
     * 이전 비밀번호와 새 비밀번호가 같은 경우 오류 메세지를 표시한다.
     * @param id 계좌아이디
     * @param oldPassword 이전 비밀번호
     * @param newPassword 새 비밀번호
     */
    public void changePassword(String id, int oldPassword, int newPassword) {
    	Account account = this.getAccount(id);
    
    	if(account == null) {
    		//만약 아이디가 null값이라면
    		System.out.println("아이디를 잘 못 입력하셨습니다.");
    		return;// 빠른 종료
    	}
    	int passwordOwner = account.getPassword();
    	if(  oldPassword != passwordOwner && oldPassword == newPassword ) {
    		//예전비밀번호와 설정비밀번호가 다를경우 
    		System.out.println("비밀번호를 잘 못 입력하셨습니다. ");
    		return;// 빠른 종료
    	}
    	account.setPassword(newPassword); 
    	//괜찮으면 비밀번호를 셋팅하고 새로운비밀번호로 
    	System.out.println("비밀번호변경이 완료 되었습니다.");
    	
    	
    
    }
    
    /**
     * 입금하기
     * 계좌아이디와 입금액을 전달받아서 계좌의 잔액을 증가시키고, 변경된 잔액을 표시한다. <br />
     * 지정된 계좌아이디가 없는 경우 오류 메세지를 표시한다.
     * @param id 계좌아이디
     * @param amount 입금액
     */
    public void deposit(String id, long amount) {
    	if(amount<= 0) {
    	System.out.println("오류: 입금액은 0보다 크거나 작을 수 없습니다.");	
    	return;
    	}
    	Account account = this.getAccount(id); //아이디가 동일하다면
    	if(account == null) {
    		//만약 아이디가 null값이라면
    		System.out.println("아이디를 잘 못 입력하셨습니다.");
    		return;// 빠른 종료
    	}
    	long balance = account.getBalance();
    	//입금전의 금액이 입력이 되었다. 
    	account.setBalance(balance+amount);
    	//account.getBalance += amount//이런 공식은 존재하지 않음
    	System.out.println("입금이 완료 되었습니다.");
    	System.out.println(account.getBalance());
    			
    }
    
    /**
     * 출금하기
     * 계좌아이디, 비밀번호, 출금액을 전달받아서 출금액만큼 잔액을 감소시키고, 변경된 잔액을 표시한다.
     * 지정된 계좌아이디가 없는 경우 오류 메세지를 표시한다.<br />
     * 비밀번호가 틀린 경우 오류 메세지를 표시한다. <br />
     * 출금액보다 잔액이 작은 경우 오류 메세를 표시한다.
     * @param id 계좌 아이디
     * @param password 비밀번호
     * @param amount 출금액
     */
    public void withdraw(String id, int password, long amount) {
    	if(amount<= 0) {
        	System.out.println("오류: 입금액은 0보다 크거나 작을 수 없습니다.");	
        	return;
        	}
    	Account account = this.getAccount(id);
    	if(account == null ) {
    		System.out.println("계좌정보를 잘 못 입력하셨습니다. ");
    		return;
    	}
    	int OwnerPassword = account.getPassword();
    	if(password == 0 && password != OwnerPassword) {
    		//비밀번호가 0이거나 그리고 비밀번호가 다를 경우 
    		System.out.println("비밀번호를 잘 못 입력하셨습니다. ");
    		return; //빠른 종료
    	}
    	long ownerBalance = account.getBalance();
    	//출금전의 잔액이 입력이 들어감
    	if(ownerBalance == 0 && ownerBalance<amount) {
    		//통장 잔액이 출금액보다 작거나 같은경우 
    		System.out.println("출금액보다 잔액이 작습니다. ");
    		return; //빠른 종료
    	}
    	account.setBalance(ownerBalance-amount);
    	System.out.println("출금이 완료되었습니다. ");
    	System.out.println(account.getBalance()+ "원이 남았습니다. ");
    
    
    
    }
    
    /**
     * 이체하기
     * 계좌아이디, 상대방 계좌아이디, 비밀번호, 이체금액을 전달받아서 이체금액만큼 잔액을 감소시키고, 상대방 계좌의 잔액을 이체금액만큼 증가시키고, 변경된 잔액을 표시한다.
     * 지정된 계좌아이디가 없는 경우 오류 메세지를 표시한다.<br />
     * 지정된 상대방 계좌아이디가 없는 경우 오류 메세지를 표시한다.<br />
     * 비밀번호가 틀린 경우 오류 메세지를 표시한다. <br />
     * 이체금액보다 잔액이 작은 경우 오류 메세를 표시한다.
     * @param id 계좌아이디
     * @param otherId 상대방 계좌아이디
     * @param password 비밀번호
     * @param amount 이체금액
     */
    public void transfer(String id, String otherId, int password, long amount) {
    	if(amount<=0) {
    		System.out.println("오류 : 이체금액이 0보다 작거나 같을 수 없습니다.");
    		 return;
    	}
    	Account account = this.getAccount(id);
    	if(account == null ) {
    		System.out.println("계좌 정보가 맞지 않습니다. ");
    		return;
    	}
    	Account account1 = this.getAccount(otherId);
    	//변수를 새롭게 설정하여 상대방 아이디로 입력을 함.
    	if(account1 == null) {
    		System.out.println("상대방의 계좌 정보가 맞지 않습니다.");
    		return;
    	}
    	int ownerPassword = account.getPassword();
    	if(ownerPassword ==0 && ownerPassword != password) {
    		System.out.println("비밀번호가 맞지 않습니다.");
    		return;
    	}
    	long otherBalance = account1.getBalance();
    	long ownerBalance = account.getBalance();
    	if(ownerBalance <amount) {
    		System.out.println("잔액이 부족합니다. ");
    		return;
    	}
    	account1.setBalance(otherBalance + amount);
    	account.setBalance(ownerBalance-amount);
    	System.out.println("이체가 완료 되었습니다.");
    	System.out.println("상대방의 계좌잔액은 :" + account1.getBalance());
    	System.out.println("이체하신분의 계좌잔액은 :" + account.getBalance());
    	//검사를 한다고 하면 전부 제어문이 필요하다.
    }
  
   
    
    /**
     * 해지환급금 계산하기
     * 계좌아이디, 비밀번호를 전달받아서 해지환금급을 계산해서 표시한다. <br />
     * 지정된 계좌아이디가 없는 경우 오류 메세지를 표시한다.<br />
     * 비밀번호가 틀린 경우 오류 메세지를 표시한다. <br />
     * @param id 계좌아이디
     * @param password 비밀번호
     */
    public void calculateCancellationRefund(String id, int password) {
    	Account account = this.getAccount(id);
    	if(account == null) {
    		System.out.println("계좌 정보가 없습니다.");
    		return;
    	}
    	int ownerPassword = account.getPassword();
    	if(ownerPassword == 0 && password != ownerPassword) {
    		//비밀번호가 없거나 비밀번호가 다르다면 
    		System.out.println("비밀번호가 다릅니다. ");
    		return;//빠른종료
    	}
    	long ownBalance = account.getBalance(); //현재잔액
    	int yearDeposit = account.getDepositPeriod()/12; //납입 년도
    	double ownRate = account.getInterestRate(); // 1년이자 
    	
    	double interest = yearDeposit * ownRate;
    	System.out.println("해지환금금 계산이 완료 되었습니다. ");
    	long refund = (long)(ownBalance+interest);
    	System.out.println("입금하긴 년도는 " + yearDeposit + "입니다");
    	System.out.println("해지환급금의 이자는 " + interest + "입니다");
    	System.out.println("해지환급금은" +refund + "입니다.");
    	
  
    }
    }
 			

