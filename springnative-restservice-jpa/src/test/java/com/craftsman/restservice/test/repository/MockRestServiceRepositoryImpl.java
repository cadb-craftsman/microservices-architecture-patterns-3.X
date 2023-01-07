package com.craftsman.restservice.test.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.craftsman.restservice.domain.model.RestServiceEntity;
import com.craftsman.restservice.repository.RestServiceRepository;

public class MockRestServiceRepositoryImpl implements RestServiceRepository {

	private List<RestServiceEntity> list = new ArrayList<RestServiceEntity>();

	@Override
	public <S extends RestServiceEntity> S save(S entity) {
		list.add(entity);
		return entity;
	}

	@Override
	public <S extends RestServiceEntity> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<RestServiceEntity> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		if (list.size() > 1) {
			list.remove(id.intValue());
		}
	}

	@Override
	public void delete(RestServiceEntity entity) {
		if (list.size() > 1) {
			list.remove(entity.getId().intValue());
		}
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends RestServiceEntity> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		list.clear();

	}

	@Override
	public Optional<RestServiceEntity> findById(Long id) {
		if (!list.isEmpty()) {
			return Optional.of(list.get(id.intValue()));
		}
		return Optional.empty();
	}

	@Override
	public Iterable<RestServiceEntity> findAll() {
		return list;
	}

}
