package com.craftsman.funcservice.domain.mappers;

import org.mapstruct.Mapper;

import com.craftsman.funcservice.domain.dto.FuncServiceDto;
import com.craftsman.funcservice.domain.model.FuncServiceBean;

@Mapper
public interface FuncServiceFactoryMapper {
	
	FuncServiceBean toFuncServiceEntity(FuncServiceDto d);
	
	FuncServiceDto toFuncServiceDto(FuncServiceBean e);

}
