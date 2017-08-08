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

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;

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
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 450);
		

		int x; 
		int y;
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				 Point point = MouseInfo.getPointerInfo().getLocation() ; 
				setLocation(point.x - x, point.y - y)  ;
			}
		});
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSistemaDeGestin = new JLabel("  SISTEMA DE GESTI\u00D3N DE RESERVAS");
		lblSistemaDeGestin.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent evt) {
				   x = evt.getX   ()  ; 
				   y = evt.getY   ()  ; 
			}
			

			
			
		});
		lblSistemaDeGestin.setBounds(0, 1, 742, 31);
		lblSistemaDeGestin.setForeground(Color.WHITE);
		lblSistemaDeGestin.setBackground(new Color(0, 51, 102));
		lblSistemaDeGestin.setOpaque(true);
		lblSistemaDeGestin.setFont(new Font("Calibri", Font.PLAIN, 12));
		contentPane.add(lblSistemaDeGestin);
		
		Button button_Cerrar = new Button("X");
		button_Cerrar.setForeground(Color.BLACK);
		button_Cerrar.setBounds(772, 1, 28, 31);
		contentPane.add(button_Cerrar);
		
		Button button_Minimizar = new Button("-");
		button_Minimizar.setBounds(740, 1, 28, 31);
		contentPane.add(button_Minimizar);
		
		JLabel lblCerrar = new JLabel("X");
		lblCerrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrar.setForeground(Color.WHITE);
		lblCerrar.setBounds(772, 38, 28, 31);
		lblCerrar.setBackground(new Color(0, 51, 102));
		lblCerrar.setOpaque(true);
		lblCerrar.setFont(new Font("Calibri", Font.PLAIN, 12));
		contentPane.add(lblCerrar);
		
		JLabel labMinimizar = new JLabel("-");
		labMinimizar.setHorizontalAlignment(SwingConstants.CENTER);
		labMinimizar.setForeground(Color.WHITE);
		labMinimizar.setBounds(740, 38, 28, 31);
		labMinimizar.setBackground(new Color(0, 51, 102));
		labMinimizar.setOpaque(true);

		contentPane.add(labMinimizar);
		
		
		labMinimizar.setFocusable(false)  ; 
		lblCerrar.setFocusable(false)  ; 
		lblSistemaDeGestin.setFocusable(false)  ; 
		button_Minimizar.setFocusable(false)  ; 
		button_Cerrar.setFocusable(false) ; 
		
		//para arrastrarlo en la compu
		int x, y;
		
		
		
		
		
	}
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
    }
}
