Delimiter #

DROP PROCEDURE IF EXISTS addRandomAnimals#
CREATE PROCEDURE addRandomAnimals(num INT)
BEGIN
	WHILE num > 0 DO
		Insert into Animal (customer_id, animal_type_id, weight_in_kg, dob) values 
			(
				FLOOR(1 + RAND() * (SELECT MAX(customer_id) FROM Customer)),
				FLOOR(1 + RAND() * (SELECT MAX(animal_type_id) FROM Animal_Type)), 
				10.0 + RAND() * 100, 
				DATE_ADD(curdate() , INTERVAL -FLOOR(RAND() * 365*10) DAY)
			)
		;
        SET num = num - 1;
	END WHILE;
END#

DELIMITER ;