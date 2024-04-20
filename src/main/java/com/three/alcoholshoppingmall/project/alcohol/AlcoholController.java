package com.three.alcoholshoppingmall.project.alcohol;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alcohol")
@Tag(name = "AlcoholController", description = "주류 필터 검색")
@RequiredArgsConstructor
public class AlcoholController {

    private final AlcoholRepository alcoholRepository;

    @PostMapping("/maincategory")
    @Operation(summary = "대분류 검색입니다.", description = "대분류로 주류 검색 필터")
    public List<Alcohol> selectByMainCategory(@RequestBody AlcoholDto alcoholDto) {
        List<Alcohol> list = alcoholRepository.findByMaincategory(alcoholDto.getMaincategory());
        return list;
    }


    @PostMapping("/subcategory")
    @Operation(summary = "소분류 검색입니다.", description = "소분류로 주류 검색 필터")
    public List<Alcohol> selectBySubCategory(@RequestBody AlcoholDto alcoholDto) {
        List<Alcohol> list = alcoholRepository.findBySubcategory(alcoholDto.getSubcategory());
        return list;
    }

    @PostMapping("/mycustom")
    @Operation(summary = "대분류와 소분류로 검색, .", description = "대분류와 소분류 db 내용과 일치 시 검색필터")
    public List<Alcohol> selectByMyCustom(@RequestBody AlcoholDto alcoholDto) {
        List<Alcohol> list = alcoholRepository
                .findByMyCustom(alcoholDto.getMaincategory(),
                        alcoholDto.getSubcategory());
        return list;
    }

    @PostMapping("/name")
    @Operation(summary = "이름으로 검색, 검색을 완료하지 않아도 내용이 나오게 만들었습니다.", description = "이름으로 주류 검색 필터")
    public List<Alcohol> selectByName(@RequestBody AlcoholDto alcoholDto) {
        List<Alcohol> list = alcoholRepository.findByNameContaining(alcoholDto.getName());
        return list;
    }

    @PostMapping("/selectSubcategory")
    @Operation(summary = "대분류를 통해 소분류를 검색합니다.", description = "대분류를 통해 소분류를 검색")
    public List<String> selectSubcategory(@RequestBody AlcoholDto alcoholDto) {
        List<String> list = alcoholRepository.findSubcategoryByMaincategory(alcoholDto.getMaincategory());
        return list;
    }

}