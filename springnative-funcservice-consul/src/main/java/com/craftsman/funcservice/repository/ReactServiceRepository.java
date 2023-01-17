package com.craftsman.funcservice.repository;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.craftsman.funcservice.domain.model.ReactServiceBean;

@Repository
public interface ReactServiceRepository extends ReactiveCrudRepository<ReactServiceBean, Long> {
}
