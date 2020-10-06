/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Edificacion.java,v 1.2 2008/07/15 12:02:37 jua-gome Exp $ 
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
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
 * Esta es una clase abstracta que representa a una edificaci�n
 */
public abstract class Edificacion extends Construccion
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * La figura que representa la edificaci�n
     */
    private BufferedImage figuraEdificacion;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea la edificaci�n con los valores especificados
     * @param x Coordenada x de la edificaci�n
     * @param y Coordenada y de la edificaci�n
     * @param alto Alto de la edificaci�n
     * @param ancho Ancho de la edificaci�n
     * @param colorFondo color de fondo de la edificaci�n
     * @param imagen Nombre de la Imagen que representa la edificaci�n incluyendo la extensi�n (p.e casa.gif)
     */
    public Edificacion( int x, int y, int alto, int ancho, Color colorFondo, String imagen )
    {
        super( x, y, alto, ancho, colorFondo );
        cargarImagen( imagen );
    }

    /**
     * Construye una edificaci�n a partir de los datos contenidos en un archivo
     * @param br Es el stream que sirve para leer el archivo
     * @param imagen Imagen de la edificaci�n
     * @throws IOException Se lanza esta excepci�n si hay problemas leyendo el archivo
     * @throws FormatoInvalidoExcepcion Se lanza esta excepci�n si el formato del archivo no es el esperado
     */
    public Edificacion( BufferedReader br, String imagen ) throws IOException, FormatoInvalidoExcepcion
    {
        super( br );
        cargarImagen( imagen );
    }

    // -----------------------------------------------------------------
    // M�todos
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
     * Sirve para pintar la edificaci�n
     * @param g La superficie donde se debe pintar
     */
    public void pintar( Graphics2D g )
    {
        g.drawImage( figuraEdificacion, x, y, ancho, alto, colorFondo, null );
        pintarTexto( g );
    }
}
