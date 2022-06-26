  CREATE TABLE hotel (
   id bigint UNSIGNED  auto_increment  NOT NULL,
   create_date TIMESTAMP NOT NULL,
   update_date TIMESTAMP NOT NULL,
   version bigint NOT NULL,
   name VARCHAR(32) NOT NULL,
   country VARCHAR(30) NOT NULL,
   city VARCHAR(30) NOT NULL,
   street VARCHAR(30) NOT NULL,
   building_number VARCHAR(10) NOT NULL,
   PRIMARY KEY (id)
  );