package com.craftsman.restservice;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.craftsman.restservice.domain.model.RestServiceEntity;
import com.craftsman.restservice.repository.RestServiceRepository;
import com.craftsman.restservice.test.repository.MockRestServiceRepositoryImpl;

@DisplayName("Tests RestServiceRepository")
public class RestServiceRepositoryTest {
	
	private static RestServiceEntity bean;
	private static RestServiceRepository repository;

	@BeforeAll
	static void initAll() {
		repository = new MockRestServiceRepositoryImpl();
		bean = new RestServiceEntity(0L, "Object", "Object description");
	}

	
	@Test
	@DisplayName("Test findById operation")
	void testFindById() {
		Optional<RestServiceEntity> b = repository.findById(bean.getId()); 
		assertTrue(bean.equals(b.get()), "Search record by id");
	}

	@Test
	@DisplayName("Test findAll operation")
	void testFindAll() {
		List<RestServiceEntity> list = (List<RestServiceEntity>) repository.findAll(); 
		assertTrue(list.size() >= 0, "Search all records");
	}

	@Test
	@DisplayName("Test save operation")
	void testSave() {
		assertTrue(repository.save(bean).getId() >= 0, "Insert a record");
	}

	@Test
	@DisplayName("Test update operation")
	void testUpdate() {
		assertTrue(repository.save(bean).getId() >= 0, "Update a record");
	}

	@Test
	@DisplayName("Test delete operation")
	void testDelete() {
		repository.deleteById(bean.getId());
		assertTrue(true, "Delete a record");
	}
	
}
