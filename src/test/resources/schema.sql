drop table if exists item;
create table item
(
    id bigint primary key,
    title varchar(255) null,
    price double not null,
    supplier_id varchar(255) null,
    article_type varchar(31) not null
);
INSERT INTO item (id, price, supplier_id, title, article_type) VALUES (1, 45, 'Pelckmans', 'A promised land', 'NON_FICTION');
INSERT INTO item (id, price, supplier_id, title, article_type) VALUES (2, 15, 'Pelckmans', 'Pietje Puk', 'FICTION');
INSERT INTO item (id, price, supplier_id, title, article_type) VALUES (3, 25, 'EA', 'Fifa', 'GAME');
INSERT INTO item (id, price, supplier_id, title, article_type) VALUES (4, 60, 'Blue Note', 'Miles Ahead', 'LP');

drop table if exists book;
create table book
(
    id bigint not null primary key,
    author varchar(255) null,
    isbn varchar(255) null,
    pages int not null,
    book_type varchar(255) null
);
INSERT INTO book (id, author, isbn, pages, book_type) VALUES (1, 'Barack Obama', '978-1-56619-909-4', 215, 'NON_FICTION');
INSERT INTO book (id, author, isbn, pages, book_type) VALUES (2, 'Bas Ketbal', '978-1-56619-909-4', 23, 'FICTION');

drop table if exists fiction;
create table fiction
(
    id bigint not null primary key,
    genre int null,
    summary varchar(255) null
);
INSERT INTO fiction (id, genre, summary) VALUES (2,1,'Pietje Puk');

drop table if exists game;
create table game
(
    id bigint not null primary key,
    publisher varchar(255) null,
    minimum_age int not null,
    genre int null
);
insert into game (id, publisher, minimum_age, genre) VALUES (3, 'EA', 18, 2);

drop table if exists lp;
create table lp
(
    id bigint not null primary key,
    artist varchar(255) null,
    genre int null
);
insert into lp (id, artist, genre) VALUES (4, 'Miles Davis', 3);

drop table if exists non_fiction;
create table non_fiction
(
    id bigint not null primary key,
    subject int null
);
insert into non_fiction (id, subject) VALUES (1,'Politics');

