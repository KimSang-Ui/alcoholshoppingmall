package com.three.alcoholshoppingmall.project.shoppingbasket;

import com.three.alcoholshoppingmall.project.alcohol.Alcohol;
import com.three.alcoholshoppingmall.project.alcohol.AlcoholRepository;
import com.three.alcoholshoppingmall.project.exception.BizException;
import com.three.alcoholshoppingmall.project.user.User;
import com.three.alcoholshoppingmall.project.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.three.alcoholshoppingmall.project.exception.ErrorCode.*;

@Service
@RequiredArgsConstructor
public class ShoppingBasketService {

    private final ShoppingBasketRepository shoppingBasketRepository;


//    public List<ShoppingBasket> add(ShoppingbasketDto shoppingbasketDto) {
//        Optional<ShoppingBasket> shoppingBasket = shoppingBasketRepository.findByEmailAndName(shoppingbasketDto.getUser(), shoppingbasketDto.getAlcohol(), shoppingbasketDto.getAmount());
//        List<ShoppingBasket> list = new ArrayList<>();
//
//        if (shoppingBasket.isPresent()){
//            shoppingBasketRepository.updateByEmailAndName(shoppingbasketDto.getUser(), shoppingbasketDto.getAlcohol(), shoppingbasketDto.getAmount());
//        }else{
//            ShoppingBasket basket = new ShoppingBasket();
//            basket.setUser(shoppingbasketDto.getUser());
//            basket.setAlcohol(shoppingbasketDto.getAlcohol());
//            basket.setAmount(shoppingbasketDto.getAmount());
//            ShoppingBasket savedBasket = shoppingBasketRepository.save(basket);
//            list.add(savedBasket);
//        }
//        return list;
//    }
}


