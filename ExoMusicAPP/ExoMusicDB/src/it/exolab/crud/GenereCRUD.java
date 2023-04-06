package it.exolab.crud;

import java.util.List;

import org.apache.log4j.Logger;

import it.exolab.mapper.GenereMapper;
import it.exolab.models.Genere;
import it.exolab.mybatis.SqlMapFactory;

public class GenereCRUD extends BaseCrud<Genere> {

	final static Logger logger = Logger.getLogger(GenereCRUD.class);

	@Override
	public Genere insert(Genere model) {
		logger.info("Sei nel genereCRUD insert>>>>" + model);
		try {
			GenereMapper mapper = SqlMapFactory.instance().getMapper(GenereMapper.class);
			mapper.insert(model);

			return model;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Genere update(Genere model) {
		logger.info("Sei nel genereCRUD update>>>>" + model);
		try {
			GenereMapper mapper = SqlMapFactory.instance().getMapper(GenereMapper.class);
			mapper.update(model);

			return model;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void delete(Integer id) {
		logger.info("Sei nel genereCRUD delete>>>>" + id);
		try {

			GenereMapper mapper = SqlMapFactory.instance().getMapper(GenereMapper.class);
			mapper.delete(id);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	@Override
	public Genere findById(Integer id) {
		logger.info("Sei nel genereCRUD FindById>>>>" + id);
		try {

			GenereMapper mapper = SqlMapFactory.instance().getMapper(GenereMapper.class);
			Genere genere = mapper.findById(id);

			return genere;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Genere> findAll() {
		logger.info("Sei nel genereCRUD FindByAll");
		try {

			GenereMapper mapper = SqlMapFactory.instance().getMapper(GenereMapper.class);
			List<Genere> listaGenere = mapper.findAll();

			return listaGenere;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public Genere findInserimento(Genere genere) {
		logger.info("Sei nel genereCRUD findInserimento>>>>" + genere);
		try {

			GenereMapper mapper = SqlMapFactory.instance().getMapper(GenereMapper.class);
			Genere genere2 = mapper.findInserimento(genere);

			return genere2;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
