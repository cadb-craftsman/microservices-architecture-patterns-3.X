package com.craftsman.restservice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BeanDto {

	private Integer id;
	private String name;
	private String description;

}
