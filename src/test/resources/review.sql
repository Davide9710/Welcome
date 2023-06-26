INSERT INTO theme(id, name)
VALUES (1, 'arte culinaria');
INSERT INTO tour(title, approx_duration, theme_id, city_id, creation_time, last_update, status)
VALUES ('Gita a Trastevere', 100, 1, 1, now(), now(), 'ACTIVE');
INSERT INTO tourist(first_name, last_name)
VALUES ( 'Davide', 'Laureti' );