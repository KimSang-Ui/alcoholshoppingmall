package com.three.alcoholshoppingmall.project.main;

import com.three.alcoholshoppingmall.project.entity.Alcohol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Alcohol, Long> {


    //신제품
    @Query(value = "SELECT * FROM alcohol ORDER BY Id DESC LIMIT 5", nativeQuery = true)
    List<Alcohol> newproduct();

}
