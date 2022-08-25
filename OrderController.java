package com.example.handicappedcare.controller;

import com.example.handicappedcare.dto.apiResponse;
import com.example.handicappedcare.model.ElectricMachineModel;
import com.example.handicappedcare.model.OrderModel;
import com.example.handicappedcare.model.Register;
import com.example.handicappedcare.model.UserModel;
import com.example.handicappedcare.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/Order")
@RequiredArgsConstructor
public class OrderController {
    private  final OrderService orderService;

    @GetMapping("/getOrders")
    private ResponseEntity getOrders(){
        List<OrderModel> order = orderService.getOrder();
        return ResponseEntity.status(200).body(order);
    }

    @GetMapping("/getOrder")
    public ResponseEntity getOrder(@AuthenticationPrincipal Register r){
        OrderModel order=orderService.getSingleOrder(r);
        return ResponseEntity.status(200).body(order);
    }

    @PostMapping("/addOrder")
    public ResponseEntity addOrders(@RequestBody @Valid OrderModel order ,  @AuthenticationPrincipal Register r ){
        orderService.AddOrder(order , r);
        return ResponseEntity.status(200).body(new apiResponse("Order added successfully!",200));
    }


    @DeleteMapping("/deleteOrder/{Id}")
    public ResponseEntity deleteOrder(@PathVariable Integer Id){
        orderService.deleteOrder(Id);
        return ResponseEntity.status(200).body(new apiResponse("Order deleted successfully!",200));
    }
    @PutMapping("/update/{Id}")
    public  ResponseEntity UpdateElectricMachine(@PathVariable Integer Id , @RequestBody  OrderModel order ){
        orderService.UpdateOrder(Id, order);
        return ResponseEntity.status(200).body(new apiResponse("Order updated successfully!",200));
    }
    @GetMapping("/requestMachine/{electricMachineId}")
    public  ResponseEntity requestMachine(@PathVariable Integer electricMachineId){

        orderService.MachineRequest(electricMachineId);
        return ResponseEntity.status(200).body(new apiResponse("Order request machine successfully!",200));

    }
}
