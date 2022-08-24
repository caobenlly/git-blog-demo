package com.example.yourself.Enity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Account")
@Data
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username", nullable = false, length = 50, unique = true)
    private String username;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @Column(name = "first_name", nullable = false, length = 50)
    private  String firstName;

    @Column(name = "last_name",nullable = false, length = 50)
    private  String lastName;

    @Column(name = "role")
    private String Role;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;


    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", Role='" + Role + '\'' +
                '}';
    }
}
