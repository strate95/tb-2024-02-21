package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class App {
    Scanner scanner;
    int goodsaynum;
    List<WSlist> WSlists;
    App(){
        scanner = new Scanner(System.in);
        goodsaynum = 1;
        WSlists = new ArrayList<>();
    }
    void run() {
        System.out.println("프로그램 실행");
        System.out.println("== 명언 앱 ==");
        while(true) {
            System.out.print("명령) ");
            String order = scanner.nextLine();
            if (order.equals("종료")) {
                break;
            }
            else if (order.equals("등록")) {
                orderwrite();
            }
            else if (order.equals("목록")){
                orderlist();
            }
            else {
                System.out.println("입력받은 명령) " + order + "(은)는 존재하지 않는 명령입니다.");
                System.out.println("다시 명령을 내려주세요.");
            }
        }
    }
    void orderwrite(){
        System.out.print("명언 : ");
        String contents = scanner.nextLine();
        System.out.print("작가 : ");
        String author = scanner.nextLine();
        System.out.println("명언) " + contents);
        System.out.println("작가) " + author);
        WSlist WS = new WSlist(goodsaynum, contents, author);
        WSlists.add(WS);
        System.out.println(goodsaynum++ + "번 명언이 등록되었습니다.");
    }
    void orderlist(){
        System.out.println("번호 / 작가 / 명언");
        System.out.println("---------------------------------------");
        if (WSlists.isEmpty()){
            System.out.println("등록된 명언이 없습니다.");
        }
        else {
            for (int i = WSlists.size() - 1; i >= 0; i--) {
                WSlist WS = WSlists.get(i);
                System.out.println(WS.num + " / " + WS.content + " / " + WS.author);
            }
        }
    }
}

