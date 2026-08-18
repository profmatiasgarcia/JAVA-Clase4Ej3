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
 * Vamos a implementar un sistema donde podamos combinar: - Alerta -
 * Recordatorio con: -- Email -- SMS -- WhatsApp sin tener que crear una clase
 * para cada combinación.
 */
public class Principal {

    public static void main(String[] args) {

        // ==========================================
        // CREACIÓN DE LOS CANALES DE ENVÍO
        // ==========================================
        CanalEnvio email = new Email();

        CanalEnvio sms = new SMS();

        CanalEnvio whatsapp = new WhatsApp();

        // ==========================================
        // CREACIÓN DE LAS NOTIFICACIONES
        // ==========================================

        /*
         * Creamos una ALERTA que utiliza EMAIL.
         */
        Notificacion alertaEmail
                = new Alerta(email);

        alertaEmail.enviar(
                "Se detectó un acceso no autorizado."
        );

        System.out.println();


        /*
         * Creamos una ALERTA que utiliza SMS.
         */
        Notificacion alertaSMS
                = new Alerta(sms);

        alertaSMS.enviar(
                "Se detectó un acceso no autorizado."
        );

        System.out.println();


        /*
         * Creamos un RECORDATORIO que utiliza WhatsApp.
         */
        Notificacion recordatorioWhatsApp
                = new Recordatorio(whatsapp);

        recordatorioWhatsApp.enviar(
                "Recuerde realizar el pago mañana."
        );

        System.out.println();


        /*
         * Creamos un RECORDATORIO que utiliza Email.
         */
        Notificacion recordatorioEmail
                = new Recordatorio(email);

        recordatorioEmail.enviar(
                "Su turno es mañana a las 10:00."
        );

    }

}
/*
¿Dónde está el Bridge?

La parte fundamental está en Notificacion:

protected CanalEnvio canalEnvio;

La clase Notificacion representa la abstracción, mientras que CanalEnvio representa la implementación.

              ABSTRACCIÓN
                   |
                   v
            Notificacion
                   |
                   |
              <<Bridge>>
                   |
                   v
             CanalEnvio
                   |
        ----------------------
        |          |         |
      Email       SMS     WhatsApp

De esta forma, Notificacion no necesita saber cómo funciona Email, SMS o WhatsApp.

Simplemente dice:

canalEnvio.enviar(mensaje);

El objeto concreto se encarga de realizar el envío.

La principal ventaja del Bridge

Supongamos que queremos agregar una nueva notificación:

public class Promocion extends Notificacion {
    
    public Promocion(CanalEnvio canalEnvio) {
        super(canalEnvio);
    }


    @Override
    public void enviar(String mensaje) {
        System.out.println("PROMOCIÓN:");
        canalEnvio.enviar(mensaje);
    }
}

No necesitamos crear:

PromocionEmail
PromocionSMS
PromocionWhatsApp

Simplemente hacemos:

Notificacion promocion =
        new Promocion(new Email());

o:

Notificacion promocion =
        new Promocion(new SMS());

o:

Notificacion promocion =
        new Promocion(new WhatsApp());

La nueva abstracción funciona automáticamente con todas las implementaciones existentes.
*/