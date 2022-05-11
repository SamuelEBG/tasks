USE books;

DROP TABLE IF EXISTS books;

CREATE TABLE books(
    id INT NOT NULL AUTO_INCREMENT,
    isbn char(5),
    title varChar(100),
    author varChar(100),
    chapters int,
    genre char(20),
    PRIMARY KEY (id),
    CONSTRAINT fk_author
        FOREIGN KEY (author)
        REFERENCES author (id)
);

CREATE TABLE author(
    id INT NOT NULL AUTO_INCREMENT,
    name varChar(30),
    surname varChar(40),
    dateOfBirth date,
    birthplace varChar(50),
    PRIMARY KEY (id)
);

CREATE TABLE chapters(
    isbn char(5),
    chapterNumber int,
    title varChar(50),
    pages smallint,
    readingTime int,
    PRIMARY KEY (isbn, chapterNumber),
    CONSTRAINT fk_isbn
        FOREIGN KEY (isbn)
        REFERENCES books (isbn)
);
