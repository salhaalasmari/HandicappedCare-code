package com.example.handicappedcare.controller;

import com.example.handicappedcare.dto.apiResponse;
import com.example.handicappedcare.model.ElectricMachineModel;
import com.example.handicappedcare.model.HospitalModel;
import com.example.handicappedcare.model.OrderModel;
import com.example.handicappedcare.model.Register;
import com.example.handicappedcare.service.ElectricMachineService;
import com.example.handicappedcare.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/ElectricMachine")
@RequiredArgsConstructor
public class ElectricMachineController {

    private  final ElectricMachineService electricMachineService;
    private  final OrderService orderService;

    @GetMapping("/getElectricMachines")
    public ResponseEntity getElectricMachine(){
        List<ElectricMachineModel> ElectricMachine =electricMachineService.getElectricMachine();
        return ResponseEntity.status(200).body(ElectricMachine);
    }
    @GetMapping("/getElectricMachine")
    public ResponseEntity getAllMacine(@AuthenticationPrincipal Register r){
        ElectricMachineModel ElectricMachine=electricMachineService.getAllElectricMachine(r);
        return ResponseEntity.status(200).body(ElectricMachine);
    }

    @GetMapping("/findQuantity/{electricMachineId}")
    public  ResponseEntity getQuantity(@PathVariable Integer electricMachineId){
        return  ResponseEntity.status(200).body( electricMachineService.findQuantity(electricMachineId));


    }
    //  @PutMapping("/addStock/{productId}/{merchantId}/{stock}")
    //    public ResponseEntity addStock(@PathVariable String productId, @PathVariable String merchantId , @PathVariable Integer stock){
    //        Integer isValid=userService.addStock(productId,merchantId,stock);
    //
    //        if (isValid==-1){
    //            return ResponseEntity.status(400).body(new ApiResponse("Stock must be positive number!"));
    //        } else if (isValid==0){
    //            return ResponseEntity.status(200).body(new ApiResponse("Stock added successfully"));
    //        }
    //        return ResponseEntity.status(400).body(new ApiResponse("Wrong merchantId or productId"));
    //    }
    @GetMapping("/requestMachine/{electricMachineId}")
    public  ResponseEntity requestMachine(@PathVariable Integer electricMachineId){
     Boolean isValid= orderService.MachineRequest(electricMachineId);
     if(isValid.equals(true)) {
         return ResponseEntity.status(200).body(new apiResponse(" request Electric Machine successfully!", 200));
     }
     else
         return ResponseEntity.status(400).body(new apiResponse("The quantity required for this electricMachine has expired", 400));
     //}
     //   return ResponseEntity.status(400).body(new apiResponse("Wrong electricMachineId",400));

    }


    @PostMapping("/addElectricMachine")
    public ResponseEntity addElectricMachine(@RequestBody @Valid ElectricMachineModel ElectricMachine , @AuthenticationPrincipal Register r){
        electricMachineService.AddElectricMachine(ElectricMachine , r);
        return ResponseEntity.status(200).body(new apiResponse("Electric Machine added successfully!",200));
    }

    @DeleteMapping("/deleteElectricMachine/{Id}")
    public ResponseEntity deleteElectricMachine(@PathVariable Integer Id){
        electricMachineService.deleteElectricMachine(Id);
        return ResponseEntity.status(200).body(new apiResponse("Electric Machine deleted successfully!",200));

    }
    @PutMapping("/update/{Id}")
    public  ResponseEntity UpdateElectricMachine(@PathVariable Integer Id , @RequestBody  ElectricMachineModel ElectricMachine ){
        electricMachineService.UpdateElectricMachine(Id,ElectricMachine);
        return ResponseEntity.status(200).body(new apiResponse("Electric Machine updated successfully!",200));
    }
    @PutMapping("/updateQuantity/{Id}")
    public ResponseEntity updateQuantity(@PathVariable Integer Id , @RequestBody  ElectricMachineModel ElectricMachine ){
        electricMachineService.UpdateQuantity(Id, ElectricMachine);
        return ResponseEntity.status(200).body(new apiResponse("Quantity updated successfully!",200));
    }
}
