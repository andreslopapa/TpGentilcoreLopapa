package ui.Desktop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import business.entities.Categoria;
import business.entities.Elemento;
import business.entities.TipoDeElemento;
import business.logic.CtrlElementoLogic;
import business.logic.CtrlTipoDeElementoLogic;
import tools.AppDataException;
import tools.FormatoEmail;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JScrollBar;

public class ABMCElemento extends JFrame {
	
	CtrlElementoLogic ctrElemLogic = new CtrlElementoLogic();
	CtrlTipoDeElementoLogic ctrTdELogic = new CtrlTipoDeElementoLogic();

	private JPanel contentPane;
	private JTextField textIdElemento;
	private JTextField textNombreElemento;
	private JLabel lblGestinDeElementos;
	private JLabel lblId;
	private JLabel lblNombre;
	private JLabel lblIconoElemento;
	private JLabel lblTipo;
	private JComboBox comboBoxTipoElemento;
	private JTextField textIdTipoDeElemento;
	private JLabel lblId_TipoElemento;
	private JTextField textNombreTipoElemento;
	private JLabel lblNombreTipoElemento;
	private JTextField textCantMaxPerRes;
	private JLabel lblMaxResPendiente;
	private JPanel panel_1;
	private JLabel lblA;
	private JLabel lblLimiteHoras;
	private JTextField textLimiteHoras;
	private JLabel lblDasDeAnticipacin;
	private JTextField textDiasDeAnticipacion;
	private JLabel lblUpdateTipoElemento;
	private JLabel lblCreateTipoElemento;
	private JLabel lblBuscar_TipoElemento;

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
	public ABMCElemento() throws Exception{
		
		this.setTitle("Sistema de gesti\u00F3n de reservas");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(ABMCElemento.class.getResource("/ui/Desktop/cropped-3w2-web-dominios-hosting.png")));
		this.setBackground(Color.WHITE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 782, 586);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(2, 2, 2, 2));
		setContentPane(contentPane);
		
		JPanel panelBarraAzulLateral = new JPanel();
		panelBarraAzulLateral.setBackground(new Color(0, 51, 102));
		
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
		
		JPanel panelTipoDeElemento = new JPanel();
		panelTipoDeElemento.setBackground(Color.WHITE);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panelBarraAzulLateral, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panelTipoDeElemento, GroupLayout.PREFERRED_SIZE, 579, GroupLayout.PREFERRED_SIZE)
							.addGap(8))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(panel_1, 0, 0, Short.MAX_VALUE)
							.addGap(18)))
					.addGap(27))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(panelBarraAzulLateral, GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 243, Short.MAX_VALUE)
					.addGap(11)
					.addComponent(panelTipoDeElemento, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
					.addGap(19))
		);
		
		lblGestinDeElementos = new JLabel("Gesti\u00F3n de elementos");
		lblGestinDeElementos.setHorizontalAlignment(SwingConstants.LEFT);
		lblGestinDeElementos.setFont(new Font("Calibri", Font.BOLD, 18));
		
		lblId = new JLabel("ID");
		lblId.setToolTipText("El ID s\u00F3lo es para busqueda, al crear se asignar\u00E1 uno nuevo automaticamente");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textIdElemento = new JTextField();
		textIdElemento.setToolTipText("El ID s\u00F3lo es para busqueda, al crear se asignar\u00E1 uno nuevo automaticamente");
		textIdElemento.setColumns(10);
		
		textNombreElemento = new JTextField();
		textNombreElemento.setColumns(10);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		
		lblTipo = new JLabel("Tipo");
		lblTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		
		
		comboBoxTipoElemento = new JComboBox();
		
		JButton btnBorrar = new JButton("Borrar");
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					clickModificar();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setSelectedIcon(null);
		btnGuardar.setToolTipText("El ID s\u00F3lo es para busqueda, al crear se asignar\u00E1 uno nuevo automaticamente");
		btnGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					clickGuardar();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
	
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setForeground(new Color(0, 51, 102));
		btnBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					clickBuscarElemento();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
				
				
				JLabel lblAcaPodriaSer = new JLabel("El ID s\u00F3lo es para busqueda, \r\nal crear se asignar\u00E1 uno nuevo automaticamente");
				lblAcaPodriaSer.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblTipo, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_1.createSequentialGroup()
											.addComponent(btnBorrar)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(btnModificar, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
											.addGap(93)
											.addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
											.addGap(207))
										.addComponent(comboBoxTipoElemento, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textNombreElemento, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(lblGestinDeElementos)
										.addGroup(gl_panel_1.createSequentialGroup()
											.addComponent(textIdElemento, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
											.addGap(52)
											.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(119)
							.addComponent(lblAcaPodriaSer, GroupLayout.PREFERRED_SIZE, 412, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(5)
					.addComponent(lblGestinDeElementos)
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(9)
							.addComponent(lblId, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(textIdElemento))
						.addComponent(btnBuscar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(12)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(textNombreElemento))
					.addGap(14)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(6)
							.addComponent(lblTipo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(comboBoxTipoElemento))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBorrar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnModificar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnGuardar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblAcaPodriaSer, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
					.addGap(10))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblTiposDeElementos = new JLabel("Tipos de Elementos");
		lblTiposDeElementos.setHorizontalAlignment(SwingConstants.LEFT);
		lblTiposDeElementos.setFont(new Font("Calibri", Font.BOLD, 18));
		
		lblId_TipoElemento = new JLabel("ID");
		lblId_TipoElemento.setToolTipText("El ID s\u00F3lo es para busqueda, ");
		lblId_TipoElemento.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textIdTipoDeElemento = new JTextField();
		textIdTipoDeElemento.setToolTipText("El ID s\u00F3lo es para busqueda, ");
		textIdTipoDeElemento.setColumns(10);
		
		textNombreTipoElemento = new JTextField();
		textNombreTipoElemento.setColumns(10);
		
		lblNombreTipoElemento = new JLabel("Nombre");
		lblNombreTipoElemento.setHorizontalAlignment(SwingConstants.RIGHT);
		
		lblMaxResPendiente = new JLabel("Max reservas pendientes");
		lblMaxResPendiente.setToolTipText("Cantidad m\u00E1xima de elementos de este tipo que cada usuario puede tener pendiente a futuro");
		lblMaxResPendiente.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textCantMaxPerRes = new JTextField();
		textCantMaxPerRes.setToolTipText("Cantidad m\u00E1xima de elementos de este tipo que cada usuario puede tener pendiente a futuro");
		textCantMaxPerRes.setColumns(10);
		
		lblA = new JLabel("- Condiciones para reservar-");
		lblA.setFont(new Font("Tahoma", Font.ITALIC, 11));
		
		lblLimiteHoras = new JLabel("Limite de horas ");
		lblLimiteHoras.setToolTipText("L\u00EDmite m\u00E1ximo de tiempo de reserva (en horas) que se controlarar\u00E1n durante la reserva.");
		
		textLimiteHoras = new JTextField();
		textLimiteHoras.setToolTipText("L\u00EDmite m\u00E1ximo de tiempo de reserva (en horas) que se controlarar\u00E1n durante la reserva.");
		textLimiteHoras.setColumns(10);
		
		lblDasDeAnticipacin = new JLabel("D\u00EDas de anticipaci\u00F3n");
		lblDasDeAnticipacin.setToolTipText("Cantidad m\u00E1xima de d\u00EDas de anticipaci\u00F3n para ser reservados");
		
		textDiasDeAnticipacion = new JTextField();
		textDiasDeAnticipacion.setToolTipText("Cantidad m\u00E1xima de d\u00EDas de anticipaci\u00F3n para ser reservados");
		textDiasDeAnticipacion.setColumns(10);
		
		JLabel lblDeleteTipoElemento = new JLabel("");
		lblDeleteTipoElemento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					clickEliminarTipoElemento();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		lblDeleteTipoElemento.setToolTipText("Eliminar Tipo de Elemento");
		lblDeleteTipoElemento.setIcon(new ImageIcon(ABMCElemento.class.getResource("/ui/Desktop/ic_delete_sweep_black_24dp_1x.png")));
		
		
		lblUpdateTipoElemento = new JLabel("");
		lblUpdateTipoElemento.setToolTipText("Editar Tipo de Elemento");
		lblUpdateTipoElemento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					clickActualizarTipoElemento();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		lblUpdateTipoElemento.setIcon(new ImageIcon(ABMCElemento.class.getResource("/ui/Desktop/ic_create_black_24dp_1x.png")));
		
		
		lblCreateTipoElemento = new JLabel("");
		lblCreateTipoElemento.setToolTipText("Crear nuevo Tipo");
		lblCreateTipoElemento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					clickAgregarTipoElemento();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		lblCreateTipoElemento.setIcon(new ImageIcon(ABMCElemento.class.getResource("/ui/Desktop/ic_add_circle_black_24dp_1x.png")));
		
		
		lblBuscar_TipoElemento = new JLabel("");
		lblBuscar_TipoElemento.setToolTipText("Buscar Tipo de Elemento");
		lblBuscar_TipoElemento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					buscarTipoElemento();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		lblBuscar_TipoElemento.setIcon(new ImageIcon(ABMCElemento.class.getResource("/ui/Desktop/ic_search_black_24dp_1x.png")));
		GroupLayout gl_panelTipoDeElemento = new GroupLayout(panelTipoDeElemento);
		gl_panelTipoDeElemento.setHorizontalGroup(
			gl_panelTipoDeElemento.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTipoDeElemento.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelTipoDeElemento.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNombreTipoElemento, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblId_TipoElemento, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelTipoDeElemento.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelTipoDeElemento.createSequentialGroup()
							.addComponent(lblA)
							.addContainerGap())
						.addGroup(gl_panelTipoDeElemento.createSequentialGroup()
							.addGroup(gl_panelTipoDeElemento.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTiposDeElementos)
								.addGroup(gl_panelTipoDeElemento.createSequentialGroup()
									.addGroup(gl_panelTipoDeElemento.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panelTipoDeElemento.createSequentialGroup()
											.addGroup(gl_panelTipoDeElemento.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblDasDeAnticipacin)
												.addGroup(gl_panelTipoDeElemento.createParallelGroup(Alignment.TRAILING)
													.addComponent(lblMaxResPendiente, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
													.addComponent(lblLimiteHoras)))
											.addGap(18)
											.addGroup(gl_panelTipoDeElemento.createParallelGroup(Alignment.TRAILING)
												.addComponent(textCantMaxPerRes, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
												.addComponent(textLimiteHoras, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
												.addComponent(textDiasDeAnticipacion, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)))
										.addComponent(textNombreTipoElemento, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblCreateTipoElemento)
									.addGap(18)
									.addComponent(lblUpdateTipoElemento)
									.addGap(18)
									.addComponent(lblDeleteTipoElemento)))
							.addGap(132))
						.addGroup(gl_panelTipoDeElemento.createSequentialGroup()
							.addComponent(textIdTipoDeElemento, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblBuscar_TipoElemento)
							.addContainerGap())))
		);
		gl_panelTipoDeElemento.setVerticalGroup(
			gl_panelTipoDeElemento.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTipoDeElemento.createSequentialGroup()
					.addGap(7)
					.addComponent(lblTiposDeElementos)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelTipoDeElemento.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelTipoDeElemento.createSequentialGroup()
							.addGroup(gl_panelTipoDeElemento.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblId_TipoElemento)
								.addComponent(textIdTipoDeElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(20)
							.addComponent(lblNombreTipoElemento))
						.addGroup(gl_panelTipoDeElemento.createSequentialGroup()
							.addComponent(lblBuscar_TipoElemento)
							.addGap(10)
							.addGroup(gl_panelTipoDeElemento.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUpdateTipoElemento)
								.addComponent(lblCreateTipoElemento)
								.addComponent(lblDeleteTipoElemento)
								.addComponent(textNombreTipoElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
					.addComponent(lblA)
					.addGap(18)
					.addGroup(gl_panelTipoDeElemento.createParallelGroup(Alignment.BASELINE)
						.addComponent(textCantMaxPerRes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMaxResPendiente))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelTipoDeElemento.createParallelGroup(Alignment.BASELINE)
						.addComponent(textLimiteHoras, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLimiteHoras))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelTipoDeElemento.createParallelGroup(Alignment.BASELINE)
						.addComponent(textDiasDeAnticipacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDasDeAnticipacin))
					.addContainerGap())
		);
		panelTipoDeElemento.setLayout(gl_panelTipoDeElemento);
		contentPane.setLayout(gl_contentPane);
		cargarListas();
	}

	
	private void cargarListas(){
		try {
			this.comboBoxTipoElemento.setModel(new DefaultComboBoxModel(ctrElemLogic.getTipoDeElemento().toArray()));
			this.comboBoxTipoElemento.setSelectedIndex(-1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void clickBuscarElemento() throws Exception{
		try {
			if(textIdElemento.getText().length() >0){
			this.mapearAForm(ctrElemLogic.getOne(this.mapearDeForm()));
			}else{
			JOptionPane.showMessageDialog(this, "Debe ingresar un elemento a buscar", "", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
			//JOptionPane.showMessageDialog(this, "No se pudo encontrar el elemento", "", JOptionPane.WARNING_MESSAGE);

		}
	}
	
	protected void clickGuardar(){
		try {		
			if(textIdElemento.getText().length() >0){				
			
				ctrElemLogic.add(this.mapearDeForm());
			JOptionPane.showMessageDialog(this, "Elemento guardado correctamente", "", JOptionPane.OK_OPTION);
			}else{
				JOptionPane.showMessageDialog(this, "Debe completar todos los campos", "", JOptionPane.WARNING_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	
	
	protected void clickModificar(){
		try {
			if(textIdElemento.getText().length() >0){
				ctrElemLogic.update(mapearDeForm());
			JOptionPane.showMessageDialog(this, "Elemento actualizado", "", JOptionPane.INFORMATION_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(this, "No se ha ingresado ningún elemento", "", JOptionPane.WARNING_MESSAGE);
			}
		} catch (Exception e) {
			limpiarTextoElemento();
			JOptionPane.showMessageDialog(this, e.getMessage());		}
	}
	
	private Elemento mapearDeForm(){
		Elemento e = new Elemento();		
		if(!this.textIdElemento.getText().isEmpty()){
			e.setId_elemento(Integer.parseInt(this.textIdElemento.getText()));
		}
		e.setNombre(this.textNombreElemento.getText());
		if (comboBoxTipoElemento.getSelectedIndex() != -1){
			e.setTipo((TipoDeElemento) this.comboBoxTipoElemento.getSelectedItem());
		}
		return e;
	}
	
	private void mapearAForm(Elemento e){
		this.textIdElemento.setText(Integer.toString((e.getId_elemento())));
		this.textNombreElemento.setText(e.getNombre());
		if (e.getTipo()!=null){
			this.comboBoxTipoElemento.setSelectedItem((TipoDeElemento) e.getTipo());
		}
	}
	
	private void limpiarTextoElemento(){
		this.textIdElemento.setText("");
		this.textNombreElemento.setText("");
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//TIPOS DE ELEMENTOS	
	private void mapearAFormTdE(TipoDeElemento t){
		
	//	this.textIdTipoDeElemento.setText(Integer.toString(t.getId()));
		this.textNombreTipoElemento.setText(t.getNombre());
		this.textCantMaxPerRes.setText(Integer.toString(t.getCant_max_res_pen()));
		this.textDiasDeAnticipacion.setText(Integer.toString(t.getDias_max_anticipacion()));
		this.textLimiteHoras.setText(Integer.toString(t.getLimite_horas_res()));
	}
	
	private TipoDeElemento mapearDeFormTdE(){
		TipoDeElemento t = new TipoDeElemento();
		t.setId(Integer.parseInt(this.textIdTipoDeElemento.getText().trim()));
		t.setNombre(this.textNombreTipoElemento.getText());
		t.setCant_max_res_pen(Integer.parseInt(this.textCantMaxPerRes.getText().trim()));
		t.setDias_max_anticipacion(Integer.parseInt(this.textDiasDeAnticipacion.getText().trim()));
		t.setLimite_horas_res(Integer.parseInt(this.textLimiteHoras.getText().trim()));
		return t;
	}
	
	private void clickAgregarTipoElemento() throws Exception{
		try {		
			if(textNombreTipoElemento.getText().length() >0){				
			
				ctrTdELogic.add(this.mapearDeFormTdE());
			JOptionPane.showMessageDialog(this, "Tipo de elemento guardado correctamente", "", JOptionPane.YES_OPTION);
			}else{
				JOptionPane.showMessageDialog(this, "Debes completar todos los campos, excepto el campo ID", "", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	
	
	private void buscarTipoElemento() throws Exception{
		try {
			if(textIdTipoDeElemento.getText().length()>0){
			this.mapearAFormTdE(ctrTdELogic.getOne(this.mapearDeFormTdE()));
			}else{
				JOptionPane.showMessageDialog(this, "Debes ingresar un ID del Tipo de Elemento a buscar", "", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());		}	
	}
	
	private void clickActualizarTipoElemento() throws Exception{
		try {
			if(textIdTipoDeElemento.getText().length()>0){
	            int reply = JOptionPane.showConfirmDialog(null,
	                    "¿Desea actualizar el Tipo De Elemento ?", "Actualización", JOptionPane.YES_NO_OPTION);
	            if (reply == JOptionPane.YES_OPTION){			
	    			ctrTdELogic.update(this.mapearDeFormTdE());
	    			limpiarTextoTipoElemento();
	            }  
			}else{
				JOptionPane.showMessageDialog(this, "Debes ingresar un ID del Tipo de Elemento a buscar y actualizar", "", JOptionPane.INFORMATION_MESSAGE);
		}} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());		}
	}
	
	private void clickEliminarTipoElemento() throws Exception{
		try {
			if(textIdTipoDeElemento.getText().length()>0){
		            int reply = JOptionPane.showConfirmDialog(null,
		                    "¿Desea eliminar el Tipo De Elemento ?", "Eliminación Tipo de Elemento", JOptionPane.YES_NO_OPTION);
		            if (reply == JOptionPane.YES_OPTION){			
		            	ctrTdELogic.delete(this.mapearDeFormTdE());
		    			limpiarTextoTipoElemento();
		            }            	
		}else{
			JOptionPane.showMessageDialog(this, "Debes ingresar un ID del Tipo de Elemento a buscar y eliminar", "", JOptionPane.INFORMATION_MESSAGE);
		}} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());		}
	}
	
	private void limpiarTextoTipoElemento(){
		this.textIdTipoDeElemento.setText("");
		this.textNombreTipoElemento.setText("");
		this.textCantMaxPerRes.setText("");
		this.textDiasDeAnticipacion.setText("");
		this.textLimiteHoras.setText("");
	}
	
}