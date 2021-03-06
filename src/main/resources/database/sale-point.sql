CREATE TABLE IF NOT EXISTS sale_point (
  id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  name VARCHAR(20),
  address VARCHAR(20),
  retail_chain VARCHAR(20),
  consultant_count INT
);

TRUNCATE TABLE sale_point;

INSERT INTO sale_point VALUES (1, 'name', 'address', 'M-MARKET', 3);
INSERT INTO sale_point VALUES (2, 'name2', 'address2', 'B-MARKET', 8);
INSERT INTO sale_point VALUES (3, 'name3', 'address3', 'C-MARKET', 14);
INSERT INTO sale_point VALUES (4, 'name4', 'address4', 'M-MARKET', 1);
INSERT INTO sale_point VALUES (5, 'name5', 'address5', 'B-MARKET', 2);
INSERT INTO sale_point VALUES (6, 'name6', 'address6', 'B-MARKET', 3);
INSERT INTO sale_point VALUES (7, 'name7', 'address7', 'M-MARKET', 9);
INSERT INTO sale_point VALUES (8, 'name8', 'address8', 'B-MARKET', 9);
INSERT INTO sale_point VALUES (9, 'name9', 'address9', 'B-MARKET', 2);
INSERT INTO sale_point VALUES (10, 'name10', 'address10', 'M-MARKET', 7);
INSERT INTO sale_point VALUES (11, 'name11', 'address11', 'B-MARKET', 11);
INSERT INTO sale_point VALUES (12, 'name12', 'address12', 'B-MARKET', 12);
INSERT INTO sale_point VALUES (13, 'name13', 'address13', 'B-MARKET', 3);
INSERT INTO sale_point VALUES (14, 'name14', 'address14', 'C-MARKET', 10);