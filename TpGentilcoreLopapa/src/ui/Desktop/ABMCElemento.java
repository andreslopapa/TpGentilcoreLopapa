package ui.Desktop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import business.entities.Elemento;
import business.entities.TipoDeElemento;
import business.logic.CtrlElementoLogic;
import tools.AppDataException;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class ABMCElemento extends JFrame {
	
	CtrlElementoLogic ctrElemLogic = new CtrlElementoLogic();

	private JPanel contentPane;
	private JTextField textIdElemento;
	private JTextField textNombreElemento;
	private JLabel lblGestinDeElementos;
	private JLabel lblId;
	private JLabel lblNombre;
	private JLabel lblIconoElemento;
	private JLabel lblTipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMCElemento frame = new ABMCElemento();
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
	public ABMCElemento() {
		setTitle("Sistema de gesti\u00F3n de reservas");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ABMCElemento.class.getResource("/ui/Desktop/cropped-3w2-web-dominios-hosting.png")));
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 452);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(2, 2, 2, 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelBarraAzulLateral = new JPanel();
		panelBarraAzulLateral.setBackground(new Color(0, 51, 102));
		panelBarraAzulLateral.setBounds(0, 0, 130, 415);
		contentPane.add(panelBarraAzulLateral);
		
		lblIconoElemento = new JLabel("");
		lblIconoElemento.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoElemento.setIcon(new ImageIcon(ABMCElemento.class.getResource("/ui/Desktop/ic_devices_white_24dp_2x.png")));
		GroupLayout gl_panelBarraAzulLateral = new GroupLayout(panelBarraAzulLateral);
		gl_panelBarraAzulLateral.setHorizontalGroup(
			gl_panelBarraAzulLateral.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelBarraAzulLateral.createSequentialGroup()
					.addContainerGap(31, Short.MAX_VALUE)
					.addComponent(lblIconoElemento, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addGap(28))
		);
		gl_panelBarraAzulLateral.setVerticalGroup(
			gl_panelBarraAzulLateral.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBarraAzulLateral.createSequentialGroup()
					.addComponent(lblIconoElemento, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(317, Short.MAX_VALUE))
		);
		panelBarraAzulLateral.setLayout(gl_panelBarraAzulLateral);
		
		textIdElemento = new JTextField();
		textIdElemento.setBounds(302, 85, 193, 20);
		contentPane.add(textIdElemento);
		textIdElemento.setColumns(10);
		
		textNombreElemento = new JTextField();
		textNombreElemento.setBounds(302, 117, 193, 20);
		contentPane.add(textNombreElemento);
		textNombreElemento.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					clickBuscarElemento();
				} catch (Exception e) {
					e.printStackTrace();
				}				
			}
		});
		btnBuscar.setBounds(563, 85, 89, 23);
		contentPane.add(btnBuscar);
		
		lblGestinDeElementos = new JLabel("Gesti\u00F3n de elementos");
		lblGestinDeElementos.setHorizontalAlignment(SwingConstants.LEFT);
		lblGestinDeElementos.setFont(new Font("Calibri", Font.BOLD, 18));
		lblGestinDeElementos.setBounds(307, 35, 213, 14);
		contentPane.add(lblGestinDeElementos);
		
		lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(184, 88, 89, 14);
		contentPane.add(lblId);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(184, 120, 89, 14);
		contentPane.add(lblNombre);
		
		lblTipo = new JLabel("Tipo");
		lblTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipo.setBounds(184, 151, 89, 14);
		contentPane.add(lblTipo);
		
		JComboBox comboBoxTipoElemento = new JComboBox();
		comboBoxTipoElemento.setBounds(302, 148, 193, 20);
		contentPane.add(comboBoxTipoElemento);
		
		JLabel lblAcaPodriaSer = new JLabel("Aca podria ser mejor buscar directamente en una tabla");
		lblAcaPodriaSer.setBounds(184, 194, 541, 47);
		contentPane.add(lblAcaPodriaSer);
	}
	
	protected void clickBuscarElemento() throws Exception{
		try {
			this.mapearAForm(ctrElemLogic.getOne(this.mapearDeForm()));
		} catch (Exception sqlex) {
			throw new AppDataException(sqlex, "Error al buscar elemento");			//MECA: 			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	
	private Elemento mapearDeForm(){
		Elemento e = new Elemento();
		TipoDeElemento tde = new TipoDeElemento();
		
		e.setId_elemento(Integer.parseInt(this.textIdElemento.getText()));
		e.setNombre(this.textNombreElemento.getText());
		//FALTA EL TIPO DE ELEMENTO /////////////////////OJOTA/////////////////////////////
		return e;
	}
	
	private void mapearAForm(Elemento e){
	//	this.textIdElemento.setText(e.getId_elemento());
		this.textNombreElemento.setText(e.getNombre());
	}
}
