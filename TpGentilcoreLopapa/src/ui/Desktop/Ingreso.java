package ui.Desktop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Ingreso {

	private JFrame frame;
	private JTextField textUsuario;
	private JPasswordField passwordUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ingreso window = new Ingreso();
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
	public Ingreso() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(188, 180, 89, 23);
		frame.getContentPane().add(btnIngresar);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(100, 71, 36, 14);
		frame.getContentPane().add(lblUsuario);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(156, 68, 170, 20);
		frame.getContentPane().add(textUsuario);
		textUsuario.setColumns(10);
		
		passwordUsuario = new JPasswordField();
		passwordUsuario.setBounds(156, 113, 170, 20);
		frame.getContentPane().add(passwordUsuario);
		
		JLabel lblNewLabel = new JLabel("Contrase\u00F1a");
		lblNewLabel.setBounds(80, 116, 56, 14);
		frame.getContentPane().add(lblNewLabel);
	}
}
