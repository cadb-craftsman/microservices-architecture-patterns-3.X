package com.craftsman.funcservice;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.craftsman.funcservice.domain.dto.ReactServiceDto;
import com.craftsman.funcservice.domain.mappers.ReactServiceFactoryMapper;
import com.craftsman.funcservice.repository.ReactServiceRepository;
import com.craftsman.funcservice.services.IReactService;

@DisplayName("Tests RestService")
@ActiveProfiles("integration")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReactServiceTest {

	@Autowired
	IReactService service;
	@Autowired
	ReactServiceRepository repository;
	@Autowired
	ReactServiceFactoryMapper mapper;

	private static ReactServiceDto in;
	
	@BeforeAll
	static void initAll() {
		in = new ReactServiceDto(1L, "Product", "Product Description");
	}

}
