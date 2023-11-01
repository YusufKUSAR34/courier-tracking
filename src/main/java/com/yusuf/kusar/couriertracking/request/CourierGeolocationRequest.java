package com.yusuf.kusar.couriertracking.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourierGeolocationRequest {
    private Long id;
    @NotNull(message = "courierId cannot be null")
    private Long courierId;
    @NotNull(message = "lat cannot be null")
    private Double lat;
    @NotNull(message = "lng cannot be null")
    private Double lng;
}
