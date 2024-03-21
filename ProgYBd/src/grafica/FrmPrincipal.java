package grafica;

import logica.*;

import java.awt.*;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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

		setResizable(false);
		setTitle("Lo hicimos obligados fuck 8M");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 192));
		panel.setBounds(10, 11, 502, 365);
		contentPane.add(panel);
		panel.setLayout(null);

		cmbPerfiles = new JComboBox();
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
		cmbPerfiles.setFont(new Font("Tw Cen MT", Font.PLAIN, 17));
		cmbPerfiles.setModel(new DefaultComboBoxModel(new String[] { "Ada Lovelace", "Barbara Thoens",
				"Betty Snyder Holberton", "Carol Shaw", "Erna Schneider Hoover", "Evelyn Berezin", "Frances E. Allen",
				"Grace Murray Hopper", "Hedy Lemarr", "Jean Bartik", "Jean E. Sammet", "Joan Clarke",
				"Joanna Rutkowska", "Jude Milhon", "Karen Spärck Jones", "Kathleen McNulty Mauchly Anton",
				"Lynn Conway", "Margaret Hamilton", "Marlyn Wescoff Meltze", "Radia Perlman", "Rózsa Péter",
				"Ruth Lichterman Teitelbaum", "Gertrude Blanch" }));
		cmbPerfiles.setBounds(10, 10, 483, 30);
		panel.add(cmbPerfiles);
		cmbPerfiles.setSelectedIndex(-1);

		panel_Foto = new JPanel();
		panel_Foto.setBounds(10, 53, 127, 129);
		panel.add(panel_Foto);
		panel_Foto.setLayout(null);

		lblFoto = new JLabel("");
		lblFoto.setBounds(0, 0, 127, 129);
		panel_Foto.add(lblFoto);

		txtFechas = new JTextPane();
		txtFechas.setFont(new Font("Tw Cen MT", Font.PLAIN, 17));
		txtFechas.setEditable(false);
		txtFechas.setBounds(147, 51, 346, 40);
		panel.add(txtFechas);

		txtNacionalidad = new JTextPane();
		txtNacionalidad.setFont(new Font("Tw Cen MT", Font.PLAIN, 17));
		txtNacionalidad.setEditable(false);
		txtNacionalidad.setBounds(147, 96, 346, 40);
		panel.add(txtNacionalidad);

		txtOcupacion = new JTextPane();
		txtOcupacion.setFont(new Font("Tw Cen MT", Font.PLAIN, 17));
		txtOcupacion.setEditable(false);
		txtOcupacion.setBounds(147, 142, 346, 40);
		panel.add(txtOcupacion);

		txtLogros = new JTextPane();
		txtLogros.setBounds(10, 193, 482, 120);
		panel.add(txtLogros);

		cmbNacionalidad = new JComboBox();
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
					case "Austroestadounidense":
						nacionalidad = "Austroestadounidense";
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
		cmbNacionalidad.setModel(new DefaultComboBoxModel(
				new String[] { "Estadounidense", "Británica", "Astroestadounidense", "Alemana", "Polaca", "Húngara" }));
		cmbNacionalidad.setBounds(10, 324, 158, 31);
		panel.add(cmbNacionalidad);
		cmbNacionalidad.setSelectedIndex(-1);

		btnPromedio = new JButton("Promedio de edades");
		btnPromedio.setForeground(Color.BLACK);
		btnPromedio.setBackground(Color.WHITE);
		btnPromedio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, pDAO.getPromedioEdades(nacionalidad), "Promedio de edades ",
						JOptionPane.PLAIN_MESSAGE);
			}
		});
		btnPromedio.setFont(new Font("Tw Cen MT", Font.PLAIN, 17));
		btnPromedio.setBounds(178, 325, 315, 30);
		panel.add(btnPromedio);

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