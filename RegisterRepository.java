package com.example.handicappedcare.repository;

import com.example.handicappedcare.model.Register;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository extends JpaRepository<Register,Integer> {

    Register findRegistersByUsername(String username);
     //OrderModel findOrderModelByOrderId(Integer orderid);
  //  Register findRegistersByRegisterid(Integer registerid);

}
