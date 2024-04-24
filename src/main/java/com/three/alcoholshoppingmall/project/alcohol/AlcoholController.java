package com.three.alcoholshoppingmall.project.alcohol;



import com.three.alcoholshoppingmall.project.purchase.PurchaseDTO;
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
@RequestMapping("/main")
@Tag(name = "main", description = "메인 페이지 입니다.")
public class AlcoholController {

    private final AlcoholService alcoholService;


    @PostMapping("/mainpage")
    @Operation(summary = "메인 페이지 정보")
    public ResponseEntity<List<Information>> MainPage(){

        List<Information> list = alcoholService.Page();

        return  ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PostMapping("/detail")
    @Operation(summary = "상세 페이지 정보")
    public ResponseEntity<List<DetailInformation>> Detail(@RequestBody Alcohol alcohol){

        List<DetailInformation> list = alcoholService.DetailPage(alcohol.getName());

        return  ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PostMapping("/sort")
    @Operation(summary = "정렬 인기 최고가격 최소가격으로 정렬 입력 값이 없으면 최소 가격으로")
    public ResponseEntity<List<DetailInformation>> Sort(@RequestBody String tag){

        List<DetailInformation> list = alcoholService.SortType(tag);

        return  ResponseEntity.status(HttpStatus.OK).body(list);
    }
    @PostMapping("/algorithm")
    @Operation(summary = "내 알고리즘")
    public ResponseEntity<List<Alcohol>> MemberAlgorithm(@RequestBody PurchaseDTO purchaseDTO){

        List<Alcohol> list = alcoholService.Algorithm(purchaseDTO.getEmail());

        return ResponseEntity.status(HttpStatus.OK).body(list);
    }



}
