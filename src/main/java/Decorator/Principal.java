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
 * Clase principal.
 * Ejemplo del patrón Decorator.
 */
public class Principal {

    public static void main(String[] args) {

        // ==========================================
        // NOTIFICACIÓN BÁSICA
        // ==========================================

        Notificacion notificacion =
                new NotificacionSimple();

        notificacion.enviar(
                "Su pedido fue enviado."
        );


        System.out.println(
                "\n--------------------------\n"
        );


        // ==========================================
        // AGREGAMOS LOG
        // ==========================================

        notificacion =
                new NotificacionConLog(notificacion);

        notificacion.enviar(
                "Su pedido fue enviado."
        );


        System.out.println(
                "\n--------------------------\n"
        );


        // ==========================================
        // AGREGAMOS SMS
        // ==========================================

        notificacion =
                new NotificacionConSMS(notificacion);

        notificacion.enviar(
                "Su pedido fue enviado."
        );


        System.out.println(
                "\n--------------------------\n"
        );


        // ==========================================
        // AGREGAMOS EMAIL
        // ==========================================

        notificacion =
                new NotificacionConEmail(notificacion);

        notificacion.enviar(
                "Su pedido fue enviado."
        );
    }
}
/*
¿Qué ocurre internamente?

Esta línea:

Notificacion notificacion =
        new NotificacionSimple();

crea:

NotificacionSimple

Luego hacemos:

notificacion =
        new NotificacionConLog(notificacion);

Ahora tenemos:

NotificacionConLog
        |
        v
NotificacionSimple

Después:

notificacion =
        new NotificacionConSMS(notificacion);

La estructura pasa a ser:

NotificacionConSMS
        |
        v
NotificacionConLog
        |
        v
NotificacionSimple

Finalmente:

notificacion =
        new NotificacionConEmail(notificacion);

Tenemos:

NotificacionConEmail
        |
        v
NotificacionConSMS
        |
        v
NotificacionConLog
        |
        v
NotificacionSimple

Esto es justamente el Decorator: un objeto está siendo envuelto por otros objetos que agregan funcionalidades.
*/