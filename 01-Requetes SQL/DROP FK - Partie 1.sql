---------------------------------------------
--
--		Address
--
---------------------------------------------

ALTER TABLE Address
DROP CONSTRAINT fkCusResidId

ALTER TABLE Address
DROP CONSTRAINT fkCusChargeId

ALTER TABLE Address
DROP CONSTRAINT fkmyLibraryId


---------------------------------------------
--
--		Purchase
--
---------------------------------------------

ALTER TABLE Purchase
DROP CONSTRAINT fkCusId

ALTER TABLE Purchase
DROP CONSTRAINT fkShippingCostId

ALTER TABLE Purchase
DROP CONSTRAINT fkAddDeliveryId

ALTER TABLE Purchase
DROP CONSTRAINT fkAddInvoiceId

---------------------------------------------
--
--		Payment
--
---------------------------------------------

ALTER TABLE Payment
DROP CONSTRAINT fkPurId


---------------------------------------------
--
--		Determinate
--
---------------------------------------------

ALTER TABLE Determinate
DROP CONSTRAINT fkDeterminateStaId

ALTER TABLE Determinate
DROP CONSTRAINT fkDeterminatePurId



