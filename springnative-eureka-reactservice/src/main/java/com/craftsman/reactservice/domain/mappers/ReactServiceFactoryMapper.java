package com.craftsman.reactservice.domain.mappers;

import org.mapstruct.Mapper;

import com.craftsman.reactservice.domain.dto.ReactServiceDto;
import com.craftsman.reactservice.domain.model.ReactServiceEntity;

@Mapper
public interface ReactServiceFactoryMapper {
	
	ReactServiceEntity toReactServiceEntity(ReactServiceDto d);
	
	ReactServiceDto toReactServiceDto(ReactServiceEntity e);

}
