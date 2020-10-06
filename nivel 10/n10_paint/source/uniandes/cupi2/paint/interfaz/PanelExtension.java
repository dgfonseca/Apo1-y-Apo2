/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelExtension.java,v 1.5 2006/10/02 17:14:35 da-romer Exp $
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n10_paint
 * Autor: Mario S�nchez - 25/08/2005 
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.paint.interfaz;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

/**
 * Es el panel que contiene los botones para ejecutar los puntos de extensi�n
 */
public class PanelExtension extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * El comando para el bot�n 1
     */
    private final String OPCION_1 = "opcion 1";

    /**
     * El comando para el bot�n 2
     */
    private final String OPCION_2 = "opcion 2";

    /**
     * El comando para el bot�n 3
     */
    private final String OPCION_3 = "opcion 3";

    /**
     * El comando para el bot�n 4
     */
    private final String OPCION_4 = "opcion 4";

    /**
     * El comando para el bot�n 5
     */
    private final String OPCION_5 = "opcion 5";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la referencia a la interfaz de la aplicaci�n
     */
    private InterfazPaint principal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Es el bot�n 1
     */
    private JButton botonOpcion1;

    /**
     * Es el bot�n 2
     */
    private JButton botonOpcion2;

    /**
     * Es el bot�n 3
     */
    private JButton botonOpcion3;

    /**
     * Es el bot�n 4
     */
    private JButton botonOpcion4;

    /**
     * Es el bot�n 5
     */
    private JButton botonOpcion5;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel con una referencia a la ventana principal de la aplicaci�n <br>
     * <b>post: </b> Construy� el panel <br>
     * @param ip - Referencia a la ventana principal - is!=null
     */
    public PanelExtension( InterfazPaint ip )
    {
        principal = ip;
        inicializar( );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Inicializa los componentes del panel <br>
     * <b>post: </b> Se inicializaron y se ubicaron los componentes del panel <br>
     */
    private void inicializar( )
    {
        setBorder( new TitledBorder( "Puntos de Extensi�n" ) );

        setLayout( new FlowLayout( ) );
        botonOpcion1 = new JButton( "Opci�n 1" );
        botonOpcion1.setActionCommand( OPCION_1 );
        botonOpcion1.addActionListener( this );

        botonOpcion2 = new JButton( "Opci�n 2" );
        botonOpcion2.setActionCommand( OPCION_2 );
        botonOpcion2.addActionListener( this );

        botonOpcion3 = new JButton( "Opci�n 3" );
        botonOpcion3.setActionCommand( OPCION_3 );
        botonOpcion3.addActionListener( this );

        botonOpcion4 = new JButton( "Opci�n 4" );
        botonOpcion4.setActionCommand( OPCION_4 );
        botonOpcion4.addActionListener( this );

        botonOpcion5 = new JButton( "Opci�n 5" );
        botonOpcion5.setActionCommand( OPCION_5 );
        botonOpcion5.addActionListener( this );

        add( botonOpcion1 );
        add( botonOpcion2 );
        add( botonOpcion3 );
        add( botonOpcion4 );
        add( botonOpcion5 );
    }

    /**
     * Este m�todo se llama cuando se presiona uno de los botones <br>
     * <b>post: </b> Se ejecut� la acci�n correspondiente al bot�n presionado <br>
     * @param event El evento del click en el bot�n
     */
    public void actionPerformed( ActionEvent event )
    {
        String comando = event.getActionCommand( );
        if( OPCION_1.equals( comando ) )
        {
            principal.reqFuncOpcion1( );
        }
        else if( OPCION_2.equals( comando ) )
        {
            principal.reqFuncOpcion2( );
        }
        else if( OPCION_3.equals( comando ) )
        {
            principal.reqFuncOpcion3( );
        }
        else if( OPCION_4.equals( comando ) )
        {
            principal.reqFuncOpcion4( );
        }
        else if( OPCION_5.equals( comando ) )
        {
            principal.reqFuncOpcion5( );
        }
    }

}
