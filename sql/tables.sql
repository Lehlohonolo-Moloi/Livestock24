
DROP DATABASE IF exists LiveStock48;
CREATE DATABASE LiveStock48;
USE Livestock48;

CREATE TABLE Users
(
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    email VARCHAR(120) NOT NULL UNIQUE
);

CREATE TABLE AnimalTypes
(
    type_id int PRIMARY KEY AUTO_INCREMENT,
    animal_name VARCHAR(20) NOT NULL,
    animal_breed VARCHAR(30) NOT NULL
);

CREATE TABLE Animals
(
    animal_id INT PRIMARY KEY AUTO_INCREMENT,
    owner_id INT NOT NULL,
    animal_type_id INT NOT NULL,
    weight_in_kg FLOAT NOT NULL,
    date_of_birth DATE NOT NULL,
    FOREIGN KEY (owner_id) REFERENCES Users(user_id),
    FOREIGN KEY (animal_type_id) REFERENCES AnimalTypes(type_id)
);

CREATE TABLE Orders
(
    order_id INT PRIMARY KEY AUTO_INCREMENT,
    status_id SMALLINT NOT NULL,
    customer_id INT,
    FOREIGN KEY (customer_id) REFERENCES Users(user_id)
);

CREATE TABLE OrderElements
(
    animal_id INT,
    order_id INT,
    FOREIGN KEY (animal_id) REFERENCES Animals(animal_id),
    FOREIGN KEY (order_id) REFERENCES Orders(order_id)
);




