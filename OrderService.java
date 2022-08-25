package com.example.handicappedcare.service;

import com.example.handicappedcare.exception.apiException;
import com.example.handicappedcare.model.ElectricMachineModel;
import com.example.handicappedcare.model.OrderModel;
import com.example.handicappedcare.model.Register;
import com.example.handicappedcare.model.UserModel;
import com.example.handicappedcare.repository.ElectricMachineRepository;
import com.example.handicappedcare.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderService {
    private  final ElectricMachineRepository electricMachineRepository;
    private  final OrderRepository orderRepository;


    public List<OrderModel> getOrder(){
        return orderRepository.findAll();
    }
//public UserModel getUser(Register r){
//        return userRepository.findUserModelByUserId(r.getRegisterid());
//}
//
//    public void AddUsers(UserModel userModel , Register r) {
//        userModel.setRegisterid(r.getRegisterid());
//        userRepository.save(userModel);
//    }

    public  OrderModel getSingleOrder(Register r){
        return orderRepository.findOrderModelByUsername(r.getUsername());
    }

    public void AddOrder(OrderModel order ,  Register r){
        order.setUsername(r.getUsername());
        orderRepository.save(order);
    }



    public  void deleteOrder(Integer OrderId){
        OrderModel order = orderRepository.getById(OrderId);
        if(order==null){

            throw  new apiException("wrong in order id");

        }
        orderRepository.delete(order);

    }


    public void UpdateOrder(Integer id , OrderModel order){
        Optional<OrderModel> optionalOrderModel = orderRepository.findById(id);
        if (optionalOrderModel.isEmpty()){
            throw  new apiException("Wrong order ID!");
        }
        OrderModel neworder=optionalOrderModel.get();
        if(neworder.getMachineId()!=null)
   neworder.setMachineId(order.getMachineId());

        orderRepository.save(neworder);

    }
//    public void MachineRequest(Integer electricMachineId){
//        ElectricMachineModel quantity = electricMachineRepository.getById(electricMachineId);
//        OrderModel changeState = orderRepository.getById(electricMachineId);
//        if(quantity.getQuantity()>0){
//            quantity.setQuantity(quantity.getQuantity()-1);
//            electricMachineRepository.save(quantity);
//        changeState.setState("complete");
//        orderRepository.save(changeState);
//        }
//        else {
//            System.out.println("The quantity required for this electricMachine has expired");
//        }
//
//    }


    public Boolean MachineRequest(Integer electricMachineId){
        ElectricMachineModel quantity = electricMachineRepository.getById(electricMachineId);
        OrderModel changeState = orderRepository.getById(electricMachineId);

        if(quantity.getQuantity()>0){
            quantity.setQuantity(quantity.getQuantity()-1);
            electricMachineRepository.save(quantity);
        changeState.setState("complete");
        orderRepository.save(changeState);
        return true;
        }
        else
            System.out.println("The quantity required for this electricMachine has expired");
        return false;

    }


}
