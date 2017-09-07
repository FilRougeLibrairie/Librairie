---------------------------------------------
--
--		Address
--
---------------------------------------------

ALTER TABLE Address
ADD CONSTRAINT fkCusResidId
FOREIGN KEY (cusResidId)
REFERENCES Customer(cusId)

ALTER TABLE Address
ADD CONSTRAINT fkCusChargeId
FOREIGN KEY (cusChargeId)
REFERENCES Customer(cusId)

ALTER TABLE Address
ADD CONSTRAINT fkmyLibraryId
FOREIGN KEY (myLibraryId)
REFERENCES MyLibrary(myLibId)


---------------------------------------------
--
--		Purchase
--
---------------------------------------------

ALTER TABLE Purchase
ADD CONSTRAINT fkCusId
FOREIGN KEY (cusId)
REFERENCES Customer(cusId)

ALTER TABLE Purchase
ADD CONSTRAINT fkShippingCostId
FOREIGN KEY (shippingCostId)
REFERENCES ShippingCost(shipId)

ALTER TABLE Purchase
ADD CONSTRAINT fkAddDeliveryId
FOREIGN KEY (addDeliveryId)
REFERENCES Address(addId)

ALTER TABLE Purchase
ADD CONSTRAINT fkAddInvoiceId
FOREIGN KEY (addInvoiceId)
REFERENCES Address(addId)

---------------------------------------------
--
--		Payment
--
---------------------------------------------

ALTER TABLE Payment
ADD CONSTRAINT fkPurId
FOREIGN KEY (purId)
REFERENCES Purchase(purId)


---------------------------------------------
--
--		Determinate
--
---------------------------------------------

ALTER TABLE Determinate
ADD CONSTRAINT fkDeterminateStaId
FOREIGN KEY (staId)
REFERENCES OrderStatus(staId)

ALTER TABLE Determinate
ADD CONSTRAINT fkDeterminatePurId
FOREIGN KEY (purId)
REFERENCES Purchase(purId)



