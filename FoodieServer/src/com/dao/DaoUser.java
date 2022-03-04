package com.dao;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public interface DaoUser<ID extends Serializable, T> {
	
	T get(ID id);
	ArrayList<T> getAll();
	int delete(T entity) throws IOException;
	int save(T entity) throws IOException;
	int saveAll(ArrayList<T> entity) throws IOException;
	int find(ArrayList<T> entity, long id) throws IOException;

}
