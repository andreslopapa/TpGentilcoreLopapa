package ui.Desktop;

import tools.Campo;
import business.entities.*;
import business.logic.*;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import javax.swing.JScrollPane;

public class ABMCPersona extends JInternalFrame{

	CtrlPersonaLogic ctrlPer = new CtrlPersonaLogic();
	private ArrayList<Persona> pers;// = new ArrayList<>();
	
	
	private JFrame frmSistemaDeGestin;
	private JTextField textUsuario;
	private JTextField textEmail;
	private JPasswordField passwordUsuarioField;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textDNI;
	private JComboBox comboCategoria;
	private JCheckBox chckbxHabilitado; 
	private JTable tablePersona;
	private JScrollPane scrollPaneTablaPersona;
	


	private static ABMCPersona Instancia=null;
	private JButton btnReiniciarListado;
	private JButton btnBotonquebusca;
	public static ABMCPersona getInstancia()throws Exception{
		if(Instancia==null){
			Instancia=new ABMCPersona();
		}
		return Instancia;
	}
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ABMCPersona window = new ABMCPersona();
//					window.frmSistemaDeGestin.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	 // Create the application.

	private ABMCPersona() throws Exception {
		getContentPane().setBackground(Color.WHITE);
		initialize();
	}

	// Initialize the contents of the frame.
	private void initialize() throws Exception {
		/*frmSistemaDeGestin = new JFrame();
		frmSistemaDeGestin.setIconImage(Toolkit.getDefaultToolkit().getImage(ABMCPersona.class.getResource("/ui/Desktop/cropped-3w2-web-dominios-hosting.png")));
		frmSistemaDeGestin.getContentPane().setBackground(Color.WHITE);
		frmSistemaDeGestin.setFont(new Font("Calibri", Font.PLAIN, 12));
		frmSistemaDeGestin.setTitle("SISTEMA DE GESTI\u00D3N DE RESERVAS");
		frmSistemaDeGestin.setBounds(100, 100, 770, 451);
		frmSistemaDeGestin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
		
		
		
		setBorder(null);											
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null); //estas dos ultimas lineas quitan bordes y barra superior de la ventana
		
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setForeground(new Color(0, 51, 102));
		lblUsuario.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblContrasenia = new JLabel("Contrase\u00F1a");

		lblContrasenia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasenia.setForeground(new Color(0, 51, 102));
		lblContrasenia.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setForeground(new Color(0, 51, 102));
		lblEmail.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		textUsuario = new JTextField();
		textUsuario.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		
		passwordUsuarioField = new JPasswordField();
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setForeground(new Color(0, 51, 102));
		lblNombre.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido.setForeground(new Color(0, 51, 102));
		lblApellido.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		textApellido = new JTextField();
		textApellido.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCategoria.setForeground(new Color(0, 51, 102));
		lblCategoria.setFont(new Font("Calibri", Font.PLAIN, 14));

		
		JLabel lblGestinDeNuevo = new JLabel("Gesti\u00F3n de Usuarios");
		lblGestinDeNuevo.setForeground(new Color(0, 51, 102));
		lblGestinDeNuevo.setFont(new Font("Calibri", Font.BOLD, 18));
		
		JButton btnGuardar = new JButton("");
		btnGuardar.setIcon(new ImageIcon(ABMCPersona.class.getResource("/ui/Desktop/Agregar.png")));
		btnGuardar.setToolTipText("Crear nuevo usuario");
		btnGuardar.setForeground(new Color(0, 51, 102));
		btnGuardar.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				try {
					guardarClick();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		
	
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDni.setForeground(new Color(0, 51, 102));
		lblDni.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		textDNI = new JTextField();
		textDNI.setColumns(10);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.setToolTipText("Buscar persona");
		btnBuscar.setIcon(new ImageIcon(ABMCPersona.class.getResource("/ui/Desktop/ic_search_black_24dp_1x.png")));
		btnBuscar.setForeground(new Color(0, 51, 102));
		btnBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					buscarClick();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		
		 comboCategoria = new JComboBox();
		 comboCategoria.setForeground(new Color(0, 51, 102));
		
		JButton btnModificar = new JButton("");
		btnModificar.setIcon(new ImageIcon(ABMCPersona.class.getResource("/ui/Desktop/Editar.png")));
		btnModificar.setToolTipText("Actualizar datos del usuario");
		btnModificar.setForeground(new Color(0, 51, 102));
		btnModificar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					modificarClick();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		
		JButton btnBorrar = new JButton("");
		btnBorrar.setIcon(new ImageIcon(ABMCPersona.class.getResource("/ui/Desktop/Borrar.png")));
		btnBorrar.setToolTipText("Borrar usuario");
		btnBorrar.setForeground(new Color(153, 0, 0));
		btnBorrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					eliminarClick();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error al apretar en boton borrar\n"+e1.getMessage());
				}
			}
		});
		
		chckbxHabilitado = new JCheckBox("");
		chckbxHabilitado.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxHabilitado.setForeground(new Color(0, 51, 102));
		chckbxHabilitado.setBackground(Color.WHITE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 51, 102));
		
		JLabel lblIconousuario = new JLabel("");
		lblIconousuario.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblIconousuario.setIcon(new ImageIcon(ABMCPersona.class.getResource("/ui/Desktop/ic_devices_white_24dp_2x.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(23)
					.addComponent(lblIconousuario)
					.addContainerGap(59, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(19)
					.addComponent(lblIconousuario)
					.addContainerGap(377, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		scrollPaneTablaPersona = new JScrollPane();
		scrollPaneTablaPersona.setBackground(Color.WHITE);			

		
		btnBotonquebusca = new JButton("");
		btnBotonquebusca.setToolTipText("Seleccionar persona para visualizarla en formulario");
		btnBotonquebusca.setIcon(new ImageIcon(ABMCPersona.class.getResource("/ui/Desktop/ic_touch_app_black.png")));
		btnBotonquebusca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					buscaPersona();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error al apretar en boton Buscar\n"+e.getMessage());
				}
			}
		});
		
		JButton btnBuscarenlista = new JButton("");
		btnBuscarenlista.setToolTipText("Mostrar listado para buscar");
		btnBuscarenlista.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					clickMostrarListado();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error con boton Mostrar Listado Personas\n"+e1.getMessage());
				}
			}
		});
		
		btnBuscarenlista.setSelectedIcon(new ImageIcon(ABMCPersona.class.getResource("/ui/Desktop/buscaPersonaListad.png")));
		btnBuscarenlista.setIcon(new ImageIcon(ABMCPersona.class.getResource("/ui/Desktop/buscaPersonaLista.png")));
		
		JLabel lblHabilitado = new JLabel("Habilitado");
		lblHabilitado.setForeground(new Color(0, 51, 102));
		lblHabilitado.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblHabilitado.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblListadoDePersonas = new JLabel("Listado de Personas");
		lblListadoDePersonas.setForeground(new Color(0, 51, 102));
		lblListadoDePersonas.setFont(new Font("Calibri", Font.PLAIN, 18));
		
		btnReiniciarListado = new JButton("");
		btnReiniciarListado.setToolTipText("Recargar tabla");
		btnReiniciarListado.setIcon(new ImageIcon(ABMCPersona.class.getResource("/ui/Desktop/ic_replay_black_24dp_1x.png")));
		//btnReiniciarListado.setIcon(new ImageIcon(ABMCPersona.class.getResource("/ui/Desktop/ic_replay_black_24dp_1x.png")));
		//btnReiniciarListado.setIcon(null);
		btnReiniciarListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actualizarLista();
			}

			
		});

		
		JButton btnLimpiarCampos = new JButton("");
		btnLimpiarCampos.setToolTipText("Limpiar formulario");
		btnLimpiarCampos.setIcon(new ImageIcon(ABMCPersona.class.getResource("/ui/Desktop/escoba.png")));
		btnLimpiarCampos.setFont(new Font("Calibri", Font.PLAIN, 9));
		btnLimpiarCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarTexto();
			}
		});
//		GroupLayout groupLayout = new GroupLayout(frmSistemaDeGestin.getContentPane());
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addGap(74)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblCategoria, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblUsuario, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblDni, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addComponent(lblApellido, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblNombre, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblContrasenia, Alignment.TRAILING))))
								.addComponent(lblHabilitado))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(textEmail, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
												.addComponent(textDNI, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(2)
											.addComponent(lblGestinDeNuevo, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnModificar, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnBorrar, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnLimpiarCampos, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
								.addComponent(textUsuario, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
								.addComponent(passwordUsuarioField, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
								.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
								.addComponent(chckbxHabilitado, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(comboCategoria, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(textApellido, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap())
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblListadoDePersonas)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnBuscarenlista, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
										.addGap(593))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(scrollPaneTablaPersona, GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnBotonquebusca, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
										.addGap(46)))
								.addGap(41))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnReiniciarListado, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblGestinDeNuevo, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
							.addGap(23))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnLimpiarCampos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnGuardar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnModificar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnBorrar))
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDni, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblUsuario, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(passwordUsuarioField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblContrasenia, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblApellido, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboCategoria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCategoria, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)))
						.addComponent(btnBuscar))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblHabilitado)
						.addComponent(chckbxHabilitado))
					.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblListadoDePersonas)
						.addComponent(btnBuscarenlista, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addGap(13)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnBotonquebusca)
						.addComponent(scrollPaneTablaPersona, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnReiniciarListado, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(87))
		);
		
		
		tablePersona = new JTable();
		tablePersona.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablePersona.getTableHeader().setResizingAllowed(false);
		tablePersona.getTableHeader().setReorderingAllowed(false);
		scrollPaneTablaPersona.setViewportView(tablePersona);
		tablePersona.setFont(new Font("Calibri", Font.PLAIN, 14));
		tablePersona.setBackground(Color.WHITE);
	//	frmSistemaDeGestin.getContentPane().setLayout(groupLayout);
		getContentPane().setLayout(groupLayout);
		
		cargarListas();		//Lista del combo


		cargarListaPersona();	//Tabla									
		initDataBindings();


	}

	private void cargarListas() {
		try {//setModel:  es una representacion de los datos que tiene adentro. Como se ordeanan
			//DefaultComboBoxModel:   recibe como parametro un array con los elementos a mostrar
			this.comboCategoria.setModel(new DefaultComboBoxModel(ctrlPer.getCategorias().toArray()));
			this.comboCategoria.setSelectedIndex(-1);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frmSistemaDeGestin, e.getMessage());
		}
	}
	
	//Crear nueva persona
	protected void guardarClick(){
		try {		
			if(validaCampos()){
		
				ctrlPer.add(this.mapearDeForm());
				actualizarLista();
				JOptionPane.showMessageDialog(frmSistemaDeGestin, "Usuario guardado correctamente", "", JOptionPane.INFORMATION_MESSAGE);
			}
		else{
				JOptionPane.showMessageDialog(null, Campo.getMensaje(), "", JOptionPane.INFORMATION_MESSAGE);
			}
		} 
//		catch (SQLException ex) {
//			JOptionPane.showMessageDialog(frmSistemaDeGestin, "Usuario y/o DNI ya existentes."+ex.getMessage());
//	    }
		catch (Exception e) {
			JOptionPane.showMessageDialog(frmSistemaDeGestin, e.getMessage());
		} 
	}

	private boolean validaCampos() {
		Boolean valido=false;
		
		valido= (Campo.Valida(textDNI.getText(), Campo.tipo.DNI) && 
		   Campo.Valida(textEmail.getText(), Campo.tipo.EMAIL) &&
		   Campo.Valida(textUsuario.getText(), Campo.tipo.OTRO)&&
		   Campo.Valida(String.valueOf(passwordUsuarioField.getPassword()), Campo.tipo.OTRO) &&
		   Campo.Valida(textApellido.getText(), Campo.tipo.OTRO) &&
		   Campo.Valida(textNombre.getText(), Campo.tipo.OTRO));
		if(this.comboCategoria.getSelectedIndex()==-1 && valido){
			Campo.setMensaje("Debe seleccionar una categoria");
			valido=false;
		}
		return valido;
	}
	
	//Buscar persona
	protected void buscarClick(){
		try {
			
			if(Campo.Valida(textDNI.getText(), Campo.tipo.DNI)){
				Persona per=ctrlPer.getByDni(this.mapearDeForm());
				if(per!=null){this.mapearAForm(per);}
				else{ JOptionPane.showMessageDialog(null, "Persona inexistente","",JOptionPane.INFORMATION_MESSAGE);}
			}
			else{
				JOptionPane.showMessageDialog(null, Campo.getMensaje(), "", JOptionPane.INFORMATION_MESSAGE);				
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frmSistemaDeGestin,e.getMessage(), "", JOptionPane.WARNING_MESSAGE);
		}
	}

	protected void modificarClick(){
		try {
			if(this.validaCampos()){
				ctrlPer.update(mapearDeForm());
				actualizarLista();
				JOptionPane.showMessageDialog(frmSistemaDeGestin, "Usuario actualizado", "", JOptionPane.INFORMATION_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(null, Campo.getMensaje(), "", JOptionPane.INFORMATION_MESSAGE);
			}
		} 
		catch (Exception e) {
			//limpiarTexto();
			JOptionPane.showMessageDialog(frmSistemaDeGestin, e.getMessage(), "", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	
	protected void eliminarClick(){
		try {
			if(Campo.Valida(textDNI.getText(), Campo.tipo.DNI)){
				ctrlPer.delete(mapearDeForm());
				actualizarLista();
				JOptionPane.showMessageDialog(null, "Persona eliminada", "", JOptionPane.INFORMATION_MESSAGE);
				this.limpiarTexto();
			}else{
				JOptionPane.showMessageDialog(null, Campo.getMensaje(), "", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e) {
			limpiarTexto();
			JOptionPane.showMessageDialog(null, e.getMessage(), "", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	private Persona mapearDeForm(){
		Persona p= new Persona();
		Categoria c = new Categoria();
		p.setDni(this.textDNI.getText());
		p.setEmail(this.textEmail.getText());
		p.setNombre(this.textNombre.getText());
		p.setApellido(this.textApellido.getText());
		p.setUsuario(this.textUsuario.getText());
		p.setContrasenia(String.valueOf(passwordUsuarioField.getPassword()));			
		p.setCategoria((Categoria) this.comboCategoria.getSelectedItem());
		p.setHabilitado(this.chckbxHabilitado.isSelected());

		return p;
		}
	
	private void mapearAForm(Persona p){
		this.textUsuario.setText(p.getUsuario());
		this.textEmail.setText(p.getEmail());
		this.passwordUsuarioField.setText(p.getContrasenia());
		this.textDNI.setText(p.getDni());
		this.textNombre.setText(p.getNombre());
		this.textApellido.setText(p.getApellido());
		this.comboCategoria.setSelectedItem((Categoria) p.getCategoria());
		this.chckbxHabilitado.setSelected(p.isHabilitado());
}
	
	private void limpiarTexto(){
		this.textDNI.setText("");
		this.textNombre.setText("");
		this.textApellido.setText("");
		this.textUsuario.setText("");
		this.passwordUsuarioField.setText("");
		this.textEmail.setText("");
		this.chckbxHabilitado.setSelected(false);
		comboCategoria.setSelectedIndex(-1);
	}
	
	
	
	protected ArrayList<Persona> cargarListaPersona(){
		try {
			pers= this.ctrlPer.getAll();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,e.getMessage(),"Error al cargar Personas",JOptionPane.ERROR_MESSAGE);
		}
		return pers;
	}
	
	
													///////////////////////////////////////////
	public void clickMostrarListado(){		//ESTE NO FUNCIONA. PERO ESTAR�A COPADO QUE SI LO HAGA JAJA. HAY 

		if(this.scrollPaneTablaPersona.isVisible()){
			this.scrollPaneTablaPersona.setVisible(false);
			this.btnBotonquebusca.setVisible(false);
			this.btnReiniciarListado.setVisible(false);
			}
		else{
			this.scrollPaneTablaPersona.setVisible(true);
			this.btnBotonquebusca.setVisible(true);
			this.btnReiniciarListado.setVisible(true);
		}
//		if(visibilidadTabla==1){
//			scrollPaneTablaPersona = new JScrollPane();	
//			scrollPaneTablaPersona.setVisible(true);
//			
//			visibilidadTabla=visibilidadTabla*-1;
//		}else{
//			scrollPaneTablaPersona.setVisible(false);
//			visibilidadTabla=visibilidadTabla*-1;
//		}
		
	}
	
	
	public void buscaPersona(){
		if(this.tablePersona.getSelectedRowCount()!=0){
		int indexPersona= tablePersona.convertRowIndexToModel(tablePersona.getSelectedRow());
		this.showPersona(this.pers.get(indexPersona));}

	}
	
	
	public void showPersona(Persona p){
		this.mapearAForm(p);
		
	}
	private void actualizarLista() {
		cargarListaPersona();										
		initDataBindings();
	}

	protected void initDataBindings() {
		JTableBinding<Persona, List<Persona>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, pers, tablePersona, "tablaPersonas");
		//
		BeanProperty<Persona, Integer> personaBeanProperty = BeanProperty.create("id");
		jTableBinding.addColumnBinding(personaBeanProperty).setColumnName("ID");
		//
		BeanProperty<Persona, String> personaBeanProperty_1 = BeanProperty.create("dni");
		jTableBinding.addColumnBinding(personaBeanProperty_1).setColumnName("DNI");
		//
		BeanProperty<Persona, String> personaBeanProperty_2 = BeanProperty.create("apellido");
		jTableBinding.addColumnBinding(personaBeanProperty_2).setColumnName("Apellido");
		//
		BeanProperty<Persona, String> personaBeanProperty_3 = BeanProperty.create("nombre");
		jTableBinding.addColumnBinding(personaBeanProperty_3).setColumnName("Nombre");
		//
		BeanProperty<Persona, String> personaBeanProperty_4 = BeanProperty.create("usuario");
		jTableBinding.addColumnBinding(personaBeanProperty_4).setColumnName("Usuario");
		//
		BeanProperty<Persona, String> personaBeanProperty_5 = BeanProperty.create("contrasenia");
		jTableBinding.addColumnBinding(personaBeanProperty_5).setColumnName("Contrase\u00F1a");
		//
		BeanProperty<Persona, String> personaBeanProperty_6 = BeanProperty.create("email");
		jTableBinding.addColumnBinding(personaBeanProperty_6).setColumnName("Email");
		//
		BeanProperty<Persona, String> personaBeanProperty_7 = BeanProperty.create("categoria.descripcion");
		jTableBinding.addColumnBinding(personaBeanProperty_7).setColumnName("Categoria");
		//
		BeanProperty<Persona, Boolean> personaBeanProperty_8 = BeanProperty.create("habilitado");
		jTableBinding.addColumnBinding(personaBeanProperty_8).setColumnName("Habilitado");
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
	}
}