/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: DialogoTituloPartitura.java 600 2006-11-06 06:16:53Z da-romer $ 
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Todos los derechos reservados 2005 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n10_partitura 
 * Autor: Mario S�nchez - 27/09/2005 
 * Modificado por: Daniel Romero - 23/03/2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.partitura.interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JDialog;

/**
 * Es el di�logo para modificar el texto, fuente y color del t�tulo de la partitura
 */
public class DialogoTituloPartitura extends JDialog
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es una referencia a la clase principal de la interfaz
     */
    private InterfazPartitura principal;

    // -----------------------------------------------------------------
    // Atributos de la Intefaz
    // -----------------------------------------------------------------

    /**
     * El panel donde se modifica el t�tulo, la fuente y el color usados en la partitura
     */
    private PanelModificarTitulo panelModificar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el di�logo para modificar el t�tulo y la fuente de una partitura
     * @param principal Es una referencia a la clase principal de la interfaz
     * @param texto Es el t�tulo que se escribir� sobre la partitura
     * @param fuente Es la fuente que se usar� para el t�tulo de la partitura
     * @param nombre Es el nombre del dialogo
     * @param color Es el color del t�tulo de la partitura
     * 
     */
    public DialogoTituloPartitura( InterfazPartitura ip, String texto, Font fuente, String nombre, Color color )
    {
        super( ip, nombre, true );

        principal = ip;

        // Averiguar cuales son las fuentes disponibles en el sistema
        String[] nombresFuentes = GraphicsEnvironment.getLocalGraphicsEnvironment( ).getAvailableFontFamilyNames( );

        ArrayList listaFuentes = new ArrayList( );
        for( int i = 0; i < nombresFuentes.length; i++ )
        {
            listaFuentes.add( nombresFuentes[ i ] );
        }

        // Construir el panel y mostrar el di�logo
        panelModificar = new PanelModificarTitulo( this, listaFuentes );
        getContentPane( ).add( panelModificar );
        panelModificar.cambiarTexto( texto, fuente, color );

        setSize( 400, 180 );
        centrarVentana( );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Cambia el titulo mostrada
     * @param titulo El t�tulo de la partitura
     * @param fuente La fuente con que se va a escribir el t�tulo
     */
    public void cambiarTitulo( String titulo, Font fuente, Color color )
    {
        principal.cambiarTituloPartitura( titulo, fuente, color );
        setVisible( false );
        dispose( );
    }

    /**
     * Centra la ventana en la pantalla
     */
    private void centrarVentana( )
    {
        Dimension pantalla = Toolkit.getDefaultToolkit( ).getScreenSize( );
        setLocation( ( int ) ( pantalla.getWidth( ) / 2 - getWidth( ) / 2 ), ( int ) ( pantalla.getHeight( ) / 2 - getHeight( ) / 2 ) );
    }

}