create table role (id integer not null auto_increment, type varchar(20), primary key (id)) engine=InnoDB;
create table user (id bigint not null auto_increment, address varchar(255), email varchar(50), name varchar(20), otp
integer not null, password varchar(120), phoneNo varchar(255), username varchar(20), primary key (id)) engine=InnoDB;
create table user_roles (user_id bigint not null, role_id integer not null, primary key (user_id, role_id))
engine=InnoDB;
alter table user add constraint UKsb8bbouer5wak8vyiiy4pf2bx unique (username);
alter table user add constraint UKob8kqyqqgmefl0aco34akdtpe unique (email);
alter table user_roles add constraint FKrhfovtciq1l558cw6udg0h0d3 foreign key (role_id) references role (id);
alter table user_roles add constraint FK55itppkw3i07do3h7qoclqd4k foreign key (user_id) references user (id);create table role (id integer not null auto_increment, type varchar(20), primary key (id)) engine=InnoDB
create table user (id bigint not null auto_increment, address varchar(255), email varchar(50), name varchar(20), otp integer not null, password varchar(120), phoneNo varchar(255), username varchar(20), primary key (id)) engine=InnoDB
create table user_roles (user_id bigint not null, role_id integer not null, primary key (user_id, role_id)) engine=InnoDB
alter table user add constraint UKsb8bbouer5wak8vyiiy4pf2bx unique (username)
alter table user add constraint UKob8kqyqqgmefl0aco34akdtpe unique (email)
alter table user_roles add constraint FKrhfovtciq1l558cw6udg0h0d3 foreign key (role_id) references role (id)
alter table user_roles add constraint FK55itppkw3i07do3h7qoclqd4k foreign key (user_id) references user (id)
create table role (id integer not null auto_increment, type varchar(20), primary key (id)) engine=InnoDB
create table user (id bigint not null auto_increment, address varchar(255), email varchar(50), name varchar(20), otp integer not null, password varchar(120), phoneNo varchar(255), username varchar(20), primary key (id)) engine=InnoDB
create table user_roles (user_id bigint not null, role_id integer not null, primary key (user_id, role_id)) engine=InnoDB
alter table user add constraint UKsb8bbouer5wak8vyiiy4pf2bx unique (username)
alter table user add constraint UKob8kqyqqgmefl0aco34akdtpe unique (email)
alter table user_roles add constraint FKrhfovtciq1l558cw6udg0h0d3 foreign key (role_id) references role (id)
alter table user_roles add constraint FK55itppkw3i07do3h7qoclqd4k foreign key (user_id) references user (id)
create table role (id integer not null auto_increment, type varchar(20), primary key (id)) engine=InnoDB
create table user (id bigint not null auto_increment, address varchar(255), email varchar(50), name varchar(20), otp integer not null, password varchar(120), phoneNo varchar(255), username varchar(20), primary key (id)) engine=InnoDB
create table user_roles (user_id bigint not null, role_id integer not null, primary key (user_id, role_id)) engine=InnoDB
alter table user add constraint UKsb8bbouer5wak8vyiiy4pf2bx unique (username)
alter table user add constraint UKob8kqyqqgmefl0aco34akdtpe unique (email)
alter table user_roles add constraint FKrhfovtciq1l558cw6udg0h0d3 foreign key (role_id) references role (id)
alter table user_roles add constraint FK55itppkw3i07do3h7qoclqd4k foreign key (user_id) references user (id)
create table role (id integer not null auto_increment, type varchar(20), primary key (id)) engine=InnoDB
create table user (id bigint not null auto_increment, address varchar(255), email varchar(50), name varchar(20), otp integer not null, password varchar(120), phoneNo varchar(255), username varchar(20), primary key (id)) engine=InnoDB
create table user_roles (user_id bigint not null, role_id integer not null, primary key (user_id, role_id)) engine=InnoDB
alter table user add constraint UKsb8bbouer5wak8vyiiy4pf2bx unique (username)
alter table user add constraint UKob8kqyqqgmefl0aco34akdtpe unique (email)
alter table user_roles add constraint FKrhfovtciq1l558cw6udg0h0d3 foreign key (role_id) references role (id)
alter table user_roles add constraint FK55itppkw3i07do3h7qoclqd4k foreign key (user_id) references user (id)
create table role (id integer not null auto_increment, type varchar(20), primary key (id)) engine=InnoDB
create table user (id bigint not null auto_increment, address varchar(255), email varchar(50), name varchar(20), otp integer not null, password varchar(120), phoneNo varchar(255), username varchar(20), primary key (id)) engine=InnoDB
create table user_roles (user_id bigint not null, role_id integer not null, primary key (user_id, role_id)) engine=InnoDB
alter table user add constraint UKsb8bbouer5wak8vyiiy4pf2bx unique (username)
alter table user add constraint UKob8kqyqqgmefl0aco34akdtpe unique (email)
alter table user_roles add constraint FKrhfovtciq1l558cw6udg0h0d3 foreign key (role_id) references role (id)
alter table user_roles add constraint FK55itppkw3i07do3h7qoclqd4k foreign key (user_id) references user (id)
create table role (id integer not null auto_increment, type varchar(20), primary key (id)) engine=InnoDB
create table user (id bigint not null auto_increment, address varchar(255), email varchar(50), name varchar(20), otp integer not null, password varchar(120), phoneNo varchar(255), username varchar(20), primary key (id)) engine=InnoDB
create table user_roles (user_id bigint not null, role_id integer not null, primary key (user_id, role_id)) engine=InnoDB
alter table user add constraint UKsb8bbouer5wak8vyiiy4pf2bx unique (username)
alter table user add constraint UKob8kqyqqgmefl0aco34akdtpe unique (email)
alter table user_roles add constraint FKrhfovtciq1l558cw6udg0h0d3 foreign key (role_id) references role (id)
alter table user_roles add constraint FK55itppkw3i07do3h7qoclqd4k foreign key (user_id) references user (id)
create table role (id integer not null auto_increment, type varchar(20), primary key (id)) engine=InnoDB
create table user (id bigint not null auto_increment, address varchar(255), email varchar(50), name varchar(20), otp integer not null, password varchar(120), phoneNo varchar(255), username varchar(20), primary key (id)) engine=InnoDB
create table user_roles (user_id bigint not null, role_id integer not null, primary key (user_id, role_id)) engine=InnoDB
alter table user add constraint UKsb8bbouer5wak8vyiiy4pf2bx unique (username)
alter table user add constraint UKob8kqyqqgmefl0aco34akdtpe unique (email)
alter table user_roles add constraint FKrhfovtciq1l558cw6udg0h0d3 foreign key (role_id) references role (id)
alter table user_roles add constraint FK55itppkw3i07do3h7qoclqd4k foreign key (user_id) references user (id)
create table role (id integer not null auto_increment, type varchar(20), primary key (id)) engine=InnoDB
create table user (id bigint not null auto_increment, address varchar(255), email varchar(50), name varchar(20), otp integer not null, password varchar(120), phoneNo varchar(255), username varchar(20), primary key (id)) engine=InnoDB
create table user_roles (user_id bigint not null, role_id integer not null, primary key (user_id, role_id)) engine=InnoDB
alter table user add constraint UKsb8bbouer5wak8vyiiy4pf2bx unique (username)
alter table user add constraint UKob8kqyqqgmefl0aco34akdtpe unique (email)
alter table user_roles add constraint FKrhfovtciq1l558cw6udg0h0d3 foreign key (role_id) references role (id)
alter table user_roles add constraint FK55itppkw3i07do3h7qoclqd4k foreign key (user_id) references user (id)
create table role (id integer not null auto_increment, type varchar(20), primary key (id)) engine=InnoDB
create table user (id bigint not null auto_increment, address varchar(255), email varchar(50), name varchar(20), otp integer not null, password varchar(120), phoneNo varchar(255), username varchar(20), primary key (id)) engine=InnoDB
create table user_roles (user_id bigint not null, role_id integer not null, primary key (user_id, role_id)) engine=InnoDB
alter table user add constraint UKsb8bbouer5wak8vyiiy4pf2bx unique (username)
alter table user add constraint UKob8kqyqqgmefl0aco34akdtpe unique (email)
alter table user_roles add constraint FKrhfovtciq1l558cw6udg0h0d3 foreign key (role_id) references role (id)
alter table user_roles add constraint FK55itppkw3i07do3h7qoclqd4k foreign key (user_id) references user (id)
create table role (id integer not null auto_increment, type varchar(20), primary key (id)) engine=InnoDB
create table user (id bigint not null auto_increment, address varchar(255), email varchar(50), name varchar(20), otp integer not null, password varchar(120), phoneNo varchar(255), username varchar(20), primary key (id)) engine=InnoDB
create table user_roles (user_id bigint not null, role_id integer not null, primary key (user_id, role_id)) engine=InnoDB
alter table user add constraint UKsb8bbouer5wak8vyiiy4pf2bx unique (username)
alter table user add constraint UKob8kqyqqgmefl0aco34akdtpe unique (email)
alter table user_roles add constraint FKrhfovtciq1l558cw6udg0h0d3 foreign key (role_id) references role (id)
alter table user_roles add constraint FK55itppkw3i07do3h7qoclqd4k foreign key (user_id) references user (id)
create table role (id integer not null auto_increment, type varchar(20), primary key (id)) engine=InnoDB
create table user (id bigint not null auto_increment, address varchar(255), email varchar(50), name varchar(20), otp integer not null, password varchar(120), phoneNo varchar(255), username varchar(20), primary key (id)) engine=InnoDB
create table user_roles (user_id bigint not null, role_id integer not null, primary key (user_id, role_id)) engine=InnoDB
alter table user add constraint UKsb8bbouer5wak8vyiiy4pf2bx unique (username)
alter table user add constraint UKob8kqyqqgmefl0aco34akdtpe unique (email)
alter table user_roles add constraint FKrhfovtciq1l558cw6udg0h0d3 foreign key (role_id) references role (id)
alter table user_roles add constraint FK55itppkw3i07do3h7qoclqd4k foreign key (user_id) references user (id)
create table role (id integer not null auto_increment, type varchar(20), primary key (id)) engine=InnoDB
create table user (id bigint not null auto_increment, address varchar(255), email varchar(50), name varchar(20), otp integer not null, password varchar(120), phoneNo varchar(255), username varchar(20), primary key (id)) engine=InnoDB
create table user_roles (user_id bigint not null, role_id integer not null, primary key (user_id, role_id)) engine=InnoDB
alter table user add constraint UKsb8bbouer5wak8vyiiy4pf2bx unique (username)
alter table user add constraint UKob8kqyqqgmefl0aco34akdtpe unique (email)
alter table user_roles add constraint FKrhfovtciq1l558cw6udg0h0d3 foreign key (role_id) references role (id)
alter table user_roles add constraint FK55itppkw3i07do3h7qoclqd4k foreign key (user_id) references user (id)
create table role (id integer not null auto_increment, type varchar(20), primary key (id)) engine=InnoDB
create table user (id bigint not null auto_increment, address varchar(255), email varchar(50), name varchar(20), otp integer not null, password varchar(120), phoneNo varchar(255), username varchar(20), primary key (id)) engine=InnoDB
create table user_roles (user_id bigint not null, role_id integer not null, primary key (user_id, role_id)) engine=InnoDB
alter table user add constraint UKsb8bbouer5wak8vyiiy4pf2bx unique (username)
alter table user add constraint UKob8kqyqqgmefl0aco34akdtpe unique (email)
alter table user_roles add constraint FKrhfovtciq1l558cw6udg0h0d3 foreign key (role_id) references role (id)
alter table user_roles add constraint FK55itppkw3i07do3h7qoclqd4k foreign key (user_id) references user (id)
create table role (id integer not null auto_increment, type varchar(20), primary key (id)) engine=InnoDB
create table user (id bigint not null auto_increment, address varchar(255), email varchar(50), name varchar(20), otp integer not null, password varchar(120), phoneNo varchar(255), username varchar(20), primary key (id)) engine=InnoDB
create table user_roles (user_id bigint not null, role_id integer not null, primary key (user_id, role_id)) engine=InnoDB
alter table user add constraint UKsb8bbouer5wak8vyiiy4pf2bx unique (username)
alter table user add constraint UKob8kqyqqgmefl0aco34akdtpe unique (email)
alter table user_roles add constraint FKrhfovtciq1l558cw6udg0h0d3 foreign key (role_id) references role (id)
alter table user_roles add constraint FK55itppkw3i07do3h7qoclqd4k foreign key (user_id) references user (id)
create table role (id integer not null auto_increment, type varchar(20), primary key (id)) engine=InnoDB
create table user (id bigint not null auto_increment, address varchar(255), email varchar(50), name varchar(20), otp integer not null, password varchar(120), phoneNo varchar(255), username varchar(20), primary key (id)) engine=InnoDB
create table user_roles (user_id bigint not null, role_id integer not null, primary key (user_id, role_id)) engine=InnoDB
alter table user add constraint UKsb8bbouer5wak8vyiiy4pf2bx unique (username)
alter table user add constraint UKob8kqyqqgmefl0aco34akdtpe unique (email)
alter table user_roles add constraint FKrhfovtciq1l558cw6udg0h0d3 foreign key (role_id) references role (id)
alter table user_roles add constraint FK55itppkw3i07do3h7qoclqd4k foreign key (user_id) references user (id)
create table role (id integer not null auto_increment, type varchar(20), primary key (id)) engine=InnoDB
create table user (id bigint not null auto_increment, address varchar(255), email varchar(50), name varchar(20), otp integer not null, password varchar(120), phoneNo varchar(255), username varchar(20), primary key (id)) engine=InnoDB
create table user_roles (user_id bigint not null, role_id integer not null, primary key (user_id, role_id)) engine=InnoDB
alter table user add constraint UKsb8bbouer5wak8vyiiy4pf2bx unique (username)
alter table user add constraint UKob8kqyqqgmefl0aco34akdtpe unique (email)
alter table user_roles add constraint FKrhfovtciq1l558cw6udg0h0d3 foreign key (role_id) references role (id)
alter table user_roles add constraint FK55itppkw3i07do3h7qoclqd4k foreign key (user_id) references user (id)
create table role (id integer not null auto_increment, type varchar(20), primary key (id)) engine=InnoDB
create table user (id bigint not null auto_increment, address varchar(255), email varchar(50), name varchar(20), otp integer not null, password varchar(120), phoneNo varchar(255), username varchar(20), primary key (id)) engine=InnoDB
create table user_roles (user_id bigint not null, role_id integer not null, primary key (user_id, role_id)) engine=InnoDB
alter table user add constraint UKsb8bbouer5wak8vyiiy4pf2bx unique (username)
alter table user add constraint UKob8kqyqqgmefl0aco34akdtpe unique (email)
alter table user_roles add constraint FKrhfovtciq1l558cw6udg0h0d3 foreign key (role_id) references role (id)
alter table user_roles add constraint FK55itppkw3i07do3h7qoclqd4k foreign key (user_id) references user (id)
create table role (id integer not null auto_increment, type varchar(20), primary key (id)) engine=InnoDB
create table user (id bigint not null auto_increment, address varchar(255), email varchar(50), name varchar(20), otp integer not null, password varchar(120), phoneNo varchar(255), username varchar(20), primary key (id)) engine=InnoDB
create table user_roles (user_id bigint not null, role_id integer not null, primary key (user_id, role_id)) engine=InnoDB
alter table user add constraint UKsb8bbouer5wak8vyiiy4pf2bx unique (username)
alter table user add constraint UKob8kqyqqgmefl0aco34akdtpe unique (email)
alter table user_roles add constraint FKrhfovtciq1l558cw6udg0h0d3 foreign key (role_id) references role (id)
alter table user_roles add constraint FK55itppkw3i07do3h7qoclqd4k foreign key (user_id) references user (id)
create table role (id integer not null auto_increment, type varchar(20), primary key (id)) engine=InnoDB
create table user (id bigint not null auto_increment, address varchar(255), email varchar(50), name varchar(20), otp integer not null, password varchar(120), phoneNo varchar(255), username varchar(20), primary key (id)) engine=InnoDB
create table user_roles (user_id bigint not null, role_id integer not null, primary key (user_id, role_id)) engine=InnoDB
alter table user add constraint UKsb8bbouer5wak8vyiiy4pf2bx unique (username)
alter table user add constraint UKob8kqyqqgmefl0aco34akdtpe unique (email)
alter table user_roles add constraint FKrhfovtciq1l558cw6udg0h0d3 foreign key (role_id) references role (id)
alter table user_roles add constraint FK55itppkw3i07do3h7qoclqd4k foreign key (user_id) references user (id)
