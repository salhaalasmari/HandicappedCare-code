package com.example.handicappedcare.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class OrderModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer orderId;
    @NotNull(message = "Machine ID must not be empty")
    @Positive(message = "Machine ID must be positive")
    private Integer machineId;
   // private Integer registerid;
   private  String username;
    private String state="new";
}
