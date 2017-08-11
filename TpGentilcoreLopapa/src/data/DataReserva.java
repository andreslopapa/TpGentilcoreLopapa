package data;

public class DataReserva {
//insert into reserva (id_persona, id_elemento, fecha_hora, detalle) values (?,?,now(),?)


//select id_persona, id_elemento, DATE_FORMAT(fecha_hora,'%d/%m/%Y a las %H:%i') as fecha_llamada, detalle from reserva
	
	
	
	
	//
	//SELECT detalle, DATE_FORMAT(fecha_hora,'%d/%m/%Y a las %H:%i') AS fechaLlamada FROM reserva  ;

//	insert into reserva (id_persona, id_elemento, fecha_hora_solcitada, fecha_hora_reserva, detalle) values (5,3,20170930,now(),"Lo atendió Ignacio, la compu tenía una marca");

/*
select  per.apellido, 
		per.nombre,
		Concat(per.apellido, N', ',per.nombre) as 'Nombre y Apellido',
		res.id_elemento, 
		DATE_FORMAT(fecha_hora_reserva,'%d/%m/%Y a las %H:%i') as 'Fecha y hora de la reserva', 
        res.detalle,
        elem.nombre
from reserva res
	inner join persona per on per.id_persona = res.id_persona
    inner join elemento elem on elem.id_elemento=res.id_elemento;

	*/
}
