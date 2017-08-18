package ui.Desktop;

import javax.swing.JInternalFrame;

public class  Listado extends JInternalFrame{

	public enum Indice{ANTERIOR,POSTERIOR,ESTE};
	protected final int FilasTabla=30;
	protected int cantidadIndices;
	protected int indiceActual;
}
