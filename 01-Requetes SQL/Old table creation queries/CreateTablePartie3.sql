CREATE TABLE OrderLine (
 ordLineId numeric identity(1,1) NOT NULL,
 purId numeric,
 booIsbn13 varchar(13),
 ordLineQuantity int NOT NULL,
 ordBookPriceHT money NOT NULL,
 ordBookVAT float NOT NULL
   
   
);

CREATE TABLE Author (
 autId numeric identity(1,1) NOT NULL,
 autLastName varchar(50) NOT NULL,
 autFirstName varchar(50),
 autBiography varchar(255),
 autStatusCode tinyint
  
   
);

CREATE TABLE ShippingCost (
 shipId numeric identity(1,1) NOT NULL,
 ShipperId numeric,
 shipName varchar(50) NOT NULL,
 shipCost float NOT NULL
   
   
);

CREATE TABLE Shipper (
 ShipperId numeric identity(1,1) NOT NULL,
 ShipperName varchar(50) NOT NULL
 );

 CREATE TABLE Formats (
 forName varchar(50) NOT NULL
 );

 CREATE TABLE Keywords (
 keyName varchar(50) NOT NULL
 );

 CREATE TABLE Possession (
 forName varchar(50) NOT NULL,
 booIsbn13 varchar(13) NOT NULL
 );

  CREATE TABLE Definitions (
 keyName varchar(50) NOT NULL,
 booIsbn13 varchar(13) NOT NULL
 );

  CREATE TABLE BookLanguage (
 bookLangCode varchar(50) NOT NULL,
 bookLangName varchar(50) NOT NULL
 );


 