CREATE DATABASE `musicalmente` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;


//CREAZIONE TABELLA ALBUM
-- musicalmente.album definition

CREATE TABLE `album` (
  `id_album` int NOT NULL AUTO_INCREMENT,
  `titolo_album` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `copertina` varchar(500) COLLATE utf8mb4_general_ci NOT NULL,
  `anno` int NOT NULL,
  `id_artista` int DEFAULT NULL,
  `id_genere` int DEFAULT NULL,
  PRIMARY KEY (`id_album`),
  KEY `album_FK` (`id_artista`),
  KEY `album_FK_1` (`id_genere`),
  CONSTRAINT `album_FK` FOREIGN KEY (`id_artista`) REFERENCES `artista` (`id_artista`) ON DELETE CASCADE,
  CONSTRAINT `album_FK_1` FOREIGN KEY (`id_genere`) REFERENCES `genere` (`id_genere`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


//CREAZIONE TABELLA ARTISTA
-- musicalmente.artista definition

CREATE TABLE `artista` (
  `id_artista` int NOT NULL AUTO_INCREMENT,
  `nome_artista` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `ascoltatori` int NOT NULL,
  PRIMARY KEY (`id_artista`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


//CREAZIONE TABELLA CANZONE
-- musicalmente.canzone definition

CREATE TABLE `canzone` (
  `id_canzone` int NOT NULL AUTO_INCREMENT,
  `titolo_canzone` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `durata` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `id_album` int NOT NULL,
  PRIMARY KEY (`id_canzone`),
  KEY `canzone_FK` (`id_album`),
  CONSTRAINT `canzone_FK` FOREIGN KEY (`id_album`) REFERENCES `album` (`id_album`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


//CREAZIONE TABELLA CANZONI_PLAYLIST
-- musicalmente.canzoni_playlist definition

CREATE TABLE `canzoni_playlist` (
  `id_playlist` int NOT NULL,
  `id_canzone` int NOT NULL,
  KEY `canzoni_playlist_FK` (`id_canzone`),
  KEY `canzoni_playlist_FK_1` (`id_playlist`),
  CONSTRAINT `canzoni_playlist_FK` FOREIGN KEY (`id_canzone`) REFERENCES `canzone` (`id_canzone`) ON DELETE CASCADE,
  CONSTRAINT `canzoni_playlist_FK_1` FOREIGN KEY (`id_playlist`) REFERENCES `playlist` (`id_playlist`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



//CREAZIONE TABELLA GENERE
-- musicalmente.genere definition

CREATE TABLE `genere` (
  `id_genere` int NOT NULL AUTO_INCREMENT,
  `nome_genere` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id_genere`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


//CREAZIONE TABELLA PLAYLIST
-- musicalmente.playlist definition

CREATE TABLE `playlist` (
  `id_playlist` int NOT NULL AUTO_INCREMENT,
  `nome_playlist` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `id_utente` int NOT NULL,
  PRIMARY KEY (`id_playlist`),
  KEY `playlist_FK` (`id_utente`),
  CONSTRAINT `playlist_FK` FOREIGN KEY (`id_utente`) REFERENCES `utente` (`id_utente`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


//CREAZIONE TABELLA RUOLO

-- musicalmente.ruolo definition

CREATE TABLE `ruolo` (
  `id_ruolo` int NOT NULL AUTO_INCREMENT,
  `ruolo` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id_ruolo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



//CREAZIONE TABELLA utente
-- musicalmente.utente definition

CREATE TABLE `utente` (
  `id_utente` int NOT NULL AUTO_INCREMENT,
  `email` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `nome` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `cognome` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `id_ruolo` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_utente`),
  KEY `utente_FK` (`id_ruolo`),
  CONSTRAINT `utente_FK` FOREIGN KEY (`id_ruolo`) REFERENCES `ruolo` (`id_ruolo`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


//Inserimenti Genere
INSERT INTO musicalmente.genere
(id_genere, nome_genere)
VALUES(1, 'Urban');
INSERT INTO musicalmente.genere
(id_genere, nome_genere)
VALUES(2, 'Pop');
INSERT INTO musicalmente.genere
(id_genere, nome_genere)
VALUES(3, 'Rap');
INSERT INTO musicalmente.genere
(id_genere, nome_genere)
VALUES(4, 'Rock');


//Inserimenti Artisti
INSERT INTO musicalmente.artista
(id_artista, nome_artista, ascoltatori)
VALUES(1, '21 Savage', 61165000);
INSERT INTO musicalmente.artista
(id_artista, nome_artista, ascoltatori)
VALUES(2, 'Post Malone', 52114000);
INSERT INTO musicalmente.artista
(id_artista, nome_artista, ascoltatori)
VALUES(3, 'Travis Scott', 44089000);
INSERT INTO musicalmente.artista
(id_artista, nome_artista, ascoltatori)
VALUES(4, 'The Weeknd', 105719000);
INSERT INTO musicalmente.artista
(id_artista, nome_artista, ascoltatori)
VALUES(5, 'XXXTENTACION', 35696000);
INSERT INTO musicalmente.artista
(id_artista, nome_artista, ascoltatori)
VALUES(6, 'Metro Boomin', 53554000);


//Inserimenti Album 
INSERT INTO musicalmente.album
(id_album, titolo_album, copertina, anno, id_artista, id_genere)
VALUES(1, 'I am > i was', 'https://m.media-amazon.com/images/I/712Rkd6CIKL._AC_SX466_.jpg', 2018, 1, 3);
INSERT INTO musicalmente.album
(id_album, titolo_album, copertina, anno, id_artista, id_genere)
VALUES(2, 'Hollywood''s Bleeding', 'https://i.scdn.co/image/ab67616d0000b2739478c87599550dd73bfa7e02', 2019, 2, 2);
INSERT INTO musicalmente.album
(id_album, titolo_album, copertina, anno, id_artista, id_genere)
VALUES(3, 'Astroworld', 'https://m.media-amazon.com/images/I/81nFF-rXdRL._AC_SL1500_.jpg', 2018, 3, 1);
INSERT INTO musicalmente.album
(id_album, titolo_album, copertina, anno, id_artista, id_genere)
VALUES(4, 'After Hours', 'https://m.media-amazon.com/images/I/813XseYNw1L._AC_SL1414_.jpg', 2020, 4, 2);
INSERT INTO musicalmente.album
(id_album, titolo_album, copertina, anno, id_artista, id_genere)
VALUES(5, '17', 'https://m.media-amazon.com/images/I/91duom08xrL._AC_SL1500_.jpg', 2017, 5, 1);
INSERT INTO musicalmente.album
(id_album, titolo_album, copertina, anno, id_artista, id_genere)
VALUES(6, 'Heroes & Villains', 'https://m.media-amazon.com/images/I/41wk2tu90AL._AC_.jpg', 2022, 6, 1);


//Inserimenti Canzoni

INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(1, 'a lot', '4:49', 1);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(2, 'break da law', '2:58', 1);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(3, 'a&t', '3:32', 1);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(4, 'out for the night', '2:17', 1);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(5, 'gun smoke', '2:48', 1);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(6, '1.5', '2:29', 1);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(7, 'all my friends', '3:32', 1);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(8, 'can''t leave without it', '3:25', 1);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(9, 'asmr', '2:52', 1);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(10, 'ball w/o you', '3:15', 1);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(11, 'good day', '4:03', 1);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(12, 'pad lock', '3:11', 1);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(13, 'monster', '3:53', 1);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(14, 'letter 2 my momma', '3:15', 1);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(15, '4L', '4:49', 1);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(16, 'Hollywood''s Bleeding', '2:36', 2);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(17, 'Sunflower', '2.38', 2);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(18, 'Take What you want', '3:50', 2);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(19, 'On the road', '3:38', 2);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(20, 'Die for me', '4:05', 2);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(21, 'Enemies', '3:17', 2);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(22, 'GoodByes', '2:55', 2);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(23, 'Staring at the Sun', '2:48', 2);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(24, 'Internet', '2:03', 2);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(25, 'Wow', '2:29', 2);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(26, 'Myself', '2:38', 2);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(27, 'Saint-Tropez', '2:31', 2);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(28, 'A Thousand Bad Times', '3:41', 2);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(29, 'I Know', '2:21', 2);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(30, 'Circles', '3:35', 2);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(31, 'I''m Gonna be', '3:21', 2);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(32, 'Allergic', '2:37', 2);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(33, 'Carousel', '3:00', 3);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(34, 'Can''t Say', '3:19', 3);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(35, 'Sicko Mode', '5:13', 3);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(36, 'Wake Up', '3:52', 3);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(37, 'Yosemite', '2:30', 3);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(38, 'No Bystanders', '3:38', 3);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(39, 'Who? What!', '2:57', 3);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(40, 'Skeletons', '2:26', 3);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(41, 'Stop Trying to be god', '5:39', 3);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(42, 'Nc-17', '2:37', 3);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(43, 'Stargazing', '4:31', 3);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(44, 'R.I.P. Screw', '3:06', 3);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(45, 'ButterFly Effect', '3:11', 3);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(46, 'Houstonfornication', '3.38', 3);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(47, '5% Tint', '3:16', 3);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(48, 'Coffee Bean', '3:29', 3);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(49, 'AstroThunder', '2:23', 3);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(50, 'Save Your Tears', '3:36', 4);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(51, 'Repeat for Me', '3:16', 4);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(52, 'Faith', '4:43', 4);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(53, 'Scared to Live', '3:11', 4);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(54, 'Bliding Lights', '3:20', 4);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(55, 'Alone Again', '4:10', 4);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(56, 'In your Eyes', '3:20', 4);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(57, 'SnowChild', '4:07', 4);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(58, 'Escape from LA', '5:56', 4);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(59, 'After Hours', '6:01', 4);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(60, 'Too late', '4:00', 4);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(61, 'Heathless', '3:18', 4);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(62, 'Until I bleed Out', '3:10', 4);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(63, 'Hardest to Love', '3:31', 4);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(64, 'Fuck love', '2:27', 5);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(65, 'Ayala', '1:40', 5);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(66, 'Revenge', '2:00', 5);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(67, 'Everybody Dies in their NithMares', '1:36', 5);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(68, 'Jocelyn Flores', '1:59', 5);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(69, 'The Explanation', '0:51', 5);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(70, 'Carry On', '2:10', 5);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(71, 'Dead Inside', '1:27', 5);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(72, 'Orlando', '2:44', 5);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(73, 'Save me', '2:43', 5);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(74, 'Depression & Obsession', '2:25', 5);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(75, 'SuperHero', '3:03', 6);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(76, 'Creepin', '3:42', 6);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(77, 'Feel the fiyaa', '3:10', 6);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(78, 'Niagara Falls', '3:28', 6);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(79, 'Walk Em Down', '5:11', 6);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(80, 'Metro Spider', '2:55', 6);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(81, 'Umbrella', '3:42', 6);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(82, 'On time', '3:42', 6);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(83, 'Trance', '3:15', 6);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(84, 'I Can''t save you', '1:31', 6);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(85, 'Around me', '3:12', 6);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(86, 'Raindrops', '3:09', 6);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(87, 'All the money', '2:48', 6);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(88, 'Lock on Me', '2:55', 6);
INSERT INTO musicalmente.canzone
(id_canzone, titolo_canzone, durata, id_album)
VALUES(89, 'Too many Nights', '3:20', 6);
