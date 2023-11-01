package com.yusuf.kusar.couriertracking.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateStoreResponse {
    private String name;
    private double lat;
    private double lng;
}
