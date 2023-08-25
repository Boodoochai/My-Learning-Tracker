UPDATE [Order Details]
SET Discount = 0.2
WHERE Quantity > 50;

UPDATE Contacts
SET City = 'Piter', Country = 'Russia'
WHERE City = 'Berlin' AND Country = 'Germmany';

// Удалил все записи, у которых ID больше 3
