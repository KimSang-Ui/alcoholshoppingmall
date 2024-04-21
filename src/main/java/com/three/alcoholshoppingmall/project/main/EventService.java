package com.three.alcoholshoppingmall.project.main;


import com.three.alcoholshoppingmall.project.entity.Alcohol;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;


    public List<Alcohol> Product() {
        List<Alcohol> list = eventRepository.newproduct();

        return list;
    }

}