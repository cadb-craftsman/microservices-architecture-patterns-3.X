package com.craftsman.funcservice.domain.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.craftsman.funcservice.domain.dto.FuncServiceDto;
import com.craftsman.funcservice.domain.model.FuncServiceBean;

import lombok.Data;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Data
@Component
public class FuncServiceMapper {

	@Autowired(required = true)
	private FuncServiceFactoryMapper mapper;

	public Mono<FuncServiceDto> toMonoFuncServiceDto(Mono<FuncServiceBean> entity) {
		return entity.map(mapper::toFuncServiceDto);
	}

	public Mono<FuncServiceBean> toMonoFuncServiceEntity(Mono<FuncServiceDto> dto) {
		return dto.map(mapper::toFuncServiceEntity);
	}

	public Flux<FuncServiceDto> toFluxFuncServiceDto(Flux<FuncServiceBean> entity) {
		return entity.map(mapper::toFuncServiceDto);
	}

	public Flux<FuncServiceBean> toFluxFuncServiceEntity(Flux<FuncServiceDto> dto) {
		return dto.map(mapper::toFuncServiceEntity);
	}
}
