package ui.Desktop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;

import business.entities.Persona;
import business.logic.CtrlPersonaLogic;
import tools.Campo;
import tools.MessageError;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Toolkit;

public class VentanaLogueo {

	private JFrame frmLogin;
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
					VentanaLogueo window = new VentanaLogueo();
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
	public VentanaLogueo() {
		this.UsuLogic=new CtrlPersonaLogic();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaLogueo.class.getResource("/ui/Desktop/cropped-3w2-web-dominios-hosting.png")));
		frmLogin.setTitle("Bienvenidos al Sistema de Gesti\u00F3n de Reservas");
		frmLogin.getContentPane().setBackground(new Color(0, 51, 102));
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		textUsuario = new JTextField();
		textUsuario.setColumns(10);
		
		JLabel lblContrasenia = new JLabel("Contrase\u00F1a");
		lblContrasenia.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasenia.setForeground(Color.WHITE);
		lblContrasenia.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		pwfContrasenia = new JPasswordField();
		pwfContrasenia.setColumns(10);
		
		JButton lblIngresar = new JButton("Ingresar");
		lblIngresar.setContentAreaFilled(false);
		lblIngresar.setBorderPainted(false);
		lblIngresar.setBackground(new Color(0, 51, 102));
		lblIngresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				loguearse();
			}
		});
		lblIngresar.setFont(new Font("Calibri", Font.BOLD, 14));
		lblIngresar.setForeground(Color.WHITE);
		
		
		JLabel lblIniciarSesin = new JLabel("Iniciar Sesi\u00F3n");
		lblIniciarSesin.setHorizontalAlignment(SwingConstants.CENTER);
		lblIniciarSesin.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblIniciarSesin.setForeground(Color.WHITE);
		
		JLabel iconoUsuario = new JLabel("");
		iconoUsuario.setIcon(new ImageIcon(VentanaLogueo.class.getResource("/ui/Desktop/ic_person_white_24dp_2x.png")));
		
		
		GroupLayout groupLayout = new GroupLayout(frmLogin.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(239, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(pwfContrasenia)
										.addComponent(textUsuario, GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
										.addComponent(lblIngresar, Alignment.TRAILING))
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(129)
										.addComponent(lblUsuario)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(130)
									.addComponent(iconoUsuario)
									.addPreferredGap(ComponentPlacement.RELATED, 156, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(99)
									.addComponent(lblIniciarSesin)
									.addPreferredGap(ComponentPlacement.RELATED, 125, GroupLayout.PREFERRED_SIZE)))
							.addGap(217))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblContrasenia)
							.addGap(361))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addComponent(iconoUsuario)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblIniciarSesin)
					.addGap(53)
					.addComponent(lblUsuario)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addComponent(lblContrasenia)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(pwfContrasenia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(52)
					.addComponent(lblIngresar)
					.addContainerGap(64, Short.MAX_VALUE))
		);
		frmLogin.getContentPane().setLayout(groupLayout);
		frmLogin.setBounds(100, 100, 800, 460);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	
	
private void loguearse(){
		if(validaCampos()){
			loguearse(textUsuario.getText(), String.valueOf(pwfContrasenia.getPassword()));}
	}

private void loguearse(String usuario, String pass){
	try {
		
		Persona user = UsuLogic.getLoggedUser(usuario, pass);
		if(user!=null){
			if(user.isHabilitado()==true){		
			ABMCReserva.main(user);			//le paso el usuario que se acaba de loguear para que  lo pueda utilizar ABMCReservaRicar
			frmLogin.dispose();
				
			//	MainWindow.main(user);
			//	frmLogin.dispose();
		}else{
			JOptionPane.showMessageDialog(frmLogin, "Usuario no Habilitado", "", JOptionPane.WARNING_MESSAGE);
			}
		}else{
			JOptionPane.showMessageDialog(frmLogin, "Usuario no encontrado", "", JOptionPane.INFORMATION_MESSAGE);
		}
	} catch (HeadlessException e) {
		e.printStackTrace();
	} catch (Exception e) {
		MessageError.showMessageDialog(frmLogin,e.getMessage());
	}
	}

	
private Boolean validaCampos(){
	return	(Campo.Valida(String.valueOf(pwfContrasenia.getPassword()),Campo.tipo.OTRO)
			&& Campo.Valida(textUsuario.getText(),Campo.tipo.OTRO));
	}

}
