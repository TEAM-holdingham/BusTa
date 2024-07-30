package study.loginstudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.loginstudy.domain.entity.EmailVerificationToken;

import java.util.Optional;

public interface EmailVerificationTokenRepository extends JpaRepository<EmailVerificationToken, Long> {
    Optional<EmailVerificationToken> findByToken(String token);
    Optional<EmailVerificationToken> findByLoginId(String loginId);
}

