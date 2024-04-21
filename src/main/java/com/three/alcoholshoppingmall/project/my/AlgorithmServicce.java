package com.three.alcoholshoppingmall.project.my;


import com.three.alcoholshoppingmall.project.entity.Alcohol;

import com.three.alcoholshoppingmall.project.entity.Purchase;
import com.three.alcoholshoppingmall.project.purchase.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlgorithmServicce {

    private final PurchaseRepository purchaseRepository;
    private  final WeekRepository weekRepository;
    private final AlgorithmRepository algorithmRepository;

    public List<Alcohol> Algorithm(String email) {

        Optional<Purchase> check = purchaseRepository.findByEmail(email);

        if(check.isPresent()) {
            String category = algorithmRepository.Category(email);
            String aroma = algorithmRepository.Aroma(email);
            String taste = algorithmRepository.Taste(email);
            String finish = algorithmRepository.Finish(email);

            List<Alcohol> list = algorithmRepository.personalalgorithm(category, aroma, taste, finish);

            return list;
        }
        else {
            List<Alcohol> list = weekRepository.mostsold();
            return list;
        }

    }


}
