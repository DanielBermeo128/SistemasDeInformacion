import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Objeto scanner para leer la entrada del nombre
		Scanner sc = new Scanner(System.in);
		// Ciclo para poder introducir varios nombres de forma rapida
		while(true) {
		try {
			// Objeto conexion con el que trabajaremos la DB
			Conexion cn = new Conexion();
			// Interfaz del usuario
			System.out.println("Escribe tu nombre:");
			String nombre = sc.nextLine();
			// Variable que guardara el mensaje del txt
			String mensaje;
			
			// Caso 1: El nombre ya se encuentra en la DB
			if(cn.existe(nombre)) {
				cn.aumentarIncidencia(nombre);
				mensaje= "Hola " + nombre + "!!! por " + cn.getIncidencias(nombre) + "° vez -_-";
			
			// Caso 2: El nombre es una entrada nueva
			}else {
				cn.crearRegistro(nombre);
				mensaje = "El nombre "+ nombre +" ha sido añadido a la DB: Hola " + nombre + " !!! :3";
			}
			// Creacion del nombre del archivo asegurando irrepetibilidad
			String nombreArchivo = nombre + cn.getIncidencias(nombre) + ".txt";
			// Creacion del archivo en la carpeta del proyecto llamada Archivos
			String pt ="Archivos/"+ nombreArchivo ;
			File archivo = new File(pt);
			// Creacion del objeto escribiente
			FileWriter escribir = new FileWriter(archivo,true);
			// Se escribe el mensaje segun el caso
			escribir.write(mensaje);
			escribir.close();
			System.out.println("Su saludo ha sido guardado en: " + pt);
			cn.cerrarConexion();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		}
	}
}
