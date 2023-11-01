package com.yusuf.kusar.couriertracking.controller;

import com.yusuf.kusar.couriertracking.model.CourierGeolocation;
import com.yusuf.kusar.couriertracking.request.CourierGeolocationRequest;
import com.yusuf.kusar.couriertracking.service.CourierGeolocationService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/courier-geolocation")
@RequiredArgsConstructor
public class CourierGeolocationController {
    private final  CourierGeolocationService courierGeolocationService;

    @GetMapping(value = "/report")
    public ResponseEntity<Object> reportCourierGeolocation(@RequestBody @Valid CourierGeolocationRequest request) {

            courierGeolocationService.reportCourierGeolocation(request);
            return new ResponseEntity<>("report courier geolocation successfully.", HttpStatus.OK);

    }
    @GetMapping(value = "/total-travel-distance/{courier-id}")
    public ResponseEntity<Object> getTotalTravelDistance(@PathVariable(value = "courier-id") @NotNull(message = "courierId cannot be null") Long courierId) {
        return new ResponseEntity<>(courierGeolocationService.getTotalTravelDistance(courierId), HttpStatus.OK);
    }
}
