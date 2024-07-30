package study.loginstudy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.loginstudy.service.EmailVerificationService;

@RestController
@RequiredArgsConstructor
public class EmailVerificationController {

    private final EmailVerificationService emailVerificationService;

    @PostMapping("/api/sendVerificationEmail")
    public ResponseEntity<String> sendVerificationEmail(@RequestParam String loginId) {
        emailVerificationService.sendVerificationEmail(loginId);
        return ResponseEntity.ok("Verification email sent");
    }

    @GetMapping("/api/verifyEmail")
    public ResponseEntity<String> verifyEmail(@RequestParam String token) {
        boolean isVerified = emailVerificationService.verifyEmailToken(token);
        if (isVerified) {
            return ResponseEntity.ok("Email verified successfully");
        } else {
            return ResponseEntity.badRequest().body("Invalid or expired token");
        }
    }
}
