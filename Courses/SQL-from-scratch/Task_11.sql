SELECT *
FROM Customers LEFT JOIN Orders
ON Orders.CustomerID = Customers.CustomerID
WHERE Orders.OrderID IS Null;

SELECT 'Customer' AS Type, ContactName, City, Country
FROM Customers
UNION ALL
SELECT 'Supplier' AS Type, ContactName, City, Country
FROM Suppliers;
