package com.three.alcoholshoppingmall.project.my;


import com.three.alcoholshoppingmall.project.entity.Alcohol;

import com.three.alcoholshoppingmall.project.purchase.PurchaseDTO;
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
@RequestMapping("/algorithm")
@Tag(name = "algorithm", description = "개인 구매내역을 토대로 상품을 추천합니다.")
public class AlgorithmController {

    private final AlgorithmServicce algorithmServicce;


    @PostMapping("")
    public ResponseEntity<List<Alcohol>> MemberAlgorithm(@RequestBody PurchaseDTO purchaseDTO){

        List<Alcohol> list = algorithmServicce.Algorithm(purchaseDTO.getEmail());

        return ResponseEntity.status(HttpStatus.OK).body(list);
    }


}
