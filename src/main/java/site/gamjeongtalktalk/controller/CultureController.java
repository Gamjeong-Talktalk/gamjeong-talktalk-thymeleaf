package site.gamjeongtalktalk.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import site.gamjeongtalktalk.controller.dto.CultureForm;
import site.gamjeongtalktalk.domain.Culture;
import site.gamjeongtalktalk.service.CultureService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CultureController {

    private final CultureService cultureService;

    @GetMapping("/cultures/new")
    public String createForm(Model model) {
        model.addAttribute("cultureForm", new CultureForm());
        return "cultures/createCultureForm";
    }

    @PostMapping("/cultures/new")
    public String create(CultureForm form) {
        cultureService.createCulture(form);
        return "redirect:/";
    }

    @GetMapping("/cultures")
    public String list(Model model) {
        List<Culture> cultures = cultureService.findAllCultures();
        model.addAttribute("cultures", cultures);
        return "cultures/culturesList";
    }
}





