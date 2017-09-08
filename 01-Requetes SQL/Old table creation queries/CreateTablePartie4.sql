CREATE TABLE Book (
   booIsbn13 varchar(13) NOT NULL,
   vatId numeric,
   revId numeric,
   ediName varchar(50),
   booTitle varchar(50) NOT NULL,
   booSubtitle varchar(50),
   booPublishYear datetime NOT NULL,
   booPriceHT money NOT NULL,
   booResume varchar(255),
   booQuantity int,
   booStatus tinyint NOT NULL,
   booFrontCover varchar(255),
   booPageNumber int
   
   
);



CREATE TABLE Event (
 eveId numeric identity(1,1) NOT NULL,
 eveName varchar(50) NOT NULL,
 eveText varchar(255),
 eveDateStart datetime NOT NULL,
 eveDateEnd datetime,
 eveDiscount float,
 evePicture varchar(255)
   
   
);



CREATE TABLE SubTheme (
subId numeric identity(1,1) NOT NULL,
theId numeric,
subName varchar(50) NOT NULL,
subDescription varchar(255)

);


 
CREATE TABLE Editor (
ediName varchar(50) NOT NULL,
ediPresentation varchar(255),
ediStatusCode tinyint NOT NULL

);



CREATE TABLE Writing (
booIsbn13 varchar(13) NOT NULL,
autId numeric NOT NULL

);

 
CREATE TABLE Have (

eveId numeric NOT NULL,
booIsbn13 varchar(13) NOT NULL


);



CREATE TABLE Theme (

theId numeric identity(1,1) NOT NULL,
theName varchar(50) NOT NULL,
theDescription varchar(255)


);



CREATE TABLE Association (

booIsbn13 varchar(13) NOT NULL,
subId numeric NOT NULL

);



CREATE TABLE Vat (

vatId numeric identity(1,1) NOT NULL,
vatRate float NOT NULL,
vatName varchar(20) NOT NULL

);