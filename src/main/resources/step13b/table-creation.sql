USE books;

CREATE TABLE books(
    isbn int,
    authorId int,
    title varChar(50),
    pages int,
    genre char(15)
);

CREATE TABLE author(
    id INT,
    name varChar(30),
    surName varChar(40),
    dateOfBirth date
);
