package study.loginstudy.domain.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class EmailVerificationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    private String loginId; // 이메일 주소
    private LocalDateTime expiryDate;

    public EmailVerificationToken(String token, String loginId, LocalDateTime expiryDate) {
        this.token = token;
        this.loginId = loginId;
        this.expiryDate = expiryDate;
    }

    public EmailVerificationToken() {
    }

    // Getters and Setters
    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    // 추가적인 메서드들
}
