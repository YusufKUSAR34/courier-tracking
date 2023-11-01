package com.yusuf.kusar.couriertracking.service.impl;

import com.yusuf.kusar.couriertracking.mapper.StoreMapper;
import com.yusuf.kusar.couriertracking.model.Store;
import com.yusuf.kusar.couriertracking.repository.StoreRepository;
import com.yusuf.kusar.couriertracking.request.StoreRequest;
import com.yusuf.kusar.couriertracking.response.CreateStoreResponse;
import com.yusuf.kusar.couriertracking.service.StoreService;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl  implements StoreService {
     private final StoreRepository storeRepository;
     private final StoreMapper storeMapper;

    public StoreServiceImpl(StoreRepository storeRepository, StoreMapper storeMapper) {
        this.storeRepository = storeRepository;
        this.storeMapper = storeMapper;
    }

     @Override
     public CreateStoreResponse createStore(StoreRequest request){
         Store store = storeMapper.from(request);
         storeRepository.save(store);
        return storeMapper.toCreateStoreResponse(store);     }
}
