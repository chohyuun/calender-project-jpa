-- Schedule Table Create
create table schedule(
     id int not null auto_increment primary key,
     username varchar(30) not null,
     title varchar(100),
     contents varchar(300),
     createDate datetime not null,
     modified_date datetime not null
);

-- User Table Create
create table user(
    id int not null auto_increment primary key,
    username varchar(30) not null,
    email varchar(100) not null,
    createDate datetime not null,
    modifiedDate datetime not null
);