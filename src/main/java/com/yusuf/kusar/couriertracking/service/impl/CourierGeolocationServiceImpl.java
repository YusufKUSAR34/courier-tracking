package com.yusuf.kusar.couriertracking.service.impl;

import com.yusuf.kusar.couriertracking.mapper.CourierGeolocationMapper;
import com.yusuf.kusar.couriertracking.model.CourierGeolocation;
import com.yusuf.kusar.couriertracking.repository.CourierGeolocationRepository;
import com.yusuf.kusar.couriertracking.request.CourierGeolocationRequest;
import com.yusuf.kusar.couriertracking.service.CourierGeolocationService;
import com.yusuf.kusar.couriertracking.service.TrackingCourierAtStoreService;
import com.yusuf.kusar.couriertracking.util.GeolocationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourierGeolocationServiceImpl implements CourierGeolocationService {
    private final CourierGeolocationRepository courierGeolocationRepository;
    private final TrackingCourierAtStoreService trackingCourierAtStoreService;
    private final CourierGeolocationMapper courierGeolocationMapper;

    @Override
    public void reportCourierGeolocation(CourierGeolocationRequest request)  {
        CourierGeolocation courierGeolocation = courierGeolocationMapper.from(request);
       courierGeolocationRepository.save(courierGeolocation);
       trackingCourierAtStoreService.traceCourier(request);
    }

    @Override
    public double getTotalTravelDistance(Long courierId) {
        Iterator<CourierGeolocation> courierGeolocationIterator = courierGeolocationRepository.findAll().stream()
                .filter(courierGeolocation -> courierGeolocation.getCourierId().equals(courierId))
                .iterator();
        double totalDistance = 0.0;
        CourierGeolocation startCourierGeolocation = courierGeolocationIterator.hasNext() ? courierGeolocationIterator.next() : null;
        while (startCourierGeolocation != null && courierGeolocationIterator.hasNext()) {
            CourierGeolocation endCourierGeolocation = courierGeolocationIterator.next();
            double distance = GeolocationUtil.getInstance().calculateDistance(startCourierGeolocation.getLat(), startCourierGeolocation.getLng(), endCourierGeolocation.getLat(), endCourierGeolocation.getLng());
            totalDistance += distance;
        }
        return totalDistance;
    }

    @Override
    public List<CourierGeolocation> getAllByCourierId(Long courierId) throws IOException {
     return   courierGeolocationRepository.findAll().stream()
                .filter(courierGeolocation -> courierGeolocation.getCourierId().equals(courierId))
                .collect(Collectors.toList());
    }
}
