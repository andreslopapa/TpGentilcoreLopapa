package ui.Desktop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
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

public class ABMCElemento extends JInternalFrame {
	
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
//	private JLabel lblUpdateTipoElemento;
//	private JLabel lblCreateTipoElemento;
	//private JLabel lblBuscar_TipoElemento;

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
		//this.setIconImage(Toolkit.getDefaultToolkit().getImage(ABMCElemento.class.getResource("/ui/Desktop/cropped-3w2-web-dominios-hosting.png")));
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
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panelBarraAzulLateral, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, 0, 0, Short.MAX_VALUE)
					.addGap(45))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(panelBarraAzulLateral, GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 251, Short.MAX_VALUE)
					.addGap(290))
		);
		
		lblGestinDeElementos = new JLabel("Elementos");
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
		
		JButton btnBorrar = new JButton("");
		btnBorrar.setToolTipText("Eliminar elemento");
		btnBorrar.setBorderPainted(false);
		btnBorrar.setBackground(Color.WHITE);
		btnBorrar.setIcon(new ImageIcon(ABMCElemento.class.getResource("/ui/Desktop/ic_delete_sweep_black_24dp_1x.png")));
		
		JButton btnModificar = new JButton("");
		btnModificar.setToolTipText("Actualizar elemento");
		btnModificar.setBackground(Color.WHITE);
		btnModificar.setBorderPainted(false);
		btnModificar.setIcon(new ImageIcon(ABMCElemento.class.getResource("/ui/Desktop/Update black .png")));
	//	btnModificar.setIcon(new ImageIcon(ABMCElemento.class.getResource("/ui/Desktop/Update black .png")));
		btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickModificar();
			}
		});
		
		JButton btnGuardar = new JButton("");
		btnGuardar.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnGuardar.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnGuardar.setBorderPainted(false);
		btnGuardar.setBorder(null);
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setBackground(Color.WHITE);
		btnGuardar.setIcon(new ImageIcon(ABMCElemento.class.getResource("/ui/Desktop/ic_add_circle_black_24dp_1x.png")));
		btnGuardar.setToolTipText("El ID s\u00F3lo es para busqueda, al crear se asignar\u00E1 uno nuevo automaticamente");
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				clickGuardar();
			}
		});
		
	
		JButton btnBuscar = new JButton("");
		btnBuscar.setToolTipText("Buscar elemento");
		btnBuscar.setBorderPainted(false);
		btnBuscar.setBackground(Color.WHITE);
		btnBuscar.setIcon(new ImageIcon(ABMCElemento.class.getResource("/ui/Desktop/ic_search_black_24dp_1x.png")));
	//	btnBuscar.setSelectedIcon(new ImageIcon(ABMCElemento.class.getResource("/ui/Desktop/ic_search_black_24dp_1x.png")));
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					clickBuscarElemento();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textNombreElemento, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnModificar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnBorrar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblGestinDeElementos)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(textIdElemento, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblTipo, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(comboBoxTipoElemento, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)))
					.addGap(50))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(5)
					.addComponent(lblGestinDeElementos)
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addGap(9)
								.addComponent(lblId, GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE))
							.addGroup(gl_panel_1.createSequentialGroup()
								.addGap(3)
								.addComponent(textIdElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(12)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNombre)
								.addComponent(textNombreElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(20)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTipo, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
								.addComponent(comboBoxTipoElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(41))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, 23, Short.MAX_VALUE)
								.addComponent(btnModificar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnBorrar))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(65))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblTiposDeElementos = new JLabel("Tipos de Elementos");
		lblTiposDeElementos.setHorizontalAlignment(SwingConstants.LEFT);
		lblTiposDeElementos.setFont(new Font("Calibri", Font.BOLD, 18));
		
		lblId_TipoElemento = new JLabel("ID");
		lblId_TipoElemento.setToolTipText("El ID s\u00F3lo es para busqueda, ");
		lblId_TipoElemento.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textIdTipoDeElemento = new JTextField();
		textIdTipoDeElemento.setToolTipText("El ID s\u00F3lo es para busqueda, al crear se asignar\u00E1 uno nuevo automaticamente");
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
		
		lblA = new JLabel("- Condiciones para reservar \u00E9ste Tipo-");
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
		
		

		contentPane.setLayout(gl_contentPane);
		cargarListas();
		((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);//esto saca la barra de arriba
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
				JOptionPane.showMessageDialog(this, "No se ha ingresado ning�n elemento", "", JOptionPane.WARNING_MESSAGE);
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
	//	if (comboBoxTipoElemento.getSelectedIndex() != -1){
			e.setTipo((TipoDeElemento) this.comboBoxTipoElemento.getSelectedItem());
		//}
		return e;
	}
	
	private void mapearAForm(Elemento e){
		this.textIdElemento.setText(Integer.toString((e.getId_elemento())));
		this.textNombreElemento.setText(e.getNombre());
		//if (e.getTipo()!=null){
			this.comboBoxTipoElemento.setSelectedItem((TipoDeElemento) e.getTipo());
	//	}
	}
	
	private void limpiarTextoElemento(){
		this.textIdElemento.setText("");
		this.textNombreElemento.setText("");
	}
	
	
}