package com.example.handicappedcare.controller;


import com.example.handicappedcare.dto.apiResponse;
import com.example.handicappedcare.model.Register;
import com.example.handicappedcare.model.UserModel;
import com.example.handicappedcare.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/Register")
public class RigisterController {

    //@GetMapping Mapping("/login")
        @GetMapping("/login")
    public ResponseEntity login(){
        return ResponseEntity.status(200).body(new apiResponse("Welcome back !",200));
    }
    private  final RegisterService registerService;
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid Register register){
        registerService.register(register);
        return ResponseEntity.status(200).body(new apiResponse("Registration information has been added upon your request!",200));
    }

    @GetMapping("/getRegister")
    public ResponseEntity getregister(){
        List<Register> users=registerService.getRegister();
        return ResponseEntity.status(200).body(users);
    }
    @DeleteMapping("/deleteregister/{username}")
    public ResponseEntity deleteregister(@PathVariable String username){
        registerService.deleteRegister(username);
        return ResponseEntity.status(200).body(new apiResponse("Registration information has been deleted at your request!",200));

    }
    @PutMapping("/updatePassword/{username}/{password}")
    public ResponseEntity updatePassword(@PathVariable String username,@PathVariable String password){
        if(registerService.updatePassword(username,password)){
            return ResponseEntity.status(201).body("Password Updated successfully");
        }
        return ResponseEntity.status(400).body("User not found");
    }
}
