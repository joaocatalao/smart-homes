package com.example.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Device extends PanacheEntity {
    public String name;
    public String type;
    public String status;
}
