-- CREATE TABLES
CREATE TABLE PLAYER(
	id SERIAL,
	name VARCHAR(40)
);

CREATE TABLE PLAYS(
	id SERIAL,
	cd_player INTEGER NOT NULL,
	cell_1 INTEGER NOT NULL,
	cell_2 INTEGER NOT NULL,
	cell_3 INTEGER NOT NULL,
	cell_4 INTEGER NOT NULL,
	cell_5 INTEGER NOT NULL,
	cell_6 INTEGER NOT NULL,
	cell_7 INTEGER NOT NULL,
	cell_8 INTEGER NOT NULL,
	cell_9 INTEGER NOT NULL
);

CREATE TABLE WINNERS(
	id SERIAL,
	cd_player INTEGER NOT NULL
);

-- ADD PRIMARY KEYS ON TABLES
ALTER TABLE PLAYER ADD PRIMARY KEY(id);
ALTER TABLE PLAYS ADD PRIMARY KEY(id);
ALTER TABLE WINNERS ADD PRIMARY KEY(id);

-- ADD FOREIGN KEY
ALTER TABLE PLAYS ADD CONSTRAINT plays_fk_player
FOREIGN KEY(cd_player)
REFERENCES PLAYER(id)
ON DELETE CASCADE;

ALTER TABLE WINNERS ADD CONSTRAINT winners_fk_player
FOREIGN KEY(cd_player)
REFERENCES PLAYER(id)
ON DELETE CASCADE;

-- ADD SOME DATA
INSERT INTO PLAYER(name) VALUES ('VITOR'), ('RAFAEL');

INSERT INTO PLAYS(cd_player, cell_1, cell_2, cell_3, cell_4, cell_5, cell_6, cell_7, cell_8, cell_9) 
VALUES (1, 1, 2, 3, 4, 5, 6, 7, 8, 0), (1, 1, 2, 3, 4, 5, 0, 7, 8, 6), (2, 1, 2, 3, 4, 5, 6, 7, 8, 0), (2, 1, 2, 3, 4, 5, 6, 7, 0, 8);

INSERT INTO WINNERS (cd_player) VALUES (1);
INSERT INTO WINNERS (cd_player) VALUES (2);

-- SELECTS
SELECT * FROM PLAYER;
SELECT * FROM PLAYS;
SELECT * FROM WINNERS;

SELECT (P.name) FROM PLAYER P JOIN
WINNERS W ON P.id = W.cd_player;

SELECT COUNT(cd_player) FROM PLAYS WHERE cd_player = 4;

-- DROP CONSTRAINTS
ALTER TABLE PLAYS DROP CONSTRAINT plays_fk_player;
ALTER TABLE WINNERS DROP CONSTRAINT winners_fk_player

-- DROP TABLES
DROP TABLE PLAYS;
DROP TABLE PLAYER;
DROP TABLE WINNERS;

-- GET PLAYER'S ID WITH NAME
SELECT id FROM PLAYER WHERE name = 'RAFAEL'

-- DELETES
DELETE FROM PLAYER WHERE id = 1

-- UPDATES
UPDATE PLAYS SET
id = 1, 
cell_1 = 2,
cell_2 = 3,
cell_3 = 4,
cell_4 = 6,
cell_5 = 7,
cell_6 = 5,
cell_7 = 1,
cell_8 = 8,
cell_9 = 0
WHERE id = 3;

