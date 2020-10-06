/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad  de  los Andes   (Bogotá - Colombia)
 * Departamento de  Ingeniería  de  Sistemas    y   Computación
 * Licenciado   bajo    el  esquema Academic Free License versión 2.1
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
 * Panel para ver la información de los carros actuales en el parqueadero.
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
     * Comando para ordenar los carros del parqueadero.
     */
    public final static String ORDENAR = "Ordenar los carros";

    /**
     * Comando para buscar un carro.
     */
    public final static String BUSCAR = "Buscar un carro";

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
     * Instancia principal de la aplicación.
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
    private JList listacarros;

    /**
     * Botón para ingresar un carro al parqueadero.
     */
    private JButton botonIngresarCarro;

    /**
     * Botón para sacar un carro del parqueadero.
     */
    private JButton btnSacarCarro;

    /**
     * Combo box con las opciones de ordenamiento.
     */
    private JComboBox comboOrdenamiento;
    // TODO HECHO Parte 5 punto A: Declarar el atributo comboOrdenamiento.

    /**
     * Combo box con las opciones de búsqueda.
     */
    private JComboBox comboBusqueda;
    // TODO HECHO Parte 5 punto A: Declarar el atributo comboBusqueda.

    /**
     * Botón para ordenar las bandas.
     */
    private JButton btnOrdenar;

    /**
     * Botón para buscar una banda.
     */
    private JButton btnBuscar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el panel con la información de los carros en el parqueadero.
     * @param pPrincipal Instancia principal de la aplicación. pPrincipal != null.
     */
    public PanelLista( InterfazParqueadero pPrincipal )
    {
        interfaz = pPrincipal;
        setLayout( new BorderLayout( ) );
        
        JPanel principal = new JPanel();
        principal.setLayout( new BorderLayout( ) );

        listacarros = new JList( );
        listacarros.addListSelectionListener( this );
        scroll = new JScrollPane( );
        TitledBorder titulo = new TitledBorder( "Carros en el parqueadero" );
        principal.setBorder( titulo );
        scroll.setViewportView( listacarros );
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
        ordenar.setLayout( new GridLayout( 2, 1, 3, 3 ) );
        ordenar.setBorder( new TitledBorder( "Ordenamientos" ) );

        JPanel busquedas = new JPanel( );
        busquedas.setLayout( new GridLayout( 2, 1, 3, 3 ) );
        busquedas.setBorder( new TitledBorder( "Búsquedas" ) );

        botonIngresarCarro = new JButton( );
        botonIngresarCarro.setText( "Ingresar Carro" );
        botonIngresarCarro.setActionCommand( INGRESAR_CARRO );
        botonIngresarCarro.addActionListener( this );
        acciones.add( botonIngresarCarro );

        btnSacarCarro = new JButton( SACAR_CARRO );
        btnSacarCarro.setActionCommand( SACAR_CARRO );
        btnSacarCarro.addActionListener( this );
        acciones.add( btnSacarCarro );

        //TODO HECHO Parte 5 punto B: Inicializar el atributo comboOrdenamiento.
        //TODO Parte 5 punto C: Añadir los items de los tipos de ordenamiento a comboOrdenamiento
        comboOrdenamiento=new JComboBox();
        comboOrdenamiento.addActionListener(this);
        comboOrdenamiento.setActionCommand(ORDENAR_POR_MODELO);
        comboOrdenamiento.setActionCommand(ORDENAR_POR_HORA);
        comboOrdenamiento.setActionCommand(ORDENAR_POR_MARCA);
        comboOrdenamiento.setEditable(false);
        comboOrdenamiento.addItem(ORDENAR_POR_HORA);
        comboOrdenamiento.addItem(ORDENAR_POR_MARCA);
        comboOrdenamiento.addItem(ORDENAR_POR_MODELO);
        ordenar.add( comboOrdenamiento );
        

        btnOrdenar = new JButton( ORDENAR );
        btnOrdenar.addActionListener( this );
        btnOrdenar.setActionCommand( ORDENAR );
        ordenar.add( btnOrdenar );

        //TODO HECHO Parte 5 punto B: Inicializar el atributo comboBusqueda.
        //TODO Parte 5 punto C: Añadir los items de los tipos de ordenamiento a comboBusqueda.
        comboBusqueda=new JComboBox();
        comboBusqueda.setEditable(false);
        comboBusqueda.setActionCommand(BUSCAR_POR_HORA);
        comboBusqueda.setActionCommand(BUSCAR_POR_PLACA);
        comboBusqueda.addItem(BUSCAR_POR_HORA);
        comboBusqueda.addItem(BUSCAR_POR_PLACA);
        busquedas.add( comboBusqueda );

        btnBuscar = new JButton( BUSCAR );
        btnBuscar.addActionListener( this );
        btnBuscar.setActionCommand( BUSCAR );
        busquedas.add( btnBuscar );

        botones.add( ordenar, BorderLayout.CENTER );
        botones.add( busquedas, BorderLayout.SOUTH );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Actualiza el panel con la información que entra por parámetro.
     * @param pcarros Carros actualmente en el parqueadero.
     * @param pActual Carro recién ingresado.
     */
    public void actualizar( ArrayList pcarros )
    {
        listacarros.setListData( pcarros.toArray( ) );
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
        listacarros.setSelectedValue( pCarro, true );
        carroActual = pCarro;
    }

    /**
     * Manejo de los eventos de la lista.
     * @param pEvento Acción que generó el evento.
     */
    public void valueChanged( ListSelectionEvent pEvento )
    {
        carroActual = ( Carro )listacarros.getSelectedValue( );        
    }

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acción que generó el evento.
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
        if( comando.equals( ORDENAR ) )
        {
            String ordenamiento=pEvento.getActionCommand();
        	//TODO Parte 5 punto D: Crear la variable tipo String ordenamiento para obtener el tipo de ordenamiento seleccionado de comboOrdenamiento.
            if( ordenamiento.equals( ORDENAR_POR_MARCA ) )
            {
                interfaz.ordenarPorMarca( );
            }
            else if( ordenamiento.equals( ORDENAR_POR_MODELO ) )
            {
                interfaz.ordenarPorModelo( );
            }
            else if( ordenamiento.equals( ORDENAR_POR_HORA ) )
            {
                interfaz.ordenarPorHora( );
            }
        }
        else if( comando.equals( BUSCAR ) )
        {
            String busqueda=pEvento.getActionCommand();
        	//TODO HECHO Parte 5 punto DÑ Crear la variable tipo String busqueda para obtener el tipo de búsqueda seleccionado de comboBusqueda.
            if( busqueda.equals( BUSCAR_POR_PLACA ) )
            {
                interfaz.buscarPorPlaca( );
            }
            else if( busqueda.equals( BUSCAR_POR_HORA ) )
            {
                interfaz.buscarPorHora( );
            }
        }
    }

}
