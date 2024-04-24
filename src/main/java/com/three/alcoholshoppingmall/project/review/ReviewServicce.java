package com.three.alcoholshoppingmall.project.review;


import com.three.alcoholshoppingmall.project.favorites.Favorites;
import com.three.alcoholshoppingmall.project.favorites.FavoritesDTO;
import com.three.alcoholshoppingmall.project.favorites.FavoritesRepository;
import com.three.alcoholshoppingmall.project.alcohol.Alcohol;
import com.three.alcoholshoppingmall.project.alcohol.AlcoholRepository;
import com.three.alcoholshoppingmall.project.market.Ordertype;
import com.three.alcoholshoppingmall.project.purchase.Purchase;
import com.three.alcoholshoppingmall.project.purchase.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewServicce {

    private final ReviewRepository reviewRepository;



    public List<Review> Review(String email) {

        List<Review> list = reviewRepository.findByEmail(email);
        return list;
    }

    }

