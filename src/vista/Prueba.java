package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import controlador.AlumnoDAO;
import modelo.Alumno;

class VentanaInicio extends JFrame implements ActionListener{
		
		public VentanaInicio() {
			crearComponentes();
		}
		
		JInternalFrame internalFrameAltasAlumnos, internalFrameBajasAlumnos, internalFrameModificacionesAlumnos, 
		internalFrameConsultasAlumnos;
		
		JMenuItem menuAltasAlumnos, menuBajasAlumnos, menuModificacionesAlumnos, menuConsultasAlumnos;
		
		JButton btnAgregarAltas, btnCancelarAltas, btnRestablecerAltas,btnBuscarBajas, btnBorrarBajas, btnRestablecerBajas, 
		btnCancelarBajas, btnEliminarBajas, btnModificar, btnBuscar,btnCancelarModificaciones,btnCancelarConsultas;
		
		JTable tablaAltas, table4, tablaBajas;
		
		JTextField NumControlAltas, nombresAltas, apPatAltas, apMatAltas, numControlBajas;
		
		JRadioButton rbtCarrera,  rbtTodos,  rbtNombre,  rbtApePaterno,  rbtApeMaterno,  rbtNumControl,
		 rbtSemestre;
		
		JComboBox<String> cboCarreraAltas, cboSemestreAltas;
		
		public void crearComponentes() {
			getContentPane().setLayout(new BorderLayout());
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setTitle("ALTAS, BAJAS, CAMBIOS Y CONSULTAS");
			setSize(710, 660);
			setLocationRelativeTo(null);
			setVisible(true);
			
			JDesktopPane pane = new JDesktopPane();
			
			//========================================== MENU PRINCIPAL===============================
			
			JMenuBar menuBar = new JMenuBar();
				JMenu menuPrincipalAlumnos = new JMenu("Alumnos");
				menuAltasAlumnos = new JMenuItem("Altas");
				menuAltasAlumnos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.ALT_MASK));
				menuAltasAlumnos.addActionListener(this);
				menuPrincipalAlumnos.add(menuAltasAlumnos);
				
				menuBajasAlumnos = new JMenuItem("Bajas");
				menuBajasAlumnos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.ALT_MASK));
				menuBajasAlumnos.addActionListener(this);
				menuPrincipalAlumnos.add(menuBajasAlumnos);
				
				menuModificacionesAlumnos = new JMenuItem("Modificaciones");
				menuModificacionesAlumnos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.ALT_MASK));
				menuModificacionesAlumnos.addActionListener(this);
				menuPrincipalAlumnos.add(menuModificacionesAlumnos);
				
				menuConsultasAlumnos = new JMenuItem("Consultas");
				menuConsultasAlumnos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.ALT_MASK));
				menuConsultasAlumnos.addActionListener(this);
				menuPrincipalAlumnos.add(menuConsultasAlumnos);
				
			menuBar.add(menuPrincipalAlumnos);
		setJMenuBar(menuBar);
		
		
		
		//============================== VENTANA ALTAS============================
		internalFrameAltasAlumnos = new JInternalFrame();
		internalFrameAltasAlumnos.setDefaultCloseOperation(HIDE_ON_CLOSE);
		internalFrameAltasAlumnos.setLayout(null);
		internalFrameAltasAlumnos.setSize(700, 595);
		internalFrameAltasAlumnos.setTitle("ALTAS");
		internalFrameAltasAlumnos.setClosable(true);
		internalFrameAltasAlumnos.setIconifiable(true);
		internalFrameAltasAlumnos.setMaximizable(true);
		internalFrameAltasAlumnos.setResizable(true);
		internalFrameAltasAlumnos.setVisible(false);
		
		Font format1 = new Font("Arial", Font.ITALIC, 12);		
		JPanel panelAltasAlumnos = new JPanel();
			panelAltasAlumnos.setBackground(new Color(124, 252, 0));
			panelAltasAlumnos.setLayout(null);
			panelAltasAlumnos.setPreferredSize(new Dimension(700, 190));
			panelAltasAlumnos.setBounds(0, 0, 700, 80);
				
			JLabel altasAlumnos = new JLabel("ALTAS ALUMNOS");
			altasAlumnos.setFont(new Font("Arial", Font.BOLD, 24));
			altasAlumnos.setForeground(new Color(255, 255, 255));
			altasAlumnos.setBounds(30, 30, 400, 20);
			panelAltasAlumnos.add(altasAlumnos);
			
		internalFrameAltasAlumnos.add(panelAltasAlumnos);
		
		Font format2 = new Font("Arial", Font.CENTER_BASELINE, 14);
		JPanel panelAltasAlumnos1 = new JPanel();
			panelAltasAlumnos1 .setLayout(null);
			panelAltasAlumnos1 .setPreferredSize(new Dimension(700, 190));
			panelAltasAlumnos1 .setBounds(0, 80, 700, 330);
				
			JLabel NumControl = new JLabel("NÚMERO DE CONTROL: ");
			NumControl.setFont(format2);
			NumControl.setBounds(100, 30, 400, 25);
			panelAltasAlumnos1 .add(NumControl);
			
			NumControlAltas = new JTextField(10);
			NumControlAltas.setFont(format2);
			NumControlAltas.setBounds(280, 30, 150, 23);
			panelAltasAlumnos1 .add(NumControlAltas);
			
			JLabel lblNombres = new JLabel("NOMBRES:");
			lblNombres.setFont(format2);
			lblNombres.setBounds(100, 70, 300, 25);
			panelAltasAlumnos1 .add(lblNombres);
			
			nombresAltas = new JTextField(10);
			nombresAltas.setFont(format2);
			nombresAltas.setBounds(200, 70, 230, 23);
			panelAltasAlumnos1 .add(nombresAltas);
			
			JLabel lblApePaterno = new JLabel("APELLIDO PATERNO:");
			lblApePaterno.setFont(format2);
			lblApePaterno.setBounds(100, 110, 300, 25);
			panelAltasAlumnos1 .add(lblApePaterno);
			
			apPatAltas = new JTextField(10);
			apPatAltas.setFont(format2);
			apPatAltas.setBounds(255, 110, 176, 23);
			panelAltasAlumnos1 .add(apPatAltas);
			
			JLabel lblApeMaterno = new JLabel("APELLIDO MATERNO:");
			lblApeMaterno.setFont(format2);
			lblApeMaterno.setBounds(100, 150, 300, 25);
			panelAltasAlumnos1 .add(lblApeMaterno);
			
			apMatAltas = new JTextField(10);
			apMatAltas.setFont(format2);
			apMatAltas.setBounds(255, 150, 176, 23);
			panelAltasAlumnos1 .add(apMatAltas);
			
			JLabel lblSemestre = new JLabel("SEMESTRE:");
			lblSemestre.setFont(format2);
			lblSemestre.setBounds(100, 200, 300, 25);
			panelAltasAlumnos1 .add(lblSemestre);
			
			cboSemestreAltas = new JComboBox<String>();
			cboSemestreAltas.addItem("Elige opción...");
			cboSemestreAltas.addItem("1");
			cboSemestreAltas.addItem("2");
			cboSemestreAltas.addItem("3");
			cboSemestreAltas.addItem("4");
			cboSemestreAltas.addItem("5");
			cboSemestreAltas.addItem("6");
			cboSemestreAltas.addItem("7");
			cboSemestreAltas.addItem("8");
			cboSemestreAltas.addItem("9");
			cboSemestreAltas.addItem("10");
			cboSemestreAltas.setFont(format1);
			cboSemestreAltas.setBounds(255, 200, 175, 23);
			panelAltasAlumnos1 .add(cboSemestreAltas);
			
			JLabel lblCarrera = new JLabel("CARRERA:");
			lblCarrera.setFont(format2);
			lblCarrera.setBounds(100, 240, 300, 25);
			panelAltasAlumnos1 .add(lblCarrera);
			
			cboCarreraAltas = new JComboBox<String>();
			cboCarreraAltas.setFont(format1);
			cboCarreraAltas.addItem("Elige opción");
			cboCarreraAltas.addItem("ISC");
			cboCarreraAltas.addItem("IIA");
			cboCarreraAltas.addItem("IM");
			cboCarreraAltas.addItem("LA");
			cboCarreraAltas.addItem("LCP");
			cboCarreraAltas.setBounds(255, 240, 175, 23);
			panelAltasAlumnos1 .add(cboCarreraAltas);
			
			btnAgregarAltas = new JButton("AGREGAR");
			btnAgregarAltas.setFont(format2);
			btnAgregarAltas.setBounds(460, 100, 120, 30);
			btnAgregarAltas.addActionListener(this);
			panelAltasAlumnos1 .add(btnAgregarAltas);
			
			btnCancelarAltas = new JButton("CERRAR");
			btnCancelarAltas.setFont(format2);
			btnCancelarAltas.setBounds(460, 200, 120, 30);
			btnCancelarAltas.addActionListener(this);
			panelAltasAlumnos1 .add(btnCancelarAltas);
			
			btnRestablecerAltas = new JButton("RESTABLECER");
			btnRestablecerAltas.setFont(format2);
			btnRestablecerAltas.setBounds(255, 290, 174, 25);
			btnRestablecerAltas.addActionListener(this);
			panelAltasAlumnos1.add(btnRestablecerAltas);
			
		internalFrameAltasAlumnos.add(panelAltasAlumnos1 );
		
		JPanel panelTabla = new JPanel();
		panelTabla.setLayout(null);
		panelTabla.setPreferredSize(new Dimension(700, 190));
		panelTabla.setBounds(0, 410, 700, 152);
			
			String columnas[] = {"Num Control", "Nombres", "Primer Ap", "Segundo Ap", "Edad", "Semestre",
								"Carrera"};
			String datos[][] = {{"", "", "", "", "", "", ""}, {"", "", "", "", "", "", ""},
								{"", "", "", "", "", "", ""}, {"", "", "", "", "", "", ""},
								{"", "", "", "", "", "", ""}, {"", "", "", "", "", "", ""},
								{"", "", "", "", "", "", ""}, {"", "", "", "", "", "", ""},
								{"", "", "", "", "", "", ""}, {"", "", "", "", "", "", ""}};
			
			tablaAltas = new JTable(datos, columnas);
			JScrollPane scroll = new JScrollPane(tablaAltas);
			scroll.setBounds(5, 9, 678, 135);
			panelTabla.add(scroll);
			
			internalFrameAltasAlumnos.add(panelTabla);
			
			pane.add(internalFrameAltasAlumnos);

		
		//============================= VENTANA BAJAS =================================
		internalFrameBajasAlumnos = new JInternalFrame();
		internalFrameBajasAlumnos.setDefaultCloseOperation(HIDE_ON_CLOSE);
		internalFrameBajasAlumnos.setLayout(null);
		internalFrameBajasAlumnos.setSize(700, 595);
		internalFrameBajasAlumnos.setTitle("BAJAS");
		internalFrameBajasAlumnos.setClosable(true);
		internalFrameBajasAlumnos.setIconifiable(true);
		internalFrameBajasAlumnos.setMaximizable(true);
		internalFrameBajasAlumnos.setResizable(true);
		internalFrameBajasAlumnos.setVisible(false);
		
		JPanel panel4 = new JPanel();
			panel4.setBackground(new Color(255, 0, 0));
			panel4.setLayout(null);
			panel4.setPreferredSize(new Dimension(700, 190));
			panel4.setBounds(0, 0, 700, 80);
			
			JLabel lbl2 = new JLabel("BAJAS ALUMNOS");
			lbl2.setFont(new Font("Arial", Font.BOLD, 24));
			lbl2.setForeground(new Color(255, 255, 255));
			lbl2.setBounds(30, 30, 400, 20);
			panel4.add(lbl2);
			
		internalFrameBajasAlumnos.add(panel4);
		
		JPanel panel5 = new JPanel();
			panel5.setLayout(null);
			panel5.setPreferredSize(new Dimension(700, 190));
			panel5.setBounds(0, 80, 700, 80);
			
			JLabel lblNumControl2 = new JLabel("NÚMERO DE CONTROL:");
			lblNumControl2.setFont(format2);
			lblNumControl2.setBounds(80, 30, 400, 25);
			panel5.add(lblNumControl2);
			
			numControlBajas = new JTextField(10);
			numControlBajas.setFont(format2);
			numControlBajas.setBounds(250, 30, 150, 23);
			panel5.add(numControlBajas);
			
			btnBuscarBajas = new JButton(new ImageIcon("Iconos/Buscar.png"));
			btnBuscarBajas.setBounds(420, 20, 50, 45);
			panel5.add(btnBuscarBajas);
			
			btnBorrarBajas = new JButton("RESTABLECER");
			btnBorrarBajas.setFont(format2);
			btnBorrarBajas.setBounds(510, 25, 140, 25);
			panel5.add(btnBorrarBajas);
			
			JLabel lblLinea = new JLabel("_____________________________________________________________________________");
			lblLinea.setFont(format2);
			lblLinea.setBounds(0, 60, 630, 20);
			panel5.add(lblLinea);
			
		internalFrameBajasAlumnos.add(panel5);
		
		JPanel panel6 = new JPanel();
			panel6.setLayout(null);
			panel6.setPreferredSize(new Dimension(700, 190));
			panel6.setBounds(0, 160, 700, 250);
			
			JLabel lblNombresBajas = new JLabel("NOMBRE(S):");
			lblNombresBajas.setFont(format2);
			lblNombresBajas.setBounds(100, 30, 400, 25);
			panel6.add(lblNombresBajas);
			
			JTextField txtNombres2 = new JTextField(10);
			txtNombres2.setFont(format2);
			txtNombres2.setBounds(280, 30, 176, 23);
			panel6.add(txtNombres2);
			
			JLabel lblApePaterno2 = new JLabel("APELLIDO PATERNO:");
			lblApePaterno2.setFont(format2);
			lblApePaterno2.setBounds(100, 70, 300, 25);
			panel6.add(lblApePaterno2);
			
			JTextField txtApePaterno2 = new JTextField(10);
			txtApePaterno2.setFont(format2);
			txtApePaterno2.setBounds(280, 70, 176, 23);
			panel6.add(txtApePaterno2);
			
			JLabel lblApeMaterno2 = new JLabel("APELLIDO MATERNO:");
			lblApeMaterno2.setFont(format2);
			lblApeMaterno2.setBounds(100, 110, 300, 25);
			panel6.add(lblApeMaterno2);
			
			JTextField txtApeMaterno2 = new JTextField(10);
			txtApeMaterno2.setFont(format2);
			txtApeMaterno2.setBounds(280, 110, 176, 23);
			panel6.add(txtApeMaterno2);
			
			JLabel lblSemestre2 = new JLabel("SEMESTRE:");
			lblSemestre2.setFont(format2);
			lblSemestre2.setBounds(100, 150, 300, 25);
			panel6.add(lblSemestre2);
			
			JSpinner sprSemestre = new JSpinner();
			sprSemestre.setAutoscrolls(true);
			sprSemestre.setBounds(280, 150, 176, 23);
			panel6.add(sprSemestre);
			
			JLabel lblCarrera2 = new JLabel("CARRERA:");
			lblCarrera2.setFont(format2);
			lblCarrera2.setBounds(100, 190, 300, 25);
			panel6.add(lblCarrera2);
			
			JComboBox<String> cboCarrera2 = new JComboBox<String>();
			cboCarrera2.addItem("Elige Carrera...");
			cboCarrera2.addItem("ISC");
			cboCarrera2.addItem("IIA");
			cboCarrera2.addItem("IM");
			cboCarrera2.addItem("LA");
			cboCarrera2.addItem("LCP");
			cboCarrera2.setFont(format1);
			cboCarrera2.setBounds(280, 190, 175, 23);
			panel6.add(cboCarrera2);
			
			btnEliminarBajas = new JButton("ELIMINAR");
			btnEliminarBajas.setFont(format2);
			btnEliminarBajas.setBounds(480, 45, 135, 25);
			btnEliminarBajas.addActionListener(this);
			panel6.add(btnEliminarBajas);
			
			btnRestablecerBajas = new JButton("RESTABLECER");
			btnRestablecerBajas.setFont(format2);
			btnRestablecerBajas.setBounds(480, 170, 135, 25);
			panel6.add(btnRestablecerBajas);
			
			btnCancelarBajas = new JButton("CERRAR");
			btnCancelarBajas.setFont(format2);
			btnCancelarBajas.setBounds(480, 110, 135, 25);
			btnCancelarBajas.addActionListener(this);
			panel6.add(btnCancelarBajas);
			
		internalFrameBajasAlumnos.add(panel6);	
		
		JPanel panel7 = new JPanel();
			panel7.setLayout(null);
			panel7.setPreferredSize(new Dimension(700, 190));
			panel7.setBounds(0, 410, 700, 152);
			
			String columnas2[] = {"Num Control", "Nombres", "Primer Ap", "Segundo Ap", "Edad", "Semestre",
							"Carrera"};
			String datos2[][] = {{"", "", "", "", "", "", ""}, {"", "", "", "", "", "", ""},
							{"", "", "", "", "", "", ""}, {"", "", "", "", "", "", ""},
							{"", "", "", "", "", "", ""}, {"", "", "", "", "", "", ""},
							{"", "", "", "", "", "", ""}, {"", "", "", "", "", "", ""},
							{"", "", "", "", "", "", ""}, {"", "", "", "", "", "", ""}};
		
			tablaBajas = new JTable(datos, columnas);
			JScrollPane scroll2 = new JScrollPane(tablaBajas);
			scroll2.setBounds(5, 9, 678, 135);
		panel7.add(scroll2);
		
		internalFrameBajasAlumnos.add(panel7);
		
		pane.add(internalFrameBajasAlumnos);
		
		//========================== MOFIFICACIONES =================================================================
		internalFrameModificacionesAlumnos = new JInternalFrame();
		internalFrameModificacionesAlumnos.setDefaultCloseOperation(HIDE_ON_CLOSE);
		internalFrameModificacionesAlumnos.setLayout(null);
		internalFrameModificacionesAlumnos.setSize(700, 595);
		internalFrameModificacionesAlumnos.setTitle("MODIFICACIONES");
		internalFrameModificacionesAlumnos.setClosable(true);
		internalFrameModificacionesAlumnos.setIconifiable(true);
		internalFrameModificacionesAlumnos.setMaximizable(true);
		internalFrameModificacionesAlumnos.setResizable(true);
		internalFrameModificacionesAlumnos.setVisible(false);
		
		JPanel panel8 = new JPanel();
			panel8.setBackground(new Color(255, 165, 0));
			panel8.setLayout(null);
			panel8.setPreferredSize(new Dimension(700, 190));
			panel8.setBounds(0, 0, 700, 80);
		
			JLabel lbl3 = new JLabel("MODIFICACIONES ALUMNOS");
			lbl3.setFont(new Font("Arial", Font.BOLD, 24));
			lbl3.setForeground(new Color(255, 255, 255));
			lbl3.setBounds(30, 30, 400, 20);
		panel8.add(lbl3);
		
		internalFrameModificacionesAlumnos.add(panel8);
		
		JPanel panel9 = new JPanel();
			panel9.setLayout(null);
			panel9.setPreferredSize(new Dimension(700, 190));
			panel9.setBounds(0, 80, 700, 80);
		
			JLabel lblNumControl3 = new JLabel("NÚMERO DE CONTROL:");
			lblNumControl3.setFont(format2);
			lblNumControl3.setBounds(80, 30, 400, 25);
			panel9.add(lblNumControl3);
			
			JTextField txtNumControl3 = new JTextField(10);
			txtNumControl3.setFont(format2);
			txtNumControl3.setBounds(250, 30, 150, 23);
			panel9.add(txtNumControl3);
			
			JButton btnBuscar2 = new JButton(new ImageIcon("Iconos/Buscar.png"));
			btnBuscar2.setBounds(420, 20, 50, 45);
			panel9.add(btnBuscar2);
		
			JButton btnBorrar3 = new JButton("RESTABLECER");
			btnBorrar3.setFont(format2);
			btnBorrar3.setBounds(510, 25, 140, 25);
			panel9.add(btnBorrar3);
			
			JLabel lblLinea2 = new JLabel("_____________________________________________________________________________");
			lblLinea2.setFont(format2);
			lblLinea2.setBounds(0, 60, 630, 20);
			panel9.add(lblLinea2);
		
			internalFrameModificacionesAlumnos.add(panel9);
		
		JPanel panel10 = new JPanel();
			panel10.setLayout(null);
			panel10.setPreferredSize(new Dimension(700, 190));
			panel10.setBounds(0, 160, 700, 250);
		
			JLabel lblNombres3 = new JLabel("NOMBRE(S):");
			lblNombres3.setFont(format2);
			lblNombres3.setBounds(100, 30, 400, 25);
			panel10.add(lblNombres3);
			
			JTextField txtNombres3 = new JTextField(10);
			txtNombres3.setFont(format2);
			txtNombres3.setBounds(280, 30, 176, 23);
			panel10.add(txtNombres3);
			
			JLabel lblApePaterno3 = new JLabel("APELLIDO PATERNO:");
			lblApePaterno3.setFont(format2);
			lblApePaterno3.setBounds(100, 70, 300, 25);
			panel10.add(lblApePaterno3);
			
			JTextField txtApePaterno3 = new JTextField(10);
			txtApePaterno3.setFont(format2);
			txtApePaterno3.setBounds(280, 70, 176, 23);
			panel10.add(txtApePaterno3);
			
			JLabel lblApeMaterno3 = new JLabel("APELLIDO MATERNO:");
			lblApeMaterno3.setFont(format2);
			lblApeMaterno3.setBounds(100, 110, 300, 25);
			panel10.add(lblApeMaterno3);
			
			JTextField txtApeMaterno3 = new JTextField(10);
			txtApeMaterno3.setFont(format2);
			txtApeMaterno3.setBounds(280, 110, 176, 23);
			panel10.add(txtApeMaterno3);
			
			JLabel lblSemestre3 = new JLabel("SEMESTRE:");
			lblSemestre3.setFont(format2);
			lblSemestre3.setBounds(100, 150, 300, 25);
			panel10.add(lblSemestre3);
			
			JSpinner sprSemestre2 = new JSpinner();
			sprSemestre2.setAutoscrolls(true);
			sprSemestre2.setBounds(280, 150, 176, 23);
			panel10.add(sprSemestre2);
			
			JLabel lblCarrera3 = new JLabel("CARRERA:");
			lblCarrera3.setFont(format2);
			lblCarrera3.setBounds(100, 190, 300, 25);
			panel10.add(lblCarrera3);
			
			JComboBox<String> cboCarrera3 = new JComboBox<String>();
			cboCarrera3.addItem("Elige Carrera...");
			cboCarrera3.addItem("ISC");
			cboCarrera3.addItem("IIA");
			cboCarrera3.addItem("IM");
			cboCarrera3.addItem("LA");
			cboCarrera3.addItem("LCP");
			cboCarrera3.setFont(format1);
			cboCarrera3.setBounds(280, 190, 175, 23);
			panel10.add(cboCarrera3);
			
			btnModificar = new JButton("MODIFICAR");
			btnModificar.setFont(format2);
			btnModificar.setBounds(480, 45, 135, 25);
			btnModificar.addActionListener(this);
			panel10.add(btnModificar);
			
			JButton btnRestablecer3 = new JButton("RESTABLECER");
			btnRestablecer3.setFont(format2);
			btnRestablecer3.setBounds(480, 170, 135, 25);
			panel10.add(btnRestablecer3);
			
			btnCancelarModificaciones = new JButton("CERRAR");
			btnCancelarModificaciones.setFont(format2);
			btnCancelarModificaciones.setBounds(480, 110, 135, 25);
			btnCancelarModificaciones.addActionListener(this);
			panel10.add(btnCancelarModificaciones);
			
			internalFrameModificacionesAlumnos.add(panel10);
		
		JPanel panel11 = new JPanel();
			panel11.setLayout(null);
			panel11.setPreferredSize(new Dimension(700, 190));
			panel11.setBounds(0, 410, 700, 152);
			
			String columnas3[] = {"Num Control", "Nombres", "Primer Ap", "Segundo Ap", "Edad", "Semestre",
						"Carrera"};
			String datos3[][] = {{"", "", "", "", "", "", ""}, {"", "", "", "", "", "", ""},
						{"", "", "", "", "", "", ""}, {"", "", "", "", "", "", ""},
						{"", "", "", "", "", "", ""}, {"", "", "", "", "", "", ""},
						{"", "", "", "", "", "", ""}, {"", "", "", "", "", "", ""},
						{"", "", "", "", "", "", ""}, {"", "", "", "", "", "", ""}};
			
			JTable table3 = new JTable(datos, columnas);
			JScrollPane scroll3 = new JScrollPane(table3);
			scroll3.setBounds(5, 9, 678, 135);
		panel11.add(scroll3);
	
		internalFrameModificacionesAlumnos.add(panel11);
		
		pane.add(internalFrameModificacionesAlumnos);
			
			
			
		
		
			
			//========================================================================================0
			internalFrameConsultasAlumnos = new JInternalFrame();
			internalFrameConsultasAlumnos.setDefaultCloseOperation(HIDE_ON_CLOSE);
			internalFrameConsultasAlumnos.setLayout(null);
			internalFrameConsultasAlumnos.setSize(700, 595);
			internalFrameConsultasAlumnos.setTitle("CONSULTAS");
			internalFrameConsultasAlumnos.setClosable(true);
			internalFrameConsultasAlumnos.setIconifiable(true);
			internalFrameConsultasAlumnos.setMaximizable(true);
			internalFrameConsultasAlumnos.setResizable(true);
			internalFrameConsultasAlumnos.setVisible(false);
			
			JPanel panel12 = new JPanel();
				panel12.setBackground(new Color(0, 0, 255));
				panel12.setLayout(null);
				panel12.setPreferredSize(new Dimension(700, 190));
				panel12.setBounds(0, 0, 700, 80);
				
				JLabel lbl4 = new JLabel("CONSULTAS ALUMNOS");
				lbl4.setFont(new Font("Arial", Font.BOLD, 24));
				lbl4.setForeground(new Color(255, 255, 255));
				lbl4.setBounds(30, 30, 400, 20);
			
			panel12.add(lbl4);
			
			internalFrameConsultasAlumnos.add(panel12);
			
			JPanel panel13 = new JPanel();
				panel13.setLayout(null);
				panel13.setPreferredSize(new Dimension(700, 190));
				panel13.setBounds(0, 80, 700, 330);
				
				JLabel lblSeleccion = new JLabel("Selecciona criterio de busqueda:");
				lblSeleccion.setFont(format2);
				lblSeleccion.setBounds(10, 15, 300, 25);
				panel13.add(lblSeleccion);
				
				ButtonGroup bg = new ButtonGroup();
				
				rbtTodos = new JRadioButton("Todos");
				bg.add(rbtTodos);
				rbtTodos.setFont(format2);
				rbtTodos.setBounds(20, 70, 80, 25);
				panel13.add(rbtTodos);
				
				rbtNombre = new JRadioButton("NOMBRE:");
				bg.add(rbtNombre);
				rbtNombre.setFont(format2);
				rbtNombre.setBounds(100, 70, 100, 25);
				panel13.add(rbtNombre);
				
				JTextField txtNombres4 = new JTextField(10);
				txtNombres4.setFont(format2);
				txtNombres4.setBounds(280, 70, 176, 23);
				panel13.add(txtNombres4);
				
				rbtApePaterno = new JRadioButton("APELLIDO PATERNO:");
				bg.add(rbtApePaterno);
				rbtApePaterno.setFont(format2);
				rbtApePaterno.setBounds(100, 120, 180, 25);
				panel13.add(rbtApePaterno);
				
				JTextField txtApePaterno4 = new JTextField(10);
				txtApePaterno4.setFont(format2);
				txtApePaterno4.setBounds(280, 120, 176, 23);
				panel13.add(txtApePaterno4);
				
				rbtApeMaterno = new JRadioButton("APELLIDO MATERNO:");
				bg.add(rbtApeMaterno);
				rbtApeMaterno.setFont(format2);
				rbtApeMaterno.setBounds(100, 170, 180, 25);
				panel13.add(rbtApeMaterno);
				
				JTextField txtApeMaterno4 = new JTextField(10);
				txtApeMaterno4.setFont(format2);
				txtApeMaterno4.setBounds(280, 170, 176, 23);
				panel13.add(txtApeMaterno4);
				
				rbtSemestre = new JRadioButton("SEMESTRE:");
				bg.add(rbtSemestre);
				rbtSemestre.setFont(format2);
				rbtSemestre.setBounds(100, 220, 180, 25);
				panel13.add(rbtSemestre);
				
				JSpinner sprSemestre3 = new JSpinner();
				sprSemestre3.setAutoscrolls(true);
				sprSemestre3.setBounds(280, 220, 176, 23);
				panel13.add(sprSemestre3);
				
				rbtCarrera = new JRadioButton("CARRERA:");
				bg.add(rbtCarrera);
				rbtCarrera.setFont(format2);
				rbtCarrera.setBounds(50, 270, 100, 25);
				panel13.add(rbtCarrera);
				
				btnBuscar = new JButton(new ImageIcon("Iconos/Buscar.png"));
				btnBuscar.setBounds(480, 85, 135, 45);
				btnBuscar.addActionListener(this);
				panel13.add(btnBuscar);
				
				JButton btnRestablecer4 = new JButton("RESTABLECER");
				btnRestablecer4.setFont(format2);
				btnRestablecer4.setBounds(480, 170, 135, 35);
				panel13.add(btnRestablecer4);
				
				btnCancelarConsultas = new JButton("CERRAR");
				btnCancelarConsultas.setFont(format2);
				btnCancelarConsultas.setBounds(480, 245, 135, 35);
				btnCancelarConsultas.addActionListener(this);
				panel13.add(btnCancelarConsultas);
				
				internalFrameConsultasAlumnos.add(panel13);
			
			JPanel panel14 = new JPanel();
				panel14.setLayout(null);
				panel14.setPreferredSize(new Dimension(700, 190));
				panel14.setBounds(0, 410, 700, 152);
				
				String columnas4[] = {"Num Control", "Nombres", "Primer Ap", "Segundo Ap", "Edad", "Semestre",
						"Carrera"};
				String datos4[][] = {{"", "", "", "", "", "", ""}, {"", "", "", "", "", "", ""},
						{"", "", "", "", "", "", ""}, {"", "", "", "", "", "", ""},
						{"", "", "", "", "", "", ""}, {"", "", "", "", "", "", ""},
						{"", "", "", "", "", "", ""}, {"", "", "", "", "", "", ""},
						{"", "", "", "", "", "", ""}, {"", "", "", "", "", "", ""}};
				
				table4 = new JTable(datos4, columnas4);
				JScrollPane scroll4 = new JScrollPane(table4);
				scroll4.setBounds(5, 9, 678, 135);
			panel14.add(scroll4);

			internalFrameConsultasAlumnos.add(panel14);
			
			pane.add(internalFrameConsultasAlumnos);
			
			
			
			add(pane, BorderLayout.CENTER);
		}
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==menuAltasAlumnos){
				internalFrameAltasAlumnos.setVisible(true);
				actualizarTabla(tablaAltas);
			}else if(e.getSource()==menuBajasAlumnos){
				internalFrameBajasAlumnos.setVisible(true);
				actualizarTabla(tablaBajas);
			}else if(e.getSource()==menuModificacionesAlumnos){
				internalFrameModificacionesAlumnos.setVisible(true);
			}else if(e.getSource()==menuConsultasAlumnos){
				internalFrameConsultasAlumnos.setVisible(true);
			}
			
			
			if(e.getSource()== btnAgregarAltas) {
				Alumno alumno= new Alumno(NumControlAltas.getText(), nombresAltas.getText(), apPatAltas.getText(),
						apPatAltas.getText(),(byte)20, (byte)5,
						cboCarreraAltas.getSelectedItem().toString());
			
			new AlumnoDAO().AgregarAlumno(alumno);
			actualizarTabla(tablaAltas);
			
				}else if (e.getSource()== btnEliminarBajas) {
				new AlumnoDAO().EliminarAlumno(numControlBajas.getText());
				actualizarTabla(tablaBajas);
				
				}else if (e.getSource()== btnModificar) {
				Alumno alumno= new Alumno(NumControlAltas.getText(), nombresAltas.getText(), apPatAltas.getText(),
						apPatAltas.getText(),(byte)20, (byte)5,
						cboCarreraAltas.getSelectedItem().toString());	
				
				new AlumnoDAO().ActualizarAlumno(alumno);
				
				}else if (e.getSource()==btnBuscar) {
					Alumno alumno= new Alumno(NumControlAltas.getText(), nombresAltas.getText(), apPatAltas.getText(),
							apPatAltas.getText(),(byte)20, (byte)5,
							cboCarreraAltas.getSelectedItem().toString());
					
					//new AlumnoDAO().buscarAlumno("1", alumno);
				}
			
			if (e.getSource()==btnCancelarAltas) {
				internalFrameAltasAlumnos.setVisible(false);
				}else if(e.getSource()==btnCancelarBajas) {
					internalFrameBajasAlumnos.setVisible(false);
				}else if(e.getSource()==btnCancelarModificaciones) {
					internalFrameModificacionesAlumnos.setVisible(false);
				}else if(e.getSource()==btnCancelarConsultas) {
					internalFrameConsultasAlumnos.setVisible(false);
				}
				
}
		
		public void actualizarTabla(JTable tabla) {
			String controlador = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost/BD_Escuela?useTimezone=true&serverTimezone=UTC";
			String consulta = "SELECT * FROM Alumnos";
			ResultSetTableModel modelDatos = null;
			try {
				modelDatos = new ResultSetTableModel(controlador, url, "root", "lacc", consulta);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			tabla.setModel(modelDatos);
		}
}






public class Prueba {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				new VentanaInicio();
			}
		});	

	}

}
