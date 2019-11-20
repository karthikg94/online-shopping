create table category(
	id identity,
	name varchar(50),
	description varchar(100),
	image_url varchar(100),
	is_active boolean,
	
	CONSTRAINT pk_category_id primary key(id)
);

create table user_details(
	id identity,
	firstname varchar(50),
	lastname varchar(50),
	role varchar(50),
	enable boolean,
	password varchar(50),
	email varchar(50),
	
	CONSTRAINT pk_user_details_id primary key(id)
);

create table product(
	id identity,
	code varchar(50),
	name varchar(50),
	brand varchar(50),
	description varchar(500),
	unit_price decimal(10,2),
	quantity int,
	is_active boolean,
	category_id int,
	supplier_id int,
	purchases int default 0,
	Views int default 0,
	
	CONSTRAINT pk_product_id primary key(id),
	CONSTRAINT fk_product_category_id foreign key(category_id) references Category(id),
	CONSTRAINT fk_product_supplier_id foreign key(supplier_id) references user_details(id)
);