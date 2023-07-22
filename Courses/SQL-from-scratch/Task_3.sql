SELECT ProductName, UnitsInStock FROM Products;
SELECT ProductName, UnitPrice FROM Products WHERE UnitPrice < 20;
SELECT * FROM Orders WHERE (freight > 11.7) AND (freight < 98.1);
SELECT * FROM Employees WHERE ;
SELECT * FROM Suppliers WHERE Country = "JP";
SELECT * FROM Orders WHERE (EmployeeID = 2) OR (EmployeeID = 4) OR (EmployeeID = 8);
SELECT OrderID, ProductID FROM OrderDetails WHERE (UnitPrice > 40) AND (Quantity < 10);
