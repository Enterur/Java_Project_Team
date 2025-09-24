package week04;

import java.util.Scanner;

public class BankAccount {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean run = true;
		int total_account = 0;
		
		while (run) {
			System.out.println("----------------------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.println("----------------------------------");
			System.out.println("선택: ");
			
			String strNum = scanner.nextLine();
			
			if (strNum.equals("1")) {
				System.out.println("예금액> ");
				int increase_account = Integer.parseInt(scanner.nextLine());
				total_account += increase_account;
			} else if (strNum.equals("2")) {
				System.out.println("출금액> ");
				int decrease_account = Integer.parseInt(scanner.nextLine());
				
				if (decrease_account > total_account) {
					System.out.println("잔고 이상을 춤금할 수 없습니다.");
				} else {
					total_account -= decrease_account;
				}
			} else if (strNum.equals("3")) {
				System.out.println("잔고> " + total_account);
			} else if (strNum.equals("4")) {
				run  = false;
			}
		}
		
		System.out.println("프로그램 종료");
	}

}