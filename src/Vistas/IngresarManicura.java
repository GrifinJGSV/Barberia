/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import ConsultasSQL.QuerysManicura;
import Controlador.Manicura;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import Vistas.Mostrarmanicuraypedicura;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Nombre del archivo: IngresarManicura.java
 * Autor: Josue Gabriel Sevilla 
 * Fecha de creación: [20/10/2023] 
 * Descripción: Este panel se encarga de editar los datos de una manicura previamente ingresada.
 * Derechos de autor (c) [20/10/2023] Josue gabriel sevilla. Todos los derechos reservados.
 * 
 * 
 */


public class IngresarManicura extends javax.swing.JFrame {
    
    private FileInputStream fis;
    private int longitudBytes;
    
    

    /**
     * Creates new form CrearCliente
     */
    public IngresarManicura() {
        initComponents();
        this.setLocationRelativeTo(null);
        
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDireccion = new javax.swing.JTextArea();
        Label_Foto1 = new javax.swing.JLabel();
        Label_Foto2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbxCategoria = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbxEsmalte = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dubai", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Agregar manicura o pedicura");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Estilo:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Precio:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Descripción:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, -1, -1));

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
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 230, -1));

        txtPrecio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });
        jPanel1.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 230, -1));

        btnGuardar.setBackground(new java.awt.Color(253, 253, 255));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 620, -1, -1));

        btnCancelar.setBackground(new java.awt.Color(253, 253, 255));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 620, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Diseño:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, -1, -1));

        txtDireccion.setColumns(20);
        txtDireccion.setLineWrap(true);
        txtDireccion.setRows(5);
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDireccionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txtDireccion);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, -1, 100));

        Label_Foto1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Label_Foto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_Foto1.setText("Foto 1");
        Label_Foto1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Label_Foto1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label_Foto1MouseClicked(evt);
            }
        });
        jPanel1.add(Label_Foto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 200, 180));

        Label_Foto2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Label_Foto2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_Foto2.setText("Foto 2");
        Label_Foto2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Label_Foto2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label_Foto2MouseClicked(evt);
            }
        });
        jPanel1.add(Label_Foto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 410, 190, 180));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setText("Técnica:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, -1, -1));

        cbxCategoria.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cbxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Uñas acrílicas", "Uñas de gel", "Uñas de fibra de vidrio", "Decoraciones 3D", "Esmalte semipermanente", "Manicura francesa", "Otra cosa" }));
        jPanel1.add(cbxCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 230, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ListaodologoBarberia.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, 100, 120));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel11.setText("Esmaltado:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, -1, -1));

        cbxEsmalte.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cbxEsmalte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acabado ballerina", "Acabado stiletto", "Almendrado", "Acabado cuadrado", "Decoracion natural", "Enpiedrado", "Efecto espejo", "Efecto Sugar", "Efecto Jersey", "Baby boomer" }));
        jPanel1.add(cbxEsmalte, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 230, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
    String foto = Label_Foto1.getText().trim();
    String foto1 = Label_Foto2.getText().trim();
    
    String nombre = txtNombre.getText().trim();
    
    if (nombre.isEmpty()) {
        JOptionPane.showMessageDialog(null, "El nombre del estilo no puede estar vacío", "Error de validación", JOptionPane.WARNING_MESSAGE);
        return; // Salir del método si el campo está vacío
    }
    
    
    String genero = cbxCategoria.getSelectedItem().toString(); // que no este vacio, que solo seleccione 1
        if(genero.equals("seleccione un sexo")){
         JOptionPane.showMessageDialog(this, "No ha seleccionado ninguna tecnica", "Error de validación", JOptionPane.INFORMATION_MESSAGE);
            return; // Salir del método si el campo está vacío
        }
    String esmalte = cbxEsmalte.getSelectedItem().toString(); // que no este vacio, que solo seleccione 1
        if(esmalte.equals("seleccione un esmaltado")){
         JOptionPane.showMessageDialog(this, "No ha seleccionado ninguna esmaltado", "Error de validación", JOptionPane.INFORMATION_MESSAGE);
            return; // Salir del método si el campo está vacío
        }
    String valor = txtPrecio.getText().trim(); 
    if (valor.isEmpty()) {
        JOptionPane.showMessageDialog(null, "El precio está vacío", "Error de validación", JOptionPane.WARNING_MESSAGE);
        return; // Salir del método si el campo está vacío
    }
    
        double precio = Double.parseDouble(valor);       
        if (precio <= 0) {
            JOptionPane.showMessageDialog(this, "El precio debe ser un número mayor que cero", "Error de validación", JOptionPane.WARNING_MESSAGE);
            return; // Salir del método si el precio no es válido
        }
        String direccion = txtDireccion.getText().trim();
    
    if (direccion.isEmpty()) {
        JOptionPane.showMessageDialog(null, "La descripción de la manicura o pedicura no puede estar vacía", "Error de validación", JOptionPane.WARNING_MESSAGE);
        return; // Salir del método si el campo está vacío
    }
    
    if (!direccion.matches("[a-zA-Z0-9áéíóúñÁÉÍÓÚÑ][a-zA-Z0-9 áéíóúñÁÉÍÓÚÑü.:;,-]+")) {
        if (direccion.length() > 0) {
            JOptionPane.showMessageDialog(null, "Alguno de los caracteres que ingresó en la descripción no es válido", "Error de validación", JOptionPane.WARNING_MESSAGE);
            return; // Salir del método
        }
    }
    
    if (foto.isEmpty() || foto1.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Debe seleccionar ambas imágenes", "Error de validación", JOptionPane.WARNING_MESSAGE);
        return; // Salir del método si una o ambas imágenes no se han seleccionado
    }
        
    // Comprueba si la conexión a la base de datos está establecida
    
        // La conexión está activa y válida, puedes proceder con la operación
        QuerysManicura querys = new QuerysManicura();
        querys.setEstilo(nombre);
        querys.setPrecio(precio);
        querys.setTecnica(genero);
        
       byte[] imagenBytes = obtenerBytesDeImagen(foto);
        byte[] imageBytes = obtenerBytesDeImagen(foto1);
        if (nombre.length() < 10) {
        JOptionPane.showMessageDialog(null, "El nombre del estilo debe tener al menos 10 letras", "Error de validación", JOptionPane.WARNING_MESSAGE);
        return; // Salir del método si el nombre es demasiado corto
    }
       

        if (imagenBytes != null && imageBytes != null) {
        querys.setFoto(imagenBytes);
        querys.setFoto1(imageBytes);
             } else {
             JOptionPane.showMessageDialog(null, "debe cargar ambas imágenes", "Error de validación", JOptionPane.WARNING_MESSAGE);
             return; // Salir del método si una o ambas imágenes no se pudieron cargar
        }
        
        querys.setEsmaltado(esmalte);
        querys.setDescripcion(direccion);
         if (direccion.length() < 10) {
        JOptionPane.showMessageDialog(null, "La descripción debe tener al menos 10 letras", "Error de validación", JOptionPane.WARNING_MESSAGE);
        return; // Salir del método si el nombre es demasiado corto
    }
          if (direccion.length() < 10) {
        JOptionPane.showMessageDialog(null, "La descripción debe tener al menos 10 letras", "Error de validación", JOptionPane.WARNING_MESSAGE);
        return; // Salir del método si el nombre es demasiado corto
    }
        
        if (Manicura.Guardar(querys)) {
            JOptionPane.showMessageDialog(null, "Nueva manicura o pedicura ingresada exitosamente");
            Manicura.Mostrarmanicuraypedicura("", NORMAL, ALLBITS);
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Algo falló, consulte con el administrador del sistema", "Error al guardar", JOptionPane.OK_OPTION);
        }
    
      
    }//GEN-LAST:event_btnGuardarActionPerformed
  
 
    private byte[] obtenerBytesDeImagen(String rutaImagen) {
   File archivoImagen = new File(rutaImagen);

    // Verificar si el archivo de imagen existe
    if (!archivoImagen.exists()) {
       // JOptionPane.showMessageDialog(null, "Debe seleccionar una imagen", "Error de validación", JOptionPane.WARNING_MESSAGE);
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
       // JOptionPane.showMessageDialog(null, "Debe selecionar la imágen", "Error de validación", JOptionPane.WARNING_MESSAGE);
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

    char c = evt.getKeyChar();
    if (!Character.isDigit(c)) {
        // Si el carácter no es un dígito, verifica otras condiciones
        int tam = txtNombre.getText().length();
        if (tam >= 30) {
            evt.consume();
        } else if ((int) evt.getKeyChar() > 32 && (int) evt.getKeyChar() <= 47
                || (int) evt.getKeyChar() >= 58 && (int) evt.getKeyChar() <= 64
                || (int) evt.getKeyChar() >= 91 && (int) evt.getKeyChar() <= 96
                || (int) evt.getKeyChar() >= 123 && (int) evt.getKeyChar() <= 159
                || (int) evt.getKeyChar() >= 166 && (int) evt.getKeyChar() <= 255) {
            getToolkit().beep();
            evt.consume();
        }
    }
    }//GEN-LAST:event_txtNombreKeyTyped

     

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
          // Obtener el texto actual en el campo txtValor
    String currentText = txtPrecio.getText();

    // Obtener el carácter que se intenta agregar
    char newChar = evt.getKeyChar();

    // Si el campo está vacío y se intenta ingresar '0', no permitirlo
    if (currentText.isEmpty() && newChar == '0') {
        evt.consume(); // No permitir el ingreso del carácter
        return;
    }

    // Si el campo está vacío y se intenta ingresar '.', no permitirlo
    if (currentText.isEmpty() && newChar == '.') {
        evt.consume(); // No permitir el ingreso del carácter
        return;
    }

    // Si el nuevo carácter es un '.', verificar que no se haya ingresado otro previamente
    if (newChar == '.') {
        if (currentText.contains(".")) {
            evt.consume(); // No permitir el ingreso de otro punto
            return;
        }
    }

    // Comprobar si el nuevo carácter es un dígito
    if (!Character.isDigit(newChar) && newChar != '.') {
        getToolkit().beep();
        evt.consume(); // No permitir el ingreso del carácter
    }

    // Comprobar si la longitud del texto supera el límite de 10 caracteres
    if (currentText.length() >= 3) {
        evt.consume(); // No permitir seguir escribiendo en el campo
    }
    
    }//GEN-LAST:event_txtPrecioKeyTyped

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
        txtDireccion.setText(txtDireccion.getText().replaceAll("( )+", " "));
    if (txtDireccion.getText().length() == 0 && evt.getKeyChar() == ' ') {
        evt.consume();
    }

    char c = evt.getKeyChar();
    if (!Character.isDigit(c)) {
        // Si el carácter no es un dígito, verifica otras condiciones
        int tam = txtDireccion.getText().length();
        if (tam >= 180) {
            evt.consume();
        } else if ((int) evt.getKeyChar() > 32 && (int) evt.getKeyChar() <= 47
                || (int) evt.getKeyChar() >= 58 && (int) evt.getKeyChar() <= 64
                || (int) evt.getKeyChar() >= 91 && (int) evt.getKeyChar() <= 96
                || (int) evt.getKeyChar() >= 123 && (int) evt.getKeyChar() <= 159
                || (int) evt.getKeyChar() >= 166 && (int) evt.getKeyChar() <= 255) {
            getToolkit().beep();
            evt.consume();
        }
    }
    }//GEN-LAST:event_txtDireccionKeyTyped

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

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
         if (evt.getKeyCode() == KeyEvent.VK_V && (evt.getModifiers() & KeyEvent.CTRL_MASK) != 0) {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable contents = clipboard.getContents(null);

        if (contents != null && contents.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            evt.consume(); // Consumir el evento para evitar que se pegue el texto
        }
    }
    }//GEN-LAST:event_txtNombreKeyPressed

    private void txtPrecioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_V && (evt.getModifiers() & KeyEvent.CTRL_MASK) != 0) {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable contents = clipboard.getContents(null);

        if (contents != null && contents.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            evt.consume(); // Consumir el evento para evitar que se pegue el texto
        }
    }
    }//GEN-LAST:event_txtPrecioKeyPressed

    private void txtDireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyPressed
       if (evt.getKeyCode() == KeyEvent.VK_V && (evt.getModifiers() & KeyEvent.CTRL_MASK) != 0) {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable contents = clipboard.getContents(null);

        if (contents != null && contents.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            evt.consume(); // Consumir el evento para evitar que se pegue el texto
        }
    }
    }//GEN-LAST:event_txtDireccionKeyPressed

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
            java.util.logging.Logger.getLogger(IngresarManicura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngresarManicura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngresarManicura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngresarManicura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngresarManicura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label_Foto1;
    private javax.swing.JLabel Label_Foto2;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    public static javax.swing.JComboBox<String> cbxCategoria;
    public static javax.swing.JComboBox<String> cbxEsmalte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables

    private static class SQLException {

        public SQLException() {
        }
    }

    
}
