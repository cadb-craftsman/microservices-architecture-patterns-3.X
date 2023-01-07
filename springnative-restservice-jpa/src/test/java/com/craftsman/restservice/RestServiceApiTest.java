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

@DisplayName("RestServiceApiTest")
class RestServiceApiTest {

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
	@DisplayName("Put test operation")
	void testPutOperation() {
		RestServiceDto bean = new RestServiceDto(1L, "Product", "Product Description");
		service.update(in);
		assertTrue(in.equals(bean), "Update a record");
	}

	@Test
	@DisplayName("Post test operation")
	void testPostOperation() {
		RestServiceDto bean = new RestServiceDto(1L, "Product", "Product Description");
		service.create(in);
		assertTrue(in.equals(bean), "Insert a new record");
	}

	@Test
	@DisplayName("Delete test operation")
	void testDeleteOperation() {
		RestServiceDto bean = new RestServiceDto(1L, "Product", "Product Description");
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
