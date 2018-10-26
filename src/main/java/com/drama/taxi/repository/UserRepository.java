package com.drama.taxi.repository;

import com.drama.taxi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserEmail(String userEmail);

    User findUserById(Long id);

}
