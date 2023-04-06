package it.exolab.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import it.exolab.crud.AbbonamentoCRUD;
import it.exolab.interfaces.AbbonamentoInterface;
import it.exolab.models.Abbonamento;
import it.exolab.mybatis.SqlMapFactory;

@Stateless
@LocalBean
public class AbbonamentoController implements AbbonamentoInterface {

	final static Logger logger = Logger.getLogger(AbbonamentoController.class);

	@Override
	public Abbonamento insert(Abbonamento album) {
		try {
			SqlMapFactory.instance().openSession();
			logger.info("Sei nel controller insert>>>" + album);

			SqlMapFactory.instance().commitSession();
			album = new AbbonamentoCRUD().insert(album);
			return album;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
			return null;

		} finally {
			SqlMapFactory.instance().closeSession();
		}
	}

	@Override
	public Abbonamento update(Abbonamento album) {
		try {
			SqlMapFactory.instance().openSession();
			logger.info("Sei nel controller update>>>" + album);

			album = new AbbonamentoCRUD().update(album);
			SqlMapFactory.instance().commitSession();
			return album;

		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
			return null;

		} finally {
			SqlMapFactory.instance().closeSession();
		}
	}

	@Override
	public Abbonamento findById(Integer id) {
		try {
			SqlMapFactory.instance().openSession();
			logger.info("Sei nel controller findById>>>" + id);

			Abbonamento album = new AbbonamentoCRUD().findById(id);
			SqlMapFactory.instance().commitSession();
			return album;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
			return null;

		} finally {
			SqlMapFactory.instance().closeSession();
		}

	}

	@Override
	public void delete(Integer id) {
		try {
			SqlMapFactory.instance().openSession();
			logger.info("Sei nel controller delete>>>" + id);
			new AbbonamentoCRUD().delete(id);
			SqlMapFactory.instance().commitSession();
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
		} finally {
			SqlMapFactory.instance().closeSession();
		}
	}

	@Override
	public List<Abbonamento> findAll() {
		try {
			SqlMapFactory.instance().openSession();
			logger.info("Sei nel controller findAll>>>");

			List<Abbonamento> listaAbbonamento = new AbbonamentoCRUD().findAll();
			SqlMapFactory.instance().commitSession();
			return listaAbbonamento;
		} catch (Exception e) {
			e.printStackTrace();
			SqlMapFactory.instance().rollbackSession();
			return null;
		} finally {
			SqlMapFactory.instance().closeSession();
		}
	}

}
