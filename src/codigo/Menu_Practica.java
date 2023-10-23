/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Graphics;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author jhony
 */
public class Menu_Practica extends javax.swing.JFrame {

    private ArrayList<Punto> listaPuntos;
    private int valorMaximoX, valorMaximoY;

    /**
     * Creates new form Menu_Practica
     */
    public Menu_Practica() {
        initComponents();
        setTitle("Menu Principal");
        this.setLocationRelativeTo(null);
        this.listaPuntos = new ArrayList<>();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        homeContent = new javax.swing.JPanel();
        paramContent = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        algoritmoCB = new javax.swing.JComboBox<>();
        opcionDatosCB = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        iniciarBtn = new javax.swing.JButton();
        compararContent = new javax.swing.JPanel();
        comprobarContent = new javax.swing.JPanel();
        graphContent = new javax.swing.JPanel();
        displayBtn = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 255, 255)));

        paramContent.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setLabelFor(this);
        jLabel1.setText("Datos:");

        jLabel2.setText("Algoritmo");

        algoritmoCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar...", "Exhaustivo", "Exhaustivo Poda", "D&V", "D&V Mejora" }));

        opcionDatosCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar...", "Cargar Fichero", "Generar Puntos" }));

        jLabel3.setText("CONFIGURACIÓN");

        iniciarBtn.setText("Iniciar");
        iniciarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paramContentLayout = new javax.swing.GroupLayout(paramContent);
        paramContent.setLayout(paramContentLayout);
        paramContentLayout.setHorizontalGroup(
            paramContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paramContentLayout.createSequentialGroup()
                .addGroup(paramContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paramContentLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(paramContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(paramContentLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(132, 132, 132)
                                .addComponent(algoritmoCB, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(paramContentLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(149, 149, 149)
                                .addComponent(opcionDatosCB, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(paramContentLayout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(jLabel3))
                    .addGroup(paramContentLayout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(iniciarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        paramContentLayout.setVerticalGroup(
            paramContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paramContentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(24, 24, 24)
                .addGroup(paramContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(opcionDatosCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(paramContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(algoritmoCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(iniciarBtn)
                .addContainerGap())
        );

        javax.swing.GroupLayout homeContentLayout = new javax.swing.GroupLayout(homeContent);
        homeContent.setLayout(homeContentLayout);
        homeContentLayout.setHorizontalGroup(
            homeContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeContentLayout.createSequentialGroup()
                .addGap(447, 447, 447)
                .addComponent(paramContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(604, Short.MAX_VALUE))
        );
        homeContentLayout.setVerticalGroup(
            homeContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeContentLayout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(paramContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(342, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("HOME", homeContent);

        javax.swing.GroupLayout compararContentLayout = new javax.swing.GroupLayout(compararContent);
        compararContent.setLayout(compararContentLayout);
        compararContentLayout.setHorizontalGroup(
            compararContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1479, Short.MAX_VALUE)
        );
        compararContentLayout.setVerticalGroup(
            compararContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 707, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("COMPARAR", compararContent);

        javax.swing.GroupLayout comprobarContentLayout = new javax.swing.GroupLayout(comprobarContent);
        comprobarContent.setLayout(comprobarContentLayout);
        comprobarContentLayout.setHorizontalGroup(
            comprobarContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1479, Short.MAX_VALUE)
        );
        comprobarContentLayout.setVerticalGroup(
            comprobarContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 707, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("COMPROBAR", comprobarContent);

        graphContent.setBackground(new java.awt.Color(255, 255, 255));
        graphContent.setPreferredSize(new java.awt.Dimension(1450, 700));

        displayBtn.setText("Mostar");
        displayBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout graphContentLayout = new javax.swing.GroupLayout(graphContent);
        graphContent.setLayout(graphContentLayout);
        graphContentLayout.setHorizontalGroup(
            graphContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(graphContentLayout.createSequentialGroup()
                .addGap(648, 648, 648)
                .addComponent(displayBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(758, Short.MAX_VALUE))
        );
        graphContentLayout.setVerticalGroup(
            graphContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, graphContentLayout.createSequentialGroup()
                .addContainerGap(422, Short.MAX_VALUE)
                .addComponent(displayBtn)
                .addGap(262, 262, 262))
        );

        jTabbedPane1.addTab("GRAPH", graphContent);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iniciarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarBtnActionPerformed
        // TODO add your handling code here:
        int numPuntos;
        if (opcionDatosCB.getSelectedIndex() == 0 || algoritmoCB.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Rellene todos los campos.");
        } else {
            if (opcionDatosCB.getSelectedIndex() == 2) {
                try {
                    numPuntos = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Cuántos puntos desea generar?"));
                    generaPuntos(numPuntos);
                } catch (HeadlessException | NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                }
            }
            if (opcionDatosCB.getSelectedIndex() == 1) {
                try {
                    abrirFichero();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Menu_Practica.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            //etiquetaGraph.setVisible(false);
        }
    }//GEN-LAST:event_iniciarBtnActionPerformed

    private void displayBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayBtnActionPerformed
        // TODO add your handling code here:
        if (listaPuntos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay datos....");
        } else {
            int maxX = graphContent.getWidth();
            int maxY = graphContent.getHeight();
            Graphics g = graphContent.getGraphics();
            displayBtn.setVisible(false);
            dibujaGraph();
        }
    }//GEN-LAST:event_displayBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Menu_Practica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Practica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Practica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Practica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new Menu_Practica().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> algoritmoCB;
    private javax.swing.JPanel compararContent;
    private javax.swing.JPanel comprobarContent;
    private javax.swing.JButton displayBtn;
    private javax.swing.JPanel graphContent;
    private javax.swing.JPanel homeContent;
    private javax.swing.JButton iniciarBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox<String> opcionDatosCB;
    private javax.swing.JPanel paramContent;
    // End of variables declaration//GEN-END:variables

    private void abrirFichero() throws FileNotFoundException {
        JFileChooser filChoose = new JFileChooser(System.getProperty("user.dir"));//Cogemos directorios desde /home
        filChoose.setFileSelectionMode(JFileChooser.FILES_ONLY);//Solo acepta ficheros
        filChoose.setFileFilter(new FileNameExtensionFilter("txt", "txt"));//Coje ficheros cuya extension sea esas
        JFrame f = new JFrame();//Necesario, para poder hacer dispose()
        if (filChoose.showOpenDialog(f) == JFileChooser.APPROVE_OPTION) {
            File file = filChoose.getSelectedFile();//Cogemos el fichero seleccionado
            FileReader s  =  new FileReader(file);
            cargarPuntos(s);
        }

    }

    private void generaPuntos(int cantidad) {
        Random r = new Random();

        Double x, y;
        Punto p;
//        int maxX = graphContent.getWidth();
//        int maxY = graphContent.getHeight();

        for (int i = 0; i < cantidad; i++) {
            // int myValue = r.nextInt(max-offset)+offset;
            x = r.nextDouble();
            y = r.nextDouble();
            p = new Punto(x, y, i);
            listaPuntos.add(p);
        }
    }

    private void dibujaGraph() {
        int size = listaPuntos.size();
        Graphics g = graphContent.getGraphics();
        graphContent.setVisible(true);
        for (int i = 0; i < size; i++) {
            listaPuntos.get(i).dibujaPunto(g);
        }
        System.out.println("listo");
    }

    private void cargarPuntos(FileReader s) {
         int i = 0;
         BufferedReader entradaDatos;
         double ancho = 0, alto = 0;
         
        try {
            entradaDatos = new BufferedReader(s);
            String Linea;
            boolean CordSection = false;
            while ((Linea = entradaDatos.readLine()) != null) {
                if (!Linea.equals("EOF") && !Linea.equals("")) {
                    if (CordSection) {
                        int a = -1, b = -1, c = -1, o = 0;
                        String[] parts = Linea.split(" ");
                        while (o<parts.length) {
                            if (!parts[o].isEmpty()) {
                                //  setID
                                if (a==-1) {
                                    a=o;
                                }
                                // set X
                                else if (b==-1) {
                                    b=o;
                                }
                                //  set Y
                                else if(c==-1){
                                    c=o;
                                }
                            }
                            o++;
                        }
                        
                        if (ancho<Double.parseDouble(parts[b].trim())) {
                            ancho = (int) Double.parseDouble(parts[b].trim());  
                        }
                        
                        if (alto<Double.parseDouble(parts[c].trim())) {
                            alto= (int) Double.parseDouble(parts[c].trim());
                        }
                        listaPuntos.add(new Punto(Double.parseDouble(parts[b].trim()),Double.parseDouble(parts[c].trim()),Integer.parseInt(parts[a].trim())));
                    }
                    else{
                        if (Linea.equals("NODE_COORD_SECTION")) {
                            CordSection =true;
                        }
                        else if (Linea.contains("DIMENSION")) {
                            String[] parts = Linea.split(" ");
                        }
                    }
                }
            }
            entradaDatos.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(paramContent, e);
        }
        System.out.println("hh");
    }
}
