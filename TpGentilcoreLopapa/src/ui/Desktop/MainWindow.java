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

	/**
	 * Launch the application.
	 */
	public static void main(Persona per) {
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
		
		JMenu mnArchivo = new JMenu("Archivo");
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
		
		JMenuItem mntmListadoPersonas = new JMenuItem("Listado Personas");
		mnArchivo.add(mntmListadoPersonas);
		
		JMenuItem mntmListadoTiposElementos = new JMenuItem("Listado Tipos de Elementos");
		mnArchivo.add(mntmListadoTiposElementos);
		
		JMenuItem mntmListadoCategorias = new JMenuItem("Listado Categorias");
		mnArchivo.add(mntmListadoCategorias);
		
		JMenuItem mntmCambiarPass = new JMenuItem("Cambiar Contraseña");
		mnArchivo.add(mntmCambiarPass);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salirClick();
			}
		});
		
		
		mnArchivo.add(mntmSalir);
	}

	protected void listadoElementosClick() {
		ListadoElementos le=null;
		try {
			le = ListadoElementos.getInstancia();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Errpr al llamar a la ventana que lista elementos",
					"Error",JOptionPane.ERROR_MESSAGE);
		}
		desktopPane.add(le);
		le.setVisible(true);
		try {
			le.setMaximum(true);
		} catch (PropertyVetoException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
		
	}

	protected void salirClick() {
		
		frmSistemaDeReservas.dispose();
		
		
		
	}

}
