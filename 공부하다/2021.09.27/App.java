package com.example;

import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Bank bank = new Bank();
        //bank라는 객체를 실행시켜야하기 때문에 bank라는 객체 new 연산자로 생성함
        //계좌 관련 조회/ 비밀번호 변경/ 입출금/ 이체/ 해지환급금조회 등의 기능을 제공하는 객체 생성하기 

        while (true) {
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("1.전계좌조회 2.계좌상세조회 3.비밀번호변경 4.입금하기 5.출금하기 6.이체하기 7.해지환급금조회 0.종료");
            System.out.println("--------------------------------------------------------------------------------");

            System.out.print("메뉴를 선택하세요: ");
            int menuNo = scan.nextInt();

            if (menuNo == 1) {
            	System.out.println("[나의 전계좌 조회하기]");
            	System.out.println("조회하실 분의 성함을 입력하세요 :");
            	//사람을 조회할 예정이기 때문에 문자열로 전달 받아야함.
            	 String name = scan.next();
            	 bank.displayMyAccounts(name);

            } else if (menuNo == 2) {
            	System.out.println("[계좌 상세정보 조회하기]");
            	
            	System.out.println("조회하실 계좌 아이디를 입력하세요 :");
            	String id = scan.next();
            	
            	System.out.println("조회하실 계좌 비밀번호를 입력하세요 :");
            	int password = scan.nextInt();
            	
            	bank.displayAccountInfo(id, password);
            	
            } else if (menuNo == 3) {
            	System.out.println("[비밀번호 변경하기]");
            	System.out.println("조회하실 계좌 아이디를 입력하세요 :");
            	String id = scan.next();
            	System.out.println("조회하실 계좌 비밀번호를 입력하세요 :");
            	int oldpassword = scan.nextInt();
            	System.out.println("변경하실 비밀번호를 입력하세요 :");
            	int newPassword = scan.nextInt();
            	bank.changePassword(id, oldpassword, newPassword);

            } else if (menuNo == 4) {
            	System.out.println("[입금하기]");
            	System.out.println("조회하실 계좌 아이디를 입력하세요 :");
            	String id = scan.next();
            	System.out.println("입금하실 금액을 입력하세요 : ");
            	long deposit = scan.nextLong();
            	bank.deposit(id, deposit);
            	
            } else if (menuNo == 5) {
            	System.out.println("[출금하기]");
            	System.out.println("조회하실 계좌 아이디를 입력하세요 :");
            	String id = scan.next();
            	System.out.println("조회하실 계좌 비밀번호를 입력하세요 :");
            	int password = scan.nextInt();
            	System.out.println("출금하실 금액을 입력하세요 : ");
            	long remove = scan.nextLong();
            	bank.withdraw(id, password, remove);
            	
            } else if (menuNo == 6) {
            	System.out.println("[이체하기]");
            	System.out.println("조회하실 계좌 아이디를 입력하세요 :");
            	String id = scan.next();
            	System.out.println("조회하실 계좌 비밀번호를 입력하세요 :");
            	int password = scan.nextInt();
            	System.out.println("이체 할 상대방 계좌아이디를 입력하세요 :");
            	String otherId = scan.next();
            	System.out.println("출금하실 금액을 입력하세요 : ");
            	long remove = scan.nextLong();
            	bank.transfer(id, otherId, password, remove);
            	
            	
            } else if (menuNo == 7) {
            	System.out.println("[해지환급금 조회하기]");
            	System.out.println("조회하실 계좌 아이디를 입력하세요 :");
            	String id = scan.next();
            	System.out.println("조회하실 계좌 비밀번호를 입력하세요 :");
            	int password = scan.nextInt();
            	bank.calculateCancellationRefund(id, password);
            	
            } else if (menuNo == 0) {
                System.out.println("[프로그램 종류]");
                break;
            }

            System.out.println();
            System.out.println();
            System.out.println();
        }

        scan.close();
    }
}