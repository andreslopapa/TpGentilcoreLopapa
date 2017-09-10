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
import tools.Campo;
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

public class ABMCElementoPrueba extends ABMC {
	
	CtrlElementoLogic ctrElemLogic = new CtrlElementoLogic();
	CtrlTipoDeElementoLogic ctrTdELogic = new CtrlTipoDeElementoLogic();

	private JPanel contentPane;
	private JTextField textNombreElemento;
	private JLabel lblGestionDeElementos;
	private JLabel lblIdTitulo;
	private JLabel lblNombre;
	private JLabel lblTipo;
	private JComboBox cboTipoElemento;
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
	private Action accion;
	private JLabel lblId;
	private JButton btnAceptar;
//	private JLabel lblUpdateTipoElemento;
//	private JLabel lblCreateTipoElemento;
	//private JLabel lblBuscar_TipoElemento;
	private JButton btnCancelar;

	private static ABMCElementoPrueba instancia=null;
	
	public static ABMCElementoPrueba getInstancia(Action qAccion){
		if(instancia==null){
				try {
					instancia=new ABMCElementoPrueba();
				} 
				catch (Exception e) {
					JOptionPane.showMessageDialog(null,e.getMessage());
				}
			}
		try{
		instancia.preparaInstancia(qAccion);}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
		return instancia;
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMCElemento frame = new ABMCElemento();
					frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
	}
	
	

	/**
	 * Create the frame.
	 */
	public void preparaInstancia(Action qAccion)throws Exception{
		this.accion=qAccion;
		switch(accion){
			case DELETE:btnAceptar.setVisible(true);
						btnCancelar.setVisible(true);
						btnAceptar.setText("Borrar");
						this.lblGestionDeElementos.setText("Borrar Elemento");
						break;
			case UPDATE:btnAceptar.setVisible(true);
						btnCancelar.setVisible(true);
						btnAceptar.setText("Guardar");
						this.lblGestionDeElementos.setText("Modificar Elemento");
						break;
			case ADD:
				    this.limpiarTextoElemento();
				    this.lblId.setVisible(true);
				    this.lblId.setText(String.valueOf(ctrElemLogic.getMaxId()+1));
					btnAceptar.setVisible(true);
					btnCancelar.setVisible(true);
					btnAceptar.setText("Guardar");
					this.lblGestionDeElementos.setText("Agregar Elemento");
					break;
			case OTHER:
			default:this.lblGestionDeElementos.setText("Elemento");break;
		}
	}
	
//	public ABMCElementoPrueba(Action qAccion)throws Exception{
//		//this();esto llama al constructor grandote
//		//this()=ABMCElementoPrueba.getInstancia();
//		this.accion=qAccion;
//		switch(accion){
//			case DELETE:btnAceptar.setVisible(true);
//						btnCancelar.setVisible(true);
//						btnAceptar.setText("Borrar");
//						this.lblGestionDeElementos.setText("Borrar Elemento");
//						break;
//			case UPDATE:btnAceptar.setVisible(true);
//						btnCancelar.setVisible(true);
//						btnAceptar.setText("Guardar");
//						this.lblGestionDeElementos.setText("Modificar Elemento");
//						break;
//			case ADD:
//				    this.limpiarTextoElemento();
//					btnAceptar.setVisible(true);
//					btnCancelar.setVisible(true);
//					btnAceptar.setText("Guardar");
//					this.lblGestionDeElementos.setText("Agregar Elemento");
//					break;
//			case OTHER:
//			default:this.lblGestionDeElementos.setText("Elemento");break;
//		}
//	}
	
	public ABMCElementoPrueba()throws Exception{
		setBorder(null);
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		
		this.accion=Action.OTHER;
		//this.setIconImage(Toolkit.getDefaultToolkit().getImage(ABMCElemento.class.getResource("/ui/Desktop/cropped-3w2-web-dominios-hosting.png")));
		this.setBackground(Color.WHITE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 368, 302);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(2, 2, 2, 2));
		setContentPane(contentPane);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(23)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
					.addGap(48))
		);
		
		lblGestionDeElementos = new JLabel("Elemento");
		lblGestionDeElementos.setHorizontalAlignment(SwingConstants.LEFT);
		lblGestionDeElementos.setFont(new Font("Calibri", Font.BOLD, 18));
		
		lblIdTitulo = new JLabel("ID:");
		lblIdTitulo.setToolTipText("El ID s\u00F3lo es para busqueda, al crear se asignar\u00E1 uno nuevo automaticamente");
		lblIdTitulo.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textNombreElemento = new JTextField();
		textNombreElemento.setColumns(10);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		
		lblTipo = new JLabel("Tipo");
		lblTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		
		
		cboTipoElemento = new JComboBox();
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AccionarClick();
			}
		});
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cancelarClick();
			}
		});
		btnAceptar.setVisible(false);
		btnCancelar.setVisible(false);
		
		lblId = new JLabel("");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblIdTitulo, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
								.addComponent(lblNombre, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(10))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblTipo, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(btnAceptar)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnCancelar))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(textNombreElemento, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
								.addComponent(cboTipoElemento, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
							.addGap(53))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblGestionDeElementos)
								.addComponent(lblId))))
					.addGap(37))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(27)
					.addComponent(lblGestionDeElementos)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdTitulo, GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
						.addComponent(lblId))
					.addGap(17)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(textNombreElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(cboTipoElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTipo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(26)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAceptar)
						.addComponent(btnCancelar))
					.addContainerGap())
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

	
	protected void cancelarClick() {
		this.btnAceptar.setVisible(false);
		this.btnCancelar.setVisible(false);
		this.lblGestionDeElementos.setText("Elemento");
		this.accion=Action.OTHER;
		this.limpiarTextoElemento();
		try {
			ListadoElementos.getInstancia().mapearHaciaABMCElementoClick();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}


	protected void AccionarClick() {
		boolean resultado=false;
		switch(accion){
		case ADD:resultado=clickAgregar();break;
		case UPDATE:resultado=clickModificar();break;
		case DELETE:resultado=clickEliminar();break;
		default:break;
		}
		if(resultado){
			this.btnAceptar.setVisible(false);
			this.btnCancelar.setVisible(false);
			this.lblGestionDeElementos.setText("Elemento");
			this.accion=Action.OTHER;
			this.limpiarTextoElemento();
			try {
				ListadoElementos.getInstancia().Actualiza();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
			}
		}
	}


	private void cargarListas(){
		try {
			this.cboTipoElemento.setModel(new DefaultComboBoxModel(ctrElemLogic.getTipoDeElemento().toArray()));
			this.cboTipoElemento.setSelectedIndex(-1);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Error al cargar lista de tipos de elementos\n"+e.getMessage(),
					"Error",JOptionPane.ERROR);
		}
	}
	
	
	//al final buscaremos por listado,este no
//	protected void clickBuscarElemento() throws Exception{
//		try {
//			if(textIdElemento.getText().length() >0){
//			this.mapearAForm(ctrElemLogic.getOne(this.mapearDeForm()));
//			}else{
//			JOptionPane.showMessageDialog(this, "Debe ingresar un elemento a buscar", "", JOptionPane.INFORMATION_MESSAGE);
//			}
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(this, e.getMessage());
//			//JOptionPane.showMessageDialog(this, "No se pudo encontrar el elemento", "", JOptionPane.WARNING_MESSAGE);
//
//		}
//	}
	
	
	private Elemento mapearDeForm(){
		Elemento e = new Elemento();		
		//if(!this.textIdElemento.getText().isEmpty()){
		//if(Campo.Valida(this.textIdElemento.getText(), Campo.tipo.ID)){
		
			if(lblId.isVisible() && !lblId.getText().isEmpty()){e.setId_elemento(Integer.parseInt(lblId.getText()));}
			e.setNombre(this.textNombreElemento.getText());
			if (this.cboTipoElemento.getSelectedIndex() != -1){
				e.setTipo((TipoDeElemento) this.cboTipoElemento.getSelectedItem());
			}
			else{
				JOptionPane.showMessageDialog(null, "Seleccione un tipo por favor");
				return null;
			}
		
		return e;
	}

	protected boolean clickAgregar(){
		try {		
						
			Elemento ele=this.mapearDeForm();
			if(ele!=null){
				ctrElemLogic.add(this.mapearDeForm());
				JOptionPane.showMessageDialog(null, "Elemento guardado correctamente", "", JOptionPane.INFORMATION_MESSAGE);
			    return true;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error elemento no agregado\n"+e.getMessage());
		}
		return false;
	}
	
	
	protected boolean clickModificar(){
		try {
			Elemento ele=this.mapearDeForm();
			if(ele!=null){
				ctrElemLogic.update(ele);
				JOptionPane.showMessageDialog(null, "Elemento actualizado", "", JOptionPane.INFORMATION_MESSAGE);
				return true;
				}
			}
		catch(Exception e) {
			limpiarTextoElemento();
			JOptionPane.showMessageDialog(null, e.getMessage());}
		return false;
		} 
	
	
	
	private boolean clickEliminar(){
		try {
			Elemento ele=this.mapearDeForm();
			if(ele!=null){
				ctrElemLogic.delete(ele);
				JOptionPane.showMessageDialog(null, "Elemento eliminado", "", JOptionPane.INFORMATION_MESSAGE);
				return true;
				}
			} catch (Exception e) {
			limpiarTextoElemento();
			JOptionPane.showMessageDialog(null, e.getMessage());}
		return false;
	}
	
	public void mapearAForm(Elemento e){
		if(e!=null){
//			if(accion==Action.OTHER){
				this.lblId.setVisible(true);
				this.lblId.setText(Integer.toString((e.getId_elemento())));
				this.textNombreElemento.setText(e.getNombre());
				if (e.getTipo()!=null){
					this.cboTipoElemento.setSelectedItem((TipoDeElemento) e.getTipo());
					}
//				}
			}
		else{
			this.limpiarTextoElemento();
			}
	}
	
	private void limpiarTextoElemento(){
		lblId.setVisible(false);
		this.textNombreElemento.setText("");
		cboTipoElemento.setSelectedIndex(-1);
	}


	public Action getAccion() {
		return accion;
	}


	public void setAccion(Action accion) {
		this.accion = accion;
	}
}