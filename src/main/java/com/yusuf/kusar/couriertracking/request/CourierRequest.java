package com.yusuf.kusar.couriertracking.request;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourierRequest {

    private Long id;
    @NotEmpty(message = "courierName cannot be empty")
    @NotNull(message = "courierName must not be null")
    private String name;
    @NotNull(message = "age cannot be null")
    @Min(value = 18, message = "age must be min 18")
    @Max(value = 40, message = "age must be max 40")
    private Integer age;
    @Min(value = 10000, message = "salary must be min 100000")
    @Max(value = 50000, message = "salary must be max 500000")
    @NotNull(message = "salary cannot be null")
    private Double salary;
}
