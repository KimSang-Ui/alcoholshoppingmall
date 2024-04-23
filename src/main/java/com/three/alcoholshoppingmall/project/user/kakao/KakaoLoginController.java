package com.three.alcoholshoppingmall.project.user.kakao;


import com.three.alcoholshoppingmall.project.user.User;
import com.three.alcoholshoppingmall.project.user.token.Token;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("kakao")
public class KakaoLoginController {

    private final KakaoLoginService loginService;

    // 인가코드 받는 함수
    @GetMapping("login")
    public ResponseEntity<Token> authToken(@RequestHeader String token){

        Token tokens = loginService.userAuthToken(token);

        return ResponseEntity.status(HttpStatus.OK).body(tokens);
    }

}
