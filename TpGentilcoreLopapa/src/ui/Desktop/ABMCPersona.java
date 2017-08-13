package ui.Desktop;

import tools.AppDataException;
import business.entities.*;
import business.logic.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
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

public class ABMCPersona {

	CtrlPersonaLogic perLogic = new CtrlPersonaLogic();
	
	private JFrame frmSistemaDeGestin;
	private JTextField textUsuario;
	private JTextField textEmail;
	private JPasswordField passwordUsuarioField;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textDNI;
	private JComboBox comboCategoria;
	private JCheckBox chckbxHabilitado; 
	
	

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
		initialize();
	}

	// Initialize the contents of the frame.
	private void initialize() throws Exception {
		frmSistemaDeGestin = new JFrame();
		frmSistemaDeGestin.setIconImage(Toolkit.getDefaultToolkit().getImage(ABMCPersona.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
		frmSistemaDeGestin.getContentPane().setBackground(Color.WHITE);
		frmSistemaDeGestin.setFont(new Font("Calibri", Font.PLAIN, 12));
		frmSistemaDeGestin.setTitle("SISTEMA DE GESTI\u00D3N DE RESERVAS");
		frmSistemaDeGestin.setBounds(100, 100, 770, 451);
		frmSistemaDeGestin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSistemaDeGestin.getContentPane().setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setForeground(new Color(0, 51, 102));
		lblUsuario.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblUsuario.setBounds(185, 137, 87, 14);
		frmSistemaDeGestin.getContentPane().add(lblUsuario);
		
		JLabel lblContrasenia = new JLabel("Contrase\u00F1a");

		lblContrasenia.setBounds(185, 168, 89, 14);

		lblContrasenia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasenia.setBounds(210, 168, 64, 14);
		lblContrasenia.setForeground(new Color(0, 51, 102));
		lblContrasenia.setFont(new Font("Calibri", Font.PLAIN, 14));

		frmSistemaDeGestin.getContentPane().add(lblContrasenia);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(185, 106, 87, 14);
		lblEmail.setForeground(new Color(0, 51, 102));
		lblEmail.setFont(new Font("Calibri", Font.PLAIN, 14));
		frmSistemaDeGestin.getContentPane().add(lblEmail);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(305, 134, 215, 20);
		frmSistemaDeGestin.getContentPane().add(textUsuario);
		textUsuario.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(305, 103, 215, 20);
		frmSistemaDeGestin.getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		passwordUsuarioField = new JPasswordField();
		passwordUsuarioField.setBounds(305, 165, 215, 20);
		frmSistemaDeGestin.getContentPane().add(passwordUsuarioField);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(185, 199, 89, 14);
		lblNombre.setForeground(new Color(0, 51, 102));
		lblNombre.setFont(new Font("Calibri", Font.PLAIN, 14));
		frmSistemaDeGestin.getContentPane().add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(305, 196, 215, 20);
		frmSistemaDeGestin.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido.setBounds(185, 230, 89, 14);
		lblApellido.setForeground(new Color(0, 51, 102));
		lblApellido.setFont(new Font("Calibri", Font.PLAIN, 14));
		frmSistemaDeGestin.getContentPane().add(lblApellido);
		
		textApellido = new JTextField();
		textApellido.setBounds(305, 227, 215, 20);
		frmSistemaDeGestin.getContentPane().add(textApellido);
		textApellido.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCategoria.setBounds(185, 261, 89, 14);
		lblCategoria.setForeground(new Color(0, 51, 102));
		lblCategoria.setFont(new Font("Calibri", Font.PLAIN, 14));
		frmSistemaDeGestin.getContentPane().add(lblCategoria);

		
		JLabel lblGestinDeNuevo = new JLabel("Nuevo usuario");
		lblGestinDeNuevo.setForeground(new Color(0, 51, 102));
		lblGestinDeNuevo.setFont(new Font("Calibri", Font.BOLD, 18));
		lblGestinDeNuevo.setBounds(307, 35, 213, 14);
		frmSistemaDeGestin.getContentPane().add(lblGestinDeNuevo);
		
		JButton btnGuardar = new JButton("Guardar");
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
			
		
		btnGuardar.setBounds(564, 353, 89, 23);
		frmSistemaDeGestin.getContentPane().add(btnGuardar);
		
	
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDni.setBounds(185, 75, 87, 14);
		lblDni.setForeground(new Color(0, 51, 102));
		lblDni.setFont(new Font("Calibri", Font.PLAIN, 14));
		frmSistemaDeGestin.getContentPane().add(lblDni);
		
		textDNI = new JTextField();
		textDNI.setBounds(305, 72, 215, 20);
		frmSistemaDeGestin.getContentPane().add(textDNI);
		textDNI.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
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
		btnBuscar.setBounds(564, 72, 89, 23);
		frmSistemaDeGestin.getContentPane().add(btnBuscar);
		
		 comboCategoria = new JComboBox();
		 comboCategoria.setForeground(new Color(0, 51, 102));
	//	comboCategoria.setModel(new DefaultComboBoxModel(new Categoria[] {new Categoria(1,"Administrador"), new Categoria(2,"Encargado"), new Categoria(3,"Usuario")}));
		comboCategoria.setBounds(305, 258, 215, 20);
		frmSistemaDeGestin.getContentPane().add(comboCategoria);
		
		JButton btnModificar = new JButton("Modificar");
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
		
		btnModificar.setBounds(307, 353, 89, 23);
		frmSistemaDeGestin.getContentPane().add(btnModificar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setForeground(new Color(153, 0, 0));
		btnBorrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					eliminarClick();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnBorrar.setBounds(210, 353, 89, 23);
		frmSistemaDeGestin.getContentPane().add(btnBorrar);
		
		chckbxHabilitado = new JCheckBox("   Habilitado");
		chckbxHabilitado.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxHabilitado.setForeground(new Color(0, 51, 102));
		chckbxHabilitado.setBackground(Color.WHITE);
		chckbxHabilitado.setBounds(305, 297, 97, 23);
		frmSistemaDeGestin.getContentPane().add(chckbxHabilitado);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 51, 102));
		panel.setBounds(0, 0, 130, 415);
		frmSistemaDeGestin.getContentPane().add(panel);
		
		cargarListas();		
	}

	private void cargarListas() throws Exception {
		try {
			this.comboCategoria.setModel(new DefaultComboBoxModel(perLogic.getCategorias().toArray()));
			this.comboCategoria.setSelectedIndex(-1);
		} catch (SQLException sqlex) {
			throw new AppDataException(sqlex, "Error al cargar listas, metodo guardarClick");	
		}
	}
	
	protected void guardarClick() throws Exception{
		try {
			perLogic.add(this.mapearDeForm());
			this.limpiarTexto();
		} catch (Exception sqlex) {

			throw new AppDataException(sqlex, "Error al guardar, metodo guardarClick");	
		}
	}
	
	
	protected void buscarClick()  throws Exception{
		try {
			this.mapearAForm(perLogic.getByDni(this.mapearDeForm()));
		} catch (Exception sqlex) {
				throw new AppDataException(sqlex, "Error al buscar mtodo buscarClick");			//MECA: 			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	protected void modificarClick() throws Exception{
		try {
			perLogic.update(mapearDeForm());
			this.limpiarTexto();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	protected void eliminarClick() throws Exception{
		try {
			perLogic.delete(mapearDeForm());
			this.limpiarTexto();
		} catch (Exception e) {
			e.printStackTrace();
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

	}
}