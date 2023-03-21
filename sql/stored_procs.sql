Delimiter #

DROP PROCEDURE IF EXISTS addRandomAnimals#
CREATE PROCEDURE addRandomAnimals(num INT)
BEGIN
	WHILE num > 0 DO
		Insert into Animal (customer_id, animal_type_id, weight_in_kg, dob, price) values 
			(
				FLOOR(1 + RAND() * (SELECT MAX(customer_id) FROM Customer)),
				FLOOR(1 + RAND() * (SELECT MAX(animal_type_id) FROM Animal_Type)), 
				10.0 + RAND() * 100, 
				DATE_ADD(curdate() , INTERVAL -FLOOR(RAND() * 365*10) DAY),
                1000.0 + RAND() * 50000
			)
		;
        SET num = num - 1;
	END WHILE;
END#

DROP PROCEDURE IF EXISTS addRandomAnimalsToOrder#
CREATE PROCEDURE addRandomAnimalsToOrder(buyer_id INT, num_animals INT)
BEGIN
	DROP TEMPORARY TABLE if exists av_animal;
    CREATE TEMPORARY TABLE av_animal(animal_id INT);
    
    INSERT INTO av_animal (animal_id)
	(
		SELECT animal_id FROM availableAnimal
			WHERE customer_id != buyer_id
			ORDER BY RAND()
			LIMIT num_animals
	);
    
    SET @purchase_id = NULL;
    
    SELECT P.purchase_id 
		FROM Purchase P 
		WHERE (buyer_id = P.customer_id and P.status = 0) 
        LIMIT 1 
	INTO @purchase_id;
    
    IF (@purchase_id IS NULL) THEN
		INSERT INTO Purchase (customer_id, status) values (buyer_id, 0);
		SELECT P.purchase_id
			FROM Purchase P
			WHERE (buyer_id = P.customer_id and P.status = 0)
			LIMIT 1
		INTO @purchase_id;
    END IF;
    
	INSERT INTO Purchase_Element (animal_id, purchase_id)
	(
		SELECT animal_id, purchase_id
			FROM av_animal JOIN (SELECT @purchase_id AS purchase_id) AS P
	);
END#

DELIMITER ;