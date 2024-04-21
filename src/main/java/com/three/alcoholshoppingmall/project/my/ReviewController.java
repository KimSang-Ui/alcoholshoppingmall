package com.three.alcoholshoppingmall.project.my;

import com.three.alcoholshoppingmall.project.entity.Favorites;
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
@RequestMapping("/review")
@Tag(name = "main", description = "메인 페이지 입니다.")
public class ReviewController {


    private final ReviewServicce reviewServicce;

    //개인 정보 쪽으로
    @PostMapping("/favorites")
    @Operation(summary = "즐겨찾기 목록")
    public ResponseEntity<List<Favorites>> FavoritesList(@RequestBody Favorites favorites){

        FavoritesDTO favoritesDTO = FavoritesDTO.builder()
                .id(favorites.getId())
                .email(favorites.getEmail())
                .name(favorites.getName())
                .build();

        List<Favorites> list = reviewServicce.Favorites(favoritesDTO);

        return  ResponseEntity.status(HttpStatus.OK).body(list);
    }   // 리뷰 및 평점 조회
}
