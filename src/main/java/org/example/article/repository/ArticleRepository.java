package org.example.article.repository;

import org.example.Container;
import org.example.article.entity.Article;
import org.example.db.DBConnection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ArticleRepository {
    private DBConnection dbConnection;
    public ArticleRepository () {
        dbConnection = Container.getDBconnection();
    }
    public void write(String category, String foodName, String brandName, int price, String weight, int scope, String review, String writer) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("INSERT INTO article "));
        sb.append(String.format("SET category = '%s', ", category));
        sb.append(String.format("foodName = '%s', ", foodName));
        sb.append(String.format("brandName = '%s', ", brandName));
        sb.append(String.format("price = %d, ", price));
        sb.append(String.format("weight = '%s', ", weight));
        sb.append(String.format("scope = %d, ", scope));
        sb.append(String.format("review = '%s', ", review));
        sb.append(String.format("writer = '%s', ", writer));
        sb.append(String.format("regDate = now() "));

        int id = dbConnection.insert(sb.toString());
    }
    public List<Article> getArticleListAll() {
        List<Article> articles = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("SELECT * FROM article"));

        List<Map<String, Object>> rows = dbConnection.selectRows(sb.toString());

        for (Map<String, Object> row : rows) {
            articles.add(new Article(row));
        }

        return articles;
    }
    public List<Article> getArticleListMy() {
        List<Article> articles = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("SELECT * FROM article "));
        sb.append(String.format("WHERE writer = '%s' ", Container.getLoginedMember().getNickname()));

        List<Map<String, Object>> rows = dbConnection.selectRows(sb.toString());

        for (Map<String, Object> row : rows) {
            articles.add(new Article(row));
        }

        return articles;
    }
    public List<Article> getArticleListCategory(String searchCategory) {
        List<Article> articles = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("SELECT * FROM article "));
        sb.append(String.format("WHERE category = '%s' ", searchCategory));

        List<Map<String, Object>> rows = dbConnection.selectRows(sb.toString());

        for (Map<String, Object> row : rows) {
            articles.add(new Article(row));
        }

        return articles;
    }
    public void remove(Article article) {
        int id = article.getId();

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("DELETE FROM article "));
        sb.append(String.format("WHERE id = %s", id));

        dbConnection.delete(sb.toString());
    }
    public void modify(Article article, String category, String foodName, String brandName, int price, String weight, int scope, String review) {
        int id = article.getId();

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("UPDATE article "));
        sb.append(String.format("SET category = '%s', ", category));
        sb.append(String.format("foodName = '%s', ", foodName));
        sb.append(String.format("brandName = '%s', ", brandName));
        sb.append(String.format("price = %d, ", price));
        sb.append(String.format("weight = '%s', ", weight));
        sb.append(String.format("scope = %d, ", scope));
        sb.append(String.format("review = '%s', ", review));
        sb.append(String.format("regDate = now() "));
        sb.append(String.format("WHERE id = %s", id));

        dbConnection.update(sb.toString());
    }
}
