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
import java.io.File;

import javax.swing.*;

import uniandes.cupi2.parqueadero.mundo.Carro;
import uniandes.cupi2.parqueadero.mundo.Parqueadero;

/**
 * Esta clase representa la ventana de interacci�n del parqueadero.
 */
@SuppressWarnings("serial")
public class InterfazParqueadero extends JFrame
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa la ubicaci�n del archivo con los datos del parqueadero.
     */
    public final static String ARCHIVO_SERIALIZACION = "./data/parqueadero.data";
    
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Parqueadero que se est� administrando.
     */
    private Parqueadero parqueadero;

    // -----------------------------------------------------------------
    // Componentes de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel que muestra el banner de la aplicaci�n.
     */
    private PanelImagen panelImagen;

    /**
     * Panel que muestra la lista de los carros en el parqueadero.
     */
    private PanelLista panelLista;

    /**
     * Panel que muestra el parqueadero.
     */
    private PanelParqueadero panelParqueadero;

    /**
     * Panel donde se realizan las operaciones.
     */
    private PanelOperaciones panelOperaciones;

    /**
     * Panel que muestra informaci�n sobre el parqueadero.
     */
    private PanelInformacion panelInformacion;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Sirve para construir la interfaz.
     */
    public InterfazParqueadero( )
    {
        setTitle( "Parqueadero" );
        setSize( 750, 700 );
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );

        // Construir los paneles
        panelImagen = new PanelImagen( );
        panelLista = new PanelLista( this );
        panelParqueadero = new PanelParqueadero( this );
        panelOperaciones = new PanelOperaciones( this );
        panelOperaciones.setPreferredSize( new Dimension( 570, 100 ) );
        panelInformacion = new PanelInformacion( this );
        JPanel centro = new JPanel( );
        centro.setLayout( new BorderLayout( ) );
        JPanel sur = new JPanel( );
        sur.setLayout( new BorderLayout( ) );

        // Organizar el panel principal
        getContentPane( ).setLayout( new BorderLayout( ) );
        getContentPane( ).add( panelImagen, BorderLayout.NORTH );
        getContentPane( ).add( panelLista, BorderLayout.EAST );
        getContentPane( ).add( centro, BorderLayout.CENTER );
        centro.add( panelParqueadero, BorderLayout.CENTER );
        centro.add( sur, BorderLayout.SOUTH );
        sur.add( panelOperaciones, BorderLayout.CENTER );
        sur.add( panelInformacion, BorderLayout.SOUTH );

        setLocationRelativeTo( null );
        setResizable( false );

        try
        {
            parqueadero = new Parqueadero( ARCHIVO_SERIALIZACION );
            actualizar( );
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Cargar", JOptionPane.ERROR_MESSAGE );
        }
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Este m�todo maneja la salida del usuario, dando la opci�n de guardar el estado del mundo.
     */
    public void dispose( )
    {
        int resultado = JOptionPane.showConfirmDialog( this, "�Desea guardar el estado del parqueadero antes de salir?", "Guardar", JOptionPane.INFORMATION_MESSAGE );
        if( resultado == JOptionPane.OK_OPTION )
        {
            try
            {
                parqueadero.guardar( ARCHIVO_SERIALIZACION );
            }
            catch( Exception e )
            {
                JOptionPane.showMessageDialog( this, e.getMessage( ), "Guardar", JOptionPane.ERROR_MESSAGE );
            }
            super.dispose( );

        }
        else if( resultado == JOptionPane.CANCEL_OPTION )
        {
            // No se cierra la aplicaci�n
        }
        else
        {
            super.dispose( );
        }

    }
    
    /**
     * Avanza una hora el reloj del parqueadero.
     */
    public void avanzar( )
    {
        parqueadero.avanzarHora( );
        actualizar( );
        if(!parqueadero.estaAbierto( ))
        {
            panelOperaciones.deshabilitarAvanzar();
        }
        
    }
    
    /**
     * Avanza un d�a en el parqueadero.
     */
    public void siguienteDia( )
    {
        parqueadero.siguienteDia( );
        actualizar( );        
    }

    /**
     * Muestra un mensaje con la placa del carro que se encuentra en el puesto indicado.
     * @param pPuesto Puesto del que se desea conocer la placa.
     */
    public void darPlacaPorPuesto( int pPuesto )
    {
        try
        {
            String placa = parqueadero.darPlacaCarro( pPuesto );
            JOptionPane.showMessageDialog( this, placa, "Placa", JOptionPane.INFORMATION_MESSAGE );
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Dar Placa Por Puesto", JOptionPane.INFORMATION_MESSAGE );
        }
    }

    /**
     * Crea una ventana de di�logo para ingresar un carro al parqueadero.
     */
    public void dialogoIngresar( )
    {
        DialogoIngresar dialogo = new DialogoIngresar( this );
        dialogo.setVisible( true );
    }

    /**
     * Este m�todo sirve para ingresar un carro al parqueadero. Debe preguntar la placa, la marca y el modelo del carro e informar la posici�n donde debe estacionarse. <br>
     * Si no se puede parquear, porque el parqueadero est� cerrado o porque no hay ning�n lugar disponible, debe informar del error.
     * @param pMarca Marca del carro a ingresar.
     * @param pModelo Modelo del carro a ingresar.
     * @param pPlaca Placa del carro a ingresar.
     * @param pVentana Ventana de di�logo.
     */
    public void ingresarCarro( String pMarca, String pModelo, String pPlaca, DialogoIngresar pVentana )
    {
        try
        {
            if(pPlaca.length( ) != 6)
            {
                JOptionPane.showMessageDialog( this, "El formato de la placa no es v�lido", "Ingresar Carro", JOptionPane.ERROR_MESSAGE );
            }
            else
            {
                int puesto = parqueadero.ingresarCarro( pPlaca, pMarca, pModelo );
                actualizar( );
                pVentana.dispose( );
                JOptionPane.showMessageDialog( this, "Bienvenido:\n Su carro qued� parqueado en el puesto: " + ( puesto + 1 ) );
            }
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ) );
        }

    }

    /**
     * Cambia la tarifa del parqueadero. Pide una tarifa al usuario, si esta tarifa no es v�lida informa al usuario.
     */
    public void cambiar( )
    {
        String tarifa = JOptionPane.showInputDialog( this, "Por favor digite la nueva tarifa", "Nueva tarifa", JOptionPane.QUESTION_MESSAGE );
        if( tarifa != null )
        {
            try
            {
                int tarifaNumero = Integer.parseInt( tarifa );
                if( tarifaNumero <= 0 )
                {
                    JOptionPane.showMessageDialog( this, "Ingrese una tarifa v�lida", "Tarifa inv�lida", JOptionPane.ERROR_MESSAGE );
                }
                else
                {
                    parqueadero.cambiarTarifa( tarifaNumero );
                    panelOperaciones.cambiarTarifa( tarifaNumero );
                    JOptionPane.showMessageDialog( this, "Se ha cambiado la tarifa", "Nueva tarifa", JOptionPane.INFORMATION_MESSAGE );
                }
            }
            catch( Exception e )
            {
                JOptionPane.showMessageDialog( this, "Ingrese una tarifa v�lida", "Tarifa inv�lida", JOptionPane.ERROR_MESSAGE );
            }
        }

    }

    /**
     * Este m�todo sirve para sacar un carro del parqueadero. Debe pedir la placa y luego contactar al parqueadero para sacar el carro y saber <br>
     * cu�nto debe cancelar. Si la placa no corresponde a un carro que est� en el parqueadero entonces debe informar al usuario.
     * @param pCarro Carro al cual se dar� salida.
     */
    public void sacarCarro( Carro pCarro )
    {
        if( pCarro != null )
        {
            try
            {
                String placa = pCarro.darPlaca( );
                parqueadero.sacarCarro( placa );
                actualizar( );
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog( this, e.getMessage( ), "Sacar Carro", JOptionPane.ERROR_MESSAGE );
            }            
        }
        else
        {
            JOptionPane.showMessageDialog( this, "Debes seleccionar un carro para darle salida", "Sacar Carro", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Ordena los carros de forma ascendente en el parqueadero por su marca.
     */
    public void ordenarPorMarca( )
    {
        parqueadero.ordenarPorMarca( );
        actualizar( );
    }

    /**
     * Ordena los carros de forma descendente en el parqueadero por su modelo.
     */
    public void ordenarPorModelo( )
    {
        parqueadero.ordenarPorModelo( );
        actualizar( );
    }

    /**
     * Ordena los carros de forma ascendente en el parqueadero por su hora de ingreso.
     */
    public void ordenarPorHora( )
    {
        parqueadero.ordenarPorHoraIngreso( );
        actualizar( );
    }

    /**
     * Busca un carro por su placa. Pide una placa al usuario, si esta placa no pertenece a ning�n carro se informa al usuario.
     */
    public void buscarPorPlaca( )
    {
        String placa = JOptionPane.showInputDialog( this, "Por favor digite la placa", "Buscar por placa", JOptionPane.QUESTION_MESSAGE );
        if( placa != null )
        {
            try
            {
                Carro carro = parqueadero.buscarCarroPorPlaca( placa );
                if( carro != null )
                {
                    panelLista.cambiarSeleccionado( carro );
                    panelParqueadero.iluminarCarro( parqueadero.buscarPuestoCarroPorPlaca( carro.darPlaca( ) ) );
                }
                else
                {
                    JOptionPane.showMessageDialog( this, "No se encontr� un carro con esta placa", "Buscar por placa", JOptionPane.ERROR_MESSAGE );

                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog( this, e.getMessage( ), "Buscar por placa", JOptionPane.ERROR_MESSAGE );
            }
        }

    }

    /**
     * Busca un carro por su hora de ingreso. Pide la hora al usuario, si esta hora de ingreso no pertenece a ning�n carro se informa al usuario.
     */
    public void buscarPorHora( )
    {
        String hora = JOptionPane.showInputDialog( this, "Por favor digite la hora de ingreso (valor de 0 a 23)", "Buscar por hora de ingreso", JOptionPane.QUESTION_MESSAGE );
        if( hora != null )
        {
            try
            {
                int horaIngreso = Integer.parseInt( hora );
                if( horaIngreso <= 0 )
                {
                    JOptionPane.showMessageDialog( this, "Ingrese una hora v�lida", "Hora inv�lida", JOptionPane.ERROR_MESSAGE );
                }
                else
                {
                    Carro carro = parqueadero.buscarPorHoraIngreso( horaIngreso );
                    if( carro != null )
                    {
                        panelLista.cambiarSeleccionado( carro );
                        panelParqueadero.iluminarCarro( parqueadero.buscarPuestoCarroPorPlaca( carro.darPlaca( ) ) );

                    }
                    else
                    {
                        JOptionPane.showMessageDialog( this, "No se encontr� un carro con esta hora", "Buscar por hora de ingreso", JOptionPane.ERROR_MESSAGE );

                    }
                }
            }
            catch( Exception e )
            {
                JOptionPane.showMessageDialog( this, "Ingrese una hora v�lida", "Hora inv�lida", JOptionPane.ERROR_MESSAGE );
            }
        }

    }
    
    /**
     * Carga el estado del mundo a partir de un archivo de texto.
     */
    public void cargar( )
    {
        JFileChooser chooser = new JFileChooser( "./data" );
        chooser.setDialogTitle( "Cargar" );
        int returnVal = chooser.showSaveDialog( this );
        if( returnVal == JFileChooser.APPROVE_OPTION )
        {
            File archivo = chooser.getSelectedFile( );
            try
            {
                parqueadero.importarArchivoTexto( archivo );
                actualizar();
            }
            catch( Exception e )
            {
                e.printStackTrace( );
                JOptionPane.showMessageDialog( this, e.getMessage( ), "Cargar archivo", JOptionPane.ERROR_MESSAGE );
            }
        }
    }

    /**
     * Genera un archivo de reporte con las ganancias estimadas del parqueadero.
     */
    public void generarReporte( )
    {
        try
        {
            String nombreReporte = JOptionPane.showInputDialog( this, "Introduzca el nombre para el reporte", "Generar Reporte", JOptionPane.INFORMATION_MESSAGE );
            if(nombreReporte != null)
            {
                parqueadero.generarReporte( "./data/" + nombreReporte + ".txt" );
                JOptionPane.showMessageDialog( this, "Reporte generado.", "Generar Reporte", JOptionPane.INFORMATION_MESSAGE );
            }
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Generar Reporte", JOptionPane.ERROR_MESSAGE );
        }

    }

    /**
     * Actualiza los datos que se presentan en la interfaz.
     */
    public void actualizar( )
    {
        panelParqueadero.refrescarParqueadero( parqueadero.darPuestos( ) );
        panelOperaciones.cambiarHora( parqueadero.darHoraActual( ) );
        panelOperaciones.cambiarTarifa( parqueadero.darTarifa( ) );
        panelInformacion.actualizarDatos( parqueadero.calcularCantidadPuestosLibres( ), parqueadero.darMontoCaja( ) );
        panelLista.actualizar( parqueadero.darCarros( ) );
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * Este m�todo ejecuta la opci�n 1.
     */
    public void reqFuncOpcion1( )
    {
        String respuesta = parqueadero.metodo1( );
        actualizar( );
        JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Este m�todo ejecuta la opci�n 2.
     */
    public void reqFuncOpcion2( )
    {
        String respuesta = parqueadero.metodo2( );
        actualizar( );
        JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Ejecuta la aplicaci�n.
     * @param pArgs Par�metros de la ejecuci�n. No son necesarios.
     */
    public static void main( String[] pArgs )
    {
        try
        {
            // Unifica la interfaz para Mac y para Windows.
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );

            InterfazParqueadero manejador = new InterfazParqueadero( );
            manejador.setVisible( true );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
    }
}