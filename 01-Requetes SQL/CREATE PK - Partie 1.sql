---------------------------------------------
--
--		MyLibrary
--
---------------------------------------------

ALTER TABLE MyLibrary
ADD CONSTRAINT pkMyLibId
PRIMARY KEY myLibId


---------------------------------------------
--
--		StatusDisplay
--
---------------------------------------------

ALTER TABLE StatusDisplay
ADD CONSTRAINT pkStaCode
PRIMARY KEY staId

---------------------------------------------
--
--		Address
--
---------------------------------------------

ALTER TABLE Address
ADD CONSTRAINT pkaddId
PRIMARY KEY addId

---------------------------------------------
--
--		Purchase
--
---------------------------------------------

ALTER TABLE Purchase
ADD CONSTRAINT pkpurId
PRIMARY KEY purId

---------------------------------------------
--
--		Payment
--
---------------------------------------------

ALTER TABLE Payment
ADD CONSTRAINT pkpayId
PRIMARY KEY payId


---------------------------------------------
--
--		OrderStatus
--
---------------------------------------------

ALTER TABLE OrderStatus
ADD CONSTRAINT pkStatId
PRIMARY KEY staId


---------------------------------------------
--
--		Determinate
--
---------------------------------------------

ALTER TABLE Determinate
ADD CONSTRAINT pkDeterminate
PRIMARY KEY (staId, purId)



