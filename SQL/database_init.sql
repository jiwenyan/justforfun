use MyStore;

create table users(
	id int primary key auto_increment,
    firstName varchar(255) not null,
    lastName varchar(255) not null,
    age int not null    
);

create table contacts(
	id int primary key auto_increment,
    telephone varchar(255),
    email varchar(255),
    user_id int not null,
    constraint fk_user_contact foreign key (user_id) references users(id) on delete cascade on update cascade
);

create table authentications(
	id int primary key auto_increment,
    user_id int not null,
    password varchar(255) not null,
    constraint fk_auth_contact foreign key (user_id) references users(id) on delete cascade on update cascade
);
