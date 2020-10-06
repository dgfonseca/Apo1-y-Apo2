/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n6_buscaminas
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.buscaminas.interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Panel que contiene las opciones del programa.
 */
@SuppressWarnings("serial")
public class PanelOpciones extends JPanel implements ActionListener
{
    /**
     * Constante para el comando del botón iniciar.
     */
    private static final String BOTON_INICIAR = "Iniciar";

    /**
     * Constante para el comando del botón cargar.
     */
    private static final String BOTON_CARGAR= "Cargar";
    
    /**
     * Constante para el comando del botón opción 1.
     */
    private static final String OPCION_1 = "OPCION_1";

    /**
     * Constante para el comando del botón opción 2.
     */
    private static final String OPCION_2 = "OPCION_2";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es una referencia a la clase principal de la interfaz.
     */
    private InterfazBuscaminas principal;

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Es el botón para (re)iniciar el campo minado.
     */
    private JButton botonIniciar;
    
    /**
     * Es el botón para cargar un nuevo campo de juego
     */
    private JButton botonCargar;

    /**
     * Es el botón para realizar la opción 1.
     */
    private JButton opcion1;

    /**
     * Es el botón para realizar la opción 2.
     */
    private JButton opcion2;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel con la referencia a la InterfazBuscaminas.
     * @param pPrincipal Es una referencia a la clase principal de la interfaz. pPrincipal != null.
     */
    public PanelOpciones( InterfazBuscaminas pPrincipal )
    {
        principal = pPrincipal;

        botonCargar = new JButton( "Cargar" );
        botonCargar.setActionCommand( BOTON_CARGAR );
        botonCargar.setToolTipText( "Cargar campo" );
        botonCargar.addActionListener( this );
        add( botonCargar );
        
        // Inicializa el botonIniciar con la imagen y los valores predeterminados
        botonIniciar = new JButton( "Nuevo Juego" );
        botonIniciar.setActionCommand( BOTON_INICIAR );
        botonIniciar.setToolTipText( "Iniciar" );
        botonIniciar.addActionListener( this );
        add( botonIniciar );

        // Iinicializa el botón de la opción 1
        opcion1 = new JButton( "Opción 1" );
        opcion1.setToolTipText( "Opción 1" );
        opcion1.setActionCommand( OPCION_1 );
        opcion1.addActionListener( this );
        add( opcion1 );

        // inicializa el botón de la opción 2
        opcion2 = new JButton( "Opción 2" );
        opcion2.setToolTipText( "Opcion 2" );
        opcion2.setActionCommand( OPCION_2 );
        opcion2.addActionListener( this );
        add( opcion2 );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Este método se ejecuta cuando se hace click sobre alguno de los botones.
     * @param pEvento El evento del click sobre uno de los botones.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );

        if( BOTON_INICIAR.equals( comando ) )
        {
            principal.reiniciar( );
        }
        else if( OPCION_1.equals( comando ) )
        {
            principal.reqFuncOpcion1( );
        }
        else if( OPCION_2.equals( comando ) )
        {
            principal.reqFuncOpcion2( );
        }else if(BOTON_CARGAR.equals(comando)){
        	principal.mostrarDialogoCargar();
        }
    }
}
