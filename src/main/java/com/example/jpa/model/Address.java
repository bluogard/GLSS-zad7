package com.example.jpa.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    private String city;
    private String country;
    private String street;

    @JsonManagedReference
    @OneToMany(mappedBy = "address")
    private List<Student> studentList = new ArrayList<>();
}
