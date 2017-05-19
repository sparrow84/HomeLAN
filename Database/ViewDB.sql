SELECT id,name, (SELECT name FROM Places WHERE id=placeId) AS place FROM Devices ORDER BY placeId;
SELECT * FROM Places;