package com.three.alcoholshoppingmall.project.search;

import com.three.alcoholshoppingmall.project.alcohol.Alcohol;
import com.three.alcoholshoppingmall.project.alcohol.AlcoholRepository;
import com.three.alcoholshoppingmall.project.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class SearchService {

    private final SearchRepository searchRepository;
    private final AlcoholRepository alcoholRepository;
    private final UserRepository userRepository;


    @Transactional
    public List<Alcohol> searchAlcoholByName(SearchDto searchDto) {
        Search search = new Search();
        List<Alcohol> list = alcoholRepository.findByNameContaining(searchDto.getSearchcontents());
        // 이메일이 유효한 경우에만 검색 기록 저장
        if (searchDto.getUser() != null) {
            search = search.builder()
                    .searchcontents(searchDto.getSearchcontents())
                    .user(searchDto.getUser())
                    .build();
                    searchRepository.save(search);


            } else {
                    search.setSearchcontents(searchDto.getSearchcontents());
                    searchRepository.save(search);


                    // 유효한 사용자 이메일을 찾을 수 없는 경우에 대한 처리

                }
        return list;
    }

    public List<Search> recentSearch(SearchDto searchDto) {
        List<Search> list = searchRepository.recentSearch(searchDto.getUser().getEmail());
        if (list == null) {
            return null;
        } else {
            return list;
        }
    }





    }


//
//    public List<Search> recentSearch(String email) {
//        List<Search> list = searchRepository.recentSearch(email);
//        return list;
//    }
//}









