/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Nombre del archivo: Conexion.java
 * Autor: Arturo Mendoza 
 * Fecha de creación: [10/04/2023] 
 * Descripción: Esta clase representa la conexion ala DB con el sistema.
 *              Permite la conexion a la DB.
 * Derechos de autor (c) [20/09/2023] Arturo Mendoza. Todos los derechos reservados.
 * 
 * 
 */

package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Arturo
 */
    public class Conexion {

    //Metodo que devuelve la variable con la que se trabaja la conexion
    public static Connection getConection() {
        return conection;
    }

    //Este metodo establece la conexion en la variable conection.
    public static void setConection(Connection conection) {
        Conexion.conection = conection;
    }
    //esta variable publica inicializa la conexion.
      public static Connection conection = null;
    
      //Mediante este metodo se obtiene la conexion.
      public Connection getConexion() {
	
          //manejo de errores en el codigo
          //Try para cuando el codigo no falla y se ejecuta bien.
          try {
			
		//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                //variable que permite la conexion con la DB en el MySQL Workbench medante las credenciales.      
                conection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/barberia", "root", "12345678");
                //Retorna la conecion cuando se logra etsablecer      
                return conection;
                        
                    } 
                       //Manejo de error por si el codigo falla y/o no se ejecuta.
                       catch (SQLException ex) {
			return conection;
			
		}

	}   
}
