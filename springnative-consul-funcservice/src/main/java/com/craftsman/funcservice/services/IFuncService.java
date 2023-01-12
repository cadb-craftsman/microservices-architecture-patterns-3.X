package com.craftsman.funcservice.services;

import com.craftsman.funcservice.domain.dto.FuncServiceDto;
import com.craftsman.funcservice.domain.exceptions.FuncServiceException;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IFuncService {

	public Mono<FuncServiceDto> create(FuncServiceDto in) throws FuncServiceException;

	public Flux<FuncServiceDto> read() throws FuncServiceException;
	
	public Mono<FuncServiceDto> read(Long id) throws FuncServiceException;

	public Mono<FuncServiceDto> update(FuncServiceDto in) throws FuncServiceException;

	public Mono<FuncServiceDto> delete(FuncServiceDto in) throws FuncServiceException;


}
