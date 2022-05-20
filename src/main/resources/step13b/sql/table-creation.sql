USE books;

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS author;
DROP TABLE IF EXISTS chapters;

CREATE TABLE author(
    id INT NOT NULL AUTO_INCREMENT,
    name varChar(30),
    surname varChar(40),
    dateOfBirth date,
    country varChar(50),
    PRIMARY KEY (id)
);

CREATE TABLE books(
    isbn char(5) UNIQUE,
    title varChar(100),
    author INT,
    pages int,
    genre char(20),
    PRIMARY KEY (isbn),
    CONSTRAINT fk_author
        FOREIGN KEY (author)
        REFERENCES author (id)
);

CREATE TABLE chapters(
    isbn char(5),
    chapterNumber int,
    title varChar(50),
    pages smallint,
    readingTime int,
    PRIMARY KEY (isbn, chapterNumber),
    CONSTRAINT fk_isbn_chnr
        FOREIGN KEY (isbn)
        REFERENCES books (isbn)
);



