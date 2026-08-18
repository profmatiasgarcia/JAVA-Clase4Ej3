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
 * DECORADOR ABSTRACTO
 * Implementa la misma interfaz que el componente que queremos decorar.
 * Esta clase es fundamental porque permite que un decorador contenga otro decorador.
 */
public abstract class NotificacionDecorator implements Notificacion {

    /**
     * Referencia al objeto que estamos decorando.
     *
     * Puede ser:
     *
     * - NotificacionSimple
     * - Otro Decorator
     *
     * Esto permite encadenar varios decoradores.
     */
    protected Notificacion notificacion;

    /**
     * Constructor.
     * Recibe el objeto que será decorado.
     */
    public NotificacionDecorator(Notificacion notificacion) {
        this.notificacion = notificacion;
    }
}