package com.three.alcoholshoppingmall.project.main;

import com.three.alcoholshoppingmall.project.entity.Alcohol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlcoholRepository extends JpaRepository<Alcohol, Long> {

//    List<Alcohol> findByMaincategory(String maincategory); // 대분류로 주류 검색하기
//
//    List<Alcohol> findByNameContaining(String name);// 이름으로 주류 검색하기
//
//    @Query(value = "select m from Alcohol m where m.maincategory = :maincategory and m.subcategory = :subcategory")
//    List<Alcohol> findByMyCustom(String maincategory, String subcategory); // 대분류와 소분류로 주류 검색하기
//
//    @Query(value = "SELECT distinct subcategory FROM Alcohol WHERE maincategory = :maincategory")
//    List<String> findSubcategoryByMaincategory(String maincategory);// 대분류 클릭 시 소분류 내용 나오게 하기


        //술 평점
        @Query(value = "SELECT ROUND(COALESCE(AVG(b.grade), 0), 1) AS average_grade FROM alcohol a LEFT JOIN review b ON a.name = b.name GROUP BY a.name", nativeQuery = true)
        List<Double> Ratingaverage();

        //술 재고
        @Query(value = "SELECT COALESCE(SUM(b.amount), 0) AS total_amount FROM alcohol a LEFT JOIN stock b ON a.name = b.name GROUP BY a.name", nativeQuery = true)
        List<Integer> Allamount();

        //술 가격(최소가격)
        @Query(value = "SELECT COALESCE(MIN(b.price), 0) AS min_price FROM alcohol a LEFT JOIN stock b ON a.name = b.name GROUP BY a.name", nativeQuery = true)
        List<Integer> Minprice();

        List<Alcohol> findByName(String name);

        //특정 술의 평점
        @Query(value = "SELECT ROUND(COALESCE(AVG(b.grade), 0), 1) AS average_grade FROM alcohol a LEFT JOIN review b ON a.name = b.name WHERE a.name = :name GROUP BY a.name", nativeQuery = true)
        Double Rating(String name);

        //특정 술의 (최소)가격
        @Query(value = "SELECT COALESCE(MIN(b.price), 0) AS min_price FROM alcohol a LEFT JOIN stock b ON a.name = b.name WHERE a.name = :name GROUP BY a.name", nativeQuery = true)
        int Price(String name);


        //인기순
        @Query(value = "SELECT a.id, a.name, a.maincategory, a.subcategory,a.content, a.aroma, a.taste, a.finish, a.nation, a.picture " +
                "FROM alcohol a LEFT JOIN ( SELECT name, COUNT(*) AS purchase_count FROM purchase GROUP BY NAME ) b ON a.name = b.name ORDER BY COALESCE(b.purchase_count, 0) DESC, a.id",nativeQuery = true)
        List<Alcohol> pop();



        // 높은 가격
        @Query(value = "SELECT a.id, a.name, a.maincategory, a.subcategory, a.content, a.aroma, a.taste, a.finish, a.nation, a.picture, COALESCE(MAX(b.price), 0) AS max_price\n" +
                "FROM alcohol a LEFT JOIN purchase b ON a.name = b.name GROUP BY a.id, a.name, a.maincategory, a.subcategory, a.content, a.aroma, a.taste, a.finish, a.nation, a.picture " +
                "ORDER BY COALESCE(MAX(b.price), 0) DESC, a.id",nativeQuery = true)
        List<Alcohol> mex();

        // 낮은 가격
        @Query(value = "SELECT a.id, a.name, a.maincategory, a.subcategory, a.content, a.aroma, a.taste, a.finish, a.nation, a.picture, COALESCE(MIN(b.price), 0) AS min_price\n" +
                "FROM alcohol a LEFT JOIN purchase b ON a.name = b.name GROUP BY a.id, a.name, a.maincategory, a.subcategory, a.content, a.aroma, a.taste, a.finish, a.nation, a.picture\n" +
                "ORDER BY COALESCE(MIN(b.price), 0), a.id",nativeQuery = true)
        List<Alcohol> min();
    }
