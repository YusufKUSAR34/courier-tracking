package com.yusuf.kusar.couriertracking.service;

import com.yusuf.kusar.couriertracking.model.CourierGeolocation;
import com.yusuf.kusar.couriertracking.request.CourierGeolocationRequest;

import java.io.IOException;
import java.util.List;

public interface CourierGeolocationService {

    void reportCourierGeolocation(CourierGeolocationRequest request);

    double getTotalTravelDistance(Long courierId);

    List<CourierGeolocation> getAllByCourierId(Long courierId) throws IOException;
}
