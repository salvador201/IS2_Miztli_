-- tablas base de datos hqr 

-- tabla cliente
create table "cliente"
(
  "id_cliente" bigserial not null,
  "usuario_id" bigint not null,
  "correo" character varying(150) not null,
  "nombre_cliente" character varying(255) not null,
  "apellido_paterno_cliente" character varying(255) not null,
  "apellido_materno_cliente" character varying(255) not null,
  "telefono_local" character varying(25),
  "telefono_movil" character varying(25),
  "area" character varying(150) not null,
  "puesto" character varying(150) not null,
  "nombre_empresa"character varying(150) not null,
  "habilitado" integer not null
);

-- tabla empleado
create table "empleado"
(
  "id_empleado" bigserial not null,
  "cliente_id" bigint not null,
  "direccion" character varying(150) not null, 
  "horas_x_semana" integer not null,
  "carrera" character varying(150) not null, 
  "estado_civil" character varying(25) not null, 
  "numero_hijos" integer not null,
  "fecha_nacimiento" date not null, 
  "antiguedad" character varying(100) not null,
  "sueldo_mensual" character varying(13),
  "sexo" character varying(1) not null,
  "candidato" character varying(1) not null,
  "habilitado" integer not null
);

-- tabla empleado_proyecto
create table "empleado_proyecto"
(
  "empleado_id" bigint not null,
  "proyecto_id" bigint not null,
  "habilitado" integer not null  
);

-- tabla password_token
create table "password_token"
(
  "id_password_token" bigserial not null,
  "usuario_password_token" bigint not null,
  "token_password_token" character varying(100),
  "date_password_token" timestamp not null
);

-- tabla pregunta
create table "pregunta"
(
  "id_pregunta" bigserial not null,
  "nombre_pregunta" character varying(255) not null,
  "habilitado" integer not null
);

-- tabla pregunta_prueba
create table "pregunta_prueba"
(
  "pregunta_id" bigint not null,
  "prueba_id" bigint not null,
  "numero_pregunta" integer not null
);

-- tabla pregunta_respuesta
create table "pregunta_respuesta"
(
  "id_pregunta_respuesta" bigserial not null,
  "pregunta_id" bigint not null,
  "respuesta_id" bigint not null,
  "puntaje_respuesta" integer not null
);

-- tabla proyecto
create table "proyecto"
(
  "id_proyecto" bigserial not null,
  "cliente_id" bigint not null,
  "nombre_proyecto" character varying(150) not null,
  "descripcion" character varying(255) not null,
  "fecha_inicio" date not null,
  "fecha_fin" date,
  "habilitado" integer not null

);

-- tabla prueba
create table "prueba"
(
  "id_prueba" bigserial not null,
  "nombre_prueba" character varying(100) not null,
  "descripcion_prueba" character varying(255) not null,
  "habilitado" integer not null  
);


-- tabla prueba_cliente
create table "prueba_cliente"
(
  "prueba_id" bigint not null,
  "cliente_id" bigint not null,
  "habilitado" integer not null
  );


-- tabla prueba_proyecto
create table "prueba_proyecto"
(
  "id_prueba_proyecto" bigserial not null,
  "prueba_id" bigint not null,
  "proyecto_id" bigint not null,
  "puntaje_prueba" integer,
  "fecha_creacion" date,
  "habilitado" integer not null    
);

-- tabla prueba_empleado
create table "prueba_empleado"
(
  "empleado_id" bigint not null,
  "prueba_id" bigint not null,
  "puntaje_prueba" double precision not null,
  "fecha_prueba" date not null 

);

-- tabla respuesta
create table "respuesta"
(
  "id_respuesta" bigserial not null,
  "nombre_respuesta" character varying(150) not null,
  "habilitado" integer not null  
);

-- tabla respuesta_empleado
create table "respuesta_empleado"
(
  "pregunta_respuesta_id" bigint not null,  
  "empleado_id" bigint not null,
  "pregunta_id" bigint not null,
  "respuesta_id" bigint not null
);

-- tabla usuario
create table "usuario"
(
  "id_usuario" bigserial not null,  
  "login_usuario" character varying(50) not null,
  "password_usuario" character varying(100) not null,
  "rol_usuario" character varying(20) not null
);

-- tabla Cliente_empleado
create table "cliente_empleado"
(
  "id_cliente_empleado" bigint not null,
  "cliente_id" bigserial not null,  
  "empleado_id" bigserial not null
 
);


-- LLAVES PRIMARIAS
ALTER TABLE cliente ADD PRIMARY KEY (id_cliente);
ALTER TABLE empleado ADD PRIMARY KEY (id_empleado);
ALTER TABLE password_token ADD PRIMARY KEY (id_password_token);
ALTER TABLE pregunta ADD PRIMARY KEY (id_pregunta);
ALTER TABLE pregunta_respuesta ADD PRIMARY KEY (id_pregunta_respuesta);
ALTER TABLE proyecto ADD PRIMARY KEY (id_proyecto);
ALTER TABLE prueba ADD PRIMARY KEY (id_prueba);
ALTER TABLE prueba_proyecto ADD PRIMARY KEY (id_prueba_proyecto);
ALTER TABLE respuesta ADD PRIMARY KEY (id_respuesta);
ALTER TABLE usuario ADD PRIMARY KEY (id_usuario);
ALTER TABLE cliente_empleado ADD PRIMARY KEY (id_cliente_empleado);

-- UNIQUE
ALTER TABLE cliente ADD  UNIQUE (correo);
ALTER TABLE usuario ADD  UNIQUE (login_usuario);


-- LLAVES FORANEAS
ALTER TABLE cliente ADD  FOREIGN KEY (usuario_id) REFERENCES usuario (id_usuario) MATCH FULL;
ALTER TABLE empleado ADD  FOREIGN KEY (cliente_id) REFERENCES cliente (id_cliente) MATCH FULL;
ALTER TABLE empleado_proyecto ADD  FOREIGN KEY (empleado_id) REFERENCES empleado (id_empleado) MATCH FULL;
ALTER TABLE empleado_proyecto ADD  FOREIGN KEY (proyecto_id) REFERENCES proyecto (id_proyecto) MATCH FULL;
ALTER TABLE pregunta_respuesta ADD  FOREIGN KEY (pregunta_id) REFERENCES pregunta (id_pregunta) MATCH FULL;
ALTER TABLE pregunta_respuesta ADD  FOREIGN KEY (respuesta_id) REFERENCES respuesta (id_respuesta) MATCH FULL;
ALTER TABLE pregunta_prueba ADD  FOREIGN KEY (pregunta_id) REFERENCES pregunta (id_pregunta) MATCH FULL;
ALTER TABLE pregunta_prueba ADD  FOREIGN KEY (prueba_id) REFERENCES prueba (id_prueba) MATCH FULL;
ALTER TABLE proyecto ADD  FOREIGN KEY (cliente_id) REFERENCES cliente (id_cliente) MATCH FULL;
ALTER TABLE prueba_cliente ADD  FOREIGN KEY (cliente_id) REFERENCES cliente (id_cliente) MATCH FULL;
ALTER TABLE prueba_cliente ADD  FOREIGN KEY (prueba_id) REFERENCES prueba (id_prueba) MATCH FULL;
ALTER TABLE prueba_proyecto ADD  FOREIGN KEY (prueba_id) REFERENCES prueba (id_prueba) MATCH FULL;
ALTER TABLE prueba_proyecto ADD  FOREIGN KEY (proyecto_id) REFERENCES proyecto (id_proyecto) MATCH FULL;
ALTER TABLE prueba_empleado ADD  FOREIGN KEY (empleado_id) REFERENCES empleado (id_empleado) MATCH FULL;
ALTER TABLE prueba_empleado ADD  FOREIGN KEY (prueba_id) REFERENCES prueba (id_prueba) MATCH FULL;
ALTER TABLE respuesta_empleado ADD  FOREIGN KEY (empleado_id) REFERENCES empleado (id_empleado) MATCH FULL;
ALTER TABLE respuesta_empleado ADD  FOREIGN KEY (pregunta_id) REFERENCES pregunta (id_pregunta) MATCH FULL;
ALTER TABLE respuesta_empleado ADD  FOREIGN KEY (respuesta_id) REFERENCES respuesta (id_respuesta) MATCH FULL;
ALTER TABLE respuesta_empleado ADD  FOREIGN KEY (pregunta_respuesta_id) REFERENCES pregunta_respuesta (id_pregunta_respuesta) MATCH FULL;
ALTER TABLE password_token ADD  FOREIGN KEY (usuario_password_token) REFERENCES usuario (id_usuario) MATCH FULL;


-- alta administrador
INSERT INTO usuario("login_usuario","password_usuario","rol_usuario") VALUES('admin',md5('+Admin123'),'ROLE_ADMIN');
insert into cliente( "usuario_id","correo", "nombre_cliente", "apellido_paterno_cliente", "apellido_materno_cliente",
                     "telefono_local", "telefono_movil", "area", "puesto", "nombre_empresa", "habilitado")
values(1,'admin@hqr.com','Juan', 'Manuel', 'Santisteban','0445548485678','(55) 55555555','Directivos','Director General','Consultoria Human Quality Research',1);

INSERT INTO usuario("login_usuario","password_usuario","rol_usuario")
VALUES
('aaron',md5('aaron'),'ROLE_CLIENTE'),
('rafa',md5('rafa'),'ROLE_CLIENTE'),
('will01',md5('user'),'ROLE_CLIENTE'),
('hob01',md5('user'),'ROLE_EMPLEADO'),
('fel01',md5('user'),'ROLE_EMPLEADO'),
('mel01',md5('user'),'ROLE_EMPLEADO'),
('gis01',md5('user'),'ROLE_EMPLEADO'),
('bet01',md5('user'),'ROLE_EMPLEADO'),
('bili01',md5('user'),'ROLE_EMPLEADO'),
('kyli01',md5('user'),'ROLE_EMPLEADO'),
('vas01',md5('user'),'ROLE_EMPLEADO'),
('bon01',md5('user'),'ROLE_EMPLEADO');

INSERT INTO cliente("usuario_id","correo", "nombre_cliente","apellido_paterno_cliente","apellido_materno_cliente", "telefono_local", 
            "telefono_movil","area", "puesto", "nombre_empresa","habilitado")
VALUES
 (2,'aaron_guerrero21@ciencias.unam.mx','Aaron', 'Guerrero', 'Hernández.','5512345678','(55) 69-196-7260','Recursos Humanos','Gerente','Banamex',1),
 (3,'phalian360@gmail.com','Rafael', 'Robles', 'Rios.','5715948938','(55) 29-525-6750','Recursos Humanos','Gerente','Barcel',1),
 (4,'convallis@outlook.com','Wilfrido', 'Steven', 'Cruz.','8319 6133','(55) 34-216-1603','Lacus Quisque Imperdiet Industries','Gerente Recursos Humanos','Grupo Jaque',1),
 (5,'arcu.mauris@dropbox.org','Hogan', 'Clinton', 'Hurtado.','3842 6041','(55) 15-274-3113','Odio Sagittis Semper Inc.','Auxiliar Contable','Banamex',1),
 (6,'massa.vitae@segob.edu','Felix', 'Destiny', 'Urrutia.','3737 1747','(55) 02-613-2526','Morbi Foundation','Auxiliar Ventas','Banamex',1),
 (7,'dui.semper@gmail.com','Melton','Alexis','Xomali.','6123 7252','(55) 36-297-6134','Luctus Corp.','Repartidor','Barcel',1),
 (8,'pede@eget.net','Greer',' Buckminster',' opez.','0815 5189','(55) 46-056-3455','Egestas A Consulting','Auxiliar Administrativo','Barcel',1),
 (9,'dui@banamex.com','Benton',' Steven ','Martinez.','6656 8091','(55) 69-041-5631','Nunc Mauris Elit Inc.','Abogado','Grupo Jaque',1),
 (10,'elit@ligula.ca','Bean',' Victor ','Quiroz.','9260 4412','(55) 79-224-5826','Cursus Et Consulting','Mercadotecnia','Grupo Jaque',1),
 (11,'mi_reyc@facebook.org','Irwin',' Chancellor',' James.','0072 9708','(55) 71-958-1095','Nam Ac Nulla Corp.','Gerente de Seguros','Banamex',1),
 (12,'armadura865@hotmail.com','Ware ','Joan ','Montiel.','9198 8504','(55) 30-959-9773','Magna Company','Cajero A','Banamex',1),
 (13,'interdum@comex.org','Bonner',' Talon',' Padilla.','4018 5304','(55) 21-206-1383','Nisl Sem Consequat PC','Cajero B','Banamex',1);


INSERT INTO empleado(cliente_id,direccion,horas_x_semana,carrera,estado_civil,numero_hijos,fecha_nacimiento
  ,antiguedad,sueldo_mensual,sexo,candidato,habilitado)
VALUES 
 (5,'7104 Adipiscing Ctra.',43,'Ingeniería mecánica','casado',0,'2008/12/31','null','11000','M','0',1),
 (6,'716-464 Amet Calle',51,'Estadística','casado',3,'2008/12/31','null','14000','H','1',1),
 (7,'284-2436 Ornare, Carretera',44,'Estadística','soltero',4,'2008/12/31','null','11000','M','0',1),
 (8,'Apdo.:173-8669 Aliquam Carretera',55,'Salud pública','soltero',1,'2008/12/31','null','11000','H','1',1),
 (9,'Apdo.:343-2971 Parturient Avenida',47,'Arquitectura','soltero',1,'2008/12/31','null','13000','H','0',1),
 (10,'8437 Et ',45,'ingeniería civil','casado',2,'2008/12/31','null','11000','H','1',1),
 (11,'195 Auctor ',41,'Salud pública','casado',2,'2008/12/31','null','14000','H','0',1),
 (12,'3747 Fusce ',49,'Historia','soltero',0,'2008/12/31','null','11000','M','1',1),
 (13,'374157 Fusce ',49,'Matematicas','soltero',0,'2008/12/31','null','11500','M','1',1);

 
INSERT INTO proyecto(cliente_id,nombre_proyecto,descripcion,fecha_inicio,fecha_fin,habilitado)
VALUES 
(2,'Proyecto de Banamex','Esto es una prueba del proyecto de Banamex', '2016-01-01','2016-12-31',1),
(3,'Proyecto de Barcel','Esto es una prueba del proyecto de Barcel', '2016-01-01','2016-12-31',1),
(4,'Proyecto de Grupo Jaque','Esto es una prueba del proyecto de Grupo Jaque', '2016-01-01','2016-12-31',1);

INSERT INTO empleado_proyecto(empleado_id,proyecto_id,habilitado)
VALUES (1,1,1),(2,1,1),(3,2,1),(4,2,1),(5,3,1),(6,3,1),(7,1,1),(8,1,1);

INSERT INTO respuesta(nombre_respuesta,habilitado)
VALUES 
('Totalmente de acuerdo',1),
('De acuerdo',1),
('Ni de acuerdo ni en desacuerdo',1),
('En desacuerdo',1),
('Totalmente en desacuerdo',1),
('-5',1),
('-6',1),
('7',1),
('6',1),
('-7',1),
('Sí',1),
('No',1);

INSERT INTO pregunta (nombre_pregunta,habilitado)
VALUES
('No pierdo la concentración cuando se presentan eventos inesperados en mi trabajo.',1),
('Aunque las situaciones no sean estables, soy totalmente competente.',1),
('Es difícil para mí encarar eventos inesperados.',1),
('Me cuesta trabajo ser una persona madura.',1),
('Mi desempeño es igual de bueno en diferentes entornos.',1),
('Tengo agilidad mental.',1),
('Soy una persona madura que sabe cómo actuar en eventos impredecibles.',1),
('Me considero hábil para resolver eventos inesperados.',1),
('Aunque las situaciones en mi trabajo sean inciertas, soy capaz de encararlas.',1),
('Aunque no conozca a fondo la situación en la que me encuentre salgo adelante.',1),
('Me siento entusiasmado cuando me enfrento a un reto difícil de resolver.',1),
('Resuelvo los conflictos de forma eficaz.',1),
('No soy innovador.',1),
('Muchos me consideran una persona cuadrada.',1),
('Soy astuto para salir de los apuros.',1),
('¿Cuál es la respuesta correcta de la siguiente operación 38+21-66?',1),
('Soluciono conflictos hábilmente.',1),
('Me causa desconfianza escuchar a personas que no siguen los pasos específicos necesarios para alcanzar una meta.',1),
('Soy creativo, a menudo se me ocurren diferentes formas de hacer las cosas.',1),
('Encuentro rápidamente respuestas a los problemas.',1),
('Se me dificulta establecer nuevas relaciones personales en la empresa.',1),
('No soy comunicativo.',1),
('Algunas personas dicen que soy irritante.',1),
('La relación con mis compañeros de trabajo es limitada.',1),
('Prefiero estar solo que mal acompañado.',1),
('A veces soy inmaduro en mi trabajo.',1),
('Me enojo muy rápido si alguien me contradice.',1),
('Soy agresivo con aquellos que me provocan.',1),
('Soy tímido, me cuesta trabajo hablar con desconocidos.',1),
('Puedo ser irrespetuoso.',1);


INSERT INTO pregunta_respuesta (pregunta_id,respuesta_id, puntaje_respuesta)
VALUES
(1,1,1),(1,2,2),(1,3,3),(1,4,4),(1,5,5),
(2,1,1),(2,2,2),(2,3,3),(2,4,4),(2,5,5),
(3,1,1),(3,2,2),(3,3,3),(3,4,4),(3,5,5),
(4,1,1),(4,2,2),(4,3,3),(4,4,4),(4,5,5),
(5,1,1),(5,2,2),(5,3,3),(5,4,4),(5,5,5),
(6,1,1),(6,2,2),(6,3,3),(6,4,4),(6,5,5),
(7,1,1),(7,2,2),(7,3,3),(7,4,4),(7,5,5),
(8,1,1),(8,2,2),(8,3,3),(8,4,4),(8,5,5),
(9,1,1),(9,2,2),(9,3,3),(9,4,4),(9,5,5),
(10,1,1),(10,2,2),(10,3,3),(10,4,4),(10,5,5),
(11,1,1),(11,2,2),(11,3,3),(11,4,4),(11,5,5),
(12,1,1),(12,2,2),(12,3,3),(12,4,4),(12,5,5),
(13,1,1),(13,2,2),(13,3,3),(13,4,4),(13,5,5),
(14,1,1),(14,2,2),(14,3,3),(14,4,4),(14,5,5),
(15,1,1),(15,2,2),(15,3,3),(15,4,4),(15,5,5),
(16,6,1),(16,7,2),(16,8,3),(16,9,4),(16,10,5),
(17,1,1),(17,2,2),(17,3,3),(17,4,4),(17,5,5),
(18,1,1),(18,2,2),(18,3,3),(18,4,4),(18,5,5),
(19,1,1),(19,2,2),(19,3,3),(19,4,4),(19,5,5),
(20,1,1),(20,2,2),(20,3,3),(20,4,4),(20,5,5),
(21,1,1),(21,2,2),(21,3,3),(21,4,4),(21,5,5),
(22,1,1),(22,2,2),(22,3,3),(22,4,4),(22,5,5),
(23,1,1),(23,2,2),(23,3,3),(23,4,4),(23,5,5),
(24,1,1),(24,2,2),(24,3,3),(24,4,4),(24,5,5),
(25,1,1),(25,2,2),(25,3,3),(25,4,4),(25,5,5),
(26,1,1),(26,2,2),(26,3,3),(26,4,4),(26,5,5),
(27,1,1),(27,2,2),(27,3,3),(27,4,4),(27,5,5),
(28,1,1),(28,2,2),(28,3,3),(28,4,4),(28,5,5),
(29,1,1),(29,2,2),(29,3,3),(29,4,4),(29,5,5),
(30,1,1),(30,2,2),(30,3,3),(30,4,4),(30,5,5);




INSERT INTO prueba(nombre_prueba,descripcion_prueba,habilitado)VALUES('Adaptabilidad laboral','Esta prueba es para la posibilidad de adaptarse a un nuevo entorno de trabajo',1);

INSERT INTO pregunta_prueba(pregunta_id,prueba_id,numero_pregunta)
VALUES 
(1,1,1),(2,1,2),(3,1,3),(4,1,4),(5,1,5),
(6,1,6),(7,1,7),(8,1,8),(9,1,9),(10,1,10),
(11,1,11),(12,1,12),(13,1,13),(14,1,14),(15,1,15),
(16,1,16),(17,1,17),(18,1,18),(19,1,19),(20,1,20),
(21,1,21),(22,1,22),(23,1,23),(24,1,24),(25,1,25),
(26,1,26),(27,1,27),(28,1,28),(29,1,29),(30,1,30);

INSERT INTO prueba_cliente(cliente_id,prueba_id,habilitado)
VALUES
(2,1,1),(3,1,1),(4,1,1);

INSERT INTO prueba_proyecto(prueba_id,proyecto_id,fecha_creacion,puntaje_prueba,habilitado)
VALUES
(1,1,'2016-01-01',10,1);

INSERT INTO cliente_empleado(id_cliente_empleado,cliente_id,empleado_id) 	
VALUES(1,2,5),(2,3,6),(3,4,7),(4,2,8),(5,3,9),(6,4,10);
