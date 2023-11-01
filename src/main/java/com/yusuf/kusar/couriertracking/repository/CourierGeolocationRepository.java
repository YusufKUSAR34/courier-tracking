package com.yusuf.kusar.couriertracking.repository;

import com.yusuf.kusar.couriertracking.model.CourierGeolocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CourierGeolocationRepository extends JpaRepository<CourierGeolocation,Long> {
}
