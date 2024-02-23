package com.ll;

import java.util.Scanner;

class App {
    void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("프로그램 실행");
        System.out.println("== 명언 앱 ==");
        System.out.print("명령) ");
        String order = scanner.nextLine();
        while(true) {
            if (order.equals("종료")) {
                break;
            }
            else {
                System.out.println("입력받은 명령) " + order);
                System.out.print("명령) ");
            }
            order = scanner.nextLine();
        }
    }
}
