package com.three.alcoholshoppingmall.project.shoppingbasket;

import com.three.alcoholshoppingmall.project.alcohol.Alcohol;
import com.three.alcoholshoppingmall.project.market.Market;
import com.three.alcoholshoppingmall.project.user.User;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingbasketDto {
    private Long id;

    private User user;

    private Alcohol alcohol;

    private ShoppingBasketType shoppingBasketType;

    private String address;

    private int amount;

    private Market market;


}
