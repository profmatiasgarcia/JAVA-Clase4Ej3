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
package Bridge;

/**
 * ABSTRACCIÓN
 * Representa una notificación.
 * La clase no sabe cómo se envía el mensaje.
 * Delegará esa responsabilidad en CanalEnvio.
 */
public abstract class Notificacion {

    /**
     * Referencia al IMPLEMENTADOR.
     * Aquí está el "puente" entre la abstracción y la implementación.
     */
    protected CanalEnvio canalEnvio;

    /**
     * Constructor.
     * Recibe el canal mediante el cual se enviará la notificación.
     */
    public Notificacion(CanalEnvio canalEnvio) {
        this.canalEnvio = canalEnvio;
    }

    /**
     * Método abstracto que deberán implementar los diferentes tipos de notificación.
     */
    public abstract void enviar(String mensaje);

}