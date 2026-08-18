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
 * Tenemos un sistema que espera trabajar con una interfaz Pago, pero queremos incorporar una clase existente SistemaPagoExterno 
 * que tiene métodos y nombres diferentes. La idea es que el Adapter traduzca la interfaz que el sistema necesita a la interfaz 
 * que la clase existente ofrece.
 */
public class Principal {
 public static void main(String[] args) {

        // Creamos el sistema externo
        SistemaPagoExterno sistemaExterno = new SistemaPagoExterno();

        /*
         * Creamos el Adapter.
         * El Adapter permite utilizar el sistema externo como si fuera un objeto de tipo Pago.
         */
        Pago pago = new PagoAdapter(sistemaExterno);

        // Creamos nuestra tienda
        Tienda tienda = new Tienda();

        /*
         * La tienda solamente conoce la interfaz Pago.
         * No sabe que estamos utilizando SistemaPagoExterno.
         */
        tienda.realizarCompra(pago, 25000);

    }    
}
/**
¿Qué está haciendo realmente el Adapter?

Cuando la Tienda ejecuta:

pago.procesarPago(25000);

en realidad está utilizando:

Tienda
  |
  | procesarPago(25000)
  v
PagoAdapter
  |
  | realizarTransaccion(25000)
  v
SistemaPagoExterno

El cliente no necesita modificar su código para utilizar el sistema externo.
 */