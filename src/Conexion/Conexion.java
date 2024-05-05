/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
    * Nombre del archivo: Conexion.java
    * Autor: Arturo Mendoza
    * Fecha de creación: [20/09/2023]
    * Descripción: Esta clase permite la conexion del sistema a la DB.
    *              Permite a los desarrolladores establer una conexion con la DB cuando necesiten hacer la.
    * Derechos de autor (c) [20/09/2023] Arturo Mendoza. Todos los derechos reservados.
 */

/**
 *
 * @author Arturo
 */
    //Clase publica para para hacer la conexion a la base de datos en MySQL Workbench
    public class Conexion {
        
    //Metodo para obtener la conxion.
    public static Connection getConection() {
        //regresa la conexion
        return conection;
    }
    //Metodo para establecer la conexion
    public static void setConection(Connection conection) {
        //variable que almacena la clase conection.
        Conexion.conection = conection;
    }
    //metodo que inicializa la conexion en null
      public static Connection conection = null;
    //meto que obtiene la conexion
    public Connection getConexion() {
                //metodo para manejar las excepciones por si se efectua o falla la conexion.
		try {
			
                      //Variable que utiliza una libreria para iniciar la conexion con los datos especificos de la conexion a la DB.
                      conection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/barberia", "root", "12345678");
                      return conection;
                        
                    } 
                        //excepcion por si falla la conexion.
                       catch (SQLException ex) {
			return conection;
			
		}

	}   
}
