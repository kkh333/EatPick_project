package org.example.article.controller;

import lombok.Getter;
import lombok.Setter;
import org.example.Container;
import org.example.article.entity.Article;
import org.example.article.service.ArticleService;
import org.example.util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class ArticleController {
    ArticleService articleService = new ArticleService();

    public void myPostList() {
        List<Article> articles = articleService.getArticleListMy();

        int postNum = 1;

        Container.postTh1();

        for (int i = 0; i < articles.size(); i++) {
            Article article = articles.get(i);
            System.out.printf("%d / %s / %s / %s / %d" + "원" + " / %s"  + " / %d" + "점" + " / %s / %s\n", postNum, article.getCategory(), article.getFoodName(), article.getBrandName(), article.getPrice(), article.getWeight(), article.getScope(), article.getReview(), article.getRegDate());
            postNum++;
        }
    }

    public void write() {
        String category;
        String foodName;
        String brandName;
        int price;
        String weight;
        String inputWeight;
        int scope;
        String review;

        System.out.println("\n1.카테고리를 입력해 주세요. (탄수화물 / 육류 / 어류 / 식물성 / 영양제 / 보충제 / 기타)");
        while (true) {
            category = Container.getSc().nextLine().trim();

            switch (category) {
                case "탄수화물":
                    break;
                case "육류":
                    break;
                case "어류":
                    break;
                case "식물성":
                    break;
                case "영양제":
                    break;
                case "보충제":
                    break;
                case "기타":
                    break;
                default:
                    System.out.println("\n올바른 카테고리를 입력해 주세요.");
                    continue;
            }
            break;
        }
        System.out.println("\n2.음식명을 입력해 주세요.");
        foodName = Container.getSc().nextLine().trim();

        System.out.println("\n3.브랜드명을 입력해 주세요.");
        brandName = Container.getSc().nextLine().trim();

        System.out.println("\n4.가격을 입력해 주세요.");
        while (true) {
            try {
                price = Integer.parseInt(Container.getSc().nextLine().trim());
            } catch (Exception e) {
                System.out.println("\n입력된 값은 숫자가 아닙니다. 다시 입력해 주세요.");
                continue;
            }
            break;
        }

        System.out.println("\n5.중량을 입력해 주세요.");

        while (true) {

            try {
                inputWeight = Container.getSc().nextLine().trim();
            } catch (Exception e) {
                System.out.println("\n입력된 값은 숫자가 아닙니다. 다시 입력해 주세요.");
                continue;
            }

            int weightNum = Integer.parseInt(inputWeight.replaceAll("[^0-9]", ""));
            String unit = inputWeight.replaceAll("[^a-z]", "");
            //Kg을 작성 하면 g만 출력 되는 현상 해결 필요.
            switch(unit.toLowerCase()) {
                case "kg" :
                    unit = "kg";
                    break;
                case "ml" :
                    unit = "ml";
                    break;
                case "g":
                    unit = "g";
                    break;
                case "L" :
                    unit = "l";
                    break;
                default:
                    System.out.println("단위는 kg, g, l, ml만 가능합니다");
                    continue;
            }
            weight = Integer.toString(weightNum).concat(unit);

            System.out.println(weight);
            break;
        }

        System.out.println("\n6.별점을 입력해 주세요.\n5점 만점(1 / 2 / 3 / 4 / 5)");
        while (true) {
            try {
                scope = Integer.parseInt(Container.getSc().nextLine().trim());
                if (scope > 5 || scope == 0) {
                    System.out.println("\n입력된 값은 정해진 값이 아닙니다. 다시 입력해 주세요.");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("\n입력된 값은 숫자가 아닙니다. 다시 입력해 주세요.");
                continue;
            }
            break;
        }

        System.out.println("\n7.한 줄 리뷰를 입력해 주세요.");
        review = Container.getSc().nextLine().trim();

        this.articleService.write(category, foodName, brandName, price, weight, scope, review, Container.getLoginedMember().getNickname());

        System.out.println("\n게시글 등록이 완료되었습니다.");

        Container.meneList2();
    }

    public void modify() {
        List<Article> articles = articleService.getArticleListMy();
        Article article = null;
        int inputNum = 0;

        if (articles.size() == 0) {
            System.out.println("\n게시글이 존재하지 않습니다.");
            Container.meneList2();
            return;
        } else {
            myPostList();

            System.out.println("\n수정할 번호를 입력해 주세요.");
            try {
                inputNum = Integer.parseInt(Container.getSc().nextLine().trim());
                if (inputNum > articles.size() || inputNum == 0) {
                    System.out.println("\n입력 값에 해당하는 게시글이 존재하지 않습니다.");
                    Container.meneList2();
                    return;
                }
            } catch (Exception e) {
                System.out.println("\n입력 값은 정수로 입력할 수 있습니다.");
                Container.meneList2();
                return;
            }
            article = articles.get(inputNum - 1);
        }

        String category;
        String foodName;
        String brandName;
        int price;
        String weight;
        String inputWeight;
        int scope;
        String review;

        System.out.println("\n1.카테고리를 입력해 주세요. (탄수화물 / 육류 / 어류 / 식물성 / 영양제 / 보충제 / 기타)");
        while (true) {
            System.out.printf("기존 내용 : " + article.getCategory() + " => ");
            category = Container.getSc().nextLine().trim();

            switch (category) {
                case "탄수화물":
                    break;
                case "육류":
                    break;
                case "어류":
                    break;
                case "식물성":
                    break;
                case "영양제":
                    break;
                case "보충제":
                    break;
                case "기타":
                    break;
                default:
                    System.out.println("\n올바른 카테고리를 입력해 주세요.");
                    continue;
            }
            break;
        }
        System.out.println("\n2.음식명을 입력해 주세요.");
        System.out.printf("기존 내용 : " + article.getFoodName() + " => ");
        foodName = Container.getSc().nextLine().trim();

        System.out.println("\n3.브랜드명을 입력해 주세요.");
        System.out.printf("기존 내용 : " + article.getBrandName() + " => ");
        brandName = Container.getSc().nextLine().trim();

        System.out.println("\n4.가격을 입력해 주세요.");
        while (true) {
            try {
                System.out.printf("기존 내용 : " + article.getPrice() + " => ");
                price = Integer.parseInt(Container.getSc().nextLine().trim());
            } catch (Exception e) {
                System.out.println("\n입력된 값은 숫자가 아닙니다. 다시 입력해 주세요.");
                continue;
            }
            break;
        }

        System.out.println("\n5.중량을 입력해 주세요.");
        while (true) {
            try {
                System.out.printf("기존 내용 : " + article.getWeight() + " => ");
                inputWeight = Container.getSc().nextLine().trim();
            } catch (Exception e) {
                System.out.println("\n입력된 값은 숫자가 아닙니다. 다시 입력해 주세요.");
                continue;
            }

            int weightNum = Integer.parseInt(inputWeight.replaceAll("[^0-9]", ""));
            String unit = inputWeight.replaceAll("[^a-z]", "");
            switch(unit.toLowerCase()) {
                case "kg" :
                    unit = "kg";
                    break;
                case "ml" :
                    unit = "ml";
                    break;
                case "g":
                    unit = "g";
                    break;
                case "L" :
                    unit = "l";
                    break;
                default:
                    System.out.println("단위는 kg, g, l, ml만 가능합니다");
                    continue;
            }
            weight = Integer.toString(weightNum).concat(unit);

            System.out.println(weight);
            break;
        }

        System.out.println("\n6.별점을 입력해 주세요.\n5점 만점(1 / 2 / 3 / 4 / 5)");
        while (true) {
            try {
                System.out.printf("기존 내용 : " + article.getScope() + " => ");
                scope = Integer.parseInt(Container.getSc().nextLine().trim());
                if (scope > 5 || scope == 0) {
                    System.out.println("\n입력된 값은 정해진 값이 아닙니다. 다시 입력해 주세요.");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("\n입력된 값은 숫자가 아닙니다. 다시 입력해 주세요.");
                continue;
            }
            break;
        }

        System.out.println("\n7.한 줄 리뷰를 입력해 주세요.");
        System.out.printf("기존 내용 : " + article.getReview() + " => ");
        review = Container.getSc().nextLine().trim();

        this.articleService.modify(article, category, foodName, brandName, price, weight, scope, review);

        System.out.println("\n해당 게시글 수정이 완료됐습니다.");

        Container.meneList2();
    }

    public void remove() {
        List<Article> articles = articleService.getArticleListMy();
        Article article = null;
        int inputNum = 0;

        if (articles.size() == 0) {
            System.out.println("\n게시글이 존재하지 않습니다.");
            Container.meneList2();
            return;
        } else {
            myPostList();

            System.out.println("\n삭제할 번호를 입력해 주세요.");
            try {
                inputNum = Integer.parseInt(Container.getSc().nextLine().trim());
                if (inputNum > articles.size() || inputNum == 0) {
                    System.out.println("\n입력 값에 해당하는 게시글이 존재하지 않습니다.");
                    Container.meneList2();
                    return;
                }
            } catch (Exception e) {
                System.out.println("\n입력 값은 정수로 입력할 수 있습니다.");
                Container.meneList2();
                return;
            }
            article = articles.get(inputNum - 1);
        }

        this.articleService.remove(article);

        System.out.println("\n해당 게시글 삭제가 완료됐습니다.");

        Container.meneList2();
    }

    public void myPost() {
        List<Article> articles = articleService.getArticleListMy();

        if (articles.size() == 0) {
            System.out.println("\n게시글이 존재하지 않습니다.");

            Container.meneList2();
        } else {
            myPostList();

            Container.meneList2();
        }
    }

    public void allPost() {
        List<Article> articles = articleService.getArticleListAll();

        int postNum = 1;

        if (articles.size() == 0) {
            System.out.println("\n게시글이 존재하지 않습니다.");

            Container.meneList2();
        } else {
            Container.postTh2();

            for (int i = 0; i < articles.size(); i++) {
                Article article = articles.get(i);
                System.out.printf("%d / %s / %s / %s / %d" + "원" + " / %s"  + " / %d" + "점" + " / %s / %s / %s\n", postNum, article.getCategory(), article.getFoodName(), article.getBrandName(), article.getPrice(), article.getWeight(), article.getScope(), article.getReview(), article.getWriter(), article.getRegDate());
                postNum++;
            }

            Container.meneList2();
        }
    }

    public void categoryPost() {
        System.out.println("\n검색하실 카테고리를 입력해 주세요. (탄수화물 / 육류 / 어류 / 식물성 / 영양제 / 보충제 / 기타)");
        String searchCategory = Container.getSc().nextLine().trim();
        switch (searchCategory) {
            case "탄수화물":
                break;
            case "육류":
                break;
            case "어류":
                break;
            case "식물성":
                break;
            case "영양제":
                break;
            case "보충제":
                break;
            case "기타":
                break;
            default:
                System.out.println("\n입력하신 카테고리는 존재하지 않습니다.");
                Container.meneList2();
                return;
        }

        List<Article> articles = articleService.getArticleListCategory(searchCategory);

        int postNum = 1;

        if (articles.size() == 0) {
            System.out.println("\n\"" + searchCategory + "\" 해당 카테고리 검색 결과가 없습니다.");

            Container.meneList2();
        } else {
            Container.postTh2();

            for (int i = 0; i < articles.size(); i++) {
                Article article = articles.get(i);
                System.out.printf("%d / %s / %s / %s / %d" + "원" + " / %s"  + " / %d" + "점" + " / %s / %s / %s\n", postNum, article.getCategory(), article.getFoodName(), article.getBrandName(), article.getPrice(), article.getWeight(), article.getScope(), article.getReview(), article.getWriter(), article.getRegDate());
                postNum++;
            }

            Container.meneList2();
        }
    }

    public void foodNamePost() {
        System.out.println("\n검색하실 음식명을 입력해 주세요.");
        String searchText = Container.getSc().nextLine().trim();

        List<Article> articles = articleService.getArticleListAll();
        List<Article> articlesResult = new ArrayList<>();

        int postNum = 1;

        for (int i = 0; i < articles.size(); i++) {
            Article article = articles.get(i);
            if (article.getFoodName().contains(searchText)) {
                articlesResult.add(articles.get(i));
            }
        }

        if (articlesResult.size() == 0) {
            System.out.println("\n\"" + searchText + "\" 해당 검색 결과가 없습니다.");

            Container.meneList2();
        } else {
            Container.postTh2();

            for (int i = 0; i < articlesResult.size(); i++) {
                Article article = articlesResult.get(i);
                System.out.printf("%d / %s / %s / %s / %d" + "원" + " / %s" + " / %d" + "점" + " / %s / %s / %s\n", postNum, article.getCategory(), article.getFoodName(), article.getBrandName(), article.getPrice(), article.getWeight(), article.getScope(), article.getReview(), article.getWriter(), article.getRegDate());
                postNum++;
            }
           double sum = 0;
            for(int i = 0; i < articlesResult.size(); i++) {
              Article article = articlesResult.get(i);
                sum += article.getScope();
            }
            double answer = sum / (double)articlesResult.size();
            double result  = Math.round(answer * 10) / 10.0;

            System.out.printf("평균 별점 : " + result);

            Container.meneList2();
        }
    }

    public void brandNamePost() {
        System.out.println("\n검색하실 브랜드명을 입력해 주세요.");
        String searchText = Container.getSc().nextLine().trim();

        List<Article> articles = articleService.getArticleListAll();
        List<Article> articlesResult = new ArrayList<>();

        int postNum = 1;

        for (int i = 0; i < articles.size(); i++) {
            Article article = articles.get(i);
            if (article.getBrandName().contains(searchText)) {
                articlesResult.add(articles.get(i));
            }
        }

        if (articlesResult.size() == 0) {
            System.out.println("\n\"" + searchText + "\" 해당 검색 결과가 없습니다.");

            Container.meneList2();
        } else {
            Container.postTh2();

            for (int i = 0; i < articlesResult.size(); i++) {
                Article article = articlesResult.get(i);
                System.out.printf("%d / %s / %s / %s / %d" + "원" + " / %s" + " / %d" + "점" + " / %s / %s / %s\n", postNum, article.getCategory(), article.getFoodName(), article.getBrandName(), article.getPrice(), article.getWeight(), article.getScope(), article.getReview(), article.getWriter(), article.getRegDate());
                postNum++;
            }

            Container.meneList2();
        }
    }

    public void writerPost() {
        System.out.print("검색하실 작성자명을 입력해 주세요.");
        String searchWriter = Container.getSc().nextLine().trim();

        List<Article> articles = articleService.getArticleListAll();
        List<Article> articlesResult = new ArrayList<>();

        int postNum = 1;

        for (int i = 0; i < articles.size(); i++) {
            Article article = articles.get(i);
            if (article.getWriter().contains(searchWriter)) {
                articlesResult.add(articles.get(i));
            }
        }

        if (articlesResult.size() == 0) {
            System.out.println("\n\"" + searchWriter + "\" 해당 검색 결과가 없습니다.");

            Container.meneList2();
        } else {
            Container.postTh2();

            for (int i = 0; i < articlesResult.size(); i++) {
                Article article = articlesResult.get(i);
                System.out.printf("%d / %s / %s / %s / %d" + "원" + " / %s" + " / %d" + "점" + " / %s / %s / %s\n", postNum, article.getCategory(), article.getFoodName(), article.getBrandName(), article.getPrice(), article.getWeight(), article.getScope(), article.getReview(), article.getWriter(), article.getRegDate());
                postNum++;
            }

            Container.meneList2();
        }
    }
}
