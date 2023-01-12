package com.craftsman.funcservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.craftsman.funcservice.domain.dto.FuncServiceDto;
import com.craftsman.funcservice.domain.exceptions.FuncServiceException;
import com.craftsman.funcservice.domain.mappers.FuncServiceMapper;
import com.craftsman.funcservice.repository.FuncServiceRepository;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class FuncServiceImpl implements IFuncService {
	
	@Autowired(required = true)
	private FuncServiceRepository repository;

	@Autowired(required = true)
	private FuncServiceMapper mapper;

	@Override
	public Mono<FuncServiceDto> create(FuncServiceDto in) throws FuncServiceException {
		return createDelegate(in);
	}

	@Override
	public Flux<FuncServiceDto> read() throws FuncServiceException {
		return readDelegate();
	}

	@Override
	public Mono<FuncServiceDto> read(Long id) throws FuncServiceException {
		return readDelegate(id);
	}

	@Override
	public Mono<FuncServiceDto> update(FuncServiceDto in) throws FuncServiceException {
		return updateDelegate(in);
	}

	@Override
	public Mono<FuncServiceDto> delete(FuncServiceDto in) throws FuncServiceException {
		return deleteDelegate(in);
	}

	private Mono<FuncServiceDto> createDelegate(FuncServiceDto in) throws FuncServiceException {
		try {
			return mapper.toMonoFuncServiceDto(repository.save(mapper.getMapper().toFuncServiceEntity(in))).onTerminateDetach();
		} catch (Exception e) {
			log.error("Exception in method create");
			throw new FuncServiceException("Exception in method create", e);
		}
	}

	private Flux<FuncServiceDto> readDelegate() throws FuncServiceException {
		Flux<FuncServiceDto> dtos = Flux.empty();
		
		try {
			dtos = mapper.toFluxFuncServiceDto(repository.findAll());
		} catch (Exception e) {
			log.error("Exception in method readAll", e);
			throw new FuncServiceException("Exception in method readAll", e);
		}
		return dtos;
	}

	private Mono<FuncServiceDto> readDelegate(Long id) throws FuncServiceException {
		Mono<FuncServiceDto> dto = Mono.empty();
		
		try {
			dto = mapper.toMonoFuncServiceDto(repository.findById(id));
		} catch (Exception e) {
			log.error("Exception in method read", e);
			throw new FuncServiceException("Exception in method read", e);
		}
		return dto;
	}

	private Mono<FuncServiceDto> updateDelegate(FuncServiceDto in) throws FuncServiceException {
		try {
			return mapper.toMonoFuncServiceDto(repository.save(mapper.getMapper().toFuncServiceEntity(in))).onTerminateDetach();
		} catch (Exception e) {
			log.error("Exception in method update");
			throw new FuncServiceException("Exception in method update", e);
		}
	}

	private Mono<FuncServiceDto> deleteDelegate(FuncServiceDto in) throws FuncServiceException {
		try {
			repository.delete(mapper.getMapper().toFuncServiceEntity(in)).onTerminateDetach();
		} catch (Exception e) {
			log.error("Exception in method delete");
			throw new FuncServiceException("Exception in method delete", e);
		}

		return Mono.just(in);
	}

}
