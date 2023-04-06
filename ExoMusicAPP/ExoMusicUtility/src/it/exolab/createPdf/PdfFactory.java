package it.exolab.createPdf;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.Table;

import it.exolab.costanti.ContenitoreFont;
import it.exolab.costanti.StringhePdf;
import it.exolab.models.Playlist;
import it.exolab.models.Utente;

public class PdfFactory {

	private Utente utente;
	private List<?> lista;
	private List<String> headerTabella;
	private Document pdfDocument;

	public PdfFactory(Utente utente, List<?> lista, List<String> headerTabella, Document pdfDocument) {
		this.utente = utente;
		this.lista = lista;
		this.headerTabella = headerTabella;
		this.pdfDocument = pdfDocument;
	}

	public PdfFactory(Utente utente, List<?> lista, Document pdfDocument) {
		this.utente = utente;
		this.lista = lista;
		this.pdfDocument = pdfDocument;
	}

	public PdfFactory(Utente utente, Document pdfDocument) {
		this.utente = utente;
		this.pdfDocument = pdfDocument;
	}

	public PdfFactory(Document pdfDocument) {
		this.pdfDocument = pdfDocument;
	}

	public void setFooter() {
		Paragraph p = new Paragraph(StringhePdf.TESTO_FOOTER, ContenitoreFont.FONT_FOOTER);

		HeaderFooter footer = new HeaderFooter(new Phrase(p), true);
		footer.setBorder(Rectangle.NO_BORDER);
		footer.setBackgroundColor(Color.BLACK);
		footer.setAlignment(Element.ALIGN_CENTER);
		pdfDocument.setFooter(footer);
	}

	public void setMetadata() {
		pdfDocument.addTitle("titolo esempio");
		pdfDocument.addAuthor("Florin");
		pdfDocument.addKeywords("prova pdf");
		pdfDocument.addSubject("prove pdf");
		pdfDocument.addCreator("Creatore Florin");

	}

	// Questo metodo aggiunge una foto all'Header se si utilizza l'impostazione
	// della pagina come Tabella
	public void setLogoHeader(Table table) throws BadElementException, IOException {

		Cell c = new Cell(setImmagine());
		c.setBorderColor(Color.WHITE);
		c.setBorderWidth(0);
		c.setHeader(true);
		c.setColspan(3);
		c.setBackgroundColor(Color.BLACK);
		table.addCell(c);
		table.endHeaders();

	}

	public Image setImmagine() throws BadElementException, IOException {
		Image image = Image.getInstance(StringhePdf.URL_LOGO);
		image.scaleAbsolute(150f, 150f);
		image.setAlignment(Element.ALIGN_CENTER);

		return image;
	}

	public void aggiungiCella(Paragraph contenuto, Table table) {
		Cell cella = new Cell(contenuto);
		cella.setBorderWidth(0);
		cella.setColspan(3);
		table.addCell(cella);
	}

	// Questo metodo viene usato per creare dei spazi vuoti tra i contenuti della
	// pagina,se si utilizza l'impostazione tabella come all page
	public void aggiungiCellaVuota(Table table) {
		Cell cella = new Cell();
		cella.setColspan(3);
		cella.setBorderWidth(0);
		table.addCell(cella);
	}

	// Questo metodo definisce l'Header della tabella nell'impostazione allPage
	// tabella
	public void aggiungiCellaHeader(Paragraph contenuto, Table table) {
		Cell cella = new Cell(contenuto);
		cella.setBorderWidth(0);
		cella.setHeader(true);
		cella.setColspan(3);
		table.addCell(cella);
		table.endHeaders();
	}

	// Questo metodo viene usato per impostare la pagina come una grande tabella
	public Table setTabellaPagina() {
		Table table = new Table(3);
		table.setTop(600);
		table.setBottom(20);
		table.setBorderWidth(0f);
		table.setBorderColor(Color.WHITE);
		table.setPadding(1);
		table.setSpacing(2);
		return table;
	}

	// Questo metodo definisce l'Header della tabella
	public void aggiungiHeaderTabella(Table table) {
		headerTabella.forEach(e -> {
			Cell current = new Cell(new Phrase(e));
			current.setHeader(true);
			current.setBackgroundColor(Color.GRAY);
			table.addCell(current);
		});
	}

	public void aggiungiCanzoniTabella(Playlist playlist, Table table) {
		if (playlist.getListaCanzoni().size() > 0) {
			playlist.getListaCanzoni().forEach((canzoni) -> {
				if (table.getBottom() > 200) {

					table.addCell(new Phrase(canzoni.getTitoloCanzone()));
					table.addCell(new Phrase(canzoni.getDurata()));
					table.addCell(new Phrase(canzoni.getAlbum().getTitoloAlbum()));
				} else {
					pdfDocument.newPage();
					table.addCell(new Phrase(canzoni.getTitoloCanzone()));
					table.addCell(new Phrase(canzoni.getDurata()));
					table.addCell(new Phrase(canzoni.getAlbum().getTitoloAlbum()));
				}
			});
		} else {
			aggiungiCella(new Paragraph("La playlist non contiene nessuna canzone", ContenitoreFont.FONT_TESTO), table);
		}
	}

	public void setHeader() {
		Paragraph p = new Paragraph(StringhePdf.TESTO_FOOTER, ContenitoreFont.FONT_FOOTER);

		HeaderFooter header = new HeaderFooter(new Phrase(p), true);
		header.setBorder(Rectangle.NO_BORDER);
		header.setBackgroundColor(Color.BLACK);
		header.setAlignment(Element.ALIGN_CENTER);
		pdfDocument.setFooter(header);
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public List<?> getLista() {
		return lista;
	}

	public void setLista(List<?> lista) {
		this.lista = lista;
	}

	public List<String> getHeaderTabella() {
		return headerTabella;
	}

	public void setHeaderTabella(List<String> headerTabella) {
		this.headerTabella = headerTabella;
	}

}
