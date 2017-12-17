CREATE TABLE user (
id int(11) NOT NULL AUTO_INCREMENT,
username varchar(50) DEFAULT NULL,
password varchar(50) DEFAULT NULL,
PRIMARY KEY(id)
);

CREATE TABLE game (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(50) DEFAULT NULL,
  owner int(11) NOT NULL,
  winner int(11) DEFAULT NULL,
  map_size_x int(11) NOT NULL,
  map_size_y int(11) NOT NULL,
  max_user int(11) NOT NULL,
  nb_init_res int(11) NOT NULL,
  nb_res_turn int(11) NOT NULL,
  time_turn int(11) NOT NULL,
  carte int(11) DEFAULT NULL,
  current_turn int(11) DEFAULT 0,
  status ENUM('awayting','InProgress','finish'),
  PRIMARY KEY (id),
  FOREIGN KEY (owner) REFERENCES user(id),
  FOREIGN KEY (winner) REFERENCES user(id)
);

CREATE TABLE joueur (
  id_user int(11) NOT NULL,
  id_game int(11) NOT NULL,
  PRIMARY KEY (id_user, id_game),
  FOREIGN KEY (id_user) REFERENCES user(id),
  FOREIGN KEY (id_game) REFERENCES game(id)
);

CREATE TABLE carte (
  id int(11) NOT NULL,
  x int(11) NOT NULL,
  y int(11) NOT NULL,
  type ENUM('plaine', 'champs', 'montagne'),
  FOREIGN KEY (id) REFERENCES game(id)
);

CREATE TABLE ville(
  id int(11) NOT NULL AUTO_INCREMENT,
  id_carte int(11) NOT NULL,
  id_joueur int(11) NOT NULL,
  x int(11) NOT NULL,
  y int(11) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE armee(
  id int(11) NOT NULL AUTO_INCREMENT,
  id_carte int(11) NOT NULL,
  id_joueur int(11) NOT NULL,
  x int(11) NOT NULL,
  y int(11) NOT NULL,
  PRIMARY KEY (id)
);