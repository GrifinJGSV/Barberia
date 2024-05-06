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
 * Nombre del archivo: QuerysVentas.java 
 * Autor: Nicol Borjas 
 * Fecha de creación: [20/09/2023] 
 * Descripción: Contiene funciones y consultas necesarias para mostrar los campos de la venta. 
 * Derechos de autor (c) [20/09/2023] Nicol Borjas. Todos los derechos reservados.
 */
public class QuerysVentas {

    // Consulta SQL para listar las ventas
    public static String LISTARVENTAS = "SELECT * FROM ventas INNER JOIN clientes ON clientes.id = ventas.fk_cliente";

    // Consulta SQL para listar las ventas de servicios
    public static String LISTARVENTASERVICIOS = "SELECT * FROM ventas_servicios INNER JOIN clientes ON clientes.id = ventas_servicios.fk_cliente";

    // Variables de instancia para los datos de la venta
    private int id;
    private String cai;
    private String numeroFactura;
    private int fk_cliente;
    private String fecha;
    private Double total;
    private Double impuestos;

    // Métodos getter y setter para acceder a los datos de la venta
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCai() {
        return cai;
    }

    public void setCai(String cai) {
        this.cai = cai;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public int getFk_cliente() {
        return fk_cliente;
    }

    public void setFk_cliente(int fk_cliente) {
        this.fk_cliente = fk_cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(Double impuestos) {
        this.impuestos = impuestos;
    }

    // Método para obtener los datos del cliente asociado a la venta
    public QuerysClientes getDatosClientes() {
        // Crear una instancia de QuerysClientes para almacenar los datos del cliente
        QuerysClientes clientes = new QuerysClientes();
        try {
            // Establecer la conexión a la base de datos
            Conexion con = new Conexion();
            Connection conexion = con.getConexion();

            // Preparar la consulta SQL para obtener los datos del cliente mediante su ID
            PreparedStatement ps = conexion.prepareStatement(QuerysVentas.TraerCliente);
            ps.setInt(1, getFk_cliente());

            // Ejecutar la consulta y obtener el resultado
            ResultSet resultset = ps.executeQuery();

            // Verificar si se encontraron resultados
            if (resultset.next()) {
                // Si se encontraron resultados, asignar los valores correspondientes a los atributos del cliente
                clientes.setId(resultset.getInt("id"));
                clientes.setNombre(resultset.getString("nombre"));
                clientes.setApellido(resultset.getString("apellido"));
                clientes.setFechaNacimiento(resultset.getString("fechaNacimiento"));
                clientes.setDireccion(resultset.getString("direccion"));
                clientes.setTelefono(resultset.getString("telefono"));
                clientes.setFechaRegistro(resultset.getString("fechaRegistro"));
            }
        } catch (SQLException ex) {
            // En caso de error, registrar el error en el registro de errores
            Logger.getLogger(QuerysVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Devolver los datos del cliente
        return clientes;
    }

    // Consulta SQL para obtener los datos de un cliente específico
    public static String TraerCliente = "SELECT * from clientes where clientes.id=?";

    // Consulta SQL para insertar una venta
    public static String InsertarVEnta = "INSERT INTO `ventas` (`cai`, `numeroFactura`, `fk_cliente`, `fecha`, `total`, `impuestos`) VALUES (?, ?, ?, ?, ?, ?)";

    // Consulta SQL para insertar una venta de servicio
    public static String InsertarVEntaServicio = "INSERT INTO `ventas_servicios` (`cai`, `numeroFactura`, `fk_cliente`, `fecha`, `total`, `impuestos`) VALUES (?, ?, ?, ?, ?, ?)";

}
