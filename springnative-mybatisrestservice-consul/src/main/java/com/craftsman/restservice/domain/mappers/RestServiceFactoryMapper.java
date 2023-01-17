package com.craftsman.restservice.domain.mappers;

import org.mapstruct.Mapper;

import com.craftsman.restservice.domain.dto.RestServiceDto;
import com.craftsman.restservice.domain.model.RestServiceBean;

@Mapper
public interface RestServiceFactoryMapper {
	
	RestServiceBean mapRestServiceDtoToRestServiceEntity(RestServiceDto in);
	
	RestServiceDto mapRestServiceEntityToRestServiceDto(RestServiceBean in);

}
