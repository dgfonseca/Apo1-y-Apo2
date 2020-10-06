/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: BarraMenu.java,v 1.6 2006/12/01 15:10:00 jvillalo2 Exp $ 
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n10_paint
 * Autor: Mario S�nchez - 27/09/2005 
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.paint.interfaz;

import java.awt.event.*;

import javax.swing.*;

/**
 * Esta es la barra que contiene los men�s de la aplicaci�n
 */
public class BarraMenu extends JMenuBar implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    private static final String NUEVO = "Nuevo";

    private static final String ABRIR = "Abrir";

    private static final String SALVAR = "Salvar";

    private static final String SALVAR_COMO = "SalvarComo";

    private static final String SALIR = "Salir";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es una referencia a la clase principal de la interfaz
     */
    private InterfazPaint principal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * El men� Archivo
     */
    private JMenu menuArchivo;

    /**
     * La opci�n Nuevo del men� Archivo
     */
    private JMenuItem itemNuevo;

    /**
     * La opci�n Abrir del men� Archivo
     */
    private JMenuItem itemAbrir;

    /**
     * La opci�n Salvar del men� Archivo
     */
    private JMenuItem itemSalvar;

    /**
     * La opci�n Salvar Como del men� Archivo
     */
    private JMenuItem itemSalvarComo;

    /**
     * La opci�n Salir del men� Archivo
     */
    private JMenuItem itemSalir;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye la barra de men�
     * @param ip Es una referencia a la clase principal de la interfaz
     */
    public BarraMenu( InterfazPaint ip )
    {
        principal = ip;

        menuArchivo = new JMenu( "Archivo" );
        add( menuArchivo );

        itemNuevo = new JMenuItem( "Nuevo" );
        itemNuevo.setActionCommand( NUEVO );
        itemNuevo.addActionListener( this );
        menuArchivo.add( itemNuevo );

        itemAbrir = new JMenuItem( "Abrir" );
        itemAbrir.setActionCommand( ABRIR );
        itemAbrir.addActionListener( this );
        menuArchivo.add( itemAbrir );

        itemSalvar = new JMenuItem( "Salvar" );
        itemSalvar.setActionCommand( SALVAR );
        itemSalvar.addActionListener( this );
        menuArchivo.add( itemSalvar );

        itemSalvarComo = new JMenuItem( "Salvar Como" );
        itemSalvarComo.setActionCommand( SALVAR_COMO );
        itemSalvarComo.addActionListener( this );
        menuArchivo.add( itemSalvarComo );

        menuArchivo.addSeparator( );

        itemSalir = new JMenuItem( "Salir" );
        itemSalir.setActionCommand( SALIR );
        itemSalir.addActionListener( this );
        menuArchivo.add( itemSalir );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Ejecuta la acci�n que corresponde a la opci�n del men� que fue seleccionada
     * @param evento Es el evento de seleccionar una opci�n del men� - evento!=null
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
        else if( SALVAR.equals( comando ) )
        {
            principal.salvar( );
        }
        else if( SALVAR_COMO.equals( comando ) )
        {
            principal.salvarComo( );
        }
        else if( SALIR.equals( comando ) )
        {
            principal.dispose( );
        }
    }

}