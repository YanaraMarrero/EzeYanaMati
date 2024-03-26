package grafica;

import logica.*;

import java.awt.*;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class FrmPrincipal extends JFrame {

	private JPanel contentPane;
	private JComboBox cmbPerfiles;
	private JPanel panel_Foto;
	private JTextPane txtFechas;
	private JTextPane txtNacionalidad;
	private JTextPane txtOcupacion;
	private JLabel lblFoto;
	private JButton btnPromedio;
	private JComboBox cmbNacionalidad;
	private String nacionalidad = "";
	ImagenDAO iDAO = new ImagenDAO();
	PerfilDAO pDAO = new PerfilDAO();
	private JTextPane txtLogros;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmPrincipal() {

		setResizable(true);
		setTitle("Si:");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 0, 128));

		cmbPerfiles = new JComboBox();
		cmbPerfiles.setBackground(new Color(255, 255, 128));
		cmbPerfiles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String perfilSeleccionado = (String) cmbPerfiles.getSelectedItem();
				if (perfilSeleccionado != null) {
					switch (perfilSeleccionado) {
					case "Ada Lovelace":
						mostrarImagen("1");
						mostrarDatos("1");
						break;
					case "Barbara Thoens":
						mostrarImagen("2");
						mostrarDatos("2");
						break;
					case "Betty Snyder Holberton":
						mostrarImagen("3");
						mostrarDatos("3");
						break;
					case "Carol Shaw":
						mostrarImagen("4");
						mostrarDatos("4");
						break;
					case "Erna Schneider Hoover":
						mostrarImagen("5");
						mostrarDatos("5");
						break;
					case "Evelyn Berezin":
						mostrarImagen("6");
						mostrarDatos("6");
						break;
					case "Frances E. Allen":
						mostrarImagen("7");
						mostrarDatos("7");
						break;
					case "Grace Murray Hopper":
						mostrarImagen("8");
						mostrarDatos("8");
						break;
					case "Hedy Lemarr":
						mostrarImagen("9");
						mostrarDatos("9");
						break;
					case "Jean Bartik":
						mostrarImagen("10");
						mostrarDatos("10");
						break;
					case "Jean E. Sammet":
						mostrarImagen("11");
						mostrarDatos("11");
						break;
					case "Joan Clarke":
						mostrarImagen("12");
						mostrarDatos("12");
						break;
					case "Joanna Rutkowska":
						mostrarImagen("13");
						mostrarDatos("13");
						break;
					case "Jude Milhon":
						mostrarImagen("14");
						mostrarDatos("14");
						break;
					case "Karen Spärck Jones":
						mostrarImagen("15");
						mostrarDatos("15");
						break;
					case "Kathleen McNulty Mauchly Anton":
						mostrarImagen("16");
						mostrarDatos("16");
						break;
					case "Lynn Conway":
						mostrarImagen("17");
						mostrarDatos("17");
						break;
					case "Margaret Hamilton":
						mostrarImagen("18");
						mostrarDatos("18");
						break;
					case "Marlyn Wescoff Meltze":
						mostrarImagen("19");
						mostrarDatos("19");
						break;
					case "Radia Perlman":
						mostrarImagen("20");
						mostrarDatos("20");
						break;
					case "Rózsa Péter":
						mostrarImagen("21");
						mostrarDatos("21");
						break;
					case "Ruth Lichterman Teitelbaum":
						mostrarImagen("22");
						mostrarDatos("22");
						break;
					case "Gertrude Blanch":
						mostrarImagen("23");
						mostrarDatos("23");
						break;
					default:
						limpiarImagen();
						limpiarDatos();
					}
				}
			}
		});

		btnPromedio = new JButton("Promedio de edades");
		btnPromedio.setForeground(Color.BLACK);
		btnPromedio.setBackground(new Color(255, 0, 255));
		btnPromedio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, pDAO.getPromedioEdades(nacionalidad), "Promedio de edades ",
						JOptionPane.PLAIN_MESSAGE);
			}
		});

		cmbNacionalidad = new JComboBox();
		cmbNacionalidad.setBackground(new Color(255, 255, 128));
		cmbNacionalidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nacionalidadSeleccionado = (String) cmbNacionalidad.getSelectedItem();
				if (nacionalidadSeleccionado != null) {
					switch (nacionalidadSeleccionado) {
					case "Estadounidense":
						nacionalidad = "Estadounidense";
						break;
					case "Británica":
						nacionalidad = "Británica";
						break;
					case "Austro Estadounidense":
						nacionalidad = "Austro Estadounidense";
						break;
					case "Alemana":
						nacionalidad = "Alemana";
						break;
					case "Polaca":
						nacionalidad = "Polaca";
						break;
					case "Húngara":
						nacionalidad = "Húngara";
						break;
					}
				}
			}
		});
		contentPane.setLayout(new BorderLayout(0, 0));
		cmbNacionalidad.setModel(new DefaultComboBoxModel(new String[] { "Estadounidense", "Británica",
				"Austro Estadounidense", "Alemana", "Polaca", "Húngara" }));
		cmbNacionalidad.setSelectedIndex(-1);

		txtFechas = new JTextPane();
		txtFechas.setBackground(new Color(255, 0, 255));
		txtFechas.setFont(new Font("Tw Cen MT", Font.PLAIN, 17));
		txtFechas.setEditable(false);

		panel_Foto = new JPanel();
		panel_Foto.setBackground(new Color(255, 255, 128));

		txtOcupacion = new JTextPane();
		txtOcupacion.setBackground(new Color(255, 128, 128));
		txtOcupacion.setFont(new Font("Tw Cen MT", Font.PLAIN, 17));
		txtOcupacion.setEditable(false);

		txtNacionalidad = new JTextPane();
		txtNacionalidad.setBackground(new Color(128, 255, 255));
		txtNacionalidad.setFont(new Font("Tw Cen MT", Font.PLAIN, 17));
		txtNacionalidad.setEditable(false);
		btnPromedio.setFont(new Font("Tw Cen MT", Font.PLAIN, 17));

		txtLogros = new JTextPane();
		txtLogros.setBackground(new Color(0, 255, 128));
		txtLogros.setEditable(false);
		cmbPerfiles.setFont(new Font("Tw Cen MT", Font.PLAIN, 17));
		cmbPerfiles.setModel(new DefaultComboBoxModel(new String[] { "Ada Lovelace", "Barbara Thoens",
				"Betty Snyder Holberton", "Carol Shaw", "Erna Schneider Hoover", "Evelyn Berezin", "Frances E. Allen",
				"Grace Murray Hopper", "Hedy Lemarr", "Jean Bartik", "Jean E. Sammet", "Joan Clarke",
				"Joanna Rutkowska", "Jude Milhon", "Karen Spärck Jones", "Kathleen McNulty Mauchly Anton",
				"Lynn Conway", "Margaret Hamilton", "Marlyn Wescoff Meltze", "Radia Perlman", "Rózsa Péter",
				"Ruth Lichterman Teitelbaum", "Gertrude Blanch" }));
		cmbPerfiles.setSelectedIndex(-1);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
								gl_panel.createSequentialGroup().addContainerGap().addComponent(txtLogros,
										GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE))
								.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup().addContainerGap()
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
														.addComponent(cmbNacionalidad, 0, 179, Short.MAX_VALUE)
														.addGap(10)
														.addComponent(btnPromedio, GroupLayout.DEFAULT_SIZE, 272,
																Short.MAX_VALUE)
														.addPreferredGap(ComponentPlacement.RELATED))
												.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
														.addComponent(panel_Foto, GroupLayout.PREFERRED_SIZE, 145,
																GroupLayout.PREFERRED_SIZE)
														.addGap(18)
														.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
																.addComponent(txtOcupacion, GroupLayout.DEFAULT_SIZE,
																		294, Short.MAX_VALUE)
																.addComponent(txtNacionalidad, GroupLayout.DEFAULT_SIZE,
																		294, Short.MAX_VALUE)
																.addComponent(txtFechas, GroupLayout.DEFAULT_SIZE, 294,
																		Short.MAX_VALUE)
																.addComponent(cmbPerfiles, 0, 0, Short.MAX_VALUE))))))
						.addGap(17)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
								.addComponent(cmbPerfiles, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txtFechas, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txtNacionalidad, GroupLayout.PREFERRED_SIZE, 29,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txtOcupacion, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_Foto, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(txtLogros, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false).addComponent(cmbNacionalidad)
						.addComponent(btnPromedio, GroupLayout.PREFERRED_SIZE, 28, Short.MAX_VALUE))
				.addContainerGap()));
		panel_Foto.setLayout(new BorderLayout(0, 0));

		lblFoto = new JLabel("");
		lblFoto.setBackground(new Color(240, 240, 240));
		panel_Foto.add(lblFoto);
		panel.setLayout(gl_panel);
		contentPane.add(panel);

	}

	private void mostrarImagen(String id) {
		ImageIcon icono = new ImageIcon(iDAO.getImagen(id));
		Image imagenEscalada = icono.getImage().getScaledInstance(panel_Foto.getWidth(), panel_Foto.getHeight(),
				Image.SCALE_SMOOTH);
		ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
		JLabel lblFoto = (JLabel) panel_Foto.getComponent(0);
		lblFoto.setIcon(iconoEscalado);
		panel_Foto.revalidate();
		panel_Foto.repaint();
	}

	private void limpiarImagen() {
		lblFoto.setIcon(null);
		panel_Foto.revalidate();
		panel_Foto.repaint();
	}

	private void mostrarDatos(String id) {
		System.out.println(pDAO.getPerfil(id).split("::")[0]);
		txtFechas.setText(pDAO.getPerfil(id).split("::")[1]);
		txtNacionalidad.setText(pDAO.getPerfil(id).split("::")[2]);
		txtOcupacion.setText(pDAO.getPerfil(id).split("::")[3]);
		txtLogros.setText(pDAO.getPerfil(id).split("::")[4]);
		// El ".split("::")" sirve para separar el string cada vez que haya un "::"
		// String: "Nombre: %s::%s - %s::Nacionalidad: %s::Ocupacion/es: %s::Logro/s:
		// %s"
	}

	private void limpiarDatos() {
		txtFechas.setText("");
		txtNacionalidad.setText("");
		txtOcupacion.setText("");
		txtLogros.setText("");
	}
}