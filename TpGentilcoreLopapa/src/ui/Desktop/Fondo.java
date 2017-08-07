package ui.Desktop;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Fondo extends JPanel {

	ImageIcon imagenFondo;
	private JTextField textField;
	
	public Fondo(String rutaImagen){
		super();
		initialize();
		imagenFondo=new ImageIcon(this.getClass().getResource(rutaImagen));
		//setSize(imagenFondo.getIconWidth(),imagenFondo.getIconHeight());
	}
	
	protected void paintComponent(Graphics g){
		
		Dimension d=this.getSize();
		g.drawImage(imagenFondo.getImage(), 0, 0, d.width,d.height,null);
		this.setOpaque(false);
		super.paintComponent(g);
	}
	
	private void initialize(){
		this.setLayout(null);
		
		
	}
}
