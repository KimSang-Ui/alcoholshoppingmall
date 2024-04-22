<<<<<<<< HEAD:src/main/java/com/three/alcoholshoppingmall/project/main/SearchService.java
package com.three.alcoholshoppingmall.project.main;

import com.three.alcoholshoppingmall.project.entity.Alcohol;
import com.three.alcoholshoppingmall.project.entity.Search;
========
package com.three.alcoholshoppingmall.project.serch;

import com.three.alcoholshoppingmall.project.alcohol.Alcohol;
>>>>>>>> main:src/main/java/com/three/alcoholshoppingmall/project/serch/SearchService.java
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
@RequiredArgsConstructor
public class SearchService {

    private final SearchRepository searchRepository;


    public List<Alcohol> saveSearchResults(List<Alcohol> searchResults) {
        for (Alcohol alcohol : searchResults) {
            Search search = new Search();
            search.setAlcohol(alcohol);
            searchRepository.save(search);
        }
        return searchResults;
    }
}


//    public List<Search> searchRecent(SearchDto searchDto) {
//        return searchRepository.findTop5ByOrderByIdDesc(searchDto);
//
//    }
//        return searchResults;
//    }

//    public SearchDto getNameBySearchContents(String searchcontents) {
//        Search search = (Search) searchRepository.findBysearchcontents(searchcontents).orElseThrow();
//        return SearchDto.builder()
//                .alcohol(search.getAlcohol())
//                .build();
//    }
//}

