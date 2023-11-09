package org.example.member.controller;

import org.example.Container;
import org.example.member.entity.Member;
import org.example.member.service.MemberService;
import org.example.util.Util;

import static org.example.member.controller.PasswordValidator.isPasswordValid;

public class MemberController {
    MemberService memberService = new MemberService();
    public void login() {
        System.out.printf("\n닉네임 : ");
        String nickname = Container.getSc().nextLine().trim();
        System.out.printf("비밀번호 : ");
        String password = Container.getSc().nextLine().trim();

        Member member = this.memberService.getFindByNickname(nickname);

        if (member == null) {
            System.out.println("\n해당 아이디는 존재하지 않습니다.");
            Container.meneList1();
            return;
        }

        if (member.getPassword().equals(password) == false) {
            System.out.println("\n비밀번호가 일치하지 않습니다.");
            Container.meneList1();
            return;
        }

        Container.setLoginedMember(member);

        System.out.println("\n" + Container.getLoginedMember().getNickname() + "님 환영합니다! 로그인이 완료됐습니다.");

        Container.meneList2();
    }
    public void logout() {
        Container.setLoginedMember(null);
        System.out.println("\n로그아웃이 완료됐습니다.");

        Container.meneList1();
    }

    public void join() {
        String nickname;
        String password;
        String passwordConfirm;



        while (true) {
            System.out.printf("\n닉네임 : ");
            nickname = Container.getSc().nextLine().trim();

            Member member = this.memberService.getFindByNickname(nickname);

            if (member != null) {
                System.out.println("\n해당 닉네임은 중복된 닉네임 입니다. 다른 닉네임을 입력해 주세요.");
                continue;
            }
            break;
        }

        while (true) {
            System.out.printf("비밀번호 : ");
            password = Container.getSc().nextLine().trim();
            // 비밀번호가 유효하지 않을 때
            if (!isPasswordValid(password)) {
                System.out.println("\n" + PasswordValidator.getErrorMessage(password));
                continue;
            }
            System.out.printf("비밀번호 확인 : ");
            passwordConfirm = Container.getSc().nextLine().trim();


            // 비밀번호와 비밀번호 확인이 일치하지 않을 때
            if (!password.equals(passwordConfirm)) {
                System.out.println("\n비밀번호가 일치하지 않습니다. 다시 입력해 주세요.\n");
                continue;
            }



            // 모든 조건을 만족할 경우 반복문 종료
            break;
        }

        try {
            this.memberService.join(nickname, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n" + nickname + "님 회원가입이 완료됐습니다.");

        Container.meneList1();
    }

    public void withdraw() { //회원 탈퇴
        if (Container.getLoginedMember() == null) {
            System.out.println("로그인 후에 탈퇴가 가능합니다.");
            return;
        }

        System.out.println("회원 탈퇴를 진행합니다.");

        // memberId는 로그인된 회원의 ID를 사용하도록 설정해야 합니다.
        int memberId = Container.getLoginedMember().getId();

        // MemberRepository에서 withdrawal 메서드를 호출하여 회원 탈퇴 진행
        memberService.withdrawal(memberId);

        System.out.println("회원 탈퇴가 완료되었습니다.");

    }

}





