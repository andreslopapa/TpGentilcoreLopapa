package ui.Desktop;

import javax.swing.JInternalFrame;

public abstract class  Listado extends JInternalFrame{

	public enum Indice{ANTERIOR,POSTERIOR,ESTE};
	protected static final int FilasTabla=30;
	protected int cantidadIndices;
	protected int indiceActual;
	
	public Listado(){
		((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		//esto saca la barra de arriba
	}
}
