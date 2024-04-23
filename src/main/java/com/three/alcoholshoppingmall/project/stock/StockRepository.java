package com.three.alcoholshoppingmall.project.stock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Stack;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

    Optional<Stack> findByNameAndMarketname(String name, String marketname);
}
