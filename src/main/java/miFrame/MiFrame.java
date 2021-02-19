package miFrame;
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
import java.awt.FlowLayout;
import java.awt.event.*;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

class MiFrame extends JFrame {

    private JPanel panelContenedor;
    private JTextField campo1;
    private JTextField campo2;
    private JTextField campo3;

    public MiFrame() {
        setTitle("Mi ventana");
        setSize(300, 250);
        addWindowListener(new manejador());
        setLocationRelativeTo(null);

        panelContenedor = new JPanel();
        panelContenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
        panelContenedor.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        setContentPane(panelContenedor);

        campo1 = new JTextField();
        campo1.setColumns(20);
        campo2 = new JTextField();
        campo2.setColumns(20);
        campo3 = new JTextField();
        campo3.setColumns(20);

        campo1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                campo2.setText("campo1 tiene el foco");
            }

            @Override
            public void focusLost(FocusEvent e) {
                campo2.setText("campo1 NO tiene el foco");
            }
        });

        campo1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                campo3.setText(campo1.getText());
            }
        });

        campo1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                campo2.setBackground(Color.YELLOW);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                campo2.setBackground(Color.GREEN);
            }
        });

//        campo1.addMouseListener(new MouseAdapter() {
//            public void mouseEntered(MouseEvent e) {
//                campo2.setBackground(Color.YELLOW);
//            }
//
//            public void mouseExited(MouseEvent e) {
//                campo2.setBackground(Color.GREEN);
//            }
//        });
        JLabel e1 = new JLabel("Campo 1:");
        panelContenedor.add(e1);
        panelContenedor.add(campo1);
        panelContenedor.add(new JLabel("Campo 2:"));
        panelContenedor.add(campo2);
        panelContenedor.add(new JLabel("Campo 3:"));
        panelContenedor.add(campo3);

        panelContenedor.setBackground(Color.ORANGE);

    }
}
