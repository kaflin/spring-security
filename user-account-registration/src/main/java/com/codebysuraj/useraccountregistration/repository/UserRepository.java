package com.codebysuraj.useraccountregistration.repository;

import com.codebysuraj.useraccountregistration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmail(String email);
    User findByConfirmationToken(String confirmationToken);

    User findByEmailAndPassword(String email, String password);



}
