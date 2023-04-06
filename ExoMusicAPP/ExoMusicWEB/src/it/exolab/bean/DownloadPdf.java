package it.exolab.bean;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@Named
@RequestScoped
public class DownloadPdf implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5882777981712522711L;
	private StreamedContent file;

	@PostConstruct
	private void init() throws FileNotFoundException {

		FileInputStream fis = new FileInputStream(
				"C:/Users/tudor/eclipse-workspace-enterprise/ExoMusicAPP/ExoMusicWEB/listaPdf./listPlaylist.pdf");

		file = DefaultStreamedContent.builder().name("playlist").contentType("application/pdf").stream(() -> fis)
				.build();

//		() -> FacesContext.getCurrentInstance().getExternalContext()
//		.getResourceAsStream("C:/Users/tudor/OneDrive/Desktop/playlistExomusic./listPlaylist.pdf"))
//		InputStream stream = this.getClass().getResourceAsStream("/chapter7/PFSamplePDF.pdf");
//		file = new DefaultStreamedContent(stream, "application/pdf", "PFSample.pdf").;

	}

	public StreamedContent getFile() {
		return file;
	}

	public void setFile(StreamedContent file) {
		this.file = file;
	}

}
