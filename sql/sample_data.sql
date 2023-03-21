Insert into Customer (first_name, last_name, email) values 
    ('Hewitt','Nyambalo','hnyam@gmail.com'),
    ('Thabang','Khubheka','tkhubheka@gmail.com'),
    ('Lehlohonolo','Moloi','lmoloi@gmail.com')
;

Insert into Animal_Type (animal_name, animal_breed) values
    ('Cow', 'Jersey'),
    ('Cow', 'Holstein-Friesian'),
    ('Sheep', 'Dorper'),
    ('Sheep', 'Merino'),
    ('Sheep', 'Awassi'),
    ('Goat', 'Boer'),
    ('Goat', 'American Pygmy'),
    ('Goat', 'Kiko')
;

CALL addRandomAnimals(30); -- choose how many animals you want to add

CALL addRandomAnimalsToOrder(getCustomerID('hnyam@gmail.com'), 2); -- choose how many animals you want
CALL addRandomAnimalsToOrder(getCustomerID('tkhubheka@gmail.com'), 3);
CALL addRandomAnimalsToOrder(getCustomerID('lmoloi@gmail.com'), 5);