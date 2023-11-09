package org.example.member.service;

import org.example.member.entity.Member;
import org.example.member.repository.MemberRepository;

public class MemberService {
    MemberRepository memberRepository;
    public MemberService () {
        this.memberRepository = new MemberRepository();
    }
    public Member getFindByNickname(String nickname) {
        return this.memberRepository.getFindByNickname(nickname);
    }

    public void join(String nickname, String password) {
        this.memberRepository.join(nickname, password);
    }

    public void withdrawal(int memberId) {
        // MemberRepository의 withdrawal 메서드를 호출하여 회원 탈퇴를 수행
        this.memberRepository.withdrawal(memberId);
    }
}
