package com.example.handicappedcare.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.*;

@AllArgsConstructor @NoArgsConstructor @Data @Entity
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;


    private  String username;
  //  private Integer registerid;
   // @NotEmpty(message = "Role must not be empty ! , enter ur role user")
   // private String role;

    @NotEmpty(message = "Handicapped ID must not be empty ,\n "+
            "Please look at your license and write the number correctly!")
    //@Column(columnDefinition = "varchar(11) unique")
   @Column(unique = true)
    private String handicappedId;

  //  @NotEmpty(message = "User name must not be empty!  \"Please write a unique user name for you to use while registering for the site\")")
    //@Column(columnDefinition = "varchar(255)")
    //private String userName;

    //@NotEmpty(message = "Password must not be empty!"+
    //"Please write a unique Password for you to use while registering for the site")
    //@Column(columnDefinition = "varchar(50)")
    //private String password;

    @NotEmpty(message = "Email must not be empty!"+
    "Register your personal email, whether Gmail, Hotmail, or others")
    @Column(columnDefinition = "varchar(40)")
   @Email
    private String email;

    @NotEmpty(message = "Enter the correct number for your file at the hospital you are being treated in")
    @Column(columnDefinition = "varchar(10)")
    private String fileNumber;
    @NotNull(message = "Age should not be null!")
    private Integer age;
    @NotEmpty(message = "Gender should not be empty!")
   @Column(columnDefinition = "varchar(10) check (Gender='male' or Gender='female')")
    private String gender;
    @NotEmpty(message = "Contact Number should not be null!")
    @Column(columnDefinition = "varchar(10)")
    @Positive(message = "Contact Number must be positive")
    private String contactNumber;
    @NotEmpty(message = "Street Name must not be empty!"+
    "Please write the street name correctly to be delivered to you")
    @Column(columnDefinition = "varchar(50)")
    private String streetName;
    @NotEmpty(message = "Neighborhood Name must not be empty!"+
   "Please write the Neighborhood name correctly to be delivered to you")
    @Column(columnDefinition = "varchar(50)")
    private String neighborhoodName;

    private String nationalAddress;


}
