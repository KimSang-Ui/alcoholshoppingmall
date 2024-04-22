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
@RequestMapping("/mypage")
@Tag(name = "mypage", description = "마이 페이지 입니다.")
public class MypageController {


    private final MypageServicce mypageServicce;


    @PostMapping("/favorites")
    @Operation(summary = "즐겨찾기 목록")
    public ResponseEntity<List<Favorites>> FavoritesList(@RequestBody Favorites favorites){

        FavoritesDTO favoritesDTO = FavoritesDTO.builder()
                .id(favorites.getId())
                .email(favorites.getEmail())
                .name(favorites.getName())
                .build();
        List<Favorites> list = mypageServicce.Favorites(favoritesDTO);

        return  ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PostMapping("/pickup")
    @Operation(summary = "구매내역 중 픽업 보기")
    public ResponseEntity<List<Purchase>> PICKUP(@Valid @RequestBody PurchaseDTO purchaseDTO) {
        List<Purchase> list = mypageServicce.PICKUPlist(purchaseDTO.getEmail(), purchaseDTO.getOrdertype());
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
    @PostMapping("/delivery")
    @Operation(summary = "구매내역 중 배달 보기")
    public ResponseEntity<List<Purchase>> DELIVERY(@Valid @RequestBody PurchaseDTO purchaseDTO) {
        List<Purchase> list = mypageServicce.DELIVERYlist(purchaseDTO.getEmail(), purchaseDTO.getOrdertype());
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PostMapping("/pickuplimt")
    @Operation(summary = "구매내역중 픽업 최근 5개만")
    public ResponseEntity<List<Purchase>>  PICKUPLIMT(@RequestBody PurchaseDTO purchaseDTO) {
        List<Purchase> list = mypageServicce.PICKUPlimt(purchaseDTO.getEmail(), purchaseDTO.getOrdertype());
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PostMapping("/deliverylimt")
    @Operation(summary = "구매내역중 배달 최근 5개만")
    public ResponseEntity<List<Purchase>>  DELIVERYLIMT(@RequestBody PurchaseDTO purchaseDTO) {
        List<Purchase> list = mypageServicce.DELIVERYLIMTlimt(purchaseDTO.getEmail(), purchaseDTO.getOrdertype());
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PostMapping("/review")
    @Operation(summary = "내 리뷰 목록")
    public ResponseEntity<List<Review>> ReviewList(@RequestBody ReviewDTO reviewDTO){
        List<Review> list = mypageServicce.Review(reviewDTO.getEmail());
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
    @PostMapping("/algorithm")
    @Operation(summary = "내 알고리즘")
    public ResponseEntity<List<Alcohol>> MemberAlgorithm(@RequestBody PurchaseDTO purchaseDTO){

        List<Alcohol> list = mypageServicce.Algorithm(purchaseDTO.getEmail());

        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
}
