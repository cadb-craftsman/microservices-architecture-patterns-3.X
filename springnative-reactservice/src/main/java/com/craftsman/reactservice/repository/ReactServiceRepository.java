package com.craftsman.reactservice.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.craftsman.reactservice.domain.model.ReactServiceEntity;

@Repository
public interface ReactServiceRepository extends ReactiveCrudRepository<ReactServiceEntity, Long> {
}
