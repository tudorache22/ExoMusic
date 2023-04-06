package it.exolab.costanti;

import it.exolab.models.Utente;

public class StringheEmail {

	public final static String MITTENTE = "gradinciamaria@gmail.com";

	public final static String DESTINATARIO = "tudoracheflorin2000@gmail.com";

	public final static String KEY = "yjaqcanlntblqljc";

	public final static String PDF_LOCAZIONE = "C:/Users/tudor/eclipse-workspace-enterprise/ExoMusicAPP/ExoMusicWEB/listaPdf./listPlaylist.pdf";

	public final static String SUBJECT = "Richiesta documento Exomusic";

	public final static String HOST = "smtp.gmail.com";

	public static String getText(Utente utente) {
		return ("Salve, signor " + utente.getNome() + " " + utente.getCognome() + "\n"
				+ "In quanto, da lei acconsentito, l'azienda ExoMusic le invia il resoconto delle playlist create nel nostro sito \n"
				+ "In allegato troverà il pdf con il documento richiesto. \n"
				+ "Le aguriamo un buon proseguimento nell'utilizzo della nostra app \n"
				+ "Cordiali saluti, staffer Exomusic");
	}

}
