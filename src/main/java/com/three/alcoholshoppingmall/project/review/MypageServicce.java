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
public class MypageServicce {

    private final FavoritesRepository favoritesFRepository;
    private final PurchaseRepository purchaseRepository;
    private final ReviewRepository reviewRepository;
    private final AlcoholRepository alcoholRepository;
    private final AlgorithmRepository algorithmRepository;


    public List<Favorites> Favorites(FavoritesDTO favoritesDTO) {

        List<Favorites> list = favoritesFRepository.MyFavorites(favoritesDTO.getEmail());

        return list;
    }

    public List<Purchase> PICKUPlist(String email, Ordertype ordertype) {
        List<Purchase>  list = purchaseRepository.Pickuplist(email);
        return list;
    }

    public List<Purchase> DELIVERYlist(String email, Ordertype ordertype) {
        List<Purchase>  list = purchaseRepository.Deliverylist(email);
        return list;
    }

    public List<Purchase> PICKUPlimt(String email, Ordertype ordertype) {
        List<Purchase> list = purchaseRepository.Pickuplimt(email);
        return list;
    }

    public List<Purchase> DELIVERYLIMTlimt(String email, Ordertype ordertype) {
        List<Purchase> list = purchaseRepository.Deliverylimt(email);
        return list;
    }


    public List<Review> Review(String email) {

        List<Review> list = reviewRepository.findByEmail(email);
        return list;
    }
    public List<Alcohol> Algorithm(String email) {

        Optional<Purchase> check = purchaseRepository.findByEmail(email);

        if(check.isPresent()) {
            String category = algorithmRepository.Category(email);
            String aroma = algorithmRepository.Aroma(email);
            String taste = algorithmRepository.Taste(email);
            String finish = algorithmRepository.Finish(email);

            List<Alcohol> list = algorithmRepository.personalalgorithm(category, aroma, taste, finish);

            return list;
        }
        else {
            List<Alcohol> list = alcoholRepository.mostsold();
            return list;
        }

    }



}
