/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.Conexion;
import ConsultasSQL.QuerysClientes;
import ConsultasSQL.QuerysDetalleVentas;
import ConsultasSQL.QuerysInventarioProductos;
import ConsultasSQL.QuerysVentas;
import Vistas.CrearVentasClientes;
import Vistas.CrearVentasProductos;
import Vistas.MostrarVentas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 * Nombre del archivo: Ventas.java 
 * Autor: Nicol Borjas 
 * Fecha de creación: [20/09/2023] 
 * Descripción: Contiene funciones y consultas necesarias para el funcionamiento de la ventana de ventas. 
 * Derechos de autor (c) [20/09/2023] Nicol Borjas. Todos los derechos reservados.
 */
public class Ventas {

    // Instancias de la clase Conexion y preparación de objetos de conexión y declaración
    private static Conexion con = new Conexion();
    private static Connection conexion = con.getConexion();
    private static PreparedStatement ps = null;

    // Constante para el número de filas por página
    private static final int filasxPagina = 20;

    // Lista para almacenar los IDs
    public static List ids = new ArrayList();

    // Método para calcular el número de páginas en función de una búsqueda y rangos de fechas
    public static int NumeroPages(String buscar, String textoInicial, String textoFinal) {
        String sql = "";
        // Verificar si la búsqueda está vacía
        if (buscar.isEmpty()) {
            buscar = "";
            // Consulta SQL para contar el número de registros en función de las fechas
            sql = "SELECT count(*) FROM ventas"
                    + "	INNER JOIN clientes ON clientes.id = ventas.fk_cliente WHERE "
                    + " ventas.fecha BETWEEN if(" + textoInicial + " IS NULL,'1980-01-01','" + textoInicial + "') and if(" + textoFinal + " IS NULL,'2900-01-01','" + textoFinal + "') ";
        } else {
            // Consulta SQL para contar el número de registros en función de la búsqueda y las fechas
            sql = "SELECT count(*) from ventas"
                    + "	INNER JOIN clientes ON clientes.id = ventas.fk_cliente WHERE "
                    + "(numeroFactura like concat('%','" + buscar + "','%') "
                    + "and cai like concat('%','" + buscar + "','%') "
                    + "and concat(clientes.nombre,' ',clientes.apellido) like concat('%','" + buscar + "','%')) "
                    + " and ventas.fecha BETWEEN if(" + textoInicial + " IS NULL,'1980-01-01','" + textoInicial + "') and if(" + textoFinal + " IS NULL,'2900-01-01','" + textoFinal + "') ";
        }

        try {
            Statement st = conexion.createStatement();

            ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // Calcular el número total de páginas
                int totalPages = (int) Math.ceil((double) rs.getInt(1) / filasxPagina);
                return totalPages;
            } else {
                return 1;
            }
        } catch (SQLException ex) {
            // Manejo de excepciones en caso de error
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    // Método para mostrar las ventas en una tabla, con paginación
    public static void MostrarVentas(String buscar, int paginaActual, int totalPages, String textoInicial, String textoFinal) {
        DefaultTableModel model = (DefaultTableModel) MostrarVentas.jtventas.getModel();
        // Limpiar la tabla
        while (model.getRowCount() > 0) {
            model.removeRow(0);
            MostrarVentas.jtventas.getColumnModel().getColumn(0).setMaxWidth(0);
            MostrarVentas.jtventas.getColumnModel().getColumn(0).setMinWidth(0);
            MostrarVentas.jtventas.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
            MostrarVentas.jtventas.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        }
        Clientes.ids.clear();

        String datos[] = new String[8];

        try {
            String sql = "";
            // Construir la consulta SQL en función de si hay una búsqueda o no
            if (buscar.equals("")) {
                sql = QuerysVentas.LISTARVENTAS + " WHERE "
                        + " ventas.fecha BETWEEN if(" + textoInicial + " IS NULL,'1980-01-01','" + textoInicial + "') and if(" + textoFinal + " IS NULL,'2900-01-01','" + textoFinal + "') "
                        + " limit " + filasxPagina + " offset " + (paginaActual - 1) * filasxPagina;
                ps = conexion.prepareStatement(sql);
            } else {
                sql = QuerysVentas.LISTARVENTAS + " WHERE "
                        + "(numeroFactura like concat('%',?,'%') "
                        + "or cai like concat('%',?,'%') "
                        + "or concat(clientes.nombre,' ',clientes.apellido) like concat('%',?,'%'))"
                        + " and ventas.fecha BETWEEN if(" + textoInicial + " IS NULL,'1980-01-01','" + textoInicial + "') and if(" + textoFinal + " IS NULL,'2900-01-01','" + textoFinal + "') "
                        + "limit " + filasxPagina + " offset " + (paginaActual - 1) * filasxPagina;
                ps = conexion.prepareStatement(sql);
                ps.setString(1, buscar);
                ps.setString(2, buscar);
                ps.setString(3, buscar);
            }

            ResultSet rs = ps.executeQuery();
            int count = 0;
            // Calcular el número inicial de la fila en función de la página actual
            if (paginaActual == 1) {
                count = 1;
            } else {
                for (int i = 1; i < paginaActual; i++) {
                    count += 20;
                }
                count += 1;
            }

            // Rellenar la tabla con los datos de las ventas
            while (rs.next()) {
                datos[0] = count + "";
                datos[1] = count + "";
                datos[2] = rs.getString("nombre") + " " + rs.getString("apellido");
                datos[3] = rs.getString("numeroFactura");
                datos[4] = rs.getString("cai");
                datos[5] = rs.getString("fecha");

                Clientes.ids.add(rs.getInt("id"));
                model.addRow(datos);
                count++;
            }

            // Calcular el número total de filas y de páginas
            int totalRows = count - 1; // Restamos el encabezado de la tabla
            totalPages = (NumeroPages(buscar, textoInicial, textoFinal) == 0 && model.getRowCount() > 0) ? 1 : NumeroPages(buscar, textoInicial, textoFinal);
            paginaActual = model.getRowCount() == 0 ? 0 : paginaActual;

            // Actualizar el texto de seguimiento con la página actual y el total de páginas
            MostrarVentas.seguimiento.setText("Página " + paginaActual + " de " + totalPages);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.RIGHT);
            MostrarVentas.jtventas.setModel(model);
        } catch (SQLException ex) {
            // Manejar las excepciones de SQL
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Método para guardar una venta junto con sus detalles en la base de datos
    public static boolean Guardar(QuerysVentas qp, List<QuerysDetalleVentas> lis) {
        String sql = QuerysVentas.InsertarVEnta;
        String sql2 = QuerysDetalleVentas.InsertarDetalle;
        String sql3 = QuerysDetalleVentas.ActualizarDetalle;
        try {
            ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, qp.getCai());
            ps.setString(2, qp.getNumeroFactura());
            ps.setInt(3, qp.getFk_cliente());
            ps.setString(4, qp.getFecha());
            ps.setDouble(5, qp.getTotal());
            ps.setDouble(6, qp.getImpuestos());
            ps.executeUpdate();

            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idGenerado = generatedKeys.getInt(1);

                // Iterar sobre los detalles de la venta y guardarlos en la base de datos
                for (QuerysDetalleVentas detalleVentas : lis) {
                    ps = conexion.prepareStatement(sql2);
                    ps.setInt(1, detalleVentas.getFk_producto());
                    ps.setInt(2, idGenerado);
                    ps.setDouble(3, detalleVentas.getPrecio());
                    ps.setInt(4, detalleVentas.getCantidad());
                    ps.executeUpdate();

                    ps = conexion.prepareStatement(sql3);
                    ps.setInt(1, detalleVentas.getCantidad());
                    ps.setInt(2, detalleVentas.getFk_producto());
                    ps.executeUpdate();
                }
            }
            return true;
        } catch (SQLException ex) {
            // Manejar las excepciones de SQL
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
    }
    private static final int filasxPagina2 = 10;
    public static List ids2 = new ArrayList();
    public static List<QuerysClientes> clientes_ventas = new ArrayList();

    // Método para calcular el número de páginas de clientes en función de la búsqueda
    public static int NumeroPagesClientes(String buscar) {

        String sql = "";
        if (buscar.isEmpty()) {
            // Si no hay búsqueda, se cuenta el total de clientes
            buscar = "";
            sql = "SELECT count(*) from clientes";
        } else {
            // Si hay una búsqueda, se cuenta el total de clientes que coinciden con la búsqueda
            sql = "SELECT count(*) from clientes WHERE "
                    + " concat(nombre,' ',apellido) like concat('%','" + buscar + "','%') ";
        }

        try {
            // Creación de la declaración y preparación de la consulta SQL
            Statement st = conexion.createStatement();

            ps = conexion.prepareStatement(sql);

            // Ejecución de la consulta y obtención del resultado
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // Cálculo del número total de páginas necesarias
                int totalPages = (int) Math.ceil((double) rs.getInt(1) / filasxPagina2);
                return totalPages;
            } else {
                // Si no se encontraron resultados, se devuelve 1 página
                return 1;
            }
        } catch (SQLException ex) {
            // Manejo de las excepciones de SQL
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }

    }

    // Método para mostrar la lista de clientes en la interfaz de CrearVentasClientes
    public static void MostrarClientes(String buscar, int paginaActual, int totalPages) {
        DefaultTableModel model = (DefaultTableModel) CrearVentasClientes.jtClientesVentas.getModel();

        // Eliminar filas existentes en la tabla
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }

        // Limpiar listas de IDs y clientes
        Ventas.ids2.clear();
        Ventas.clientes_ventas.clear();

        String sql = "";
        if (buscar.equals("")) {
            // Consulta SQL para listar todos los clientes con paginación
            sql = QuerysClientes.LISTARCLIENTES + " limit " + filasxPagina2 + " offset " + (paginaActual - 1) * filasxPagina2;

        } else {
            // Consulta SQL para buscar clientes por nombre o apellido con paginación
            sql = "select * from clientes  WHERE "
                    + "concat(nombre,' ',apellido) like concat('%','" + buscar + "','%') limit " + filasxPagina2 + " offset " + (paginaActual - 1) * filasxPagina2;
        }

        String datos[] = new String[7];

        try {
            // Crear una declaración y ejecutar la consulta SQL
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);

            int count = 0;
            // Calcular el número de la primera fila en la página actual
            if (paginaActual == 1) {
                count = 1;
            } else {
                for (int i = 1; i < paginaActual; i++) {
                    count += 5;
                }
                count += 1;
            }

            // Iterar sobre los resultados de la consulta
            while (rs.next()) {
                QuerysClientes clien = new QuerysClientes();
                // Llenar los datos del cliente en la tabla y en la lista de clientes
                datos[0] = count + "";
                datos[1] = rs.getString("nombre") + " " + rs.getString("apellido");
                datos[2] = rs.getString("telefono");

                clien.setId(rs.getInt("id"));
                clien.setNombre(rs.getString("nombre"));
                clien.setApellido(rs.getString("apellido"));
                clien.setDireccion(rs.getString("direccion"));

                Ventas.ids2.add(rs.getInt("id"));
                Ventas.clientes_ventas.add(clien);
                model.addRow(datos);

                count++;
            }

            // Calcular el número total de páginas y actualizar la etiqueta de seguimiento
            int totalRows = count - 1; // Restamos el encabezado de la tabla
            totalPages = (NumeroPagesClientes(buscar) == 0 && model.getRowCount() > 0) ? 1 : NumeroPagesClientes(buscar);
            paginaActual = model.getRowCount() == 0 ? 0 : paginaActual;
            CrearVentasClientes.seguimiento1.setText("Página " + paginaActual + " de " + totalPages);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.RIGHT);
            CrearVentasClientes.jtClientesVentas.setModel(model);
        } catch (SQLException ex) {
            // Manejar las excepciones de SQL
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static final int filasxPagina3 = 10;
    public static List ids3 = new ArrayList();
    public static List<QuerysInventarioProductos> inventarioProductoses = new ArrayList();

    // Método para calcular el número de páginas para la lista de productos en la interfaz de CrearVentasProductos
    public static int NumeroPagesProductos(String buscar) {
        String sql = "";
        if (buscar.isEmpty()) {
            // Consulta SQL para contar todos los productos
            sql = "SELECT count(*) from inventarioproductos";

        } else {
            // Consulta SQL para buscar productos por marca o nombre con paginación
            sql = "SELECT count(*) from inventarioproductos WHERE "
                    + " concat(marca,' ',producto) like concat('%','" + buscar + "','%') ";
        }

        try {
            // Crear una declaración y ejecutar la consulta SQL
            Statement st = conexion.createStatement();
            ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // Calcular el número total de páginas y devolverlo
                int totalPages = (int) Math.ceil((double) rs.getInt(1) / filasxPagina2);
                return totalPages;
            } else {
                return 1;
            }
        } catch (SQLException ex) {
            // Manejar las excepciones de SQL
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    // Método para mostrar el inventario de productos en la interfaz de CrearVentasProductos
    public static void MostrarInventario(String buscar, int paginaActual, int totalPages) {
        DefaultTableModel model = (DefaultTableModel) CrearVentasProductos.jtProductosVentas.getModel();

        // Limpiar la tabla antes de cargar nuevos datos
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }

        // Limpiar listas de identificadores y productos del inventario
        Ventas.ids3.clear();
        Ventas.inventarioProductoses.clear();

        String sql = "";
        if (buscar.equals("")) {
            // Consulta SQL para seleccionar todos los productos con paginación
            sql = "SELECT * from inventarioproductos limit " + filasxPagina2 + " offset " + (paginaActual - 1) * filasxPagina2;

        } else {
            // Consulta SQL para buscar productos por marca o nombre con paginación
            sql = "SELECT * from inventarioproductos WHERE "
                    + "concat(marca,' ',producto) like concat('%','" + buscar + "','%') limit " + filasxPagina2 + " offset " + (paginaActual - 1) * filasxPagina2;
        }

        String datos[] = new String[7];

        try {
            // Crear una declaración y ejecutar la consulta SQL
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);

            int count = 0;
            // Calcular el número de fila inicial en la página actual
            if (paginaActual == 1) {
                count = 1;
            } else {
                for (int i = 1; i < paginaActual; i++) {
                    count += 5;
                }
                count += 1;
            }

            // Recorrer los resultados de la consulta y agregar datos a la tabla
            while (rs.next()) {
                QuerysInventarioProductos inventarioProductos = new QuerysInventarioProductos();
                datos[0] = count + "";
                datos[1] = rs.getString("marca");
                datos[2] = rs.getString("producto");
                datos[3] = rs.getString("precio");
                datos[4] = rs.getString("precio_venta");
                datos[5] = rs.getString("cantidad");

                inventarioProductos.setId(rs.getInt("id"));
                inventarioProductos.setPrecio(rs.getDouble("precio"));
                inventarioProductos.setProducto(rs.getString("producto"));
                inventarioProductos.setCantidad(rs.getInt("cantidad"));
                inventarioProductos.setTipo_producto(rs.getString("tipo_producto"));

                Ventas.ids3.add(rs.getInt("id"));
                Ventas.inventarioProductoses.add(inventarioProductos);
                model.addRow(datos);

                count++;
            }
            int totalRows = count - 1; // Restar el encabezado de la tabla
            // Calcular el número total de páginas y la página actual
            totalPages = (NumeroPagesProductos(buscar) == 0 && model.getRowCount() > 0) ? 1 : NumeroPagesProductos(buscar);
            paginaActual = model.getRowCount() == 0 ? 0 : paginaActual;
            // Mostrar información de la página actual en el componente de seguimiento
            CrearVentasProductos.seguimiento1.setText("Página " + paginaActual + " de " + totalPages);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.RIGHT);
            CrearVentasProductos.jtProductosVentas.setModel(model);
        } catch (SQLException ex) {
            // Manejar las excepciones de SQL
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}
