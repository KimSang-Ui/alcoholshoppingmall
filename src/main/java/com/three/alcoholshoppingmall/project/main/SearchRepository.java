package com.three.alcoholshoppingmall.project.main;

<<<<<<< HEAD:src/main/java/com/three/alcoholshoppingmall/project/main/SearchRepository.java
import com.three.alcoholshoppingmall.project.entity.Alcohol;
import com.three.alcoholshoppingmall.project.entity.Search;
=======


>>>>>>> main:src/main/java/com/three/alcoholshoppingmall/project/alcohol/AlcoholRepository.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SearchRepository extends JpaRepository<Search, Long> {


<<<<<<< HEAD:src/main/java/com/three/alcoholshoppingmall/project/main/SearchRepository.java
    List<Alcohol> findByMaincategory(String maincategory); // 대분류로 주류 검색하기

=======
    @Query(value = "SELECT a.* FROM alcohol a INNER JOIN (SELECT name, COUNT(*) AS cnt FROM purchase WHERE YEARWEEK(purchaseday) = YEARWEEK(NOW()) AND division = 'BUY'GROUP BY NAME ORDER BY cnt DESC LIMIT 8) b ON a.name = b.name ORDER BY b.cnt DESC", nativeQuery = true)
    List<Alcohol> mostsold();

    @Query(value = "SELECT a.* FROM alcohol a INNER JOIN (SELECT name FROM purchase WHERE YEARWEEK(purchaseday) = YEARWEEK(NOW()) AND division = 'BUY'  GROUP BY name) b ON a.name = b.name WHERE a.maincategory = :maincategory ORDER BY a.name LIMIT 5", nativeQuery = true)
    List<Alcohol> most(String maincategory);

    @Query(value = "SELECT * FROM alcohol ORDER BY Id DESC LIMIT 5", nativeQuery = true)
    List<Alcohol> newproduct(); //신제품


    List<Alcohol> findByMaincategory(String maincategory); // 대분류로 주류 검색하기

>>>>>>> main:src/main/java/com/three/alcoholshoppingmall/project/alcohol/AlcoholRepository.java
    List<Alcohol> findByNameContaining(String name);// 이름으로 주류 검색하기

    @Query(value = "select m from Alcohol m where m.maincategory = :maincategory and m.subcategory = :subcategory")
    List<Alcohol> findByMyCustom(String maincategory, String subcategory); // 대분류와 소분류로 주류 검색하기

    @Query(value = "SELECT distinct subcategory FROM Alcohol WHERE maincategory = :maincategory")
    List<String> findSubcategoryByMaincategory(String maincategory);// 대분류 클릭 시 소분류 내용 나오게 하기


<<<<<<< HEAD:src/main/java/com/three/alcoholshoppingmall/project/main/SearchRepository.java
}
=======
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


    // 인기순
    @Query(value = "SELECT a.id, a.name, a.maincategory, a.subcategory, a.content, a.aroma, a.taste, a.finish, a.nation, a.picture " +
            "FROM alcohol a LEFT JOIN (SELECT name, COUNT(*) AS purchase_count FROM purchase GROUP BY name) b ON a.name = b.name " +
            "ORDER BY COALESCE(b.purchase_count, 0) DESC, a.id", nativeQuery = true)
    List<Alcohol> pop();

    @Query(value = "SELECT COALESCE(AVG(r.grade), 0) AS avg_rating " +
            "FROM alcohol a " +
            "LEFT JOIN review r ON a.name = r.name " +
            "LEFT JOIN (SELECT name, COUNT(*) AS purchase_count FROM purchase GROUP BY name) b ON a.name = b.name " +
            "GROUP BY a.id " +
            "ORDER BY COALESCE(MAX(b.purchase_count), 0) DESC, a.id", nativeQuery = true)
    List<Double> popratings();

    @Query(value = "SELECT COALESCE(MAX(b.price), 0) AS price " +
            "FROM alcohol a " +
            "LEFT JOIN (SELECT name, MAX(price) AS price, COUNT(*) AS purchase_count FROM purchase GROUP BY name) b ON a.name = b.name " +
            "GROUP BY a.id " +
            "ORDER BY COALESCE(MAX(b.purchase_count), 0) DESC, a.id", nativeQuery = true)
    List<Integer> popprices();

    @Query(value = "SELECT COALESCE(COUNT(r.writing), 0) AS review_count " +
            "FROM alcohol a LEFT JOIN review r ON a.name = r.name " +
            "LEFT JOIN (SELECT name, COUNT(*) AS purchase_count FROM purchase GROUP BY name) b ON a.name = b.name " +
            "GROUP BY a.id " +
            "ORDER BY COALESCE(MAX(b.purchase_count), 0) DESC, a.id", nativeQuery = true)
    List<Integer> popreviewCount();


    // 최대 가격 순 정렬
    @Query(value = "SELECT a.id, a.name, a.maincategory, a.subcategory, a.content, a.aroma, a.taste, a.finish, a.nation, a.picture, COALESCE(MAX(b.price), 0) AS max_price\n" +
            "FROM alcohol a LEFT JOIN purchase b ON a.name = b.name GROUP BY a.id, a.name, a.maincategory, a.subcategory, a.content, a.aroma, a.taste, a.finish, a.nation, a.picture\n" +
            "ORDER BY COALESCE(MAX(b.price), 0) DESC, a.id", nativeQuery = true)
    List<Alcohol> max();

    // 최대 가격 순 정렬시 평점 정렬
    @Query(value = "SELECT COALESCE(AVG(r.grade), 0) AS ratingaverage\n" +
            "FROM alcohol a LEFT JOIN review r ON a.name = r.name\n" +
            "LEFT JOIN purchase b ON a.name = b.name\n" +
            "GROUP BY a.name, a.id\n" +
            "ORDER BY MAX(COALESCE(b.price, 0)) DESC, a.id ASC", nativeQuery = true)
    List<Double> maxratings();

    // 최대 가격 순 정렬시 가격 출력
    @Query(value = "SELECT COALESCE(MAX(b.price), 0) AS max_price\n" +
            "FROM alcohol a LEFT JOIN purchase b ON a.name = b.name GROUP BY a.id, a.name, a.maincategory, a.subcategory, a.content, a.aroma, a.taste, a.finish, a.nation, a.picture\n" +
            "ORDER BY COALESCE(MAX(b.price), 0) DESC, a.id", nativeQuery = true)
    List<Integer> maxprices();

    // 최대 가격 순 정렬시 리뷰 갯수
    @Query(value = "SELECT COALESCE(COUNT(r.writing), 0) AS review_count " +
            "FROM alcohol a LEFT JOIN review r ON a.name = r.name " +
            "LEFT JOIN purchase b ON a.name = b.name " +
            "GROUP BY a.id " +
            "ORDER BY COALESCE(MAX(b.price), 0) DESC, a.id", nativeQuery = true)
    List<Integer> maxreviewCount();

    // 최소 가격 순 정렬
    @Query(value = "SELECT a.id, a.name, a.maincategory, a.subcategory, a.content, a.aroma, a.taste, a.finish, a.nation, a.picture, COALESCE(MIN(b.price), 0) AS min_price\n" +
            "FROM alcohol a LEFT JOIN purchase b ON a.name = b.name GROUP BY a.id, a.name, a.maincategory, a.subcategory, a.content, a.aroma, a.taste, a.finish, a.nation, a.picture\n" +
            "ORDER BY COALESCE(MIN(b.price), 0), a.id", nativeQuery = true)
    List<Alcohol> min();

    // 최소 가격 순 정렬시 평점 정렬
    @Query(value = "SELECT COALESCE(AVG(r.grade), 0) AS ratingaverage\n" +
            "FROM alcohol a LEFT JOIN review r ON a.name = r.name\n" +
            "LEFT JOIN purchase b ON a.name = b.name\n" +
            "GROUP BY a.name, a.id\n" +
            "ORDER BY MIN(COALESCE(b.price, 0)) ASC, a.id ASC", nativeQuery = true)
    List<Double> minratings();

    // 최소 가격 순 정렬시 가격 출력
    @Query(value = "SELECT COALESCE(MIN(b.price), 0) AS min_price\n" +
            "FROM alcohol a LEFT JOIN purchase b ON a.name = b.name GROUP BY a.id, a.name, a.maincategory, a.subcategory, a.content, a.aroma, a.taste, a.finish, a.nation, a.picture\n" +
            "ORDER BY COALESCE(MIN(b.price), 0), a.id", nativeQuery = true)
    List<Integer> minprices();

    // 최소 가격 순 정렬시 리뷰 갯수
    @Query(value = "SELECT COALESCE(COUNT(r.writing), 0) AS review_count " +
            "FROM alcohol a LEFT JOIN review r ON a.name = r.name " +
            "LEFT JOIN purchase b ON a.name = b.name " +
            "GROUP BY a.id " +
            "ORDER BY COALESCE(MIN(b.price), 0) ASC, a.id ASC", nativeQuery = true)
    List<Integer> minreviewCount();
}
>>>>>>> main:src/main/java/com/three/alcoholshoppingmall/project/alcohol/AlcoholRepository.java