package com.craftsman.funcservice;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.craftsman.funcservice.domain.model.FuncServiceBean;
import com.craftsman.funcservice.repository.FuncServiceRepository;

@DisplayName("Tests RestServiceRepository")
@ActiveProfiles("integration")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FuncServiceRepositoryTest {
	
	@Autowired
	FuncServiceRepository repository;

	private static FuncServiceBean bean;

	@BeforeAll
	static void initAll() {
		bean = new FuncServiceBean(1L, "Object", "Object description");
	}

}
