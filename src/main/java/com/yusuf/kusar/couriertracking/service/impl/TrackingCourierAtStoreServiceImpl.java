package com.yusuf.kusar.couriertracking.service.impl;

import com.yusuf.kusar.couriertracking.constant.CourierTrackingConstant;
import com.yusuf.kusar.couriertracking.exception.TrackingCourierAtStoreNotFoundException;
import com.yusuf.kusar.couriertracking.mapper.CourierGeolocationMapper;
import com.yusuf.kusar.couriertracking.model.CourierGeolocation;
import com.yusuf.kusar.couriertracking.model.Store;
import com.yusuf.kusar.couriertracking.model.TrackingCourierAtStore;
import com.yusuf.kusar.couriertracking.repository.StoreRepository;
import com.yusuf.kusar.couriertracking.repository.TrackingCourierAtStoreRepository;
import com.yusuf.kusar.couriertracking.request.CourierGeolocationRequest;
import com.yusuf.kusar.couriertracking.service.TrackingCourierAtStoreService;
import com.yusuf.kusar.couriertracking.util.DateUtil;
import com.yusuf.kusar.couriertracking.util.GeolocationUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;

@Service
@RequiredArgsConstructor
@Slf4j
public class TrackingCourierAtStoreServiceImpl implements TrackingCourierAtStoreService {

    private final StoreRepository storeRepository;
    private final TrackingCourierAtStoreRepository trackingCourierAtStoreRepository;
    private final CourierGeolocationMapper courierGeolocationMapper;

    @Override
    public void traceCourier(CourierGeolocationRequest request)  {
        CourierGeolocation courierGeolocation = courierGeolocationMapper.from(request);
        storeRepository.findAll().stream()
                    .filter(store ->  isCourierAtStore(store, courierGeolocation))
                    .forEach(store -> {
                        TrackingCourierAtStore lastTackingCourierAtStoreByStoreName = trackingCourierAtStoreRepository.findAll().stream().filter(trackingCourierAtStore -> trackingCourierAtStore.getStoreName().equals(store.getName())).reduce((first, second) -> second)
                                .orElseThrow(() -> new TrackingCourierAtStoreNotFoundException("Tracking Courier not found At Store"));
                        if (lastTackingCourierAtStoreByStoreName == null || !isIgnoredByTracking(lastTackingCourierAtStoreByStoreName.getTrackingDate())) {
                            TrackingCourierAtStore trackingCourierAtStore = TrackingCourierAtStore.builder()
                                    .courierId(courierGeolocation.getCourierId())
                                    .storeName(store.getName())
                                    .trackingDate(new Date()).build();
                            trackingCourierAtStoreRepository.save(trackingCourierAtStore);
                        }
                    });
    }

    private boolean isCourierAtStore(Store store, CourierGeolocation courierGeolocation) {
        return GeolocationUtil.getInstance().calculateDistance(store.getLat(), store.getLng(), courierGeolocation.getLat(), courierGeolocation.getLng()) <= CourierTrackingConstant.TRACKING_KILOMETER_COURIER_AT_STORE;
    }

    private boolean isIgnoredByTracking(Date lastLogDate) {
        lastLogDate = DateUtil.getInstance().addToDateByMinutes(lastLogDate, CourierTrackingConstant.IGNORED_COURIER_TRACKING_MINUTE);
        return DateUtil.getInstance().isDateExpired(lastLogDate, new Date());
    }
}
