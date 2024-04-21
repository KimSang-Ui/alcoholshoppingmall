package com.three.alcoholshoppingmall.project.main;

import com.three.alcoholshoppingmall.project.entity.Alcohol;
import com.three.alcoholshoppingmall.project.entity.Search;
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

    private final SearchRepository searchRepository;

    @PostMapping("/contents") // 최근 검색이랑 검색
    @Operation(summary = "이름을 검색, 검색을 완료하지 않아도 내용이 나오게 만들었습니다. " +
            "검색내용에 검색 기록이 나오며 검색기록과 관련된 술 이름들이 name에 저장됩니다.", 
            description = "이름으로 주류 검색을 하면 검색기록들과 연관된 술이름이 db에 저장됩니다.")
    public List<Alcohol> selectByName(
            @RequestBody AlcoholDto alcoholDto,
            @RequestParam(required = false, value = "aaa@naver.com") String email) {
        List<Alcohol> list = searchRepository.findByNameContaining(alcoholDto.getName());

        if (list == null || list.isEmpty()) {
            return null;
        } else {
            list.stream().forEach(alcohol -> {
                Search search = new Search();
                search.setSearchcontents(alcoholDto.getName());
                search.setAlcohol(alcohol);
                searchRepository.save(search);
            });

            return list;

        }
    }

    @PostMapping("/maincategory")
    @Operation(summary = "대분류로 주류 검색",
            description = "대분류로 주류를 검색합니다, 대분류에 와인, 위스키, 브랜디, 리큐르 중 하나를 입력해주세요.")
    public List<Alcohol> selectByMainCategory(@RequestBody AlcoholDto alcoholDto) {
        List<Alcohol> list = searchRepository.findByMaincategory(alcoholDto.getMaincategory());
        return list;
    }

    @PostMapping("/mycustom")
    @Operation(summary = "대분류와 소분류가 db 내용과 일치 시 검색, 와인 소분류 검색시 띄어쓰기 유의해주세요.",
            description = "    대분류와 소분류로 검색, 대분류: 와인- 소분류: 레드 와인, 화이트 와인, 스파클링 와인, 로제 와인\" +\n" +
                    "            \"대분류: 위스키 - 소분류: 싱글몰트, 블렌디드, 버번\" +\n" +
                    "            \"대분류: 브랜디 - 소분류: 꼬냑, 깔바도스, 아르마냑\" +\n" +
                    "            \"대분류: 리큐르 = 소분류: 리큐르를 입력해주세요.")
    public List<Alcohol> selectByMyCustom(@RequestBody AlcoholDto alcoholDto) {
        List<Alcohol> list = searchRepository
                .findByMyCustom(alcoholDto.getMaincategory(),
                        alcoholDto.getSubcategory());
        return list;
    }
    @PostMapping("/name")
    @Operation(summary = "주류 이름으로 검색", description = "주류 이름으로 검색, 검색기록이 완료되지 않아도 주류들이 출력되게 만들었습니다.")
    public List<Alcohol> selectByName(@RequestBody AlcoholDto alcoholDto) {
        List<Alcohol> list = searchRepository.findByNameContaining(alcoholDto.getName());
        return list;
    }

    @PostMapping("/subcategory")
    @Operation(summary = "대분류를 통해 소분류를 검색",
            description = "대분류를 검색하면 소분류가 출력됩니다, 대분류는 와인, 위스키, 브랜디, 리큐르가 있습니다.")
    public List<String> selectSubcategory(@RequestBody AlcoholDto alcoholDto) {
        List<String> list = searchRepository.findSubcategoryByMaincategory(alcoholDto.getMaincategory());
        return list;
    }


}



