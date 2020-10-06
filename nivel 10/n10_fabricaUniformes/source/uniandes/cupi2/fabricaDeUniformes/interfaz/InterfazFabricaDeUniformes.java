/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n10_FabricaDeUniformes
 * Autor: Equipo Cupi2 2018-1
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.fabricaDeUniformes.interfaz;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

import uniandes.cupi2.fabricaDeUniformes.mundo.Camiseta;
import uniandes.cupi2.fabricaDeUniformes.mundo.IParte;
import uniandes.cupi2.fabricaDeUniformes.mundo.Parte;
import uniandes.cupi2.fabricaDeUniformes.mundo.Uniforme;
import uniandes.cupi2.fabricaDeUniformes.mundo.CamisetaConRaya;

/**
 * Ventana principal de la aplicación.
 */
@SuppressWarnings("serial")
public class InterfazFabricaDeUniformes extends JFrame
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase principal del mundo.
     */
    private Uniforme uniforme;

    /**
     * Parte actualmente seleccionado.
     */
    private IParte seleccionado;

    /**
     * Parte que se está creando.
     */
    private IParte sombreado;

    /**
     * Arreglo con las diferentes opciones de selección.
     */
    private ArrayList<String> opcionesSeleccion;

    /**
     * Primer color seleccionado.
     */
    private Color color;

    /**
     * Ruta hasta el último directorio de donde se cargó o guardó un archivo.
     */
    private String ultimoDirectorio;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel que contiene la imagen del encabezado.
     */
    private PanelImagen panelImagen;

    /**
     * Panel con las extensiones.
     */
    private PanelExtension panelExtension;

    /**
     * Panel donde se muestran los botones para controlar la aplicación.
     */
    private PanelBotones panelBotones;

    /**
     * Panel en el que se muestra y edita el uniforme.
     */
    private PanelUniforme panelUniforme;

    /**
     * Barra del menú.
     */
    private BarraMenu barraMenu;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor de la ventana principal. <br>
     * <b>post: </b> Se inicializaron todos los paneles de la aplicación.
     */
    public InterfazFabricaDeUniformes( )
    {
        // Se crea la clase principal.
        uniforme = new Uniforme( );
        inicializarOpcionesSeleccion( );
        ultimoDirectorio = "./data";

        // Se declara el primer color en la aplicación.
        color = new Color( 153, 204, 255 );

        // Se construye la forma.
        setLayout( new BorderLayout( ) );
        setTitle( "Fabrica de uniformes" );
        barraMenu = new BarraMenu( this );
        setJMenuBar( barraMenu );
        setSize( 1020, 780 );
        setLocationRelativeTo( null );
        setResizable( true );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        // Se crean los paneles.
        panelImagen = new PanelImagen( );
        add( panelImagen, BorderLayout.NORTH );

        panelExtension = new PanelExtension( this );
        add( panelExtension, BorderLayout.SOUTH );

        add( panelExtension, BorderLayout.SOUTH );

        JPanel auxPanelInformacion = new JPanel( );
        auxPanelInformacion.setLayout( new BorderLayout( ) );

        panelBotones = new PanelBotones( this );
        auxPanelInformacion.add( panelBotones, BorderLayout.WEST );

        panelUniforme = new PanelUniforme( this );
        auxPanelInformacion.add( panelUniforme, BorderLayout.CENTER );

        add( auxPanelInformacion, BorderLayout.CENTER );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Inicializa la lista de opciones de selección.
     */
    public void inicializarOpcionesSeleccion( )
    {
        opcionesSeleccion = new ArrayList<String>( );
        opcionesSeleccion.add( "Ninguna" );
        opcionesSeleccion.add( "Seleccionar" );
        opcionesSeleccion.add( "Borrar" );
        ArrayList<String> listaTipos = ( ArrayList<String> )uniforme.darTipos( );
        for( int i = 0; i < listaTipos.size( ); i++ )
        {
            opcionesSeleccion.add( listaTipos.get( i ) );
        }
    }

    /**
     * Retorna la lista de opciones de selección.
     * @return la lista de opciones de selección.
     */
    public ArrayList darOpcionesSeleccion( )
    {
        return opcionesSeleccion;
    }

    /**
     * Retorna la opción seleccionada en el panel de botones.
     * @return La opción actualmente seleccionada.
     */
    public String darOpcionSeleccionada( )
    {
        return panelBotones.darOpcionSeleccionada( );
    }

    /**
     * Intenta eliminar un dibujo dado un punto. <br>
     * Cada Parte debe saber si las coordenadas indicadas sirven para eliminarla o no. <br>
     * <b>post: </b> Si había una parte que se pudiera eliminar en esa posición entonces se elimina.
     * @param pX Coordenada en x del punto. pX >= 0
     * @param pY Coordenada en y del punto. pY >= 0
     * @param pTipo El tipo del dibujo a eliminar. pTipo != null && pTipo != ""
     */
    public void eliminar( int pX, int pY, String pTipo )
    {
        uniforme.eliminarParte( pX, pY, pTipo );
        seleccionado = null;
        panelUniforme.actualizar( );
    }

    /**
     * Intenta eliminar el dibujo seleccionado. <br>
     * <b>post: </b> Si había un dibujo seleccionado, entonces esta se elimina.
     */
    public void eliminar( )
    {
        if( seleccionado != null )
        {
            uniforme.eliminarParte( seleccionado.darX( ), seleccionado.darY( ), seleccionado.darTipo( ) );
            seleccionado = null;
            panelUniforme.actualizar( );
        }
    }

    /**
     * Realiza las acciones posibles cuando está seleccionada la opción de SELECCIONAR.<br>
     * Si no había un dibujo seleccionado, busca el dibujo que contiene los puntos dados y la selecciona.<br>
     * Si había un dibujo seleccionado y los puntos dados se encuentran dentro de la misma Parte, esta se des-selecciona.<br>
     * Si había un dibujo seleccionado y los puntos dados no se encuentran dentro de la misma Parte, cambia el lugar del dibujo.
     * @param pX Coordenada en x del punto. x >= 0.
     * @param pY Coordenada en y del punto. y >= 0.
     */
    public void seleccionar( int pX, int pY )
    {
        if( seleccionado == null )
        {
            seleccionado = uniforme.buscarParte( pX, pY );
        }
        else
        {
            IParte nSeleccionada = uniforme.buscarParte( pX, pY );
            if( nSeleccionada != null && nSeleccionada.equals( seleccionado ) )
            {
                seleccionado = null;
                sombreado = null;
            }
            else
            {
                cambiarPosicionParte( seleccionado.darX( ), seleccionado.darY( ), seleccionado.darTipo( ), pX, pY );
            }
        }
        panelUniforme.actualizar( );
    }

    /**
     * Cambia la posición del dibujo con las características dadas al nuevo punto de coordenadas dadas.<br>
     * <b>post: </b> el dibujo con las características indicadas se encuentra en la nueva posición.
     * @param pXActual Coordenada en x donde se encuentra el dibujo a cambiar de posición. pXActual >= 0.
     * @param pYActual Coordenada en y donde se encuentra el dibujo a cambiar de posición. pYActual >= 0.
     * @param pTipo Tipo del dibujo a cambiar de posición. pTipo != null && pTipo != "".
     * @param pNuevoX Nueva coordenada en x donde se desea posicionar el dibujo. pNuevoX >= 0.
     * @param pNuevoY Nueva coordenada en y donde se desea posicionar el dibujo. pNuevoY >= 0.
     */
    public void cambiarPosicionParte( int pXActual, int pYActual, String pTipo, int pNuevoX, int pNuevoY )
    {
        uniforme.cambiarPosicionParte( pXActual, pYActual, pTipo, pNuevoX, pNuevoY );
        seleccionado = null;
        sombreado = null;
    }

    /**
     * Cambia el dibujo seleccionado.
     * @param pParte Nueva dibujo seleccionado. pParte != null.
     */
    public void cambiarSeleccionada( IParte pParte )
    {
        seleccionado = pParte;
    }

    /**
     * Agrega un dibujo del tipo seleccionado en el panel de botones. <br>
     * <b>post: </b> Se agregó el dibujo y se re-dibujó el lienzo.
     * @param pX La coordenada x del punto superior izquierdo del dibujo. pX >= 0.
     * @param pY La coordenada y del punto superior izquierdo del dibujo. pY >= 0.
     */
    public void agregarParte( int pX, int pY )
    {
        String opcion = darOpcionSeleccionada( );

        Color color = darColor( );
        Parte f = null;
        // f = uniforme.crearParte( opcion, pX, pY, color );
        sombreado.cambiarX( pX );
        sombreado.cambiarY( pY );
        uniforme.agregarParte( sombreado );
        sombreado = null;
        panelBotones.reiniciarSeleccion( );
        panelUniforme.actualizar( );
    }

    /**
     * Retorna el dibujo seleccionado
     * @return seleccionada
     */
    public IParte darSeleccionada( )
    {
        return seleccionado;
    }

    /**
     * Retorna el dibujo a ser pintado sombreado.
     * @return Parte a ser pintado sombreado.
     */
    public IParte darSombreado( )
    {

        return sombreado;
    }

    /**
     * Calcula la sombra del dibujo actual seleccionado.
     * @param pX La coordenada x del punto.pX >= 0.
     * @param pY La coordenada y del punto. pY >= 0.
     */
    public void calcularSombra( int pX, int pY )
    {
        String opcion = darOpcionSeleccionada( );

        // Se calcula la sombra para un dibujo existente
        if( opcionesSeleccion.get( 1 ).equals( opcion ) )
        {
            if( seleccionado != null )
            {
                sombreado = uniforme.crearParte( seleccionado.darTipo( ), pX, pY, seleccionado.darColor( ) );
                if( seleccionado instanceof Camiseta )
                {
                    Camiseta camisetaSom = ( Camiseta )sombreado;
                    Camiseta camisetaSel = ( Camiseta )seleccionado;
                    camisetaSom.cambiarColor2( ( ( Camiseta )seleccionado ).darColorSecundario( ) );
                    camisetaSom.cambiarManga( camisetaSel.darManga( ) );

                }
                if( seleccionado instanceof CamisetaConRaya )
                {
                    CamisetaConRaya camisetaSom = ( CamisetaConRaya )sombreado;
                    CamisetaConRaya camisetaSel = ( CamisetaConRaya )seleccionado;
                    camisetaSom.cambiarDireccion( camisetaSel.darDireccion( ) );

                }
            }
        }

        // Se calcula sombra para un nuevo dibujo
        else if( !opcionesSeleccion.get( 1 ).equals( opcion ) )
        {
            if( sombreado == null )
            {
                sombreado = uniforme.crearParte( opcion, pX, pY, darColor( ) );
            }
            else
            {
                sombreado.cambiarX( pX );
                sombreado.cambiarY( pY );
            }

        }
        cambiarSombreado( sombreado );
    }

    /**
     * Cambia el dibujo sombreado.
     * @param pParte - Nuevo dibujo sombreado. pParte != null
     */
    public void cambiarSombreado( IParte pParte )
    {
        sombreado = pParte;
    }

    /**
     * Reinicia el uniforme después de pedir una confirmación. <br>
     * <b>post: </b> Se reinició el uniforme.
     */
    public void reiniciar( )
    {
        boolean reiniciar = pedirConfirmacion( );
        if( reiniciar )
        {
            seleccionado = null;
            sombreado = null;
            uniforme.reiniciar( );
            panelUniforme.actualizar( );
        }
    }

    /**
     * Le pide al usuario un archivo para abrir y lo carga en el panel historieta <br>
     * <b>post: </b>Se cargó el uniforme que estaba guardada.
     */
    public void abrir( )
    {
        boolean abrir = pedirConfirmacion( );
        if( abrir )
        {
            JFileChooser fc = new JFileChooser( ultimoDirectorio );
            fc.setDialogTitle( "Abrir historieta" );
            fc.setFileSelectionMode( JFileChooser.FILES_ONLY );
            fc.setMultiSelectionEnabled( false );

            int resultado = fc.showOpenDialog( this );

            if( resultado == JFileChooser.APPROVE_OPTION )
            {
                File seleccionado = fc.getSelectedFile( );
                ultimoDirectorio = seleccionado.getParentFile( ).getAbsolutePath( );
                try
                {
                    uniforme.abrir( seleccionado.getAbsolutePath( ) );
                    panelUniforme.actualizar( );
                }
                catch( Exception e )
                {
                	System.out.println(e.getMessage());
                	e.printStackTrace();
                    JOptionPane.showMessageDialog( this, e.getMessage( ), "Error", JOptionPane.ERROR_MESSAGE );
                }
            }
        }
    }

    /**
     * Salva el uniforme en el archivo del que se había cargado o donde se había salvado la última vez. <br>
     * Si se trata de un uniforme nuevo y no se ha salvado, entonces se pregunta el nombre del archivo donde se salvaría. <br>
     * <b>post: </b> Se salvó el uniforme.
     */
    public void salvar( )
    {
        String nombreArchivo = uniforme.darNombreArchivo( );
        if( nombreArchivo == null )
        {
            salvarComo( );
        }
        else
        {
            try
            {
                uniforme.salvar( );
            }
            catch( IOException e )
            {
                JOptionPane.showMessageDialog( this, "Hubo problemas salvando el archivo:\n" + e.getMessage( ), "Error", JOptionPane.ERROR_MESSAGE );
            }
        }
    }

    /**
     * Salva el uniforme en un archivo cuyo nombre se pregunta usuario. <br>
     * <b>post: </b> Se salvó el uniforme en un archivo cuyo nombre se pregunta al usuario.
     */
    public void salvarComo( )
    {
        JFileChooser fc = new JFileChooser( ultimoDirectorio );
        fc.setDialogTitle( "Guardar como" );
        fc.setFileSelectionMode( JFileChooser.FILES_ONLY );
        fc.setMultiSelectionEnabled( false );

        boolean termine = false;

        int resultado = fc.showSaveDialog( this );

        while( !termine )
        {
            if( resultado == JFileChooser.APPROVE_OPTION )
            {
                File seleccionado = fc.getSelectedFile( );
                ultimoDirectorio = seleccionado.getParentFile( ).getAbsolutePath( );

                int respuesta = JOptionPane.YES_OPTION;

                // Si el archivo ya existe hay que pedir confirmaciï¿½n para sobrescribirlo
                if( seleccionado.exists( ) )
                {
                    respuesta = JOptionPane.showConfirmDialog( this, "ï¿½Desea sobrescribir el archivo seleccionado?", "Sobrescribir", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE );
                }

                // Si la respuesta fue positiva (o si no fue necesario hacer la pregunta) se graba el archivo
                if( respuesta == JOptionPane.YES_OPTION )
                {
                    try
                    {
                        uniforme.salvar( seleccionado.getAbsolutePath( ) );
                        termine = true;
                    }
                    catch( IOException e )
                    {
                        JOptionPane.showMessageDialog( this, "Hubo problemas guardando el archivo:\n" + e.getMessage( ), "Error", JOptionPane.ERROR_MESSAGE );
                    }
                }
                else
                {
                    resultado = fc.showSaveDialog( this );
                }
            }
            else
            {
                termine = true;
            }
        }
    }

    /**
     * Este método solicita una confirmación para realizar una acción que haría que el trabajo se perdiera. <br>
     * Presenta una ventana con las opciones "Si","No" y "Cancelar". <br>
     * Si se selecciona "Si", entonces se salva el archivo actual. <br>
     * Si se selecciona "No", el archivo no se salva y se retorna true <br>
     * Si se selecciona "Cancelar", el archivo no se salva pero se retorna false para que la acción no se realice.
     * @return Retorna true si la acción se debe realizar; retorna false en caso contrario.
     */
    private boolean pedirConfirmacion( )
    {
        boolean cerrar = true;

        int respuesta = JOptionPane.showConfirmDialog( this, "Desea guardar el archivo actual antes de continuar?", "Salvar", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE );

        if( respuesta == JOptionPane.YES_OPTION )
        {
            salvar( );
        }
        else if( respuesta == JOptionPane.NO_OPTION )
        {
            // No hace nada
        }
        else if( respuesta == JOptionPane.CANCEL_OPTION )
        {
            cerrar = false;
        }
        return cerrar;
    }

    /**
     * Pinta las Partes.
     * @param g - Graphics sobre el que se va a pintar las Partes.
     */
    public void pintarPartes( Graphics2D g )
    {
        uniforme.pintarPartes( g );
    }

    /**
     * Retorna el último color seleccionado por el usuario.<br>
     * @return Último color seleccionado.
     */
    public Color darColor( )
    {
        return color;
    }

    /**
     * Cambia el último color seleccionado.<br>
     * @param pColor Nuevo color
     */
    public void cambiarColor( Color pColor )
    {
        color = pColor;
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1
     */
    public void reqFuncOpcion1( )
    {
        String resultado = uniforme.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta 1", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Método para la extensión 2
     */
    public void reqFuncOpcion2( )
    {
        String resultado = uniforme.metodo2( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta 2", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Este método ejecuta la aplicación, creando una nueva interfaz
     * @param args Argumentos para la ejecución del programa.
     */
    public static void main( String[] args )
    {
        try
        {
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );
        }
        catch( Exception e )
        {
            //
        }
        InterfazFabricaDeUniformes interfaz = new InterfazFabricaDeUniformes( );
        interfaz.setVisible( true );
    }

}
