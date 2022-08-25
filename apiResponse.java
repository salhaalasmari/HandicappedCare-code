package com.example.handicappedcare.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class apiResponse {
    private String message;
    private Integer status;
}
