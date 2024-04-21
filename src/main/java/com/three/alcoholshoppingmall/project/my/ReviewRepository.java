package com.three.alcoholshoppingmall.project.my;


import com.three.alcoholshoppingmall.project.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {


    //해당술의 리뷰 정보
    @Query(value = "SELECT * FROM review WHERE NAME = :name", nativeQuery = true)
    List<Review> review(String name);

    //해당 술의 리뷰 갯수
    @Query(value = "SELECT COUNT(*) FROM review WHERE NAME = :name", nativeQuery = true)
    int Reviewcacount(String name);


}
