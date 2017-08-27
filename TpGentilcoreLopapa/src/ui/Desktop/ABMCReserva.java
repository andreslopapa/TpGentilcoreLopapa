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
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import com.toedter.calendar.JDateChooser;

public class ABMCReserva {
	
	CtrlReservaLogic resLogic = new CtrlReservaLogic();

	
	private JFrame frmSistemaDeGestin;
	private JLabel lblElemento;
	private JTextField textUsuario;
	private JTextField textElemento;
	private JTextArea textAreaDetalle;
	private CtrlElementoLogic ctrElemLogic;
	private JDateChooser dateChooserDesde;
	private JDateChooser dateChooserHasta;
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
		
		JLabel lblValidarQueSea = new JLabel("Faltaria validar los requerimientos");
		
		textAreaDetalle = new JTextArea();
		textAreaDetalle.setLineWrap(true);
		textAreaDetalle.setFont(new Font("Calibri", Font.PLAIN, 12));
		textAreaDetalle.setBorder(new LineBorder(Color.LIGHT_GRAY));
		
		JLabel lblDetalle = new JLabel("Detalle");
		
		dateChooserDesde = new JDateChooser();
		dateChooserDesde.setDateFormatString("yyyy/MM/dd");
		
		dateChooserHasta = new JDateChooser();
		dateChooserHasta.setDateFormatString("yyyy/MM/dd");
		
		GroupLayout groupLayout = new GroupLayout(frmSistemaDeGestin.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panelVerticalAzul, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(lblDetalle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblElemento, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblHasta))
								.addComponent(lblDesde, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textAreaDetalle, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAceptar)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(textElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(dateChooserHasta, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(dateChooserDesde, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(62)))
							.addGap(201)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblDosOpcionesBuscar)
								.addComponent(lblValidarQueSea))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addComponent(lblGestionarReservas))
					.addContainerGap(57, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addComponent(lblGestionarReservas)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(66)
							.addComponent(lblDosOpcionesBuscar)
							.addGap(18)
							.addComponent(lblValidarQueSea))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblElemento)
									.addComponent(textElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(dateChooserDesde, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblDesde))
								.addGap(11)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(dateChooserHasta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblHasta)))
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textAreaDetalle, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDetalle))
							.addGap(18)
							.addComponent(btnAceptar)))
					.addContainerGap(131, Short.MAX_VALUE))
				.addComponent(panelVerticalAzul, GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
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
		frmSistemaDeGestin.setBounds(100, 100, 785, 477);
		frmSistemaDeGestin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mapearAForm(per);				//per es la persona logueada que se envia como parametro desde el login
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

		r.setPersona(pers);	
		e.setId_elemento(Integer.parseInt(this.textElemento.getText()));
		r.setElemento(e);
		
				int vyearD = dateChooserDesde.getCalendar().get(Calendar.YEAR);
				int vmonthD = 1+dateChooserDesde.getCalendar().get(Calendar.MONTH);				//le sumo 1 porque january lo toma como 0 y explota tambien
				int vdayD = dateChooserDesde.getCalendar().get(Calendar.DAY_OF_MONTH);
				String vfechaD = vyearD + "-" + vmonthD + "-" + vdayD;
		r.setFecha_hora_desde_solicitada(Date.valueOf(vfechaD));	//el famoso provisorio. --> En vez de estas 5 lineas de codigo, Intenté una mas linda con dateChooserHasta.getDate() como en la linea de abajo pero no me dejaba convertir de java.util.Date a java.sql.date.... Busqe y no encontre ayuda , Luego vere otra forma "mejor"
		//r.setFecha_hora_desde_solicitada(Date.valueOf(textHasta.getText()));

				int vyearH = dateChooserHasta.getCalendar().get(Calendar.YEAR);
				int vmonthH = 1+dateChooserHasta.getCalendar().get(Calendar.MONTH);
				int vdayH = dateChooserHasta.getCalendar().get(Calendar.DAY_OF_MONTH);
				String vfechaH = vyearH + "-" + vmonthH + "-" + vdayH;
		r.setFecha_hora_hasta_solicitada(Date.valueOf(vfechaH));	//el famoso provisorio
		
		r.setDetalle(this.textAreaDetalle.getText());
		return r;
	}
	
	
	private void mapearAForm(Persona per){
		this.textUsuario.setText(String.valueOf(per.getUsuario()));
		//this.textUsuario.setText(p.getUsuario());
		//this.comboCategoria.setSelectedItem((Categoria) p.getCategoria());
		//this.chckbxHabilitado.setSelected(p.isHabilitado());
	}
}