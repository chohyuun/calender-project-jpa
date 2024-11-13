-- Schedule Table Create
create table schedule(
     id int not null auto_increment primary key,
     username varchar(100) not null,
     title varchar(200) not null,
     contents varchar(300),
     createDate datetime not null,
     modified_date datetime not null
);

-- User Table Create
create table user(
    id int not null auto_increment primary key,
    username varchar(100) not null,
    email varchar(200) not null,
    createDate datetime not null,
    modifiedDate datetime not null
);