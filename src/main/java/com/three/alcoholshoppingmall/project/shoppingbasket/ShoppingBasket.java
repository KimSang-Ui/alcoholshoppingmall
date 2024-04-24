package com.three.alcoholshoppingmall.project.shoppingbasket;


import com.three.alcoholshoppingmall.project.alcohol.Alcohol;
import com.three.alcoholshoppingmall.project.market.Market;
import com.three.alcoholshoppingmall.project.user.User;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shoppingbasket")
@Schema(description = "shoppingbasket 테이블에 대한 내용입니다.")
public class ShoppingBasket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(title = "주류 ID", description = "table에서 자동으로 생성되는 칼럼입니다.")
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "email")
    private User user; // 구매자

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "name")
    private Alcohol alcohol; // 주류 이름

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "marketname")
    private Market market; // 매장명

    @Schema(title = "판매처 주소", description = "회원의 주소 입니다.")
    private String address;

    @Schema(title = "해당 물품 개수", description = "해당 물품의 구매 수량입니다.")
    private  int amount;

    @Enumerated(EnumType.STRING)
    @Schema(title = "장바구니", description = "픽업 장바구니와 배달 장바구니 여부를 확인하는 칼럼입니다.")
    private ShoppingBasketType shoppingBasketType;


}
