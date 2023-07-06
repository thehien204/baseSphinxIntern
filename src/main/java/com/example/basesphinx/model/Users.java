package com.example.basesphinx.model;


import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserId")
    private int id ;
    @Column(name = "UserName", nullable = false, unique = true)
    private String userName;
    @Column(name = "Password", nullable = false)
    private String password;
    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "LastName")
    private String lastName;
    @Column(name = "Age")
    private int age;
    @Column(name = "Email", nullable = false, unique = true)
    private String email;
    @Column(name="Active", nullable = false)
    private int active;
    @Column(name = "Address")
    private String address;
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(name = "CreatedDate" ,nullable = false,updatable = false)
    private Date createDate;
    @PrePersist
    private void onCreate(){
        createDate = new Date();
    }
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "User_Role", joinColumns = @JoinColumn(name = "UserId"), inverseJoinColumns = @JoinColumn(name = "RoleId"))
    private Set<Role> listRole = new HashSet<>();

}
