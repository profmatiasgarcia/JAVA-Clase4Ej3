package eventos;
/**
 * @author Prof Matias Garcia.
 * <p> Copyright (C) 2017 para <a href = "https://www.profmatiasgarcia.com.ar/"> www.profmatiasgarcia.com.ar </a>
 * - con licencia GNU GPL3.
 * <p> Este programa es software libre. Puede redistribuirlo y/o modificarlo bajo los términos de la
 * Licencia Pública General de GNU según es publicada por la Free Software Foundation, 
 * bien con la versión 3 de dicha Licencia o bien (según su elección) con cualquier versión posterior. 
 * Este programa se distribuye con la esperanza de que sea útil, pero SIN NINGUNA GARANTÍA, 
 * incluso sin la garantía MERCANTIL implícita o sin garantizar la CONVENIENCIA PARA UN PROPÓSITO
 * PARTICULAR. Véase la Licencia Pública General de GNU para más detalles.
 * Debería haber recibido una copia de la Licencia Pública General junto con este programa. 
 * Si no ha sido así ingrese a <a href = "http://www.gnu.org/licenses/"> GNU org </a>
 */
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class PruebaJButton5 extends javax.swing.JFrame {

    public PruebaJButton5() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cuadroTexto = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        comboColor = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.FlowLayout());

        jLabel1.setText("Nombre:");
        getContentPane().add(jLabel1);

        cuadroTexto.setColumns(20);
        getContentPane().add(cuadroTexto);

        jButton1.setText("Saludar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);

        comboColor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Color", "Rojo", "Verde", "Azul" }));
        comboColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboColorActionPerformed(evt);
            }
        });
        getContentPane().add(comboColor);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JOptionPane.showMessageDialog(null, "¡Hola, " + cuadroTexto.getText() + "!");

    }//GEN-LAST:event_jButton1ActionPerformed

    private void comboColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboColorActionPerformed
        JComboBox<String> combo = (JComboBox<String>) evt.getSource();
        String itemSeleccionado = (String) combo.getSelectedItem();
 
        if (itemSeleccionado.equals("Rojo")) {
            getContentPane().setBackground(Color.RED);
        } else if (itemSeleccionado.equals("Verde")) {
            getContentPane().setBackground(Color.GREEN);
        }else if (itemSeleccionado.equals("Azul")) {
            getContentPane().setBackground(Color.BLUE);
        }
    
    }//GEN-LAST:event_comboColorActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PruebaJButton5().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboColor;
    private javax.swing.JTextField cuadroTexto;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
