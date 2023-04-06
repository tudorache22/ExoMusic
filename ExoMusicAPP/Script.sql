--<ScriptOptions statementTerminator=";"/>

CREATE TABLE artista (
	id_artista INT NOT NULL,
	nome_artista VARCHAR(100) NOT NULL,
	ascoltatori INT NOT NULL,
	PRIMARY KEY (id_artista)
);

CREATE TABLE abbonamento (
	id_abbonamento INT NOT NULL,
	stato VARCHAR(100) NOT NULL,
	data_scadenza VARCHAR(100) NOT NULL,
	id_tipo_abbonamento INT DEFAULT 1 NOT NULL,
	id_utente INT NOT NULL,
	PRIMARY KEY (id_abbonamento)
);

CREATE TABLE canzoni_playlist (
	id_playlist INT NOT NULL,
	id_canzone INT NOT NULL
);

CREATE TABLE playlist (
	id_playlist INT NOT NULL,
	nome_playlist VARCHAR(100) NOT NULL,
	id_utente INT NOT NULL,
	PRIMARY KEY (id_playlist)
);

CREATE TABLE canzone (
	id_canzone INT NOT NULL,
	titolo_canzone VARCHAR(100) NOT NULL,
	durata VARCHAR(100) NOT NULL,
	id_album INT NOT NULL,
	PRIMARY KEY (id_canzone)
);

CREATE TABLE utente (
	id_utente INT NOT NULL,
	email VARCHAR(100) NOT NULL,
	password VARCHAR(100) NOT NULL,
	nome VARCHAR(100) NOT NULL,
	cognome VARCHAR(100),
	id_ruolo INT DEFAULT 1 NOT NULL,
	PRIMARY KEY (id_utente)
);

CREATE TABLE ruolo (
	id_ruolo INT NOT NULL,
	ruolo VARCHAR(100) NOT NULL,
	PRIMARY KEY (id_ruolo)
);

CREATE TABLE tipo_abbonamento (
	id_tipo_abbonamento INT NOT NULL,
	costo VARCHAR(100) NOT NULL,
	nome_abbonamento VARCHAR(100) NOT NULL,
	privilegi VARCHAR(100),
	link_copertina VARCHAR(100),
	PRIMARY KEY (id_tipo_abbonamento)
);

CREATE TABLE genere (
	id_genere INT NOT NULL,
	nome_genere VARCHAR(100) NOT NULL,
	PRIMARY KEY (id_genere)
);

CREATE TABLE album (
	id_album INT NOT NULL,
	titolo_album VARCHAR(100) NOT NULL,
	copertina VARCHAR(500) NOT NULL,
	anno INT NOT NULL,
	id_artista INT,
	id_genere INT,
	PRIMARY KEY (id_album)
);

CREATE INDEX abbonamento_FK_1 ON abbonamento (id_utente ASC);

CREATE INDEX canzone_FK ON canzone (id_album ASC);

CREATE INDEX utente_FK ON utente (id_ruolo ASC);

CREATE INDEX abbonamento_FK ON abbonamento (id_tipo_abbonamento ASC);

CREATE INDEX playlist_FK ON playlist (id_utente ASC);

CREATE INDEX canzoni_playlist_FK_1 ON canzoni_playlist (id_playlist ASC);

CREATE INDEX album_FK ON album (id_artista ASC);

CREATE INDEX album_FK_1 ON album (id_genere ASC);

CREATE INDEX canzoni_playlist_FK ON canzoni_playlist (id_canzone ASC);

