create table person (
	person_id int not null auto_increment,
	user_name varchar(50) not null,
	first_name varchar(50),
	last_name varchar(50),
	password varchar(20),
	email varchar(50) not null,
	phone varchar(20),
	create_date datetime not null,
	edit_date datetime not null default now(),
	last_login datetime,
	occupation varchar(20),
	gender varchar(6),
	birth_date date,
	status_cd varchar(3) not null default 'ACT',
	UNIQUE(person_id, user_name, email),
	PRIMARY KEY (person_id)
)
