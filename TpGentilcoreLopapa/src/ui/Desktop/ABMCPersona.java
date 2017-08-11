package ui.Desktop;

import tools.AppDataException;
import business.entities.*;
import business.logic.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

public class ABMCPersona {

	PersonaLogic perLogic = new PersonaLogic();
	
	private JFrame frmSistemaDeGestin;
	private JTextField textUsuario;
	private JTextField textEmail;
	private JPasswordField passwordUsuarioField;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textDNI;
	private JComboBox comboBox;
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

	/**
	 * Create the application.
	 */
	public ABMCPersona() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSistemaDeGestin = new JFrame();
		frmSistemaDeGestin.getContentPane().setBackground(Color.WHITE);
		frmSistemaDeGestin.setFont(new Font("Calibri", Font.PLAIN, 12));
		frmSistemaDeGestin.setTitle("SISTEMA DE GESTI\u00D3N DE RESERVAS");
		frmSistemaDeGestin.setBounds(100, 100, 773, 453);
		frmSistemaDeGestin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSistemaDeGestin.getContentPane().setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setForeground(new Color(0, 51, 102));
		lblUsuario.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblUsuario.setBounds(43, 138, 62, 14);
		frmSistemaDeGestin.getContentPane().add(lblUsuario);
		
		JLabel lblContrasenia = new JLabel("Contrase\u00F1a");
		lblContrasenia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasenia.setBounds(43, 169, 64, 14);
		lblContrasenia.setForeground(new Color(0, 51, 102));
		lblContrasenia.setFont(new Font("Calibri", Font.PLAIN, 14));
		frmSistemaDeGestin.getContentPane().add(lblContrasenia);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(43, 107, 62, 14);
		lblEmail.setForeground(new Color(0, 51, 102));
		lblEmail.setFont(new Font("Calibri", Font.PLAIN, 14));
		frmSistemaDeGestin.getContentPane().add(lblEmail);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(138, 135, 215, 20);
		frmSistemaDeGestin.getContentPane().add(textUsuario);
		textUsuario.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(138, 104, 215, 20);
		frmSistemaDeGestin.getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		passwordUsuarioField = new JPasswordField();
		passwordUsuarioField.setBounds(138, 166, 215, 20);
		frmSistemaDeGestin.getContentPane().add(passwordUsuarioField);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(45, 200, 62, 14);
		lblNombre.setForeground(new Color(0, 51, 102));
		lblNombre.setFont(new Font("Calibri", Font.PLAIN, 14));
		frmSistemaDeGestin.getContentPane().add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(138, 197, 215, 20);
		frmSistemaDeGestin.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido.setBounds(45, 231, 62, 14);
		lblApellido.setForeground(new Color(0, 51, 102));
		lblApellido.setFont(new Font("Calibri", Font.PLAIN, 14));
		frmSistemaDeGestin.getContentPane().add(lblApellido);
		
		textApellido = new JTextField();
		textApellido.setBounds(138, 228, 215, 20);
		frmSistemaDeGestin.getContentPane().add(textApellido);
		textApellido.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCategoria.setBounds(45, 262, 62, 14);
		lblCategoria.setForeground(new Color(0, 51, 102));
		lblCategoria.setFont(new Font("Calibri", Font.PLAIN, 14));
		frmSistemaDeGestin.getContentPane().add(lblCategoria);

		
		JLabel lblGestinDeNuevo = new JLabel("Gesti\u00F3n de nuevo usuario");
		lblGestinDeNuevo.setForeground(new Color(0, 51, 102));
		lblGestinDeNuevo.setFont(new Font("Calibri", Font.BOLD, 18));
		lblGestinDeNuevo.setBounds(38, 36, 215, 14);
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
			
		
		btnGuardar.setBounds(379, 354, 89, 23);
		frmSistemaDeGestin.getContentPane().add(btnGuardar);
		
	
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDni.setBounds(43, 76, 62, 14);
		lblDni.setForeground(new Color(0, 51, 102));
		lblDni.setFont(new Font("Calibri", Font.PLAIN, 14));
		frmSistemaDeGestin.getContentPane().add(lblDni);
		
		textDNI = new JTextField();
		textDNI.setBounds(138, 73, 215, 20);
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
		btnBuscar.setBounds(379, 72, 89, 23);
		frmSistemaDeGestin.getContentPane().add(btnBuscar);
		
		 comboBox = new JComboBox();
		 comboBox.setForeground(new Color(0, 51, 102));
		comboBox.setModel(new DefaultComboBoxModel(new Categoria[] {new Categoria(1,"Administrador"), new Categoria(2,"Encargado"), new Categoria(3,"Usuario")}));
		comboBox.setBounds(138, 259, 215, 20);
		frmSistemaDeGestin.getContentPane().add(comboBox);
		
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
		
		btnModificar.setBounds(202, 354, 89, 23);
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
		btnBorrar.setBounds(43, 354, 89, 23);
		frmSistemaDeGestin.getContentPane().add(btnBorrar);
		
		chckbxHabilitado = new JCheckBox("   Habilitado");
		chckbxHabilitado.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxHabilitado.setForeground(new Color(0, 51, 102));
		chckbxHabilitado.setBackground(Color.WHITE);
		chckbxHabilitado.setBounds(138, 295, 97, 23);
		frmSistemaDeGestin.getContentPane().add(chckbxHabilitado);
		
		
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
		p.setCategoria((Categoria) this.comboBox.getSelectedItem());
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
		this.comboBox.setSelectedItem((Categoria) p.getCategoria());
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