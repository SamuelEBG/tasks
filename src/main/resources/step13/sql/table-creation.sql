USE Shapes;

CREATE TABLE Circle(
    radius DOUBLE,
    area DOUBLE,
    perimeter DOUBLE,
    r int,
    g int,
    b int,
    filled BOOLEAN,
    center VARCHAR(20)
);

CREATE TABLE Square(
    sides DOUBLE,
    area DOUBLE,
    perimeter DOUBLE,
    r int,
    g int,
    b int,
    filled BOOLEAN,
    topLeft VARCHAR(30),
    bottomRight VARCHAR(30)
);

CREATE TABLE Rectangle(
    width DOUBLE,
    length DOUBLE,
    area DOUBLE,
    perimeter DOUBLE,
    r int,
    g int,
    b int,
    filled BOOLEAN,
    topLeft VARCHAR(30),
    bottomRight VARCHAR(30)
);

