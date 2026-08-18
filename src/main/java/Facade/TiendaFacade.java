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
package Facade;

/**
 * FACADE
 *
 * Proporciona una interfaz simple para utilizar los diferentes subsistemas de la tienda.
 *
 * El cliente no necesita conocer cómo funcionan Inventario, Pago y Envio.
 */
public class TiendaFacade {

    // Referencias a los diferentes subsistemas
    private Inventario inventario;
    private Pago pago;
    private Envio envio;

    /**
     * Constructor de la Fachada.
     *
     * Inicializamos todos los subsistemas.
     */
    public TiendaFacade() {

        inventario = new Inventario();

        pago = new Pago();

        envio = new Envio();

    }

    /**
     * Método simplificado para realizar una compra.
     *
     * Internamente realiza varias operaciones:
     *
     * 1. Verifica stock.
     * 2. Procesa el pago.
     * 3. Actualiza el inventario.
     * 4. Genera el envío.
     */
    public void comprar(
            String producto,
            int cantidad,
            double precio,
            String direccion) {

        System.out.println(
                "===== INICIANDO COMPRA ====="
        );

        // ------------------------------------------
        // PASO 1: Verificar stock
        // ------------------------------------------

        boolean hayStock =
                inventario.verificarStock(
                        producto,
                        cantidad
                );

        if (!hayStock) {

            System.out.println(
                    "No hay stock disponible."
            );

            return;
        }


        // ------------------------------------------
        // PASO 2: Procesar el pago
        // ------------------------------------------

        double montoTotal =
                precio * cantidad;

        boolean pagoAprobado =
                pago.procesarPago(montoTotal);

        if (!pagoAprobado) {

            System.out.println(
                    "El pago fue rechazado."
            );

            return;
        }


        // ------------------------------------------
        // PASO 3: Actualizar inventario
        // ------------------------------------------

        inventario.actualizarStock(
                producto,
                cantidad
        );


        // ------------------------------------------
        // PASO 4: Generar envío
        // ------------------------------------------

        envio.generarEnvio(
                producto,
                direccion
        );


        System.out.println(
                "===== COMPRA FINALIZADA ====="
        );
    }
}
/*
La clase TiendaFacade es la parte más importante del ejemplo.

El cliente no tiene que conocer los detalles de:

Inventario
Pago
Envio

Solamente necesita conocer:

comprar(...)
*/