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
package Decorator;

/**
 * DECORADOR CONCRETO
 *
 * Agrega la funcionalidad de registrar la notificación en un log.
 */
public class NotificacionConLog extends NotificacionDecorator {

    /**
     * Constructor.
     */
    public NotificacionConLog(Notificacion notificacion) {

        super(notificacion);

    }

    /**
     * Agrega una funcionalidad antes y después
     * de ejecutar la operación original.
     */
    @Override
    public void enviar(String mensaje) {

        // Nueva funcionalidad
        System.out.println(
                "[LOG] Registrando notificación..."
        );

        // Ejecutamos la funcionalidad original
        notificacion.enviar(mensaje);

        // Otra funcionalidad agregada
        System.out.println(
                "[LOG] Notificación registrada correctamente."
        );
    }
}