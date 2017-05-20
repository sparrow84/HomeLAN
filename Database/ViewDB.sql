/**/
SELECT * FROM Devices ORDER BY placeId;
SELECT * FROM Places;
/**/

/** /
SELECT
	id
	,name
    ,(SELECT name FROM Places WHERE id=placeId) AS place 
FROM Devices 
ORDER BY placeId;

SELECT 
	id
	,name
    ,(SELECT width/1000) AS W
    ,(SELECT length/1000) AS L
    ,(SELECT height/1000) AS H
FROM Places;

/**/