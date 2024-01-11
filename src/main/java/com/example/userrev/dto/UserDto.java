package com.example.userrev.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
;

@NoArgsConstructor
@AllArgsConstructor(staticName = "build")

@Data
public class UserDto {
    private String name;
    private int age;
    private String email;
    private String phoneNumber;
}
