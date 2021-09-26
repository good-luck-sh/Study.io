package Homework;

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
     * 전계좌 조회하기
     * 소유자명을 전달받아서 해당 소유자의 모든 계좌정보를 화면에 출력한다.
     * @param ownerName 소유자명
     */
    public void displayMyAccounts(String ownerName) {
    	for (Account databases : database) {
    		
    		if(databases == null) {
				break;
			} 
    		if(databases.getOwner().equals(ownerName)) {
    			System.out.println("------------------------");
    			System.out.println("계좌번호 : "+databases.getId());
//    			System.out.println("이름 : "+databases.getOwner());
//    			System.out.println("현재 잔액 : "+databases.getBalance());
//    			System.out.println("납입 기간 : "+databases.getDepositPeriod());
//    			System.out.println("이자율 : "+databases.getInterestRate());
    			
    			} else if (!(databases.getOwner().equals(ownerName))) {
    				System.out.println("이름이 없습니다.");
    				break;
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
        for(Account databases : database) {
        	if(databases == null) {
				break;
			}
        	if(!(databases.getId().equals(id))) {
        		System.out.println("아이디가 없습니다.");
        		break;
        	}	else {
        		if(databases.getPassword() == password) {
        			System.out.println("------------------------");
        			System.out.println("계좌번호 : "+databases.getId());
        			System.out.println("이름 : "+databases.getOwner());
        			System.out.println("현재 잔액 : "+databases.getBalance());
        			System.out.println("납입 기간 : "+databases.getDepositPeriod());
        			System.out.println("이자율 : "+databases.getInterestRate());
        		} else {
        			System.out.println("비밀번호가 틀렸습니다.");
        			break;
        		} 
        	}
    }
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
    	  for(Account databases : database) {
          	if(databases == null) {
  				break;
  			}
          	if(databases.getId().equals(id)) {
          		if(databases.getPassword() == oldPassword) {
          			if(newPassword != oldPassword) {
          				databases.setPassword(newPassword);
              			System.out.println("변경하실 비밀번호가 " + newPassword + "으로 변경되었습니다.");
          			} else {
          				System.out.println("중복된 비밀번호 입니다.");
          				System.out.println(" 다시 진행하세요.");
          			}
          		} else {
          			System.out.println("비밀번호가 틀렸습니다.");
          			break;
          		} }else if(!(databases.getId().equals(id))) {
            		System.out.println("아이디가 없습니다.");
            		break;
          	} 
      }
    }
    
    /**
     * 입금하기
     * 계좌아이디와 입금액을 전달받아서 계좌의 잔액을 증가시키고, 변경된 잔액을 표시한다. <br />
     * 지정된 계좌아이디가 없는 경우 오류 메세지를 표시한다.
     * @param id 계좌아이디
     * @param amount 입금액
     */
    public void deposit(String id, long amount) {
    	  for(Account databases : database) {
            	if(databases == null) {
    				break;
    			}
            	if(databases.getId().equals(id)) {
            	System.out.println("입금 전 금액은"+databases.getBalance()+"입니다.");
            	databases.setBalance(databases.getBalance()+amount);
            	System.out.println("총 금액은 " +databases.getBalance() +"입니다.");
            	} else  {
            		System.out.println("아이디가 없습니다.");
            		break;
            	}
        }
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
    	  for(Account databases : database) {
          	if(databases == null) {
  				break;
  			}
          	if(databases.getId().equals(id)) {
          		if(databases.getPassword() == password) {
          			if(databases.getBalance()>amount) {
          				System.out.println("입금 전 금액은"+databases.getBalance()+"입니다.");
                    	databases.setBalance(databases.getBalance()-amount);
                    	System.out.println("총 금액은 " +databases.getBalance() +"입니다.");
                	} else {
                		System.out.println("잔액이 부족합니다.");
                		break;
                	}
                
          		} else {
          			System.out.println("비밀번호가 틀렸습니다.");
          			break;
          		} 
          		}else {
            		System.out.println("아이디가 없습니다.");
            		break;
}}}
    
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
  	  for(Account databases : database) {
        	if(databases == null) {
				break;
			}
        	if(databases.getId().equals(id)) {
        		if(databases.getPassword() == password) {
        			System.out.println("출금 전 금액은"+databases.getBalance()+"입니다.");
        			if(databases.getBalance()>amount) {
        				System.out.println("이체하실 금액은 " +amount+"입니다.");
        				databases.setBalance(databases.getBalance()-amount);
        				System.out.println("통장의 잔액은" + databases.getBalance() + "입니다");
        				System.out.println("이체하실 계좌번호는" + otherId +"입니다.");
        				if(databases.getId().equals(otherId)) {//만약otherId가 같으면 
                			databases.setBalance(databases.getBalance()+amount);//setter메소드로 금액을 변경함
                			System.out.println("이체받으시는 분 통장 잔액은 "+databases.getBalance()+"입니다");//잔액을 출력함.
                      		 //이체 받으시는 분의 통장 잔액 변경은 입력이 되지 않습니다. 
                			// 어떻게 입력을 해야할지 답안확인 때 확인하겠습니다. 
        			}}
        			else {
                		System.out.println("잔액이 부족합니다.");
                		break;
                	}
        			
        		}else {
          			System.out.println("비밀번호가 틀렸습니다.");
          			break;
        		}
        		}else {
            		System.out.println("아이디가 없습니다.");
            		break;
        		}
			}
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
    	 for(Account databases : database) {
         	if(databases == null) {
 				break;
 			}
         	if(databases.getId().equals(id)) {
         		if(databases.getPassword() == password) {
         			System.out.println("해지전 잔액은 "+databases.getBalance()+" 입니다.");
         			long refund = (long)( databases.getDepositPeriod()*databases.getInterestRate()*databases.getBalance());
         			System.out.println("이자율은" + databases.getInterestRate() + "입니다");
         			System.out.println("납입기간은" + databases.getDepositPeriod() + "개월 입니다");
         			System.out.println("해지환급이자는" + refund + "입니다.");
         			long amount = (databases.getBalance()+refund);
         			System.out.println("통장해지금액은" + amount + "입니다.");
         			
         			
         		}else {
           			System.out.println("비밀번호가 틀렸습니다.");
           			break;
         		}
         		}
         		}
 			}
         		}


