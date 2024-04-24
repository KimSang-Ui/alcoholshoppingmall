package com.three.alcoholshoppingmall.project.favorites;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/favorites")
@Tag(name = "favorites", description = "즐겨찾기 페이지 입니다.")
public class FavoritesController {

private final FavoritesService favoritesService;
    @PostMapping("")
    @Operation(summary = "즐겨찾기 목록")
    public ResponseEntity<List<Favorites>> FavoritesList(@RequestBody FavoritesDTO favoritesDTO){

        List<Favorites> list = favoritesService.Favoriteslist(favoritesDTO);

        return  ResponseEntity.status(HttpStatus.OK).body(list);
    }
    @PostMapping("/up")
    @Operation(summary = "즐겨찾기 등록")
    public ResponseEntity<List<Favorites>> Favorites(@RequestBody FavoritesDTO favoritesDTO) {


        List<Favorites> list = favoritesService.Favorites(favoritesDTO);

        return  ResponseEntity.status(HttpStatus.OK).body(list);
    }
}
