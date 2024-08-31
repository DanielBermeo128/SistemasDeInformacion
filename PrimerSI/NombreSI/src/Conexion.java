import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

	// Valores para hacer la conexion con mariaDB 10.11.2/ MySQL 15.1
	private String url = "jdbc:mariadb://127.0.0.1:3306/nombres?serverTimezone = UTC";
	private String usuario = "root";
	private String pass = "1234";
	private Connection conexion;
		
		public Conexion() throws ClassNotFoundException, SQLException {
		
			Class.forName("org.mariadb.jdbc.Driver");
			conexion = DriverManager.getConnection(url,usuario,pass);
		
		}

		// Devuelve verdadero si el nombre ya esta en la DB, o falso en caso de no estar
		public boolean existe(String nombre) throws SQLException {
			boolean existe = false;
			int indice = -1;
			String consulta = "SELECT id_nombre FROM datos WHERE nombre = '" + nombre + "';";
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			if(rs.next()) {
				indice = rs.getInt(1); 
			}
			
			if(indice != -1) {
				existe = true;
			}
			
			return existe;
		}

		// Aumenta el valor INT que se encuentra contando el numero de veces en que el nombre es introducido
		public void aumentarIncidencia(String nombre) throws SQLException {
			String actualizar = "UPDATE datos SET incidencias = (SELECT incidencias FROM datos WHERE nombre = ?) + 1 WHERE nombre = ?;";
			PreparedStatement ps = conexion.prepareStatement(actualizar);
			ps.setString(1, nombre);
			ps.setString(2, nombre);
			ps.execute();
			ps.close();

			
		}

		// Crea un nuevo registro dentro de la tabla con el nombre y cuenta esta como su primer incidencia
		 void crearRegistro(String nombre) throws SQLException {
			 String insertar =  "INSERT INTO datos(nombre,incidencias) VALUES (?,1)"; 
				PreparedStatement ps = conexion.prepareStatement(insertar);
				ps.setString(1, nombre);
				ps.execute();
				ps.close();
		 }

		// Devuelve en INT el numero de veces que ha entrado el nombre
		public int getIncidencias(String nombre) throws SQLException {
			
			int incidencias = 0;
			String consulta = "SELECT incidencias FROM datos WHERE nombre = '" + nombre + "';";
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			rs.next();	
			incidencias = rs.getInt(1); 
			
			
			return incidencias;
		}
		
		// Cierre de la conexion a la base de datos
		public void cerrarConexion() throws SQLException {
			conexion.close();
		}
		
		
		
		
	
	}
