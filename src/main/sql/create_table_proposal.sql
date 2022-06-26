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