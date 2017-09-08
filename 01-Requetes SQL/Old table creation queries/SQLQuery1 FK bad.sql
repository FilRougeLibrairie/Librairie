USE MyLibrary

ALTER TABLE GettingAccess
ADD CONSTRAINT fkAccessProfil
FOREIGN KEY (accProfilID)
REFERENCES AccessProfile (accProfilId)

ALTER TABLE GettingAccess
ADD CONSTRAINT fkAccessProEmploye
FOREIGN KEY (empId)
REFERENCES Employee (empId)

ALTER TABLE Book
ADD CONSTRAINT fkBooVat
FOREIGN KEY (vatId)
REFERENCES Vat (vatId)

ALTER TABLE Book
ADD CONSTRAINT fkBooLang
FOREIGN KEY (bookLangCode)
REFERENCES BookLanguage (bookLangCode)

ALTER TABLE Book
ADD CONSTRAINT fkBooEdi
FOREIGN KEY (ediName)
REFERENCES Editor (ediName)

ALTER TABLE SubTheme
ADD CONSTRAINT fkTheme
FOREIGN KEY (theId)
REFERENCES Theme (theId)

ALTER TABLE Association
ADD CONSTRAINT fkBooAsso
FOREIGN KEY (booIsbn13)
REFERENCES Book (booIsbn13)

ALTER TABLE Association
ADD CONSTRAINT fkBooSubT
FOREIGN KEY (subId)
REFERENCES SubTheme (subId)

ALTER TABLE Have
ADD CONSTRAINT fkOfferHave
FOREIGN KEY (offID)
REFERENCES Offer (offID)

ALTER TABLE Have
ADD CONSTRAINT fkBooHave
FOREIGN KEY (booIsbn13)
REFERENCES Book (booIsbn13)

ALTER TABLE Writing
ADD CONSTRAINT fkBooWriting
FOREIGN KEY (booIsbn13)
REFERENCES Book (booIsbn13)

ALTER TABLE Writing
ADD CONSTRAINT fkAutWriting
FOREIGN KEY (autId)
REFERENCES Author (autId)

ALTER TABLE Review
ADD CONSTRAINT fkOrdLinReview
FOREIGN KEY (ordLineId)
REFERENCES OrderLine (ordLineId)

ALTER TABLE Review
ADD CONSTRAINT fkCusReview
FOREIGN KEY (cusId)
REFERENCES Customer (cusId)






