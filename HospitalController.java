package com.example.handicappedcare.controller;

import com.example.handicappedcare.dto.apiResponse;
import com.example.handicappedcare.model.HospitalModel;
import com.example.handicappedcare.model.Register;
import com.example.handicappedcare.model.UserModel;
import com.example.handicappedcare.service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/Hospitals")
@RequiredArgsConstructor
public class HospitalController {

    private final HospitalService hospitalService;

    @GetMapping("/getHospitals")
    public ResponseEntity getHospitals(){
        List<HospitalModel> hospitals=hospitalService.getHospitals();
        return ResponseEntity.status(200).body(hospitals);
    }
    @GetMapping("/getHospital")
    public ResponseEntity getHospital(@AuthenticationPrincipal Register r){
        HospitalModel hospital=hospitalService.getHospital(r);
        return ResponseEntity.status(200).body(hospital);
    }

    @PostMapping("/addHospitals")
    public ResponseEntity addHospitals(@RequestBody @Valid HospitalModel hospital , @AuthenticationPrincipal Register r  ){

        hospitalService.AddHospitals(hospital , r);
        return ResponseEntity.status(200).body(new apiResponse("Hospital added successfully!",200));
    }

    @DeleteMapping("/deleteHospitals/{Id}")
    public ResponseEntity deleteUser(@PathVariable Integer Id){
        hospitalService.deleteHospitals(Id);
        return ResponseEntity.status(200).body(new apiResponse("Hospital deleted successfully!",200));

    }
    @PutMapping("/update/{Id}")
    public  ResponseEntity UpdateHospitals(@PathVariable Integer Id , @RequestBody  HospitalModel hospital){
        hospitalService.UpdateHospitla(Id, hospital);
        return ResponseEntity.status(200).body(new apiResponse("Hospital updated successfully!",200));
    }

    @GetMapping("/getHospitalByEmail/{email}")
    public ResponseEntity<HospitalModel> getHospitalByEmail(@PathVariable String email){
        return ResponseEntity.status(200).body(hospitalService.findHospitalByEmail(email));
    }


  //  @PutMapping("/updatePassword/{Id}/{password}")
//    public ResponseEntity updatePassword(@PathVariable Integer Id,@PathVariable String password){
//        if(hospitalService.updatePassword(Id, password)){
//            return ResponseEntity.status(201).body("Password Updated successfully");
//        }
//        return ResponseEntity.status(400).body("User not found");
//    }
//


}
