package conexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {
	private Connection conexion;
	private Statement stm;
	
	private PreparedStatement pstm; // PARA PROYECTO FINAL
	
	ResultSet rs=null;
	
	public ConexionBD() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
									 //127.0.0.1 
			String url = "jdbc:mysql://localhost/BD_Escuela?useTimezone=true&serverTimezone=UTC";
			conexion = DriverManager.getConnection(url, "root", "lacc");//(ruta, nombreUsuario, contraseña)
			System.out.println("Magia magia con BD, ya casi soy ISC  =)");
		} catch (ClassNotFoundException e) {
			System.out.println("No se encontro el controlador");
			System.out.println("Mejor me dedico a las redes ='(");
		}catch(SQLException e) {
			System.out.println("No se pudo conectar al servidor");
			System.out.println("Mejor me dedico a las redes ='(");
		}finally {
			//Codigo que SIEMPRE SE EJECUTA 
			//Cierre de la conexion de la BD
		}
	}//Cnstructor
	
	public void cerrarConexion() {
		try {
			stm.close();
			conexion.close();
		} catch (SQLException e) {
			System.out.println("No se pudo cerrar la conexion");
		}
	}
	//metodos que ejecuten las operaciones ABCC(DDL, DML Y SQL)
	
	//Un metodo para DDL y DML
	//otro metodo para SQL
	
	public boolean ejecutarInstruccion(String sql) {
		try {
			stm = conexion.prepareStatement(sql);
			int ejecucion;
			ejecucion = stm.executeUpdate(sql);
			return ejecucion==1?true:false;
		} catch (SQLException e) {
		System.out.println("No se pudo ejecutar la instruccion SQL");
		return false;
		}
	}
	
	//otro metodo para SQL (CONSULTAS)
	
	public ResultSet ejecutarConsultaRegistros(String sql) {
		try {
			stm = conexion.createStatement();
			stm.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("No se pudo ejecutar la instruccion SQL");
			e.printStackTrace();
		}
		return rs;
	}
	
	public static void main(String[] args) {
		new ConexionBD();
	}
}//class ConexionBD


