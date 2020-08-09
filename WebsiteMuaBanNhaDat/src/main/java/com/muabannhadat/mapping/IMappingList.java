package com.muabannhadat.mapping;

import java.util.List;

public interface IMappingList<M,E> {
	List<E> mapToEntityList(List<M> model);
	List<M> mapToModelList(List<E> entity);
	

}
