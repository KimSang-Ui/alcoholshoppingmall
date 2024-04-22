package com.three.alcoholshoppingmall.project.favorites;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FavoritesService {

    private final FavoritesRepository favoritesFRepository;

    public List<Favorites> Favorites(FavoritesDTO favoritesDTO) {

        List<Favorites> list = favoritesFRepository.MyFavorites(favoritesDTO.getEmail());

        return list;
    }

}
