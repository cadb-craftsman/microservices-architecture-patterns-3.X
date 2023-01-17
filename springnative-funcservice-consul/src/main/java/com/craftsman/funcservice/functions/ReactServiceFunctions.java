package com.craftsman.funcservice.functions;

import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.craftsman.funcservice.domain.dto.ReactServiceDto;
import com.craftsman.funcservice.domain.mappers.ReactServiceFactoryMapperImpl;
import com.craftsman.funcservice.services.IReactService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Configuration
public class ReactServiceFunctions {

	@Bean
	public ReactServiceFactoryMapperImpl getFactoryMapper() {
		return new ReactServiceFactoryMapperImpl();
	}

	
	@Bean
	Supplier<Flux<ReactServiceDto>> getAll(IReactService service) {
		return () -> {
			log.info("Getting all records");
			return service.read();
		};
	}
	
	@Bean
	Function<Mono<String>, Mono<ReactServiceDto>> getById(IReactService service) {
		return mono -> mono.flatMap(id ->{
			log.info("Getting one by Id " + id);
			return service.read(Long.valueOf(id));
		});
	}
	
	@Bean
	Function<Mono<ReactServiceDto>, Mono<ReactServiceDto>> create(IReactService service) {
		return mono -> mono.flatMap(newRecord ->{
			log.info("Create new record", newRecord.toString());
			return service.create(newRecord);
		});
	}
	
	@Bean
	Function<Mono<ReactServiceDto>, Mono<ReactServiceDto>> update(IReactService service) {
		return mono -> mono.flatMap(updateRecord ->{
			log.info("Update record", updateRecord.toString());
			return service.update(updateRecord);
		});
	}
	
	@Bean
	Function<Mono<ReactServiceDto>, Mono<ReactServiceDto>> delete(IReactService service) {
		return mono -> mono.flatMap(deleteRecord ->{
			log.info("Delete recorid", deleteRecord.toString());
			return service.delete(deleteRecord);
		});
	}
}
