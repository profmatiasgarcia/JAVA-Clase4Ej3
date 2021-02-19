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
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class PruebaJButton2 extends JFrame {

    private JTextField cuadroTexto;

    public PruebaJButton2() {
        super("Titulo de ventana");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        Container cp = getContentPane();
        cp.add(new JLabel("Nombre :"));
        cuadroTexto = new JTextField(20);
        cp.add(cuadroTexto);
        JButton botonSaludo = new JButton("Saludar");
        botonSaludo.addActionListener(new EventoSaludo2());
        cp.add(botonSaludo);
    }

    private class EventoSaludo2 implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "¡Hola, " + cuadroTexto.getText() + "!");
        }
    }

    public static void main(String args[]) {
        PruebaJButton2 ventana = new PruebaJButton2();
        ventana.setVisible(true);
    }

}
