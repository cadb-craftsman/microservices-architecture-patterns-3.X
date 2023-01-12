package com.craftsman.funcservice;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.craftsman.funcservice.domain.dto.FuncServiceDto;
import com.craftsman.funcservice.domain.mappers.FuncServiceFactoryMapper;
import com.craftsman.funcservice.repository.FuncServiceRepository;
import com.craftsman.funcservice.services.IFuncService;

@DisplayName("RestServiceApiTest")
@ActiveProfiles("integration")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FuncServiceApiTest {

	@Autowired
	IFuncService service;
	@Autowired
	FuncServiceFactoryMapper mapper;
	@Autowired
	FuncServiceRepository repository;

	private static FuncServiceDto in;
	
	@BeforeAll
	static void initAll() {
		in = new FuncServiceDto(1L, "Product", "Product Description");
	}

}
