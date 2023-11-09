package org.example.member.repository;

import org.example.Container;
import org.example.db.DBConnection;
import org.example.member.entity.Member;
import org.example.util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MemberRepository {
    private DBConnection dbConnection;

    public MemberRepository () {
        dbConnection = Container.getDBconnection();
    }

    public Member getFindByNickname(String nickname) {
        List<Member> members = new ArrayList<>();

        String sql = "SELECT * FROM `member`";
        List<Map<String, Object>> rows = dbConnection.selectRows(sql);

        for (Map<String, Object> row : rows) {
            members.add(new Member(row));
        }

        for (int i = 0; i < members.size(); i++) {
            Member member = members.get(i);
            if (member.getNickname().equals(nickname)) {
                return member;
            }
        }
        return null;
    }

    public void join(String nickname, String password) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("INSERT INTO `member` "));
        sb.append(String.format("SET nickname = '%s', ", nickname));
        sb.append(String.format("`password` = '%s', ", password));
        sb.append(String.format("regDate = now() "));

        int id = dbConnection.insert(sb.toString());
    }

    public void withdrawal(int memberId) {
        // 회원 탈퇴 쿼리를 작성
        String sql = "DELETE FROM `member` WHERE id = " + memberId;


        dbConnection.delete(sql);
    }
}
