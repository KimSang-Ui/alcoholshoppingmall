package com.three.alcoholshoppingmall.project.my;


import com.three.alcoholshoppingmall.project.entity.Favorites;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServicce {

    private final FavoritesRepository favoritesFRepository;


    public List<Favorites> Favorites(FavoritesDTO favoritesDTO) {

        List<Favorites> list = favoritesFRepository.MyFavorites(favoritesDTO.getEmail());


        return list;
    }
}
