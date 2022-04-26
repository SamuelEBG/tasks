USE Shapes;

CREATE TABLE movablepoints(
    id INT NOT NULL,
    x DOUBLE,
    y DOUBLE,
    PRIMARY KEY (id)
);

CREATE TABLE circle(
    id INT NOT NULL AUTO_INCREMENT,
    r INT,
    g INT,
    b INT,
    filled INT,
    radius DOUBLE,
    center INT,
    PRIMARY KEY (id),
    CONSTRAINT fk_center
        FOREIGN KEY(center)
        REFERENCES movablepoints (id)
);

CREATE TABLE rectangle(
    id INT NOT NULL AUTO_INCREMENT,
    r INT,
    g INT,
    b INT,
    filled INT,
    width DOUBLE,
    length DOUBLE,
    topLeft INT,
    bottomRight INT,
    PRIMARY KEY (id),
    CONSTRAINT fk_topLeft
       FOREIGN KEY (topLeft)
       REFERENCES movablepoints (id),
    CONSTRAINT fk_bottomRight
       FOREIGN KEY (bottomRight)
       REFERENCES movablepoints(id)
);

CREATE TABLE square(
    id INT NOT NULL AUTO_INCREMENT,
    r INT,
    g INT,
    b INT,
    filled INT,
    sides DOUBLE,
    topLeft INT,
    bottomRight INT,
    PRIMARY KEY (id),
    CONSTRAINT fk_s_topLeft
       FOREIGN KEY (topLeft)
           REFERENCES movablepoints (id),
    CONSTRAINT fk_s_bottomRight
       FOREIGN KEY (bottomRight)
           REFERENCES movablepoints(id)
);

