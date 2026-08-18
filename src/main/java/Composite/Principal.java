/**
 * @author Prof Matias Garcia.
 * <p> Copyright (C) 2026 para <a href = "https://www.profmatiasgarcia.com.ar/"> www.profmatiasgarcia.com.ar </a>
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
package Composite;

/**
 * Clase principal.
 *
 * Ejemplo del patrón Composite.
 */
public class Principal {

    public static void main(String[] args) {

        // ==========================================
        // CREACIÓN DE ARCHIVOS
        // ==========================================

        Archivo archivo1 =
                new Archivo("documento.txt");

        Archivo archivo2 =
                new Archivo("foto.jpg");

        Archivo archivo3 =
                new Archivo("informe.pdf");

        Archivo archivo4 =
                new Archivo("presentacion.pptx");


        // ==========================================
        // CREACIÓN DE CARPETAS
        // ==========================================

        Carpeta documentos =
                new Carpeta("Documentos");

        Carpeta imagenes =
                new Carpeta("Imagenes");

        Carpeta trabajo =
                new Carpeta("Trabajo");


        // ==========================================
        // AGREGAMOS ARCHIVOS A LAS CARPETAS
        // ==========================================

        documentos.agregar(archivo1);

        imagenes.agregar(archivo2);

        trabajo.agregar(archivo3);
        trabajo.agregar(archivo4);


        // ==========================================
        // AGREGAMOS UNA CARPETA DENTRO DE OTRA
        // ==========================================

        documentos.agregar(trabajo);


        // ==========================================
        // MOSTRAMOS LA ESTRUCTURA
        // ==========================================

        documentos.mostrar();
    }
}

/*
Es decir, tenemos una estructura jerárquica:

Documentos
│
├── documento.txt
│
└── Trabajo
    │
    ├── informe.pdf
    │
    └── presentacion.pptx
¿Dónde está el Composite?

La parte fundamental es esta:

public class Carpeta implements Elemento

y:

private List<Elemento> elementos;

La carpeta contiene objetos del mismo tipo abstracto que ella misma implementa.

Por eso podemos tener:

                    Elemento
                       ^
                       |
              ----------------
              |              |
           Archivo         Carpeta
                            |
                            |
                       Elemento
                            ^
                            |
                     ---------------
                     |             |
                  Archivo       Carpeta

Esto permite construir árboles de cualquier profundidad.
*/