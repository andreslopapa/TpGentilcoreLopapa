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

public class ABMCPersona extends JInternalFrame{

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
		/*frmSistemaDeGestin = new JFrame();
		frmSistemaDeGestin.setIconImage(Toolkit.getDefaultToolkit().getImage(ABMCPersona.class.getResource("/ui/Desktop/cropped-3w2-web-dominios-hosting.png")));
		frmSistemaDeGestin.getContentPane().setBackground(Color.WHITE);
		frmSistemaDeGestin.setFont(new Font("Calibri", Font.PLAIN, 12));
		frmSistemaDeGestin.setTitle("SISTEMA DE GESTI\u00D3N DE RESERVAS");
		frmSistemaDeGestin.setBounds(100, 100, 770, 451);
		frmSistemaDeGestin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
		
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

		
		JLabel lblGestinDeNuevo = new JLabel("Nuevo usuario");
		lblGestinDeNuevo.setForeground(new Color(0, 51, 102));
		lblGestinDeNuevo.setFont(new Font("Calibri", Font.BOLD, 18));
		
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
		
	
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDni.setForeground(new Color(0, 51, 102));
		lblDni.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		textDNI = new JTextField();
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
		
		 comboCategoria = new JComboBox();
		 comboCategoria.setForeground(new Color(0, 51, 102));
		
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
		
		chckbxHabilitado = new JCheckBox("   Habilitado");
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
					.addGap(39)
					.addComponent(lblIconousuario)
					.addContainerGap(43, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(23)
					.addComponent(lblIconousuario)
					.addContainerGap(344, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		GroupLayout groupLayout = new GroupLayout(frmSistemaDeGestin.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(55)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDni, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsuario, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(25)
							.addComponent(lblContrasenia))
						.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblApellido, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCategoria, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(25)
							.addComponent(btnBorrar, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(2)
									.addComponent(lblGestinDeNuevo, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE))
								.addComponent(textDNI, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
								.addComponent(textEmail, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
								.addComponent(textUsuario, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
								.addComponent(passwordUsuarioField, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
								.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
								.addComponent(textApellido, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboCategoria, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
								.addComponent(chckbxHabilitado, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnModificar, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)))
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(75)
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
					.addComponent(lblCategoria, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(78)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBorrar)
						.addComponent(btnModificar)))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addComponent(lblGestinDeNuevo, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
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
					.addComponent(comboCategoria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(19)
					.addComponent(chckbxHabilitado)
					.addGap(56))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(72)
					.addComponent(btnBuscar)
					.addGap(258)
					.addComponent(btnGuardar))
		);
	//	frmSistemaDeGestin.getContentPane().setLayout(groupLayout);
		
		cargarListas();		
	}

	private void cargarListas() {
		try {//setModel:  es una representacion de los datos que tiene adentro. Como se ordeanan
			//DefaultComboBoxModel:   recibe como parametro un array con los elementos a mostrar
			this.comboCategoria.setModel(new DefaultComboBoxModel(perLogic.getCategorias().toArray()));
			this.comboCategoria.setSelectedIndex(-1);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frmSistemaDeGestin, e.getMessage());
		}
	}
	
	protected void guardarClick(){
		try {		
			if(textDNI.getText().length() >0 && textUsuario.getText().length() >0 && passwordUsuarioField.getText().length() >0 
					&& textNombre.getText().length() >0 && textApellido.getText().length() >0 &&  textEmail.getText().length()>0 ){				
			if(!FormatoEmail.esEmailCorrecto(textEmail.getText())){JOptionPane.showMessageDialog(frmSistemaDeGestin, "Email incorrecto", "", JOptionPane.WARNING_MESSAGE); 
			}else{
			perLogic.add(this.mapearDeForm());
			JOptionPane.showMessageDialog(frmSistemaDeGestin, "Usuario guardado correctamente", "", JOptionPane.OK_OPTION);}
			}else{
				JOptionPane.showMessageDialog(frmSistemaDeGestin, "Debe completar todos los campos", "", JOptionPane.WARNING_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frmSistemaDeGestin, e.getMessage());
		}
	}
	
	
	protected void buscarClick(){
		try {if(textDNI.getText().length() >0){
			this.mapearAForm(perLogic.getByDni(this.mapearDeForm()));
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
			perLogic.update(mapearDeForm());
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
			perLogic.delete(mapearDeForm());
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

	}

}