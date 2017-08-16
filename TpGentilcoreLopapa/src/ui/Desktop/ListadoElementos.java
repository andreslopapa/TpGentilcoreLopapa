package ui.Desktop;


import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;


import business.entities.Elemento;
import business.logic.CtrlElementoLogic;


import java.util.*;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.BeanProperty;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

public class ListadoElementos extends JInternalFrame {
	/**
	 * @wbp.nonvisual location=127,137
	 */
	private CtrlElementoLogic elementoLogic;
	private ArrayList<Elemento> elementos=null;
	private JTable table;
	private JTextField txtIndice;
	private final int FilasTabla=30;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ListadoElementos frame = new ListadoElementos();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public ListadoElementos() {
		
	
		elementoLogic=new CtrlElementoLogic();
		setBounds(100, 100, 528, 444);
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setResizingAllowed(false);
		table.getTableHeader().setReorderingAllowed(false) ;
		scrollPane.setViewportView(table);
		
		JButton btnAnterior = new JButton("",new ImageIcon(ListadoElementos.class.getResource("/ui/Desktop/flechaizquierda.png")));
		
		JButton btnSiguiente = new JButton("");
		btnSiguiente.setIcon(new ImageIcon(ListadoElementos.class.getResource("/ui/Desktop/flechaderecha.png")));
		
		txtIndice = new JTextField();
		txtIndice.setText("1");
		txtIndice.setColumns(10);
		txtIndice.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblIndice = new JLabel("de xxx");
		getContentPane().setLayout(new MigLayout("", "[100%][100%][][50:50:50,center][][][][100%][100%]", "[][95%][5%,baseline]"));
		getContentPane().add(txtIndice, "cell 3 2,alignx right,aligny center");
		getContentPane().add(lblIndice, "cell 5 2,alignx left,aligny center");
		getContentPane().add(btnAnterior, "cell 1 2,alignx right,aligny center");
		getContentPane().add(btnSiguiente, "cell 7 2,alignx left,aligny center");
		getContentPane().add(scrollPane, "cell 1 1 7 1,grow");
		
		try{
			this.elementos=elementoLogic.getSome(0,FilasTabla);
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		initDataBindings();

	}
	protected void initDataBindings() {
		JTableBinding<Elemento, List<Elemento>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, elementos, table);
		//
		BeanProperty<Elemento, Integer> elementoBeanProperty = BeanProperty.create("id_elemento");
		jTableBinding.addColumnBinding(elementoBeanProperty).setColumnName("ID Elemento");
		//
		BeanProperty<Elemento, String> elementoBeanProperty_1 = BeanProperty.create("nombre");
		jTableBinding.addColumnBinding(elementoBeanProperty_1).setColumnName("Nombre");
		//
		BeanProperty<Elemento, String> elementoBeanProperty_2 = BeanProperty.create("tipo.nombre");
		jTableBinding.addColumnBinding(elementoBeanProperty_2).setColumnName("Tipo de elemento");
		//
		jTableBinding.setEditable(false);
		
		
	
		jTableBinding.bind();
		
	}
}
