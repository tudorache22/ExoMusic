package it.exoBanca.rest;

import javax.ws.rs.core.Response;

public abstract class BaseRest<T> {

	abstract Response insert(T model);

	abstract Response update(T model);

	abstract Response findById(Integer idModel);

	abstract Response findAll();

	abstract Response delete(T model);

}
