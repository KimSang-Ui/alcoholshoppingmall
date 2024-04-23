package com.three.alcoholshoppingmall.project.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);

    User findByEmailAndPassword(String email, String password);
}
