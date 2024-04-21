package com.three.alcoholshoppingmall.project.my;


import com.three.alcoholshoppingmall.project.entity.Alcohol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlgorithmRepository extends JpaRepository<Alcohol, Long> {


    //가장 많이 산 술의 대분류
    @Query(value = "SELECT a.maincategory " +
            "FROM alcohol a " +
            "INNER JOIN purchase b ON a.name = b.name " +
            "WHERE b.email = :email " +
            "GROUP BY a.maincategory " +
            "ORDER BY COUNT(*) DESC " +
            "LIMIT 1", nativeQuery = true)
    String Category(String email);


    // 가장 많이 산 주류의 향
    @Query(value = "SELECT REPLACE(REPLACE(SUBSTRING_INDEX(SUBSTRING_INDEX(a.finish, ',', numbers.n), ',', -1), '\"', ''), ' ', '') AS word " +
            "FROM alcohol a " +
            "INNER JOIN purchase b ON a.name = b.name " +
            "JOIN ( " +
            "    SELECT 1 + units.i + tens.i * 10 AS n " +
            "    FROM " +
            "        (SELECT 0 AS i UNION SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9) AS units " +
            "        CROSS JOIN " +
            "        (SELECT 0 AS i UNION SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9) AS tens " +
            ") AS numbers " +
            "ON CHAR_LENGTH(a.aroma) - CHAR_LENGTH(REPLACE(a.finish, ',', '')) >= numbers.n - 1 " +
            "WHERE b.email = :email " +
            "GROUP BY word " +
            "ORDER BY COUNT(*) DESC " +
            "LIMIT 1", nativeQuery = true)
    String Aroma(String email);

    // 가장 많이 산 주류의 맛
    @Query(value = "SELECT REPLACE(REPLACE(SUBSTRING_INDEX(SUBSTRING_INDEX(a.finish, ',', numbers.n), ',', -1), '\"', ''), ' ', '') AS word " +
            "FROM alcohol a " +
            "INNER JOIN purchase b ON a.name = b.name " +
            "JOIN ( " +
            "    SELECT 1 + units.i + tens.i * 10 AS n " +
            "    FROM " +
            "        (SELECT 0 AS i UNION SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9) AS units " +
            "        CROSS JOIN " +
            "        (SELECT 0 AS i UNION SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9) AS tens " +
            ") AS numbers " +
            "ON CHAR_LENGTH(a.taste) - CHAR_LENGTH(REPLACE(a.finish, ',', '')) >= numbers.n - 1 " +
            "WHERE b.email = :email " +
            "GROUP BY word " +
            "ORDER BY COUNT(*) DESC " +
            "LIMIT 1", nativeQuery = true)
    String Taste(String email);

    // 가장 많이 산 주류의 여운
    @Query(value = "SELECT REPLACE(REPLACE(SUBSTRING_INDEX(SUBSTRING_INDEX(a.finish, ',', numbers.n), ',', -1), '\"', ''), ' ', '') AS word " +
            "FROM alcohol a " +
            "INNER JOIN purchase b ON a.name = b.name " +
            "JOIN ( " +
            "    SELECT 1 + units.i + tens.i * 10 AS n " +
            "    FROM " +
            "        (SELECT 0 AS i UNION SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9) AS units " +
            "        CROSS JOIN " +
            "        (SELECT 0 AS i UNION SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9) AS tens " +
            ") AS numbers " +
            "ON CHAR_LENGTH(a.finish) - CHAR_LENGTH(REPLACE(a.finish, ',', '')) >= numbers.n - 1 " +
            "WHERE b.email = :email " +
            "GROUP BY word " +
            "ORDER BY COUNT(*) DESC " +
            "LIMIT 1", nativeQuery = true)
    String Finish(String email);



    @Query(value = "SELECT DISTINCT * \n" +
            "FROM alcohol \n" +
            "WHERE maincategory = :category \n" +
            "AND (aroma LIKE CONCAT('%', :aroma, '%') OR taste LIKE CONCAT('%', :taste, '%') OR finish LIKE CONCAT('%', :finish, '%')) \n" +
            "LIMIT 8",nativeQuery = true)
    List<Alcohol> personalalgorithm(String category, String aroma, String taste, String finish);
}
