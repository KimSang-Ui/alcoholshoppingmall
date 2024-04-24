package com.three.alcoholshoppingmall.project.favorites;

import com.three.alcoholshoppingmall.project.purchase.Purchase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FavoritesService {

    private final FavoritesRepository favoritesFRepository;

    public List<Favorites> Favoriteslist(FavoritesDTO favoritesDTO) {

        List<Favorites> list = favoritesFRepository.MyFavorites(favoritesDTO.getEmail());

        return list;
    }

    public List<Favorites> Favorites(FavoritesDTO favoritesDTO) {
        Optional<Favorites> favor = favoritesFRepository.findByEmailAndName(favoritesDTO.getEmail(), favoritesDTO.getName());
        List<Favorites> list = new ArrayList<>();

        if (favor.isPresent()) {
            favoritesFRepository.deleteByEmailAndAndName(favoritesDTO.getEmail(), favoritesDTO.getName());
        } else {
            Favorites favorites = new Favorites();
            favorites.setEmail(favoritesDTO.getEmail());
            favorites.setName(favoritesDTO.getName());
            Favorites savedFavorites = favoritesFRepository.save(favorites);
            list.add(savedFavorites);
        }
        return list;
    }
}
