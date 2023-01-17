package com.craftsman.reactservice.domain.mappers;

import org.mapstruct.Mapper;

import com.craftsman.reactservice.domain.dto.ReactServiceDto;
import com.craftsman.reactservice.domain.model.ReactServiceBean;

@Mapper
public interface ReactServiceFactoryMapper {
	
	ReactServiceBean toReactServiceEntity(ReactServiceDto d);
	
	ReactServiceDto toReactServiceDto(ReactServiceBean e);

}
