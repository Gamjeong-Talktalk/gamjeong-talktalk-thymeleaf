package site.gamjeongtalktalk.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.gamjeongtalktalk.controller.dto.MemberForm;
import site.gamjeongtalktalk.domain.Member;
import site.gamjeongtalktalk.repository.MemberRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void saveMember(MemberForm form) {
        Member member = Member.createMember(
                form.getName(),
                form.getAddress(),
                form.getBirthday(),
                form.getPhoneNumber()
        );

        memberRepository.save(member);
    }
}
