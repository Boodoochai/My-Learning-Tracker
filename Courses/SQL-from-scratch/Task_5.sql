SELECT *
FROM Employees
ORDERED BY Age, Country;

SELECT *
FROM Employees
ORDERED BY Age, Country;
WHERE NOT (Region IS NULL);

SELECT AVG(UnitPrice), MAX(UnitPrice), MIN(UnitPrice)
FROM OrderDetails;

SELECT (COUNT DISTINCT City)
FROM Customers;
