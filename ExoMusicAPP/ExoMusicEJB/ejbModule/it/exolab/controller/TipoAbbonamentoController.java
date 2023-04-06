package it.exolab.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import it.exolab.crud.TipoAbbonamentoCRUD;
import it.exolab.interfaces.TipoAbbonamentoInterface;
import it.exolab.models.TipoAbbonamento;
import it.exolab.mybatis.SqlMapFactory;

@Stateless
@LocalBean
public class TipoAbbonamentoController implements TipoAbbonamentoInterface {

	final static Logger logger = Logger.getLogger(TipoAbbonamentoController.class);

	@Override
	public TipoAbbonamento findById(Integer id) {

		try {
			SqlMapFactory.instance().openSession();
			logger.info("Sei nel controller findById>>>" + id);
			TipoAbbonamento tipoAbbonamento = new TipoAbbonamentoCRUD().findById(id);
			SqlMapFactory.instance().commitSession();
			return tipoAbbonamento;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
			return null;

		} finally {
			SqlMapFactory.instance().closeSession();
		}
	}

	@Override
	public List<TipoAbbonamento> findAll() {
		try {
			SqlMapFactory.instance().openSession();
			logger.info("Sei nel controller findAll>>>");
			List<TipoAbbonamento> listaAbbonamenti = new TipoAbbonamentoCRUD().findAll();
			SqlMapFactory.instance().commitSession();
			return listaAbbonamenti;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
			return null;

		} finally {
			SqlMapFactory.instance().closeSession();
		}
	}

}
