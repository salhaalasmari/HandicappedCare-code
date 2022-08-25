package com.example.handicappedcare.service;

import com.example.handicappedcare.exception.apiException;
import com.example.handicappedcare.model.HospitalModel;
import com.example.handicappedcare.model.Register;
import com.example.handicappedcare.model.UserModel;
import com.example.handicappedcare.repository.HospitalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HospitalService {
    private final HospitalRepository hospitalRepository;

    public List<HospitalModel> getHospitals(){
        return hospitalRepository.findAll();
    }

    public HospitalModel getHospital(Register r){
        return  hospitalRepository.findHospitalModelByUsername(r.getUsername());
    }

    public void AddHospitals(HospitalModel hospitalModel ,Register r ){
        hospitalModel.setUsername(r.getUsername());
        hospitalRepository.save(hospitalModel);
    }
    public  void deleteHospitals(Integer HospitalId){
        HospitalModel Hospital = hospitalRepository.getById(HospitalId);
        if(Hospital==null){

            throw  new apiException("wrong in Hospital id");

        }
        hospitalRepository.delete(Hospital);

    }

    public void UpdateHospitla(Integer id , HospitalModel hospitalModel){
        Optional<HospitalModel> optionalHospitalModel = hospitalRepository.findById(id);
        if (optionalHospitalModel.isEmpty()){
            throw  new apiException("Wrong Hospital ID!");
        }
        HospitalModel newhospital=optionalHospitalModel.get();
        if(newhospital.getLocation()!=null)
            newhospital.setLocation(hospitalModel.getLocation());
      if(newhospital.getPhoneNumber()!=null)
          newhospital.setPhoneNumber(hospitalModel.getPhoneNumber());
      if(newhospital.getEmail()!=null)
          newhospital.setEmail(hospitalModel.getEmail());
      if(newhospital.getHospitalName()!=null)
          newhospital.setHospitalName(hospitalModel.getHospitalName());
        hospitalRepository.save(newhospital);

    }

    public HospitalModel findHospitalByEmail(String  email){
        return hospitalRepository.findHospitalModelByEmail(email);
    }

//    public  boolean updatePassword(Integer id , String password){
//        HospitalModel newHospital = hospitalRepository.getById(id);
//        if(newHospital != null){
//            newHospital.setPassword(password);
//            hospitalRepository.save(newHospital);
//            return  true;
//        }
//
//        return  false;
//    }
//



}
