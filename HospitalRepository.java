package com.example.handicappedcare.repository;

import com.example.handicappedcare.model.HospitalModel;
import com.example.handicappedcare.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository  extends JpaRepository<HospitalModel,Integer> {

    HospitalModel findHospitalModelByEmail(String email);

  //  HospitalModel findHospitalModelByHospitalId(Integer hospitalid);
  HospitalModel findHospitalModelByUsername(String username);
}
