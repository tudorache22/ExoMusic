package it.exolab.converterJson;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.exoBanca.models.Otp;
import it.exoBanca.models.Utente;
import it.exolab.models.Abbonamento;

public class ConverterJson {

	public Abbonamento convertToAbbonamento(String json) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			Abbonamento abbonamento = mapper.readValue(json, Abbonamento.class);
			return abbonamento;

		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}

	}

	public String convertToJson(Abbonamento abbonamento) {
		ObjectMapper mapper = new ObjectMapper();

		try {
			String json = mapper.writeValueAsString(abbonamento);
			return json;

		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Abbonamento> convertList(String json) {
		ObjectMapper mapper = new ObjectMapper();
		System.out.println("converto: " + json);

		try {
			List<Abbonamento> lista = mapper.readValue(json, new TypeReference<List<Abbonamento>>() {
			});
			return lista;

		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String convertToJsonUtente(Utente utente) {
		ObjectMapper mapper = new ObjectMapper();

		try {
			String json = mapper.writeValueAsString(utente);
			return json;

		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Utente convertToUtente(String json) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			Utente utente = mapper.readValue(json, Utente.class);
			return utente;

		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Otp convertJsonToOtp(String json) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			Otp otp = mapper.readValue(json, Otp.class);
			return otp;

		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String convertOtpToJson(Otp otp) {
		ObjectMapper mapper = new ObjectMapper();

		try {
			String json = mapper.writeValueAsString(otp);
			return json;

		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}

	}

}
