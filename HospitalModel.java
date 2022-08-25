package com.example.handicappedcare.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class HospitalModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer hospitalId;

    private  String username;
   // private Integer registerid;

    @NotEmpty(message = "hospital Name must not be empty! ")
    @Column(columnDefinition = "varchar(50) unique")
    private String hospitalName;

    //@NotEmpty(message = "Password must not be empty!"+
      //      "Please write a unique Password for you to use while registering for the site")
    //@Column(columnDefinition = "varchar(50) unique")
    //private String password;

    //@NotEmpty(message = "Role must not be empty!")
    //@Column(columnDefinition = "varchar(10) check (role='admin')")
    //private String role;

    @NotEmpty(message = "location must not be empty! ")
    @Column(columnDefinition = "varchar(50)")
    private  String location;
    @NotEmpty(message = "Email must not be empty!"+
            "Register the hospital email, whether Gmail, Hotmail, or others")
    @Column(columnDefinition = "varchar(40)")
    @Email
    private String email;
    @NotEmpty(message = "Contact Number should not be null!")
    @Column(columnDefinition = "varchar(10)")
    private String phoneNumber;
    //@NotEmpty(message = "Admin Name should not be null!")
    //@Column(columnDefinition = "varchar(50)")
    //private String adminName;
  //  @NotNull(message = "Machine ID must not be empty")
    //@Positive(message = "Machine ID must be positive")
    //private  Integer MachineId;


}
