package com.yusuf.kusar.couriertracking.repository;

import com.yusuf.kusar.couriertracking.model.Courier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CourierRepository  extends JpaRepository<Courier,Long> {
}
