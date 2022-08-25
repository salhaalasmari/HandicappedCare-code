package com.example.handicappedcare.repository;

import com.example.handicappedcare.model.ElectricMachineModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectricMachineRepository extends JpaRepository<ElectricMachineModel,Integer> {


   // ElectricMachineModel findElectricMachineModelByElectricMachineId(Integer ElectricMachine);
    ElectricMachineModel findElectricMachineModelByUsername(String username);
}
