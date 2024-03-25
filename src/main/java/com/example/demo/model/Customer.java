package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Customer {
    //@Column(name="id") dung de hop twng collum
    //tu dong ghi id vao db
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  String username;
    private String password;
    private String role;
}
