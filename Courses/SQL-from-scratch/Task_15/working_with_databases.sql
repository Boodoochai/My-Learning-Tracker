CREATE TABLE Territories(
  TerritoryID nvarchar(20),
  TerritoryDescription nvarchar(50),
  RegionID int);

INSERT INTO Region VALUES (1, 'East'), (2, 'West');

INSERT INTO Territories VALUES (1, 'China', 1), (2, 'USA', 2);
