package com.craftsman.restservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.craftsman.restservice.domain.model.RestServiceEntity;

public interface RestServiceRepository extends CrudRepository<RestServiceEntity, Long> {
}
