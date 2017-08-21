package ui.Desktop;

import ui.Desktop.Listado.Indice;

public interface IListados {

	//todos los metodos son public abstract
	//si quisiera declarar una variable seria public static final
	public abstract void buscarXIndiceClick(String indiceCampo,Indice tipoIndice);
	public abstract void initDataBindings();
	public abstract void Actualiza();
	
	
}
