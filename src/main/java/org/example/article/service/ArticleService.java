package org.example.article.service;

import org.example.article.entity.Article;
import org.example.article.repository.ArticleRepository;

import java.util.List;

public class ArticleService {
    ArticleRepository articleRepository;
    public ArticleService () {
        this.articleRepository = new ArticleRepository();
    }
    public void write(String category, String foodName, String brandName, int price, String weight, int scope, String review, String writer) {
        this.articleRepository.write(category, foodName, brandName, price, weight, scope, review, writer);
    }
    public List<Article> getArticleListAll() {
        return this.articleRepository.getArticleListAll();
    }
    public List<Article> getArticleListMy() {
        return this.articleRepository.getArticleListMy();
    }
    public List<Article> getArticleListCategory(String searchCategory) {
        return this.articleRepository.getArticleListCategory(searchCategory);
    }
    public void remove(Article article) {
        this.articleRepository.remove(article);
    }
    public void modify(Article article, String category, String foodName, String brandName, int price, String weight, int scope, String review) {
        this.articleRepository.modify(article, category, foodName, brandName, price, weight, scope, review);
    }

    public void withdrawalRemovePost(String nickname) {
        this.articleRepository.withdrawalRemovePost(nickname);
    }
}
