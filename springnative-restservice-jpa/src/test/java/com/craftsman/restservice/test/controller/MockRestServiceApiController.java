package com.craftsman.restservice.test.controller;

import org.springframework.http.ResponseEntity;

import com.craftsman.restservice.controller.RestServiceApi;
import com.craftsman.restservice.domain.dto.RestServiceDto;
import com.craftsman.restservice.domain.dto.RestServiceDtoList;
import com.craftsman.restservice.domain.exceptions.RestServiceResourceNotFoundException;

public class MockRestServiceApiController implements RestServiceApi {

	@Override
	public ResponseEntity<RestServiceDto> putOperation(RestServiceDto in) throws RestServiceResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<RestServiceDto> postOperation(RestServiceDto in) throws RestServiceResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<RestServiceDto> deleteOperation(RestServiceDto in)
			throws RestServiceResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<RestServiceDto> getOperation(Long id) throws RestServiceResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<RestServiceDtoList> getOperation() throws RestServiceResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
