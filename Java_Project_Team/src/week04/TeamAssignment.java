package ch04.sec05;

import java.util.Scanner;

public class TeamAssignment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bank = 0;
        
        while (true) {
            System.out.println("----------------------------");
            System.out.println("1. 예금 | 2.출금 | 3.잔고 | 4.종료");
            System.out.println("----------------------------");
            System.out.print("선택> ");
            
            String choice = scanner.nextLine();
            
            if (choice.equals("1")) {
                System.out.print("예금액> ");
                int money = scanner.nextInt();
                bank += money;
                scanner.nextLine();
            } else if (choice.equals("2")) {
                System.out.print("출금액> ");
                int money = scanner.nextInt();
                bank -= money;
                scanner.nextLine(); 
            } else if (choice.equals("3")) {
                System.out.println("잔고> " + bank);
            } else if (choice.equals("4")) {
                System.out.println("\n프로그램 종료");
                break;
            }
        }
        scanner.close();
    }
}
