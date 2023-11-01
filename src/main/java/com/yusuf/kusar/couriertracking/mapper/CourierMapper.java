package com.yusuf.kusar.couriertracking.mapper;

import com.yusuf.kusar.couriertracking.model.Courier;
import com.yusuf.kusar.couriertracking.model.Store;
import com.yusuf.kusar.couriertracking.request.CourierRequest;
import com.yusuf.kusar.couriertracking.request.StoreRequest;
import com.yusuf.kusar.couriertracking.response.CreateStoreResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface CourierMapper {
    Courier from(final CourierRequest request);
}
