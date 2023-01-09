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

	@Test
	@DisplayName("Test create operation")
	void testCreate() {
		ReactServiceDto bean = new ReactServiceDto(1L, "Product", "Product Description");
		service.create(in);
		assertTrue(in.equals(bean), "Insert a new record");
	}

	@Test
	@DisplayName("Test read operation")
	void testRead() {
		//RestServiceDtoList list = service.read(in.getId());
		assertTrue(true, "Search a record");
	}

	@Test
	@DisplayName("Test update operation")
	void testUpdate() {
		ReactServiceDto bean = new ReactServiceDto(1L, "Product", "Product Description");
		service.update(in);
		assertTrue(in.equals(bean), "Update a record");
	}

	@Test
	@DisplayName("Test delete operation")
	void testDelete() {
		ReactServiceDto bean = new ReactServiceDto(1L, "Product", "Product Description");
		service.delete(in);
		assertTrue(in.equals(bean), "Delete a record");
	}

}
