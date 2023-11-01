package com.yusuf.kusar.couriertracking.mapper;

import com.yusuf.kusar.couriertracking.model.Courier;
import com.yusuf.kusar.couriertracking.model.CourierGeolocation;
import com.yusuf.kusar.couriertracking.request.CourierGeolocationRequest;
import com.yusuf.kusar.couriertracking.request.CourierRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface CourierGeolocationMapper {
    CourierGeolocation from(final CourierGeolocationRequest request);
}
