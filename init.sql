create table customer(
	id int unique not null primary key auto_increment,
    `name` varchar(255) unique not null,
    `password` varchar(255) not null,
    email varchar(255) 
);

create table `account`(
	id int unique not null primary key auto_increment,
    cust_id int not null, 
	foreign key(cust_id) references customer(id) on delete cascade,
    account_number char(10) not null, 
    balance decimal(14,2)
);

create table `transaction`(
	id int unique not null primary key auto_increment,
    cust_id int not null, 
	foreign key(cust_id) references customer(id) on delete cascade,
    acc_id int not null, 
	foreign key(acc_id) references `account`(id) on delete cascade,
    amount decimal(14,2)
);