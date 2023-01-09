package com.craftsman.reactservice.repository;

import com.craftsman.reactservice.domain.model.ReactServiceEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Component;

@Component
public interface ReactServiceRepository extends R2dbcRepository<ReactServiceEntity, Long> {
}
