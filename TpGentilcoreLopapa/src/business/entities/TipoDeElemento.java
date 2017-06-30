package business.entities;

import java.util.Date;

public class TipoDeElemento {
	private int id;
	private String nombre;
	private int cant_max_reservas; 
	private Date dias_min_anticipacion;			
	//este ultimo campo podria INT. Ya que dice que un TipoDeElemento PUEDE tener una cantidad maxima de dias. en dicho caso le ponemos 0. ESCUCHO OPINION LOPAPA
	
	
	//adem�s AGREGAR CAMPO horas maxima de tiempo de reserva (en horas)
	
}
