package com.three.alcoholshoppingmall.project.my;



import com.three.alcoholshoppingmall.project.entity.Alcohol;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Weekservice {

    private final WeekRepository weekRepository;



    public List<Alcohol> Most() {
        List<Alcohol> list = weekRepository.mostsold();

        return list;
    }

    public List<Alcohol> MostWhiskey() {
        List<Alcohol> list = weekRepository.mostwhiskey();

        return list;
    }

    public List<Alcohol> MostWine() {
        List<Alcohol> list = weekRepository.mostwine();

        return list;
    }

    public List<Alcohol> MostLiqueur() {
        List<Alcohol> list = weekRepository.mostliqueur();

        return list;
    }




}
