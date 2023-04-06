package it.exolab.crud;

import java.util.List;

import org.apache.log4j.Logger;

import it.exolab.mapper.TipoAbbonamentoMapper;
import it.exolab.models.TipoAbbonamento;
import it.exolab.mybatis.SqlMapFactory;

public class TipoAbbonamentoCRUD {
	final static Logger logger = Logger.getLogger(UtenteCRUD.class);

	public TipoAbbonamento findById(Integer id) {
		logger.info("Sei nel TipoAbbonamentoCrud FindById>>>>" + id);
		try {

			TipoAbbonamentoMapper mapper = SqlMapFactory.instance().getMapper(TipoAbbonamentoMapper.class);
			TipoAbbonamento tipoAbbonamento = mapper.findById(id);

			return tipoAbbonamento;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<TipoAbbonamento> findAll() {
		logger.info("Sei nel TipoAbbonamentoCrud FindAll>>>>");
		try {

			TipoAbbonamentoMapper mapper = SqlMapFactory.instance().getMapper(TipoAbbonamentoMapper.class);
			List<TipoAbbonamento> listaAbbonamenti = mapper.findAll();

			return listaAbbonamenti;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
