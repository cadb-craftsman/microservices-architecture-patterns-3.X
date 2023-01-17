package com.craftsman.restservice.services;

import com.craftsman.restservice.domain.dto.RestServiceDto;
import com.craftsman.restservice.domain.dto.RestServiceDtoList;
import com.craftsman.restservice.domain.exceptions.RestServiceException;

public interface IRestService {

	RestServiceDto create(RestServiceDto in) throws RestServiceException;

	RestServiceDtoList read() throws RestServiceException;
	
	RestServiceDto read(Long id) throws RestServiceException;

	RestServiceDto update(RestServiceDto in) throws RestServiceException;

	RestServiceDto delete(RestServiceDto in) throws RestServiceException;

}
