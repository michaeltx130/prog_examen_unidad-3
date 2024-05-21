//Examen unidad 3
//Michelle Obeso y Javier Rojo
//Funcional

package examenU3Funcional;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JMenuItem;

public class Examen {

	private JFrame frame;
	
	String nombreUsuario;
	boolean sesionIniciada;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Examen window = new Examen();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Alumno juan = new Alumno("Juan", "123456", "Juan Alfonso", "Sanchez", "Galarza", "Jua_23@gmail.com", 1234567, 10,12,2005, "Bachillerato");
	Docente alonso = new Docente("Lic_Al1980", "Al_1980_22", "Alonso", "Piñas", "Cuevas", "Lic_Al19@gmail.com", 5550100, 22,9,1980, "Licenciatura");
	
	public Examen() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 650, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.login(frame);
	}
	
	public void login(JFrame frame) {
	
		JLabel panel = new JLabel(new ImageIcon(getClass().getResource("blue.png")));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(161, 85, 320, 285);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JTextField textField = new JTextField();
		textField.setBackground(new Color(255, 255, 255));
		textField.setBounds(39, 139, 238, 20);
		textField.setBorder(null);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(39, 191, 238, 20);
		passwordField.setBorder(null);
		panel_1.add(passwordField);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 0));
		panel_2.setBounds(39, 158, 238, 2);
		panel_1.add(panel_2);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.BLACK);
		panel_2_1.setBounds(39, 210, 238, 2);
		panel_1.add(panel_2_1);
		
		JLabel lblNewLabel = new JLabel("Iniciar sesión");
		lblNewLabel.setBackground(new Color(0, 0, 128));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(10, 11, 114, 27);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
		panel.add(lblNewLabel);
	
		JLabel person2 = new JLabel(new ImageIcon(getClass().getResource("personA.png")));
		person2.setLocation(120, 25);
		person2.setSize(75, 75);
		panel_1.add(person2);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(39, 117, 109, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Contraseña");
		lblNewLabel_1_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(39, 170, 109, 14);
		panel_1.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnNewButton.setBounds(120, 237, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean userState = false, passState = false;
				
				if(textField.getText().length() <= 0 && textField.getText() != juan.usuario || textField.getText().length() <= 0 && textField.getText() != alonso.usuario) {
					panel_2.setBackground(Color.red);
				} else if(textField.getText().length() > 0 && textField.getText().equals(juan.usuario) || textField.getText().length() > 0 && textField.getText().equals(alonso.usuario)) {
					panel_2.setBackground(new Color(0, 0, 0));
					userState = true;
				}
				
				String contrasenia = new String(passwordField.getPassword());
				
				if (contrasenia.length() <= 0 && contrasenia != juan.contrasena || contrasenia.length() <= 0 && contrasenia != alonso.contrasena) {
					panel_2_1.setBackground(Color.red);
				} else if (contrasenia.length() > 0 && contrasenia.equals(juan.contrasena) || contrasenia.length() > 0 && contrasenia.equals(alonso.contrasena)){
					panel_2_1.setBackground(new Color(0, 0, 0));
					passState = true;
				}
				
				if(passState && userState) {
					nombreUsuario = textField.getText();
					sesionIniciada = true;
					JOptionPane.showMessageDialog(null, "Se ha iniciado sesion con exito, bienvenido "+nombreUsuario+"!");
					frame.getContentPane().removeAll();
					frame.getContentPane().repaint();
					frame.getContentPane().revalidate();
					
					PanelAlumnos(frame);
				} else{
					panel_2.setBackground(Color.red);
					panel_2_1.setBackground(Color.red);
					JOptionPane.showMessageDialog(null, "Usuario/Datos erroneos, vuelva a intentarlo", "Error #01EH24", 0);
					panel_2.setBackground(new Color(0, 0, 0));
					panel_2_1.setBackground(new Color(0, 0, 0));
				}
				
			}
			
		});
		panel_1.add(btnNewButton);
	}

	private void PanelAlumnos(JFrame frame) {
		JMenuBar barra = new JMenuBar();
		frame.setJMenuBar(barra);
		
		JMenu menu = new JMenu("Opciones");
		ImageIcon iconOpciones = new ImageIcon(getClass().getResource("opciones.png"));
		menu.setIcon(new ImageIcon(iconOpciones.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH)));
		
		ImageIcon imgAlumno = new ImageIcon(getClass().getResource("alumno.png"));
		JMenuItem eleccion = new JMenuItem("Creditos", new ImageIcon(imgAlumno.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH)));
		eleccion.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Hecho por los alumnos: \n\nMichelle Jesus Obeso Sanchez\nJesus Javier Rojo Martinez\n\n IDS Turno vespertino", "titulo", 1);
				JOptionPane.showMessageDialog(null, "Docente: Prof. Jonathan Giovanni Soto Muñoz"+ "", "titulo", 1);
			}
			
		});
		menu.add(eleccion);
		
		ImageIcon imgEliminar2 = new ImageIcon(getClass().getResource("cerrar-sesion.png"));
		JMenuItem eleccion1 = new JMenuItem("Cerrar sesión", new ImageIcon(imgEliminar2.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH)));
		eleccion1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(sesionIniciada) {
					
					int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea cerrar sesion?");
					
					if(respuesta == JOptionPane.YES_OPTION) {
						nombreUsuario = "Usuario";
						sesionIniciada = false;
						JOptionPane.showMessageDialog(null, "Se ha cerrado sesion con exito, adios!");
						frame.getContentPane().removeAll();
						frame.getContentPane().repaint();
						frame.getContentPane().revalidate();
						barra.setVisible(false);
						barra.setEnabled(false);
						
						login(frame);
					}
					
				} else {
					JOptionPane.showMessageDialog(null, "No se puede cerrar sesion, porque no se ha iniciado sesion");
				}
			}
			
		});
		menu.add(eleccion1);

		JMenu regresar = new JMenu("Regresar"); 
		ImageIcon iconRegresar = new ImageIcon(getClass().getResource("anterior.png"));
		regresar.setEnabled(false);
		regresar.setVisible(false);
		regresar.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().repaint();
				frame.getContentPane().revalidate();
				
				regresar.setEnabled(false);
				regresar.setVisible(false);
				
				PanelAlumnos(frame);
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			
		});
		regresar.setIcon(new ImageIcon(iconRegresar.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH))); 
		
		barra.add(regresar);
		barra.add(menu);
		barra.updateUI();
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#1e88e5"));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel = new JLabel("Bienvenido "+nombreUsuario+"!");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);

		ImageIcon imgdescargar = new ImageIcon(getClass().getResource("descargar.png"));
		ImageIcon imgdescargarSelect = new ImageIcon(getClass().getResource("descargarSelect.png"));
		ImageIcon imgConsultar = new ImageIcon(getClass().getResource("consultar.png"));
		ImageIcon imgConsultarSelect = new ImageIcon(getClass().getResource("consultarSelect.png"));
		ImageIcon imgCrear = new ImageIcon(getClass().getResource("crear.png"));
		ImageIcon imgCrearSelect = new ImageIcon(getClass().getResource("crearSelect.png"));
		ImageIcon imgEditar = new ImageIcon(getClass().getResource("editar.png"));
		ImageIcon imgEditarSelect = new ImageIcon(getClass().getResource("editarSelect.png"));
		ImageIcon imgEliminar = new ImageIcon(getClass().getResource("eliminar.png"));
		ImageIcon imgEliminarSelect = new ImageIcon(getClass().getResource("eliminarSelect.png"));

		JButton descargarbtn = new JButton();
		descargarbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Descarga de información completa.", "Descargar información", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		descargarbtn.setContentAreaFilled(false);
		descargarbtn.setBorderPainted(false);
		descargarbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		descargarbtn.setBounds(60, 24, 135, 135);
		descargarbtn.setIcon(new ImageIcon(imgdescargar.getImage().getScaledInstance(descargarbtn.getWidth(), descargarbtn.getHeight(), Image.SCALE_SMOOTH)));
		descargarbtn.setRolloverIcon(new ImageIcon(imgdescargarSelect.getImage().getScaledInstance(descargarbtn.getWidth(), descargarbtn.getHeight(), Image.SCALE_SMOOTH)));
		panel_1.add(descargarbtn);

		JButton consultarbtn = new JButton();
		consultarbtn.setContentAreaFilled(false);
		consultarbtn.setBorderPainted(false);
		consultarbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		consultarbtn.setBounds(250, 24, 135, 135);
		consultarbtn.setIcon(new ImageIcon(imgConsultar.getImage().getScaledInstance(consultarbtn.getWidth(), consultarbtn.getHeight(), Image.SCALE_SMOOTH)));
		consultarbtn.setRolloverIcon(new ImageIcon(imgConsultarSelect.getImage().getScaledInstance(consultarbtn.getWidth(), consultarbtn.getHeight(), Image.SCALE_SMOOTH)));
		consultarbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().repaint();
				frame.getContentPane().revalidate();
				
				regresar.setEnabled(true);
				regresar.setVisible(true);
				
				if(nombreUsuario.equals("Lic_Al1980")) {
					ConsultarMaestro(frame);
				}else {
					ConsultarAlumno(frame);
				}
				
			}
		});
		panel_1.add(consultarbtn);

		JButton crearBtn = new JButton();
		crearBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea crear otro perfil Alumno?", "Crear", JOptionPane.INFORMATION_MESSAGE);
				if(respuesta == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, "Se ha creado otro perfil Alumno.", "Crear", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		crearBtn.setBorderPainted(false);
		crearBtn.setContentAreaFilled(false);
		crearBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		crearBtn.setBounds(440, 24, 135, 135);
		crearBtn.setIcon(new ImageIcon(imgCrear.getImage().getScaledInstance(crearBtn.getWidth(), crearBtn.getHeight(), Image.SCALE_SMOOTH)));
		crearBtn.setRolloverIcon(new ImageIcon(imgCrearSelect.getImage().getScaledInstance(crearBtn.getWidth(), crearBtn.getHeight(), Image.SCALE_SMOOTH)));
		panel_1.add(crearBtn);

		JButton editarBtn = new JButton();
		editarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().repaint();
				frame.getContentPane().revalidate();
				
				regresar.setEnabled(true);
				regresar.setVisible(true);
				
				if(nombreUsuario.equals("Lic_Al1980")) {
					editarMaestro(frame);
				}else {
					editarAlumno(frame);
				}
				
			}
		});
		
		editarBtn.setContentAreaFilled(false);
		editarBtn.setBorderPainted(false);
		editarBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		editarBtn.setBounds(146, 212, 135, 135);
		editarBtn.setIcon(new ImageIcon(imgEditar.getImage().getScaledInstance(editarBtn.getWidth(), editarBtn.getHeight(), Image.SCALE_SMOOTH)));
		editarBtn.setRolloverIcon(new ImageIcon(imgEditarSelect.getImage().getScaledInstance(editarBtn.getWidth(), editarBtn.getHeight(), Image.SCALE_SMOOTH)));
		panel_1.add(editarBtn);

		JButton eliminarBtn = new JButton("");
		eliminarBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int respuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro de querer eliminar este perfíl?.", "Eliminar", JOptionPane.INFORMATION_MESSAGE);
				
				if(respuesta ==  JOptionPane.YES_OPTION) {
					frame.getContentPane().removeAll();
					frame.getContentPane().repaint();
					frame.getContentPane().revalidate();
	
				}
			}
		});
		eliminarBtn.setContentAreaFilled(false);
		eliminarBtn.setBorderPainted(false);
		eliminarBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		eliminarBtn.setBounds(351, 212, 135, 135);
		eliminarBtn.setIcon(new ImageIcon(imgEliminar.getImage().getScaledInstance(eliminarBtn.getWidth(), eliminarBtn.getHeight(), Image.SCALE_SMOOTH)));
		eliminarBtn.setRolloverIcon(new ImageIcon(imgEliminarSelect.getImage().getScaledInstance(eliminarBtn.getWidth(), eliminarBtn.getHeight(), Image.SCALE_SMOOTH)));
		panel_1.add(eliminarBtn);

		JLabel descargarLabel = new JLabel("Descargar Información");
		descargarLabel.setHorizontalAlignment(SwingConstants.CENTER);
		descargarLabel.setBounds(60, 169, 135, 14);
		panel_1.add(descargarLabel);
		
		JLabel consultarLabel = new JLabel("Consultar");
		consultarLabel.setHorizontalAlignment(SwingConstants.CENTER);
		consultarLabel.setBounds(250, 169, 135, 14);
		panel_1.add(consultarLabel);
		
		JLabel crearLabel = new JLabel("Crear");
		crearLabel.setHorizontalAlignment(SwingConstants.CENTER);
		crearLabel.setBounds(440, 170, 135, 14);
		panel_1.add(crearLabel);
		
		JLabel editarLabel = new JLabel("Editar");
		editarLabel.setHorizontalAlignment(SwingConstants.CENTER);
		editarLabel.setBounds(146, 358, 135, 14);
		panel_1.add(editarLabel);
		
		JLabel eliminarLabel = new JLabel("Eliminar");
		eliminarLabel.setHorizontalAlignment(SwingConstants.CENTER);
		eliminarLabel.setBounds(351, 358, 135, 14);
		panel_1.add(eliminarLabel);
		
		JPanel panelSouth = new JPanel();
		panelSouth.setBackground(Color.decode("#1e88e5"));
		frame.getContentPane().add(panelSouth, BorderLayout.SOUTH);
	}
	
	private void ConsultarAlumno(JFrame frame) {
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#1e88e5"));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel titulo = new JLabel("    Consulta de alumno");
		titulo.setForeground(new Color(255, 255, 255));
		titulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(titulo, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.decode("#1e88e5"));
		panel_6.setBounds(395, 11, 216, 273);
		panel_2.add(panel_6);
		panel_6.setLayout(new BorderLayout());
		
		JLabel lblNewLabel_2 = new JLabel("   Fotografía del alumno");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_6.add(lblNewLabel_2, BorderLayout.NORTH);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(new Color(151, 203, 255));
		panel_6.add(panel_7, BorderLayout.CENTER);
		
		ImageIcon imgUsuario = new ImageIcon(getClass().getResource("fotoEstudiante.png"));
		JLabel img_user = new JLabel();
		img_user.setBounds(12, 11, 192, 223);
		img_user.setIcon(new ImageIcon(imgUsuario.getImage().getScaledInstance(img_user.getWidth(), img_user.getHeight(), Image.SCALE_SMOOTH)));
		panel_7.add(img_user);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.decode("#1e88e5"));
		panel_2_1.setBounds(23, 11, 341, 273);
		panel_2.add(panel_2_1);
		panel_2_1.setLayout(new BorderLayout());
		
		JLabel lblNewLabel_1 = new JLabel("   Datos generales");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_2_1.add(lblNewLabel_1, BorderLayout.NORTH);
		
		JPanel panel_3 = new JPanel();
		panel_2_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(151, 203, 255));
		
		JLabel nombre_etiqueta = new JLabel("Nombres:");
		nombre_etiqueta.setBounds(15, 25, 56, 14);
		panel_3.add(nombre_etiqueta);
		
		JTextField textField = new JTextField(juan.Nombres);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(136, 22, 136, 20);
		panel_3.add(textField);
		
		JLabel ap_etiqueta = new JLabel("Apellido Paterno:");
		ap_etiqueta.setBounds(15, 62, 100, 14);
		panel_3.add(ap_etiqueta);
		
		JTextField textField_1 = new JTextField(juan.apellidoP);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(136, 59, 136, 20);
		panel_3.add(textField_1);
		
		JLabel am_etiqueta = new JLabel("Apellido Materno:");
		am_etiqueta.setBounds(15, 99, 100, 14);
		panel_3.add(am_etiqueta);
		
		JTextField textField_2 = new JTextField(juan.apellidoM);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(136, 96, 136, 20);
		panel_3.add(textField_2);
		
		JLabel fecha_etiqueta = new JLabel("Fecha Nacimiento:");
		fecha_etiqueta.setBounds(15, 136, 105, 14);
		panel_3.add(fecha_etiqueta);
		
		JLabel genero_etiqueta = new JLabel("Correo electrónico:");
		genero_etiqueta.setBounds(15, 173, 116, 14);
		panel_3.add(genero_etiqueta);
		
		JLabel nacionalidad_etiqueta = new JLabel("Teléfono: ");
		nacionalidad_etiqueta.setBounds(15, 210, 76, 14);
		panel_3.add(nacionalidad_etiqueta);
		
		JTextField textField_3 = new JTextField(juan.Correo);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(136, 170, 136, 20);
		panel_3.add(textField_3);
		
		JTextField textField_4 = new JTextField(""+juan.Teléfono);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(156, 207, 116, 20);
		panel_3.add(textField_4);
		
		JTextField textField_10 = new JTextField(juan.dia+"/"+juan.mes+"/"+juan.anio);
		textField_10.setEditable(false);
		textField_10.setBounds(136, 133, 136, 20);
		panel_3.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel nacionalidad_etiqueta_1 = new JLabel("612");
		nacionalidad_etiqueta_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		nacionalidad_etiqueta_1.setBounds(136, 210, 76, 14);
		panel_3.add(nacionalidad_etiqueta_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.decode("#1e88e5"));
		panel_4.setBounds(23, 295, 590, 114);
		panel_2.add(panel_4);
		panel_4.setLayout(new BorderLayout());
		
		JLabel lblNewLabel_3 = new JLabel("   Escolaridad");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_4.add(lblNewLabel_3, BorderLayout.NORTH);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(151, 203, 255));
		panel_4.add(panel_5, BorderLayout.CENTER);
		
		JLabel descripcion_etiqueta = new JLabel("Nivel Educativo:");
		descripcion_etiqueta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		descripcion_etiqueta.setBounds(23, 21, 106, 14);
		panel_5.add(descripcion_etiqueta);
		
		JLabel preferencias_etiqueta = new JLabel("N° Control:");
		preferencias_etiqueta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		preferencias_etiqueta.setBounds(22, 58, 77, 14);
		panel_5.add(preferencias_etiqueta);
		
		JTextField textField_5 = new JTextField(juan.nivelEstudios);
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(137, 19, 136, 20);
		panel_5.add(textField_5);
		
		JTextField textField_6 = new JTextField("2023097811");
		textField_6.setColumns(10);
		textField_6.setEditable(false);
		textField_6.setBounds(137, 56, 136, 20);
		panel_5.add(textField_6);
		
		JLabel descripcion_etiqueta_1 = new JLabel("Semestre:");
		descripcion_etiqueta_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		descripcion_etiqueta_1.setBounds(301, 22, 77, 14);
		panel_5.add(descripcion_etiqueta_1);
		
		JTextField txtto = new JTextField();
		txtto.setText("5to");
		txtto.setEditable(false);
		txtto.setColumns(10);
		txtto.setBounds(372, 19, 50, 20);
		panel_5.add(txtto);
		
		JLabel descripcion_etiqueta_1_1 = new JLabel("Grupo:");
		descripcion_etiqueta_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		descripcion_etiqueta_1_1.setBounds(448, 21, 50, 14);
		panel_5.add(descripcion_etiqueta_1_1);
		
		JTextField txtA = new JTextField();
		txtA.setEditable(false);
		txtA.setText("A");
		txtA.setColumns(10);
		txtA.setBounds(508, 19, 50, 20);
		panel_5.add(txtA);
		
		JLabel descripcion_etiqueta_2 = new JLabel("Carrera:");
		descripcion_etiqueta_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		descripcion_etiqueta_2.setBounds(302, 58, 62, 14);
		panel_5.add(descripcion_etiqueta_2);
		
		JTextField txtArquitectura = new JTextField();
		txtArquitectura.setEditable(false);
		txtArquitectura.setText("Arquitectura");
		txtArquitectura.setColumns(10);
		txtArquitectura.setBounds(372, 56, 186, 20);
		panel_5.add(txtArquitectura);
		
		
	}
	
	private void ConsultarMaestro(JFrame frame) {
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#1e88e5"));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel titulo = new JLabel("    Consulta de docente");
		titulo.setForeground(new Color(255, 255, 255));
		titulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(titulo, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.decode("#1e88e5"));
		panel_6.setBounds(395, 11, 216, 273);
		panel_2.add(panel_6);
		panel_6.setLayout(new BorderLayout());
		
		JLabel lblNewLabel_2 = new JLabel("   Fotografía del docente");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_6.add(lblNewLabel_2, BorderLayout.NORTH);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(new Color(151, 203, 255));
		panel_6.add(panel_7, BorderLayout.CENTER);
		
		ImageIcon imgUsuario = new ImageIcon(getClass().getResource("maestro.png"));
		JLabel img_user = new JLabel();
		img_user.setBounds(10, 11, 196, 220);
		img_user.setIcon(new ImageIcon(imgUsuario.getImage().getScaledInstance(img_user.getWidth(), img_user.getHeight(), Image.SCALE_SMOOTH)));
		panel_7.add(img_user);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.decode("#1e88e5"));
		panel_2_1.setBounds(23, 11, 341, 273);
		panel_2.add(panel_2_1);
		panel_2_1.setLayout(new BorderLayout());
		
		JLabel lblNewLabel_1 = new JLabel("   Datos generales");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_2_1.add(lblNewLabel_1, BorderLayout.NORTH);
		
		JPanel panel_3 = new JPanel();
		panel_2_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(151, 203, 255));
		
		JLabel nombre_etiqueta = new JLabel("Nombres:");
		nombre_etiqueta.setBounds(15, 25, 56, 14);
		panel_3.add(nombre_etiqueta);
		
		JTextField textField = new JTextField(alonso.Nombres);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(136, 22, 136, 20);
		textField.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if(!Character.isLetter(c) && !Character.isSpaceChar(c)) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		panel_3.add(textField);
		
		JLabel ap_etiqueta = new JLabel("Apellido Paterno:");
		ap_etiqueta.setBounds(15, 62, 100, 14);
		panel_3.add(ap_etiqueta);
		
		JTextField textField_1 = new JTextField(alonso.apellidoP);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(136, 59, 136, 20);
		textField_1.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if(!Character.isLetter(c)) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		panel_3.add(textField_1);
		
		JLabel am_etiqueta = new JLabel("Apellido Materno:");
		am_etiqueta.setBounds(15, 99, 100, 14);
		panel_3.add(am_etiqueta);
		
		JTextField textField_2 = new JTextField(alonso.apellidoM);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(136, 96, 136, 20);
		textField_2.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if(!Character.isLetter(c)) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		panel_3.add(textField_2);
		
		JLabel fecha_etiqueta = new JLabel("Fecha Nacimiento:");
		fecha_etiqueta.setBounds(15, 136, 105, 14);
		panel_3.add(fecha_etiqueta);
		
		JLabel genero_etiqueta = new JLabel("Correo electrónico:");
		genero_etiqueta.setBounds(15, 173, 116, 14);
		panel_3.add(genero_etiqueta);
		
		JLabel nacionalidad_etiqueta = new JLabel("Teléfono: ");
		nacionalidad_etiqueta.setBounds(15, 210, 76, 14);
		panel_3.add(nacionalidad_etiqueta);
		
		JTextField textField_3 = new JTextField(alonso.Correo);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(136, 170, 136, 20);
		panel_3.add(textField_3);
		
		JTextField textField_4 = new JTextField(""+alonso.Teléfono);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(156, 207, 116, 20);
		textField_4.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if(!Character.isDigit(c)) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		panel_3.add(textField_4);
		
		JTextField textField_10 = new JTextField(alonso.dia+"/"+alonso.mes+"/"+alonso.anio);
		textField_10.setEditable(false);
		textField_10.setBounds(136, 133, 136, 20);
		panel_3.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel nacionalidad_etiqueta_1 = new JLabel("612");
		nacionalidad_etiqueta_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		nacionalidad_etiqueta_1.setBounds(136, 210, 76, 14);
		panel_3.add(nacionalidad_etiqueta_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.decode("#1e88e5"));
		panel_4.setBounds(23, 295, 590, 114);
		panel_2.add(panel_4);
		panel_4.setLayout(new BorderLayout());
		
		JLabel lblNewLabel_3 = new JLabel("   Escolaridad");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_4.add(lblNewLabel_3, BorderLayout.NORTH);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(151, 203, 255));
		panel_4.add(panel_5, BorderLayout.CENTER);
		
		JLabel descripcion_etiqueta = new JLabel("Nivel Educativo:");
		descripcion_etiqueta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		descripcion_etiqueta.setBounds(23, 21, 106, 14);
		panel_5.add(descripcion_etiqueta);
		
		JLabel preferencias_etiqueta = new JLabel("C° Maestro:");
		preferencias_etiqueta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		preferencias_etiqueta.setBounds(22, 58, 107, 14);
		panel_5.add(preferencias_etiqueta);
		
		JTextField textField_5 = new JTextField(alonso.nivelEstudios);
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(137, 19, 136, 20);
		panel_5.add(textField_5);
		
		JTextField textField_6 = new JTextField();
		textField_6.setText("18446579");
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(137, 56, 136, 20);
		panel_5.add(textField_6);
		
		JLabel descripcion_etiqueta_1 = new JLabel("Materia:");
		descripcion_etiqueta_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		descripcion_etiqueta_1.setBounds(301, 22, 77, 14);
		panel_5.add(descripcion_etiqueta_1);
		
		JTextField txtDiseoDeInteriores = new JTextField();
		txtDiseoDeInteriores.setText("Diseño de interiores");
		txtDiseoDeInteriores.setEditable(false);
		txtDiseoDeInteriores.setColumns(10);
		txtDiseoDeInteriores.setBounds(372, 19, 186, 20);
		panel_5.add(txtDiseoDeInteriores);
		
		JLabel descripcion_etiqueta_2 = new JLabel("Carrera:");
		descripcion_etiqueta_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		descripcion_etiqueta_2.setBounds(302, 58, 62, 14);
		panel_5.add(descripcion_etiqueta_2);
		
		JTextField txtArquitectura_2 = new JTextField();
		txtArquitectura_2.setText("Arquitectura");
		txtArquitectura_2.setEditable(false);
		txtArquitectura_2.setColumns(10);
		txtArquitectura_2.setBounds(372, 56, 186, 20);
		panel_5.add(txtArquitectura_2);
		
		
	}
	
	public void editarAlumno(JFrame frame) {
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#1e88e5"));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel titulo = new JLabel("    Edición de información del alumno");
		titulo.setForeground(new Color(255, 255, 255));
		titulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(titulo, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.decode("#1e88e5"));
		panel_6.setBounds(395, 11, 216, 273);
		panel_2.add(panel_6);
		panel_6.setLayout(new BorderLayout());
		
		JLabel lblNewLabel_2 = new JLabel("   Fotografía del alumno");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_6.add(lblNewLabel_2, BorderLayout.NORTH);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(new Color(151, 203, 255));
		panel_6.add(panel_7, BorderLayout.CENTER);
		
		ImageIcon imgUsuario = new ImageIcon(getClass().getResource("fotoEstudiante.png"));
		JLabel img_user = new JLabel();
		img_user.setBounds(32, 11, 147, 167);
		img_user.setIcon(new ImageIcon(imgUsuario.getImage().getScaledInstance(img_user.getWidth(), img_user.getHeight(), Image.SCALE_SMOOTH)));
		panel_7.add(img_user);
		
		ImageIcon imgEliminar = new ImageIcon(getClass().getResource("borrar.png"));
		ImageIcon imgEliminarSelect = new ImageIcon(getClass().getResource("borrarSelect.png"));
		JButton borrarBtn = new JButton();
		borrarBtn.setContentAreaFilled(false);
		borrarBtn.setBorderPainted(false);
		borrarBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		borrarBtn.setBounds(131, 180, 59, 42);
		borrarBtn.setIcon(new ImageIcon(imgEliminar.getImage().getScaledInstance(borrarBtn.getWidth(), borrarBtn.getHeight(), Image.SCALE_SMOOTH)));
		borrarBtn.setRolloverIcon(new ImageIcon(imgEliminarSelect.getImage().getScaledInstance(borrarBtn.getWidth(), borrarBtn.getHeight(), Image.SCALE_SMOOTH)));
		panel_7.add(borrarBtn);
		
		
		ImageIcon imgEditar = new ImageIcon(getClass().getResource("cambiarFoto.png"));
		ImageIcon imgEditarSelect = new ImageIcon(getClass().getResource("cambiarFotoSelect.png"));
		JButton editarBtn = new JButton();
		editarBtn.setContentAreaFilled(false);
		editarBtn.setBorderPainted(false);
		editarBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		editarBtn.setBounds(20, 180, 59, 50);
		editarBtn.setIcon(new ImageIcon(imgEditar.getImage().getScaledInstance(editarBtn.getWidth(), editarBtn.getHeight(), Image.SCALE_SMOOTH)));
		editarBtn.setRolloverIcon(new ImageIcon(imgEditarSelect.getImage().getScaledInstance(editarBtn.getWidth(), editarBtn.getHeight(), Image.SCALE_SMOOTH)));
		panel_7.add(editarBtn);
		
		JLabel lblNewLabel_4 = new JLabel("Cambiar foto");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(10, 222, 76, 14);
		panel_7.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Borrar foto");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setBounds(121, 222, 76, 14);
		panel_7.add(lblNewLabel_4_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.decode("#1e88e5"));
		panel_2_1.setBounds(23, 11, 341, 273);
		panel_2.add(panel_2_1);
		panel_2_1.setLayout(new BorderLayout());
		
		JLabel lblNewLabel_1 = new JLabel("   Datos generales");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_2_1.add(lblNewLabel_1, BorderLayout.NORTH);
		
		JPanel panel_3 = new JPanel();
		panel_2_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(151, 203, 255));
		
		JLabel nombre_etiqueta = new JLabel("Nombres:");
		nombre_etiqueta.setBounds(15, 25, 56, 14);
		panel_3.add(nombre_etiqueta);
		
		JTextField textField = new JTextField(juan.Nombres);
		textField.setColumns(10);
		textField.setBounds(136, 22, 136, 20);
		textField.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if(!Character.isLetter(c) && !Character.isSpaceChar(c)) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		panel_3.add(textField);
		
		JLabel ap_etiqueta = new JLabel("Apellido Paterno:");
		ap_etiqueta.setBounds(15, 62, 100, 14);
		panel_3.add(ap_etiqueta);
		
		JTextField textField_1 = new JTextField(juan.apellidoP);
		textField_1.setColumns(10);
		textField_1.setBounds(136, 59, 136, 20);
		textField_1.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if(!Character.isLetter(c) && !Character.isSpaceChar(c)) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		panel_3.add(textField_1);
		
		JLabel am_etiqueta = new JLabel("Apellido Materno:");
		am_etiqueta.setBounds(15, 99, 100, 14);
		panel_3.add(am_etiqueta);
		
		JTextField textField_2 = new JTextField(juan.apellidoM);
		textField_2.setColumns(10);
		textField_2.setBounds(136, 96, 136, 20);
		textField_2.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if(!Character.isLetter(c) && !Character.isSpaceChar(c)) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		panel_3.add(textField_2);
		
		JLabel fecha_etiqueta = new JLabel("Fecha Nacimiento:");
		fecha_etiqueta.setBounds(15, 136, 105, 14);
		panel_3.add(fecha_etiqueta);
		
		JLabel genero_etiqueta = new JLabel("Correo electrónico:");
		genero_etiqueta.setBounds(15, 173, 116, 14);
		panel_3.add(genero_etiqueta);
		
		JLabel nacionalidad_etiqueta = new JLabel("Teléfono: ");
		nacionalidad_etiqueta.setBounds(15, 210, 76, 14);
		panel_3.add(nacionalidad_etiqueta);
		
		JTextField textField_3 = new JTextField(juan.Correo);
		textField_3.setColumns(10);
		textField_3.setBounds(136, 170, 136, 20);
		textField_3.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if(Character.isSpaceChar(c)) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		panel_3.add(textField_3);
		
		JTextField textField_4 = new JTextField(""+juan.Teléfono);
		textField_4.setColumns(10);
		textField_4.setBounds(156, 207, 116, 20);
		textField_4.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if(!Character.isDigit(c)) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		panel_3.add(textField_4);
		
		JTextField textField_10 = new JTextField(juan.dia+"/"+juan.mes+"/"+juan.anio);
		textField_10.setEditable(false);
		textField_10.setBounds(136, 133, 136, 20);
		panel_3.add(textField_10);
		textField_10.setColumns(10);
		
		ImageIcon imgGuardar = new ImageIcon(getClass().getResource("guardar.png"));
		ImageIcon imgGuardarSelected = new ImageIcon(getClass().getResource("guardarSelected.png"));
		JButton guardarbtn = new JButton();
		guardarbtn.setContentAreaFilled(false);
		guardarbtn.setBorderPainted(false);
		guardarbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		guardarbtn.setBounds(301, 216, 30, 30);
		guardarbtn.setIcon(new ImageIcon(imgGuardar.getImage().getScaledInstance(guardarbtn.getWidth(), guardarbtn.getHeight(), Image.SCALE_SMOOTH)));
		guardarbtn.setRolloverIcon(new ImageIcon(imgGuardarSelected.getImage().getScaledInstance(guardarbtn.getWidth(), guardarbtn.getHeight(), Image.SCALE_SMOOTH)));
		guardarbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea guardar los cambios?");
				if(respuesta == JOptionPane.YES_OPTION) {
					juan.setNombres(textField.getText());
					juan.setApellidoP(textField_1.getText());
					juan.setApellidoM(textField_2.getText());
					juan.setCorreo(textField_3.getText());
					juan.setTeléfono(Long.parseLong(textField_4.getText()));
					JOptionPane.showMessageDialog(null, "Los datos se han guardado con exito.");
					textField.setEditable(false);
					textField_1.setEditable(false);
					textField_2.setEditable(false);
					textField_3.setEditable(false);
					textField_4.setEditable(false);
					
					frame.getContentPane().removeAll();
					frame.getContentPane().repaint();
					frame.getContentPane().revalidate();
					
					PanelAlumnos(frame);
				} else if(respuesta == JOptionPane.CANCEL_OPTION) {
					JOptionPane.showMessageDialog(null, "Los datos no se han guardado.");
					textField.setText(juan.Nombres);
					textField_1.setText(juan.apellidoP);
					textField_2.setText(juan.apellidoM);
					textField_3.setText(juan.Correo);
					textField_4.setText(""+juan.Teléfono);
				}
				
			}
			
		});
		panel_3.add(guardarbtn);
		
		JLabel nacionalidad_etiqueta_1 = new JLabel("612");
		nacionalidad_etiqueta_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		nacionalidad_etiqueta_1.setBounds(136, 210, 76, 14);
		panel_3.add(nacionalidad_etiqueta_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.decode("#1e88e5"));
		panel_4.setBounds(23, 295, 590, 114);
		panel_2.add(panel_4);
		panel_4.setLayout(new BorderLayout());
		
		JLabel lblNewLabel_3 = new JLabel("   Escolaridad");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_4.add(lblNewLabel_3, BorderLayout.NORTH);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(151, 203, 255));
		panel_4.add(panel_5, BorderLayout.CENTER);
		
		JLabel descripcion_etiqueta = new JLabel("Nivel Educativo:");
		descripcion_etiqueta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		descripcion_etiqueta.setBounds(23, 21, 106, 14);
		panel_5.add(descripcion_etiqueta);
		
		JLabel preferencias_etiqueta = new JLabel("N° Matrícula:");
		preferencias_etiqueta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		preferencias_etiqueta.setBounds(22, 58, 77, 14);
		panel_5.add(preferencias_etiqueta);
		
		JTextField textField_5 = new JTextField(juan.nivelEstudios);
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(137, 19, 136, 20);
		panel_5.add(textField_5);
		
		JTextField textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setText("2023097811");
		textField_6.setColumns(10);
		textField_6.setBounds(137, 56, 136, 20);
		panel_5.add(textField_6);
		
		JLabel descripcion_etiqueta_1 = new JLabel("Semestre:");
		descripcion_etiqueta_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		descripcion_etiqueta_1.setBounds(301, 22, 77, 14);
		panel_5.add(descripcion_etiqueta_1);
		
		JTextField txtto_1 = new JTextField();
		txtto_1.setEditable(false);
		txtto_1.setText("5to");
		txtto_1.setColumns(10);
		txtto_1.setBounds(372, 19, 50, 20);
		panel_5.add(txtto_1);
		
		JLabel descripcion_etiqueta_1_1 = new JLabel("Grupo:");
		descripcion_etiqueta_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		descripcion_etiqueta_1_1.setBounds(448, 21, 50, 14);
		panel_5.add(descripcion_etiqueta_1_1);
		
		JTextField txtA_1 = new JTextField();
		txtA_1.setEditable(false);
		txtA_1.setText("A");
		txtA_1.setColumns(10);
		txtA_1.setBounds(508, 19, 50, 20);
		panel_5.add(txtA_1);
		
		JLabel descripcion_etiqueta_2 = new JLabel("Carrera:");
		descripcion_etiqueta_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		descripcion_etiqueta_2.setBounds(302, 58, 62, 14);
		panel_5.add(descripcion_etiqueta_2);
		
		JTextField txtArquitectura_1 = new JTextField();
		txtArquitectura_1.setEditable(false);
		txtArquitectura_1.setText("Arquitectura");
		txtArquitectura_1.setColumns(10);
		txtArquitectura_1.setBounds(372, 56, 186, 20);
		panel_5.add(txtArquitectura_1);
		
		
	
	}
	
	public void editarMaestro(JFrame frame) {
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#1e88e5"));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel titulo = new JLabel("    Edición de información del docente");
		titulo.setForeground(new Color(255, 255, 255));
		titulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(titulo, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.decode("#1e88e5"));
		panel_6.setBounds(395, 11, 216, 273);
		panel_2.add(panel_6);
		panel_6.setLayout(new BorderLayout());
		
		JLabel lblNewLabel_2 = new JLabel("   Fotografía del docente");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_6.add(lblNewLabel_2, BorderLayout.NORTH);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(new Color(151, 203, 255));
		panel_6.add(panel_7, BorderLayout.CENTER);
		
		ImageIcon imgUsuario = new ImageIcon(getClass().getResource("maestro.png"));
		
		JLabel img_user = new JLabel();
		img_user.setBounds(32, 11, 147, 167);
		img_user.setIcon(new ImageIcon(imgUsuario.getImage().getScaledInstance(img_user.getWidth(), img_user.getHeight(), Image.SCALE_SMOOTH)));
		panel_7.add(img_user);
		
		ImageIcon imgEliminar = new ImageIcon(getClass().getResource("borrar.png"));
		ImageIcon imgEliminarSelect = new ImageIcon(getClass().getResource("borrarSelect.png"));
		JButton borrarBtn = new JButton();
		borrarBtn.setContentAreaFilled(false);
		borrarBtn.setBorderPainted(false);
		borrarBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		borrarBtn.setBounds(131, 180, 59, 42);
		borrarBtn.setIcon(new ImageIcon(imgEliminar.getImage().getScaledInstance(borrarBtn.getWidth(), borrarBtn.getHeight(), Image.SCALE_SMOOTH)));
		borrarBtn.setRolloverIcon(new ImageIcon(imgEliminarSelect.getImage().getScaledInstance(borrarBtn.getWidth(), borrarBtn.getHeight(), Image.SCALE_SMOOTH)));
		panel_7.add(borrarBtn);
		
		ImageIcon imgEditar = new ImageIcon(getClass().getResource("cambiarFoto.png"));
		ImageIcon imgEditarSelect = new ImageIcon(getClass().getResource("cambiarFotoSelect.png"));
		JButton editarBtn = new JButton();
		editarBtn.setContentAreaFilled(false);
		editarBtn.setBorderPainted(false);
		editarBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		editarBtn.setBounds(20, 180, 59, 50);
		editarBtn.setIcon(new ImageIcon(imgEditar.getImage().getScaledInstance(editarBtn.getWidth(), editarBtn.getHeight(), Image.SCALE_SMOOTH)));
		editarBtn.setRolloverIcon(new ImageIcon(imgEditarSelect.getImage().getScaledInstance(editarBtn.getWidth(), editarBtn.getHeight(), Image.SCALE_SMOOTH)));
		panel_7.add(editarBtn);
		
		JLabel lblNewLabel_4 = new JLabel("Cambiar foto");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(10, 222, 76, 14);
		panel_7.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Borrar foto");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setBounds(121, 222, 76, 14);
		panel_7.add(lblNewLabel_4_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.decode("#1e88e5"));
		panel_2_1.setBounds(23, 11, 341, 273);
		panel_2.add(panel_2_1);
		panel_2_1.setLayout(new BorderLayout());
		
		JLabel lblNewLabel_1 = new JLabel("   Datos generales");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_2_1.add(lblNewLabel_1, BorderLayout.NORTH);
		
		JPanel panel_3 = new JPanel();
		panel_2_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(151, 203, 255));
		
		JLabel nombre_etiqueta = new JLabel("Nombres:");
		nombre_etiqueta.setBounds(15, 25, 56, 14);
		panel_3.add(nombre_etiqueta);
		
		JTextField textField = new JTextField(alonso.Nombres);
		textField.setColumns(10);
		textField.setBounds(136, 22, 136, 20);
		textField.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if(!Character.isLetter(c) && !Character.isSpaceChar(c)) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		panel_3.add(textField);
		
		JLabel ap_etiqueta = new JLabel("Apellido Paterno:");
		ap_etiqueta.setBounds(15, 62, 100, 14);
		panel_3.add(ap_etiqueta);
		
		JTextField textField_1 = new JTextField(alonso.apellidoP);
		textField_1.setColumns(10);
		textField_1.setBounds(136, 59, 136, 20);
		textField_1.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if(!Character.isLetter(c) && !Character.isSpaceChar(c)) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		panel_3.add(textField_1);
		
		JLabel am_etiqueta = new JLabel("Apellido Materno:");
		am_etiqueta.setBounds(15, 99, 100, 14);
		panel_3.add(am_etiqueta);
		
		JTextField textField_2 = new JTextField(alonso.apellidoM);
		textField_2.setColumns(10);
		textField_2.setBounds(136, 96, 136, 20);
		textField_2.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if(!Character.isLetter(c) && !Character.isSpaceChar(c)) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		panel_3.add(textField_2);
		
		JLabel fecha_etiqueta = new JLabel("Fecha Nacimiento:");
		fecha_etiqueta.setBounds(15, 136, 105, 14);
		panel_3.add(fecha_etiqueta);
		
		JLabel genero_etiqueta = new JLabel("Correo electrónico:");
		genero_etiqueta.setBounds(15, 173, 116, 14);
		panel_3.add(genero_etiqueta);
		
		JLabel nacionalidad_etiqueta = new JLabel("Teléfono: ");
		nacionalidad_etiqueta.setBounds(15, 210, 76, 14);
		panel_3.add(nacionalidad_etiqueta);
		
		JTextField textField_3 = new JTextField(alonso.Correo);
		textField_3.setColumns(10);
		textField_3.setBounds(136, 170, 136, 20);
		textField_3.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if(Character.isSpaceChar(c)) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		panel_3.add(textField_3);
		
		JTextField textField_4 = new JTextField(""+alonso.Teléfono);
		textField_4.setColumns(10);
		textField_4.setBounds(156, 207, 116, 20);
		textField_4.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if(!Character.isDigit(c)) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		panel_3.add(textField_4);
		
		JTextField textField_10 = new JTextField(alonso.dia+"/"+alonso.mes+"/"+alonso.anio);
		textField_10.setEditable(false);
		textField_10.setBounds(136, 133, 136, 20);
		panel_3.add(textField_10);
		textField_10.setColumns(10);
		
		ImageIcon imgGuardar = new ImageIcon(getClass().getResource("guardar.png"));
		ImageIcon imgGuardarSelected = new ImageIcon(getClass().getResource("guardarSelected.png"));
		JButton guardarbtn = new JButton();
		guardarbtn.setContentAreaFilled(false);
		guardarbtn.setBorderPainted(false);
		guardarbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		guardarbtn.setBounds(301, 216, 30, 30);
		guardarbtn.setIcon(new ImageIcon(imgGuardar.getImage().getScaledInstance(guardarbtn.getWidth(), guardarbtn.getHeight(), Image.SCALE_SMOOTH)));
		guardarbtn.setRolloverIcon(new ImageIcon(imgGuardarSelected.getImage().getScaledInstance(guardarbtn.getWidth(), guardarbtn.getHeight(), Image.SCALE_SMOOTH)));
		guardarbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea guardar los cambios?");
				if(respuesta == JOptionPane.YES_OPTION) {
					alonso.setNombres(textField.getText());
					alonso.setApellidoP(textField_1.getText());
					alonso.setApellidoM(textField_2.getText());
					alonso.setCorreo(textField_3.getText());
					alonso.setTeléfono(Long.parseLong(textField_4.getText()));
					JOptionPane.showMessageDialog(null, "Los datos se han guardado con exito.");
					textField.setEditable(false);
					textField_1.setEditable(false);
					textField_2.setEditable(false);
					textField_3.setEditable(false);
					textField_4.setEditable(false);
					
					frame.getContentPane().removeAll();
					frame.getContentPane().repaint();
					frame.getContentPane().revalidate();
					
					PanelAlumnos(frame);
				} else if(respuesta == JOptionPane.CANCEL_OPTION) {
					JOptionPane.showMessageDialog(null, "Los datos no se han guardado.");
					textField.setText(alonso.Nombres);
					textField_1.setText(alonso.apellidoP);
					textField_2.setText(alonso.apellidoM);
					textField_3.setText(alonso.Correo);
					textField_4.setText(""+alonso.Teléfono);
				}
				
			}
			
		});
		panel_3.add(guardarbtn);
		
		JLabel nacionalidad_etiqueta_1 = new JLabel("612");
		nacionalidad_etiqueta_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		nacionalidad_etiqueta_1.setBounds(136, 210, 76, 14);
		panel_3.add(nacionalidad_etiqueta_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.decode("#1e88e5"));
		panel_4.setBounds(23, 295, 590, 114);
		panel_2.add(panel_4);
		panel_4.setLayout(new BorderLayout());
		
		JLabel lblNewLabel_3 = new JLabel("   Escolaridad");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_4.add(lblNewLabel_3, BorderLayout.NORTH);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(151, 203, 255));
		panel_4.add(panel_5, BorderLayout.CENTER);
		
		JLabel descripcion_etiqueta = new JLabel("Nivel Educativo:");
		descripcion_etiqueta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		descripcion_etiqueta.setBounds(23, 21, 106, 14);
		panel_5.add(descripcion_etiqueta);
		
		JLabel preferencias_etiqueta = new JLabel("C° Maestro:");
		preferencias_etiqueta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		preferencias_etiqueta.setBounds(22, 58, 77, 14);
		panel_5.add(preferencias_etiqueta);
		
		JTextField textField_5 = new JTextField(alonso.nivelEstudios);
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(137, 19, 136, 20);
		panel_5.add(textField_5);
		
		JTextField textField_6 = new JTextField();
		textField_6.setText("18446579");
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(137, 56, 136, 20);
		panel_5.add(textField_6);
		
		JLabel descripcion_etiqueta_1 = new JLabel("Materia:");
		descripcion_etiqueta_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		descripcion_etiqueta_1.setBounds(301, 22, 77, 14);
		panel_5.add(descripcion_etiqueta_1);
		
		JTextField txtDiseoDeInteriores_1 = new JTextField();
		txtDiseoDeInteriores_1.setText("Diseño de interiores");
		txtDiseoDeInteriores_1.setEditable(false);
		txtDiseoDeInteriores_1.setColumns(10);
		txtDiseoDeInteriores_1.setBounds(372, 19, 186, 20);
		panel_5.add(txtDiseoDeInteriores_1);
		
		JLabel descripcion_etiqueta_2 = new JLabel("Carrera:");
		descripcion_etiqueta_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		descripcion_etiqueta_2.setBounds(302, 58, 62, 14);
		panel_5.add(descripcion_etiqueta_2);
		
		JTextField txtArquitectura_3 = new JTextField();
		txtArquitectura_3.setText("Arquitectura");
		txtArquitectura_3.setEditable(false);
		txtArquitectura_3.setColumns(10);
		txtArquitectura_3.setBounds(372, 56, 186, 20);
		panel_5.add(txtArquitectura_3);
		
		
	
	}
}
