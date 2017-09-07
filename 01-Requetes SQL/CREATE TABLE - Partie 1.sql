---------------------------------------------
--
--		CREATE MyLibrary
--
---------------------------------------------

CREATE TABLE MyLibrary
(
myLibId BIGINT IDENTITY(1,1) NOT NULL,
myLibName VARCHAR(50) NOT NULL,
myLibLogo VARCHAR(255) NULL,
myLibEmail VARCHAR(50) NULL,
myLibPhone VARCHAR(20) NULL,
myLibSiret VARCHAR(14) NULL,
myLibCGU VARCHAR(MAX) NULL
)


---------------------------------------------
--
--		CREATE StatusDisplay
--
---------------------------------------------

CREATE TABLE StatusDisplay
(
staId BIT NOT NULL,
staValidate BIT NULL
)


---------------------------------------------
--
--		CREATE Address
--
---------------------------------------------

CREATE TABLE Address
(
addId BIGINT IDENTITY(1,1) NOT NULL,
cusResidId BIGINT NOT NULL, -- FK
cusChargeId BIGINT NOT NULL, -- FK
myLibraryId BIGINT NOT NULL, -- FK
addLabel VARCHAR(255) NULL,
addFirstName VARCHAR(50) NULL,
addLastName VARCHAR(50) NULL,
addCompany VARCHAR(50) NULL,
addNumber VARCHAR(10) NULL,
addStreetType VARCHAR(15) NULL,
addStreetName VARCHAR(50) NULL,
addComplement VARCHAR(50) NULL,
addZipCode VARCHAR(10) NULL,
addCity VARCHAR(50) NULL,
addSecurityCode VARCHAR(50) NULL,
addPhone VARCHAR(50) NULL
)


---------------------------------------------
--
--		CREATE Purchase
--
---------------------------------------------

CREATE TABLE Purchase
(
purId BIGINT IDENTITY(57231, 1) NOT NULL,
cusId BIGINT NOT NULL, -- FK
shippingCostId BIGINT NOT NULL, -- FK
addDeliveryId BIGINT NOT NULL, -- FK
addInvoiceId BIGINT NOT NULL, -- FK
purPostage FLOAT NULL,
purIP VARCHAR(50) NULL,
shippingDate DATETIME NULL,
shippingNumber BIGINT NULL
)


---------------------------------------------
--
--		CREATE Payment
--
---------------------------------------------

CREATE TABLE Payment
(
payId INTEGER NOT NULL,
purId BIGINT NOT NULL, -- FK
payValidate BIT NULL,
payChoice VARCHAR(50),
payDate DATETIME
)

---------------------------------------------
--
--		CREATE Determinate
--
---------------------------------------------

CREATE TABLE Determinate
(
staId BIT NOT NULL, -- PK, FK
ordId BIGINT IDENTITY(76527,1), -- PK, FK
detTime DATETIME NOT NULL
)

---------------------------------------------
--
--		CREATE OrderStatus
--
---------------------------------------------

CREATE TABLE OrderStatus
(
staId BIT NOT NULL,
staValidate BIT
)