package com.craftsman.funcservice.domain.mappers;

import org.mapstruct.Mapper;

import com.craftsman.funcservice.domain.dto.ReactServiceDto;
import com.craftsman.funcservice.domain.model.ReactServiceBean;

@Mapper
public interface ReactServiceFactoryMapper {
	
	ReactServiceBean toReactServiceEntity(ReactServiceDto d);
	
	ReactServiceDto toReactServiceDto(ReactServiceBean e);

}
