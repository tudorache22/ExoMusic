package it.exolab.crud;

import java.util.List;

import org.apache.log4j.Logger;

import it.exolab.mapper.AbbonamentoMapper;
import it.exolab.models.Abbonamento;
import it.exolab.mybatis.SqlMapFactory;

public class AbbonamentoCRUD extends BaseCrud<Abbonamento> {

	final static Logger logger = Logger.getLogger(AbbonamentoCRUD.class);

	@Override
	public Abbonamento insert(Abbonamento model) {
		System.out.println("Sei nel abbonamentoCRUD insert>>>>" + model);
		try {
			AbbonamentoMapper mapper = SqlMapFactory.instance().getMapper(AbbonamentoMapper.class);
			mapper.insert(model);
			return model;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Abbonamento update(Abbonamento model) {
		System.out.println("Sei nel Abbonamento crud update>>>" + model);

		try {
			AbbonamentoMapper mapper = SqlMapFactory.instance().getMapper(AbbonamentoMapper.class);
			mapper.update(model);
			return model;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void delete(Integer id) {
		System.out.println("Sei nel AbbonamentoCrud>>>" + id);
		try {
			AbbonamentoMapper mapper = SqlMapFactory.instance().getMapper(AbbonamentoMapper.class);
			mapper.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Abbonamento findById(Integer id) {
		System.out.println("Sei nel Abbonamento crud FindById>>>" + id);

		try {
			AbbonamentoMapper mapper = SqlMapFactory.instance().getMapper(AbbonamentoMapper.class);
			Abbonamento abbonamento = mapper.findById(id);
			return abbonamento;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Abbonamento> findAll() {
		System.out.println("Sei nel Abbonamento crud FindAll");

		try {
			AbbonamentoMapper mapper = SqlMapFactory.instance().getMapper(AbbonamentoMapper.class);
			List<Abbonamento> listaAbbonamento = mapper.findAll();
			return listaAbbonamento;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
