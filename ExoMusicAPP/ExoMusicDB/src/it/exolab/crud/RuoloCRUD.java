package it.exolab.crud;

import java.util.List;

import org.apache.log4j.Logger;

import it.exolab.mapper.RuoloMapper;
import it.exolab.models.Ruolo;
import it.exolab.mybatis.SqlMapFactory;

public class RuoloCRUD extends BaseCrud<Ruolo> {

	final static Logger logger = Logger.getLogger(RuoloCRUD.class);

	@Override
	public Ruolo insert(Ruolo model) {
		logger.info("Sei nel RuoloCRUD insert>>>>" + model);
		try {

			RuoloMapper mapper = SqlMapFactory.instance().getMapper(RuoloMapper.class);
			mapper.insert(model);

			return model;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Ruolo update(Ruolo model) {
		logger.info("Sei nel RuoloCRUD update>>>>" + model);
		try {

			RuoloMapper mapper = SqlMapFactory.instance().getMapper(RuoloMapper.class);
			mapper.update(model);

			return model;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void delete(Integer id) {
		logger.info("Sei nel RuoloCRUD update>>>>" + id);
		try {

			RuoloMapper mapper = SqlMapFactory.instance().getMapper(RuoloMapper.class);
			mapper.delete(id);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Ruolo findById(Integer id) {
		logger.info("Sei nel RuoloCRUD findbyId>>>>" + id);
		try {

			RuoloMapper mapper = SqlMapFactory.instance().getMapper(RuoloMapper.class);
			Ruolo ruolo = mapper.findById(id);

			return ruolo;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Ruolo> findAll() {
		logger.info("Sei nel RuoloCRUD findAll");
		try {

			RuoloMapper mapper = SqlMapFactory.instance().getMapper(RuoloMapper.class);
			List<Ruolo> ruolo = mapper.findAll();
			return ruolo;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
