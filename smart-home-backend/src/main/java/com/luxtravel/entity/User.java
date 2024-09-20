package com.example.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class User extends PanacheEntity {
    @Column(unique = true)
    public String username;
    public String password;  // In a real-world application, you should hash passwords
}
