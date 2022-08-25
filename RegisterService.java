package com.example.handicappedcare.service;

import com.example.handicappedcare.exception.apiException;
import com.example.handicappedcare.model.Register;
import com.example.handicappedcare.model.UserModel;
import com.example.handicappedcare.repository.RegisterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegisterService {

   private final RegisterRepository registerRepository;
 
    public List<Register> getRegister(){
        return registerRepository.findAll();
    }


     public void register(Register register){
        String hashedPassword= new BCryptPasswordEncoder().encode(register.getPassword());
         register.setPassword(hashedPassword);

         registerRepository.save(register);
      }

//    public  void deleteRegister(Integer id){
//        Register register = registerRepository.getById(id);
//        if(register==null){
//
//            throw  new apiException("wrong in user id");
//
//        }
//        registerRepository.delete(register);
//
//    }

    public  void deleteRegister(String username){
        Register register = registerRepository.findRegistersByUsername(username);
        if(register==null){

            throw  new apiException("wrong in user name");

        }
        registerRepository.delete(register);

    }

    public  boolean updatePassword(String username , String password){
        Register newPassword = registerRepository.findRegistersByUsername(username);
        if(newPassword != null){
            newPassword.setPassword(password);
            registerRepository.save(newPassword);
            return true;
        }
        return false;
    }

}
