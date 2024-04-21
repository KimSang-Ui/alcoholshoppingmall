package com.three.alcoholshoppingmall.project.my;


import com.three.alcoholshoppingmall.project.entity.Alcohol;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/week")
@Tag(name = "week", description = "주간 판매정보를 토대로 인기상품을 보여 줍니다.")
public class WeekController {
    // 주간판매정보(전체, 대분류만 보이게)

    private final Weekservice weekservice;


    @PostMapping("/most")
    @Operation(summary = "주간 많이 팔린 제품")
    public ResponseEntity<List<Alcohol>> Mostsold(){

        List<Alcohol> list = weekservice.Most();

        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
    @PostMapping("/most/whiskey")
    @Operation(summary = "주간 많이 팔린 위스키")
    public ResponseEntity<List<Alcohol>> Mostwhiskey(){

        List<Alcohol> list = weekservice.MostWhiskey();

        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PostMapping("/most/wine")
    @Operation(summary = "주간 많이 팔린 와인")
    public ResponseEntity<List<Alcohol>> Mostwine(){

        List<Alcohol> list = weekservice.MostWine();

        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PostMapping("/most/liqueur")
    @Operation(summary = "주간 많이 팔린 와인")
    public ResponseEntity<List<Alcohol>> Mostliqueur(){

        List<Alcohol> list = weekservice.MostLiqueur();

        return ResponseEntity.status(HttpStatus.OK).body(list);
    }










}
