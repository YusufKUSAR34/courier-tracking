package com.yusuf.kusar.couriertracking;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yusuf.kusar.couriertracking.model.Store;
import com.yusuf.kusar.couriertracking.repository.CourierRepository;
import com.yusuf.kusar.couriertracking.repository.StoreRepository;
import com.yusuf.kusar.couriertracking.service.StoreService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class CourierTrackingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourierTrackingApplication.class, args);
	}
}
