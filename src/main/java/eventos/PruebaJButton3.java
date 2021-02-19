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

import java.awt.*;

public class PruebaJButton3 extends JFrame {

    public PruebaJButton3() {

        super("Titulo de ventana");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        Container cp = getContentPane();
        cp.add(new JLabel("Nombre :"));
        JTextField texto = new JTextField(20);
        cp.add(texto);
        JButton botonSaludo = new JButton("Saludar");
        botonSaludo.addActionListener(new EventoSaludo(texto));
        cp.add(botonSaludo);
    }

    public static void main(String args[]) {
        PruebaJButton3 ventana = new PruebaJButton3();
        ventana.setVisible(true);
    }
}
