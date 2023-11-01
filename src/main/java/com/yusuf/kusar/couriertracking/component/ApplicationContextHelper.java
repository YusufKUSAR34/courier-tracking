package com.yusuf.kusar.couriertracking.component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yusuf.kusar.couriertracking.aop.NoLogging;
import com.yusuf.kusar.couriertracking.model.Courier;
import com.yusuf.kusar.couriertracking.model.CourierGeolocation;
import com.yusuf.kusar.couriertracking.model.Store;
import com.yusuf.kusar.couriertracking.model.TrackingCourierAtStore;
import com.yusuf.kusar.couriertracking.repository.CourierGeolocationRepository;
import com.yusuf.kusar.couriertracking.repository.CourierRepository;
import com.yusuf.kusar.couriertracking.repository.StoreRepository;
import com.yusuf.kusar.couriertracking.repository.TrackingCourierAtStoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
@NoLogging
public class ApplicationContextHelper  implements CommandLineRunner {
    private final StoreRepository storeRepository;
    private final CourierRepository courierRepository;
    private final CourierGeolocationRepository courierGeolocationRepository;
    private final TrackingCourierAtStoreRepository trackingCourierAtStoreRepository;
    
    @Override
    public void run(String... args) throws Exception {
        insertDatabaseStaticValuesFromJsonFiles();
    }

    private void insertDatabaseStaticValuesFromJsonFiles() {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Store>> typeReferenceStores = new TypeReference<>(){};
        TypeReference<List<Courier>> typeReferenceCouriers = new TypeReference<>(){};
        TypeReference<List<CourierGeolocation>> typeReferenceCourierGeolocations = new TypeReference<>(){};
        TypeReference<List<TrackingCourierAtStore>> typeReferenceTrackingCourierAtStores = new TypeReference<>(){};


        InputStream inputStreamStores = TypeReference.class.getResourceAsStream("/json/stores.json");
        InputStream inputStreamCouriers = TypeReference.class.getResourceAsStream("/json/couriers.json");
        InputStream inputStreamCourierGeolocations = TypeReference.class.getResourceAsStream("/json/courier-geolocations.json");
        InputStream inputStreamTrackingCourierAtStores = TypeReference.class.getResourceAsStream("/json/tracking-courier-in-store.json");

        try {
            List<Store> stores = mapper.readValue(inputStreamStores,typeReferenceStores);
            List<Courier> couriers = mapper.readValue(inputStreamCouriers,typeReferenceCouriers);
            List<CourierGeolocation> courierGeolocations = mapper.readValue(inputStreamCourierGeolocations,typeReferenceCourierGeolocations);
            List<TrackingCourierAtStore> trackingCourierAtStores = mapper.readValue(inputStreamTrackingCourierAtStores,typeReferenceTrackingCourierAtStores);

            storeRepository.saveAll(stores);
            courierRepository.saveAll(couriers);
            courierGeolocationRepository.saveAll(courierGeolocations);
            trackingCourierAtStoreRepository.saveAll(trackingCourierAtStores);

            log.info("Static data has been successfully added to the database.");
        } catch (IOException e){
            log.error("Static data could not be successfully added to the database.");
        }
    }
}
