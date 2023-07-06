package com.example.basesphinx.model;

import com.example.basesphinx.constant.Constants;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RoleId")
    private int id;
    @Column(name = "RoleName")
    @Enumerated(EnumType.STRING)
    private Constants.ERole roleName;
}
