package com.craftsman.reactservice.domain.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.craftsman.reactservice.domain.dto.ReactServiceDto;
import com.craftsman.reactservice.domain.model.ReactServiceBean;

import lombok.Data;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Data
@Component
public class ReactServiceMapper {

	@Autowired(required = true)
	private ReactServiceFactoryMapper mapper;

	public Mono<ReactServiceDto> toMonoReactServiceDto(Mono<ReactServiceBean> entity) {
		return entity.map(mapper::toReactServiceDto);
	}

	public Mono<ReactServiceBean> toMonoReactServiceEntity(Mono<ReactServiceDto> dto) {
		return dto.map(mapper::toReactServiceEntity);
	}

	public Flux<ReactServiceDto> toFluxReactServiceDto(Flux<ReactServiceBean> entity) {
		return entity.map(mapper::toReactServiceDto);
	}

	public Flux<ReactServiceBean> toFluxReactServiceEntity(Flux<ReactServiceDto> dto) {
		return dto.map(mapper::toReactServiceEntity);
	}
}
