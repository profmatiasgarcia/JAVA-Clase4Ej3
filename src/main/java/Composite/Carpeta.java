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

import java.util.ArrayList;
import java.util.List;

/**
 * COMPOSITE
 *
 * Representa una carpeta.
 *
 * Una carpeta puede contener:
 *
 * - Archivos
 * - Otras carpetas
 *
 * Todos ellos implementan la interfaz Elemento.
 */
public class Carpeta implements Elemento {

    private String nombre;

    /*
     * Lista de elementos que contiene la carpeta.
     * Puede contener tanto archivos como carpetas.
     */
    private List<Elemento> elementos;

    /**
     * Constructor.
     */
    public Carpeta(String nombre) {

        this.nombre = nombre;

        // Inicializamos la lista de elementos
        elementos = new ArrayList<>();
    }

    /**
     * Agrega un elemento a la carpeta.
     * Puede ser un Archivo o una Carpeta.
     */
    public void agregar(Elemento elemento) {
        elementos.add(elemento);
    }

    /**
     * Elimina un elemento de la carpeta.
     */
    public void eliminar(Elemento elemento) {
        elementos.remove(elemento);
    }

    /**
     * Muestra la carpeta y todos sus elementos.
     */
    @Override
    public void mostrar() {

        System.out.println("Carpeta: " + nombre);

        /*
         * Recorremos todos los elementos contenidos en la carpeta.
         */
        for (Elemento elemento : elementos) {

            elemento.mostrar();
        }
    }
}