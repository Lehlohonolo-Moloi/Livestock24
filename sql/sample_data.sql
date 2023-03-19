Insert into Users (first_name, last_name, email) values 
    ('Hewitt','Nyambalo','hnyam@gmail.com'),
    ('Thabang','Khubheka','tkhubheka@gmail.com'),
    ('Lehlohonolo','Moloi','lmoloi@gmail.com')
;

Insert into AnimalTypes (animal_name, animal_breed) values
    ('Cow', 'Jersey'),
    ('Cow', 'Holstein-Friesian'),
    ('Sheep', 'Dorper'),
    ('Sheep', 'Merino'),
    ('Sheep', 'Awassi'),
    ('Goat', 'Boer'),
    ('Goat', 'American Pygmy'),
    ('Goat', 'Kiko')
;

CALL addRandomAnimals(10); -- choose how many animals you want to add