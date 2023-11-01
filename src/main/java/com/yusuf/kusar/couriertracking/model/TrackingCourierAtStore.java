package com.yusuf.kusar.couriertracking.model;


import com.yusuf.kusar.couriertracking.aop.annotation.ID;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tracking_courier_at_store")
public class TrackingCourierAtStore {
    @Id
    private Long id;
    private Long courierId;
    private String storeName;
    private Date trackingDate;
}
