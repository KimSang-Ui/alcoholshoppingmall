<<<<<<< HEAD:src/main/java/com/three/alcoholshoppingmall/project/main/EventController.java
package com.three.alcoholshoppingmall.project.main;


import com.three.alcoholshoppingmall.project.entity.Alcohol;
=======
package com.three.alcoholshoppingmall.project.alcohol;





>>>>>>> main:src/main/java/com/three/alcoholshoppingmall/project/alcohol/EventController.java
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
<<<<<<< HEAD:src/main/java/com/three/alcoholshoppingmall/project/main/EventController.java
=======
import org.springframework.web.bind.annotation.RequestBody;
>>>>>>> main:src/main/java/com/three/alcoholshoppingmall/project/alcohol/EventController.java
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/event")
<<<<<<< HEAD:src/main/java/com/three/alcoholshoppingmall/project/main/EventController.java
@Tag(name = "event", description = "신상품을 보여줍니다.")
public class EventController {

    private final EventService eventService;

    @PostMapping("/newproduct")
    @Operation(summary = "신상품 조회",  description = "신상품을 보여줍니다. 주류 id가 높은 순(최신 순)으로 5개를 출력합니다.")
    public ResponseEntity<List<Alcohol>> NewProduct(){

        List<Alcohol> list = eventService.Product();
=======
@Tag(name = "event", description = "이벤트 페이지 입니다.")
public class EventController {

    private final Eventservice eventservice;

    @PostMapping("/most")
    @Operation(summary = "주간 많이 팔린 제품")
    public ResponseEntity<List<Alcohol>> Mostsold(){

        List<Alcohol> list = eventservice.Most();

        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
    @PostMapping("/mostcategory")
    @Operation(summary = "주간 많이 팔린 술 카테고리별")
    public ResponseEntity<List<Alcohol>> MostCategory(@RequestBody Alcohol alcohol){

        List<Alcohol> list = eventservice.Mostcategory(alcohol.getMaincategory());

        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
    @PostMapping("/newproduct")
    @Operation(summary = "신 제품")
    public ResponseEntity<List<Alcohol>> NewProduct(){

        List<Alcohol> list = eventservice.Product();
>>>>>>> main:src/main/java/com/three/alcoholshoppingmall/project/alcohol/EventController.java

        return ResponseEntity.status(HttpStatus.OK).body(list);
    }


}
