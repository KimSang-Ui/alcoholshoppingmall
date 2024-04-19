package com.three.alcoholshoppingmall.project.search;

import com.three.alcoholshoppingmall.project.alcohol.Alcohol;
import com.three.alcoholshoppingmall.project.alcohol.AlcoholDto;
import com.three.alcoholshoppingmall.project.alcohol.AlcoholRepository;
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

        @PostMapping("/name") // 최근 검색이랑 검색
        @Operation(summary = "이름으로 검색, 검색을 완료하지 않아도 내용이 나오게 만들었습니다.", description = "이름으로 주류 검색 필터")
        public List<Alcohol> selectByName(
                @RequestBody AlcoholDto alcoholDto,
                @RequestParam(required = false, value = "aa@naver.com") String email) {
            List<Alcohol> list = alcoholRepository.findByNameContaining(alcoholDto.getAlcohol_name());

            if (list == null || list.isEmpty()) {
                return null;
            } else {
                list.stream().forEach(alcohol -> {
                    Search search = new Search();
                    search.setSearchcontents(alcoholDto.getAlcohol_name());
                    search.setAlcohol(alcohol);
                    searchRepository.save(search);
                });
//            User user = userRepository.findB/yEmail(email);
//            search.setUser(user);
                return list;

                // 찾아온 알코올들을 저장하는거
                // 방법을 뭘로 해줄지를 모르겠네여
            }
        }
    }