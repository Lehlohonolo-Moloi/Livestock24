
DROP VIEW IF EXISTS availableAnimal;

CREATE VIEW availableAnimal AS
	SELECT A.* 
		FROM Animal A LEFT JOIN Purchase_Element PE 
		ON A.animal_id = PE.animal_id
        WHERE PE.animal_id IS NULL
	;
;