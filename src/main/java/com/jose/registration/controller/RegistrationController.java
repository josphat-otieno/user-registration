package com.jose.registration.controller;


import com.jose.registration.model.User;
import com.jose.registration.service.RegistrationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class RegistrationController {
  private final RegistrationService registrationService;

  public RegistrationController(RegistrationService registrationService) {
    this.registrationService = registrationService;
  }

  @GetMapping("/api/v1/users")
  public List<User> getUsers(){
    List<User> users = registrationService.getAllUsers();
    return users;
  }

  @PostMapping("/api/v2/register")
  public User registerUser(@RequestBody User user) throws Exception {
    String emailId = user.getEmail();
    if(emailId != null && !"".equals(emailId)){
       User user1 = registrationService.getUserByEmail(emailId);
       if (user1 !=null){
         throw new Exception("User with this "+ emailId + " already exist");
       }
    }
    User user1 = null;
    user1 = registrationService.registerUser(user);
    return user1;
  }

  @PostMapping("/api/v3/login")
  public User loginUser(@RequestBody User user) throws Exception {
    String email = user.getEmail();
    String password = user.getPassword();
//    User user1 = null;
    if(email !=null && password!=null){
      user = registrationService.getUserByEmailAndPassword(email, password);
    }
    if (user == null){
      throw new Exception("Invalid login details");
    }
    return  user;
  }

}
