package com.jose.registration.repository;

import com.jose.registration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<User, Long> {
  User findByEmail(String email);

  User findUserByEmailAndPassword(String email, String password);
}
