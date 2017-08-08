package ui.Desktop;

import java.awt.*;
import javax.swing.*;

import business.entities.Persona;
import business.logic.PersonaLogic;
import tools.LimitadorTxt;
import tools.MessageError;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Ingreso {

	private JFrame frmLogin;
	private JTextField txtUsuario;
	private PersonaLogic UsuLogic;
	private JPasswordField pwfContrasenia;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ingreso window = new Ingreso();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ingreso() {
		this.UsuLogic=new PersonaLogic();
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
	
		frmLogin = new JFrame();
		frmLogin.setResizable(false);
		frmLogin.getContentPane().setBackground(new Color(255, 255, 255));
		frmLogin.setTitle("Login");

		frmLogin.setBounds(100, 100, 400, 279);
		frmLogin.setLocationRelativeTo(null);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		Fondo fondo = new Fondo("loginimg.jpg");
		fondo.setBounds(0, 0, 400, 279);
		//frmLogin.setContentPane(fondo);
		frmLogin.getContentPane().add(fondo);
		
		txtUsuario=new JTextField();
		txtUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loguea();
			}
		});
		LimitadorTxt.MaxCaracteres(20, txtUsuario);
		txtUsuario.setBounds(161, 86, 168, 19);
		
		fondo.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(161, 72, 70, 15);
		fondo.add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Contraseña");
		lblPassword.setBounds(161, 117, 85, 15);
		fondo.add(lblPassword);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				//UsuLogic.getLoggedUser(txtUsuario.getText(), txtPassword.getText());
				loguea();
			}
		});
		btnSignIn.setBounds(212, 175, 117, 25);
		fondo.add(btnSignIn);
		
		pwfContrasenia = new JPasswordField();
		pwfContrasenia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loguea();
			}
		});
		LimitadorTxt.MaxCaracteres(20, pwfContrasenia);
		pwfContrasenia.setBounds(162, 132, 167, 19);
		fondo.add(pwfContrasenia);
		
		

	}
	
	private void loguea(){
		if(validaCampos()){
			loguea(txtUsuario.getText(), String.valueOf(pwfContrasenia.getPassword()));}
	}
	private void loguea(String usuario,String pass){
		try{
			Persona usu=UsuLogic.getLoggedUser(usuario, pass);
			if(usu!=null){
				if(usu.isHabilitado()==true){
					JOptionPane.showMessageDialog(frmLogin, "Usuario encontrado", "", JOptionPane.INFORMATION_MESSAGE);
//aca despues abro otro frame
				}else{
					JOptionPane.showMessageDialog(frmLogin, "Usuario no Habilitado", "", JOptionPane.WARNING_MESSAGE);

				}
			}
			else{
				JOptionPane.showMessageDialog(frmLogin, "Usuario no encontrado", "", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		catch(Exception ex){
			MessageError.showMessageDialog(frmLogin,ex.getMessage());
		}
	}
	
	private Boolean validaCampos(){
		if(String.valueOf(pwfContrasenia.getPassword()).isEmpty()||txtUsuario.getText().isEmpty()){
			JOptionPane.showMessageDialog(frmLogin, "Complete todos los campos por favor", "", JOptionPane.INFORMATION_MESSAGE);
		    return false;
		}
		return true;
	}
}
