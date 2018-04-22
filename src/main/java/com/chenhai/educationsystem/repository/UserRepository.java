package com.chenhai.educationsystem.repository;

import com.chenhai.educationsystem.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
