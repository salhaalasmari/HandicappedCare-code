package com.example.handicappedcare.service;

import com.example.handicappedcare.exception.apiException;
import com.example.handicappedcare.model.ElectricMachineModel;
import com.example.handicappedcare.model.HospitalModel;
import com.example.handicappedcare.model.Register;
import com.example.handicappedcare.repository.ElectricMachineRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ElectricMachineService {


    private  final ElectricMachineRepository electricMachineRepository;

    public List<ElectricMachineModel> getElectricMachine(){
        return electricMachineRepository.findAll();
    }
//   public HospitalModel getHospital(Register r){
//        return  hospitalRepository.findHospitalModelByHospitalId(r.getRegisterid());
//    }
//
//    public void AddHospitals(HospitalModel hospitalModel ,Register r ){
//        hospitalModel.setRegisterid(r.getRegisterid());
//        hospitalRepository.save(hospitalModel);
//    }

    public ElectricMachineModel getAllElectricMachine(Register r){
        return electricMachineRepository.findElectricMachineModelByUsername(r.getUsername());
    }
    public void AddElectricMachine(ElectricMachineModel electricMachineModel ,Register r ){
        electricMachineModel.setUsername(r.getUsername());
        electricMachineRepository.save(electricMachineModel);
    }
    public Integer findQuantity(Integer electricMachineId){
        ElectricMachineModel quantity = electricMachineRepository.getById(electricMachineId);
        if(quantity.getQuantity() >0)
        return quantity.getQuantity();
        else
            System.out.println("There is no quantity available for this device at the moment");
        return 0;
    }


    public  void deleteElectricMachine(Integer electricMachineId){
        ElectricMachineModel machine = electricMachineRepository.getById(electricMachineId);
        if(machine==null){

            throw  new apiException("wrong in  Electric Machine id");

        }
        electricMachineRepository.delete(machine);

    }
    public void UpdateElectricMachine(Integer id , ElectricMachineModel electricMachineModel){
        Optional<ElectricMachineModel> optionalElectricMachineModel = electricMachineRepository.findById(id);
        if (optionalElectricMachineModel.isEmpty()){
            throw  new apiException("Wrong Electric Machine ID!");
        }
        ElectricMachineModel newMachine=optionalElectricMachineModel.get();
        if(newMachine.getMachineName()!=null)
            newMachine.setMachineName(electricMachineModel.getMachineName());
        if(newMachine.getMachineSize()!=null)
            newMachine.setMachineSize(electricMachineModel.getMachineSize());
        if(newMachine.getPoweredByElectricity()!=null)
           newMachine.setPoweredByElectricity(electricMachineModel.getPoweredByElectricity());
        if(newMachine.getBrandName()!=null)
            newMachine.setBrandName(electricMachineModel.getBrandName());
        if(newMachine.getMachineColor()!=null)
            newMachine.setMachineColor(electricMachineModel.getMachineColor());
        if(newMachine.getMachineType()!=null)
            newMachine.setMachineType(electricMachineModel.getMachineType());
        if(newMachine.getMachineWeight()!=null)
            newMachine.setMachineWeight(electricMachineModel.getMachineWeight());
        if(newMachine.getMachineMaterial()!=null)
            newMachine.setMachineMaterial(electricMachineModel.getMachineMaterial());
        if(newMachine.getFoldable()!=null)
           newMachine.setFoldable(electricMachineModel.getFoldable());
        electricMachineRepository.save(newMachine);

    }
public  void UpdateQuantity(Integer id , ElectricMachineModel electricMachineModel ){
    Optional<ElectricMachineModel> optionalElectricMachineModel = electricMachineRepository.findById(id);
    if (optionalElectricMachineModel.isEmpty()){
        throw  new apiException("Wrong Electric Machine ID!");
    }
    ElectricMachineModel newMachine=optionalElectricMachineModel.get();
    if(newMachine.getQuantity()!=null)
        newMachine.setQuantity(electricMachineModel.getQuantity());
    electricMachineRepository.save(newMachine);
}
}
