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
package Adapter;

/**
 * Clase que utiliza el servicio de pago.
 * Esta clase solamente conoce la interfaz Pago.
 * No necesita saber que detras existen diferentes sisemas de pago, como el externo.
 */
public class Tienda {

    /**
     * Procesa un pago utilizando cualquier objeto que implemente la interfaz Pago.
     */
    public void realizarCompra(Pago pago, double monto) {

        System.out.println("Iniciando compra...");

        pago.procesarPago(monto);

        System.out.println("Compra finalizada.");

    }

}