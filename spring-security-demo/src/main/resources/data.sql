-- insert into USERS(name, email, password, created_at) values('admin', 'admin@localhost', '8450eca01665516d9aeb5317764902b78495502637c96192c81b1683d32d691a0965cf037feca8b9ed9ee6fc6ab8f27fce8f77c4fd9b4a442a00fc317b8237e6', current_time());
-- insert into USERS(name, email, password, created_at) values('user', 'user@localhost',   'cc704afcecdbef04739ae2970f4986b4704b6370bb53cc9a6ab2c5ef19eb7f777ae04d2634463c16e977804e5a841d7a9e436a50f34ed56467e6ff7d1abf52ae', current_time());
--
insert into USERS(username, email, password_hash, enabled, created_at) values('admin', 'admin@localhost', '$2a$10$rOcVCn1Z/KTfS1mDi4sAF.Qw7UyqGb7BEqqxtIJyZ4Yim3robndHe', true, current_time());
insert into USERS(username, email, password_hash, enabled, created_at) values('superadmin', 'super@localhost', '$2a$10$rOcVCn1Z/KTfS1mDi4sAF.Qw7UyqGb7BEqqxtIJyZ4Yim3robndHe', true, current_time());
insert into USERS(username, email, password_hash, enabled, created_at) values('user', 'user@localhost',   '$2a$10$BIVg.9jmNw5VM00/04QOmOaq9gfJUJyv7jxn8kelIeWhU1xxSCmeG', true, current_time());

insert into AUTHORITIES(name) values('VIEW_INFO');
insert into AUTHORITIES(name) values('VIEW_ADMIN');
insert into AUTHORITIES(name) values('STANDARD');

insert into USER_AUTHORITIES(user_id, authority_name) values(1, 'VIEW_INFO');
insert into USER_AUTHORITIES(user_id, authority_name) values(1, 'STANDARD');
insert into USER_AUTHORITIES(user_id, authority_name) values(2, 'VIEW_INFO');
insert into USER_AUTHORITIES(user_id, authority_name) values(2, 'VIEW_ADMIN');
insert into USER_AUTHORITIES(user_id, authority_name) values(3, 'VIEW_INFO');
insert into USER_AUTHORITIES(user_id, authority_name) values(3, 'VIEW_ADMIN');
insert into USER_AUTHORITIES(user_id, authority_name) values(3, 'STANDARD');
