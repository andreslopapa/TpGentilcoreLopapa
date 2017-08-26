package ui.Desktop;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import business.entities.Elemento;
import business.entities.TipoDeElemento;
import business.logic.CtrlTipoDeElementoLogic;

import java.awt.Toolkit;
import javax.swing.JPanel;

public class ABMCTipoDeElemento {
	CtrlTipoDeElementoLogic ctrTdELogic = new CtrlTipoDeElementoLogic();

	private JFrame frmSistemaDeGestin;
	private JTextField textIdTipoDeElemento;
	private JTextField textNombreTipoElemento;
	private JTextField textCantMaxPerRes;
	private JTextField textLimiteHoras;
	private JTextField textDiasDeAnticipacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMCTipoDeElemento window = new ABMCTipoDeElemento();
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
	public ABMCTipoDeElemento() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSistemaDeGestin = new JFrame();
		frmSistemaDeGestin.setTitle("Sistema de gesti\u00F3n de reservas");
		frmSistemaDeGestin.setIconImage(Toolkit.getDefaultToolkit().getImage(ABMCTipoDeElemento.class.getResource("/ui/Desktop/cropped-3w2-web-dominios-hosting.png")));
		frmSistemaDeGestin.getContentPane().setBackground(Color.WHITE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 51, 102));
		
		textIdTipoDeElemento = new JTextField();
		textIdTipoDeElemento.setColumns(10);
		
		JLabel lblId_TipoElemento = new JLabel("ID");
		
		JButton lblBuscar_TipoElemento = new JButton("");
		lblBuscar_TipoElemento.setContentAreaFilled(false);
		lblBuscar_TipoElemento.setBorder(null);
		lblBuscar_TipoElemento.setBorderPainted(false);
		lblBuscar_TipoElemento.setIcon(new ImageIcon(ABMCTipoDeElemento.class.getResource("/ui/Desktop/ic_search_black_24dp_1x.png")));
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

		
		textNombreTipoElemento = new JTextField();
		textNombreTipoElemento.setColumns(10);
		
		
		
		
	
		
		
		JLabel lblNombreTipoElemento = new JLabel("Nombre");
		
		JButton lblCreateTipoElemento = new JButton("");
		lblCreateTipoElemento.setToolTipText("El ID s\u00F3lo es para busqueda, al crear se asignar\u00E1 uno nuevo automaticamente");
		lblCreateTipoElemento.setBorderPainted(false);
		lblCreateTipoElemento.setContentAreaFilled(false);
		lblCreateTipoElemento.setBackground(Color.WHITE);
		lblCreateTipoElemento.setIcon(new ImageIcon(ABMCElemento.class.getResource("/ui/Desktop/ic_add_circle_black_24dp_1x.png")));
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
		
		JButton lblUpdateTipoElemento = new JButton("");
		lblUpdateTipoElemento.setToolTipText("Actualizar tipo de elemento");
		lblUpdateTipoElemento.setBorderPainted(false);
		lblUpdateTipoElemento.setContentAreaFilled(false);
		lblUpdateTipoElemento.setBackground(Color.WHITE);
		lblUpdateTipoElemento.setIcon(new ImageIcon(ABMCElemento.class.getResource("/ui/Desktop/ic_create_black_24dp_1x.png")));
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
		
		JButton lblDeleteTipoElemento = new JButton("");
		lblDeleteTipoElemento.setBorderPainted(false);
		lblDeleteTipoElemento.setContentAreaFilled(false);
		lblDeleteTipoElemento.setBackground(Color.WHITE);
		lblDeleteTipoElemento.setIcon(new ImageIcon(ABMCElemento.class.getResource("/ui/Desktop/ic_delete_sweep_black_24dp_1x.png")));
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
		
		textCantMaxPerRes = new JTextField();
		textCantMaxPerRes.setColumns(10);
		
		JLabel lblMaxResPendiente = new JLabel("Max reservas pendientes");
		
		textLimiteHoras = new JTextField();
		textLimiteHoras.setColumns(10);
		
		JLabel lblLimiteHoras = new JLabel("Limite de horas ");
		
		textDiasDeAnticipacion = new JTextField();
		textDiasDeAnticipacion.setColumns(10);
		
		JLabel lblDasDeAnticipacin = new JLabel("D\u00EDas de anticipaci\u00F3n");
		
		
		
		GroupLayout groupLayout = new GroupLayout(frmSistemaDeGestin.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblDasDeAnticipacin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblId_TipoElemento, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNombreTipoElemento, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
						.addComponent(lblMaxResPendiente, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblLimiteHoras, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textNombreTipoElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblCreateTipoElemento, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblUpdateTipoElemento, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(lblDeleteTipoElemento, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textIdTipoDeElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblBuscar_TipoElemento))
						.addComponent(textCantMaxPerRes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textLimiteHoras, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textDiasDeAnticipacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(291, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(17)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblBuscar_TipoElemento)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblId_TipoElemento)
							.addComponent(textIdTipoDeElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblDeleteTipoElemento, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblUpdateTipoElemento, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNombreTipoElemento)
							.addComponent(textNombreTipoElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblCreateTipoElemento, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textCantMaxPerRes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMaxResPendiente))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textLimiteHoras, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLimiteHoras))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(textDiasDeAnticipacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDasDeAnticipacin))
					.addContainerGap(273, Short.MAX_VALUE))
		);
		
		JLabel lblIconoTdE = new JLabel("");
		lblIconoTdE.setIcon(new ImageIcon(ABMCTipoDeElemento.class.getResource("/ui/Desktop/ic_devices_white_24dp_2x.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(23)
					.addComponent(lblIconoTdE)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblIconoTdE)
					.addContainerGap(434, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		frmSistemaDeGestin.getContentPane().setLayout(groupLayout);
		frmSistemaDeGestin.setBounds(100, 100, 807, 498);
		frmSistemaDeGestin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	
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
		t.setId(Integer.parseInt(this.textIdTipoDeElemento.getText()));
		t.setNombre(this.textNombreTipoElemento.getText());
		t.setCant_max_res_pen(Integer.parseInt(this.textCantMaxPerRes.getText()));
		t.setDias_max_anticipacion(Integer.parseInt(this.textDiasDeAnticipacion.getText()));
		t.setLimite_horas_res(Integer.parseInt(this.textLimiteHoras.getText()));
		return t;
	}
	
	private void clickAgregarTipoElemento() throws Exception{
		try {		
			if(textNombreTipoElemento.getText().length() >0){				
			
				ctrTdELogic.add(this.mapearDeFormTdE());
			JOptionPane.showMessageDialog(frmSistemaDeGestin, "Tipo de elemento guardado correctamente", "", JOptionPane.YES_OPTION);
			}else{
				JOptionPane.showMessageDialog(frmSistemaDeGestin, "Debes completar todos los campos, excepto el campo ID", "", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frmSistemaDeGestin, e.getMessage());
		}
	}
	
	
	private void buscarTipoElemento() throws Exception{
		try {
			if(textIdTipoDeElemento.getText().length()>0){
			this.mapearAFormTdE(ctrTdELogic.getOne(this.mapearDeFormTdE()));
			}else{
				JOptionPane.showMessageDialog(frmSistemaDeGestin, "Debes ingresar un ID del Tipo de Elemento a buscar", "", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frmSistemaDeGestin, e.getMessage());		}	
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
				JOptionPane.showMessageDialog(frmSistemaDeGestin, "Debes ingresar un ID del Tipo de Elemento a buscar y actualizar", "", JOptionPane.INFORMATION_MESSAGE);
		}} catch (Exception e) {
			JOptionPane.showMessageDialog(frmSistemaDeGestin, e.getMessage());		}
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
			JOptionPane.showMessageDialog(frmSistemaDeGestin, "Debes ingresar un ID del Tipo de Elemento a buscar y eliminar", "", JOptionPane.INFORMATION_MESSAGE);
		}} catch (Exception e) {
			JOptionPane.showMessageDialog(frmSistemaDeGestin, e.getMessage());		}
	}
	
	private void limpiarTextoTipoElemento(){
		this.textIdTipoDeElemento.setText("");
		this.textNombreTipoElemento.setText("");
		this.textCantMaxPerRes.setText("");
		this.textDiasDeAnticipacion.setText("");
		this.textLimiteHoras.setText("");
	}
	
}