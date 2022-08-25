package com.example.handicappedcare.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@AllArgsConstructor @NoArgsConstructor @Data @Entity
public class ElectricMachineModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer electricMachineId;

    private  String username;
//    private Integer registerid;

    @NotNull(message = "Hospital ID must not be empty")
    @Positive(message = "Hospital ID must be positive")
    private  Integer hospitalId;

    @NotEmpty(message = "Machine Name must not be empty! ")
    @Column(columnDefinition = "varchar(50)")
    private  String machineName;
    @NotEmpty(message = "Machine Size must not be empty! ")
    @Column(columnDefinition = "varchar(50)")
    private  String machineSize;
    @NotEmpty(message = "Powered By Electricity must not be empty! ")
    @Column(columnDefinition = "varchar(50)")
    private String poweredByElectricity;
    @NotEmpty(message = "Brand Name must not be empty! ")
    @Column(columnDefinition = "varchar(50)")
    private String brandName;
    @NotEmpty(message = "Machine Color must not be empty! ")
    @Column(columnDefinition = "varchar(50)")
    private String machineColor;
    @NotEmpty(message = "Machine Type must not be empty! ")
    @Column(columnDefinition = "varchar(50)")
    private String machineType;
    @NotEmpty(message = "Machine Weight must not be empty! ")
    @Column(columnDefinition = "varchar(50)")
    private String machineWeight;
    @NotEmpty(message = "Machine Material must not be empty! ")
    @Column(columnDefinition = "varchar(50)")
    private String machineMaterial;
    @NotEmpty(message = "Foldable must not be empty! ")
    @Column(columnDefinition = "varchar(50)")
    private String foldable;
    @NotNull(message = "Quantity must be not null")
    @Column(columnDefinition = "varchar(50)")
    private  Integer quantity;



}
