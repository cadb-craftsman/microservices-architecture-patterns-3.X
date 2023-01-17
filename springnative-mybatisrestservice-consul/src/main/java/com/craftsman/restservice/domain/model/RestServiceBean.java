package com.craftsman.restservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestServiceBean {

	private Long id;
	private String name;
	private String description;

}
