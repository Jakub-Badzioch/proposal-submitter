drop schema if exists proposal_submitter_db;

create schema proposal_submitter_db;

use proposal_submitter_db;

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

  CREATE TABLE proposal (
   id bigint UNSIGNED  auto_increment  NOT NULL,
   create_date TIMESTAMP NOT NULL,
   update_date TIMESTAMP NOT NULL,
   version bigint NOT NULL,
   employee_id bigint unsigned,
   hotel_id bigint unsigned,
   trip_type ENUM("PAID_BY_THE_COMPANY", "PAID_BY_THE_CLIENT") NOT NULL,
   trip_reason ENUM("VISIT_TO_THE_CLIENT", "TRAINING", "MARKETING") NOT NULL,
   first_day DATE NOT NULL,
   last_day DATE NOT NULL,
   country VARCHAR(30) NOT NULL,
   city VARCHAR(30) NOT NULL,
   is_trip_with_accommodation BOOLEAN NOT NULL,
   is_accepted BOOLEAN NOT NULL,
   price DECIMAL(15,2) NOT NULL,
   PRIMARY KEY (id),
   FOREIGN KEY (employee_id) REFERENCES employee(id),
   FOREIGN KEY (hotel_id) REFERENCES hotel(id)
  );


  INSERT INTO employee VALUES
(CURRENT_TIMESTAMP,
 CURRENT_TIMESTAMP,
0,
"F",
"Jan",
"Polski",
CURRENT_DATE,
"bodziov3@gmail.com",
"512587425",
"Poland");

select * from employee;

select * from proposal;