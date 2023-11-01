package com.yusuf.kusar.couriertracking.repository;

import com.yusuf.kusar.couriertracking.model.TrackingCourierAtStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TrackingCourierAtStoreRepository extends JpaRepository<TrackingCourierAtStore,Long> {
}
