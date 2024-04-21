package com.three.alcoholshoppingmall.project.main;

import com.three.alcoholshoppingmall.project.entity.Alcohol;
import com.three.alcoholshoppingmall.project.entity.Search;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SearchRepository extends JpaRepository<Search, Long> {


    List<Alcohol> findByMaincategory(String maincategory); // 대분류로 주류 검색하기

    List<Alcohol> findByNameContaining(String name);// 이름으로 주류 검색하기

    @Query(value = "select m from Alcohol m where m.maincategory = :maincategory and m.subcategory = :subcategory")
    List<Alcohol> findByMyCustom(String maincategory, String subcategory); // 대분류와 소분류로 주류 검색하기

    @Query(value = "SELECT distinct subcategory FROM Alcohol WHERE maincategory = :maincategory")
    List<String> findSubcategoryByMaincategory(String maincategory);// 대분류 클릭 시 소분류 내용 나오게 하기


}