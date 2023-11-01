package com.yusuf.kusar.couriertracking.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TrackingCourierAtStoreRequest {
    private Long id;
    @NotNull(message = "courierId cannot be null")
    private Long courierId;
    @NotEmpty(message = "storeName cannot be empty")
    private String storeName;
    @NotNull(message = "trackingDate cannot be null")
    private Date trackingDate;
}
