package com.codebysuraj.useraccountregistration.service;

import com.codebysuraj.useraccountregistration.model.ResetToken;
import com.codebysuraj.useraccountregistration.model.User;
import com.codebysuraj.useraccountregistration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service("userService")
public class UserService {

   @Autowired
   private UserRepository userRepository;


    public User findByEmail(String email)
    {
        return userRepository.findByEmail(email);

    }
    public User findByConfirmationToken(String confirmationToken) {
        return userRepository.findByConfirmationToken(confirmationToken);
    }
    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User findByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email,password);
    }




    public void save(ResetToken resetToken) {

    }



}


