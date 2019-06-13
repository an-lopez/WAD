-- Roles

insert into role(tx_name, tx_description, st_active) values ('Técnico','Director técnico de futbol',true);
insert into role(tx_name, tx_description, st_active) values ('Jugador','Jugador profesional de futbol',true);

-- Personas
insert into person(tx_first_name, tx_last_name_a, tx_last_name_b, tx_curp, fh_birth) values ('Ricardo', 'Ferreti', 'Oliveria', 'MOCH870812HGRX00', to_date('01/01/1950','dd/MM/yyyy'));
insert into person(tx_first_name, tx_last_name_a, tx_last_name_b, tx_curp, fh_birth) values ('Rafael', 'Márquez', 'Álvarez', 'MOCH870812HGRX01', to_date('01/01/1960','dd/MM/yyyy'));
insert into person(tx_first_name, tx_last_name_a, tx_last_name_b, tx_curp, fh_birth) values ('Javier', 'Hernández', 'Balcázar', 'MOCH870812HGRX02', to_date('01/01/1970','dd/MM/yyyy'));
insert into person(tx_first_name, tx_last_name_a, tx_last_name_b, tx_curp, fh_birth) values ('José Andrés', 'Guardado', 'Hernández', 'MOCH870812HGRX03', to_date('01/01/1980','dd/MM/yyyy'));
insert into person(tx_first_name, tx_last_name_a, tx_last_name_b, tx_curp, fh_birth) values ('Cristiano Ronaldo', 'Dos Santos', 'Aveiro', 'MOCH870812HGRX04', to_date('01/01/1990','dd/MM/yyyy'));

-- Usuarios
insert into users(id_user, tx_login, tx_password) values (1,'tuca_ferreti@gmail.com', 'prueba123');
insert into users(id_user, tx_login, tx_password) values (2,'rafael_marquez@gmail.com', 'prueba123');
insert into users(id_user, tx_login, tx_password) values (3,'chicharito_hernandez@gmail.com', 'prueba123');
insert into users(id_user, tx_login, tx_password) values (4,'andres_guardado@gmail.com', 'prueba123');
insert into users(id_user, tx_login, tx_password) values (5,'cristiano_ronaldo@gmail.com', 'prueba123');

-- Cuentas
insert into account(id_role, id_user, fh_begin, fh_end) values (1, 1, to_date('01/01/2018','dd/MM/yyyy'), to_date('31/12/1950','dd/MM/yyyy'));
insert into account(id_role, id_user, fh_begin, fh_end) values (2, 2, to_date('01/01/2018','dd/MM/yyyy'), to_date('31/12/2018','dd/MM/yyyy'));
insert into account(id_role, id_user, fh_begin, fh_end) values (2, 3, to_date('01/01/2018','dd/MM/yyyy'), to_date('31/12/2018','dd/MM/yyyy'));
insert into account(id_role, id_user, fh_begin, fh_end) values (2, 4, to_date('01/01/2018','dd/MM/yyyy'), to_date('31/12/2018','dd/MM/yyyy'));
insert into account(id_role, id_user, fh_begin, fh_end) values (2, 5, to_date('01/01/2018','dd/MM/yyyy'), null);

-- Acceso
insert into access(id_access, nu_attempt, fh_failed, fh_lock) values (1,0,null,null);
insert into access(id_access, nu_attempt, fh_failed, fh_lock) values (2,0,null,null);
insert into access(id_access, nu_attempt, fh_failed, fh_lock) values (3,0,null,null);
insert into access(id_access, nu_attempt, fh_failed, fh_lock) values (4,0,null,null);
insert into access(id_access, nu_attempt, fh_failed, fh_lock) values (5,0,null,null);

-- Tipo contacto
insert into type_contact(tx_name, tx_description, st_active) values ('Telephone','Telephone',true);
insert into type_contact(tx_name, tx_description, st_active) values ('Email','Email',true);
insert into type_contact(tx_name, tx_description, st_active) values ('Mobile phone','Mobile phone',true);
insert into type_contact(tx_name, tx_description, st_active) values ('Facebook','Facebook',true);
insert into type_contact(tx_name, tx_description, st_active) values ('Twitter','Twitter',true);

--Contactos
insert into person_contact(id_person, id_type, tx_contact) values (1,1,'5555555555');
insert into person_contact(id_person, id_type, tx_contact) values (2,2,'aaaa.bbbb@cccc.com');
insert into person_contact(id_person, id_type, tx_contact) values (3,3,'5555555555');
insert into person_contact(id_person, id_type, tx_contact) values (4,4,'Facebook');
insert into person_contact(id_person, id_type, tx_contact) values (5,5,'@Twitter');

-- Address
insert into address(id_person, tx_street, tx_city, tx_zipcode) values(1, 'Avenida Manzano', 'Ciudad de Mexico', '02150');
insert into address(id_person, tx_street, tx_city, tx_zipcode) values(2, 'Avenida Manzano', 'Ciudad de Mexico', '02150');
insert into address(id_person, tx_street, tx_city, tx_zipcode) values(3, 'Avenida Manzano', 'Ciudad de Mexico', '02150');
insert into address(id_person, tx_street, tx_city, tx_zipcode) values(4, 'Avenida Manzano', 'Ciudad de Mexico', '02150');
insert into address(id_person, tx_street, tx_city, tx_zipcode) values(5, 'Avenida Manzano', 'Ciudad de Mexico', '02150');