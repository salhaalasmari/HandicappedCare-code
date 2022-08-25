package com.example.handicappedcare.repository;

import com.example.handicappedcare.model.ElectricMachineModel;
import com.example.handicappedcare.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderModel,Integer> {

    //OrderModel findOrderModelByOrderId(Integer orderid);
  //  private  String username;
    OrderModel  findOrderModelByUsername(String username);
}
