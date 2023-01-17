package com.craftsman.restservice.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.craftsman.restservice.domain.dto.RestServiceDto;
import com.craftsman.restservice.domain.dto.RestServiceDtoList;
import com.craftsman.restservice.domain.exceptions.RestServiceException;
import com.craftsman.restservice.domain.mappers.RestServiceFactoryMapper;
import com.craftsman.restservice.domain.model.RestServiceBean;
import com.craftsman.restservice.repository.RestServiceRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RestServiceImpl implements IRestService {

	@Autowired
	private RestServiceRepository repository;

	@Autowired(required = true)
	private RestServiceFactoryMapper mapper;

	@Override
	public RestServiceDto create(RestServiceDto in) throws RestServiceException {
		return createDelegate(in);
	}

	@Override
	public RestServiceDtoList read() throws RestServiceException {
		return readDelegate();
	}

	@Override
	public RestServiceDto read(Long id) throws RestServiceException {
		return readDelegate(id);
	}

	@Override
	public RestServiceDto update(RestServiceDto in) throws RestServiceException {
		return updateDelegate(in);
	}

	@Override
	public RestServiceDto delete(RestServiceDto in) throws RestServiceException {
		return deleteDelegate(in);
	}

	private RestServiceDto createDelegate(RestServiceDto in) throws RestServiceException {
		try {
			repository.save(mapper.mapRestServiceDtoToRestServiceEntity(in));
		} catch (Exception e) {
			log.error("Exception in method create", e);
			throw new RestServiceException("Exception in method create", e);
		}
		return in;
	}

	private RestServiceDtoList readDelegate() throws RestServiceException {
		RestServiceDtoList restServiceList = new RestServiceDtoList();
		List<RestServiceDto> dtoList = null;

		try {
			List<RestServiceBean> list = repository.findAll();
			if (list != null) {
				dtoList = new ArrayList<>();
				for (RestServiceBean e : list) {
					dtoList.add(mapper.mapRestServiceEntityToRestServiceDto(e));
				}
				restServiceList.setDtoList(dtoList);
			}
		} catch (Exception e) {
			log.error("Exception in method read", e);
			throw new RestServiceException("Exception in method read", e);
		}

		return restServiceList;
	}

	private RestServiceDto readDelegate(Long id) throws RestServiceException {
		RestServiceDto dto;
		try {
			RestServiceBean bean = repository.findById(id);
			dto = mapper.mapRestServiceEntityToRestServiceDto(bean);
		} catch (Exception e) {
			log.error("Exception in method read", e);
			throw new RestServiceException("Exception in method read", e);
		}

		return dto;
	}

	private RestServiceDto updateDelegate(RestServiceDto in) throws RestServiceException {
		try {
			repository.update(mapper.mapRestServiceDtoToRestServiceEntity(in));
		} catch (Exception e) {
			log.error("Exception in method update", e);
			throw new RestServiceException("Exception in method update", e);
		}

		return in;
	}

	private RestServiceDto deleteDelegate(RestServiceDto in) throws RestServiceException {
		RestServiceBean b = mapper.mapRestServiceDtoToRestServiceEntity(in);
		try {
			repository.delete(b.getId());
		} catch (Exception e) {
			log.error("Exception in method delete", e);
			throw new RestServiceException("Exception in method delete", e);
		}
		return in;
	}
}
