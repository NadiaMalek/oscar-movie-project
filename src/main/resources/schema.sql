DROP SEQUENCE IF EXISTS tbl_rating_seq;
DROP SEQUENCE IF EXISTS tbl_movie_seq;
DROP TABLE IF EXISTS tbl_rating;
DROP TABLE IF EXISTS tbl_movie;

create table tbl_movie (
movie_id integer NOT NULL DEFAULT nextval('tbl_movie_seq') PRIMARY KEY,
category varchar(255), 
additional_info varchar(255), 
movie_title varchar(255), 
movie_year integer, 
oscar_won boolean
);

CREATE SEQUENCE tbl_movie_seq 
MINVALUE 1 
MAXVALUE 999999999 
INCREMENT BY 1 
START WITH 1 
NOCACHE 
NOCYCLE;

create table tbl_rating (
rating_id integer NOT NULL DEFAULT nextval('tbl_rating_seq') PRIMARY KEY, 
user_email_id varchar(255), 
movie_name varchar(255), 
rating float(53), 
user_name varchar(255), 
movie_id integer not null,
foreign key (movie_id) references tbl_movie on delete cascade
);


CREATE SEQUENCE tbl_rating_seq 
MINVALUE 1 
MAXVALUE 999999999 
INCREMENT BY 1 
START WITH 1 
NOCACHE 
NOCYCLE;
