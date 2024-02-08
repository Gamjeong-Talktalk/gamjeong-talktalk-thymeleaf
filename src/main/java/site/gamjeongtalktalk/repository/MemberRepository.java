package site.gamjeongtalktalk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import site.gamjeongtalktalk.domain.Member;

@Transactional
public interface MemberRepository extends JpaRepository<Member, Long> {
}
