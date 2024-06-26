/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Conexion.Conexion;
import ConsultasSQL.QuerysClientes;
import Controlador.Clientes;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Event;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.InputMap;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

/**
 * Nombre del archivo: EditarCliente.java
 * Autor: Alejandra Suárez
 * Fecha de creación: [20/09/2023]
 * Descripción: JFRame que contiene los campos necesarios para editar un cliente existente.
 * Derechos de autor (c) [20/09/2023] Alejandra Suárez. Todos los derechos reservados.
 */
public class EditarCliente extends javax.swing.JFrame {

    /**
     * Creates new form EditarCliente
     */
    private QuerysClientes cliente; 
    public EditarCliente(QuerysClientes cliente) {
        try {
            initComponents();
            this.cliente = cliente;
            this.setLocationRelativeTo(null);
            this.setLocationRelativeTo(null);
            Date fechaActual = new Date();
            
            

            // Crea una instancia de Calendar y la inicializa con la fecha actual
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fechaActual);

            // Resta 18 años
            calendar.add(Calendar.YEAR, -1);

            // Obtiene la nueva fecha
            Date nuevaFecha = calendar.getTime();
            jdFechaNa.setMaxSelectableDate(nuevaFecha);
            jdFechaNa.setDate(nuevaFecha);

            
            //Se establece los valores que trae el cliente seleccioando
            txtNombre.setText(cliente.getNombre());
            txtApellido.setText(cliente.getApellido());
            txtTelefono.setText(cliente.getTelefono());
            txtDireccion.setText(cliente.getDireccion());
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            jdFechaNa.setDate(formato.parse(cliente.getFechaNacimiento()));
        } catch (ParseException ex) {
            Logger.getLogger(EditarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                
        
        //código para bloquear el pegado en Nombre del producto.
        InputMap map1 = txtNombre.getInputMap(JTextField.WHEN_FOCUSED);
        map1.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK),"null");
        
        //código para bloquear el pegado en la marca.
        InputMap map2 = txtApellido.getInputMap(JTextField.WHEN_FOCUSED);
        map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK),"null");
        
        //código para bloquear el pegado en el tamaño
        InputMap map3 = txtTelefono.getInputMap(JTextField.WHEN_FOCUSED);
        map3.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK),"null");
        
        //código para bloquear el pegado en la descripcion
        InputMap map4 = txtDireccion.getInputMap( JTextArea.WHEN_FOCUSED);
        map4.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK),"null");
        
        //Desabilita el campo de escritura de selector de fecha
         ((JTextFieldDateEditor)jdFechaNa.getDateEditor()).setEditable(false);
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
        btnActualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDireccion = new javax.swing.JTextArea();
        jdFechaNa = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnActualizar.setBackground(new java.awt.Color(249, 253, 250));
        btnActualizar.setForeground(new java.awt.Color(0, 51, 153));
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/editarN.jpg"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(249, 253, 250));
        btnCancelar.setForeground(new java.awt.Color(0, 51, 153));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dubai", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Editar cliente");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Apellido:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Teléfono:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Dirección:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Fecha de nacimiento:");

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtApellido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });
        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });

        txtTelefono.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        txtDireccion.setColumns(20);
        txtDireccion.setLineWrap(true);
        txtDireccion.setRows(5);
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txtDireccion);

        jdFechaNa.setMaxSelectableDate(new java.util.Date(253370790113000L));
        jdFechaNa.setMinSelectableDate(new java.util.Date(-1483203487000L));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ListaodologoBarberia (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(121, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtNombre))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtApellido))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(33, 33, 33))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(18, 18, 18)
                                    .addComponent(jdFechaNa, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(121, 121, 121))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdFechaNa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed
    // Metodo de cierre del JFRAME
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed
    // Método para validar la entrada de texto en el campo de nombre
    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        char character = evt.getKeyChar();
        String currentText = txtNombre.getText();
        char keyPressed = evt.getKeyChar();
                if (!Character.isLetter(character) && character != ' ') {
                    evt.consume(); // Ignorar el evento de tecla
                     getToolkit().beep();
                }
        if(txtNombre.getText().length() >=30){
            evt.consume();
             getToolkit().beep();
        }
        
        //No deja que inicie con caracteres especiales, ni numeros ni espacios
        String regex = "^[A-Za-z].*";
        if (currentText.length() == 0 && !Pattern.matches(regex, String.valueOf(keyPressed))) {
            // Si el texto está vacío y el carácter presionado no es una letra, evita agregar el carácter al inicio.
            getToolkit().beep();
            evt.consume();
        }
                      

    }//GEN-LAST:event_txtNombreKeyTyped
   // Método para guardar lod nurvos cambios del cliente al presionar el botón "Actualizar"
    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        String telefono = txtTelefono.getText().trim();
       
        if(!telefono.matches("[0-9][0-9 -]+")) {//El codigo contiene caracteres diferentes se muestra el siguiente mensaje
            //mensaje de error 
            if(telefono.length()>0){
            JOptionPane.showMessageDialog(null, "Alguno de los caracteres que ingresó en el teléfono no es válido", "Error al guardar", 
                    JOptionPane.WARNING_MESSAGE);
            return;//sale del método
            }
            
        }
        
        String nombre = txtNombre.getText().trim();
        if(nombre.isEmpty()){
        JOptionPane.showMessageDialog(null, "El nombre del cliente no puede estar vacío","Error al guardar",
                    JOptionPane.WARNING_MESSAGE);
            return; // Salir del método si el campo está vacío
        }
        
        String apellido = txtApellido.getText().trim();
        if(apellido.isEmpty()){
        JOptionPane.showMessageDialog(null, "El apellido del cliente no puede estar vacío","Error al guardar",
                    JOptionPane.WARNING_MESSAGE);
            return; // Salir del método si el campo está vacío
        }
        
        
        if(telefono.isEmpty()){
        JOptionPane.showMessageDialog(null, "El teléfono del cliente no puede estar vacío","Error al guardar",
                    JOptionPane.WARNING_MESSAGE);
            return; // Salir del método si el campo está vacío
        }
        
        if (!telefono.matches("[2389]\\d{7}")) {
                        JOptionPane.showMessageDialog(null, "El número de teléfono debe empezar con 2, 3, 8 o 9", "Error al guardar", JOptionPane.ERROR_MESSAGE);
                        return; // Salir del método si el campo no cumple con el formato definido
                    }
        
        String direccion = txtDireccion.getText().trim();
        if(direccion.isEmpty()){
        JOptionPane.showMessageDialog(null, "La dirección del cliente no puede estar vacía","Error al guardar",
                    JOptionPane.WARNING_MESSAGE);
            return; // Salir del método si el campo está vacío
        }
         if(!direccion.matches("[a-zA-Z0-9áéíóúñÁÉÍÓÚÑ][a-zA-Z0-9 áéíóúñÁÉÍÓÚÑü.:;,-]+")){
             if(direccion.length()>0){
             JOptionPane.showMessageDialog(null, "Alguno de los caracteres que ingresó en la dirección no es válido", "Error al guardar", 
                    JOptionPane.WARNING_MESSAGE);
            return;// Salir del método si el campo no cumple con el formato definido
             }
         }
   
        
        if(jdFechaNa.getDate()==null){
            JOptionPane.showMessageDialog(null, "La fecha de nacimiento del cliente no puede estar vacía","Error al guardar",
                    JOptionPane.WARNING_MESSAGE);
            return; // Salir del método si el campo está vacío
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fechaNacimiento = simpleDateFormat.format(jdFechaNa.getDate());
       
        try {
            if(jdFechaNa.getDate().before(simpleDateFormat.parse("1923-01-01"))){
                JOptionPane.showMessageDialog(null, "La fecha de nacimiento no debe ser menor a 1923","Error al guardar",
                        JOptionPane.WARNING_MESSAGE);
                return; // Salir del método si el campo está vacío
            }
        } catch (ParseException ex) {
            Logger.getLogger(EditarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
          if (nombre.length() < 3) {
        JOptionPane.showMessageDialog(null, "El nombre del cliente debe tener al menos 3 letras", "Error de validación", JOptionPane.WARNING_MESSAGE);
        return; // Salir del método si el nombre es demasiado corto
    }
         if (apellido.length() < 3) {
        JOptionPane.showMessageDialog(null, "El apellido del cliente debe tener al menos 3 letras", "Error de validación", JOptionPane.WARNING_MESSAGE);
        return; // Salir del método si el apellido es demasiado corto
    }
           if (telefono.length() < 8) {
        JOptionPane.showMessageDialog(null, "El telefono debe tener al menos 8 numeros", "Error de validación", JOptionPane.WARNING_MESSAGE);
        return; // Salir del método si el telefono es demasiado corto
    }
            if (direccion.length() < 20) {
        JOptionPane.showMessageDialog(null, "La direccion debe tener al menos 20 letras", "Error de validación", JOptionPane.WARNING_MESSAGE);
        return; // Salir del método si la direccion es demasiado corto
    }
        
         
            
         QuerysClientes querys = new QuerysClientes();
         querys.setId(this.cliente.getId());
         querys.setNombre(nombre);
         querys.setApellido(apellido);
         querys.setTelefono(telefono);
         querys.setDireccion(direccion);
         querys.setFechaNacimiento(fechaNacimiento);
         SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
         String fechaRegistrar = simpleDate.format(new Date());
         querys.setFechaRegistro(fechaRegistrar);
         
         if (Clientes.Actualizar(querys)) {
                JOptionPane.showMessageDialog(null, "Cliente editado exitosamente");
                int paginaAct = 1;
                Clientes.MostrarClientes("", paginaAct,MostrarClientes.totalPages);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Algo falló, consulte con el administrador del sistema", "Error al guardar", 
                    JOptionPane.OK_OPTION);
         }
    }//GEN-LAST:event_btnActualizarActionPerformed
 // Método para validar la entrada de texto en el campo de apellido
    private void txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyTyped
        char character = evt.getKeyChar();
        String currentText = txtApellido.getText();
        char keyPressed = evt.getKeyChar();
                if (!Character.isLetter(character) && character != ' ') {
                    evt.consume(); // Ignorar el evento de tecla
                     getToolkit().beep();
                }
        if(txtApellido.getText().length() >=30){
            evt.consume();
             getToolkit().beep();
        }
        
        //No deja que inicie con caracteres especiales, ni numeros ni espacios
        String regex = "^[A-Za-z].*";
        if (currentText.length() == 0 && !Pattern.matches(regex, String.valueOf(keyPressed))) {
            // Si el texto está vacío y el carácter presionado no es una letra, evita agregar el carácter al inicio.
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtApellidoKeyTyped
// Método para validar la entrada de texto en el campo de teléfono
    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        char character = evt.getKeyChar();
                if (!Character.isDigit(character)) {
                    evt.consume(); // Ignorar el evento de tecla
                     getToolkit().beep();
                }
        if(txtTelefono.getText().length() >=8){
            evt.consume();
             getToolkit().beep();
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped
// Método para validar la entrada de texto en el campo de dirección
    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
        String currentText = txtDireccion.getText();
        char keyPressed = evt.getKeyChar();
        
        if(txtDireccion.getText().length() >=255){
            evt.consume();
             getToolkit().beep();
        }
        
        //No deja que inicie con caracteres especiales, ni numeros ni espacios
        String regex = "^[A-Za-z].*";
        if (currentText.length() == 0 && !Pattern.matches(regex, String.valueOf(keyPressed))) {
            // Si el texto está vacío y el carácter presionado no es una letra, evita agregar el carácter al inicio.
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtDireccionKeyTyped

    /**
     * Funiones por defecto que prueban la edicion sin presionar un registro en la tabla
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
            java.util.logging.Logger.getLogger(EditarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Conexion con = new Conexion();
                Connection conexion = con.getConexion();
                QuerysClientes cliente = new QuerysClientes();
                 try {
            Statement st = (Statement)conexion.createStatement();
            ResultSet rs = st.executeQuery("select * from clientes limit 1");

           
            while (rs.next()) {
                
                    cliente.setNombre(rs.getString("nombre")); // Número de orden
                    cliente.setApellido(rs.getString("apellido"));
                    cliente.setTelefono(rs.getString("telefono"));
                    cliente.setDireccion(rs.getString("direccion"));
                    cliente.setFechaNacimiento(rs.getString("FechaNacimiento"));
                    cliente.setFechaRegistro(rs.getString("FechaRegistro"));
                    cliente.setId(rs.getInt("id"));
                    
                
            }

            

        } catch (Exception e) {
            e.printStackTrace();
        }
                new EditarCliente(cliente).setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdFechaNa;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextArea txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
