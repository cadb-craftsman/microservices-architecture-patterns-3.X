package com.craftsman.restservice.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.craftsman.restservice.domain.model.RestServiceBean;

@Mapper
public interface RestServiceRepository {
	
	@Select("SELECT id, name, description FROM PRODUCT WHERE id = #{id}")
	public RestServiceBean findById(Long id);
	
	@Select("SELECT  id, name, description FROM PRODUCT")
	public List<RestServiceBean> findAll();
	
	@Insert("INSERT INTO PRODUCT (id, name, description) VALUES(#{id}, #{name}, #{description})")
	public int save(RestServiceBean in);
	
	@Update("UPDATE PRODUCT SET name = #{name}, description = #{description} WHERE ID = #{id}")
	public int update(RestServiceBean in);
	
	@Delete("DELETE FROM PRODUCT WHERE ID = #{id}")
	public int delete(Long id);
}
