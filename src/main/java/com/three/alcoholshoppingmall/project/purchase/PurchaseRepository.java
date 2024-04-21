package com.three.alcoholshoppingmall.project.purchase;

import com.three.alcoholshoppingmall.project.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {


    //해당 이메일을 사용하는 사람이 물건을 구매한적 있는지 확인
    @Query(value = "SELECT * FROM Purchase  WHERE email = :email LIMIT 1 ", nativeQuery = true)
    Optional<Purchase> findByEmail(@Param("email") String email);


}
