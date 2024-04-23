package com.three.alcoholshoppingmall.project.user;


import com.three.alcoholshoppingmall.project.user.token.TokenManager;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("login")
public class LoginController {

    private final LoginService loginService;
    private final  LoginRepository loginRepository;
    private final TokenManager tokenManager;

    @PostMapping
    public String loginUser(@RequestBody UserDto userDto){
        User dbuser =  loginRepository.findByEmailAndPassword(userDto.getEmail(),userDto.getPassword());


        if(dbuser == null){
            throw new RuntimeException("회원정보 없음");
        }
        return tokenManager.generateToken(dbuser);
    }

    @PostMapping("create")
    public ResponseEntity<String> createUser(@RequestBody UserDto userDto){

        loginService.createUser(userDto);

        return ResponseEntity.status(HttpStatus.OK).body("회원가입 완료");
    }
}
