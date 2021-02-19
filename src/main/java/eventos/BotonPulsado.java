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
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class BotonPulsado extends JFrame {

    private static final long serialVersionUID = 1L;

    private JLabel etiqueta;
    private JButton b1, b2, b3;

    BotonPulsado() {
        super("¿Qué botón es Pulsado?");
        getContentPane().setLayout(new FlowLayout());

        b1 = new JButton("Botón 1");
        b2 = new JButton("Botón 2");
        b3 = new JButton("Botón 3");

        etiqueta = new JLabel("");

        add(b1);
        add(b2);
        add(b3);
        add(etiqueta);

        b1.addActionListener(new BotonPulsadoListener());
        b2.addActionListener(new BotonPulsadoListener());
        b3.addActionListener(new BotonPulsadoListener());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(null, "Gracias por usar este Software", "Salida", JOptionPane.OK_OPTION);
                System.exit(0);
            }
        });

        setSize(400, 300);
        setVisible(true);

    }

    private class BotonPulsadoListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            etiqueta.setText("Has pulsado el botón " + e.getActionCommand());
        }
    }

    public static void main(String[] args) {
        new BotonPulsado();

    }

}
