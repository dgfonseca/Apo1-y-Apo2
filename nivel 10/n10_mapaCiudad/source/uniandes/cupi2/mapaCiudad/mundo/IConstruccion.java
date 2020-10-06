/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: IConstruccion.java,v 1.1 2007/03/22 16:12:59 p-marque Exp $
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n10_mapaCiudad
 * Autor: Pablo Andrés Márquez - 26-oct-2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.mapaCiudad.mundo;

import java.awt.Font;
import java.awt.Graphics2D;
import java.io.PrintWriter;

/**
 * Clase que contiene los contratos de la construcción
 */
public interface IConstruccion
{
    /**
     * Cambia el texto de la construcción
     * @param txt El nuevo texto
     */
    public void cambiarTexto( String txt );

    /**
     * Retorna el texto de la construcción
     * @return Texto de la construcción
     */
    public String darTexto( );

    /**
     * Sirve para saber si un punto está dentro de una construcción o no.
     * @param px Es la coordenada x del punto
     * @param py Es la coordenada y del punto
     * @return Retorna true si el punto está dentro de la construcción. Retorna false en caso contrario.
     */
    public boolean estaDentro( int px, int py );

    /**
     * Este método sirve para guardar una construcción en un archivo
     * @param out Es el stream donde se va a guardar la construcción
     */
    public void guardar( PrintWriter out );
    

    /**
     * Sirve para pintar la construcción de forma normal
     * @param g La superficie donde se debe pintar
     */
    public void pintar( Graphics2D g );
    
    /**
     * Sirve para retornar el tipo de la construcción
     * @return El tipo de la construcción
     */
    public String darTipo();
    
    /**
     * Sirve para pintar la figura sombreada. 
     * @param g La superficie donde se debe pintar
     */
    public void pintarSombreada( Graphics2D g );

    /**
     * Pinta la construcción como seleccionada.
     * @param g Es la superficie donde se pinta el óvalo
     */
    public void pintarSeleccionada( Graphics2D g );

    /**
     * Cambia la coordenada x de la construcción
     * @param px Nueva coordena x de la construcción
     */
    public void cambiarX( int px );

    /**
     * Cambia la coordenada y de la construcción
     * @param py Nueva coordena y de la construcción
     */
    public void cambiarY( int py );

    /**
     * Cambia el ancho de la construcción
     * @param elAncho Nuevo ancho de la construcción
     */
    public void cambiarAncho( int elAncho );

    /**
     * Retorna el ancho de la construcción
     * @return ancho de la construcción
     */
    public int darAncho( );

    /**
     * Retorna el alto de la construcción
     * @return alto de la construcción
     */
    public int darAlto( );

    /**
     * Cambia el alto de la construcción
     * @param elAlto Nuevo alto de la construcción
     */
    public void cambiarAlto( int elAlto );

    /**
     * Retorna la fuente de la construcción
     * @return Fuente de la construcción
     */
    public Font darFuente( );
    /**
     * Cambia la fuente de la construcción
     * @param laFuente Nueva fuente de la construcción
     */
    public void cambiarFuente( Font laFuente );

    /**
     * Retorna la coordenada x de la construcción
     * @return Coordenada x de la construcción
     */
    public int darX( );

    /**
     * Retorna la coordenada y de la construcción
     * @return Coordenada y de la construcción
     */
    public int darY( );
}
