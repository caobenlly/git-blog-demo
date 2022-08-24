package com.example.yourself.Enity;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Department")
@Data
public class Department {
    @Column(name = "id",insertable = false,updatable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "name", length = 50)
    private  String name;

    @Column(name = "total_member")
    private Integer totalMember;

    @Column(name = "type", nullable = false)
    private String type;

    @CreationTimestamp
    @Column(name = "created_date")
    private LocalDateTime createDate;


    @OneToMany(mappedBy = "department")
    private List<Account> accounts;

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", totalMember=" + totalMember +
                ", type='" + type + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
