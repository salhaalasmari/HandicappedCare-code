package com.example.handicappedcare.repository;

import com.example.handicappedcare.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository  extends JpaRepository<UserModel,Integer> {

  //  UserModel findUserModelByUserNameAndPassword(String userName , String password);
    //    User findUserByEmail(String email);
    UserModel findUserModelByHandicappedId(String handicappedId);

 // UserModel findUserModelByUserId(Integer userId);

UserModel findUserModelByUsername(String username);

}
