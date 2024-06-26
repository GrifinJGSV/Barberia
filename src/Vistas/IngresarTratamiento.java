/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Conexion.Conexion;
import ConsultasSQL.QuerysTratamiento;
import ConsultasSQL.QuerysTratamientoProductos;
import Controlador.Tratamiento;
import static Controlador.Tratamiento.MostrarTratamientos;
import com.sun.jdi.connect.spi.Connection;
import java.awt.Event;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.InputMap;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 * @author Andrea Ardon
 * Fecha de creación: [02/11/2023] 
 * Descripción: esta ventana tiene el objetivo de Ingresar un tratamiento con sus especificaciones.
 * Derechos de autor (c) [02/11/2023] Andrea Ardón. Todos los derechos reservados.
 */

public class IngresarTratamiento extends javax.swing.JFrame {
    // Declara una variable para almacenar un flujo de entrada de archivo
    private FileInputStream fis;
    // Declara una variable para almacenar la longitud en bytes de un archivo
    private int longitudBytes;
    // Establece una conexión estática a la base de datos utilizando la clase de conexión "Conexion"
    private static Conexion con = new Conexion();
    private static java.sql.Connection conexion = con.getConexion();
    // Declara un PreparedStatement estático para ejecutar consultas SQL
    private static PreparedStatement ps = null;



    /**
     * Creates new form CrearCliente
     */
    public IngresarTratamiento() {
        // Inicializa los componentes de la interfaz de usuario
        initComponents();
        // Establece la ubicación de la ventana en el centro de la pantalla
        this.setLocationRelativeTo(null);
        
        //Codigo para bloquear el pegado en el campo txtNombre 
        InputMap map1 = txtNombre.getInputMap(JTextField.WHEN_FOCUSED);
        map1.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK),"null");
        
        //codigo para bloquear el pegado en el campo txtDescripcion
        InputMap map2 = txtDescripcion.getInputMap(JTextField.WHEN_FOCUSED);
        map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK),"null");
        
        //codigo para bloquear el pegado en el campo txtPrecio
        InputMap map3 = txtPrecio.getInputMap(JTextField.WHEN_FOCUSED);
        map3.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK),"null");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        Label_Foto1 = new javax.swing.JLabel();
        Label_Foto2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbxTipoTratamiento = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        BtnAgregarListado = new javax.swing.JButton();
        BtnLimpiarListado = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProductosDeTratamiento = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dubai", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Agregar tratamiento");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 230, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Nombre del tratamiento:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Descripción:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, -1, -1));

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 230, -1));

        btnGuardar.setBackground(new java.awt.Color(253, 253, 255));
        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(0, 0, 204));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/agregarN.jpg"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153)));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 590, 110, -1));

        btnCancelar.setBackground(new java.awt.Color(253, 253, 255));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(0, 0, 204));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153)));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 590, 110, 50));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Fotos:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, -1, -1));

        txtDescripcion.setColumns(20);
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setRows(5);
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txtDescripcion);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 230, 100));

        Label_Foto1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Label_Foto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_Foto1.setText("Foto 1");
        Label_Foto1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Label_Foto1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label_Foto1MouseClicked(evt);
            }
        });
        jPanel1.add(Label_Foto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, 190, 180));

        Label_Foto2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Label_Foto2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_Foto2.setText("Foto 2");
        Label_Foto2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Label_Foto2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label_Foto2MouseClicked(evt);
            }
        });
        jPanel1.add(Label_Foto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 320, 190, 180));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setText("Tipo de tratamiento:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        cbxTipoTratamiento.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cbxTipoTratamiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Capilares ", "Faciales" }));
        cbxTipoTratamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoTratamientoActionPerformed(evt);
            }
        });
        jPanel1.add(cbxTipoTratamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 230, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ListaodologoBarberia.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 0, 120, 100));

        BtnAgregarListado.setBackground(new java.awt.Color(253, 253, 255));
        BtnAgregarListado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnAgregarListado.setForeground(new java.awt.Color(0, 0, 204));
        BtnAgregarListado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/agregar productoN.jpg"))); // NOI18N
        BtnAgregarListado.setText("Agregar");
        BtnAgregarListado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153)));
        BtnAgregarListado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarListadoActionPerformed(evt);
            }
        });
        jPanel1.add(BtnAgregarListado, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 540, 110, -1));

        BtnLimpiarListado.setBackground(new java.awt.Color(253, 253, 255));
        BtnLimpiarListado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnLimpiarListado.setForeground(new java.awt.Color(0, 0, 204));
        BtnLimpiarListado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelarr.png"))); // NOI18N
        BtnLimpiarListado.setText("Limpiar");
        BtnLimpiarListado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153)));
        BtnLimpiarListado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimpiarListadoActionPerformed(evt);
            }
        });
        jPanel1.add(BtnLimpiarListado, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 540, 90, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setText("Listado de productos:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, -1));

        //hacer que la tabla no sea editabe
        tblProductosDeTratamiento.setFocusable(false);
        tblProductosDeTratamiento = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblProductosDeTratamiento.setAutoCreateRowSorter(true);
        tblProductosDeTratamiento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre del tratamiento", "Id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProductosDeTratamiento.setToolTipText("");
        tblProductosDeTratamiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosDeTratamientoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblProductosDeTratamiento);
        if (tblProductosDeTratamiento.getColumnModel().getColumnCount() > 0) {
            tblProductosDeTratamiento.getColumnModel().getColumn(1).setMinWidth(0);
            tblProductosDeTratamiento.getColumnModel().getColumn(1).setPreferredWidth(0);
            tblProductosDeTratamiento.getColumnModel().getColumn(1).setMaxWidth(0);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 340, 230, 190));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Precio:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, -1, -1));

        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });
        jPanel1.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 298, 120, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 872, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        //cierre de la ventana y libera recursos asociados
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed
    
    
// ...

    // Método para obtener el próximo ID disponible desde la base de datos
    private int obtenerProximoId() {
        int maxId = 0;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            

            // Crear la declaración SQL para obtener el máximo ID
            String sql = "SELECT MAX(id) FROM tratamientos";
            statement = conexion.createStatement();

            // Ejecutar la consulta y obtener el resultado
            resultSet = statement.executeQuery(sql);

            // Obtener el máximo ID
            if (resultSet.next()) {
                maxId = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Manejo adecuado de las excepciones en un entorno de producción
        } finally {
            // Cerrar recursos
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                // No cerramos la conexión aquí para que pueda ser reutilizada
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Incrementar el máximo ID para obtener el próximo ID disponible
        return maxId + 1;
    }
    
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
    String foto = Label_Foto1.getText().trim(); // Obtiene el texto del JLabel Label_Foto1 y lo almacena en una variable llamada foto
    String foto1 = Label_Foto2.getText().trim();// Obtiene el texto del JLabel Label_Foto2 y lo almacena en una variable llamada foto1
    String nombre = txtNombre.getText().trim();// Obtiene el texto del JTextField txtNombre y lo almacena en una variable llamada nombre
    String texto = txtPrecio.getText();//// Obtiene el texto del JTextField txtPrecio y lo almacena en una variable llamada texto
    
    // Obtiene el modelo de la tabla tblProductosDeTratamiento y lo almacena en una variable llamada model
    DefaultTableModel model = (DefaultTableModel) tblProductosDeTratamiento.getModel();
       // Verificar si la tabla está vacía
    if (model.getRowCount() == 0) {
        JOptionPane.showMessageDialog(null, "La tabla de productos está vacía", "Error de validación", JOptionPane.WARNING_MESSAGE);
        return; // Salir del método si la tabla está vacía
    }
    // Verifica si el campo de nombre del tratamiento está vacío
    if (nombre.isEmpty()) {
        // Si el campo está vacío, muestra un mensaje de advertencia al usuario
        JOptionPane.showMessageDialog(null, "El nombre del tratamiento no puede estar vacío", "Error de validación", JOptionPane.WARNING_MESSAGE);
        return; // Salir del método si el campo está vacío
    }
    //cantidad mínima de caracteres
    if (nombre.length() < 5 ) {
            JOptionPane.showMessageDialog(null, "El nombre debe de tener mas de 5 caracteres", "Error de validación", JOptionPane.WARNING_MESSAGE);
            return; // Salir del método
        }
    
    // Obtiene el tratamiento seleccionado del combo box cbxTipoTratamiento y lo convierte a una cadena
    String TipoTratamiento = cbxTipoTratamiento.getSelectedItem().toString(); // que no este vacio, que solo seleccione 1
    // Verifica si se ha seleccionado "seleccione un tratamiento"    
    if(TipoTratamiento.equals("seleccione un tratamiento")){
        // Si no se ha seleccionado ningún tratamiento, muestra un mensaje de advertencia al usuario 
        JOptionPane.showMessageDialog(this, "No ha seleccionado ningun tratamiento", "Error de validación", JOptionPane.INFORMATION_MESSAGE);
            return; // Salir del método si el campo está vacío
        }
        
        // Obtiene la dirección ingresada por el usuario y elimina los espacios en blanco al principio y al final
        String direccion = txtDescripcion.getText().trim();
    
        // Verifica si el campo de descripción está vacío
    if (direccion.isEmpty()) {
        // Si el campo está vacío, muestra un mensaje de advertencia al usuario
        JOptionPane.showMessageDialog(null, "La descripción no puede estar vacía", "Error de validación", JOptionPane.WARNING_MESSAGE);
        return; // Salir del método si el campo está vacío
    }
    
    // Verifica si la descripción contiene caracteres no válidos utilizando una expresión regular
    if (!direccion.matches("[a-zA-Z0-9áéíóúñÁÉÍÓÚÑ][a-zA-Z0-9 áéíóúñÁÉÍÓÚÑü.:;,-]+")) {
        // Verifica si la descripción tiene al menos un carácter
        if (direccion.length() > 0) {
            // Si se encuentra al menos un carácter no válido, muestra un mensaje de advertencia al usuario
            JOptionPane.showMessageDialog(null, "Alguno de los caracteres que ingresó en la descripción no es válido", "Error de validación", JOptionPane.WARNING_MESSAGE);
            return; // Salir del método
        }
    }
    //cantidad minima de caracteres
    // Verifica si la longitud de la descripción es menor que 10
    if (direccion.length() < 10 ) {
        // Muestra un mensaje de advertencia si la longitud de la descripción es menor que 10
            JOptionPane.showMessageDialog(null, "la descripción debe de ingresar mas de 10 caracteres", "Error de validación", JOptionPane.WARNING_MESSAGE);
            return; // Salir del método
        }
    // Verifica si el campo está vacío
    if(texto.isEmpty()){
        // Muestra un mensaje de advertencia si el campo de precio está vacío
            JOptionPane.showMessageDialog(null, "El precio no puede estar vacio", "Error de validación", JOptionPane.WARNING_MESSAGE);
            return;
        }
        // Intenta convertir el texto del campo de precio a un valor double
        double precio = Double.parseDouble(texto);
        
        try {
            // Verifica si el precio es mayor que 5999.99
            if(precio > 5999.99 ){
                // Muestra un mensaje de advertencia si el precio es demasiado alto
                JOptionPane.showMessageDialog(null, "El precio es demaciado alto", "Error de validación", JOptionPane.WARNING_MESSAGE);
                return;//sale del metodo
            }
        } catch (Exception e) { // Maneja cualquier excepción que pueda ocurrir al intentar convertir el texto del campo de precio a un valor double
        }
  
        // Validación de la imagen
       
       // ...

        // Obtener el próximo ID disponible
        int idTratamiento = obtenerProximoId();


        String estado="habilitado";
        
        QuerysTratamiento querysT = new QuerysTratamiento();
        QuerysTratamientoProductos querysTP = new QuerysTratamientoProductos();
        querysT.setNombre(nombre);
        querysT.setDescripcion(direccion);
        querysT.setTipoTratamiento(TipoTratamiento);
        querysT.setEstado(estado);
        querysT.setPrecio(precio);
        
            byte[] imagenBytes = obtenerBytesDeImagen(foto);
        byte[] imageBytes = obtenerBytesDeImage(foto1);
        if (imagenBytes != null) {
            querysT.setFoto1(imagenBytes);
            if(imageBytes != null){
                querysT.setFoto2(imageBytes);
            if (Tratamiento.GuardarT(querysT)) {
                for (int i = 0; i < model.getRowCount(); i++) {
                    // Obtener los datos de la fila actual

                    int productos = Integer.parseInt(model.getValueAt(i, 1).toString());
                    querysTP.setId_tratamientos(idTratamiento);
                    querysTP.setId_productos(productos);
                    Tratamiento.GuardarTP(querysTP); 

                }
                JOptionPane.showMessageDialog(null, "Nuevo tratamiento ingresado exitosamente");
                //MostrarTratamientos();
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Algo falló, consulte con el administrador del sistema", "Error al guardar", JOptionPane.OK_OPTION);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo cargar la imagen", "Error de validación", JOptionPane.WARNING_MESSAGE);
            } 
        }
        
   
    
    }//GEN-LAST:event_btnGuardarActionPerformed
  
 
    private byte[] obtenerBytesDeImagen(String rutaImagen) {
   
    File archivoImagen = new File(rutaImagen);
    
    // Verificar si el archivo de imagen existe
   if (!archivoImagen.exists()) {
        JOptionPane.showMessageDialog(null, "Debe selecionar una imagen", "Error de validación", JOptionPane.WARNING_MESSAGE);
        return null; // Retorna null si el archivo no existe
    }

    // Continuar con la carga de la imagen
    try {
        FileInputStream fis = new FileInputStream(archivoImagen);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = fis.read(buffer)) != -1) {
            bos.write(buffer, 0, bytesRead);
        }
        return bos.toByteArray();
    } catch (IOException e) {
        e.printStackTrace();
        return null; // Retorna null si hay un error al cargar la imagen
    }
}
    
     private byte[] obtenerBytesDeImage(String rutaImagen) {
   
    File archivoImagen = new File(rutaImagen);
    
    // Verificar si el archivo de imagen existe
   if (!archivoImagen.exists()) {
        JOptionPane.showMessageDialog(null, "Debe selecionar una imagen", "Error de validación", JOptionPane.WARNING_MESSAGE);
        return null; // Retorna null si el archivo no existe
    }

    // Continuar con la carga de la imagen
    try {
        FileInputStream fis = new FileInputStream(archivoImagen);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = fis.read(buffer)) != -1) {
            bos.write(buffer, 0, bytesRead);
        }
        return bos.toByteArray();
    } catch (IOException e) {
        e.printStackTrace();
        return null; // Retorna null si hay un error al cargar la imagen
    }
}
     private byte[] obtenerByteDeImagen (String rutaImagen) {
   
    File archivoImagen = new File(rutaImagen);
    
    // Verificar si el archivo de imagen existe
   if (!archivoImagen.exists()) {
        JOptionPane.showMessageDialog(null, "Debe selecionar una imagen", "Error de validación", JOptionPane.WARNING_MESSAGE);
        return null; // Retorna null si el archivo no existe
    }

    // Continuar con la carga de la imagen
    try {
        FileInputStream fis = new FileInputStream(archivoImagen);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = fis.read(buffer)) != -1) {
            bos.write(buffer, 0, bytesRead);
        }
        return bos.toByteArray();
    } catch (IOException e) {
        e.printStackTrace();
        return null; // Retorna null si hay un error al cargar la imagen
    }
}

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
    txtNombre.setText(txtNombre.getText().replaceAll("( )+", " "));
        if (txtNombre.getText().length() == 0 && evt.getKeyChar() == ' ') {
                    evt.consume();
        }      
        
        // Limitar la longitud a 30 caracteres
        if (txtNombre.getText().length() >= 30) {
            evt.consume();
        }
        
        char c = evt.getKeyChar();
        if(Character.isDigit(c)){
            getToolkit().beep();
            evt.consume();
        }
        
        // No permitir iniciar con espacios ni caracteres especiales
        if (txtNombre.getText().isEmpty() && (c == ' ' || !Character.isLetter(c))) {
            evt.consume();
            return;
        }
        
        // Permitir solo letras, espacios y borrar
        if (!Character.isLetter(c) && c != ' ' && c != '\b') {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyTyped
       txtDescripcion.setText(txtDescripcion.getText().replaceAll("( )+", " "));
        if (txtNombre.getText().length() == 0 && evt.getKeyChar() == ' ') {
                    evt.consume();
        }      
        
        // Limitar la longitud a 180 caracteres
        if (txtDescripcion.getText().length() >= 180) {
            evt.consume();
        }
        
        char c = evt.getKeyChar();
        if(Character.isDigit(c)){
            getToolkit().beep();
            evt.consume();
        }
        
        // No permitir iniciar con espacios ni caracteres especiales
        if (txtDescripcion.getText().isEmpty() && (c == ' ' || !Character.isLetter(c))) {
            evt.consume();
            return;
        }
        
        // Permitir solo letras, espacios y borrar
        if (!Character.isLetter(c) && c != ' ' && c != '\b') {
            getToolkit().beep();
            evt.consume();
        }
           
    }//GEN-LAST:event_txtDescripcionKeyTyped

    private void Label_Foto2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label_Foto2MouseClicked
          
    JFileChooser se = new JFileChooser();
    
    // Agregar un filtro para seleccionar solo archivos PNG
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Imágenes PNG", "jpg");
    se.setFileFilter(filter);
    
    se.setFileSelectionMode(JFileChooser.FILES_ONLY);
    int estado = se.showOpenDialog(null);

    if (estado == JFileChooser.APPROVE_OPTION) {
        try {
            File archivoSeleccionado = se.getSelectedFile();

            if (archivoSeleccionado != null) {
                String rutImagen = archivoSeleccionado.getAbsolutePath();
                byte[] imageBytes = obtenerBytesDeImagen(rutImagen);

                if (imageBytes != null) {
                    ImageIcon icono = new ImageIcon(imageBytes);
                    Image imagen = icono.getImage();

                    // Redimensionar la imagen para ajustar al tamaño del Label_Foto
                    int ancho = Label_Foto2.getWidth();
                    int alto = Label_Foto2.getHeight();
                    Image imagenRedimensionada = imagen.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);

                    // Crear un nuevo ImageIcon con la imagen redimensionada
                    ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);

                    // Mostrar la imagen en el componente Label_Foto
                    Label_Foto2.setIcon(iconoRedimensionado);
                    Label_Foto2.setText(rutImagen); // Actualiza el texto del Label con la ruta
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo cargar la imagen", "Error de validación", JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }//GEN-LAST:event_Label_Foto2MouseClicked

    private void Label_Foto1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label_Foto1MouseClicked

        JFileChooser se = new JFileChooser();

        // Agregar un filtro para seleccionar solo archivos PNG
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Imágenes PNG", "jpg");
        se.setFileFilter(filter);

        se.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = se.showOpenDialog(null);

        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                File archivoSeleccionado = se.getSelectedFile();

                if (archivoSeleccionado != null) {
                    String ruaImagen = archivoSeleccionado.getAbsolutePath();
                    byte[] imagenBytes = obtenerBytesDeImagen(ruaImagen);

                    if (imagenBytes != null) {
                        ImageIcon icono = new ImageIcon(imagenBytes);
                        Image imagen = icono.getImage();

                        // Redimensionar la imagen para ajustar al tamaño del Label_Foto
                        int ancho = Label_Foto1.getWidth();
                        int alto = Label_Foto1.getHeight();
                        Image imagenRedimensionada = imagen.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);

                        // Crear un nuevo ImageIcon con la imagen redimensionada
                        ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);

                        // Mostrar la imagen en el componente Label_Foto
                        Label_Foto1.setIcon(iconoRedimensionado);
                        Label_Foto1.setText(ruaImagen); // Actualiza el texto del Label con la ruta
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo cargar la imagen", "Error de validación", JOptionPane.WARNING_MESSAGE);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_Label_Foto1MouseClicked

    public static void agregarProductoAListado(String nombreProducto) {

    }
    
    private void BtnAgregarListadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarListadoActionPerformed
        ProductoParaTratamiento prod = new ProductoParaTratamiento();
        prod.setVisible(true);
        prod.setLocationRelativeTo(null);
    }//GEN-LAST:event_BtnAgregarListadoActionPerformed

    private void BtnLimpiarListadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimpiarListadoActionPerformed
        try {
            int filaSeleccionada = tblProductosDeTratamiento.getSelectedRow();

            // Si no hay fila seleccionada, preguntar si quiere borrar toda la tabla
            if (filaSeleccionada == -1) {
                int confirmacion = JOptionPane.showConfirmDialog(null, "¿Desea borrar toda la tabla?", "Confirmar", JOptionPane.YES_NO_OPTION);

                if (confirmacion == JOptionPane.YES_OPTION) {
                    // Borrar todas las filas de la tabla
                    DefaultTableModel modeloDestino = (DefaultTableModel) tblProductosDeTratamiento.getModel();
                    modeloDestino.setRowCount(0);
                    JOptionPane.showMessageDialog(null, "Se borraron todas las filas de la tabla.");
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una fila o confirme para borrar toda la tabla.", "Mensaje", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                // Si hay una fila seleccionada, borrar esa fila
                DefaultTableModel modeloDestino = (DefaultTableModel) tblProductosDeTratamiento.getModel();
                modeloDestino.removeRow(filaSeleccionada);
                JOptionPane.showMessageDialog(null, "Se borró la fila seleccionada.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_BtnLimpiarListadoActionPerformed

    private void tblProductosDeTratamientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosDeTratamientoMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            int filaSeleccionada = tblProductosDeTratamiento.getSelectedRow();
            if (filaSeleccionada >= 0) {
                String idTratamiento = (String) tblProductosDeTratamiento.getValueAt(filaSeleccionada, 0); // Supongo que el ID está en la primera columna.
                VerTratamiento verTratamiento = null;
                try {
                    verTratamiento = new VerTratamiento(idTratamiento);
                } catch (IOException ex) {
                    //Logger.getLogger(MostrarCortes.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, ex.toString());
                }
                verTratamiento.setVisible(true);
            }
        }

    }//GEN-LAST:event_tblProductosDeTratamientoMouseClicked

    private void cbxTipoTratamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoTratamientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTipoTratamientoActionPerformed

    
    
    
    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        // No permitir cero o punto al inicio
        if (txtPrecio.getText().isEmpty() && (c == '0' || c == '.')) {
            evt.consume(); // Ignorar cero o punto al inicio
        }

        // Verificar si es un número o un punto
        if (!(Character.isDigit(c) || (c == '.'))) {
            evt.consume(); // Ignorar el evento si no es un número o un punto
        }

        // Verificar si ya hay un punto y no permitir otro
        if (c == '.' && txtPrecio.getText().contains(".")) {
            evt.consume(); // Ignorar el evento si ya hay un punto
        }

        // No permitir espacios al inicio
        if (txtPrecio.getText().isEmpty() && Character.isWhitespace(c)) {
            evt.consume(); // Ignorar espacios al inicio
        }

        // Limitar a 6 dígitos en total y 2 dígitos después del punto
        String text = txtPrecio.getText();
        int dotIndex = text.indexOf('.');
        if (dotIndex != -1 && text.substring(dotIndex).length() >= 3) {
            evt.consume(); // Ignorar más de 2 dígitos después del punto
        } else if (text.length() >= 7) {
            evt.consume(); // Ignorar más de 6 caracteres en total
        }
    }//GEN-LAST:event_txtPrecioKeyTyped

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IngresarTratamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngresarTratamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngresarTratamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngresarTratamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngresarTratamiento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregarListado;
    private javax.swing.JButton BtnLimpiarListado;
    private javax.swing.JLabel Label_Foto1;
    private javax.swing.JLabel Label_Foto2;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    public static javax.swing.JComboBox<String> cbxTipoTratamiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable tblProductosDeTratamiento;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables

    
}
