/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad  de  los Andes   (Bogot� - Colombia)
 * Departamento de  Ingenier�a  de  Sistemas    y   Computaci�n
 * Licenciado   bajo    el  esquema Academic Free License versi�n 2.1
 *      
 * Proyecto Cupi2   (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_Parqueadero
 * Autor: Equipo Cupi2 2018
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.parqueadero.interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

import uniandes.cupi2.parqueadero.mundo.Carro;

/**
 * Panel para ver la informaci�n de los carros actuales en el parqueadero.
 */
@SuppressWarnings("serial")
public class PanelLista extends JPanel implements ActionListener, ListSelectionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando para ingresar un carro al parqueadero.
     */
    private final static String INGRESAR_CARRO = "Ingresar Carro";

    /**
     * Comando para sacar un carro del parqueadero.
     */
    public final static String SACAR_CARRO = "Sacar Carro";

    /**
     * Comando para ordenar los carros por su marca.
     */
    public final static String ORDENAR_POR_MARCA = "Ordenar por marca";

    /**
     * Comando para ordenar los carros por su modelo.
     */
    public final static String ORDENAR_POR_MODELO = "Ordenar por modelo";

    /**
     * Comando para ordenar los carros por su hora de ingreso.
     */
    public final static String ORDENAR_POR_HORA = "Ordenar por hora de ingreso";

    /**
     * Comando para buscar un carro por su placa.
     */
    public final static String BUSCAR_POR_PLACA = "Buscar por placa";

    /**
     * Comando para buscar un carro por su hora de ingreso.
     */
    public final static String BUSCAR_POR_HORA = "Buscar por hora de ingreso";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Instancia principal de la aplicaci�n.
     */
    private InterfazParqueadero interfaz;

    /**
     * Carro actual seleccionado.
     */
    private Carro carroActual;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Objeto scroll para la lista de carros del parqueadero.
     */
    private JScrollPane scroll;

    /**
     * Lista de las carros en el parqueadero.
     */
    // TODO HECHO Parte 5 Punto A: Declarar el atributo listaCarros de tipo JList.
    private JList listaCarros;

    /**
     * Bot�n para ingresar un carro al parqueadero.
     */
    private JButton botonIngresarCarro;

    /**
     * Bot�n para sacar un carro del parqueadero.
     */
    private JButton btnSacarCarro;

    /**
     * Bot�n para ordenar los carros por marca.
     */
    private JButton btnOrdenarPorMarca;

    /**
     * Bot�n para ordenar los carros por modelo.
     */
    private JButton btnOrdenarPorModelo;

    /**
     * Bot�n para ordenar los carros por hora de ingreso.
     */
    private JButton btnOrdenarPorHora;

    /**
     * Bot�n para buscar un carro por su placa.
     */
    private JButton btnBuscarPorPlaca;

    /**
     * Bot�n para buscar un carro por su hora de ingreso.
     */
    private JButton btnBuscarPorHora;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el panel con la informaci�n de los carros en el parqueadero.
     * @param pPrincipal Instancia principal de la aplicaci�n. pPrincipal != null.
     */
    public PanelLista( InterfazParqueadero pPrincipal )
    {
        interfaz = pPrincipal;
        setLayout( new BorderLayout( ) );
        
        JPanel principal = new JPanel();
        principal.setLayout( new BorderLayout( ) );

        // TODO HECHO Parte 5 Punto B: Inicialice el atributo listaBandas.
        listaCarros = new JList();
        listaCarros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaCarros.addListSelectionListener(this);
        // TODO HECHO Parte 5 Punto C: Agregue el ListSelecionListener al atributo listaBandas.
        
        scroll = new JScrollPane( );
        TitledBorder titulo = new TitledBorder( "Carros en el parqueadero" );
        principal.setBorder( titulo );
        scroll.setViewportView( listaCarros );
        scroll.setPreferredSize( new Dimension( 200, 200 ) );
        scroll.setVerticalScrollBarPolicy( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
        scroll.setHorizontalScrollBarPolicy( ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS );
        principal.add( scroll, BorderLayout.CENTER );
        add( principal, BorderLayout.CENTER );

        JPanel botones = new JPanel( );
        botones.setLayout( new BorderLayout( ) );
        add( botones, BorderLayout.SOUTH );

        JPanel acciones = new JPanel( );
        acciones.setLayout( new GridLayout( 2, 1, 3, 3 ) );
        principal.add(acciones, BorderLayout.SOUTH);

        JPanel ordenar = new JPanel( );
        ordenar.setLayout( new GridLayout( 3, 1, 3, 3 ) );
        ordenar.setBorder( new TitledBorder( "Ordenamientos" ) );

        JPanel busquedas = new JPanel( );
        busquedas.setLayout( new GridLayout( 2, 1, 3, 3 ) );
        busquedas.setBorder( new TitledBorder( "B�squedas" ) );

        botonIngresarCarro = new JButton( );
        botonIngresarCarro.setText( "Ingresar Carro" );
        botonIngresarCarro.setActionCommand( INGRESAR_CARRO );
        botonIngresarCarro.addActionListener( this );
        acciones.add( botonIngresarCarro );

        btnSacarCarro = new JButton( SACAR_CARRO );
        btnSacarCarro.setActionCommand( SACAR_CARRO );
        btnSacarCarro.addActionListener( this );
        acciones.add( btnSacarCarro );

        btnOrdenarPorMarca = new JButton( ORDENAR_POR_MARCA );
        btnOrdenarPorMarca.setActionCommand( ORDENAR_POR_MARCA );
        btnOrdenarPorMarca.addActionListener( this );
        ordenar.add( btnOrdenarPorMarca );

        btnOrdenarPorModelo = new JButton( ORDENAR_POR_MODELO );
        btnOrdenarPorModelo.setActionCommand( ORDENAR_POR_MODELO );
        btnOrdenarPorModelo.addActionListener( this );
        ordenar.add( btnOrdenarPorModelo );

        btnOrdenarPorHora = new JButton( ORDENAR_POR_HORA );
        btnOrdenarPorHora.setActionCommand( ORDENAR_POR_HORA );
        btnOrdenarPorHora.addActionListener( this );
        ordenar.add( btnOrdenarPorHora );

        btnBuscarPorPlaca = new JButton( BUSCAR_POR_PLACA );
        btnBuscarPorPlaca.setActionCommand( BUSCAR_POR_PLACA );
        btnBuscarPorPlaca.addActionListener( this );
        busquedas.add( btnBuscarPorPlaca );

        btnBuscarPorPlaca = new JButton( BUSCAR_POR_HORA );
        btnBuscarPorPlaca.setActionCommand( BUSCAR_POR_HORA );
        btnBuscarPorPlaca.addActionListener( this );
        busquedas.add( btnBuscarPorPlaca );

        botones.add( ordenar, BorderLayout.CENTER );
        botones.add( busquedas, BorderLayout.SOUTH );

    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Actualiza el panel con la informaci�n que entra por par�metro.
     * @param pcarros Carros actualmente en el parqueadero.
     * @param pActual Carro reci�n ingresado.
     */
    public void actualizar( ArrayList pcarros )
    {
        // TODO HECHO Parte 5 Punto D: Asigne la lista de carros al atributo listaCarros.
    	listaCarros.setListData(pcarros.toArray());
    	listaCarros.setSelectedIndex(0);
        if( carroActual != null )
        {
            cambiarSeleccionado( carroActual );
        }

    }

    /**
     * Actualiza el carro seleccionado.
     * @param pCarro Carro a seleccionar.
     */
    public void cambiarSeleccionado( Carro pCarro )
    {
        listaCarros.setSelectedValue( pCarro, true );
        carroActual = pCarro;
    }

    /**
     * Manejo de los eventos de la lista.
     * @param pEvento Acci�n que gener� el evento.
     */
    public void valueChanged( ListSelectionEvent pEvento )
    {
        carroActual = ( Carro )listaCarros.getSelectedValue( );
        
    }

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acci�n que gener� el evento.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( comando.equals( INGRESAR_CARRO ) )
        {
            interfaz.dialogoIngresar( );
        }
        else if( comando.equals( SACAR_CARRO ) )
        {
            interfaz.sacarCarro( carroActual );
        }
        else if( comando.equals( ORDENAR_POR_MARCA ) )
        {
            interfaz.ordenarPorMarca( );
        }
        else if( comando.equals( ORDENAR_POR_MODELO ) )
        {
            interfaz.ordenarPorModelo( );
        }
        else if( comando.equals( ORDENAR_POR_HORA ) )
        {
            interfaz.ordenarPorHora( );
        }
        else if( comando.equals( BUSCAR_POR_PLACA ) )
        {
            interfaz.buscarPorPlaca( );
        }
        else if( comando.equals( BUSCAR_POR_HORA ) )
        {
            interfaz.buscarPorHora( );
        }

    }

}
