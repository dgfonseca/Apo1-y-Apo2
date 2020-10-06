/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: BarraMenu.java,v 1.1 2007/03/22 16:13:00 p-marque Exp $ 
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Todos los derechos reservados 2005 
 *
 * Proyecto Cupi2 
 * Ejercicio: n10_mapaCiudad 
 * Autor: Mario Sánchez - 27/09/2005 
 * Modificada por: Daniel Romero - 31/01/2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.mapaCiudad.interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * Esta es la barra que contiene los menús de la aplicación
 */
public class BarraMenu extends JMenuBar implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    /**
     * Constante para un nuevo mapa.
     */
    private static final String NUEVO = "Nuevo";
    /**
     * Constante para abrir un mapa.
     */
    private static final String ABRIR = "Abrir";
    /**
     * Constante para guardar un mapa.
     */
    private static final String GUARDAR = "Guardar";
    /**
     * Constante para guardar y decir como se llama y donde se úbica un mapa.
     */
    private static final String GUARDAR_COMO = "GuardarComo";
    /**
     * Constante para salir del programa.
     */
    private static final String SALIR = "Salir";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es una referencia a la clase principal de la interfaz
     */
    private InterfazMapaCiudad principal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * El menú Archivo
     */
    private JMenu menuArchivo;

    /**
     * La opción Nuevo del menú Archivo
     */
    private JMenuItem itemNuevo;

    /**
     * La opción Abrir del menú Archivo
     */
    private JMenuItem itemAbrir;

    /**
     * La opción Salvar del menú Archivo
     */
    private JMenuItem itemSalvar;

    /**
     * La opción Salvar Como del menú Archivo
     */
    private JMenuItem itemSalvarComo;

    /**
     * La opción Salir del menú Archivo
     */
    private JMenuItem itemSalir;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye la barra de menú
     * @param ip Es una referencia a la clase principal de la interfaz
     */
    public BarraMenu( InterfazMapaCiudad ip )
    {
        principal = ip;

        menuArchivo = new JMenu( "Archivo" );
        menuArchivo.setMnemonic( KeyEvent.VK_A );
        add( menuArchivo );

        itemNuevo = new JMenuItem( "Nuevo" );
        itemNuevo.setActionCommand( NUEVO );
        itemNuevo.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_N, ActionEvent.CTRL_MASK ) );
        itemNuevo.setMnemonic( KeyEvent.VK_N );
        itemNuevo.addActionListener( this );
        menuArchivo.add( itemNuevo );

        itemAbrir = new JMenuItem( "Abrir" );
        itemAbrir.setActionCommand( ABRIR );
        itemAbrir.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_A, ActionEvent.CTRL_MASK ) );
        itemAbrir.setMnemonic( KeyEvent.VK_A );
        itemAbrir.addActionListener( this );
        menuArchivo.add( itemAbrir );

        itemSalvar = new JMenuItem( "Guardar" );
        itemSalvar.setActionCommand( GUARDAR );
        itemSalvar.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_S, ActionEvent.CTRL_MASK ) );
        itemSalvar.setMnemonic( KeyEvent.VK_S );
        itemSalvar.addActionListener( this );
        menuArchivo.add( itemSalvar );

        itemSalvarComo = new JMenuItem( "Guardar Como" );
        itemSalvarComo.setActionCommand( GUARDAR_COMO );
        itemSalvarComo.setMnemonic( KeyEvent.VK_C );
        itemSalvarComo.addActionListener( this );
        menuArchivo.add( itemSalvarComo );

        menuArchivo.addSeparator( );

        itemSalir = new JMenuItem( "Salir" );
        itemSalir.setActionCommand( SALIR );
        itemSalir.addActionListener( this );
        menuArchivo.add( itemSalir );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Ejecuta la acción que corresponde a la opción del menú que fue seleccionada
     * @param evento Es el evento de seleccionar una opción del menú
     */
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );

        if( NUEVO.equals( comando ) )
        {
            principal.reiniciar( );
        }
        else if( ABRIR.equals( comando ) )
        {
            principal.abrir( );
        }
        else if( GUARDAR.equals( comando ) )
        {
            principal.salvar( );
        }
        else if( GUARDAR_COMO.equals( comando ) )
        {
            principal.salvarComo( );
        }
        else if( SALIR.equals( comando ) )
        {
            principal.dispose( );
        }
    }

}