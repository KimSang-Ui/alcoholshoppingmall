package com.three.alcoholshoppingmall.project.main;


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
@RequestMapping("/event")
@Tag(name = "event", description = "신상품을 보여줍니다.")
public class EventController {

    private final EventService eventService;

    @PostMapping("/newproduct")
    @Operation(summary = "신상품 조회",  description = "신상품을 보여줍니다. 주류 id가 높은 순(최신 순)으로 5개를 출력합니다.")
    public ResponseEntity<List<Alcohol>> NewProduct(){

        List<Alcohol> list = eventService.Product();

        return ResponseEntity.status(HttpStatus.OK).body(list);
    }


}
