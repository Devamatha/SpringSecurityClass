package com.example.springsecurity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private long id;

    private String name;

    private String email;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String pwd;

    private String role;

    @Column(name = "create_dt")
    @JsonIgnore
    private Date createDt;


    @JsonManagedReference
    @OneToMany(mappedBy = "customer")
    private List<AccountTransaction> accountTransactionList = new ArrayList<>();

//    @JsonManagedReference
//    @OneToOne(mappedBy = "customer")
//    private List<Accounts> accountsList = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "customer")
    private List<Cards> cards = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "customer")
    private List<Loans> loans = new ArrayList<>();

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Authority> authorities;

}
