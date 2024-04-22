package com.three.alcoholshoppingmall.project.entity;


import com.three.alcoholshoppingmall.project.purchase.Delivery;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "market")
@Schema(description = "market 테이블 입니다.")
public class Market {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(title = "매장 ID", description = "table에서 자동으로 생성되는 칼럼입니다.")
    private Long id;

    @Schema(title = "매장 이름", description = "해당 매장의 이름 입니다.")
    private String marketname;

    @Schema(title = "매장 주소", description = "해당 매장의 주소입니다.")
    private String address;

    @Schema(title = "매장 전화번호", description = "해당 매장의 전화번호 입니다.")
    private String phonenumber;

    @Schema(title = "배달 여부", description = "해당 매장의 배달여부 입니다")
    private Delivery delivery;

    @Schema(title = "영업시작 시간", description = "매장의 영업시작 시간 입니다.")
    private LocalTime open;

    @Schema(title = "영업종료 시간", description = "매장의 영업종료 시간입니다.")
    private LocalTime end;
}