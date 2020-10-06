/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Edificacion.java,v 1.2 2008/07/15 12:02:37 jua-gome Exp $ 
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Todos los derechos reservados 2005 
 *
 * Proyecto Cupi2 
 * Ejercicio: n10_mapaCiudad 
 * Autor: Daniel Romero - 31/01/2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.mapaCiudad.mundo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Esta es una clase abstracta que representa a una edificación
 */
public abstract class Edificacion extends Construccion
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * La figura que representa la edificación
     */
    private BufferedImage figuraEdificacion;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea la edificación con los valores especificados
     * @param x Coordenada x de la edificación
     * @param y Coordenada y de la edificación
     * @param alto Alto de la edificación
     * @param ancho Ancho de la edificación
     * @param colorFondo color de fondo de la edificación
     * @param imagen Nombre de la Imagen que representa la edificación incluyendo la extensión (p.e casa.gif)
     */
    public Edificacion( int x, int y, int alto, int ancho, Color colorFondo, String imagen )
    {
        super( x, y, alto, ancho, colorFondo );
        cargarImagen( imagen );
    }

    /**
     * Construye una edificación a partir de los datos contenidos en un archivo
     * @param br Es el stream que sirve para leer el archivo
     * @param imagen Imagen de la edificación
     * @throws IOException Se lanza esta excepción si hay problemas leyendo el archivo
     * @throws FormatoInvalidoExcepcion Se lanza esta excepción si el formato del archivo no es el esperado
     */
    public Edificacion( BufferedReader br, String imagen ) throws IOException, FormatoInvalidoExcepcion
    {
        super( br );
        cargarImagen( imagen );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Carga la imagen con el nombre especificado
     * @param imagen Nombre de la imagen a ser cargada
     */
    private void cargarImagen( String imagen )
    {
        try
        {
            figuraEdificacion = ImageIO.read( new File( "data\\imagenes\\" + imagen ) );
        }
        catch( IOException e )
        {
            figuraEdificacion = new BufferedImage( 1, 1, BufferedImage.TYPE_INT_RGB );
        }
    }

    /**
     * Sirve para pintar la edificación
     * @param g La superficie donde se debe pintar
     */
    public void pintar( Graphics2D g )
    {
        g.drawImage( figuraEdificacion, x, y, ancho, alto, colorFondo, null );
        pintarTexto( g );
    }
}
