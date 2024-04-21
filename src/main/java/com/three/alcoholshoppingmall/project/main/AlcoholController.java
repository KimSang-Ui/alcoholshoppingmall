package com.three.alcoholshoppingmall.project.main;

import com.three.alcoholshoppingmall.project.entity.Alcohol;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/main")
@Tag(name = "main", description = "메인 페이지 입니다.")
public class AlcoholController {

    private final AlcoholService alcoholService;
    // 주류 상세 페이지

    @PostMapping("/mainpage")
    @Operation(summary = "메인 페이지 정보")
    public ResponseEntity<List<Information>> MainPage(){

        List<Information> list = alcoholService.Page();

        return  ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PostMapping("/detail")
    @Operation(summary = "주류 상세 페이지 정보", description = "주류 이름을 검색하면 그 주류에 대한 상세 내용이 나옵니다, 주류 이름을 완벽히 입력해야합니다.")
    public ResponseEntity<List<DetailInformation>> Detail(@RequestBody Alcohol alcohol){

        List<DetailInformation> list = alcoholService.DetailPage(alcohol.getName());

        return  ResponseEntity.status(HttpStatus.OK).body(list);
    }


    @PostMapping("/pop")
    @Operation(summary = "인기순")
    public ResponseEntity<List<Alcohol>> Popularity(){

        List<Alcohol> list = alcoholService.Popranking();

        return  ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PostMapping("/maxprice")
    @Operation(summary = "높은 가격 순")
    public ResponseEntity<List<Alcohol>> MaxPrice(){

        List<Alcohol> list = alcoholService.Max();

        return  ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PostMapping("/minprice")
    @Operation(summary = "높은 가격 순")
    public ResponseEntity<List<Alcohol>> MinPrice(){

        List<Alcohol> list = alcoholService.Min();

        return  ResponseEntity.status(HttpStatus.OK).body(list);
    }


}
