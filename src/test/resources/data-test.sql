INSERT INTO theme(id, name)
VALUES (1, 'arte culinaria');
INSERT INTO tour(title, approx_duration, theme_id, city_id, creation_time, last_update, status)
VALUES ('Gita a Trastevere', 100, 1, 1, now(), now(), 'ACTIVE');
INSERT INTO review(id, creation_timestamp, stars, tour_id )
VALUES ( 1, now(), 5, 1);
INSERT INTO review(id, creation_timestamp, stars, tour_id )
VALUES ( 2, now(), 2, 1);