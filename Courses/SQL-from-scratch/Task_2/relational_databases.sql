Employees.ReportsTo -> Employees.EmployID (один-ко-многим)
Products.SupplierID -> Suppliers.SupplierID (один-ко-многим)
Products.CategoryID -> Categories.CategoryID (один-ко-многим)
Territories.RegionID -> Region.RegionID (один-ко-многим)
Orders.EmployeeID -> Emloyees.EmployeeID (один-ко-многим)
Orders.Customer -> Customers.CustomerID (один-ко-многим)
Orders.ShipVia -> Shippers.ShipperID (один-ко-многим)
Orders <-> OrderDetatails <-> Products (многие-ко-многим)
В одном заказе может быть несколько продуктов и один продукт может быть в нескольких заказах.
Employees <-> EmployeeTerritories <-> Territories (многие-ко-многим)
Одному работнику может соответствовать несколько территорий и одна территория может соответствовать нескольким работникам.
