CREATE PROCEDURE AddReviewLocked 
	
AS 
BEGIN 
	DECLARE @revid int  
    SELECT @revid = revid FROM Review WHERE cusid = @cusid
    
    IF @revid IS NOT NULL 
       RAISERROR ('the user has already commented',18, 1) 
	

END