CREATE INDEX idxTerritoryRegionId ON Territories (RegionId);

CREATE CLUSTERED INDEX idxTerritoriesId ON Territories (TerritoryID);

CREATE CLUSTERED INDEX idxRegionId ON Region (RegionID);
