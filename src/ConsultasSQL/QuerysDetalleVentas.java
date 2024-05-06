/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConsultasSQL;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Nombre del archivo: QuerysDetalleVentas.java 
 * Autor: Nicol Borjas 
 * Fecha de creación: [20/09/2023] 
 * Descripción: Contiene funciones y consultas necesarias para mostrar los campos de la venta. 
 * Derechos de autor (c) [20/09/2023] Nicol Borjas. Todos los derechos reservados.
 */
public class QuerysDetalleVentas {

    // Atributos de la clase
    private int id;
    private int fk_producto;
    private int fk_ventas;
    private double precio;
    private int cantidad;

    // Métodos getters y setters para los atributos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFk_producto() {
        return fk_producto;
    }

    public void setFk_producto(int fk_producto) {
        this.fk_producto = fk_producto;
    }

    public int getFk_ventas() {
        return fk_ventas;
    }

    public void setFk_ventas(int fk_ventas) {
        this.fk_ventas = fk_ventas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // Método para obtener los datos del producto asociado al detalle de venta
    public QuerysInventarioProductos getDatosProducto() {
        QuerysInventarioProductos inventarioProductos = new QuerysInventarioProductos();
        try {
            // Establecer la conexión a la base de datos
            Conexion con = new Conexion();
            Connection conexion = con.getConexion();

            // Preparar la consulta SQL para obtener los datos del producto mediante su ID
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM inventarioproductos WHERE id = ? ");
            ps.setInt(1, getFk_producto());

            // Ejecutar la consulta y obtener el resultado
            ResultSet resultset = ps.executeQuery();

            // Verificar si se encontraron resultados
            if (resultset.next()) {
                // Si se encontraron resultados, asignar los valores correspondientes a los atributos del producto
                inventarioProductos.setId(resultset.getInt("id"));
                inventarioProductos.setProducto(resultset.getString("producto"));
                inventarioProductos.setTipo_producto(resultset.getString("tipo_producto"));
                inventarioProductos.setCantidad(resultset.getInt("cantidad"));
                inventarioProductos.setPrecio(resultset.getDouble("precio"));
                inventarioProductos.setPrecio_venta(resultset.getDouble("precio_venta"));
            }
        } catch (SQLException ex) {
            // En caso de error, registrar el error en el registro de errores
            Logger.getLogger(QuerysDetalleVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Devolver los datos del producto
        return inventarioProductos;
    }

    // Consultas SQL para insertar y actualizar detalles de venta
    public static String InsertarDetalle = "INSERT INTO `detalle_ventas` (`fk_producto`, `fk_ventas`, `precio`, `cantidad`) VALUES (?, ?, ?, ?);";
    public static String ActualizarDetalle = "UPDATE inventarioproductos SET cantidad = cantidad - ? WHERE  id=?;";

    // Consulta SQL para insertar detalles de venta de servicios
    public static String InsertarDetalleVentaServicio = "INSERT INTO `detalle_ventas_servicios` (`fk_producto`,`tipo_servicio`, `fk_ventas`, `precio`, `cantidad`) VALUES (?, ?, ?, ?, ?)";

}
