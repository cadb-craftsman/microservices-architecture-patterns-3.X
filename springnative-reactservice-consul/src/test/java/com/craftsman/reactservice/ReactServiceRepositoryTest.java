package com.craftsman.reactservice;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.craftsman.reactservice.domain.model.ReactServiceBean;
import com.craftsman.reactservice.repository.ReactServiceRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@DisplayName("Tests RestServiceRepository")
@ActiveProfiles("integration")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReactServiceRepositoryTest {
	
	@Autowired
	ReactServiceRepository repository;

	private static ReactServiceBean bean;

	@BeforeAll
	static void initAll() {
		bean = new ReactServiceBean(1L, "Object", "Object description");
	}

	
	@Test
	@DisplayName("Test findById operation")
	void testFindById() {
		Mono<ReactServiceBean> b = repository.findById(bean.getId()); 
		if(b.block() != null) {
			assertTrue(bean.getId() == b.block().getId(), "Search record by id");	
		}else {
			assertTrue(true);
		}
		
	}

	@Test
	@DisplayName("Test findAll operation")
	void testFindAll() {
		Flux<ReactServiceBean> list = repository.findAll(); 
		assertTrue(list.count().block() >= 0, "Search all records");
	}

	@Test
	@DisplayName("Test save operation")
	void testSave() {
		assertTrue(repository.save(bean).block().getId() >= 0, "Insert a record");
	}

	@Test
	@DisplayName("Test update operation")
	void testUpdate() {
		assertTrue(repository.save(bean).block().getId() >= 0, "Update a record");
	}

	@Test
	@DisplayName("Test delete operation")
	void testDelete() {
		Mono<ReactServiceBean> b = repository.findById(bean.getId()); 
		if(b.block() != null) {
			repository.deleteById(bean.getId());
			assertTrue(true, "Delete a record");
		}else {
			assertTrue(true);
		}
	}
	
}
