package it.exolab.costanti;

public class Const {

	public static final String MODELS_PROJECT_NAME = "ExoMusicBancaModel";

	// nomi tabelle per findAll
	public static final String TABELLA_ANAGRAFICA = "anagrafica";
	public static final String TABELLA_CONTO_CORRENTE = "conto_corrente";
	public static final String TABELLA_OTP = "otp";
	public static final String TABELLA_TRANSAZIONE = "transazione";
	public static final String TABELLA_UTENTE = "utente";

	public static final String QUERY_LOGIN = "SELECT * FROM utente WHERE email = ':placeEmail:' AND password = ':placePassword:'";

	public static final String PREFISSO_IT = "IT";
	public static final String PREFISSO_EE = "EE";

	public static final String CHARS_FOR_CONTO_CORRENTE_1 = "EFGNETUVBASZHIXOPQLMAJRKWBCDCDY";
	public static final String CHARS_FOR_CONTO_CORRENTE_2 = "FGXSZHIYXYWEKJKNUVTBAPQOCLMRDWZ";
	public static final String CHARS_FOR_CONTO_CORRENTE_3 = "NFGOPQHIRLMJ";

	public static final String[] CODICE_FISCALE_LETTERA_MESE = { "A", "B", "C", "D", "E", "H", "L", "M", "P", "R", "S",
			"T" };

}
