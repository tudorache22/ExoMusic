package it.exolab.crud;

import java.util.List;

public abstract class BaseCrud<T> {
	
	public abstract T insert(T model);
	
	public abstract T update(T model);
	
	public abstract void delete(Integer id);
	
	public abstract T findById(Integer id);
	
	public abstract List<T> findAll();
}
