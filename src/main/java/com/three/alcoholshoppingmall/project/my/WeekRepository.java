package com.three.alcoholshoppingmall.project.my;


import com.three.alcoholshoppingmall.project.entity.Alcohol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface WeekRepository extends JpaRepository<Alcohol, Long> {


    @Query(value = "SELECT a.* FROM alcohol a INNER JOIN (SELECT name, COUNT(*) AS cnt FROM purchase WHERE YEARWEEK(purchaseday) = YEARWEEK(NOW()) AND division = 'BUY'GROUP BY NAME ORDER BY cnt DESC LIMIT 8) b ON a.name = b.name ORDER BY b.cnt DESC", nativeQuery = true)
    List<Alcohol> mostsold();

    @Query(value = "SELECT a.*  FROM alcohol a INNER JOIN (SELECT name, COUNT(*) AS cnt FROM purchase WHERE YEARWEEK(purchaseday) = YEARWEEK(NOW()) AND division = 'BUY'  GROUP BY name ORDER BY cnt DESC) b ON a.name = b.name WHERE a.maincategory = '위스키' AND b.cnt <= 5 ORDER BY b.cnt DESC", nativeQuery = true)
    List<Alcohol> mostwhiskey();

    @Query(value = "SELECT a.*  FROM alcohol a INNER JOIN (SELECT name, COUNT(*) AS cnt FROM purchase WHERE YEARWEEK(purchaseday) = YEARWEEK(NOW()) AND division = 'BUY'  GROUP BY name ORDER BY cnt DESC) b ON a.name = b.name WHERE a.maincategory = '와인' AND b.cnt <= 5 ORDER BY b.cnt DESC", nativeQuery = true)
    List<Alcohol> mostwine();

    @Query(value = "SELECT a.*  FROM alcohol a INNER JOIN (SELECT name, COUNT(*) AS cnt FROM purchase WHERE YEARWEEK(purchaseday) = YEARWEEK(NOW()) AND division = 'BUY'  GROUP BY name ORDER BY cnt DESC) b ON a.name = b.name WHERE a.maincategory = '리큐르' AND b.cnt <= 5 ORDER BY b.cnt DESC", nativeQuery = true)
    List<Alcohol> mostliqueur();



}



