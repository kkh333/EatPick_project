package org.example;

import lombok.Getter;
import lombok.Setter;
import org.example.db.DBConnection;
import org.example.member.entity.Member;
import org.example.system.controller.SystemController;

import java.util.Scanner;

public class Container {
    @Getter
    private static Scanner sc;
    @Getter
    @Setter
    private static Member loginedMember = null;
    private static DBConnection dbConnection;
    public static void init() {
        sc = new Scanner(System.in);
    }
    public static Scanner getSc() {
        return sc;
    }
    public static void close() {
        sc.close();
    }
    public static void meneList1() {
        System.out.println("\n1.로그인 / 2.회원가입 / 3.종료");
    }
    public static void meneList2() {
        System.out.println("\n1.게시글 등록 / 2.게시글 수정 / 3.게시글 삭제 / 4.나의 게시글 / 5.전체 게시글 / 6.카테고리 검색 / 7.음식명 검색 /8.브랜드명 검색/ 9. 작성자 검색 / 10.로그아웃 / 11.종료");
    }
    public static void postTh1() {
        System.out.println("\n번호 / 카테고리 / 음식명 / 브랜드명 / 가격 / 중량 / 별점 / 한 줄 리뷰 / 작성 시간");
        System.out.println("=".repeat(80));
    }
    public static void postTh2() {
        System.out.println("\n번호 / 카테고리 / 음식명 / 브랜드명 / 가격 / 중량 / 별점 / 한 줄 리뷰 / 작성자 / 작성 시간");
        System.out.println("=".repeat(80));
    }
    public static DBConnection getDBconnection() {
        if (dbConnection == null) {
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }
}
