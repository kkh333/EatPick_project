package org.example.article.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class Article {
    private int id;
    private String category;
    private String foodName;
    private String brandName;
    private int price;
    private String weight;
    private int scope;
    private String review;
    private String writer;
    private String regDate;

    public Article (Map<String, Object> row) {
        this.id = (int)row.get("id");
        this.category = (String) row.get("category");
        this.foodName = (String) row.get("foodName");
        this.brandName = (String) row.get("brandName");
        this.price = (int) row.get("price");
        this.weight = (String) row.get("weight");
        this.scope = (int) row.get("scope");
        this.review = (String) row.get("review");
        this.writer = (String) row.get("writer");
        this.regDate = (String)row.get("regDate");
    }
}
