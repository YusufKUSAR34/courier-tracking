package com.yusuf.kusar.couriertracking.mapper;

import com.yusuf.kusar.couriertracking.model.Store;
import com.yusuf.kusar.couriertracking.model.TrackingCourierAtStore;
import com.yusuf.kusar.couriertracking.request.StoreRequest;
import com.yusuf.kusar.couriertracking.request.TrackingCourierAtStoreRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface TrackingCourierAtStoreMapper {
    TrackingCourierAtStore from(final TrackingCourierAtStoreRequest request);
}
