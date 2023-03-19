DELIMITER ;
DROP FUNCTION IF EXISTS getUserID;
DELIMITER //

CREATE FUNCTION getUserID(user_email VARCHAR(120))
RETURNS INT DETERMINISTIC
BEGIN
    DECLARE user_id INT default -1;
    SELECT U.user_id
        FROM Users U
        WHERE (U.email = user_email) INTO user_id;

    RETURN user_id;
END//

DELIMITER ;
