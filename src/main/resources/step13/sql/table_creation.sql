USE Shapes;

CREATE TABLE movablepoints(
    id INT NOT NULL,
    x INT,
    y INT,
    PRIMARY KEY (id)
);

CREATE TABLE circle(
    id INT NOT NULL AUTO_INCREMENT,
    radius DOUBLE,
    color VARCHAR(50),
    filled INT,
    center INT,
    PRIMARY KEY (id),
    CONSTRAINT fk_center
        FOREIGN KEY(center)
        REFERENCES movablepoints (id)
);

CREATE TABLE square(

);

CREATE TABLE rectangle(
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

