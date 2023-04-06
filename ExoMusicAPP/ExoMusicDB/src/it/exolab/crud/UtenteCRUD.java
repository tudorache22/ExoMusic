package it.exolab.crud;

import java.util.List;

import org.apache.log4j.Logger;

import it.exolab.mapper.UtenteMapper;
import it.exolab.models.Utente;
import it.exolab.mybatis.SqlMapFactory;

public class UtenteCRUD extends BaseCrud<Utente> {

	final static Logger logger = Logger.getLogger(UtenteCRUD.class);

	@Override
	public Utente insert(Utente model) {
		logger.info("Sei nel UtenteCRUD insert>>>>" + model);
		try {

			UtenteMapper mapper = SqlMapFactory.instance().getMapper(UtenteMapper.class);
			mapper.insert(model);

			return model;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Utente update(Utente model) {
		logger.info("Sei nel UtenteCRUD update>>>>" + model);
		try {

			UtenteMapper mapper = SqlMapFactory.instance().getMapper(UtenteMapper.class);
			mapper.update(model);

			return model;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void delete(Integer id) {
		logger.info("Sei nel UtenteCRUD delete>>>>" + id);
		try {

			UtenteMapper mapper = SqlMapFactory.instance().getMapper(UtenteMapper.class);
			mapper.delete(id);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Utente findById(Integer id) {
		logger.info("Sei nel UtenteCRUD FindById>>>>" + id);
		try {

			UtenteMapper mapper = SqlMapFactory.instance().getMapper(UtenteMapper.class);
			Utente utente = mapper.findById(id);

			return utente;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Utente> findAll() {
		logger.info("Sei nel UtenteCRUD FindAll>>>>");
		try {

			UtenteMapper mapper = SqlMapFactory.instance().getMapper(UtenteMapper.class);
			List<Utente> listaUtenti = mapper.findAll();

			return listaUtenti;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Utente login(Utente utente) {
		logger.info("Sei nel UtenteCRUD login>>>>" + utente);
		try {

			UtenteMapper mapper = SqlMapFactory.instance().getMapper(UtenteMapper.class);
			Utente ut = mapper.login(utente);

			return ut;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
