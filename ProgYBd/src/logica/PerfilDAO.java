package logica;

import java.sql.*;

import persistencia.*;

public class PerfilDAO {

	private Conexion conexion;

	public PerfilDAO() {
		conexion = new Conexion();
	}

	public String getPromedioEdades(String nacionalidad) {
		try {
			Connection acceBD = conexion.getConnection();

			String sql = "SELECT p.id, p.nacionalidad, p.fechaNac, p.fechaFall FROM Perfil p WHERE p.nacionalidad = ?";

			PreparedStatement statement = acceBD.prepareStatement(sql);
			statement.setString(1, nacionalidad);

			ResultSet resultSet = statement.executeQuery();

			String fechaNac = null;
			String fechaFall = null;

			int fechaNacInt = 0;
			int fechaFallInt = 0;

			int cantidadPersonas = 0;
			int sumaEdades = 0;
			int edad = 0;

			while (resultSet.next()) {

				fechaNac = resultSet.getString("fechaNac").split("/")[2];
				fechaFall = resultSet.getString("fechaFall");
				
				if (fechaFall.equals("Viva")) {
					fechaFall = "2024";
				} else {
					fechaFall = fechaFall.split("/")[2];
				}

				fechaNacInt = Integer.parseInt(fechaNac);
				fechaFallInt = Integer.parseInt(fechaFall);

				edad = fechaFallInt - fechaNacInt;

				sumaEdades += edad;
				cantidadPersonas++;
			}

			if (cantidadPersonas == 0) {
				return "No se encontraron personas con dicha nacionalidad";
			}

			double promedio = sumaEdades / cantidadPersonas;

			return String.format("El promedio de edades %s es: %s", nacionalidad, promedio);

		} catch (SQLException e) {
			System.out.println("Error al ejecutar la consulta SQL: " + e.getMessage());
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