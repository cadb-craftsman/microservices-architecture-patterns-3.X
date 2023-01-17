package com.craftsman.reactservice.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.craftsman.reactservice.domain.model.ReactServiceBean;

@Repository
public interface ReactServiceRepository extends ReactiveCrudRepository<ReactServiceBean, Long> {
}
