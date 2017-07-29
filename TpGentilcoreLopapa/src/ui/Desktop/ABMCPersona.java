package ui.Desktop;

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

public class ABMCPersona {

	PersonaLogic perLogic = new PersonaLogic();
	
	private JFrame frame;
	private JTextField textUsuario;
	private JTextField textEmail;
	private JPasswordField passwordUsuarioField;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textDNI;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMCPersona window = new ABMCPersona();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 415, 361);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(37, 61, 46, 14);
		frame.getContentPane().add(lblUsuario);
		
		JLabel lblContraseņa = new JLabel("Contrase\u00F1a");
		lblContraseņa.setBounds(37, 86, 56, 14);
		frame.getContentPane().add(lblContraseņa);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(37, 111, 46, 14);
		frame.getContentPane().add(lblEmail);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(130, 58, 150, 20);
		frame.getContentPane().add(textUsuario);
		textUsuario.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(130, 108, 150, 20);
		frame.getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		passwordUsuarioField = new JPasswordField();
		passwordUsuarioField.setBounds(130, 83, 150, 20);
		frame.getContentPane().add(passwordUsuarioField);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(37, 161, 46, 14);
		frame.getContentPane().add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(130, 158, 150, 20);
		frame.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(37, 186, 46, 14);
		frame.getContentPane().add(lblApellido);
		
		textApellido = new JTextField();
		textApellido.setBounds(130, 183, 150, 20);
		frame.getContentPane().add(textApellido);
		textApellido.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(37, 211, 56, 14);
		frame.getContentPane().add(lblCategoria);
		
		JRadioButton rdbtnHabilitado = new JRadioButton("Habilitado");
		rdbtnHabilitado.setBounds(130, 228, 109, 23);
		frame.getContentPane().add(rdbtnHabilitado);
		
		JComboBox comboBoxCategoria = new JComboBox();
		comboBoxCategoria.setBounds(130, 208, 150, 20);
		frame.getContentPane().add(comboBoxCategoria);
		
		JLabel lblGestinDeNuevo = new JLabel("Gesti\u00F3n de nuevo usuario");
		lblGestinDeNuevo.setFont(new Font("Calibri", Font.BOLD, 15));
		lblGestinDeNuevo.setBounds(37, 23, 175, 14);
		frame.getContentPane().add(lblGestinDeNuevo);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				guardarClick();
			}
		});
		
		btnGuardar.setBounds(191, 270, 89, 23);
		frame.getContentPane().add(btnGuardar);
		
	
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(37, 136, 46, 14);
		frame.getContentPane().add(lblDni);
		
		textDNI = new JTextField();
		textDNI.setBounds(130, 133, 150, 20);
		frame.getContentPane().add(textDNI);
		textDNI.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(300, 132, 89, 23);
		frame.getContentPane().add(btnBuscar);
	}
	
	protected void guardarClick(){
		perLogic.add(this.mapearDeForm());
		this.limpiarTexto();
	}
	
	private void mapearDeForm(){
		Persona p= new Persona();
		p.setDni(this.textDNI.getText());
		p.setNombre(this.textNombre.getText());
		p.setApellido(this.textApellido.getText());
		p.setUsuario(this.textUsuario.getText());
		p.setNombre(this.passwordUsuarioField.getText());
		p.setNombre(this.textNombre.getText());
		p.setNombre(this.textNombre.getText());
		
	}
	
	private void limpiarTexto(){
		this.textDNI.setText("");
		this.textNombre.setText("");
		this.textApellido.setText("");
		this.textUsuario.setText("");
		this.passwordUsuarioField.setText("");
		this.textEmail.setText("");
	}
}
