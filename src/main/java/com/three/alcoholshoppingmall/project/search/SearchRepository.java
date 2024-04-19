package com.three.alcoholshoppingmall.project.search;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;



@Repository
public interface SearchRepository extends JpaRepository<Search, Long> {

//    List<Search> findTop5ByOrderByIdDesc(SearchDto searchDto);

}