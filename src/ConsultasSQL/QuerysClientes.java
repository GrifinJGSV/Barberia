/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConsultasSQL;

/**
 * Nombre del archivo: QuerysClientes.java
 * Autor: Alejandra Suárez
 * Fecha de creación: [20/09/2023]
 * Descripción: Esta es la clase objeto de cliente para uso en las diferentes funciones en el codigo.
 * Derechos de autor (c) [20/09/2023] Alejandra Suárez. Todos los derechos reservados.
 */


public class QuerysClientes {
    // Se define una constante de tipo String llamada LISTARCLIENTES que contiene una consulta SQL para listar todos los clientes en la tabla clientes.
    public static String LISTARCLIENTES = "select * from clientes ";
    // Se declaran variables de instancia para representar los atributos de un cliente.
    private int id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    private String fechaNacimiento;
    private String fechaRegistro;


    // Métodos getter y setter para cada atributo...
    
    // Método getter para obtener el ID del cliente.
    public int getId() {
        return id;
    }
    
    // Método setter para establecer el ID del cliente.
    public void setId(int id) {
        this.id = id;
    }
    
    // Método getter para obtener el nombre del cliente.
    public String getNombre() {
        return nombre;
    }
    
    // Método setter para establecer el nombre del cliente.
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    // Método getter para obtener el apellido del cliente.
    public String getApellido() {
        return apellido;

    }
    // Método setter para establecer el apellido del cliente.
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    // Método getter para obtener el telefono del cliente.
    public String getTelefono() {
        return telefono;
    }
    // Método setter para establecer el telefono del cliente.
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    // Método getter para obtener la direccion del cliente.
    public String getDireccion() {
        return direccion;
    }
    // Método setter para establecer la direccion del cliente.
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    // Método getter para obtener la fecha nacimiento del cliente.
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
    // Método setter para establecer la fecha nacimiento.
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    // Método getter para obtener la fecha nacimiento del cliente.
    public String getFechaRegistro() {
        return fechaRegistro;
    }
    // Método setter para establecer la fecha nacimiento.
    public void setFechaRegistro(String FechaRegistro) {
        this.fechaRegistro = FechaRegistro;
    }

    
    // Consulta SQL para registrar un nuevo cliente en la tabla clientes.
    public static String RegistrarClientes = "INSERT INTO clientes (" + "nombre," + "apellido," + "telefono," + "direccion," + "fechaNacimiento," + "fechaRegistro"
            + ")" + "VALUES(?,?,?,?,?,?)";
    
    // Método para generar una consulta SQL de búsqueda de clientes por su nombre.
    public String Busqueda(String textBusqueda) {
        String query = "SELECT * FROM clientes p WHERE p.nombre LIKE '%" + textBusqueda + "%'";
        return query;
    }
    
    // Consulta SQL para actualizar los datos de un cliente en la tabla clientes.
    public static String ActualizarClientes = "UPDATE clientes set nombre=?, apellido=?, telefono=?, direccion=?, fechaNacimiento=?,"
            + "fechaRegistro=? where clientes.id=?";
    
    // Consulta SQL para seleccionar un cliente de la tabla clientes por su ID.
    public static String TraerCliente = "SELECT * from clientes where clientes.id=?";
}
