create table if not exists person(
	id integer not null auto_increment,
	firstname varchar(100) not null,
	lastname varchar(100) not null,
	address varchar(255) not null,
	gender varchar(10),
	primary key(id)
)