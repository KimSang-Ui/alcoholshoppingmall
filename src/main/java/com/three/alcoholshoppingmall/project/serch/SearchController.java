package com.three.alcoholshoppingmall.project.serch;

import com.three.alcoholshoppingmall.project.alcohol.AlcoholDto;
import com.three.alcoholshoppingmall.project.alcohol.AlcoholRepository;
import com.three.alcoholshoppingmall.project.alcohol.Alcohol;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
@Tag(name = "SearchController", description = "주류 검색")
@RequiredArgsConstructor
public class SearchController {

    private final AlcoholRepository alcoholRepository;
    private final SearchRepository searchRepository;

    @PostMapping("/searchcontents") // 최근 검색이랑 검색
    @Operation(summary = "이름으로 검색, 검색을 완료하지 않아도 내용이 나오게 만들었습니다.", description = "이름으로 주류 검색")
    public List<Alcohol> selectByName(
            @RequestBody AlcoholDto alcoholDto,
            @RequestParam(required = false, value = "aaa@naver.com") String email) {
        List<Alcohol> list = alcoholRepository.findByNameContaining(alcoholDto.getName());

        if (list == null || list.isEmpty()) {
            return null;
        } else {
            list.stream().forEach(alcohol -> {
                Search search = new Search();
                search.setSearchcontents(alcoholDto.getName());
                searchRepository.save(search);
            });

            return list;

            // 찾아온 알코올들을 저장하는거
            // 방법을 뭘로 해줄지를 모르겠네여
        }
    }

    @PostMapping("/maincategory")
    @Operation(summary = "대분류 검색입니다.", description = "대분류로 주류 검색")
    public List<Alcohol> selectByMainCategory(@RequestBody AlcoholDto alcoholDto) {
        List<Alcohol> list = alcoholRepository.findByMaincategory(alcoholDto.getMaincategory());
        return list;
    }
    //영웅씨 이거 필요해서 잠깐 추가했어요
    @PostMapping("/subcategory")
    @Operation(summary = "소분류 검색입니다.", description = "소분류 주류 검색")
    public List<Alcohol> selectbySubcategory(@RequestBody AlcoholDto alcoholDto){
        List<Alcohol>list = alcoholRepository.findBySubcategory(alcoholDto.getSubcategory());
            return list;
    }


//    @PostMapping("/mycustom")
//    @Operation(summary = "대분류와 소분류로 검색, .", description = "대분류와 소분류 db 내용과 일치 시 검색")
//    public List<Alcohol> selectByMyCustom(@RequestBody AlcoholDto alcoholDto) {
//        List<Alcohol> list = alcoholRepository
//                .findByMyCustom(alcoholDto.getMaincategory(),
//                        alcoholDto.getSubcategory());
//        return list;
//    }

    @PostMapping("/name")
    @Operation(summary = "이름으로 검색, 검색을 완료하지 않아도 내용이 나오게 만들었습니다.", description = "이름으로 주류 검색")
    public List<Alcohol> selectByName(@RequestBody AlcoholDto alcoholDto) {
        List<Alcohol> list = alcoholRepository.findByNameContaining(alcoholDto.getName());
        return list;
    }

//    @PostMapping("/selectSubcategory")
//    @Operation(summary = "대분류를 통해 소분류를 검색합니다.", description = "대분류를 통해 소분류를 검색")
//    public List<String> selectSubcategory(@RequestBody AlcoholDto alcoholDto) {
//        List<String> list = alcoholRepository.findSubcategoryByMaincategory(alcoholDto.getMaincategory());
//        return list;
//    }


}


