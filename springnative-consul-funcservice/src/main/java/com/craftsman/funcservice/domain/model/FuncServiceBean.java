package com.craftsman.funcservice.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PRODUCT")
public class FuncServiceBean implements Persistable<Long> {

	@Id
	private Long id;
	private String name;
	private String description;

	@Override
	@Transient
	public boolean isNew() {
		return true;
	}
}
