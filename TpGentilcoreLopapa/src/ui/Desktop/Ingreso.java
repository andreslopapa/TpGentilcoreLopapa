package ui.Desktop;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.image.ImagingOpException;
import java.io.File;

import javax.swing.UIManager;
import javax.swing.JSeparator;
import java.awt.Panel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import tools.MessageError;

import javax.swing.border.CompoundBorder;

public class Ingreso {

	private JFrame frmLogin;
	private JTextField txtUsuario;
	private JTextField txtPassword;
	
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

		frmLogin.setBounds(100, 100, 400, 247);
		frmLogin.setLocationRelativeTo(null);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		Fondo fondo = new Fondo("loginimg.jpg");
		fondo.setBounds(0, 0, 400, 247);
		//frmLogin.setContentPane(fondo);
		frmLogin.getContentPane().add(fondo);
		
		txtUsuario=new JTextField();
		txtUsuario.setBounds(161, 86, 168, 19);
		fondo.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(161, 72, 70, 15);
		fondo.add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Contraseña");
		lblPassword.setBounds(164, 117, 85, 15);
		fondo.add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(161, 131, 168, 19);
		fondo.add(txtPassword);
		txtPassword.setColumns(10);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.setBounds(212, 175, 117, 25);
		fondo.add(btnSignIn);
		
		//fondo.repaint(); 
		
//		JLabel lblParaelFondo = new JLabel("New label");
//		
//		lblParaelFondo.setBounds(0, 0, frmLogin.getWidth(), frmLogin.getHeight());
//		
//		Icon imgFondo=new ImageIcon(this.getClass().getResource("loginimg.jpg"));
//		lblParaelFondo.setIcon(imgFondo);
//		frmLogin.getContentPane().add(lblParaelFondo);
	}
}
