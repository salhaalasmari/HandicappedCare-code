package com.example.handicappedcare.service;

import com.example.handicappedcare.exception.apiException;
import com.example.handicappedcare.model.Register;
import com.example.handicappedcare.model.UserModel;
import com.example.handicappedcare.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserModel> getUsers(){
        return userRepository.findAll();
    }
public UserModel getUser(Register r){
       // return userRepository.findUserModelByUserId(r.getRegisterid());
    return  userRepository.findUserModelByUsername(r.getUsername());
}

    public void AddUsers(UserModel userModel , Register r) {
     //   userModel.setRegisterid(r.getRegisterid());
        userModel.setUsername(r.getUsername());
        userRepository.save(userModel);
    }



    public  void deleteUser(Integer UserId){
        UserModel user = userRepository.getById(UserId);
if(user==null){

    throw  new apiException("wrong in user id");

}
userRepository.delete(user);

    }




    public void UpdateUser(Integer id , UserModel userModel){
        Optional<UserModel> optionalUserModel = userRepository.findById(id);
        if (optionalUserModel.isEmpty()){
            throw  new apiException("Wrong student ID!");
        }
        UserModel user=optionalUserModel.get();
        if(user.getEmail()!=null)
        user.setEmail(userModel.getEmail());
        if(user.getAge()!=null)
        user.setAge(userModel.getAge());
        if(user.getGender()!=null)
        user.setGender(userModel.getGender());
        if(user.getFileNumber()!=null)
        user.setFileNumber(userModel.getFileNumber());
        if(user.getContactNumber()!=null)
        user.setContactNumber(userModel.getContactNumber());
        userRepository.save(user);

    }

    public void UpdateAdress(Integer id , UserModel userModel){
        Optional<UserModel> optionalUserModel = userRepository.findById(id);
        if (optionalUserModel.isEmpty()){
            throw  new apiException("Wrong student ID!");
        }
        UserModel user=optionalUserModel.get();
        if(user.getStreetName()!=null)
         user.setStreetName(userModel.getStreetName());
        if(user.getNeighborhoodName()!=null)
            user.setNeighborhoodName(userModel.getNeighborhoodName());
        if(user.getNationalAddress()!=null)
            user.setNationalAddress(userModel.getNationalAddress());

        userRepository.save(user);

    }


//    public  boolean updatePassword(Integer id , String password){
//        UserModel newUser = userRepository.getById(id);
//        if(newUser != null){
//            newUser.setPassword(password);
//            userRepository.save(newUser);
//            return true;
//        }
//        return false;
//    }
//
//  public boolean checkUsers(String username,String password){
//        if(userRepository.findUserByUsernameAndPassword(username,password)!= null)
//            return true;
//        return false;
//    }
//    public boolean checkUsers(String userName , String password){
//        if(userRepository.findUserModelByUserNameAndPassword(userName,password)!=null)
//            return  true;
//        return  false;
//    }
    public UserModel findUserByHanicappedId(String handicappedId){
        UserModel users = userRepository.findUserModelByHandicappedId(handicappedId);
        if(users ==null){
            throw new apiException("Wrong user handicapped Id!");
        }
        return users;
    }






}
