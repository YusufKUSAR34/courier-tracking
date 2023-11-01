package com.yusuf.kusar.couriertracking.controller;

import com.yusuf.kusar.couriertracking.request.StoreRequest;
import com.yusuf.kusar.couriertracking.response.CreateStoreResponse;
import com.yusuf.kusar.couriertracking.service.StoreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/store")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;
    @PostMapping(value = "/create")
    public ResponseEntity<CreateStoreResponse> create(@RequestBody @Valid StoreRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(storeService.createStore(request));
    }

}
