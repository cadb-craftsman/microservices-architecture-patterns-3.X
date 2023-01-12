package com.craftsman.funcservice.functions;

import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.craftsman.funcservice.domain.dto.FuncServiceDto;
import com.craftsman.funcservice.domain.mappers.FuncServiceFactoryMapperImpl;
import com.craftsman.funcservice.services.IFuncService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Configuration
public class FuncServiceFunctions {

	@Bean
	public FuncServiceFactoryMapperImpl getFactoryMapper() {
		return new FuncServiceFactoryMapperImpl();
	}

	
	@Bean
	Supplier<Flux<FuncServiceDto>> getAll(IFuncService service) {
		return () -> {
			log.info("Getting all records");
			return service.read();
		};
	}
	
	@Bean
	Function<Mono<String>, Mono<FuncServiceDto>> getById(IFuncService service) {
		return mono -> mono.flatMap(id ->{
			log.info("Getting one by Id " + id);
			return service.read(Long.valueOf(id));
		});
	}
	
	@Bean
	Function<Mono<FuncServiceDto>, Mono<FuncServiceDto>> create(IFuncService service) {
		return mono -> mono.flatMap(newRecord ->{
			log.info("Create new record", newRecord.toString());
			return service.create(newRecord);
		});
	}
	
	@Bean
	Function<Mono<FuncServiceDto>, Mono<FuncServiceDto>> update(IFuncService service) {
		return mono -> mono.flatMap(updateRecord ->{
			log.info("Update record", updateRecord.toString());
			return service.update(updateRecord);
		});
	}
	
	@Bean
	Function<Mono<FuncServiceDto>, Mono<FuncServiceDto>> delete(IFuncService service) {
		return mono -> mono.flatMap(deleteRecord ->{
			log.info("Delete recorid", deleteRecord.toString());
			return service.delete(deleteRecord);
		});
	}
}
