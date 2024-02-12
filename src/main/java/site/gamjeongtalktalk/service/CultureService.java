package site.gamjeongtalktalk.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.gamjeongtalktalk.controller.dto.CultureForm;
import site.gamjeongtalktalk.domain.Culture;
import site.gamjeongtalktalk.repository.CultureRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CultureService {

    private final CultureRepository cultureRepository;

    public void createCulture(CultureForm form) {
        Culture culture = Culture.create(
                form.getName(),
                form.getPrice(),
                form.getManager(),
                form.getDate()
        );

        cultureRepository.save(culture);
    }

    public List<Culture> findAllCultures() {
        return cultureRepository.findAll();
    }
}
