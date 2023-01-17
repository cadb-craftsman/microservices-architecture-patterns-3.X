package com.craftsman.reactservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.craftsman.reactservice.domain.dto.ReactServiceDto;
import com.craftsman.reactservice.services.IReactService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ReactServiceApiController implements ReactServiceApi {

	@Autowired
	private IReactService service;

	@Override
	public ResponseEntity<Mono<ReactServiceDto>> putOperation(ReactServiceDto in) {
		return ResponseEntity.ok(service.update(in));
	}

	@Override
	public ResponseEntity<Mono<ReactServiceDto>> postOperation(ReactServiceDto in) {
		return ResponseEntity.ok(service.create(in));
	}

	@Override
	public ResponseEntity<Mono<ReactServiceDto>> deleteOperation(ReactServiceDto in) {
		return ResponseEntity.ok(service.delete(in));
	}

	@Override
	public ResponseEntity<Mono<ReactServiceDto>> getOperation(Long id) {
		return ResponseEntity.ok(service.read(id));
	}

	@Override
	public ResponseEntity<Flux<ReactServiceDto>> getOperation() {
		return ResponseEntity.ok(service.read());
	}

}
