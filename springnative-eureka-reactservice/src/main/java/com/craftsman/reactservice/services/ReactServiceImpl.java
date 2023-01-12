package com.craftsman.reactservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.craftsman.reactservice.domain.dto.ReactServiceDto;
import com.craftsman.reactservice.domain.exceptions.ReactServiceException;
import com.craftsman.reactservice.domain.mappers.ReactServiceMapper;
import com.craftsman.reactservice.repository.ReactServiceRepository;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class ReactServiceImpl implements IReactService {
	
	@Autowired(required = true)
	private ReactServiceRepository repository;

	@Autowired(required = true)
	private ReactServiceMapper mapper;

	@Override
	public Mono<ReactServiceDto> create(ReactServiceDto in) throws ReactServiceException {
		return createDelegate(in);
	}

	@Override
	public Flux<ReactServiceDto> read() throws ReactServiceException {
		return readDelegate();
	}

	@Override
	public Mono<ReactServiceDto> read(Long id) throws ReactServiceException {
		return readDelegate(id);
	}

	@Override
	public Mono<ReactServiceDto> update(ReactServiceDto in) throws ReactServiceException {
		return updateDelegate(in);
	}

	@Override
	public Mono<ReactServiceDto> delete(ReactServiceDto in) throws ReactServiceException {
		return deleteDelegate(in);
	}

	private Mono<ReactServiceDto> createDelegate(ReactServiceDto in) throws ReactServiceException {
		try {
			return mapper.toMonoReactServiceDto(repository.save(mapper.getMapper().toReactServiceEntity(in))).onTerminateDetach();
		} catch (Exception e) {
			log.error("Exception in method create");
			throw new ReactServiceException("Exception in method create", e);
		}
	}

	private Flux<ReactServiceDto> readDelegate() throws ReactServiceException {
		Flux<ReactServiceDto> dtos = Flux.empty();
		
		try {
			dtos = mapper.toFluxReactServiceDto(repository.findAll());
		} catch (Exception e) {
			log.error("Exception in method readAll", e);
			throw new ReactServiceException("Exception in method readAll", e);
		}
		return dtos;
	}

	private Mono<ReactServiceDto> readDelegate(Long id) throws ReactServiceException {
		Mono<ReactServiceDto> dto = Mono.empty();
		
		try {
			dto = mapper.toMonoReactServiceDto(repository.findById(id));
		} catch (Exception e) {
			log.error("Exception in method read", e);
			throw new ReactServiceException("Exception in method read", e);
		}
		return dto;
	}

	private Mono<ReactServiceDto> updateDelegate(ReactServiceDto in) throws ReactServiceException {
		try {
			return mapper.toMonoReactServiceDto(repository.save(mapper.getMapper().toReactServiceEntity(in))).onTerminateDetach();
		} catch (Exception e) {
			log.error("Exception in method update");
			throw new ReactServiceException("Exception in method update", e);
		}
	}

	private Mono<ReactServiceDto> deleteDelegate(ReactServiceDto in) throws ReactServiceException {
		try {
			repository.delete(mapper.getMapper().toReactServiceEntity(in));
		} catch (Exception e) {
			log.error("Exception in method delete");
			throw new ReactServiceException("Exception in method delete", e);
		}

		return Mono.just(in);
	}

}
