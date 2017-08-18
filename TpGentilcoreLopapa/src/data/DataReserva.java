package data;

public class DataReserva {

	//INSERT
//insert into reserva(id_persona, id_elemento, fecha_hora_desde_solicitada,fecha_hora_hasta_solicitada,detalle) values(2,3,20170820,20170824,'Se entregó con raya superior');

	
	
/*posible query //// con FORMATO*/
/*
select  per.apellido, 
		per.nombre,
		Concat(per.apellido, N', ',per.nombre) as 'Nombre y Apellido',
		res.id_elemento, 
        DATE_FORMAT(fecha_hora_reserva_hecha,'%d/%m/%Y a las %H:%i') as 'Fecha y hora de fin de reserva',        
		DATE_FORMAT(fecha_hora_desde_solicitada,'%d/%m/%Y a las %H:%i') as 'Fecha y hora de inicio de reserva', 
		DATE_FORMAT(fecha_hora_hasta_solicitada,'%d/%m/%Y a las %H:%i') as 'Fecha y hora de fin de reserva', 
		fecha_hora_entregado			//esta será null por defecto, posible validador para cuando no se finalizo la reserva, por lo tanto no tiene fecha de fin
        res.detalle,
        elem.nombre
from reserva res
	inner join persona per on per.id_persona = res.id_persona
    inner join elemento elem on elem.id_elemento=res.id_elemento;    
*/
}
