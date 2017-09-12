USE MyLibrary
go


/*Requete simple sur la table Customer*/
select cusGender,cusFirstName, cusLastName, cusOrganisationName, cusEmail, cusPhoneNumber, cusDateOfBirth,cusPassword,cusSalt,cusIP, cusStatus,cusComment FROM Customer
order by cusLastName DESC


/*requete jointure customer et adresse*/
select cusGender,cusFirstName, cusLastName,addLabel, addNumber, addStreetType,addStreetName,addComplement,
addZipCode,addCity,addsecurityCode,addPhone
from Customer cus, Address addr
where cus.cusId = addr.cusResidId


/*requete sur la commandes N° 57233*/
DECLARE @purId INT
SET @purId = 57233
SELECT  cusLastName 'nom client', cusFirstName 'prenom Client', booTitle 'titre livre',
 booPriceHT 'prix du livre', ordLineQuantity 'quantitée commandé', ordBookPriceHT 'prix livre commande', ordBookVAT 'taux TVA'
 FROM Book boo
 JOIN OrderLine odr
 ON boo.booIsbn13 = odr.booIsbn13
 JOIN Purchase pur
 ON odr.purId=pur.purId
 JOIN Customer cus
 ON pur.cusId = cus.cusId
 WHERE pur.purId = @purId


 /*requete sur toutes les commandes*/
SELECT  cusLastName 'nom client', cusFirstName 'prenom Client', booTitle 'titre livre',
 booPriceHT 'prix du livre', ordLineQuantity 'quantitée commandé', ordBookPriceHT 'prix livre commande', ordBookVAT 'taux TVA'
 FROM Book boo
 JOIN OrderLine odr
 ON boo.booIsbn13 = odr.booIsbn13
 JOIN Purchase pur
 ON odr.purId=pur.purId
 JOIN Customer cus
 ON pur.cusId = cus.cusId
 ORDER BY cusLastName DESC


/* requete comparative sur le prix HT etTVA entre Book (avec nom et prenom hauteur) et OrderLine*/
SELECT boo.booIsbn13 'ISBN livre', booTitle 'titre du livre', aut.autLastName 'nom auteur', autFirstName 'prenom auteur',
 booPriceHT 'prix HT book', ordBookPriceHT 'prix HT order', vat.vatCode 'TVA Book', ordBookVAT 'TVA Order'
 FROM Author aut
 JOIN Writing wri
 ON aut.autId = wri.autId
 JOIN Book boo
 ON wri.booIsbn13 = boo.booIsbn13
 JOIN Vat vat
 ON boo.vatCode = vat.vatCode
 JOIN OrderLine ord
 ON boo.booIsbn13 = ord.booIsbn13
 ORDER BY boo.booIsbn13 DESC


  /*requete sur toutes les commandes par clients et par livres*/
 SELECT  cusLastName 'nom client', cusFirstName 'prenom Client', booTitle 'titre livre',
 ordLineQuantity 'quantitée commandé', ordBookPriceHT 'prix livre commande',
 (SELECT SUM(ordLineQuantity*ordBookPriceHT)) 'total H.T.',
  ordBookVAT 'taux TVA', 
 CAST((SELECT SUM(ordLineQuantity*ordBookPriceHT)*(1+ordBookVAT/100))AS DECIMAL(9,2)) 'total T.T.C.',shipCost 'Frais de port',
 CAST((SELECT SUM((ordLineQuantity*ordBookPriceHT)*(1+ordBookVAT/100))+ shipCost)AS DECIMAL(9,2)) 'total Ligne'
 FROM Book boo
 JOIN OrderLine odr
 ON boo.booIsbn13 = odr.booIsbn13
 JOIN Purchase pur
 ON odr.purId=pur.purId
 JOIN ShippingCost shc
 ON pur.shippingCostId = shc.shipId
 JOIN Customer cus
 ON pur.cusId = cus.cusId
 GROUP BY cusFirstName, cusLastName, booTitle, ordLineQuantity, ordBookPriceHT,ordBookVAT,shipCost
  

/*requete sur toutes les commandes d'un client et par livres*/
  DECLARE @cusId INT
  SET @cusId = 1986
 SELECT  cusLastName 'nom client', cusFirstName 'prenom Client', booTitle 'titre livre',
 ordLineQuantity 'quantitée commandé', ordBookPriceHT 'prix livre commande',
 (SELECT SUM(ordLineQuantity*ordBookPriceHT)) 'total H.T.',
  ordBookVAT 'taux TVA',
 CAST((SELECT SUM(ordLineQuantity*ordBookPriceHT)*(1+ordBookVAT/100))AS DECIMAL(9,2)) 'total T.T.C.',shipCost 'Frais de port',
 CAST((SELECT SUM((ordLineQuantity*ordBookPriceHT)*(1+ordBookVAT/100))+ shipCost)AS DECIMAL(9,2)) 'total Ligne'
 FROM Book boo
 JOIN OrderLine odr
 ON boo.booIsbn13 = odr.booIsbn13
 JOIN Purchase pur
 ON odr.purId=pur.purId
 JOIN ShippingCost shc
 ON pur.shippingCostId = shc.shipId
 JOIN Customer cus
 ON pur.cusId = cus.cusId
 WHERE cus.cusId = @cusId
 GROUP BY cusFirstName, cusLastName, booTitle, ordLineQuantity, ordBookPriceHT,ordBookVAT,shipCost


 /*toutes les entités des Livres ayant un KeyWord*/
 SELECT booTitle 'titre', booSubtitle 'sous-titre', vatRate 'tx TVA' ,subName'sous-theme', theName'theme', ediName'editeur', ediPresentation'presentation editeur', 
 bookLangName'langue', autLastName 'nom Auteur' ,autFirstName 'prenom Auteur', fom.forName 'format', def.keyName 'mots-clef'
 FROM Book boo
 JOIN Vat vat
 ON boo.vatCode = vat.vatCode
 JOIN Association ass
 ON boo.booIsbn13 = ass.booIsbn13
 JOIN SubTheme sub
 ON sub.subId = ass.subId
 JOIN Theme the
 ON sub.theId = the.theId
 JOIN Editor edi
 ON boo.ediId = edi.ediId
 JOIN BookLanguage bol
 ON boo.bookLangCode = bol.bookLangCode
 JOIN Writing wri
 ON boo.booIsbn13 = wri.booIsbn13
 JOIN Author aut
 ON wri.autId = aut.autId
 JOIN Definitions def
 ON boo.booIsbn13 = def.booIsbn13
 JOIN Keywords kew
 ON def.keyName = kew.keyName
 JOIN Possession pos
 ON boo.booIsbn13 = pos.booIsbn13
 JOIN Formats fom
 ON pos.forName = fom.forName

 GROUP BY booTitle, booSubtitle, vatRate, subName, theName, ediName, ediPresentation, bookLangName, autLastName, autFirstName, fom.forName, def.keyName


  /* toutes les entités d'un Livre avec KeyWords*/
 SELECT booTitle 'titre', booSubtitle 'sous-titre', vatRate 'tx TVA' ,subName'sous-theme', theName'theme', ediName'editeur', ediPresentation'presentation editeur', 
 bookLangName'langue', autLastName 'nom Auteur' ,autFirstName 'prenom Auteur', fom.forName 'format', def.keyName 'mots-clef'
 FROM Book boo
 JOIN Vat vat
 ON boo.vatCode = vat.vatCode
 JOIN Association ass
 ON boo.booIsbn13 = ass.booIsbn13
 JOIN SubTheme sub
 ON sub.subId = ass.subId
 JOIN Theme the
 ON sub.theId = the.theId
 JOIN Editor edi
 ON boo.ediId = edi.ediId
 JOIN BookLanguage bol
 ON boo.bookLangCode = bol.bookLangCode
 JOIN Writing wri
 ON boo.booIsbn13 = wri.booIsbn13
 JOIN Author aut
 ON wri.autId = aut.autId
 JOIN Definitions def
 ON boo.booIsbn13 = def.booIsbn13
 JOIN Keywords kew
 ON def.keyName = kew.keyName
 JOIN Possession pos
 ON boo.booIsbn13 = pos.booIsbn13
 JOIN Formats fom
 ON pos.forName = fom.forName
 WHERE boo.booIsbn13 = '9782226328717'
 GROUP BY booTitle, booSubtitle, vatRate, subName, theName, ediName, ediPresentation, bookLangName, autLastName, autFirstName, fom.forName, def.keyName

 
 /*Toutes les entités d'un livre sans KeyWord*/

 SELECT booTitle 'titre', booSubtitle 'sous-titre', vatRate,subName'sous-theme', theName'theme',ediName'editeur', ediPresentation'presentation editeur'
 , bookLangName'langue', autLastName 'nom Auteur' ,autFirstName 'prenom Auteur', fom.forName 'format'
 FROM Book boo
 JOIN Vat vat
 ON boo.vatCode = vat.vatCode
 JOIN Association ass
 ON boo.booIsbn13 = ass.booIsbn13
 JOIN SubTheme sub
 ON sub.subId = ass.subId
 JOIN Theme the
 ON sub.theId = the.theId
 JOIN Editor edi
 ON boo.ediId = edi.ediId
 JOIN BookLanguage bol
 ON boo.bookLangCode = bol.bookLangCode
 JOIN Writing wri
 ON boo.booIsbn13 = wri.booIsbn13
 JOIN Author aut
 ON wri.autId = aut.autId
 JOIN Possession pos
 ON boo.booIsbn13 = pos.booIsbn13
 JOIN Formats fom
 ON pos.forName = fom.forName
 WHERE boo.booIsbn13 = '9782412020869'
 GROUP BY booTitle, booSubtitle, vatRate, subName, theName, ediName, ediPresentation, bookLangName, autLastName, autFirstName, fom.forName

  /*toutes les entités des Livres (hors Keyword)*/
 
 SELECT booTitle 'titre', booSubtitle 'sous-titre', vatRate,subName'sous-theme', theName'theme',ediName'editeur', ediPresentation'presentation editeur'
 , bookLangName'langue', autLastName 'nom Auteur' ,autFirstName 'prenom Auteur', fom.forName 'format'
 FROM Book boo
 JOIN Vat vat
 ON boo.vatCode = vat.vatCode
 JOIN Association ass
 ON boo.booIsbn13 = ass.booIsbn13
 JOIN SubTheme sub
 ON sub.subId = ass.subId
 JOIN Theme the
 ON sub.theId = the.theId
 JOIN Editor edi
 ON boo.ediId = edi.ediId
 JOIN BookLanguage bol
 ON boo.bookLangCode = bol.bookLangCode
 JOIN Writing wri
 ON boo.booIsbn13 = wri.booIsbn13
 JOIN Author aut
 ON wri.autId = aut.autId
 JOIN Possession pos
 ON boo.booIsbn13 = pos.booIsbn13
 JOIN Formats fom
 ON pos.forName = fom.forName

 GROUP BY booTitle, booSubtitle, vatRate, subName, theName, ediName, ediPresentation, bookLangName, autLastName, autFirstName, fom.forName
  

 SELECT booTitle, autLastName, autFirstName
 FROM Book boo
 JOIN Writing wri
 ON boo.booIsbn13 = wri.booIsbn13
 JOIN Author aut
 ON wri.autId = aut.autId
 WHERE boo.booIsbn13 = '9782253014997'
 GROUP BY booTitle, autLastName, autFirstName