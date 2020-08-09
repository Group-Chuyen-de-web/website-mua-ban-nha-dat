package com.muabannhadat.mapping;

import java.util.List;

public interface IMapping<M,E> {
	E mapToEntity(M model);
	M mapToModel(E entity);
	List<E> mapToEntityList(List<M> models);
	List<M> mapToModelList(List<E> entities);
	
}
