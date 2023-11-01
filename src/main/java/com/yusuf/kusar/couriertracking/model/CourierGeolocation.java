package com.yusuf.kusar.couriertracking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "courier_geolocation")
public class CourierGeolocation {

    @Id
    private Long id;
    private Long courierId;
    private Double lat;
    private Double lng;
}
