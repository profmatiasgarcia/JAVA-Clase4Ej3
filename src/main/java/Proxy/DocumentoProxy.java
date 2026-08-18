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
 * PROXY
 *
 * Controla el acceso al DocumentoReal.
 *
 * Implementa la misma interfaz que el objeto real.
 */
public class DocumentoProxy implements Documento {

    /*
     * Referencia al objeto real.
     *
     * El Proxy será quien decida cuándo
     * crear o utilizar este objeto.
     */
    private DocumentoReal documentoReal;

    /*
     * Usuario que intenta acceder al documento.
     */
    private Usuario usuario;

    /*
     * Nombre del documento.
     *
     * Lo almacenamos en el Proxy para poder
     * identificar el recurso sin cargarlo todavía.
     */
    private String nombreDocumento;

    /**
     * Constructor.
     */
    public DocumentoProxy(
            String nombreDocumento,
            Usuario usuario) {

        this.nombreDocumento = nombreDocumento;

        this.usuario = usuario;

    }

    /**
     * Controla el acceso al documento.
     */
    @Override
    public void visualizar() {

        System.out.println(
                "Usuario: " + usuario.getNombre()
        );

        // ==========================================
        // VERIFICACIÓN DE PERMISOS
        // ==========================================

        if (!usuario.isAutorizado()) {

            System.out.println(
                    "Acceso DENEGADO."
            );

            return;

        }

        System.out.println(
                "Acceso autorizado."
        );


        // ==========================================
        // CREACIÓN DEL OBJETO REAL
        // ==========================================

        /*
         * El documento real solamente se crea
         * cuando realmente es necesario.
         *
         * Esto también es un ejemplo de
         * Lazy Loading.
         */
        if (documentoReal == null) {

            documentoReal =
                    new DocumentoReal(
                            nombreDocumento
                    );

        }


        // ==========================================
        // DELEGACIÓN
        // ==========================================

        /*
         * Una vez autorizado el acceso,
         * delegamos la operación al objeto real.
         */
        documentoReal.visualizar();

    }

}