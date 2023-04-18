package it.exolab.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClientAbbonamento {

	public String callAbbonamentoBase(String json) {
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://dummyjson.com/products/1"))
//					.header("X-RapidAPI-Key", "93cfe45340msh7e6ea469caf7dd6p19ad47jsnf8c88c9bc303")
//					.header("X-RapidAPI-Host", "api-football-v1.p.rapidapi.com")
				.method("POST", HttpRequest.BodyPublishers.ofString(json)).build();
		HttpResponse<String> response;
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body());
			return response.body();
		} catch (IOException | InterruptedException e) {
			System.out.println("errore");
			e.printStackTrace();
			return ("");
		}
	}

	public String callAbbonamentoExtra(String json) {
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://dummyjson.com/products/1"))
//					.header("X-RapidAPI-Key", "93cfe45340msh7e6ea469caf7dd6p19ad47jsnf8c88c9bc303")
//					.header("X-RapidAPI-Host", "api-football-v1.p.rapidapi.com")
				.method("POST", HttpRequest.BodyPublishers.ofString(json)).build();
		HttpResponse<String> response;
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body());
			return response.body();
		} catch (IOException | InterruptedException e) {
			System.out.println("errore");
			e.printStackTrace();
			return null;
		}
	}

	public String callAbbonamentoPremium(String json) {
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://dummyjson.com/products/1"))
//					.header("X-RapidAPI-Key", "93cfe45340msh7e6ea469caf7dd6p19ad47jsnf8c88c9bc303")
//					.header("X-RapidAPI-Host", "api-football-v1.p.rapidapi.com")
				.method("POST", HttpRequest.BodyPublishers.ofString(json)).build();
		HttpResponse<String> response;
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body());
			return response.body();
		} catch (IOException | InterruptedException e) {
			System.out.println("errore");
			e.printStackTrace();
			return null;
		}
	}

	public String callAllAbbonamenti() {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("http://127.0.0.1:8080/ExoMusicREST/rest/ExomusicRest/allAbbonamenti"))
//				.uri(URI.create("https://dummyjson.com/products/1")).method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response;
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body());
			return response.body();
		} catch (IOException | InterruptedException e) {
			System.out.println("errore");
			e.printStackTrace();
			return null;
		}
	}

	public String callUtenti() {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("http://127.0.0.1:8080/ExoMusicBancaWEB/rest/UtenteRest/findAllUtenti"))
//				.uri(URI.create("https://dummyjson.com/products/1")).method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response;
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body());
			return response.body();
		} catch (IOException | InterruptedException e) {
			System.out.println("errore");
			e.printStackTrace();
			return null;
		}
	}

	public String faiLogin(String requestBody) {

		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("http://127.0.0.1:8080/ExoMusicBancaWEB/rest/UtenteRest/faiLogin"))
				.header("Content-Type", "application/json").POST(HttpRequest.BodyPublishers.ofString(requestBody))
				.build();
		HttpResponse<String> response;
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body());
			return response.body();
		} catch (IOException | InterruptedException e) {
			System.out.println("errore");
			e.printStackTrace();
			return null;
		}
	}

	public String richiediOtp(String requestBody) {

		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("http://127.0.0.1:8080/ExoMusicBancaWEB/rest/OtpRest/creaOtp"))
				.header("Content-Type", "application/json").POST(HttpRequest.BodyPublishers.ofString(requestBody))
				.build();
		HttpResponse<String> response;
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body());
			return response.body();
		} catch (IOException | InterruptedException e) {
			System.out.println("errore");
			e.printStackTrace();
			return null;
		}
	}
	
	public String faiTransazione(String requestBody) {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("http://127.0.0.1:8080/ExoMusicBancaWEB/rest/TransazioneRest/insertTransazione"))
				.header("Content-Type", "application/json")
				.POST(HttpRequest.BodyPublishers.ofString(requestBody))
				.build();
		HttpResponse<String> response;
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body());
			return response.body();
		} catch (IOException | InterruptedException e) {
			System.out.println("errore");
			e.printStackTrace();
			return null;
		}
	}
}
