package logica;

import java.sql.*;
import persistencia.*;

public class ImagenDAO {

	private Conexion conexion;

	public ImagenDAO() {
		conexion = new Conexion();
	}

	public String pedirImagen(String id) {
		try {
			Connection acceBD = conexion.getConnection();

			String sql = "SELECT imagen_id, titulo, imagen FROM Imagen WHERE imagen_id = ?";

			PreparedStatement estatuto = acceBD.prepareStatement(sql);
			estatuto.setString(1, id);

			ResultSet resultSet = estatuto.executeQuery();
			String image = null;

			while (resultSet.next()) {
				image = resultSet.getString("imagen");
			}

			return image;

		} catch (Exception e) {

			return null;

		}
	}
}