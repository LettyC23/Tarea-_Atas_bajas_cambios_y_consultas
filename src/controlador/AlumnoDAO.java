package controlador;

import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexionBD.ConexionBD;
import modelo.Alumno;

public class AlumnoDAO {

	public boolean AgregarAlumno(Alumno a) {
		ConexionBD conexion = new ConexionBD();
		String sql = "INSERT INTO Alumnos VALUES('3', '3', '3', '3', 3, 3, '3');";
		String sql2 = "INSERT INTO Alumnos VALUES('"+a.getNumControl()+"', '"+a.getNombre()+"', '"+a.getPrimerAp()+"', '"+a.getSegundoAp()+"', "+a.getEdad()+", "+a.getSemestre()+", '"+a.getCarrera()+"');";
		return conexion.ejecutarInstruccion(sql2);
	}
	
	public boolean EliminarAlumno(String nc) {
		ConexionBD conexion = new ConexionBD();
		String sql = "DELETE FROM Alumnos WHERE NumControl = '"+nc+"';";
		return conexion.ejecutarInstruccion(sql);
	}
	
	public boolean ActualizarAlumno(Alumno a) {
		ConexionBD conexion = new ConexionBD();
		
		String sql = "UPDATE Alumnos SET Nombre='"+a.getNombre()+"', PrimerAp='"+a.getPrimerAp()+"', SegundoAp='"+a.getSegundoAp()+"', Edad="+a.getEdad()+", Semestre="+a.getSemestre()+", Carrera='"+a.getCarrera()+"' WHERE NumContrl='"+a.getNumControl()+"';";
		return conexion.ejecutarInstruccion(sql);
	}
	
	//Buscar un registro
	public Alumno buscarAlumno(String nc, Alumno alumno) {
		
		
		String sql = "SELECT * FROM Alumnos WHERE NumContrl = '"+nc+"';";
		ConexionBD conexion = new ConexionBD();
		
		ResultSet rs = conexion.ejecutarConsultaRegistros(sql);
		
		try {
			rs.last();
			rs.getString(1);
			alumno.setNumControl(rs.getString(1));
			alumno.setNombre(rs.getString(2));
			alumno.setPrimerAp(rs.getString(3));
			alumno.setSegundoAp(rs.getString(4));
			alumno.setEdad(rs.getByte(5));
			alumno.setSemestre(rs.getByte(6));
			alumno.setCarrera(rs.getString(7));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return alumno;
	}
	
	//Buscar multiples registros
	public ArrayList<Alumno> BuscarAlumnos(String filtro, Alumno alumno){
		ArrayList<Alumno> listaAlumnos = null;
	
		
		String sql = "SELECT * FROM Alumnos WHERE Semestre = '"+filtro+"';";
		ConexionBD conexion = new ConexionBD();
		
		ResultSet rs = conexion.ejecutarConsultaRegistros(sql);
		
		try {
			while(rs.next()) {
				alumno.setNumControl(rs.getString(1));
				alumno.setNombre(rs.getString(2));
				alumno.setPrimerAp(rs.getString(3));
				alumno.setSegundoAp(rs.getString(4));
				alumno.setEdad(rs.getByte(5));
				alumno.setSemestre(rs.getByte(6));
				alumno.setCarrera(rs.getString(7));
				listaAlumnos.add(alumno);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaAlumnos;
	}
	
}
