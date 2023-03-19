Delimiter #

DROP PROCEDURE IF EXISTS addRandomAnimals#
CREATE PROCEDURE addRandomAnimals(num INT)
BEGIN
	WHILE num > 0 DO
		Insert into Animals (owner_id, animal_type_id, weight_in_kg, date_of_birth) values 
			(
				FLOOR(1 + RAND() * (SELECT MAX(user_id) FROM Users)),
				FLOOR(1 + RAND() * (SELECT MAX(type_id) FROM AnimalTypes)), 
				10.0 + RAND() * 100, 
				DATE_ADD(curdate() , INTERVAL -FLOOR(RAND() * 365*10) DAY)
			)
		;
        SET num = num - 1;
	END WHILE;
END#

DELIMITER ;