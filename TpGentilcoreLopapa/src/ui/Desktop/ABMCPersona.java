package ui.Desktop;

import tools.AppDataException;
import business.entities.*;
import business.logic.*;
import tools.FormatoEmail;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JMenu;
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
	
	private int visibilidadTabla=1;

	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMCPersona window = new ABMCPersona();
					window.frmSistemaDeGestin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	 // Create the application.

	public ABMCPersona() throws Exception {
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
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnGuardar.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				try {
					guardarClick();
				} catch (Exception e1) {
					e1.printStackTrace();
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
		btnBuscar.setIcon(new ImageIcon(ABMCPersona.class.getResource("/ui/Desktop/ic_search_black_24dp_1x.png")));
		btnBuscar.setForeground(new Color(0, 51, 102));
		btnBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					buscarClick();
				} catch (Exception e1) {
					e1.printStackTrace();
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
					e1.printStackTrace();
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
					JOptionPane.showMessageDialog(null, "Error al apretar en botón borrar\n"+e1.getMessage());
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
		lblIconousuario.setIcon(new ImageIcon(ABMCPersona.class.getResource("/ui/Desktop/ic_person_add_white_24dp_2x.png")));
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

		
		JButton btnBotonquebusca = new JButton("");
		btnBotonquebusca.setToolTipText("Seleccionar persona para visualizarla en formulario");
		btnBotonquebusca.setIcon(new ImageIcon(ABMCPersona.class.getResource("/ui/Desktop/ic_touch_app_black.png")));
		btnBotonquebusca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					buscaPersona();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error al apretar en botón Buscar\n"+e.getMessage());
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
					JOptionPane.showMessageDialog(null, "Error con botón Mostrar Listado Personas\n"+e1.getMessage());
				}
			}
		});
		
		btnBuscarenlista.setSelectedIcon(new ImageIcon(ABMCPersona.class.getResource("/ui/Desktop/buscaPersonaListad.png")));
		btnBuscarenlista.setIcon(new ImageIcon(ABMCPersona.class.getResource("/ui/Desktop/buscaPersonaLista.png")));
		
		JLabel lblHabilitado = new JLabel("Habilitado");
		lblHabilitado.setForeground(new Color(0, 51, 102));
		lblHabilitado.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblHabilitado.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblMostrarListado = new JLabel("Mostrar listado");
		
		JLabel lblListadoDePersonas = new JLabel("Listado de Personas");
		lblListadoDePersonas.setForeground(new Color(0, 51, 102));
		lblListadoDePersonas.setFont(new Font("Calibri", Font.PLAIN, 18));
		
		JButton btnReiniciarListado = new JButton("Reiniciar");
		btnReiniciarListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargarListaPersona();										
				initDataBindings();
			}
		});

		btnReiniciarListado.setIcon(null);
		
		JButton btnLimpiarCampos = new JButton("Clear");
		btnLimpiarCampos.setFont(new Font("Calibri", Font.PLAIN, 9));
		btnLimpiarCampos.setIcon(null);
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
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblListadoDePersonas)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(scrollPaneTablaPersona, GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnBotonquebusca, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnReiniciarListado, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblHabilitado, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblDni, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblUsuario, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(25)
											.addComponent(lblContrasenia))
										.addComponent(lblNombre, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
										.addComponent(lblApellido, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
										.addComponent(lblCategoria, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(textUsuario, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
										.addComponent(passwordUsuarioField, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
										.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
												.addGroup(groupLayout.createSequentialGroup()
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(textEmail, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
														.addComponent(textDNI, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE))
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(btnBuscar, 0, 0, Short.MAX_VALUE))
												.addGroup(groupLayout.createSequentialGroup()
													.addGap(2)
													.addComponent(lblGestinDeNuevo, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(btnBorrar, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(btnModificar, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(chckbxHabilitado, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(comboCategoria, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(textApellido, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)))
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(btnBuscarenlista, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblMostrarListado)))
										.addGroup(groupLayout.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(btnLimpiarCampos)))))
							.addGap(52))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(54)
							.addComponent(lblDni, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
							.addGap(17)
							.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
							.addGap(17)
							.addComponent(lblUsuario, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
							.addGap(17)
							.addComponent(lblContrasenia, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
							.addGap(17)
							.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
							.addGap(17)
							.addComponent(lblApellido, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
							.addGap(17)
							.addComponent(lblCategoria, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblGestinDeNuevo, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
									.addGap(23))
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnLimpiarCampos)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblMostrarListado)
										.addPreferredGap(ComponentPlacement.RELATED))
									.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
											.addComponent(btnModificar, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
											.addComponent(btnBorrar, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
											.addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
										.addGap(18))))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(textDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(11)
									.addComponent(textEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(11)
									.addComponent(textUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(11)
									.addComponent(passwordUsuarioField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(11)
									.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(11)
									.addComponent(textApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(11)
									.addComponent(comboCategoria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnBuscar)
								.addComponent(btnBuscarenlista, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(11)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblHabilitado)
								.addComponent(chckbxHabilitado))
							.addGap(40)
							.addComponent(lblListadoDePersonas)
							.addGap(13)
							.addComponent(scrollPaneTablaPersona, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(125)
							.addComponent(btnBotonquebusca)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnReiniciarListado)))
					.addGap(122))
		);
		
		tablePersona = new JTable();
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
			if(textDNI.getText().length() >0 && textUsuario.getText().length() >0 && passwordUsuarioField.getText().length() >0 
					&& textNombre.getText().length() >0 && textApellido.getText().length() >0 &&  textEmail.getText().length()>0 ){				
			if(!FormatoEmail.esEmailCorrecto(textEmail.getText())){JOptionPane.showMessageDialog(frmSistemaDeGestin, "Email incorrecto", "", JOptionPane.WARNING_MESSAGE); 
			}else{
			ctrlPer.add(this.mapearDeForm());
			JOptionPane.showMessageDialog(frmSistemaDeGestin, "Usuario guardado correctamente", "", JOptionPane.OK_OPTION);}
			}else{
				JOptionPane.showMessageDialog(frmSistemaDeGestin, "Debe completar todos los campos", "", JOptionPane.WARNING_MESSAGE);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(frmSistemaDeGestin, "Usuario y/o DNI ya existentes."+ex.getMessage());
	    }catch (Exception e) {
			JOptionPane.showMessageDialog(frmSistemaDeGestin, e.getMessage());
		} 
	}
	
	//Buscar persona
	protected void buscarClick(){
		try {if(textDNI.getText().length() >0){
			this.mapearAForm(ctrlPer.getByDni(this.mapearDeForm()));
			}else{
				JOptionPane.showMessageDialog(frmSistemaDeGestin, "No se ha ingresado ningún usuario para buscar", "", JOptionPane.WARNING_MESSAGE);				
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frmSistemaDeGestin, "Usuario inexistente", "", JOptionPane.WARNING_MESSAGE);
		}
	}

	protected void modificarClick(){
		try {
			if(textDNI.getText().length() >0){
			ctrlPer.update(mapearDeForm());
			JOptionPane.showMessageDialog(frmSistemaDeGestin, "Usuario actualizado", "", JOptionPane.INFORMATION_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(frmSistemaDeGestin, "No se ha ingresado ningún usuario", "", JOptionPane.WARNING_MESSAGE);
			}
		} catch (Exception e) {
			limpiarTexto();
			JOptionPane.showMessageDialog(frmSistemaDeGestin, "No se ha podido actualizar el usuario", "", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	
	protected void eliminarClick(){
		try {if(textDNI.getText().length() >0){
			ctrlPer.delete(mapearDeForm());
			JOptionPane.showMessageDialog(frmSistemaDeGestin, "Usuario eliminado", "", JOptionPane.INFORMATION_MESSAGE);
			this.limpiarTexto();
			}else{
				JOptionPane.showMessageDialog(frmSistemaDeGestin, "No se ha ingresado ningún usuario", "", JOptionPane.WARNING_MESSAGE);
			}
		} catch (Exception e) {
			limpiarTexto();
			JOptionPane.showMessageDialog(frmSistemaDeGestin, "No se ha podido eliminar el usuario", "", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	private Persona mapearDeForm(){
		Persona p= new Persona();
		Categoria c = new Categoria();
		p.setDni(this.textDNI.getText());
		p.setNombre(this.textNombre.getText());
		p.setApellido(this.textApellido.getText());
		p.setUsuario(this.textUsuario.getText());
		p.setContrasenia(this.passwordUsuarioField.getText());			//detalle a tener en cuenta
		p.setEmail(this.textEmail.getText());
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
	public void clickMostrarListado(){		//ESTE NO FUNCIONA. PERO ESTARÏA COPADO QUE SI LO HAGA JAJA. HAY 

		if(visibilidadTabla==1){
			scrollPaneTablaPersona = new JScrollPane();	
			scrollPaneTablaPersona.setVisible(true);
			
			visibilidadTabla=visibilidadTabla*-1;
		}else{
			scrollPaneTablaPersona.setVisible(false);
			visibilidadTabla=visibilidadTabla*-1;
		}
		
	}
	
	
	public void buscaPersona(){
		int indexPersona= tablePersona.convertRowIndexToModel(tablePersona.getSelectedRow());
		this.showPersona(this.pers.get(indexPersona));

	}
	
	
	public void showPersona(Persona p){
		this.mapearAForm(p);
		
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