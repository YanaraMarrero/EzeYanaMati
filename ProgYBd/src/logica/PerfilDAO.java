package logica;

import java.sql.*;
import persistencia.*;

public class PerfilDAO {

	private Conexion conexion;

	public PerfilDAO() {
		conexion = new Conexion();
	}

	public String getPromedioEdades(String nacionalidad) {
		switch (nacionalidad) {
		case "Estadounidense":
			return "El promedio de edades Estadounidenses es: 79";
		case "Británica":
			return "El promedio de edades Britanica es: 63";
		case "Austroestadounidense":
			return "El promedio de edades Austroestadounidenses es: 86";
		case "Alemana":
			return "El promedio de edades Alemana es: 68";
		case "Polaca":
			return "El promedio de edades Polaca es: 43";
		case "Húngara":
			return "El promedio de edades Húngara es: 53";
		default:
			return "Seleccione una nacionalidad";
		}
	}

	public String getPerfil(String id) {
		try {
			Connection acceBD = conexion.getConnection();

			String sql = "SELECT p.*, "
					+ "GROUP_CONCAT(DISTINCT o.ocupacion ORDER BY o.ocupacion SEPARATOR ', ') AS ocupaciones, "
					+ "GROUP_CONCAT(DISTINCT l.logro ORDER BY l.logro SEPARATOR ', ') AS logros " + "FROM Perfil p "
					+ "LEFT JOIN Ocupacion o ON p.id = o.perfil_id " + "LEFT JOIN Logro l ON p.id = l.perfil_id "
					+ "WHERE p.id = ? " + "GROUP BY p.id";

			PreparedStatement statement = acceBD.prepareStatement(sql);
			statement.setString(1, id);

			ResultSet resultSet = statement.executeQuery();

			StringBuilder datos = new StringBuilder();

			while (resultSet.next()) {

				String nom1 = resultSet.getString("nom1");
				String nom2 = resultSet.getString("nom2");
				String ape1 = resultSet.getString("ape1");
				String ape2 = resultSet.getString("ape2");
				String nombreCompleto = unirNombres(nom1, nom2, ape1, ape2);
				String fechaNac = resultSet.getString("fechaNac");
				String fechaFall = resultSet.getString("fechaFall");
				String nacionalidad = resultSet.getString("nacionalidad");
				String ocupacion = resultSet.getString("ocupaciones");
				String logro = resultSet.getString("logros");

				datos.append("Nombre: ").append(nombreCompleto).append("::").append(fechaNac).append(" - ")
						.append(fechaFall).append("::").append("Nacionalidad: ").append(nacionalidad).append("::")
						.append("Ocupacion/es: ").append(ocupacion).append("::").append("Logro/s: ").append(logro);

			}

			return datos.toString();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "Error al obtener datos del perfil";
		}
	}

	public static String unirNombres(String nom1, String nom2, String ape1, String ape2) {
		StringBuilder nombreCompleto = new StringBuilder();
		if (nom1 != null) {
			nombreCompleto.append(nom1).append(" ");
		}
		if (nom2 != null) {
			nombreCompleto.append(nom2).append(" ");
		}
		if (ape1 != null) {
			nombreCompleto.append(ape1).append(" ");
		}
		if (ape2 != null) {
			nombreCompleto.append(ape2);
		}
		return nombreCompleto.toString().trim();
	}

}