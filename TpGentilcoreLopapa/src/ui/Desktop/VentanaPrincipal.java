package ui.Desktop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Panel;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Button;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.GridBagLayout;
import java.awt.MouseInfo;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textUsuario;
	private JTextField textContrasenia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setTitle("Sistema de gesti\u00F3n de reservas");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/ui/Desktop/cropped-3w2-web-dominios-hosting.png")));
	//	setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 450);
		


		
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			//@Override
			
			int x,y;
			public void mouseDragged(MouseEvent e) {
				 Point point = MouseInfo.getPointerInfo().getLocation() ; 
				setLocation(point.x - x, point.y - y)  ;
			}
		});
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		setContentPane(contentPane);
	/*	
		JLabel lblSistemaDeGestin = new JLabel("  SISTEMA DE GESTI\u00D3N DE RESERVAS");
		lblSistemaDeGestin.addMouseListener(new MouseAdapter() {
			
			int x,y; 
			
		//	@Override
			public void lblSistemaDeGestinmousePressed(MouseEvent evt) {

				   x = evt.getX   ()  ; 
				   y = evt.getY   ()  ; 
			}		
			public void mouseDragged(MouseEvent e) {
				 Point point = MouseInfo.getPointerInfo().getLocation() ; 
				setLocation(point.x - x, point.y - y)  ;
			}
		});
		

		lblSistemaDeGestin.setBounds(0, 1, 742, 31);
		lblSistemaDeGestin.setForeground(Color.DARK_GRAY);
		lblSistemaDeGestin.setBackground(Color.WHITE);
		lblSistemaDeGestin.setOpaque(true);
		lblSistemaDeGestin.setFont(new Font("Calibri", Font.PLAIN, 12));
		contentPane.add(lblSistemaDeGestin);
*/
		/*
		//BOTONES DE MINIMAR Y CERRAR (EN CASO DE QUERER CAMBIAR EL DISEÑ
		Button button_Cerrar = new Button("X");
		button_Cerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0); 
			}
		});
		button_Cerrar.setForeground(Color.BLACK);
		button_Cerrar.setBounds(772, 1, 28, 31);
		contentPane.add(button_Cerrar);
O)
		Button button_Minimizar = new Button("-");
		button_Minimizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setExtendedState(ICONIFIED); 

			}
		});
		button_Minimizar.setBounds(740, 1, 28, 31);
		contentPane.add(button_Minimizar);
		*/
/*		JLabel lblCerrar = new JLabel("X");
		lblCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Esta seguro que desea Cerrar?", "Saliendo", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
					System.exit(0);
					}
			}
		});
		lblCerrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrar.setForeground(new Color(153, 51, 51));
		lblCerrar.setBounds(770, 0, 28, 32);
		lblCerrar.setBackground(Color.WHITE);
		lblCerrar.setOpaque(true);
		lblCerrar.setFont(new Font("Calibri", Font.PLAIN, 12));
		contentPane.add(lblCerrar);
		
		JLabel labMinimizar = new JLabel("-");
		labMinimizar.setFont(new Font("Calibri", Font.PLAIN, 12));
		labMinimizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setExtendedState(ICONIFIED); 
			}
		});
		labMinimizar.setHorizontalAlignment(SwingConstants.CENTER);
		labMinimizar.setForeground(new Color(153, 51, 51));
		labMinimizar.setBounds(742, 0, 28, 32);
		labMinimizar.setBackground(Color.WHITE);
		labMinimizar.setOpaque(true);

		contentPane.add(labMinimizar);
		
		
		labMinimizar.setFocusable(false)  ; 
		lblCerrar.setFocusable(false)  ; 
		lblSistemaDeGestin.setFocusable(false)  ;
	*/	
		JLabel lblContrasenia = new JLabel("Contrase\u00F1a");
		lblContrasenia.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasenia.setForeground(Color.WHITE);
		lblContrasenia.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		textUsuario = new JTextField();
		textUsuario.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblInicioSesion = new JLabel("Iniciar sesi\u00F3n");
		lblInicioSesion.setHorizontalAlignment(SwingConstants.CENTER);
		lblInicioSesion.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblInicioSesion.setForeground(Color.WHITE);
		
		textContrasenia = new JTextField();
		textContrasenia.setColumns(10);
		
		JLabel lblIngresar = new JLabel("Ingresar");
		lblIngresar.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresar.setFont(new Font("Calibri", Font.BOLD, 14));
		lblIngresar.setForeground(Color.WHITE);
		
		JLabel lblIcono = new JLabel("");
		lblIcono.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/ui/Desktop/ic_person_white_24dp_2x.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(349)
							.addComponent(lblUsuario, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(214)
							.addComponent(textUsuario, GroupLayout.PREFERRED_SIZE, 348, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(349)
							.addComponent(lblContrasenia, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(215)
							.addComponent(textContrasenia, GroupLayout.PREFERRED_SIZE, 347, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(490)
							.addComponent(lblIngresar, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(362)
							.addComponent(lblIcono))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(296)
							.addComponent(lblInicioSesion, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(220, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addComponent(lblIcono)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblInicioSesion, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(42)
					.addComponent(lblUsuario, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(16)
					.addComponent(textUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addComponent(lblContrasenia, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(textContrasenia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(51)
					.addComponent(lblIngresar, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
	//	button_Minimizar.setFocusable(false)  ; 
	//	button_Cerrar.setFocusable(false) ; 

		
		
		
		
		
	}/*
    public static class FrameDragListener extends MouseAdapter {

        private final JFrame frame;
        private Point mouseDownCompCoords = null;

        public FrameDragListener(JFrame frame) {
            this.frame = frame;
        }

        public void mouseReleased(MouseEvent e) {
            mouseDownCompCoords = null;
        }

        public void mousePressed(MouseEvent e) {
            mouseDownCompCoords = e.getPoint();
        }

        public void mouseDragged(MouseEvent e) {
            Point currCoords = e.getLocationOnScreen();
            frame.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
        }
    }*/
}
