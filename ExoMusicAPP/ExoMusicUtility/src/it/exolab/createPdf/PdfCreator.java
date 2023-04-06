package it.exolab.createPdf;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

import it.exolab.costanti.ContenitoreFont;
import it.exolab.costanti.StringhePdf;
import it.exolab.models.Playlist;
import it.exolab.models.Utente;

public class PdfCreator {

	private List<Playlist> listaPlaylist = new ArrayList<Playlist>();
	private Utente utente;

	private List<String> headerTabella;

	public void creaPdf() {
		Document pdfDocument = new Document(PageSize.A4, 10f, 10f, 50f, 32f);

		try {

			PdfWriter pdfWriter = PdfWriter.getInstance(pdfDocument, new FileOutputStream(StringhePdf.PERCORSO_PDF));

			setValoriHeader();

			PdfFactory factory = new PdfFactory(utente, listaPlaylist, headerTabella, pdfDocument);

			factory.setFooter();
			pdfDocument.open();

			Table table = factory.setTabellaPagina();
			factory.setLogoHeader(table);
			factory.aggiungiCellaHeader(new Paragraph(StringhePdf.TITOLO, ContenitoreFont.FONT_TITOLO), table);
			factory.aggiungiCella(new Paragraph(StringhePdf.contenutoPdfPlaylist(utente), ContenitoreFont.FONT_TESTO),
					table);
			factory.aggiungiCella(new Paragraph(StringhePdf.getData(), ContenitoreFont.FONT_TITOLO_PLAYLIST), table);

			listaPlaylist.forEach(playlist -> {
				factory.aggiungiCella(
						new Paragraph(StringhePdf.nomePlaylist(playlist), ContenitoreFont.FONT_TITOLO_PLAYLIST), table);
				factory.aggiungiHeaderTabella(table);
				factory.aggiungiCanzoniTabella(playlist, table);
				factory.aggiungiCellaVuota(table);
			});

			pdfDocument.add(table);

			pdfDocument.close();
			pdfWriter.close();
			System.out.println("ha funzionato");

		} catch (BadElementException | IOException e) {
			System.out.println("non ha funzionato");
			e.printStackTrace();
		}
	}

	public void setValoriHeader() {
		headerTabella = new ArrayList<String>();

		headerTabella.add("Titolo Canzone");
		headerTabella.add("Durata");
		headerTabella.add("Album");
	}

	public List<Playlist> getListaPlaylist() {
		return listaPlaylist;
	}

	public void setListaPlaylist(List<Playlist> listaPlaylist) {
		this.listaPlaylist = listaPlaylist;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public List<String> getHeaderTabella() {
		return headerTabella;
	}

	public void setHeaderTabella(List<String> headerTabella) {
		this.headerTabella = headerTabella;
	}

//	public void creaPdf() {

//		Document pdfDocument = new Document(PageSize.A4, 10f, 10f, 50f, 30f);
//
//		try {
//			FileOutputStream pdfOutputStream = new FileOutputStream(
//					"C:/Users/tudor/eclipse-workspace-enterprise/ExoMusicAPP/ExoMusicWEB/listaPdf./listPlaylist.pdf");
//			PdfWriter pdfWriter = PdfWriter.getInstance(pdfDocument, pdfOutputStream);
//
//			setFooter(pdfDocument);
//
//			pdfDocument.open();
//
//			setMetadata(pdfDocument);
//
//			pdfDocument.add(impostaPagina(pdfDocument));
//
//			pdfDocument.close();
//			pdfWriter.close();
//
//			System.out.println("ha funzionato");
//
//		} catch (Exception e) {
//
//			System.out.println("non ha funzionato");
//			e.printStackTrace();
//
//		}
//
//	}
//
//	private Table impostaPagina(Document pdfDocument) throws BadElementException, IOException {
//
//		String contenuto = "Il Cliente " + utente.getNome() + " " + utente.getCognome() + " ,associato all'email: "
//				+ utente.getEmail()
//				+ " , dichiara di voler esportare il contenuto delle sue playlist per uso personale e non divulgativo.\r\n"
//				+ "In base alle normative 100/c232 l'azienda ExoMusic si impegna a mantenere i dati privati dell'utente e abilita l'esportazione delle playlist personali.\r\n"
//				+ "";
//
//		Table table = setTabellaPagina();
//
//		setLogo("https://i.imgur.com/98QXrmP.jpg", table);
//
//		aggiungiCellaHeader("Documento di esportazione delle playlist", table);
//
//		aggiungiCella(contenuto, table);
//
//		aggiungiCella(data, table);
//
//		listaPlaylist.forEach((playlist) -> {
//
//			String titoloPlaylist = "Playlist: " + playlist.getNomePlaylist();
//
//			aggiungiCella(titoloPlaylist, table);
//
//			List<String> headerTabella = new ArrayList<String>();
//			headerTabella.add("Titolo Canzone");
//			headerTabella.add("Durata");
//			headerTabella.add("Album");
//
//			aggiungiHeaderTabella(headerTabella, table);
//
//			aggiungiCanzoniTabella(playlist, table, pdfDocument);
//
//			aggiungiCellaVuota(table);
//
//		});
//		return table;
//
//	}
//
//	private void aggiungiCanzoniTabella(Playlist playlist, Table table, Document pdfDocument) {
//		if (playlist.getListaCanzoni().size() > 0) {
//			playlist.getListaCanzoni().forEach((canzoni) -> {
//				if (table.getBottom() > 200) {
//
//					table.addCell(new Phrase(canzoni.getTitoloCanzone()));
//					table.addCell(new Phrase(canzoni.getDurata()));
//					table.addCell(new Phrase(canzoni.getAlbum().getTitoloAlbum()));
//				} else {
//					pdfDocument.newPage();
//					table.addCell(new Phrase(canzoni.getTitoloCanzone()));
//					table.addCell(new Phrase(canzoni.getDurata()));
//					table.addCell(new Phrase(canzoni.getAlbum().getTitoloAlbum()));
//				}
//			});
//		} else {
//			aggiungiCella("La playlist non contiene nessuna canzone", table);
//		}
//	}
//
//	private void aggiungiHeaderTabella(List<String> headerTabella, Table table) {
//
//		headerTabella.forEach(e -> {
//			Cell current = new Cell(new Phrase(e));
//			current.setHeader(true);
//			current.setBackgroundColor(Color.GRAY);
//			table.addCell(current);
//		});
//	}
//
//	private void aggiungiCella(String contenuto, Table table) {
//		Cell c = new Cell(contenuto);
//		c.setBorderWidth(0);
//		c.setColspan(3);
//		table.addCell(c);
//	}
//
//	private void aggiungiCellaVuota(Table table) {
//		Cell f = new Cell();
//		f.setColspan(3);
//		f.setBorderWidth(0);
//		table.addCell(f);
//	}
//
//	private void aggiungiCellaHeader(String contenuto, Table table) {
//		Cell c = new Cell(contenuto);
//		c.setBorderWidth(0);
//		c.setHeader(true);
//		c.setColspan(3);
//		table.addCell(c);
//		table.endHeaders();
//	}
//
//	private void setLogo(String url, Table table) throws BadElementException, IOException {
//		Image image = Image.getInstance(url);
//		image.scaleAbsolute(150f, 150f);
//		image.setAlignment(Element.ALIGN_CENTER);
//
//		Cell c = new Cell(image);
//		c.setBorderColor(Color.WHITE);
//		c.setBorderWidth(0);
//		c.setHeader(true);
//		c.setColspan(3);
//		c.setBackgroundColor(Color.BLACK);
//		table.addCell(c);
//		table.endHeaders();
//
//	}
//
//	private Table setTabellaPagina() {
//		Table table = new Table(3);
//		table.setTop(600);
//		table.setBottom(20);
//		table.setBorderWidth(0f);
//		table.setBorderColor(Color.WHITE);
//		table.setPadding(1);
//		table.setSpacing(2);
//		return table;
//	}
//
//	private void setMetadata(Document pdfDocument) {
//		pdfDocument.addTitle("titolo esempio");
//		pdfDocument.addAuthor("Florin");
//		pdfDocument.addKeywords("prova pdf");
//		pdfDocument.addSubject("prove pdf");
//		pdfDocument.addCreator("Creatore Florin");
//
//	}
//
//	private void setFooter(Document pdfDocument) {
//		Font fontFooter = new Font(Font.COURIER, 15f, Font.BOLDITALIC, Color.WHITE);
//		String s = "@ExoMusicProduction        page Number:";
//		Paragraph p = new Paragraph(s, fontFooter);
//
//		HeaderFooter footer = new HeaderFooter(new Phrase(p), true);
//		footer.setBorder(Rectangle.NO_BORDER);
//		footer.setBackgroundColor(Color.BLACK);
//		footer.setAlignment(Element.ALIGN_CENTER);
//		pdfDocument.setFooter(footer);
//	}
//
//	public String getTitolo() {
//		return titolo;
//	}
//
//	public void setTitolo(String titolo) {
//		this.titolo = titolo;
//	}
//
//	public List<Playlist> getListaPlaylist() {
//		return listaPlaylist;
//	}
//
//	public void setListaPlaylist(List<Playlist> listaPlaylist) {
//		this.listaPlaylist = listaPlaylist;
//	}
//
//	public Utente getUtente() {
//		return utente;
//	}
//
//	public void setUtente(Utente utente) {
//		this.utente = utente;
//	}
//
//	public String getData() {
//		return data;
//	}
//
//	public void setData(String data) {
//		this.data = data;
//	}

}
