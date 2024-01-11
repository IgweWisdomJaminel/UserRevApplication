package com.example.userrev.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import static jakarta.persistence.GenerationType.IDENTITY;
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
@Getter
@Setter
@Data
@Entity
@Table(name = "User_table", uniqueConstraints ={@UniqueConstraint(columnNames = {"Email"})} )
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name ="Id")
    long userId;

    @NotBlank
    @Column(name="Name")
    private String name;

    @Min(18)
    @Max(75)
    @Column(name = "Age")
    private int age;

    @Email
    @Column(name ="Email")
    private String email;



    @Column(name = "Phone_Number")
    private String phoneNumber;


}
