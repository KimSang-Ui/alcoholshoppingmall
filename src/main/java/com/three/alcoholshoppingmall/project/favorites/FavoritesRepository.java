package com.three.alcoholshoppingmall.project.favorites;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavoritesRepository extends JpaRepository<Favorites, Long> {



    //해당 회원의 즐겨찾기
    @Query(value = "SELECT * FROM favorites WHERE email = :email", nativeQuery = true)
    List<Favorites> MyFavorites(String email);

    Optional<Favorites> findByEmailAndName(String email, String name);

    List<Favorites> deleteByEmailAndAndName(String email, String name);

}
