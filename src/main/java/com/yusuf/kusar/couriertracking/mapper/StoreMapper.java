package com.yusuf.kusar.couriertracking.mapper;

import com.yusuf.kusar.couriertracking.model.Store;
import com.yusuf.kusar.couriertracking.request.StoreRequest;
import com.yusuf.kusar.couriertracking.response.CreateStoreResponse;
import jakarta.persistence.Column;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface StoreMapper {
     Store from(final StoreRequest request);
     CreateStoreResponse toCreateStoreResponse(Store store);
}
