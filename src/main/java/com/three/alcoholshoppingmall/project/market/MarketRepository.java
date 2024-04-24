package com.three.alcoholshoppingmall.project.market;

<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketRepository extends JpaRepository<Market,Long> {
=======
import com.three.alcoholshoppingmall.project.review.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MarketRepository  extends JpaRepository<Market, Long> {

>>>>>>> d85a169e0b589f1ce29eb65dc3d8a308032fcedb

}
