package com.example.handicappedcare.controller;


import com.example.handicappedcare.dto.apiResponse;
import com.example.handicappedcare.model.Register;
import com.example.handicappedcare.model.UserModel;
import com.example.handicappedcare.service.UserService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import javax.validation.Valid;
import java.util.List;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

@RestController
@RequestMapping("/api/v1/User")
@RequiredArgsConstructor
public class UserController {


    private  final UserService userService;


    @GetMapping("/getUsers")
    public ResponseEntity getUsers(){
        List<UserModel> users=userService.getUsers();
        return ResponseEntity.status(200).body(users);
    }
    @GetMapping("/getUser")
    public ResponseEntity getUser(@AuthenticationPrincipal Register r){
        UserModel user=userService.getUser(r);
        return ResponseEntity.status(200).body(user);
    }


    @PostMapping("/addUsers")
    public ResponseEntity addUsers(@RequestBody @Valid UserModel user ,@AuthenticationPrincipal Register r  ){

        userService.AddUsers(user , r);
        return ResponseEntity.status(200).body(new apiResponse("User added successfully!",200));
    }
    @DeleteMapping("/deleteUsers/{Id}")
    public ResponseEntity deleteUser(@PathVariable Integer Id){
        userService.deleteUser(Id);
        return ResponseEntity.status(200).body(new apiResponse("User deleted successfully!",200));

    }
    @PutMapping("/update/{Id}")
    public  ResponseEntity UpdateUser(@PathVariable Integer Id , @RequestBody  UserModel user  ){
        userService.UpdateUser(Id , user);
        return ResponseEntity.status(200).body(new apiResponse("User updated successfully!",200));
    }
    //UpdateAdress
    @PutMapping("/updateAdress/{Id}")
    public  ResponseEntity UpdateAdress(@PathVariable Integer Id , @RequestBody  UserModel user  ){
        userService.UpdateAdress(Id , user);
        return ResponseEntity.status(200).body(new apiResponse("User updated successfully!",200));
    }
//    @PutMapping("/updatePassword/{Id}/{password}")
//    public ResponseEntity updatePassword(@PathVariable Integer Id,@PathVariable String password){
//        if(userService.updatePassword(Id,password)){
//            return ResponseEntity.status(201).body("Password Updated successfully");
//        }
//        return ResponseEntity.status(400).body("User not found");
//    }
//
    //@GetMapping("/checkuser/{username}/{password}")
  //  public ResponseEntity checkUsers(@PathVariable String username,@PathVariable String password){
      //  if (!userService.checkUsers(username,password)){
        //    return ResponseEntity.status(400).body("Wrong username or password");
        //}
        //return ResponseEntity.status(201).body("Correct username and password");
   // }
//  @GetMapping("/byEmail")
//    public ResponseEntity<User> getUserByEmail(@RequestBody String email){
//        User user= userService.getUserByEmail(email);
//        return ResponseEntity.status(200).body(user);
//    }
    @GetMapping("/handicappeId/{handicappedId}")
    private ResponseEntity checkhandicappedId(@PathVariable String handicappedId){
        UserModel user = userService.findUserByHanicappedId(handicappedId);
        return  ResponseEntity.status(200).body(user);

    }


}
