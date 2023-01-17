package com.craftsman.restservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.craftsman.restservice.domain.model.RestServiceBean;

public interface RestServiceRepository extends CrudRepository<RestServiceBean, Long> {
}
