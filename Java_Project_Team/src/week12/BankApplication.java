package week12;

import java.util.Scanner;

public class BankApplication {
	// 길이가 100인 Account[] 배열로 계좌 관리
	private static Account[] accountArray = new Account[100];
	private static int accountCount = 0; // 생성된 계좌 수
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean run = true;
		
		while (run) {
			System.out.println("--------------------------------------------------------");
            System.out.println("1. 계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 잔고 | 6. 종료");
            System.out.println("--------------------------------------------------------");
            System.out.print("선택> ");

            String strNum = scanner.nextLine();

            if ("1".equals(strNum)) {
                createAccount(scanner);
            } else if ("2".equals(strNum)) {
            	listAccounts();
            } else if ("3".equals(strNum)) {
            	deposit(scanner);
            } else if ("4".equals(strNum)) {
            	withdraw(scanner);
            } else if ("5".equals(strNum)) {
            	showBalance(scanner);
            } else if ("6".equals(strNum)) {
            	run = false;
            } else {
                System.out.println("잘못된 메뉴입니다.");
            }
        }

        System.out.println("프로그램 종료");
        scanner.close();
	}
	
	// 계좌 생성 메소드
	private static void createAccount(Scanner scanner) {
		System.out.println("-------");
	    System.out.println("계좌생성");
	    System.out.println("-------");

	    System.out.print("계좌번호: ");
	    String acNumber = scanner.nextLine();

	    System.out.print("계좌주: ");
	    String acOwner = scanner.nextLine();

	    System.out.print("초기 입금액: ");
	    String balanceStr = scanner.nextLine();
	    int acBalance = Integer.parseInt(balanceStr);
	    
	    if (acBalance < 0) {
	    	System.out.println("초기 입금액은 음수가 될 수 없습니다.");
	    	return;
	    }
	        
	    // 배열에 계좌 추가
	    if (accountCount < accountArray.length) {
	    	accountArray[accountCount] = new Account(acNumber, acOwner, acBalance);
	    	accountCount++;
	    	System.out.println("결과: 계좌가 생성되었습니다.");
	    } else {
	    	System.out.println("결과: 계좌 생성 한도를 초과했습니다.");
	    }
	}
	
	// 계좌 목록 출력 메소드
	private static void listAccounts() {
		System.out.println("-------");
		System.out.println("계좌목록");
		System.out.println("-------");
		        
		if (accountCount == 0) {
			System.out.println("등록된 계좌가 없습니다.");
			return;
		}
		        
		for (int i = 0; i < accountCount; i++) {
			Account account = accountArray[i];
			System.out.printf("계좌번호: %s 계좌주: %s 잔고: %d\n",
					account.getNumber(), account.getOwner(), account.getBalance());
		}
	}
		
	// 예금 메소드
	private static void deposit(Scanner scanner) {
		System.out.println("-------");
		System.out.println("예금");
		System.out.println("-------");

		System.out.print("계좌번호: ");
		String acNumber = scanner.nextLine();

		System.out.print("예금액: ");
		String amountStr = scanner.nextLine();
		int amount = Integer.parseInt(amountStr);
		
		if (amount < 0) {
			System.out.println("예금액은 음수가 될 수 없습니다.");
			return;
		}
	        
		// 계좌 검색
		Account account = findAccount(acNumber);
		
		if (account == null) {
			System.out.println("결과: 계좌가 존재하지 않습니다.");
		} else {
			account.setBalance(account.getBalance() + amount);
			System.out.println("결과: 예금이 성공되었습니다.");
		}
	}
		
	// 출금 메소드
	private static void withdraw(java.util.Scanner scanner) {
		System.out.println("-------");
		System.out.println("출금");
		System.out.println("-------");

		System.out.print("계좌번호: ");
		String acNumber = scanner.nextLine();

		System.out.print("출금액: ");
		String amountStr = scanner.nextLine();
		int amount = Integer.parseInt(amountStr);
		
		if (amount < 0) {
			System.out.println("출금액은 음수가 될 수 없습니다.");
			return;
		}
	        
		Account account = findAccount(acNumber);
	        
		if (account == null) {
			System.out.println("결과: 계좌가 존재하지 않습니다.");
		} else if (amount > account.getBalance()) {
			System.out.println("결과: 잔고 이상을 출금할 수 없습니다.");
		} else {
			account.setBalance(account.getBalance() - amount);
			System.out.println("결과: 출금이 성공되었습니다.");
		}
	}
		
	// 잔고 조회 메소드
	private static void showBalance(Scanner scanner) {
		System.out.println("-------");
		System.out.println("잔고");
		System.out.println("-------");

		System.out.print("계좌번호: ");
		String acNumber = scanner.nextLine();

		Account account = findAccount(acNumber);
		
		if (account == null) {
			System.out.println("결과: 계좌가 존재하지 않습니다.");
		} else {
			System.out.println("잔고: " + account.getBalance());
		}
	}
		
	// 계좌 검색 메소드
	private static Account findAccount(String acNumber) {
		for (int i = 0; i < accountCount; i++) {
			if (accountArray[i].getNumber().equals(acNumber)) {
				return accountArray[i];
			}
		}
		return null;
	}
}