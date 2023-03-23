DROP DATABASE IF exists LiveStock;
CREATE DATABASE LiveStock;
USE Livestock;

CREATE TABLE Customer
(
    customer_id bigint PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    email VARCHAR(120) NOT NULL UNIQUE
);

CREATE TABLE Animal_Type
(
    animal_type_id bigint PRIMARY KEY AUTO_INCREMENT,
    animal_name VARCHAR(20) NOT NULL,
    animal_breed VARCHAR(30) NOT NULL
);

CREATE TABLE Animal
(
    animal_id bigint PRIMARY KEY AUTO_INCREMENT,
    customer_id bigint NOT NULL,
    animal_type_id bigint NOT NULL,
    weight_in_kg FLOAT NOT NULL,
    dob DATE NOT NULL,
    price float NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES Customer(customer_id),
    FOREIGN KEY (animal_type_id) REFERENCES Animal_Type(animal_type_id)
);

CREATE TABLE Purchase
(
    purchase_id bigint PRIMARY KEY AUTO_INCREMENT,
    status bit NOT NULL DEFAULT 0,
    purchase_date DATE default '9999-12-31',
    customer_id bigint,
    FOREIGN KEY (customer_id) REFERENCES Customer(customer_id)
);

CREATE TABLE Purchase_Element
(
	purchase_element_id bigint PRIMARY KEY auto_increment,
    animal_id bigint,
    purchase_id bigint,
    FOREIGN KEY (animal_id) REFERENCES Animal(animal_id),
    FOREIGN KEY (purchase_id) REFERENCES Purchase(purchase_id)
);