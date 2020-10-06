/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: DialogoInformacionNota.java 600 2006-11-06 06:16:53Z da-romer $ 
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Todos los derechos reservados 2005 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n10_partitura  
 * Autor: Daniel Romero - 22/03/2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.partitura.interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;

/**
 * Es el di�logo para modificar la informaci�n de la nota (clase, tipo y color)
 */
public class DialogoInformacionNota extends JDialog
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
     * El panel donde se modifica la informaci�n de la nota
     */
    private PanelModificarInformacionNota panelModificar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el di�logo para modificar la informaci�n de una nota
     * @param ip Es una referencia a la clase principal de la interfaz
     * @param clase Es el t�tulo que se escribir� sobre la partitura
     * @param tipo Es el tipo de la nota
     * @param nombre Es el nombre de la nota
     * @param color Es el color de la nota
     * @param pos La posici�n de la nota a la que se le va a cambiar la informaci�n
     * @param titulo Es el titulo del di�logo
     * 
     */
    public DialogoInformacionNota( InterfazPartitura ip, String clase, String tipo, String nombre, Color color, int pos, String titulo )
    {
        super( ip, titulo, true );

        principal = ip;

        // Construir el panel y mostrar el di�logo
        panelModificar = new PanelModificarInformacionNota( this, pos );
        getContentPane( ).add( panelModificar );
        panelModificar.cambiarInformacion( clase, tipo, nombre, color );

        setSize( 200, 200 );
        setResizable( false );
        centrarVentana( );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Cambia la informaci�n de la nota correspondiente a la posici�n especificada
     * @param clase La clase de la nota (rendonda, blanca, negra, corchea, semicorchea)
     * @param tipo El tipo de la nota (normal o sostenido)
     * @param color El color de la nota
     * @param posicion La posici�n de la nota a ser modificada
     * @param nombre El nombre de la nota (do, re mi, fa sol, la, si, do2)
     */
    public void cambiarInformacionNota( String clase, String tipo, Color color, int posicion, String nombre )
    {
        principal.cambiarInformacionNota( clase, tipo, color, posicion, nombre );
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
