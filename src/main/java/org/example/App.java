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
                        memberController.login();
                        break;
                    case "회원가입":
                        System.out.println("비밀번호는 9자 이상, 영문과 특수문자가 포함되어야 합니다.");
                        memberController.join();
                        break;
                }
            }
            else if (Container.getLoginedMember() != null) {
                switch (command) {
                    case "로그아웃":
                        memberController.logout();
                        break;
                    case "게시글 등록":
                        articleController.write();
                        break;
                    case "게시글 수정":
                        articleController.modify();
                        break;
                    case "게시글 삭제":
                        articleController.remove();
                        break;
                    case "나의 게시글":
                        articleController.myPost();
                        break;
                    case "전체 게시글":
                        articleController.allPost();
                        break;
                    case "카테고리 검색":
                        articleController.categoryPost();
                        break;
                    case "음식명 검색":
                        articleController.foodNamePost();
                        break;
                    case "브랜드명 검색":
                        articleController.brandNamePost();
                        break;
                }
            }
        }
    }
}
