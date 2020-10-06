/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: IConstruccion.java,v 1.1 2007/03/22 16:12:59 p-marque Exp $
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n10_mapaCiudad
 * Autor: Pablo Andr�s M�rquez - 26-oct-2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.mapaCiudad.mundo;

import java.awt.Font;
import java.awt.Graphics2D;
import java.io.PrintWriter;

/**
 * Clase que contiene los contratos de la construcci�n
 */
public interface IConstruccion
{
    /**
     * Cambia el texto de la construcci�n
     * @param txt El nuevo texto
     */
    public void cambiarTexto( String txt );

    /**
     * Retorna el texto de la construcci�n
     * @return Texto de la construcci�n
     */
    public String darTexto( );

    /**
     * Sirve para saber si un punto est� dentro de una construcci�n o no.
     * @param px Es la coordenada x del punto
     * @param py Es la coordenada y del punto
     * @return Retorna true si el punto est� dentro de la construcci�n. Retorna false en caso contrario.
     */
    public boolean estaDentro( int px, int py );

    /**
     * Este m�todo sirve para guardar una construcci�n en un archivo
     * @param out Es el stream donde se va a guardar la construcci�n
     */
    public void guardar( PrintWriter out );
    

    /**
     * Sirve para pintar la construcci�n de forma normal
     * @param g La superficie donde se debe pintar
     */
    public void pintar( Graphics2D g );
    
    /**
     * Sirve para retornar el tipo de la construcci�n
     * @return El tipo de la construcci�n
     */
    public String darTipo();
    
    /**
     * Sirve para pintar la figura sombreada. 
     * @param g La superficie donde se debe pintar
     */
    public void pintarSombreada( Graphics2D g );

    /**
     * Pinta la construcci�n como seleccionada.
     * @param g Es la superficie donde se pinta el �valo
     */
    public void pintarSeleccionada( Graphics2D g );

    /**
     * Cambia la coordenada x de la construcci�n
     * @param px Nueva coordena x de la construcci�n
     */
    public void cambiarX( int px );

    /**
     * Cambia la coordenada y de la construcci�n
     * @param py Nueva coordena y de la construcci�n
     */
    public void cambiarY( int py );

    /**
     * Cambia el ancho de la construcci�n
     * @param elAncho Nuevo ancho de la construcci�n
     */
    public void cambiarAncho( int elAncho );

    /**
     * Retorna el ancho de la construcci�n
     * @return ancho de la construcci�n
     */
    public int darAncho( );

    /**
     * Retorna el alto de la construcci�n
     * @return alto de la construcci�n
     */
    public int darAlto( );

    /**
     * Cambia el alto de la construcci�n
     * @param elAlto Nuevo alto de la construcci�n
     */
    public void cambiarAlto( int elAlto );

    /**
     * Retorna la fuente de la construcci�n
     * @return Fuente de la construcci�n
     */
    public Font darFuente( );
    /**
     * Cambia la fuente de la construcci�n
     * @param laFuente Nueva fuente de la construcci�n
     */
    public void cambiarFuente( Font laFuente );

    /**
     * Retorna la coordenada x de la construcci�n
     * @return Coordenada x de la construcci�n
     */
    public int darX( );

    /**
     * Retorna la coordenada y de la construcci�n
     * @return Coordenada y de la construcci�n
     */
    public int darY( );
}
