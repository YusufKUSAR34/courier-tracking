package com.yusuf.kusar.couriertracking.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StoreRequest {
    private String name;
    private double lat;
    private double lng;
}
