package com.three.alcoholshoppingmall.project.main;


import com.three.alcoholshoppingmall.project.entity.Favorites;
import com.three.alcoholshoppingmall.project.my.FavoritesDTO;
import com.three.alcoholshoppingmall.project.my.FavoritesRepository;
import com.three.alcoholshoppingmall.project.my.ReviewRepository;
import com.three.alcoholshoppingmall.project.entity.Alcohol;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class AlcoholService {


    private final AlcoholRepository alcoholRepository;
    private final FavoritesRepository favoritesRepository;
    private final ReviewRepository reviewRepository;


    public List<Information> Page() {
        List<Double> rating = alcoholRepository.Ratingaverage();
        List<Integer> allamount = alcoholRepository.Allamount();
        List<Integer> minprice = alcoholRepository.Minprice();
        List<Alcohol> alcohols = alcoholRepository.findAll();
        List<Information> list = new ArrayList<>();

        for (int i = 0; i < alcohols.size(); i++) {
            Alcohol alcohol = alcohols.get(i);
            Double grade = (i < rating.size()) ? rating.get(i) : null;
            Integer price = (i < minprice.size()) ? minprice.get(i) : null;
            Integer amount = (i < allamount.size()) ? allamount.get(i) : null;

            Information info = Information.builder()
                    .id(alcohol.getId())
                    .name(alcohol.getName())
                    .maincategory(alcohol.getMaincategory())
                    .subcategory(alcohol.getSubcategory())
                    .content(alcohol.getContent())
                    .aroma(alcohol.getAroma())
                    .taste(alcohol.getTaste())
                    .finish(alcohol.getFinish())
                    .nation(alcohol.getNation())
                    .picture(alcohol.getPicture())
                    .grade(grade)
                    .price(price)
                    .amount(amount)
                    .build();

            list.add(info);
        }
        return list;
    }

    public List<Favorites> Favorites(FavoritesDTO favoritesDTO) {

        List<Favorites> list = favoritesRepository.MyFavorites(favoritesDTO.getEmail());

        return list;
    }

    public List<DetailInformation> DetailPage(String name) {

        Double ratings = alcoholRepository.Rating(name);
        int prices = alcoholRepository.Price(name);
        List<Alcohol> alcohols = alcoholRepository.findByName(name);
        List<DetailInformation> list = new ArrayList<>();

        for (Alcohol alcohol : alcohols) {
            int reviewCount = reviewRepository.Reviewcacount(alcohol.getName());

            DetailInformation info = DetailInformation.builder()
                    .id(alcohol.getId())
                    .name(alcohol.getName())
                    .maincategory(alcohol.getMaincategory())
                    .subcategory(alcohol.getSubcategory())
                    .content(alcohol.getContent())
                    .aroma(alcohol.getAroma())
                    .taste(alcohol.getTaste())
                    .finish(alcohol.getFinish())
                    .nation(alcohol.getNation())
                    .picture(alcohol.getPicture())
                    .price(prices)
                    .ratingaverage(ratings)
                    .reviewcacount(reviewCount)
                    .build();

            list.add(info);
        }
        return list;
    }

    public List<Alcohol> Popranking() {


        List<Alcohol> list = alcoholRepository.pop();

        return list;
    }

    public List<Alcohol> Max() {

        List<Alcohol> list = alcoholRepository.mex();

        return list;

    }

    public List<Alcohol> Min() {
        List<Alcohol> list = alcoholRepository.min();

        return list;

    }
}
