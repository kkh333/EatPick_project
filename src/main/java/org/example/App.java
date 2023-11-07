package org.example;

import org.example.article.controller.ArticleController;
import org.example.db.DBConnection;
import org.example.member.controller.MemberController;
import org.example.member.service.MemberService;
import org.example.system.controller.SystemController;

public class App {
    public App () {
        DBConnection.DB_NAME = "proj1";
        DBConnection.DB_USER = "root";
        DBConnection.DB_PASSWORD = "";
        DBConnection.DB_PORT = 3306;

        Container.getDBconnection().connect();
    }

    public void run() {
        SystemController systemController = new SystemController();
        MemberController memberController = new MemberController();
        ArticleController articleController = new ArticleController();

        System.out.println("== Eat Pick 시작 ==");
        System.out.println("명령어 입력은 숫자로 입력해도 되고 한글로 입력해도 됩니다.");

        Container.meneList1();

        while (true) {
            System.out.printf("명령어) ");
            String command = Container.getSc().nextLine();

            switch (command) {
                case "종료":
                    systemController.exit();
                    return;
            }

            if (Container.getLoginedMember() == null) {
                switch (command) {
                    case "로그인":
                    case "1":
                        memberController.login();
                        break;
                    case "회원가입":
                    case "2":
                        memberController.join();
                        break;
                    case "3":
                        systemController.exit();
                        return;
                }
            }
            else if (Container.getLoginedMember() != null) {
                switch (command) {
                    case "게시글 등록":
                    case "1":
                        articleController.write();
                        break;
                    case "게시글 수정":
                    case "2":
                        articleController.modify();
                        break;
                    case "게시글 삭제":
                    case "3":
                        articleController.remove();
                        break;
                    case "나의 게시글":
                    case "4":
                        articleController.myPost();
                        break;
                    case "전체 게시글":
                    case "5":
                        articleController.allPost();
                        break;
                    case "카테고리 검색":
                    case "6":
                        articleController.categoryPost();
                        break;
                    case "음식명 검색":
                    case "7":
                        articleController.foodNamePost();
                        break;
                    case "브랜드명 검색":
                    case "8":
                        articleController.brandNamePost();
                        break;
                    case "작성자 검색" :
                    case "9" :
                        articleController.writerPost();
                        break;
                    case "로그아웃":
                    case "10":
                        memberController.logout();
                        break;
                    case "11":
                        systemController.exit();
                        return;
                }
            }
        }
    }
}
