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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private JDateChooser dateChooserFechaFinRes;
	private JTextField textIdReserva;
	private JPanel panel_EditarReserva;
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
		
		JPanel panelCrearReserva = new JPanel();
		panelCrearReserva.setBackground(Color.WHITE);
		
		JButton btnCrearReserva = new JButton("");
		btnCrearReserva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panelCrearReserva.setVisible(true);
			}
		});
		
		btnCrearReserva.setIcon(new ImageIcon(ABMCReserva.class.getResource("/ui/Desktop/Agregar.png")));
		
		JButton btnCerrarReserva = new JButton("");
		btnCerrarReserva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel_EditarReserva.setVisible(true);
			}
		});
		btnCerrarReserva.setIcon(new ImageIcon(ABMCReserva.class.getResource("/ui/Desktop/Editar.png")));
		
		JButton btnCancelarSolicitud = new JButton("Cancelar Solicitud ");
		btnCancelarSolicitud.setIcon(new ImageIcon(ABMCReserva.class.getResource("/ui/Desktop/Borrar.png")));
		
		panel_EditarReserva = new JPanel();
		panel_EditarReserva.setBackground(Color.WHITE);
		
		GroupLayout groupLayout = new GroupLayout(frmSistemaDeGestin.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panelVerticalAzul, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(28)
							.addComponent(lblGestionarReservas)
							.addGap(27)
							.addComponent(btnCrearReserva)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnCerrarReserva))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(panelCrearReserva, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCancelarSolicitud)
						.addComponent(panel_EditarReserva, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCancelarSolicitud)
						.addComponent(lblGestionarReservas)
						.addComponent(btnCerrarReserva)
						.addComponent(btnCrearReserva))
					.addGap(54)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_EditarReserva, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelCrearReserva, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(79, Short.MAX_VALUE))
				.addComponent(panelVerticalAzul, GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
		);
		
		textIdReserva = new JTextField();
		textIdReserva.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		
		dateChooserFechaFinRes = new JDateChooser();
		
		JLabel lblFinReserva = new JLabel("Fin reserva ");
		lblFinReserva.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					clickModificarReserva(per);
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (AppDataException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		GroupLayout gl_panel_EditarReserva = new GroupLayout(panel_EditarReserva);
		panel_EditarReserva.setVisible(false);

		gl_panel_EditarReserva.setHorizontalGroup(
			gl_panel_EditarReserva.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_EditarReserva.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_EditarReserva.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_EditarReserva.createSequentialGroup()
							.addComponent(lblFinReserva, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(dateChooserFechaFinRes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_panel_EditarReserva.createSequentialGroup()
							.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textIdReserva, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(18)
					.addComponent(btnActualizar)
					.addGap(37))
		);
		gl_panel_EditarReserva.setVerticalGroup(
			gl_panel_EditarReserva.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_EditarReserva.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_EditarReserva.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(textIdReserva, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_EditarReserva.createParallelGroup(Alignment.LEADING)
						.addComponent(btnActualizar)
						.addComponent(lblFinReserva)
						.addComponent(dateChooserFechaFinRes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(132, Short.MAX_VALUE))
		);
		panel_EditarReserva.setLayout(gl_panel_EditarReserva);
		
		textAreaDetalle = new JTextArea();
		textAreaDetalle.setLineWrap(true);
		textAreaDetalle.setFont(new Font("Calibri", Font.PLAIN, 12));
		textAreaDetalle.setBorder(new LineBorder(Color.LIGHT_GRAY));
		
		JLabel lblDetalle = new JLabel("Detalle");
		lblDetalle.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblHasta = new JLabel("Hasta");
		lblHasta.setHorizontalAlignment(SwingConstants.RIGHT);
		
		dateChooserHasta = new JDateChooser();
		dateChooserHasta.setDateFormatString("yyyy/MM/dd");
		
		dateChooserDesde = new JDateChooser();
		dateChooserDesde.setDateFormatString("yyyy/MM/dd");
		
		JLabel lblDesde = new JLabel("Desde");
		lblDesde.setHorizontalAlignment(SwingConstants.RIGHT);
		
		lblElemento = new JLabel("Elemento");
		lblElemento.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textElemento = new JTextField();
		textElemento.setColumns(10);
		
		JButton btnSolicitarReserva = new JButton("Solicitar Reserva");
		btnSolicitarReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSolicitarReserva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					clickCrearReserva(per);
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (AppDataException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		GroupLayout gl_panelCrearReserva = new GroupLayout(panelCrearReserva);
		gl_panelCrearReserva.setHorizontalGroup(
			gl_panelCrearReserva.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCrearReserva.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_panelCrearReserva.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panelCrearReserva.createSequentialGroup()
							.addComponent(lblDetalle, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textAreaDetalle, 0, 0, Short.MAX_VALUE))
						.addGroup(gl_panelCrearReserva.createSequentialGroup()
							.addComponent(lblElemento)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textElemento))
						.addGroup(gl_panelCrearReserva.createSequentialGroup()
							.addGroup(gl_panelCrearReserva.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblHasta)
								.addComponent(lblDesde, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelCrearReserva.createParallelGroup(Alignment.LEADING)
								.addComponent(dateChooserDesde, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
								.addComponent(dateChooserHasta, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSolicitarReserva)
					.addContainerGap(27, Short.MAX_VALUE))
		);
		gl_panelCrearReserva.setVerticalGroup(
			gl_panelCrearReserva.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCrearReserva.createSequentialGroup()
					.addGroup(gl_panelCrearReserva.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelCrearReserva.createSequentialGroup()
							.addGap(14)
							.addComponent(lblElemento))
						.addGroup(gl_panelCrearReserva.createSequentialGroup()
							.addContainerGap()
							.addComponent(textElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(11)
					.addGroup(gl_panelCrearReserva.createParallelGroup(Alignment.LEADING)
						.addComponent(dateChooserDesde, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDesde))
					.addGap(11)
					.addGroup(gl_panelCrearReserva.createParallelGroup(Alignment.LEADING)
						.addComponent(dateChooserHasta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHasta))
					.addGroup(gl_panelCrearReserva.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panelCrearReserva.createSequentialGroup()
							.addGap(11)
							.addComponent(lblDetalle)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnSolicitarReserva))
						.addGroup(gl_panelCrearReserva.createSequentialGroup()
							.addGap(10)
							.addComponent(textAreaDetalle, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		panelCrearReserva.setVisible(false);
		panelCrearReserva.setLayout(gl_panelCrearReserva);
		
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
	
	
	private void clickCrearReserva(Persona pers) throws Exception, SQLException, AppDataException{
		try {
			resLogic.add(this.mapearDeForm(pers));
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	private void clickModificarReserva(Persona pers) throws SQLException, AppDataException, ParseException{
		try {
			resLogic.updateParaCerrarRes(this.mapearDeFormFechaFin(pers));
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		r.setFecha_hora_desde_solicitada(Date.valueOf(vfechaD));	//el famoso provisorio. --> En vez de estas 5 lineas de codigo, Intent� una mas linda con dateChooserHasta.getDate() como en la linea de abajo pero no me dejaba convertir de java.util.Date a java.sql.date.... Busqe y no encontre ayuda , Luego vere otra forma "mejor"
		//r.setFecha_hora_desde_solicitada(Date.valueOf(textHasta.getText()));

				int vyearH = dateChooserHasta.getCalendar().get(Calendar.YEAR);
				int vmonthH = 1+dateChooserHasta.getCalendar().get(Calendar.MONTH);
				int vdayH = dateChooserHasta.getCalendar().get(Calendar.DAY_OF_MONTH);
				String vfechaH = vyearH + "-" + vmonthH + "-" + vdayH;
		r.setFecha_hora_hasta_solicitada(Date.valueOf(vfechaH));	//el famoso provisorio
		
		r.setDetalle(this.textAreaDetalle.getText());
		return r;
	}
	
	
	private Reserva mapearDeFormFechaFin(Persona pers) throws ParseException{
		Reserva r = new Reserva();
		//Persona p = new Persona();
		Elemento e = new Elemento();
		
		r.setId_reserva(Integer.parseInt(this.textIdReserva.getText()));
		r.setPersona(pers);	
	
				int vyearE = dateChooserFechaFinRes.getCalendar().get(Calendar.YEAR);
				int vmonthE = 1+dateChooserFechaFinRes.getCalendar().get(Calendar.MONTH);				//le sumo 1 porque january lo toma como 0 y explota tambien
				int vdayE = dateChooserFechaFinRes.getCalendar().get(Calendar.DAY_OF_MONTH);
				String vfechaE = vyearE + "-" + vmonthE + "-" + vdayE;
		r.setFecha_hora_entregado(Date.valueOf(vfechaE));			
		//el famoso provisorio.
		
		return r;
	}
	
	
	
	private void mapearAForm(Persona per){
		this.textUsuario.setText(String.valueOf(per.getUsuario()));
		//this.textUsuario.setText(p.getUsuario());
		//this.comboCategoria.setSelectedItem((Categoria) p.getCategoria());
		//this.chckbxHabilitado.setSelected(p.isHabilitado());
	}
}