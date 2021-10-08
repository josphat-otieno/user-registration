package com.jose.registration.service;

import com.jose.registration.model.User;
import com.jose.registration.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {
  private final RegistrationRepository registrationRepository;

  @Autowired
  public RegistrationService(RegistrationRepository registrationRepository) {
    this.registrationRepository = registrationRepository;
  }

  public List<User> getAllUsers(){
    return registrationRepository.findAll();
  }
  public User registerUser(User user){
    return registrationRepository.save(user);
  }

  public User getUserByEmail(String email){
   return registrationRepository.findByEmail(email);
  }
  public User getUserByEmailAndPassword(String email, String password){
    return registrationRepository.findUserByEmailAndPassword(email, password);
  }
}
