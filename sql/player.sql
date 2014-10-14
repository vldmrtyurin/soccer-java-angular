CREATE TABLE player
(
    player_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    country_id INT NOT NULL,
    club_id INT NOT NULL,
    name VARCHAR(45) DEFAULT '' NOT NULL,
    num INT DEFAULT 0 NOT NULL,
    birth_date DATE DEFAULT '1900-01-01' NOT NULL,
    FOREIGN KEY (country_id) REFERENCES country (country_id) ON DELETE CASCADE,
    FOREIGN KEY (club_id) REFERENCES club (club_id) ON DELETE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=0;


INSERT INTO soccerdb.player (player_id, country_id, club_id, name, num, birth_date) VALUES (2, 31, 1, 'Халк', 7, '1986-07-25');
INSERT INTO soccerdb.player (player_id, country_id, club_id, name, num, birth_date) VALUES (3, 191, 2, 'Акинфеев Игорь', 1, '1986-04-08');
INSERT INTO soccerdb.player (player_id, country_id, club_id, name, num, birth_date) VALUES (31, 191, 1, 'Смольников Игорь', 19, '1988-08-08');
INSERT INTO soccerdb.player (player_id, country_id, club_id, name, num, birth_date) VALUES (82, 191, 1, 'Малафеев Вячеслав', 16, '1979-03-04');
INSERT INTO soccerdb.player (player_id, country_id, club_id, name, num, birth_date) VALUES (83, 191, 1, 'Анюков Александр', 2, '1982-09-28');
INSERT INTO soccerdb.player (player_id, country_id, club_id, name, num, birth_date) VALUES (84, 20, 1, 'Ломбертс Николас', 6, '1985-03-20');
