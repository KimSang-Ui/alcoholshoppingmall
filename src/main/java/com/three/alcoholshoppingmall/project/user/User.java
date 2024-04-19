package com.three.alcoholshoppingmall.project.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name = "user")
@Schema(description = "user 테이블에 대한 내용입니다.")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(title = "회원 ID", description = "table에서 자동으로 생성되는 칼럼입니다.")
    private Long id;

    @Schema(title = "회원 Email", description = "회원 email을 넣어줍니다.")
    @Column(unique = true)
    private String email;

}
