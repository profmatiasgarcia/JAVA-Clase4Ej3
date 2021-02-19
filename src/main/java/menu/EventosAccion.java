package menu;
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
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EventosAccion extends JFrame implements ActionListener {

    private TextField c1;
    private TextField c2;
    private Button b;

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public EventosAccion() {
        // se crea una barra de menus
        JMenuBar mb = new JMenuBar();

        // creamos un elemento del menu
        JMenu archivo = new JMenu("Archivo");
        archivo.setFont(new Font("Arial", Font.PLAIN, 20));

        // creamos y añadimos submenues
        JMenuItem abrir = new JMenuItem("Abrir");
        abrir.setFont(new Font("Arial", Font.PLAIN, 16));
        abrir.addActionListener(this);
        archivo.add(abrir);

        JMenuItem salir = new JMenuItem("Salir");
        salir.setFont(new Font("Arial", Font.PLAIN, 16));
        salir.addActionListener(this);
        archivo.add(salir);

        mb.add(archivo);

        Color rojito = new Color(54, 84, 65);

        setJMenuBar(mb);
        setBackground(rojito);
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // comprobamos si la fuente del evento es un JMenuItem
        if (e.getSource() instanceof JMenuItem) {
            JMenuItem source = (JMenuItem) (e.getSource());
            String seleccionado = source.getText();

            // si pulsa sobre abrir mostramos una ventana para abrir archivos
            if (seleccionado.compareTo("Abrir") == 0) {
                JFileChooser elegirArchivo = new JFileChooser();
                int returnVal = elegirArchivo.showOpenDialog(EventosAccion.this);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    System.out.println("Ha seleccionado el archivo " + elegirArchivo.getSelectedFile().getName());
                }
            }

            if (seleccionado.compareTo("Salir") == 0) {
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        new EventosAccion();
    }

}
