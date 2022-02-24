DROP TABLE IF EXISTS books;
CREATE TABLE books(
    isbn int,
    title varChar(100),
    author varChar(100),
    pages int default 1,
    genre char(15)
);
/*
CREATE TABLE author(
    id INT NOT NULL AUTO_INCREMENT,
    name varChar(30),
    surName varChar(40),
    dateOfBirth date
);
 */
