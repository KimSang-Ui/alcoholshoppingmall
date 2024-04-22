package com.three.alcoholshoppingmall.project.review;

import com.three.alcoholshoppingmall.project.alcohol.Alcohol;
import com.three.alcoholshoppingmall.project.favorites.Favorites;
import com.three.alcoholshoppingmall.project.favorites.FavoritesDTO;
import com.three.alcoholshoppingmall.project.purchase.Purchase;
import com.three.alcoholshoppingmall.project.purchase.PurchaseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
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
@Tag(name = "review", description = "리뷰 페이지 입니다.")
public class ReviewController {


    private final ReviewServicce reviewServicce;



    @PostMapping("/review")
    @Operation(summary = "내 리뷰 목록")
    public ResponseEntity<List<Review>> ReviewList(@RequestBody ReviewDTO reviewDTO){
        List<Review> list = reviewServicce.Review(reviewDTO.getEmail());
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

}
