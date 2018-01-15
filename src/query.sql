/*CREATE DATABASE netflix;*/
USE netflix;
 
DROP TABLE IF EXISTS languages;
DROP TABLE IF EXISTS views;
DROP TABLE IF EXISTS profiles;
DROP TABLE IF EXISTS subscribers;
DROP TABLE IF EXISTS episodes;
DROP TABLE IF EXISTS movies;
DROP TABLE IF EXISTS programs;
 
 
CREATE TABLE languages
(
    code VARCHAR(2) NOT NULL PRIMARY KEY,
    name VARCHAR(32) NOT NULL
)
 
INSERT INTO languages(code, name) VALUES('en', 'Engels');
INSERT INTO languages(code, name) VALUES('nl', 'Nederlands');
INSERT INTO languages(code, name) VALUES('fr', 'Frans');
INSERT INTO languages(code, name) VALUES('de', 'Duits');
 
CREATE TABLE subscribers
(
    id INT NOT NULL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    city VARCHAR(100) NOT NULL,
    address VARCHAR(100) NOT NULL
)

CREATE TABLE profiles
(
    id INT NOT NULL PRIMARY KEY,
	subscriber int NOT NULL,
    name VARCHAR(100) NOT NULL,
    birthday DATE NOT NULL,
 
    CONSTRAINT profilesFK1
        FOREIGN KEY (subscriber)
            REFERENCES subscribers(id)
            ON DELETE CASCADE
            ON UPDATE CASCADE
 
)

CREATE TABLE programs
(
    id INT NOT NULL PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    genre VARCHAR(16) NOT NULL CHECK (genre IN('action', 'documentary', 'comedy', 'horror', 'thriller')),
    language VARCHAR(2) NOT NULL,
    ageminimum INT NOT NULL,
    ismovie INT NOT NULL CHECK (ismovie IN(0, 1))
    /* De lengte van een programma wordt in movies & episodes bijgehouden, en in het Java systeem berekend */
)

CREATE TABLE episodes
(
    program INT NOT NULL,
    episodeid VARCHAR(10) NOT NULL,
    title VARCHAR(50) NOT NULL,
    length INT NOT NULL, /* length in minutes */
 
 
    CONSTRAINT episodesFK
        FOREIGN KEY (program)
            REFERENCES programs(id),
    CONSTRAINT episodesPK
        PRIMARY KEY (program, episodeid)
)

CREATE TABLE movies
(
    program INT NOT NULL,
    length INT NOT NULL,
 
   
    CONSTRAINT moviesFK
        FOREIGN KEY (program)
            REFERENCES programs(id)
            ON DELETE CASCADE
            ON UPDATE CASCADE
)


 
CREATE TABLE views
(
    id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    profile INT NOT NULL,
    program INT NOT NULL,
	episodeid varchar(10) DEFAULT NULL,
    length INT NOT NULL,
 
    CONSTRAINT viewsFK1
        FOREIGN KEY (profile)
            REFERENCES profiles(id)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
	CONSTRAINT viewsFK2
		FOREIGN KEY (program, episodeid)
			REFERENCES episodes(program, episodeid)
			ON DELETE CASCADE
			ON UPDATE CASCADE
)


INSERT INTO subscribers(id, name, city, address) VALUES(1, 'Fam. van Raalte','Houten',  'Schopenhauerdijkje 5');
INSERT INTO subscribers(id, name, city, address) VALUES(2, 'J. van Betlehem','Breda',  'Nietzschestraat 99');
INSERT INTO subscribers(id, name, city, address) VALUES(3, 'Fam. van Raalte','Breda',  'Kantlaan 11');
 
INSERT INTO profiles VALUES (1, 1, 'profiel 1', '01-01-1999')
INSERT INTO profiles VALUES (2, 1, 'profiel 2', '01-01-1999')
INSERT INTO profiles VALUES (3, 1, 'profiel 3', '01-01-1999')
INSERT INTO profiles VALUES (4, 2, 'profiel 4', '01-01-1999')
INSERT INTO profiles VALUES (5, 2, 'profiel 5', '01-01-1999')
INSERT INTO profiles VALUES (6, 2, 'profiel 6', '01-01-1999')
INSERT INTO profiles VALUES (7, 3, 'profiel 7', '01-01-1999')
INSERT INTO profiles VALUES (8, 3, 'profiel 8', '01-01-1999')

INSERT INTO programs(id, title, genre, language,ageminimum,ismovie)	VALUES(1, 'The Abominable Bride', 'action', 'en', '12', 1)
INSERT INTO programs(id, title, genre, language,ageminimum,ismovie)	VALUES(2, 'Pulp Fiction', 'comedy', 'en', '16', 1)
INSERT INTO programs(id, title, genre, language,ageminimum,ismovie)	VALUES(3, 'The Good, the Bad and the Ugly', 'thriller', 'en', '16', 1)
INSERT INTO programs(id, title, genre, language,ageminimum,ismovie)	VALUES(4, 'Der Untergang', 'action', 'en', '6', 1)

INSERT INTO programs(id, title, genre, language,ageminimum,ismovie)	VALUES(5, 'Sherlock', 'action', 'en', '16', 0)
INSERT INTO programs(id, title, genre, language,ageminimum,ismovie)	VALUES(6, 'Breaking Bad', 'action', 'en', '16', 0)
INSERT INTO programs(id, title, genre, language,ageminimum,ismovie)	VALUES(7, 'How I Met Your Mother', 'comedy', 'en', '16', 0)


INSERT INTO movies(program, length) VALUES(1, 123)
INSERT INTO movies(program, length) VALUES(2, 200)
INSERT INTO movies(program, length) VALUES(3, 73)
INSERT INTO movies(program, length) VALUES(4, 108)

INSERT INTO episodes VALUES (5, 'S01E01', 'Episode 1', 22)
INSERT INTO episodes VALUES (5, 'S01E02', 'Episode 2', 22)
INSERT INTO episodes VALUES (5, 'S01E03', 'Episode 3', 22)
INSERT INTO episodes VALUES (5, 'S01E04', 'Episode 4', 22)
INSERT INTO episodes VALUES (5, 'S01E05', 'Episode 5', 22)
INSERT INTO episodes VALUES (6, 'S01E01', 'Episode 1', 22)
INSERT INTO episodes VALUES (6, 'S01E02', 'Episode 2', 22)
INSERT INTO episodes VALUES (6, 'S01E03', 'Episode 3', 22)
INSERT INTO episodes VALUES (6, 'S01E04', 'Episode 4', 22)
INSERT INTO episodes VALUES (6, 'S01E05', 'Episode 5', 22)
INSERT INTO episodes VALUES (7, 'S01E01', 'Episode 1', 22)
INSERT INTO episodes VALUES (7, 'S01E02', 'Episode 2', 22)
INSERT INTO episodes VALUES (7, 'S01E03', 'Episode 3', 22)
INSERT INTO episodes VALUES (7, 'S01E04', 'Episode 4', 22)
INSERT INTO episodes VALUES (7, 'S01E05', 'Episode 5', 22)
 
INSERT INTO views (profile, program, episodeid, length) VALUES (1, 1, null, 59)
INSERT INTO views (profile, program, episodeid, length) VALUES (1, 2, null, 63)
INSERT INTO views (profile, program, episodeid, length) VALUES (1, 3, null, 88)
INSERT INTO views (profile, program, episodeid, length) VALUES (1, 4, null, 30)
INSERT INTO views (profile, program, episodeid, length) VALUES (1, 5, 'S01E01', 12)
INSERT INTO views (profile, program, episodeid, length) VALUES (1, 5, 'S01E02', 13)
INSERT INTO views (profile, program, episodeid, length) VALUES (1, 5, 'S01E03', 17)
INSERT INTO views (profile, program, episodeid, length) VALUES (1, 5, 'S01E04', 16)
INSERT INTO views (profile, program, episodeid, length) VALUES (1, 5, 'S01E05', 22)
INSERT INTO views (profile, program, episodeid, length) VALUES (1, 6, 'S01E01', 21)
INSERT INTO views (profile, program, episodeid, length) VALUES (1, 6, 'S01E02', 18)
INSERT INTO views (profile, program, episodeid, length) VALUES (1, 6, 'S01E03', 1)
INSERT INTO views (profile, program, episodeid, length) VALUES (1, 6, 'S01E04', 1)
INSERT INTO views (profile, program, episodeid, length) VALUES (1, 6, 'S01E05', 22)
INSERT INTO views (profile, program, episodeid, length) VALUES (1, 7, 'S01E01', 10)
INSERT INTO views (profile, program, episodeid, length) VALUES (1, 7, 'S01E02', 8)
INSERT INTO views (profile, program, episodeid, length) VALUES (1, 7, 'S01E03', 1)
INSERT INTO views (profile, program, episodeid, length) VALUES (1, 7, 'S01E04', 19)
INSERT INTO views (profile, program, episodeid, length) VALUES (1, 7, 'S01E05', 20)
INSERT INTO views (profile, program, episodeid, length) VALUES (2, 1, null, 59)
INSERT INTO views (profile, program, episodeid, length) VALUES (2, 2, null, 63)
INSERT INTO views (profile, program, episodeid, length) VALUES (2, 3, null, 88)
INSERT INTO views (profile, program, episodeid, length) VALUES (2, 4, null, 30)
INSERT INTO views (profile, program, episodeid, length) VALUES (2, 5, 'S01E01', 10)
INSERT INTO views (profile, program, episodeid, length) VALUES (2, 5, 'S01E02', 18)
INSERT INTO views (profile, program, episodeid, length) VALUES (2, 5, 'S01E03', 1)
INSERT INTO views (profile, program, episodeid, length) VALUES (2, 5, 'S01E04', 19)
INSERT INTO views (profile, program, episodeid, length) VALUES (2, 5, 'S01E05', 22)
INSERT INTO views (profile, program, episodeid, length) VALUES (2, 6, 'S01E01', 10)
INSERT INTO views (profile, program, episodeid, length) VALUES (2, 6, 'S01E02', 13)
INSERT INTO views (profile, program, episodeid, length) VALUES (2, 6, 'S01E03', 1)
INSERT INTO views (profile, program, episodeid, length) VALUES (2, 6, 'S01E04', 19)
INSERT INTO views (profile, program, episodeid, length) VALUES (2, 6, 'S01E05', 22)
INSERT INTO views (profile, program, episodeid, length) VALUES (2, 7, 'S01E01', 10)
INSERT INTO views (profile, program, episodeid, length) VALUES (2, 7, 'S01E02', 18)
INSERT INTO views (profile, program, episodeid, length) VALUES (2, 7, 'S01E03', 1)
INSERT INTO views (profile, program, episodeid, length) VALUES (2, 7, 'S01E04', 11)
INSERT INTO views (profile, program, episodeid, length) VALUES (2, 7, 'S01E05', 22)
INSERT INTO views (profile, program, episodeid, length) VALUES (3, 1, null, 59)
INSERT INTO views (profile, program, episodeid, length) VALUES (3, 2, null, 63)
INSERT INTO views (profile, program, episodeid, length) VALUES (3, 3, null, 88)
INSERT INTO views (profile, program, episodeid, length) VALUES (3, 4, null, 30)
INSERT INTO views (profile, program, episodeid, length) VALUES (3, 5, 'S01E01', 10)
INSERT INTO views (profile, program, episodeid, length) VALUES (3, 5, 'S01E02', 18)
INSERT INTO views (profile, program, episodeid, length) VALUES (3, 5, 'S01E03', 1)
INSERT INTO views (profile, program, episodeid, length) VALUES (3, 5, 'S01E04', 19)
INSERT INTO views (profile, program, episodeid, length) VALUES (3, 5, 'S01E05', 22)
INSERT INTO views (profile, program, episodeid, length) VALUES (3, 6, 'S01E01', 10)
INSERT INTO views (profile, program, episodeid, length) VALUES (3, 6, 'S01E02', 18)
INSERT INTO views (profile, program, episodeid, length) VALUES (3, 6, 'S01E03', 1)
INSERT INTO views (profile, program, episodeid, length) VALUES (3, 6, 'S01E04', 19)
INSERT INTO views (profile, program, episodeid, length) VALUES (3, 6, 'S01E05', 22)
INSERT INTO views (profile, program, episodeid, length) VALUES (3, 7, 'S01E01', 10)
INSERT INTO views (profile, program, episodeid, length) VALUES (3, 7, 'S01E02', 14)
INSERT INTO views (profile, program, episodeid, length) VALUES (3, 7, 'S01E03', 1)
INSERT INTO views (profile, program, episodeid, length) VALUES (3, 7, 'S01E04', 19)
INSERT INTO views (profile, program, episodeid, length) VALUES (3, 7, 'S01E05', 22)
INSERT INTO views (profile, program, episodeid, length) VALUES (4, 1, null, 59)
INSERT INTO views (profile, program, episodeid, length) VALUES (4, 2, null, 63)
INSERT INTO views (profile, program, episodeid, length) VALUES (4, 3, null, 88)
INSERT INTO views (profile, program, episodeid, length) VALUES (4, 4, null, 30)
INSERT INTO views (profile, program, episodeid, length) VALUES (4, 5, 'S01E01', 10)
INSERT INTO views (profile, program, episodeid, length) VALUES (4, 5, 'S01E02', 18)
INSERT INTO views (profile, program, episodeid, length) VALUES (4, 5, 'S01E03', 1)
INSERT INTO views (profile, program, episodeid, length) VALUES (4, 5, 'S01E04', 19)
INSERT INTO views (profile, program, episodeid, length) VALUES (4, 5, 'S01E05', 22)
INSERT INTO views (profile, program, episodeid, length) VALUES (4, 6, 'S01E01', 10)
INSERT INTO views (profile, program, episodeid, length) VALUES (4, 6, 'S01E02', 18)
INSERT INTO views (profile, program, episodeid, length) VALUES (4, 6, 'S01E03', 1)
INSERT INTO views (profile, program, episodeid, length) VALUES (4, 6, 'S01E04', 19)
INSERT INTO views (profile, program, episodeid, length) VALUES (4, 6, 'S01E05', 22)
INSERT INTO views (profile, program, episodeid, length) VALUES (4, 7, 'S01E01', 10)
INSERT INTO views (profile, program, episodeid, length) VALUES (4, 7, 'S01E02', 18)
INSERT INTO views (profile, program, episodeid, length) VALUES (4, 7, 'S01E03', 1)
INSERT INTO views (profile, program, episodeid, length) VALUES (4, 7, 'S01E04', 19)
INSERT INTO views (profile, program, episodeid, length) VALUES (4, 7, 'S01E05', 22)
INSERT INTO views (profile, program, episodeid, length) VALUES (5, 1, null, 59)
INSERT INTO views (profile, program, episodeid, length) VALUES (5, 2, null, 63)
INSERT INTO views (profile, program, episodeid, length) VALUES (5, 3, null, 88)
INSERT INTO views (profile, program, episodeid, length) VALUES (5, 4, null, 30)
INSERT INTO views (profile, program, episodeid, length) VALUES (5, 5, 'S01E01', 10)
INSERT INTO views (profile, program, episodeid, length) VALUES (5, 5, 'S01E02', 18)
INSERT INTO views (profile, program, episodeid, length) VALUES (5, 5, 'S01E03', 1)
INSERT INTO views (profile, program, episodeid, length) VALUES (5, 5, 'S01E04', 19)
INSERT INTO views (profile, program, episodeid, length) VALUES (5, 5, 'S01E05', 22)
INSERT INTO views (profile, program, episodeid, length) VALUES (5, 6, 'S01E01', 10)
INSERT INTO views (profile, program, episodeid, length) VALUES (5, 6, 'S01E02', 18)
INSERT INTO views (profile, program, episodeid, length) VALUES (5, 6, 'S01E03', 1)
INSERT INTO views (profile, program, episodeid, length) VALUES (5, 6, 'S01E04', 19)
INSERT INTO views (profile, program, episodeid, length) VALUES (5, 6, 'S01E05', 22)
INSERT INTO views (profile, program, episodeid, length) VALUES (5, 7, 'S01E01', 10)
INSERT INTO views (profile, program, episodeid, length) VALUES (5, 7, 'S01E02', 18)
INSERT INTO views (profile, program, episodeid, length) VALUES (5, 7, 'S01E03', 1)
INSERT INTO views (profile, program, episodeid, length) VALUES (5, 7, 'S01E04', 19)
INSERT INTO views (profile, program, episodeid, length) VALUES (5, 7, 'S01E05', 22)
INSERT INTO views (profile, program, episodeid, length) VALUES (6, 1, null, 59)
INSERT INTO views (profile, program, episodeid, length) VALUES (6, 2, null, 63)
INSERT INTO views (profile, program, episodeid, length) VALUES (6, 3, null, 88)
INSERT INTO views (profile, program, episodeid, length) VALUES (6, 4, null, 30)
INSERT INTO views (profile, program, episodeid, length) VALUES (6, 5, 'S01E01', 10)
INSERT INTO views (profile, program, episodeid, length) VALUES (6, 5, 'S01E02', 18)
INSERT INTO views (profile, program, episodeid, length) VALUES (6, 5, 'S01E03', 1)
INSERT INTO views (profile, program, episodeid, length) VALUES (6, 5, 'S01E04', 19)
INSERT INTO views (profile, program, episodeid, length) VALUES (6, 5, 'S01E05', 22)
INSERT INTO views (profile, program, episodeid, length) VALUES (6, 6, 'S01E01', 10)
INSERT INTO views (profile, program, episodeid, length) VALUES (6, 6, 'S01E02', 18)
INSERT INTO views (profile, program, episodeid, length) VALUES (6, 6, 'S01E03', 1)
INSERT INTO views (profile, program, episodeid, length) VALUES (6, 6, 'S01E04', 19)
INSERT INTO views (profile, program, episodeid, length) VALUES (6, 6, 'S01E05', 22)
INSERT INTO views (profile, program, episodeid, length) VALUES (6, 7, 'S01E01', 10)
INSERT INTO views (profile, program, episodeid, length) VALUES (6, 7, 'S01E02', 18)
INSERT INTO views (profile, program, episodeid, length) VALUES (6, 7, 'S01E03', 1)
INSERT INTO views (profile, program, episodeid, length) VALUES (6, 7, 'S01E04', 19)
INSERT INTO views (profile, program, episodeid, length) VALUES (6, 7, 'S01E05', 22)
INSERT INTO views (profile, program, episodeid, length) VALUES (7, 1, null, 59)
INSERT INTO views (profile, program, episodeid, length) VALUES (7, 2, null, 63)
INSERT INTO views (profile, program, episodeid, length) VALUES (7, 3, null, 88)
INSERT INTO views (profile, program, episodeid, length) VALUES (7, 4, null, 30)
INSERT INTO views (profile, program, episodeid, length) VALUES (7, 5, 'S01E01', 10)
INSERT INTO views (profile, program, episodeid, length) VALUES (7, 5, 'S01E02', 18)
INSERT INTO views (profile, program, episodeid, length) VALUES (7, 5, 'S01E03', 1)
INSERT INTO views (profile, program, episodeid, length) VALUES (7, 5, 'S01E04', 19)
INSERT INTO views (profile, program, episodeid, length) VALUES (7, 5, 'S01E05', 22)
INSERT INTO views (profile, program, episodeid, length) VALUES (7, 6, 'S01E01', 10)
INSERT INTO views (profile, program, episodeid, length) VALUES (7, 6, 'S01E02', 18)
INSERT INTO views (profile, program, episodeid, length) VALUES (7, 6, 'S01E03', 1)
INSERT INTO views (profile, program, episodeid, length) VALUES (7, 6, 'S01E04', 19)
INSERT INTO views (profile, program, episodeid, length) VALUES (7, 6, 'S01E05', 22)
INSERT INTO views (profile, program, episodeid, length) VALUES (7, 7, 'S01E01', 10)
INSERT INTO views (profile, program, episodeid, length) VALUES (7, 7, 'S01E02', 18)
INSERT INTO views (profile, program, episodeid, length) VALUES (7, 7, 'S01E03', 1)
INSERT INTO views (profile, program, episodeid, length) VALUES (7, 7, 'S01E04', 19)
INSERT INTO views (profile, program, episodeid, length) VALUES (7, 7, 'S01E05', 22)
INSERT INTO views (profile, program, episodeid, length) VALUES (8, 1, null, 59)
INSERT INTO views (profile, program, episodeid, length) VALUES (8, 2, null, 63)
INSERT INTO views (profile, program, episodeid, length) VALUES (8, 3, null, 88)
INSERT INTO views (profile, program, episodeid, length) VALUES (8, 4, null, 30)
INSERT INTO views (profile, program, episodeid, length) VALUES (8, 5, 'S01E01', 10)
INSERT INTO views (profile, program, episodeid, length) VALUES (8, 5, 'S01E02', 18)
INSERT INTO views (profile, program, episodeid, length) VALUES (8, 5, 'S01E03', 1)
INSERT INTO views (profile, program, episodeid, length) VALUES (8, 5, 'S01E04', 19)
INSERT INTO views (profile, program, episodeid, length) VALUES (8, 5, 'S01E05', 22)
INSERT INTO views (profile, program, episodeid, length) VALUES (8, 6, 'S01E01', 10)
INSERT INTO views (profile, program, episodeid, length) VALUES (8, 6, 'S01E02', 18)
INSERT INTO views (profile, program, episodeid, length) VALUES (8, 6, 'S01E03', 1)
INSERT INTO views (profile, program, episodeid, length) VALUES (8, 6, 'S01E04', 19)
INSERT INTO views (profile, program, episodeid, length) VALUES (8, 6, 'S01E05', 22)
INSERT INTO views (profile, program, episodeid, length) VALUES (8, 7, 'S01E01', 10)
INSERT INTO views (profile, program, episodeid, length) VALUES (8, 7, 'S01E02', 18)
INSERT INTO views (profile, program, episodeid, length) VALUES (8, 7, 'S01E03', 1)
INSERT INTO views (profile, program, episodeid, length) VALUES (8, 7, 'S01E04', 19)
INSERT INTO views (profile, program, episodeid, length) VALUES (8, 7, 'S01E05', 22)



