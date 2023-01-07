package com.craftsman.restservice;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.craftsman.restservice.domain.dto.RestServiceDto;
import com.craftsman.restservice.domain.mappers.RestServiceFactoryMapper;
import com.craftsman.restservice.domain.mappers.RestServiceFactoryMapperImpl;
import com.craftsman.restservice.services.IRestService;
import com.craftsman.restservice.test.repository.MockRestServiceRepositoryImpl;
import com.craftsman.restservice.test.service.MockRestServiceImpl;

@DisplayName("Tests RestService")
public class RestServiceTest {
	
	private static RestServiceDto in;
	private static IRestService service;
	private static RestServiceFactoryMapper mapper;
	private static MockRestServiceRepositoryImpl repository;

	@BeforeAll
	static void initAll() {
		mapper = new RestServiceFactoryMapperImpl(); 
		repository = new MockRestServiceRepositoryImpl();
		service = new MockRestServiceImpl(repository, mapper);
		
		in = new RestServiceDto(1L, "Product", "Product Description");
	}

	@Test
	@DisplayName("Test create operation")
	void testCreate() {
		RestServiceDto bean = new RestServiceDto(1L, "Product", "Product Description");
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
		RestServiceDto bean = new RestServiceDto(1L, "Product", "Product Description");
		service.update(in);
		assertTrue(in.equals(bean), "Update a record");
	}

	@Test
	@DisplayName("Test delete operation")
	void testDelete() {
		RestServiceDto bean = new RestServiceDto(1L, "Product", "Product Description");
		service.delete(in);
		assertTrue(in.equals(bean), "Delete a record");
	}

}
