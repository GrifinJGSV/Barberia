/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Nombre del archivo: ProductosCuidado.java
 * Autor: Andera Ardon 
 * Fecha de creación: [17/09/2023] 
 * Descripción: Esta clase representa los metodos para la funcionalidad de los productos de cuidado personal.
 *              Permite a los desarrolladores tratar la funcionalidad del modulo de productosde cuidado personal.
 * Derechos de autor (c) [17/09/2023] Andrea Ardon. Todos los derechos reservados.
 * 
 * 
 */

package Controlador;


import Conexion.Conexion;
import ConsultasSQL.QuerysProductosCuidados;
import Vistas.MostrarProductosCuidado;
import java.sql.Connection;
import java.sql.PreparedStatement;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admins
 */
public class ProductosCuidado {
    private static Conexion con = new Conexion();
    private static Connection conexion = con.getConexion();
    private static PreparedStatement ps = null;
    
    private static final int filasxPagina = 20;   
    
        public static int NumeroPages(String buscar, int paginaActual,String categoria){
                
            String textoCategoria = "";
            if(categoria.equals("Todas")){
                textoCategoria = "";
            }else if(categoria.equals("Cuidado corporal")){
                textoCategoria = " categoria = 'Cuidado corporal' and ";
                
            }else if(categoria.equals("Cuidado de cabello")){
                 textoCategoria = " categoria = 'Cuidado de cabello' and ";
                 
            }else if(categoria.equals("Cuidado facial")){
                 textoCategoria = " categoria = 'Cuidado facial' and ";
            }
            String sql = ""; 
                sql = "SELECT count(*) from catalogo_productos WHERE "+textoCategoria+" (nombre like concat('%','"+buscar+"','%') or "
                        + "marca like '%"+buscar+"%')";

            try{
                 Statement st = conexion.createStatement();

                ps = conexion.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int totalPages = (int) Math.ceil((double) rs.getInt(1) / filasxPagina);
                    return totalPages;
                } else {
                    return 0;
                }
            }catch (SQLException ex){
                Logger.getLogger(ProductosCuidado.class.getName()).log(Level.SEVERE, null, ex);
                return 0;
            }

        }
        
        /**
        *
        * @author Andrea
        */
        //metodo para la funcionalidad del listado de productos de cuidado
         public static void MostrarProductosCuidado(String buscar, int paginaActual, int totalPages, String categoria){
        DefaultTableModel model = (DefaultTableModel)MostrarProductosCuidado.tblMostrarProductos.getModel();
            //Esta variable inicializa la categoria.
           String textoCategoria = "";
           //condiciones para realizar busqueda segun la categoria seleccionada en el ComboBox.
            if(categoria.equals("Todas")){
                textoCategoria = "";
            }else if(categoria.equals("Cuidado corporal")){
                textoCategoria = " categoria = 'Cuidado corporal' and ";
                
            }else if(categoria.equals("Cuidado de cabello")){
                 textoCategoria = " categoria = 'Cuidado de cabello' and ";
                 
            }else if(categoria.equals("Cuidado facial")){
                 textoCategoria = " categoria = 'Cuidado facial' and ";
            }     
        
        //Esta condicion estable tamaños de columnas en la tabla del listado de productos de cuidado.    
        while(model.getRowCount() > 0 ){
               
            MostrarProductosCuidado.tblMostrarProductos.getColumnModel().getColumn(5).setMaxWidth(0);
            MostrarProductosCuidado.tblMostrarProductos.getColumnModel().getColumn(5).setMinWidth(0);
            MostrarProductosCuidado.tblMostrarProductos.getTableHeader().getColumnModel().getColumn(5).setMaxWidth(0);
            MostrarProductosCuidado.tblMostrarProductos.getTableHeader().getColumnModel().getColumn(5).setMinWidth(0);
            //remueve filas.
            model.removeRow(0);
        }
           //variable que inicializa la busqueda.
           String sql = "";
           
           //condicion if para cuando el cuadro de busqueda esta vacio.
            if (!buscar.isEmpty()) {
                sql = "select * from catalogo_productos  WHERE "+textoCategoria+" (nombre like concat('%','"+buscar+"','%') or "
                + "marca like '%"+buscar+"%') limit " + filasxPagina + " offset " + (paginaActual - 1) * filasxPagina;
            
                MostrarProductosCuidado.siguiente.setVisible(true);
                MostrarProductosCuidado.Previo.setVisible(true);
                MostrarProductosCuidado.seguimiento.setVisible(true);
            } 
            //condicion else para cuando hay parametros de entrada en el cuadro de busqueda.
            else {
                sql = "select * from catalogo_productos WHERE "+textoCategoria+" (nombre like concat('%','"+buscar+"','%') or "
                + "marca like '%"+buscar+"%')";
            
                MostrarProductosCuidado.siguiente.setVisible(true);
                MostrarProductosCuidado.Previo.setVisible(true);
                MostrarProductosCuidado.seguimiento.setVisible(true);
            
            }
            
        // arreglo para los atributos de la tabala.
        String datos[] = new String[7];
        
        //Manejo de errrores, el try maneja el codigo si funciona.
        try{
            //estas variables establecen la coneccion con la DB.
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            //variable para inicializar el contador de paginacion.
            int count = 0;
            //Condicion cuando la pagina sea igual a 1
            if(paginaActual ==1) {
                count =1;
            }
            //condicion cuando la pagina no sea igual a 1 y muestre en la tabla 20 filas o registros.
            else{
                for(int i =1;i < paginaActual ; i++){
                    count +=20;
                }
                count +=1;
            }
           //Condicion para ordenar los atributos en la tabla.
            while(rs.next()){
                //arreglo para el contador de la enumeracion de los registros en la tabla
                datos[0] = count+"";
                //Variable que obtiene el nombre de la DB. y lo pone en la columna Nombre de la tabla en la posicion 1
                datos[1] = rs.getString("nombre");
                //Variable que obtiene la marca de la DB. y lo pone en la columna Marca de la tabla en la posicion 2
                datos[2] = rs.getString("marca");
                //Variable que obtiene el tamaño de la DB. y lo pone en la columna tamaño de la tabla en la posicion 3
                datos[3] = rs.getString("tamano");
                //Variable que obtiene la categoria de la DB. y lo pone en la columna categoria de la tabla en la posicion 4
                datos[4] = rs.getString("categoria");
                //Variable que obtiene la descripcione de la DB. y lo pone en la columna descricion de la tabla en la posicion 5
                datos[5] = rs.getString("descripcion");
                //Variable que obtiene el id de la DB. y lo pone en la columna id de la tabla en la posicion 6
                datos[6] = rs.getString("id");
                //esta linea de codigo agrega esos datos ordenados en la tabla.
                model.addRow(datos);
                //aumenta el contador de registros para la paginacion.
                count++;
                //variable que almacena la paginacion.
                totalPages = NumeroPages(buscar,paginaActual,categoria);
                
                MostrarProductosCuidado.seguimiento.setText("Página " + paginaActual + " de " + totalPages);
                DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
                tcr.setHorizontalAlignment(SwingConstants.RIGHT);
                MostrarProductosCuidado.tblMostrarProductos.setModel(model);
                
            }
           
        }
        //manejo de error si el codigo falla.
        catch (SQLException ex){
            Logger.getLogger(MostrarProductosCuidado.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
         
    public static boolean Guardar(QuerysProductosCuidados qp) {
    String sql = QuerysProductosCuidados.RegistraProducto; 

        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, qp.getNombre());
            ps.setString(2, qp.getMarca());
            ps.setString(3, qp.getTamano());
            ps.setString(4, qp.getCategoria());
            ps.setString(5, qp.getDescripcion());

            ps.executeUpdate();
            return true; 
        } catch (SQLException ex) {
            Logger.getLogger(ProductosCuidado.class.getName()).log(Level.SEVERE, null, ex);
            return false;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static boolean Editar(QuerysProductosCuidados qp) {
     String sql = QuerysProductosCuidados.ACTUALIZAR; // Obtener la consulta SQL para modificar un desde QuerysProductos

        try {
            ps = conexion.prepareStatement(sql); // Preparar la sentencia SQL
            
           ps.setString(1,qp.getNombre());
            ps.setString(2,qp.getMarca());
            ps.setString(3,qp.getCategoria());
             ps.setString(4, qp.getTamano());
            ps.setString(5,qp.getDescripcion());
            ps.setInt(6,qp.getId());//   se agrego aqui tambien                          Establecer id en la consulta  

            ps.executeUpdate(); // Ejecutar la consulta de inserción en la base de datos* actualiza la información de la base de datos
            return true; // Indicar que el guardado fue exitoso
        } catch (SQLException ex) {
            return false; // Indicar que ocurrió un error durante el guardado
//         
        }
    }
}
