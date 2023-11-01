package com.yusuf.kusar.couriertracking.service;

import com.yusuf.kusar.couriertracking.request.StoreRequest;
import com.yusuf.kusar.couriertracking.response.CreateStoreResponse;

public interface StoreService {
    CreateStoreResponse createStore(StoreRequest request);
}
