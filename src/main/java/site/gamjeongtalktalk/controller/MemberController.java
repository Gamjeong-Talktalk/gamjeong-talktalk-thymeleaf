package site.gamjeongtalktalk.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import site.gamjeongtalktalk.controller.dto.MemberForm;
import site.gamjeongtalktalk.domain.Member;
import site.gamjeongtalktalk.repository.MemberRepository;
import site.gamjeongtalktalk.service.MemberService;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    @GetMapping("/members/new")
    public String createForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(
            @Valid MemberForm memberForm,
            BindingResult result
    ) {

        if (result.hasErrors()) {
            return "members/createMemberForm";
        }

        memberService.saveMember(memberForm);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);
        return "members/memberList";
    }

}
