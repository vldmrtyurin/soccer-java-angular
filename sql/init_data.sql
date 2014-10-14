INSERT INTO soccerdb.STADIUM VALUES (1, 179, 'Петровский', 'Санкт-Петербург');
INSERT INTO soccerdb.STADIUM VALUES (2, 179, 'Спартак', 'Москва');
INSERT INTO soccerdb.STADIUM VALUES (3, 179, 'Лужники', 'Москва');
INSERT INTO soccerdb.STADIUM VALUES (4, 179, 'Динамо', 'Москва');

INSERT INTO soccerdb.POSITION (POSITION_ID, NAME) VALUES (1, 'Goalkeeper');
INSERT INTO soccerdb.POSITION (POSITION_ID, NAME) VALUES (2, 'Defender');
INSERT INTO soccerdb.POSITION (POSITION_ID, NAME) VALUES (3, 'Midfielder');
INSERT INTO soccerdb.POSITION (POSITION_ID, NAME) VALUES (4, 'Attacker');

INSERT INTO soccerdb.CLUB (CLUB_ID, COUNTRY_ID, NAME, CITY, SITE, LOGO) VALUES (1, 179, 'FC Zenit Saint Petersburg', 'Saint-Petersburg', 'http://www.fc-zenit.ru/', 'fc_zenit_spb_logo.png');
INSERT INTO soccerdb.CLUB (CLUB_ID, COUNTRY_ID, NAME, CITY, SITE, LOGO) VALUES (2, 179, 'PFC CSKA Moscow', 'Moscow', 'http://pfc-cska.com/', 'pfc_cska_moscow_logo.png');
INSERT INTO soccerdb.CLUB (CLUB_ID, COUNTRY_ID, NAME, CITY, SITE, LOGO) VALUES (3, 179,'FC Dynamo Moscow', 'Moscow', 'http://fcdynamo.ru/', 'dynamo_moscow_logo.png');
INSERT INTO soccerdb.CLUB (CLUB_ID, COUNTRY_ID, NAME, CITY, SITE, LOGO) VALUES (4, 199, 'FC Barcelona', 'Barselona', '', '');
INSERT INTO soccerdb.CLUB (CLUB_ID, COUNTRY_ID, NAME, CITY, SITE, LOGO) VALUES (5, 199, 'Real Madrid C.F.', 'Madrid', '', '');
INSERT INTO soccerdb.CLUB (CLUB_ID, COUNTRY_ID, NAME, CITY, SITE, LOGO) VALUES (6, 199, 'Atletico Madrid', 'Madrid', '', '');
INSERT INTO soccerdb.CLUB (CLUB_ID, COUNTRY_ID, NAME, CITY, SITE, LOGO) VALUES (7, 105, 'A.S. Roma', 'Rome', '', '');
INSERT INTO soccerdb.PLAYER (PLAYER_ID, COUNTRY_ID, NAME, SQUAD_NUMBER, BIRTH_DATE, POSITION_ID) VALUES (1, 31, 'Халк', 7, '1986-07-25', 4);
INSERT INTO soccerdb.PLAYER (PLAYER_ID, COUNTRY_ID, NAME, SQUAD_NUMBER, BIRTH_DATE, POSITION_ID) VALUES (2, 179, 'Акинфеев Игорь', 1, '1986-04-08', 1);
INSERT INTO soccerdb.PLAYER (PLAYER_ID, COUNTRY_ID, NAME, SQUAD_NUMBER, BIRTH_DATE, POSITION_ID) VALUES (3, 179, 'Смольников Игорь', 19, '1988-08-08', 3);
INSERT INTO soccerdb.PLAYER (PLAYER_ID, COUNTRY_ID, NAME, SQUAD_NUMBER, BIRTH_DATE, POSITION_ID) VALUES (4, 179, 'Малафеев Вячеслав', 16, '1979-03-04', 1);
INSERT INTO soccerdb.PLAYER (PLAYER_ID, COUNTRY_ID, NAME, SQUAD_NUMBER, BIRTH_DATE, POSITION_ID) VALUES (5, 179, 'Анюков Александр', 2, '1982-09-28', 2);
INSERT INTO soccerdb.PLAYER (PLAYER_ID, COUNTRY_ID, NAME, SQUAD_NUMBER, BIRTH_DATE, POSITION_ID) VALUES (6, 20, 'Ломбертс Николас', 6, '1985-03-20', 2);

