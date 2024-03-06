package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class App {
    Scanner scanner;
    int goodsaynum;
    List<WSlist> WSlists;

    App() {
        scanner = new Scanner(System.in);
        goodsaynum = 1;
        WSlists = new ArrayList<>();
    }

    void run() {
        System.out.println("프로그램 실행");
        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.print("명령) ");
            String order = scanner.nextLine();
            Rq rq = new Rq(order);
            System.out.println("입력받은 명령 : " + rq.getAction());
            System.out.println("입력받은 id : " + rq.getParamAsInt("id", 0));
            switch (rq.getAction()) {
                case "종료":
                    return;
                case "등록":
                    orderwrite();
                    break;
                case "목록":
                    orderlist();
                    break;
                case "삭제":
                    orderdelete(rq);
                    break;
                case "수정":
                    ordermodify(rq);
                    break;
            }
        }
    }

    void orderwrite() {
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

    void orderlist() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("---------------------------------------");
        if (WSlists.isEmpty()) {
            System.out.println("등록된 명언이 없습니다.");
        } else {
            for (int i = WSlists.size() - 1; i >= 0; i--) {
                WSlist WS = WSlists.get(i);
                System.out.println(WS.num + " / " + WS.content + " / " + WS.author);
            }
        }
    }

    int getIndexofgoodsayingbyid(int id) {
        for (int i = 0; i < WSlists.size(); i++) {
            WSlist ws = WSlists.get(i);
            if (ws.num == id) {
                return i;
            }
        }
        return -1;
    }

    void orderdelete(Rq rq) {
        int removeid = rq.getParamAsInt("id", 0);
        int index = getIndexofgoodsayingbyid(removeid);
        if (index == -1) {
            System.out.println("입력하신 번호의 명언이 없습니다. 정확한 번호를 입력해 주세요");
        } else {
            WSlists.remove(index);
            System.out.println(removeid + "번 명언이 삭제되었습니다");
        }
    }

    void ordermodify(Rq rq) {
        int modifyid = rq.getParamAsInt("id", 0);
        int index = getIndexofgoodsayingbyid(modifyid);
        if (index == -1) {
            System.out.println("입력하신 번호의 명언이 없습니다. 정확한 번호를 입력해 주세요");
        } else {
            WSlist ws = WSlists.get(index);
            System.out.println("명언(기존) : " + ws.content);
            System.out.print("수정할 명언 : ");
            String newcontent = scanner.nextLine();
            System.out.println("작가(기존) : " + ws.author);
            System.out.print("수정할 작가 : ");
            String newauthor = scanner.nextLine();
            WSlist newws = new WSlist(modifyid, newcontent, newauthor);
            WSlists.set(index, newws);
            System.out.println("수정된 명언 : " + newcontent);
            System.out.println("수정된 작가 : " + newauthor);
        }
    }
}
