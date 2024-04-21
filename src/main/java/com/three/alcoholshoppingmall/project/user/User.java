package com.three.alcoholshoppingmall.project.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "user")
@Schema(description = "user 테이블에 대한 내용입니다.")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(title = "생성 번호", description = "table에서 자동으로 생성되는 칼럼입니다.")
    private Long id;

    @Schema(title = "email", description = "회원의 email입니다.")
    private String email;

    @Schema(title = "nickname", description = "회원의 nickname입니다.")
    private String nickname;

    @Schema(title = "password", description = "회원의 password입니다.")
    private String password;

    @Schema(title = "address", description = "회원의 주소 입니다.")
    private String address;

    @Schema(title = "lastaddress", description = "회원의 마지막 배송 주소 입니다.")
    private String lastaddress;

    @Schema(title = "gender", description = "회원의 성별 입니다.")
    private Gender gender;

    @Schema(title = "birthdate", description = "회원의 생년월일 입니다.")

    private int birthdate;

    @Schema(title = "phone", description = "회원의 전화번호 입니다.")
    private String phone;

    @Schema(title = "withdraw", description = "회원의 탈퇴 입니다.")
    private WithdrawStatus withdrawStatus;


}