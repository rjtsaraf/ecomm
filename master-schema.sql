create table Item (id bigint not null auto_increment, createdAt datetime, isDeleted bit not null, updatedAt datetime, capacity varchar(255), pid bigint, price bigint, quantity bigint, primary key (id)) engine=InnoDB;
create table OrderItem (id bigint not null auto_increment, createdAt datetime, isDeleted bit not null, updatedAt datetime, OrderId bigint, PhysicalId bigint, status varchar(255), primary key (id)) engine=InnoDB;
create table Orders (id bigint not null auto_increment, createdAt datetime, isDeleted bit not null, updatedAt datetime, amount bigint, isCancelled bit not null, isPaid bit not null, userId bigint, primary key (id)) engine=InnoDB;
create table PhysicalItem (id bigint not null auto_increment, createdAt datetime, isDeleted bit not null, updatedAt datetime, itemId bigint, price bigint, status varchar(255), primary key (id)) engine=InnoDB;
create table Product (id bigint not null auto_increment, createdAt datetime, isDeleted bit not null, updatedAt datetime, admin_id bigint, product_code varchar(255), product_name varchar(255), primary key (id)) engine=InnoDB;
create table role (id integer not null auto_increment, type varchar(20), primary key (id)) engine=InnoDB;
create table user (id bigint not null auto_increment, createdAt datetime, isDeleted bit not null, updatedAt datetime, address varchar(255), email varchar(50), name varchar(20), otp integer not null, password varchar(120), phoneNo varchar(255), username varchar(20), primary key (id)) engine=InnoDB;
create table user_roles (user_id bigint not null, role_id integer not null, primary key (user_id, role_id)) engine=InnoDB;
alter table user add constraint uniq_name unique (username);
alter table user add constraint uniq_email unique (email);
alter table user_roles add constraint FKrhfovtciq1l558cw6udg0h0d3 foreign key (role_id) references role (id);
alter table user_roles add constraint FK55itppkw3i07do3h7qoclqd4k foreign key (user_id) references user (id);


INSERT INTO role(type) VALUES('ROLE_USER');
INSERT INTO role(type) VALUES('ROLE_MODERATOR');
INSERT INTO role(type) VALUES('ROLE_ADMIN');
