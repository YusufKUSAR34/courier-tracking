package com.yusuf.kusar.couriertracking.model;

import com.yusuf.kusar.couriertracking.aop.annotation.ID;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "store")
public class Store {
    @Id
    private String name;
    private double lat;
    private double lng;
}
