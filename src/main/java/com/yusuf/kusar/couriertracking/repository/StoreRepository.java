package com.yusuf.kusar.couriertracking.repository;

import com.yusuf.kusar.couriertracking.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface StoreRepository extends JpaRepository<Store,Long> {
}
