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
import java.awt.Toolkit;

public class MainWindow {

	private JFrame frmSistemaDeReservas;
	private JDesktopPane desktopPane;
	private ListadoElementos le;
	private ListadoReservas lr;
	private ABMCPersona abmcper;	
	private ABMCTipoDeElemento abmctde;
	//private ListadoPersona lp;
	private InformacionSistema info;
	private JMenu mnArchivo;
	private JMenuItem mntmListadoPersonas;
	private JMenuItem mntmSalir;
	private JMenuItem mntmListadoTipos;
	private JMenuItem mntmNosotros;
	private JMenu mnAcercaDe;
	private JMenuItem mntmListadoElementos;
	private JMenuItem mntmListadoReservas;
	private JMenuBar menuBar;
	
  
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmSistemaDeReservas.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
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
		frmSistemaDeReservas.setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/ui/Desktop/cropped-3w2-web-dominios-hosting.png")));
		frmSistemaDeReservas.setExtendedState(frmSistemaDeReservas.MAXIMIZED_BOTH);
		frmSistemaDeReservas.getContentPane().setBackground(Color.WHITE);
		
		desktopPane = new JDesktopPane();
		frmSistemaDeReservas.getContentPane().add(desktopPane, BorderLayout.CENTER);
		frmSistemaDeReservas.setTitle("Sistema de Reservas Patalalas ");
		frmSistemaDeReservas.setBounds(100, 100, 450, 300);
		frmSistemaDeReservas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menuBar = new JMenuBar();
		frmSistemaDeReservas.setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Inicio");
		menuBar.add(mnArchivo);
		
		
		
		mntmListadoElementos = new JMenuItem("Listado Elementos");
		mntmListadoElementos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listadoElementosClick();
			}

		});
		mnArchivo.add(mntmListadoElementos);
		
		mntmListadoReservas = new JMenuItem("Listado Reservas");
		mntmListadoReservas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listadoReservasClick();
			}

		});
		mnArchivo.add(mntmListadoReservas);
		
	
		/*JMenuItem mntmListadoTiposElementos = new JMenuItem("Listado Tipos de Elementos");
		mnArchivo.add(mntmListadoTiposElementos);*/
		
		/*JMenuItem mntmListadoCategorias = new JMenuItem("Listado Categorias");
		mnArchivo.add(mntmListadoCategorias);*/
		
		mntmListadoPersonas = new JMenuItem("Administrar Usuarios");
		mntmListadoPersonas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listadoPersonasClick();
			}

		});
		mnArchivo.add(mntmListadoPersonas);
		
/*
		JMenuItem mntmListadoDePersonas = new JMenuItem("Listado Personas");
		mntmListadoDePersonas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listadoPersonasClickLISTA();
			}
		});
		mnArchivo.add(mntmListadoDePersonas);
*/

//		JMenuItem mntmCambiarPass = new JMenuItem("Cambiar Contrase�a");
//		mnArchivo.add(mntmCambiarPass);

		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salirClick();
			}
		});
		
		mntmListadoTipos = new JMenuItem("Administrar Tipos de Elementos");
		mntmListadoTipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listadoTiposEClick();
			}

		});
		mnArchivo.add(mntmListadoTipos);
		
		
		mnArchivo.add(mntmSalir);
		
		mnAcercaDe = new JMenu("Acerca de");
		menuBar.add(mnAcercaDe);
		
		mntmNosotros = new JMenuItem("Nosotros");
		mntmNosotros.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				informacionSistemaClick();
			}
		});
		mnAcercaDe.add(mntmNosotros);
		
		this.setPermisos();
	}

	private void listadoElementosClick() {
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

	private void listadoReservasClick(){
		try{
			desktopPane.removeAll();
			lr=ListadoReservas.getInstancia();
			lr.Actualiza();
			desktopPane.add(lr);
			lr.setVisible(true);
			lr.setMaximum(true);
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null, "Error al llamar a la ventana que lista reservas\n"+
										ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/*
	public void listadoPersonasClickLISTA(){
		try {
		desktopPane.removeAll();
		lp = new ListadoPersona();
		desktopPane.add(lp);
		lp.setVisible(true);	
		lp.setMaximum(true);
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null, "Error al llamar a la ventana que lista personas\n"+
					ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
	}*/
	
	private void listadoPersonasClick(){			//proxima etapa hacer listado de personas para que quede similar a listadoelementos
		 try {
			desktopPane.removeAll();
			abmcper = ABMCPersona.getInstancia();
			desktopPane.add(abmcper);
			abmcper.setVisible(true);
			abmcper.setMaximum(true);
			}		 
		catch (Exception e) {
//			JOptionPane.showMessageDialog(null, "Error al llamar a la ventana de Personas\n"+e1.getMessage(),
//					"Error",JOptionPane.ERROR_MESSAGE);
			JOptionPane.showMessageDialog(null,"Error al llamar a la ventana que administra personas\n"+ e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void listadoTiposEClick(){
		try{
			desktopPane.removeAll();
			abmctde=ABMCTipoDeElemento.getInstancia();
			desktopPane.add(abmctde);
			abmctde.setVisible(true);
			abmctde.setMaximum(true);
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null, "Error al llamar a la ventana que administra tipos de elementos\n"+ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void informacionSistemaClick(){
		try {
			desktopPane.removeAll();
			info = new InformacionSistema();
			desktopPane.add(info);
			info.setVisible(true);		
			info.setMaximum(true);
		} 
		catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Error al llamar a la ventana de Informacion del Sistema",
					"Error",JOptionPane.ERROR_MESSAGE);
			
		}
	}
	
	private void salirClick() {		
		frmSistemaDeReservas.dispose();		
	}
	
	private void setPermisos(){
		switch(Ingreso.PersonaLogueada.getCategoria().getDescripcion()){
		
		
		case "Administrador":break;
		case "Usuario":
		case "Encargado":
		default:
			mnArchivo.remove(this.mntmListadoTipos);
			mnArchivo.remove(this.mntmListadoPersonas);
		break;
		
		}
	}
	
	
}
