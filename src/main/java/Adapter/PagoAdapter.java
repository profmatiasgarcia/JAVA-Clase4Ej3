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
 * Adapter.
 * Implementa la interfaz que nuestro sistema necesita y utiliza internamente la clase externa.
 */
public class PagoAdapter implements Pago {

    // Referencia al objeto que queremos adaptar
    private SistemaPagoExterno sistemaExterno;

    /**
     * Constructor.
     * Recibe el objeto externo que queremos utilizar.
     */
    public PagoAdapter(SistemaPagoExterno sistemaExterno) {
        this.sistemaExterno = sistemaExterno;
    }

    /**
     * Método requerido por nuestra interfaz Pago.
     * El Adapter traduce la llamada:
     * procesarPago()
     * a:
     * realizarTransaccion()
     */

    @Override
    public void procesarPago(double monto) {
        sistemaExterno.realizarTransaccion(monto);
    }

}
