create table user (
	user_id bigint not null auto_increment,
	email text not null,
	username text,
	password varchar(20),
	create_date datetime not null,
	last_login datetime,
	UNIQUE(user_id, email(50)),
	PRIMARY KEY (user_id)
);