package com.yusuf.kusar.couriertracking.model;

import com.yusuf.kusar.couriertracking.aop.annotation.ID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "courier")
public class Courier {

    @Id
    private Long id;
    private String name;
    private Integer age;
    private Double salary;
}
