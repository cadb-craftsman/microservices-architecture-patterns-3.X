package com.craftsman.restservice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestServiceDto {

	private Long id;
	private String name;
	private String description;

}
