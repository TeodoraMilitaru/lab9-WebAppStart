CREATE TABLE BookEpedia (
    id bigserial NOT NULL PRIMARY KEY,
    Author character(40),
    Title character(40) ,
    ISBN int not null,
    PublishingYear int not null
    );

    INSERT INTO book( author, title, isbn, publishingyear) VALUES ('George RR Martin', 'Game of Thrones', '1234', '2008')

/*CREATE TABLE someOtherTable (
    idSomeOtherTable bigserial NOT NULL PRIMARY KEY,
    field1 character(20),
    field2 int NOT NULL REFERENCES someTable(idSomeTable)
);

INSERT INTO sometable( field1, field2, field4) VALUES ('value1', 10, 5.2);
INSERT INTO someOtherTable( field1, field2) VALUES ('value2', 1);*/