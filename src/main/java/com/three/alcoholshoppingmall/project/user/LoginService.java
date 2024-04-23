package com.three.alcoholshoppingmall.project.user;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final LoginRepository loginRepository;
    public void createUser(UserDto userDto) {

        User user = loginRepository.findByEmail(userDto.getEmail());

        if(user == null){
            loginRepository.save(user.builder()
                            .email(userDto.getEmail())
                            .password(userDto.getPassword())
                            .build());
        }else{
            throw new RuntimeException("중복된 이메일");
        }
    }
}
