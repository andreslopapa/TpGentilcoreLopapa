insert into categoria(descripcion)
values
('Administrador'),
('Encargado'),
('Usuario');

insert into persona(dni,nombre,apellido,usuario,contrasenia,habilitado,email,id_categoria) 
values
('39927307','Nahuel','Alvarez','NaweShopping','123',0,'NaweShopping@gmail.com',3),
('11111111','Elsa','Pallo','zapallito','321',1,'zapallito@hotmail.com',3),
('22222222','Seba','Rantica','heilHitler','000',1,'bigotito@yahoo.com',2),
('33333333','Fausto','Azzaretti','elOligarca','1989',1,'mauriPresidente@yahoo.com',2),
('44444444','Adrian','Meca','debo aprobar','alumnos',1,'estoschicospromueven@hotmail.com',1),
('55555555','Ricky','Tabacman','Ricardo','123',1,'soyricky@yahoo.com',1),
('66666666','Miguel','Oliveros Vega','cubaLibre','123',1,'cubaLibre@free.com',3);

insert into tipodeelemento(nombre,cantmaxrespen,limite_horas_res,dias_max_anticipacion)
values
('Electronico',3,72,8),
('Ropa',10,72,15),
('Inmueble',4,24,30),
('Vehiculo',2,48,30);


insert into elemento(nombre,id_tipodeelemento)
values
('Computadora',1),('Servidor',1),('Plotter',1),('Camara',1),
('Jeen',2),('Corbata',2),('Saco',2),('Pantalon',2),('Traje',2),('Zapatos',2),('Vestido',2),
('Canchita de futbol',3),('Salon de eventos',3),('Quinta',3),
('Auto deportivo',4),('Auto familiar',4),('Triciclo',4),('Panzer',4),('Moto',4);


--ejemplo reserva no entregada
insert into reserva(id_persona, id_elemento,fecha_hora_reserva_hecha, fecha_hora_desde_solicitada,fecha_hora_hasta_solicitada,detalle) 
values
(2,3,20170810,20170820,20170824,'Se entregó con raya superior');
--ejemplo reserva entregada
insert into reserva(id_persona, id_elemento,fecha_hora_reserva_hecha, fecha_hora_desde_solicitada,fecha_hora_hasta_solicitada,fecha_hora_entregado, detalle) 
values
(2,3,20170810,20170820,20170824,20170824,'Se entregó con raya superior');



/*delete from persona;
delete from elemento;
delete from categoria;
delete from tipodeelemento;
ALTER TABLE persona AUTO_INCREMENT = 1;
ALTER TABLE elemento AUTO_INCREMENT = 1;
ALTER TABLE categoria AUTO_INCREMENT = 1;
ALTER TABLE tipodeelemento AUTO_INCREMENT = 1;*/
