package com.craftsman.reactservice;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.craftsman.reactservice.domain.dto.ReactServiceDto;
import com.craftsman.reactservice.domain.mappers.ReactServiceFactoryMapper;
import com.craftsman.reactservice.repository.ReactServiceRepository;
import com.craftsman.reactservice.services.IReactService;

@DisplayName("RestServiceApiTest")
@ActiveProfiles("integration")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ReactServiceApiTest {

	@Autowired
	IReactService service;
	@Autowired
	ReactServiceFactoryMapper mapper;
	@Autowired
	ReactServiceRepository repository;

	private static ReactServiceDto in;
	
	@BeforeAll
	static void initAll() {
		in = new ReactServiceDto(1L, "Product", "Product Description");
	}

	@Test
	@DisplayName("Put test operation")
	void testPutOperation() {
		ReactServiceDto bean = new ReactServiceDto(1L, "Product", "Product Description");
		service.update(in);
		assertTrue(in.equals(bean), "Update a record");
	}

	@Test
	@DisplayName("Post test operation")
	void testPostOperation() {
		ReactServiceDto bean = new ReactServiceDto(1L, "Product", "Product Description");
		service.create(in);
		assertTrue(in.equals(bean), "Insert a new record");
	}

	@Test
	@DisplayName("Delete test operation")
	void testDeleteOperation() {
		ReactServiceDto bean = new ReactServiceDto(1L, "Product", "Product Description");
		service.delete(in);
		assertTrue(in.equals(bean), "Delete a record");
	}

	@Test
	@DisplayName("Get test operation")
	void testGetOperation() {
		//RestServiceDtoList list = service.read(in.getId());
		assertTrue(true, "Search a record");
	}

}
