package it.exolab.costanti;

import org.joda.time.DateTime;

import it.exolab.models.Playlist;
import it.exolab.models.Utente;

public class StringhePdf {

	public final static String PERCORSO_PDF = "C:/Users/tudor/eclipse-workspace-enterprise/ExoMusicAPP/ExoMusicWEB/listaPdf./listPlaylist.pdf";

	public final static String TESTO_FOOTER = "@ExoMusicProduction        page Number:";

	public final static String URL_LOGO = "https://i.imgur.com/98QXrmP.jpg";

	public final static String TITOLO = "Documento di esportazione delle playlist";

	public static String getData() {
		DateTime datetime = DateTime.now();
		String dataFormato = datetime.getDayOfMonth() + "/" + datetime.getMonthOfYear() + "/" + datetime.getYear();
		String data = "data: " + dataFormato;

		return data;
	}

	public static String contenutoPdfPlaylist(Utente utente) {

		return ("Il Cliente " + utente.getNome() + " " + utente.getCognome() + " ,associato all'email: "
				+ utente.getEmail()
				+ " , dichiara di voler esportare il contenuto delle sue playlist per uso personale e non divulgativo."
				+ "In base alle normative 100/c232 l'azienda ExoMusic si impegna a mantenere i dati privati dell'utente e abilita l'esportazione delle playlist personali.");
	}

	public static String nomePlaylist(Playlist playlist) {
		return ("Playlist: " + playlist.getNomePlaylist());
	}
}
