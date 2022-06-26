CREATE TABLE employee (
  id bigint UNSIGNED auto_increment NOT NULL,
  create_date TIMESTAMP NOT NULL,
  update_date TIMESTAMP NOT NULL,
  version bigint NOT NULL,
  grade ENUM("A", "B", "C", "D", "E", "F") NOT NULL,
  first_name VARCHAR(32) NOT NULL,
  last_name VARCHAR(32) NOT NULL,
  birth_date DATE NOT NULL,
  email VARCHAR(40) NOT NULL,
  telephone_number VARCHAR(20) NOT NULL,
  country VARCHAR(30) NOT NULL,
  PRIMARY KEY (id)
  );