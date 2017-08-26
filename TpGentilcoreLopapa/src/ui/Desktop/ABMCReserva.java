package ui.Desktop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

import business.entities.Categoria;
import business.entities.Elemento;
import business.entities.Persona;
import business.entities.Reserva;
import business.entities.TipoDeElemento;
import business.logic.CtrlElementoLogic;
import business.logic.CtrlReservaLogic;
import business.logic.CtrlTipoDeElementoLogic;
import tools.AppDataException;
import tools.ParseoAFecha;


import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class ABMCReserva {
	
	CtrlReservaLogic resLogic = new CtrlReservaLogic();

	
	private JFrame frmSistemaDeGestin;
	private JLabel lblElemento;
	private JTextField textUsuario;
	private JTextField textElemento;
	private JTextField textDesde;
	private JTextField textHasta;
	private CtrlElementoLogic ctrElemLogic;
	private JComboBox comboBoxTiposDeElementos;

	/**
	 * Launch the application.
	 */
	public static void main(Persona per) {								//parametro
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMCReserva window = new ABMCReserva(per);			//parametro
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
	public ABMCReserva(Persona per) {									//parametro
		this.resLogic = new CtrlReservaLogic();
		initialize(per);												//parametro
		//cargarPersona(per);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Persona per) {								//parametro
		frmSistemaDeGestin = new JFrame();
		frmSistemaDeGestin.setIconImage(Toolkit.getDefaultToolkit().getImage(ABMCReserva.class.getResource("/ui/Desktop/cropped-3w2-web-dominios-hosting.png")));
		frmSistemaDeGestin.setTitle("Sistema de gesti\u00F3n de reservas");
		frmSistemaDeGestin.getContentPane().setBackground(Color.WHITE);
		
		JPanel panelVerticalAzul = new JPanel();
		panelVerticalAzul.setBackground(new Color(0, 51, 102));
		
		JLabel lblGestionarReservas = new JLabel("Gestionar Reserva");
		lblGestionarReservas.setFont(new Font("Calibri", Font.BOLD, 20));
		
		lblElemento = new JLabel("Elemento");
		
		JLabel lblDesde = new JLabel("Desde");
		
		JLabel lblHasta = new JLabel("Hasta");
		
		textElemento = new JTextField();
		textElemento.setColumns(10);
		
		textDesde = new JTextField();
		textDesde.setColumns(10);
		
		textHasta = new JTextField();
		textHasta.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					clickAceptar(per);
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (AppDataException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		JLabel lblDosOpcionesBuscar = new JLabel("Dos opciones: buscar en tabla o en lista");
		
		JLabel lblValidarQueSea = new JLabel("Validar que sean fechas, adem\u00E1s de los requerimientos");
		
		JLabel lblFormatoYyyymmdd = new JLabel("formato YYYY-MM-DD    2017-04-26");
		
		comboBoxTiposDeElementos = new JComboBox();
		
		GroupLayout groupLayout = new GroupLayout(frmSistemaDeGestin.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panelVerticalAzul, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblElemento)
								.addComponent(lblDesde)
								.addComponent(lblHasta))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(textElemento)
										.addComponent(textDesde)
										.addComponent(textHasta))
									.addGap(80)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblFormatoYyyymmdd)
										.addComponent(lblValidarQueSea)
										.addComponent(lblDosOpcionesBuscar)))
								.addComponent(comboBoxTiposDeElementos, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(btnAceptar)
							.addComponent(lblGestionarReservas)))
					.addContainerGap(84, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addComponent(lblGestionarReservas)
					.addGap(35)
					.addComponent(comboBoxTiposDeElementos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblElemento)
								.addComponent(textElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDesde)
								.addComponent(textDesde, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblHasta)
								.addComponent(textHasta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(55)
							.addComponent(btnAceptar))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblDosOpcionesBuscar)
							.addGap(18)
							.addComponent(lblValidarQueSea)
							.addGap(18)
							.addComponent(lblFormatoYyyymmdd)))
					.addContainerGap(127, Short.MAX_VALUE))
				.addComponent(panelVerticalAzul, GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
		);
		
		JLabel lbliconoReservas = new JLabel("");
		lbliconoReservas.setIcon(new ImageIcon(ABMCReserva.class.getResource("/ui/Desktop/ic_add_shopping_cart_white_24dp_2x.png")));
		lbliconoReservas.setFont(new Font("Calibri", Font.PLAIN, 11));
		lbliconoReservas.setForeground(Color.WHITE);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsuario.setIcon(new ImageIcon(ABMCReserva.class.getResource("/ui/Desktop/ic_person_pin_white_24dp_1x.png")));
		lblUsuario.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblUsuario.setForeground(Color.WHITE);
		
		textUsuario = new JTextField();
		textUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		textUsuario.setBorder(null);
		textUsuario.setEditable(false);
		textUsuario.setFont(new Font("Calibri", Font.PLAIN, 12));
		textUsuario.setForeground(Color.WHITE);
		textUsuario.setBackground(new Color(0, 51, 102));
		textUsuario.setColumns(10);
		GroupLayout gl_panelVerticalAzul = new GroupLayout(panelVerticalAzul);
		gl_panelVerticalAzul.setHorizontalGroup(
			gl_panelVerticalAzul.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelVerticalAzul.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelVerticalAzul.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panelVerticalAzul.createSequentialGroup()
							.addComponent(lbliconoReservas)
							.addGap(28))
						.addGroup(gl_panelVerticalAzul.createSequentialGroup()
							.addComponent(lblUsuario, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panelVerticalAzul.createSequentialGroup()
							.addComponent(textUsuario, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_panelVerticalAzul.setVerticalGroup(
			gl_panelVerticalAzul.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelVerticalAzul.createSequentialGroup()
					.addGap(21)
					.addComponent(lbliconoReservas)
					.addGap(38)
					.addComponent(lblUsuario)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(239, Short.MAX_VALUE))
		);
		panelVerticalAzul.setLayout(gl_panelVerticalAzul);
		frmSistemaDeGestin.getContentPane().setLayout(groupLayout);
		frmSistemaDeGestin.setBounds(100, 100, 701, 442);
		frmSistemaDeGestin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mapearAForm(per);				//El parametro per es la persona logueada que se envia como parametro desde el login
	//	cargarListaTdE();
	}
	/*
	private void cargarListaTdE(){
			try {
				this.comboBoxTiposDeElementos.setModel(new DefaultComboBoxModel(ctrElemLogic.getTipoDeElemento().toArray()));		//en el controlorador de reservas o de elemento??
				this.comboBoxTiposDeElementos.setSelectedIndex(-1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}*/
	
	
	private void clickAceptar(Persona pers) throws Exception, SQLException, AppDataException{
		resLogic.add(this.mapearDeForm(pers));		
	}
	
	
	private Reserva mapearDeForm(Persona pers) throws ParseException{
		Reserva r = new Reserva();
		//Persona p = new Persona();
		Elemento e = new Elemento();

		//p.setId(Integer.parseInt(this.textUsuario.getText()) );
		r.setPersona(pers);	
		e.setId_elemento(Integer.parseInt(this.textElemento.getText()));
		r.setElemento(e);
		r.setFecha_hora_desde_solicitada(Date.valueOf(textDesde.getText()));
		r.setFecha_hora_desde_solicitada(Date.valueOf((textDesde.getText())));
		r.setFecha_hora_hasta_solicitada(Date.valueOf(textHasta.getText()));

		return r;
	}
	
	
	private void mapearAForm(Persona per){
		this.textUsuario.setText(String.valueOf(per.getUsuario()));
		//this.textUsuario.setText(p.getUsuario());
		//this.comboCategoria.setSelectedItem((Categoria) p.getCategoria());
		//this.chckbxHabilitado.setSelected(p.isHabilitado());
	}
}