package ui.Desktop;

import java.awt.EventQueue;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.SpinnerDateModel;

import business.entities.Persona;
import business.logic.CtrlPersonaLogic;
import org.jdesktop.beansbinding.ObjectProperty;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.BeanProperty;
import javax.swing.JScrollBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import net.miginfocom.swing.MigLayout;

public class ListadoPersona extends JInternalFrame {
	private JTable tablePersonas;
	
	private ArrayList<Persona> pers;// = new ArrayList<>();
	private CtrlPersonaLogic ctrlPer = new CtrlPersonaLogic();
	private static ABMCPersona formPer;

	private JDesktopPane desktopPane;

	
	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListadoPersona frame = new ListadoPersona();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public ListadoPersona() {
		setBorder(null);											
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null); //estas dos ultimas lineas quitan bordes y titulo
		getContentPane().setBackground(Color.WHITE);

		
		setBounds(100, 100, 788, 464);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBackground(Color.WHITE);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setIgnoreRepaint(true);
		desktopPane.setForeground(Color.WHITE);
		desktopPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		tablePersonas = new JTable();
		scrollPane_1.setViewportView(tablePersonas);
		getContentPane().setLayout(new MigLayout("", "[][461.00px][][175px][39.00]", "[79.00][][321.00px,bottom]"));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 51, 102));
		
		JLabel lblIcono = new JLabel("");
		lblIcono.setIcon(new ImageIcon(ListadoPersona.class.getResource("/ui/Desktop/ic_person_white_24dp_2x.png")));
		panel.add(lblIcono);
		getContentPane().add(panel, "cell 0 0 1 3,grow");
		getContentPane().add(scrollPane_1, "cell 1 2,grow");
		getContentPane().add(desktopPane, "cell 2 2 3 1,grow");
		
		
		
		abrirABMCReserva();

		cargarListaPersona();
		initDataBindings();

	}
	
	public void abrirABMCReserva(){
		try {
			formPer = new ABMCPersona();
			desktopPane.removeAll();
			desktopPane.add(formPer);
			formPer.setVisible(true);
			formPer.setMaximum(true);						
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al intentar ingresar la ventana interna de Persona\n"+e.getMessage());
		}
		
	}
	

	
	protected ArrayList<Persona> cargarListaPersona(){
		try {
			pers= this.ctrlPer.getAll();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,e.getMessage(),"Error al cargar Personas",JOptionPane.ERROR_MESSAGE);
		}
		return pers;
	}
	
	protected void initDataBindings() {
		JTableBinding<Persona, List<Persona>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, pers, tablePersonas);
		//
		BeanProperty<Persona, Integer> personaBeanProperty = BeanProperty.create("id");
		jTableBinding.addColumnBinding(personaBeanProperty).setColumnName("ID");
		//
		BeanProperty<Persona, String> personaBeanProperty_1 = BeanProperty.create("dni");
		jTableBinding.addColumnBinding(personaBeanProperty_1).setColumnName("DNI");
		//
		BeanProperty<Persona, String> personaBeanProperty_2 = BeanProperty.create("apellido");
		jTableBinding.addColumnBinding(personaBeanProperty_2).setColumnName("Apellido");
		//
		BeanProperty<Persona, String> personaBeanProperty_3 = BeanProperty.create("nombre");
		jTableBinding.addColumnBinding(personaBeanProperty_3).setColumnName("Nombre");
		//
		BeanProperty<Persona, String> personaBeanProperty_4 = BeanProperty.create("email");
		jTableBinding.addColumnBinding(personaBeanProperty_4).setColumnName("Email");
		//
		BeanProperty<Persona, String> personaBeanProperty_5 = BeanProperty.create("usuario");
		jTableBinding.addColumnBinding(personaBeanProperty_5).setColumnName("Usuario");
		//
		BeanProperty<Persona, String> personaBeanProperty_6 = BeanProperty.create("contrasenia");
		jTableBinding.addColumnBinding(personaBeanProperty_6).setColumnName("Contrase\u00F1a");
		//
		BeanProperty<Persona, String> personaBeanProperty_7 = BeanProperty.create("categoria.descripcion");
		jTableBinding.addColumnBinding(personaBeanProperty_7).setColumnName("Categoria");
		//
		BeanProperty<Persona, Boolean> personaBeanProperty_8 = BeanProperty.create("habilitado");
		jTableBinding.addColumnBinding(personaBeanProperty_8).setColumnName("Habilitado");
		//
		jTableBinding.bind();
	}
}