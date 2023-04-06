package it.exoBanca.ejbInterfaces;

import java.util.List;

import javax.ejb.Local;

import it.exoBanca.models.Otp;
import it.exoBanca.models.Transazione;

@Local
public interface OtpControllerInterface {

	Otp insert(Otp model);

	Otp update(Otp model);

	Otp findById(Integer idModel);

	List<Otp> findAll();

	void delete(Otp model);

	Otp nuovoOtp(Transazione transazione);

}
