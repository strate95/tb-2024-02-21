package com.ll;

import java.util.Scanner;

class App {
    void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("프로그램 실행");
        System.out.println("== 명언 앱 ==");
        System.out.print("명령) ");
        String order = scanner.nextLine();
        int goodsaynum = 1;
        while(true) {
            if (order.equals("종료")) {
                break;
            }
            else if (order.equals("등록")) {
                System.out.print("명언 : ");
                String contents = scanner.nextLine();
                System.out.print("작가 : ");
                String author = scanner.nextLine();
                System.out.println("명언) " + contents);
                System.out.println("작가) " + author);
                System.out.println(goodsaynum++ +"번 명언이 등록되었습니다.");
            }
            else {
                System.out.println("입력받은 명령) " + order + "(은)는 존재하지 않는 명령입니다.");
                System.out.println("다시 명령을 내려주세요.");
            }
            System.out.print("명령) ");
            order = scanner.nextLine();
        }
    }
}
