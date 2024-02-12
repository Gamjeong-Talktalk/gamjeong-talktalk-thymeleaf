package site.gamjeongtalktalk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import site.gamjeongtalktalk.domain.Culture;

@Transactional
public interface CultureRepository extends JpaRepository<Culture, Long> {
}
