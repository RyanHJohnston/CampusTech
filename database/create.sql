USE CampusTech;

CREATE TABLE Users (
    auto_id int auto_increment primary key,
    username varchar(32) not null,
    password varchar(32) not null,
    email varchar(64) not null
);
