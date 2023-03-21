DELIMITER ;
DROP FUNCTION IF EXISTS getCustomerID;
DELIMITER //

CREATE FUNCTION getCustomerID(user_email VARCHAR(120))
RETURNS INT DETERMINISTIC
BEGIN
    DECLARE user_id INT default -1;
    SELECT U.customer_id
        FROM Customer U
        WHERE (U.email = user_email) INTO user_id;

    RETURN user_id;
END//

DELIMITER ;
