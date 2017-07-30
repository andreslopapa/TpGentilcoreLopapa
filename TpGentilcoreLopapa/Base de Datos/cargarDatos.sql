insert into categoria(descripcion)
values
('Administrador'),('Encargado'),('Usuario');

insert into persona(dni,nombre,apellido,usuario,contrasenia,habilitado,email,id_categoria) 
values
('39927307','nawe','shopping','naweferoz','123',0,'tunawebienturro@gmail.com',3),
('11111111','kim','deal','lakimpiola','321',1,'kim_deal@hotmail.com',3),
('22222222','joe','santiago','santiagojoe','000',1,'joe_santiago@yahoo.com',2),
('33333333','black','francis','thepixies','1989',1,'hey@yahoo.com',2),
('44444444','adrian','meca','debo aprobar','alumnos',1,'estoschicospromueven@hotmail.com',1),
('55555555','Ricky','Tabacman','Ricardo','123',1,'soyricky@yahoo.com',1);

insert into tipodeelemento(nombre,cantmaxrespen,limite_horas_res,dias_max_anticipacion)
values
('electronico',3,72,8),
('ropa',10,72,15),
('inmueble',4,24,30),
('vehiculo',2,48,30);


insert into elemento(nombre,id_tipodeelemento)
values
(null,1),(null,1),('computadora',1),('servidor',1),('plotter',1),('camara',1),
('jeen',2),('corbata',2),('saco',2),('pantalon',2),('traje',2),('zapatos',2),('vestido',2),
('canchita de futbol',3),('salon de eventos',3),('quinta',3),(null,3),(null,3),(null,3),
('auto deportivo',4),('auto familiar',4),('triciclo',4),('panzer',4),('moto',4);

/*delete from persona;
delete from elemento;
delete from categoria;
delete from tipodeelemento;
ALTER TABLE persona AUTO_INCREMENT = 1;
ALTER TABLE elemento AUTO_INCREMENT = 1;
ALTER TABLE categoria AUTO_INCREMENT = 1;
ALTER TABLE tipodeelemento AUTO_INCREMENT = 1;*/