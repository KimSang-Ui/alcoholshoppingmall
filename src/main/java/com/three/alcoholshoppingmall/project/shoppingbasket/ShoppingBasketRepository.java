package com.three.alcoholshoppingmall.project.shoppingbasket;

import com.three.alcoholshoppingmall.project.alcohol.Alcohol;
import com.three.alcoholshoppingmall.project.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ShoppingBasketRepository extends JpaRepository <ShoppingBasket, Long> {

//    Optional<ShoppingBasket> findByEmailAndName(User user, Alcohol alcohol, int amount);
//
//    void updateByEmailAndName(User user, Alcohol alcohol, int amount);
}
