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
package Proxy;

/**
Vamos a crear un sistema donde un usuario quiere acceder a un documento.

El sistema tendrá:
 - Documento → interfaz común.
 - DocumentoReal → objeto real que contiene el documento.
 - DocumentoProxy → controla el acceso.
 - Usuario → representa al usuario que intenta acceder.
 - Principal → cliente.

La idea será que solo los usuarios autorizados puedan visualizar el documento.
 */
/**
 * CLIENTE
 *
 * Ejemplo del patrón Proxy.
 */
public class Principal {

    public static void main(String[] args) {

        // ==========================================
        // USUARIO AUTORIZADO
        // ==========================================

        Usuario usuarioAutorizado =
                new Usuario(
                        "Juan",
                        true
                );


        // Creamos el Proxy
        Documento documento =
                new DocumentoProxy(
                        "Contrato.pdf",
                        usuarioAutorizado
                );


        // Intentamos acceder al documento
        documento.visualizar();


        System.out.println(
                "\n--------------------------\n"
        );


        // ==========================================
        // USUARIO NO AUTORIZADO
        // ==========================================

        Usuario usuarioNoAutorizado =
                new Usuario(
                        "Pedro",
                        false
                );


        // Creamos otro Proxy
        Documento documentoProtegido =
                new DocumentoProxy(
                        "Contrato.pdf",
                        usuarioNoAutorizado
                );


        // Intentamos acceder
        documentoProtegido.visualizar();

    }

}
/*¿Cómo funciona?

El funcionamiento puede dividirse en cuatro pasos.

1. El cliente solicita una operación
documento.visualizar();
2. La solicitud llega al Proxy
Cliente
   |
   v
DocumentoProxy
3. El Proxy realiza alguna operación adicional

Por ejemplo:

Verificar permisos
Registrar log
Comprobar autenticación
Verificar caché
4. El Proxy decide si delega la operación

Si todo está correcto:

DocumentoProxy
      |
      v
DocumentoReal

Si no está permitido:

DocumentoProxy
      |
      X
   Acceso denegado
Lazy Loading

En este ejemplo también utilizamos una técnica muy común llamada Lazy Loading o carga diferida.

Tenemos:

if (documentoReal == null) {


    documentoReal =
            new DocumentoReal(nombreDocumento);


}

Esto significa que el objeto real no se crea hasta que realmente sea necesario.

Esto puede ser muy útil cuando crear el objeto es costoso.

Por ejemplo:

Documento
   |
   +--> Archivo de 500 MB
   |
   +--> Imagen de alta resolución
   |
   +--> Consulta a base de datos
   |
   +--> Servicio remoto

En lugar de cargarlo inmediatamente, el Proxy puede esperar hasta que el usuario realmente lo necesite.
*/