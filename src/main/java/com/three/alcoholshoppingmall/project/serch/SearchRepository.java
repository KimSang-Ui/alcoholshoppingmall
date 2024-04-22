package com.three.alcoholshoppingmall.project.serch;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SearchRepository extends JpaRepository<Search, Long> {



}