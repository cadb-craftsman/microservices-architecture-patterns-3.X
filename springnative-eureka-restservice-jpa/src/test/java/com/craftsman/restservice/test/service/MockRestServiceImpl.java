package com.craftsman.restservice.test.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import com.craftsman.restservice.domain.dto.RestServiceDto;
import com.craftsman.restservice.domain.dto.RestServiceDtoList;
import com.craftsman.restservice.domain.exceptions.RestServiceException;
import com.craftsman.restservice.domain.mappers.RestServiceFactoryMapper;
import com.craftsman.restservice.domain.model.RestServiceEntity;
import com.craftsman.restservice.services.IRestService;
import com.craftsman.restservice.test.repository.MockRestServiceRepositoryImpl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MockRestServiceImpl implements IRestService {

	private MockRestServiceRepositoryImpl repository;
	private RestServiceFactoryMapper mapper;

	@Override
	public RestServiceDto create(RestServiceDto in) {
		repository.save(mapper.mapRestServiceDtoToRestServiceEntity(in));
		return in;
	}

	@Override
	public RestServiceDto read(Long id) {
		RestServiceDto dto = null;
		if (id != null) {
			Optional<RestServiceEntity> e = repository.findById(id);
			if (e != null) {
				dto = mapper.mapRestServiceEntityToRestServiceDto(e.get());
			}
		}
		return dto;
	}

	@Override
	public RestServiceDto update(RestServiceDto in) {
		repository.save(mapper.mapRestServiceDtoToRestServiceEntity(in));
		return in;
	}

	@Override
	public RestServiceDto delete(RestServiceDto in) {
		repository.delete(mapper.mapRestServiceDtoToRestServiceEntity(in));
		return in;
	}

	@Override
	public RestServiceDtoList read() throws RestServiceException {
		RestServiceDtoList restServiceList = new RestServiceDtoList();
		Iterable<RestServiceEntity> itEntities = repository.findAll();
		if (itEntities != null) {
			List<RestServiceDto> list = new ArrayList<>();
			for (Iterator<RestServiceEntity> iterator = itEntities.iterator(); iterator.hasNext();) {
				RestServiceEntity e = (RestServiceEntity) iterator.next();
				list.add(mapper.mapRestServiceEntityToRestServiceDto(e));
			}
			restServiceList.setDtoList(list);
		}
		return restServiceList;
	}

}
