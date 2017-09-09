package ui.Desktop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import business.entities.*;

import javax.swing.JMenu;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;

public class MainWindow {

	private JFrame frmSistemaDeReservas;
	private JDesktopPane desktopPane;
	private static ListadoElementos le;
	private static ABMCPersona abmcper;			//proxima etapa deber�a llamar a listado persona
	
    //agregar los listados que faltan
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmSistemaDeReservas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSistemaDeReservas = new JFrame();
		frmSistemaDeReservas.setExtendedState(frmSistemaDeReservas.MAXIMIZED_BOTH);
		frmSistemaDeReservas.getContentPane().setBackground(Color.WHITE);
		
		desktopPane = new JDesktopPane();
		frmSistemaDeReservas.getContentPane().add(desktopPane, BorderLayout.CENTER);
		frmSistemaDeReservas.setTitle("Sistema de Reservas");
		frmSistemaDeReservas.setBounds(100, 100, 450, 300);
		frmSistemaDeReservas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmSistemaDeReservas.setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Inicio");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmListadoElementos = new JMenuItem("Listado Elementos");
		mntmListadoElementos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listadoElementosClick();
			}

		});
		mnArchivo.add(mntmListadoElementos);
		
		JMenuItem mntmListadoReservas = new JMenuItem("Listado Reservas");
		mnArchivo.add(mntmListadoReservas);
		
	
		JMenuItem mntmListadoTiposElementos = new JMenuItem("Listado Tipos de Elementos");
		mnArchivo.add(mntmListadoTiposElementos);
		
		JMenuItem mntmListadoCategorias = new JMenuItem("Listado Categorias");
		mnArchivo.add(mntmListadoCategorias);
		
		JMenuItem mntmListadoPersonas = new JMenuItem("Administrar usuarios");
		mntmListadoPersonas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listadoPersonasClick();
			}

		});
		mnArchivo.add(mntmListadoPersonas);
		
		JMenuItem mntmCambiarPass = new JMenuItem("Cambiar Contrase�a");
		mnArchivo.add(mntmCambiarPass);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salirClick();
			}
		});
		
		
		mnArchivo.add(mntmSalir);
	}

	public void listadoElementosClick() {
		try {
			desktopPane.removeAll();
			le = ListadoElementos.getInstancia();
			desktopPane.add(le);
			le.setVisible(true);
			le.setMaximum(true);
		} 
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Error al llamar a la ventana que lista elementos\n"+
		                                e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
		
	}

	
	
	public void listadoPersonasClick(){			//proxima etapa hacer listado de personas para que quede similar a listadoelementos
		

		try {
			desktopPane.removeAll();
							abmcper = new ABMCPersona();
						//	abmcper.main();
							desktopPane.add(abmcper);
							abmcper.setVisible(true);
							abmcper.setMaximum(true);
							
			
			}		 
		catch(PropertyVetoException e){
			JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
		catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Error al llamar a la ventana de Personas",
					"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	
	protected void salirClick() {
		
		frmSistemaDeReservas.dispose();		
	}

	
	
	
}
