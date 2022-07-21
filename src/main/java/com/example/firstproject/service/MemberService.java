package com.example.firstproject.service;

import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional //로직을 처리하다가 에러가 발생하였다면, 변경된 로직을 수행하기 이전 상태로 콜백.
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member saveMember(Member member) {
        validateDuplicateMember(member);
        return memberRepository.save(member);
    }

    private void validateDuplicateMember(Member member) { //이미 가입된 회원의 경우 IllegalStateException예외 발생시킴.
        Member findMember = memberRepository.findByEmail(member.getEmail());
        if (findMember != null) {
            throw new IllegalStateException("既に加入された会員です。");
        }
    }

}
