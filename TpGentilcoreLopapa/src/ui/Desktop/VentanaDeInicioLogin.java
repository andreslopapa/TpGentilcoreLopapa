package ui.Desktop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Panel;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Button;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import business.entities.Persona;
import business.logic.CtrlPersonaLogic;
import tools.MessageError;

import java.awt.GridBagLayout;
import java.awt.MouseInfo;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class VentanaDeInicioLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textUsuario;
	private JPasswordField pwfContrasenia;
	private CtrlPersonaLogic UsuLogic;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaDeInicioLogin frame = new VentanaDeInicioLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaDeInicioLogin() {
		setTitle("Sistema de gesti\u00F3n de reservas");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaDeInicioLogin.class.getResource("/ui/Desktop/cropped-3w2-web-dominios-hosting.png")));
	//	setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 450);
		


		
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);

		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		setContentPane(contentPane);

		
		JLabel lblContrasenia = new JLabel("Contrase\u00F1a");
		lblContrasenia.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasenia.setForeground(Color.WHITE);
		lblContrasenia.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		textUsuario = new JTextField();
		textUsuario.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblInicioSesion = new JLabel("Iniciar sesi\u00F3n");
		lblInicioSesion.setHorizontalAlignment(SwingConstants.CENTER);
		lblInicioSesion.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblInicioSesion.setForeground(Color.WHITE);
		

		pwfContrasenia = new JPasswordField();
		//pwfContrasenia.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
	//			loguea();
		//	}
//		});
		pwfContrasenia.setColumns(10);
		
		JLabel lblIngresar = new JLabel("Ingresar");
		lblIngresar.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresar.setFont(new Font("Calibri", Font.BOLD, 14));
		lblIngresar.setForeground(Color.WHITE);
		
		JLabel lblIcono = new JLabel("");
		lblIcono.setIcon(new ImageIcon(VentanaDeInicioLogin.class.getResource("/ui/Desktop/ic_person_white_24dp_2x.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(349)
							.addComponent(lblUsuario, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(214)
							.addComponent(textUsuario, GroupLayout.PREFERRED_SIZE, 348, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(349)
							.addComponent(lblContrasenia, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(215)
							.addComponent(pwfContrasenia, GroupLayout.PREFERRED_SIZE, 347, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(490)
							.addComponent(lblIngresar, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(362)
							.addComponent(lblIcono))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(296)
							.addComponent(lblInicioSesion, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(220, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addComponent(lblIcono)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblInicioSesion, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(42)
					.addComponent(lblUsuario, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(16)
					.addComponent(textUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addComponent(lblContrasenia, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(pwfContrasenia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(51)
					.addComponent(lblIngresar, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);	
		
	}
	

}
