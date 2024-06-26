package Vistas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.prompt.PromptSupport;

/**
 * @author Andrea Ardon
 * Fecha de creación: [23/10/2023] 
 * Descripción: este panel muestra el listado del mobiliario y equipo de la barberia,
 * cuenta con el acceso a crear, editar y ver los detalles del mobiliario o el equipo.
 * Derechos de autor (c) [23/10/2023] Andrea Ardón. Todos los derechos reservados.
 */
public class MostrarMobiliarioyEquipo extends javax.swing.JPanel {

    private int paginaActual = 1;
    public static int totalPages ;
    
    public MostrarMobiliarioyEquipo() {
        // Inicializa los componentes de la interfaz de usuario
        initComponents();
        // Evita que se reordene las columnas de la tabla mediante la cabecera
        tblMostrarMobiliarioyEquipo.getTableHeader().setReorderingAllowed(false);
        // Llama a un método para mostrar Mobiliario y Equipo con ciertos parámetros
        Controlador.MobiliarioYEquipo.MostrarMobiliarioyEquipo("", paginaActual, totalPages, ListadoEstado.getModel().getSelectedItem().toString());
        // Establece un mensaje de sugerencia para el campo de búsqueda
        PromptSupport.setPrompt("Buscar por el nombre", txtbusqueda);
    
        //evento para la abrir la ventana ver detalles de mobiliario y equipo
        tblMostrarMobiliarioyEquipo.addMouseListener(new MouseAdapter(){
        public void mouseClicked(MouseEvent e){
            if (e.getClickCount()==2){
            int fila= tblMostrarMobiliarioyEquipo.getSelectedRow();
                    verMobiliarioyEquipo VerMobiliarioyEquipo = new verMobiliarioyEquipo();
                    
                    VerMobiliarioyEquipo.txtNombreMob.setText(tblMostrarMobiliarioyEquipo.getValueAt(fila, 1).toString());
                    VerMobiliarioyEquipo.txtCantidad.setText(tblMostrarMobiliarioyEquipo.getValueAt(fila, 2).toString());
                    VerMobiliarioyEquipo.txtEstado.setText(tblMostrarMobiliarioyEquipo.getValueAt(fila, 3).toString());
                    VerMobiliarioyEquipo.txtaDescripcion.setText(tblMostrarMobiliarioyEquipo.getValueAt(fila, 4).toString());
                    VerMobiliarioyEquipo.txtfecha.setText(tblMostrarMobiliarioyEquipo.getValueAt(fila, 5).toString());
                    VerMobiliarioyEquipo.setVisible(true);
            }
        }
        
        });
    
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMostrarMobiliarioyEquipo = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Previo = new javax.swing.JButton();
        siguiente = new javax.swing.JButton();
        seguimiento = new javax.swing.JLabel();
        txtbusqueda = new javax.swing.JTextField();
        ListadoEstado = new javax.swing.JComboBox<>();

        setPreferredSize(new java.awt.Dimension(1000, 500));

        jPanel1.setBackground(new java.awt.Color(253, 253, 253));

        tblMostrarMobiliarioyEquipo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblMostrarMobiliarioyEquipo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Núm.", "Nombre", "Cantidad", "Estado", "Descripción", "Fecha de adquisición", "id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblMostrarMobiliarioyEquipo);
        if (tblMostrarMobiliarioyEquipo.getColumnModel().getColumnCount() > 0) {
            tblMostrarMobiliarioyEquipo.getColumnModel().getColumn(0).setMinWidth(50);
            tblMostrarMobiliarioyEquipo.getColumnModel().getColumn(0).setMaxWidth(50);
            tblMostrarMobiliarioyEquipo.getColumnModel().getColumn(2).setMinWidth(75);
            tblMostrarMobiliarioyEquipo.getColumnModel().getColumn(2).setMaxWidth(75);
            tblMostrarMobiliarioyEquipo.getColumnModel().getColumn(3).setMinWidth(150);
            tblMostrarMobiliarioyEquipo.getColumnModel().getColumn(3).setMaxWidth(150);
            tblMostrarMobiliarioyEquipo.getColumnModel().getColumn(4).setMinWidth(0);
            tblMostrarMobiliarioyEquipo.getColumnModel().getColumn(4).setMaxWidth(0);
            tblMostrarMobiliarioyEquipo.getColumnModel().getColumn(5).setMinWidth(150);
            tblMostrarMobiliarioyEquipo.getColumnModel().getColumn(5).setMaxWidth(150);
            tblMostrarMobiliarioyEquipo.getColumnModel().getColumn(6).setMinWidth(0);
            tblMostrarMobiliarioyEquipo.getColumnModel().getColumn(6).setMaxWidth(0);
        }

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ListaodologoBarberia (1).png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setText("Listado de mobiliario y equipo");

        btnAgregar.setBackground(new java.awt.Color(255, 255, 248));
        btnAgregar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/agregarN.jpg"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(255, 255, 248));
        btnEditar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/editarN.jpg"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lupa.jpg"))); // NOI18N
        jLabel3.setText("Buscar");

        Previo.setBackground(new java.awt.Color(255, 255, 248));
        Previo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes proyecto/atras.jpg"))); // NOI18N
        Previo.setBorder(null);
        Previo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrevioActionPerformed(evt);
            }
        });

        siguiente.setBackground(new java.awt.Color(255, 255, 248));
        siguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes proyecto/adelante.jpg"))); // NOI18N
        siguiente.setBorder(null);
        siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteActionPerformed(evt);
            }
        });

        seguimiento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        seguimiento.setText("Página :");

        txtbusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbusquedaKeyReleased(evt);
            }
        });

        ListadoEstado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ListadoEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Nuevo", "Usado", "Mal estado", "Inhabilitado" }));
        ListadoEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListadoEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ListadoEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(245, 245, 245)
                                .addComponent(jLabel2))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(15, 15, 15))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Previo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(siguiente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(seguimiento)
                        .addGap(235, 235, 235)))
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(65, 65, 65)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(btnEditar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel2)
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(ListadoEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(seguimiento)
                        .addContainerGap(41, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(siguiente)
                            .addComponent(Previo))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // Crea una instancia de EditarMobiliarioyEquipo
        EditarMobiliarioyEquipo mostradatos = new EditarMobiliarioyEquipo();
         // Obtiene la fila seleccionada en la tabla
          int fila = tblMostrarMobiliarioyEquipo.getSelectedRow();  
        // Verifica si se ha seleccionado alguna fila
        if (fila>=0){
        // Copia los datos de la fila seleccionada a los campos de entrada en EditarMobiliarioyEquipo    
        mostradatos.txtid.setText(tblMostrarMobiliarioyEquipo.getValueAt(fila, 0).toString());   // aqui se agrego esto
        mostradatos.txtnombre.setText(tblMostrarMobiliarioyEquipo.getValueAt(fila, 1).toString());
        mostradatos.txtcantidad.setText(tblMostrarMobiliarioyEquipo.getValueAt(fila, 2).toString());
        mostradatos.jCBestado.setSelectedItem(tblMostrarMobiliarioyEquipo.getValueAt(fila, 3).toString());
        mostradatos.txtAdescripcion.setText(tblMostrarMobiliarioyEquipo.getValueAt(fila, 4).toString());
        try{
            // Obtiene y formatea la fecha de la fila seleccionada y la establece 
            //en el campo de fecha en EditarMobiliarioyEquipo
                String fechaString = tblMostrarMobiliarioyEquipo.getValueAt(fila, 5).toString();
                SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
                Date fechas = sdf.parse(fechaString);
                EditarMobiliarioyEquipo.fecha.setDate(fechas);
            }catch(ParseException e){
                e.printStackTrace();
            }
      //muestra la ventana de edición
       mostradatos.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No ha selecionado ningun mobiliario  para editar", "Error al seleccionar el mobiliario", JOptionPane.INFORMATION_MESSAGE);
         }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void PrevioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrevioActionPerformed
        // Verifica si hay una página anterior disponible
        if (paginaActual > 1) {
            // Decrementa el número de página actual
            paginaActual--;
            // Actualiza la lista mostrada en la interfaz de usuario utilizando el método correspondiente del controlador
            Controlador.MobiliarioYEquipo.MostrarMobiliarioyEquipo(txtbusqueda.getText(), paginaActual, totalPages,ListadoEstado.getModel().getSelectedItem().toString());
        }
    }//GEN-LAST:event_PrevioActionPerformed

    private void ListadoEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListadoEstadoActionPerformed
        // Obtiene el valor seleccionado del componente de lista desplegable
        String  valor= ListadoEstado.getModel().getSelectedItem().toString();
        // Actualiza la lista de mobiliario y equipo del valor seleccionado como parámetro
        Controlador.MobiliarioYEquipo.MostrarMobiliarioyEquipo(txtbusqueda.getText(), paginaActual, totalPages,valor);
    }//GEN-LAST:event_ListadoEstadoActionPerformed

    private void siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteActionPerformed
         // Calcula el número total de páginas disponibles utilizando el método correspondiente del controlador
        totalPages = Controlador.MobiliarioYEquipo.NumeroPages(txtbusqueda.getText(), paginaActual,ListadoEstado.getModel().getSelectedItem().toString());
         // Verifica si hay una página siguiente disponible
        if (paginaActual < totalPages) {
            // Incrementa el número de página actual
            paginaActual++;
            // Actualiza la lista de mobiliario y equipo mostrada en la interfaz de usuario utilizando el método correspondiente del controlador
            Controlador.MobiliarioYEquipo.MostrarMobiliarioyEquipo(txtbusqueda.getText(), paginaActual, totalPages,ListadoEstado.getModel().getSelectedItem().toString());
        }
    }//GEN-LAST:event_siguienteActionPerformed

    private void txtbusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbusquedaKeyReleased
        // Obtiene el texto ingresado por el usuario en el campo de búsqueda
        String textoBusqueda = txtbusqueda.getText();
        // Actualiza la lista de mobiliario y equipo mostrada en la interfaz de usuario utilizando el texto de búsqueda como parámetro
          Controlador.MobiliarioYEquipo.MostrarMobiliarioyEquipo(textoBusqueda, paginaActual, totalPages,ListadoEstado.getModel().getSelectedItem().toString());
    }//GEN-LAST:event_txtbusquedaKeyReleased

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // Crea una instancia de la ventana de creación de mobiliario y equipo
        CrearMobiliarioyEquipo mobiliario = new CrearMobiliarioyEquipo();
                // Hace visible la ventana de creación de mobiliario y equipo
                mobiliario.setVisible(true);
                // Ubica la ventana de creación de mobiliario y equipo en el centro de la pantalla
                mobiliario.setLocationRelativeTo(null);

    }//GEN-LAST:event_btnAgregarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<String> ListadoEstado;
    public static javax.swing.JButton Previo;
    public static javax.swing.JButton btnAgregar;
    public static javax.swing.JButton btnEditar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel seguimiento;
    public static javax.swing.JButton siguiente;
    public static javax.swing.JTable tblMostrarMobiliarioyEquipo;
    private javax.swing.JTextField txtbusqueda;
    // End of variables declaration//GEN-END:variables
}
