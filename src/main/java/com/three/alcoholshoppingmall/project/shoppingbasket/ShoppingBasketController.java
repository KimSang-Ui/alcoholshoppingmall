package com.three.alcoholshoppingmall.project.shoppingbasket;

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
@RequestMapping("/shoppingbasket")
@Tag(name = "ShoppingBasketController", description = "장바구니")
@RequiredArgsConstructor
public class ShoppingBasketController {

    private final ShoppingBasketService shoppingBasketService;

//    @PostMapping("/add")
//    @Operation(summary = "장바구니 담기", description = "장바구니에 상품을 담습니다.")
//    public ResponseEntity<List<ShoppingBasket>> add(@RequestBody ShoppingbasketDto shoppingbasketDto){
//        List<ShoppingBasket> list = shoppingBasketService.add(shoppingbasketDto);
//        return ResponseEntity.status(HttpStatus.OK).body(list);
//}

}
