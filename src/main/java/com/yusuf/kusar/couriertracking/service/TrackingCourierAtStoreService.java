package com.yusuf.kusar.couriertracking.service;

import com.yusuf.kusar.couriertracking.model.CourierGeolocation;
import com.yusuf.kusar.couriertracking.request.CourierGeolocationRequest;

public interface TrackingCourierAtStoreService {
    void traceCourier(CourierGeolocationRequest request) ;

}
