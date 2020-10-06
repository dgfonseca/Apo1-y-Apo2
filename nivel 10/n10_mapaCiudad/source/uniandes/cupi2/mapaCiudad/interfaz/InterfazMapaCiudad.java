/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: InterfazMapaCiudad.java,v 1.1 2007/03/22 16:13:00 p-marque Exp $
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n10_mapaCiudad
 * Autor: Daniel Francisco Romero Acero - 25-ene-2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.mapaCiudad.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import uniandes.cupi2.mapaCiudad.mundo.Calle;
import uniandes.cupi2.mapaCiudad.mundo.Carrera;
import uniandes.cupi2.mapaCiudad.mundo.Casa;
import uniandes.cupi2.mapaCiudad.mundo.Construccion;
import uniandes.cupi2.mapaCiudad.mundo.Edificio;
import uniandes.cupi2.mapaCiudad.mundo.Esquina1;
import uniandes.cupi2.mapaCiudad.mundo.Esquina2;
import uniandes.cupi2.mapaCiudad.mundo.Esquina3;
import uniandes.cupi2.mapaCiudad.mundo.Esquina4;
import uniandes.cupi2.mapaCiudad.mundo.EstacionBomberos;
import uniandes.cupi2.mapaCiudad.mundo.EstacionPolicia;
import uniandes.cupi2.mapaCiudad.mundo.FormatoInvalidoExcepcion;
import uniandes.cupi2.mapaCiudad.mundo.Glorieta;
import uniandes.cupi2.mapaCiudad.mundo.Hospital;
import uniandes.cupi2.mapaCiudad.mundo.IConstruccion;
import uniandes.cupi2.mapaCiudad.mundo.MapaCiudad;

/**
 * Esta es la ventana principal de la aplicaci�n.
 */
public class InterfazMapaCiudad extends JFrame
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    /**
     * Constante para definir que no hay opci�n seleccionada.
     */
    public static final int NINGUNA = 0;
    /**
     * Constante para definir que una calle est� seleccionada.
     */
    public static final int CALLE = 5;
    /**
     * Constante para definir que una carrera est� seleccionada.
     */
    public static final int CARRERA = 6;
    /**
     * Constante para definir que una casa est� seleccionada.
     */
    public static final int CASA = 7;
    /**
     * Constante para definir que una glorieta est� seleccionada.
     */
    public static final int GLORIETA = 8;
    /**
     * Constante para definir que una edificio est� seleccionada.
     */
    public static final int EDIFICIO = 9;
    /**
     * Constante para definir que una esquina 1 est� seleccionada.
     */
    public static final int ESQUINA1 = 10;
    /**
     * Constante para definir que una esquina 2 est� seleccionada.
     */
    public static final int ESQUINA2 = 11;
    /**
     * Constante para definir que una esquina 3 est� seleccionada.
     */
    public static final int ESQUINA3 = 12;
    /**
     * Constante para definir que una esquina 4 est� seleccionada.
     */
    public static final int ESQUINA4 = 13;
    /**
     * Constante para definir que una estaci�n de polic�a est� seleccionada.
     */
    public static final int ESTACION_POLICIA = 14;
    /**
     * Constante para definir que una estaci�n de bomberos est� seleccionada.
     */
    public static final int ESTACION_BOMBEROS = 15;
    /**
     * Constante para definir que un hospital est� seleccionado.
     */
    public static final int HOSPITAL = 16;
    /**
     * Constante para definir que se va a entrar en modo Selecci�n.
     */
    public static final int SELECCIONAR = 17;
    /**
     * Constante para definir que se va borrar.
     */
    public static final int BORRAR = 18;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es el mapa de la ciudad
     */
    private MapaCiudad mapa;

    /**
     * Es la construcci�n actualmente seleccionada
     */
    private IConstruccion seleccionada;

    /**
     * Es la construcci�n que se est� creando y que se muestra sombreada
     */
    private IConstruccion sombreada;

    /**
     * Es la ruta hasta el �ltimo directorio de donde se carg� o salv� un archivo
     */
    private String ultimoDirectorio;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel en el que se muestra y edita el mapa
     */
    private PanelMapa panelMapa;

    /**
     * Es el panel donde se muestran los botones para controlar la aplicaci�n
     */
    private PanelBotones panelBotones;

    /**
     * Es la barra del men�
     */
    private BarraMenu barra;

     /**
     * Panel con las extensiones
     */
    private PanelExtension panelExtension;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye e inicializa la interfaz de la aplicaci�n
     */
    public InterfazMapaCiudad( )
    {
        // Crea la clase principal
        mapa = new MapaCiudad( );
        ultimoDirectorio = "./data";

        seleccionada = null;
        sombreada = null;

        // Construye la forma
        barra = new BarraMenu( this );
        setJMenuBar( barra );
        setLayout( new BorderLayout( ) );
        setSize( 1000, 742 );

        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setTitle( "MapaCiudad Ciudad" );

        // Creacion de los paneles
        panelExtension = new PanelExtension( this );
        panelMapa = new PanelMapa( this );
        panelBotones = new PanelBotones( this );

        // Adici�n de los panales al frame
        add( panelBotones, BorderLayout.WEST );
        add( panelMapa, BorderLayout.CENTER );
        add( panelExtension, BorderLayout.SOUTH );

    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------
    /**
     * Retorna la opci�n seleccionada en el panel de botones
     * 
     * @return Retorna InterfazMapaCiudad.NINGUNA o InterfazMapaCiudad.SELECCIONAR o InterfazMapaCiudad.BORRAR o InterfazMapaCiudad.CALLE o InterfazMapaCiudad.CARRERA o
     *         InterfazMapaCiudad.GLORIETA o InterfazMapaCiudad.CASA o InterfazMapaCiudad.EDIFICIO o InterfazMapaCiudad.ESQUINA1 o InterfazMapaCiudad.ESQUINA2 o
     *         InterfazMapaCiudad.ESQUINA3 o InterfazMapaCiudad.ESQUINA4 o InterfazMapaCiudad.ESTACION_BOMBEROS o InterfazMapaCiudad.ESTACION_POLICIA o
     *         InterfazMapaCiudad.HOSPITAL
     */
    public int darOpcionSeleccionada( )
    {
        return panelBotones.darOpcionSeleccionada( );
    }

    /**
     * Intenta eliminar una construcci�n dado un punto. <br>
     * Cada construcci�n debe saber si las coordenadas indicadas sirven para eliminarla o no. <br>
     * <b>post: </b> Si hab�a una construcci�n que se pudiera eliminar en esa posici�n entonces esta se elimina seleccionada.
     * 
     * @param x La coordenada x del punto
     * @param y La coordenada y del punto
     */
    public void eliminar( int x, int y )
    {
        mapa.eliminarConstruccion( x, y );
        seleccionada = null;
        panelMapa.actualizar( );
    }

    /**
     * Intenta eliminar la construcci�n seleccionada. <br>
     * <b>post: </b> Si hab�a una construcci�n seleccionada entonces esta se elimina.
     */
    public void eliminar( )
    {
        if( seleccionada != null )
        {
            mapa.eliminarConstruccion( seleccionada.darX( ), seleccionada.darY( ) );
            seleccionada = null;
            panelMapa.actualizar( );
        }
    }

    /**
     * Muestra la ventana de texto utilizada para modificar el texto de la construcci�n sobre la que se hizo doble click.
     */
    public void mostrarVentanaTexto( )
    {
        String texto = "";
        String nomDialogo;
        Font fuente = seleccionada.darFuente( );

        String tipo = seleccionada.darTipo( );
        texto = seleccionada.darTexto( );
        nomDialogo = "Cambiar Texto de " + tipo;

        DialogoTexto dt = new DialogoTexto( this, texto, fuente, nomDialogo );
        dt.setVisible( true );
    }

    /**
     * Cambia el texto de la construcci�n seleccionada. <br>
     * <b>pre: </b>Hay una construcci�n seleccionada <br>
     * <b>post: </b> Se modific� el texto de la construcci�n.
     * @param texto El texto que va a tener la construcci�n
     * @param fuente La fuente del texto de la construcci�n
     */
    public void cambiarTexto( String texto, Font fuente )
    {
        if( seleccionada != null )
        {
            seleccionada.cambiarFuente( fuente );
            seleccionada.cambiarTexto( texto );
            panelMapa.actualizar( );
        }
    }

    /**
     * Cambia la construcci�n actualmente seleccionada por la que contiene el punto x,y
     * 
     * @param x Coordenada x del punto
     * @param y Coordenada y del punto
     */
    public void seleccionar( int x, int y )
    {
        seleccionada = mapa.buscarConstruccion( x, y );
        panelMapa.actualizar( );
    }

    /**
     * Cambia la figura seleccionada
     * 
     * @param c Nueva figura seleccionada
     */
    public void cambiarSeleccionada( Construccion c )
    {
        seleccionada = c;
    }

    /**
     * Agrega una construcci�n del tipo seleccionado en el panel de botones. Los atributos de la construcci�n tambi�n se sacan del panel de botones. <br>
     * <b>post: </b>Se agreg� la construcci�n y se redibuj� el mapa.
     * @param x La coordenada x del punto superior izquierdo de la construcci�n
     * @param y La coordenada y del punto superior izquierdo de la construcci�n
     */
    public void agregarConstruccion( int x, int y )
    {
        int opcion = darOpcionSeleccionada( );
        Construccion c = null;
        Color colorFondo = panelBotones.darColorFondo( );
        
        if( CALLE == opcion )
        {
            c = mapa.crearConstruccion(Calle.TIPO,x,y,colorFondo);
        }
        else if( CARRERA == opcion )
        {
            c = mapa.crearConstruccion(Carrera.TIPO,x,y,colorFondo);
        }
        else if( GLORIETA == opcion )
        {
            c = mapa.crearConstruccion(Glorieta.TIPO,x,y,colorFondo);
        }
        else if( ESQUINA1 == opcion)
        {
            c = mapa.crearConstruccion(Esquina1.TIPO,x,y,colorFondo);
        }
        else if( ESQUINA2 == opcion )
        {
            c = mapa.crearConstruccion(Esquina2.TIPO,x,y,colorFondo);
        }
        else if( ESQUINA3 == opcion )
        {
            c = mapa.crearConstruccion(Esquina3.TIPO,x,y,colorFondo);
        }
        else if( ESQUINA4 == opcion)
        {
            c = mapa.crearConstruccion(Esquina4.TIPO,x,y,colorFondo);
        }
        if( CASA == opcion )
        {
            c = mapa.crearConstruccion(Casa.TIPO,x,y,colorFondo);
        }
        else if( EDIFICIO == opcion )
        {
            c = mapa.crearConstruccion(Edificio.TIPO,x,y,colorFondo);
        }
        else if( HOSPITAL == opcion )
        {
            c = mapa.crearConstruccion(Hospital.TIPO,x,y,colorFondo);
        }
        else if( ESTACION_BOMBEROS == opcion )
        {
            c = mapa.crearConstruccion(EstacionBomberos.TIPO,x,y,colorFondo);
        }
        else if( ESTACION_POLICIA == opcion )
        {
            c = mapa.crearConstruccion(EstacionPolicia.TIPO,x,y,colorFondo);
        }

        // Agregar la construcci�n s�lo si no se sobrepone con otra
        if( !mapa.sobreponeConstruccion( c ) )
        {            
            mapa.agregarConstruccion( c );
            sombreada = null;
            panelMapa.actualizar( );
        }
    }

    /**
     * Retorna la construcci�n a ser pintada sobreada
     * 
     * @return construcci�n a ser pintada sobreada
     */
    public IConstruccion darSombreado( )
    {
        return sombreada;
    }

    /**
     * Calcula la sombra de la figura actual seleccionada
     * 
     * @param x La coordenada x del punto
     * @param y La coordenada y del punto
     */
    public void calcularSombra( int x, int y )
    {
        int opcion = darOpcionSeleccionada( );
        Color colorFondo = panelBotones.darColorFondo( );
       
        if( opcion == InterfazMapaCiudad.CALLE )
        {
            sombreada = mapa.crearConstruccion( Calle.TIPO, x, y, colorFondo );
            
        }
        else if( opcion == InterfazMapaCiudad.CARRERA )
        {
            sombreada = mapa.crearConstruccion( Carrera.TIPO, x, y, colorFondo );
        }
        else if( opcion == InterfazMapaCiudad.GLORIETA )
        {
            sombreada = mapa.crearConstruccion( Glorieta.TIPO, x, y, colorFondo );
        }
        else if( opcion == InterfazMapaCiudad.ESQUINA1 )
        {
            sombreada = mapa.crearConstruccion( Esquina1.TIPO, x, y, colorFondo );
        }
        else if( opcion == InterfazMapaCiudad.ESQUINA2 )
        {
            sombreada = mapa.crearConstruccion( Esquina2.TIPO, x, y, colorFondo );
        }
        else if( opcion == InterfazMapaCiudad.ESQUINA3 )
        {
            sombreada = mapa.crearConstruccion( Esquina3.TIPO, x, y, colorFondo );
        }
        else if( opcion == InterfazMapaCiudad.ESQUINA4 )
        {
            sombreada = mapa.crearConstruccion( Esquina4.TIPO, x, y, colorFondo );
        }
        else if( opcion == InterfazMapaCiudad.CASA )
        {
            sombreada = mapa.crearConstruccion( Casa.TIPO, x, y, colorFondo );
        }
        else if( opcion == InterfazMapaCiudad.EDIFICIO )
        {
            sombreada = mapa.crearConstruccion( Edificio.TIPO, x, y, colorFondo );
        }
        else if( opcion == InterfazMapaCiudad.HOSPITAL )
        {
            sombreada = mapa.crearConstruccion( Hospital.TIPO, x, y, colorFondo );
        }
        else if( opcion == InterfazMapaCiudad.ESTACION_BOMBEROS )
        {
            sombreada = mapa.crearConstruccion( EstacionBomberos.TIPO, x, y, colorFondo );
        }
        else if( opcion == InterfazMapaCiudad.ESTACION_POLICIA )
        {
            sombreada = mapa.crearConstruccion( EstacionPolicia.TIPO, x, y, colorFondo );
        }

        if(sombreada!=null && mapa.sobreponeConstruccion( sombreada ) )
        {
            sombreada = null;
        }
        cambiarSombreada( sombreada );
    }

    /**
     * Cambia la construcci�n sombreada
     * 
     * @param c Nueva construcci�n sombreada
     */
    public void cambiarSombreada( IConstruccion c )
    {
        sombreada = c;
    }

    /**
     * Reinicia el mapa despu�s de pedir una confirmaci�n <br>
     * <b>post: </b> Se reinici� el mapa
     */
    public void reiniciar( )
    {
        boolean reiniciar = pedirConfirmacion( );
        if( reiniciar )
        {
            mapa.reiniciar( );
            panelMapa.actualizar( );
        }
    }

    /**
     * Le pide al usuario un archivo para abrir y lo carga en el panel mapa <br>
     * <b>post: </b>Se carg� un mapa que estaba guardado
     */
    public void abrir( )
    {
        boolean abrir = pedirConfirmacion( );
        if( abrir )
        {
            JFileChooser fc = new JFileChooser( ultimoDirectorio );
            fc.setDialogTitle( "Abrir mapa" );
            fc.setFileSelectionMode( JFileChooser.FILES_ONLY );
            fc.setMultiSelectionEnabled( false );

            int resultado = fc.showOpenDialog( this );

            if( resultado == JFileChooser.APPROVE_OPTION )
            {
                File seleccionado = fc.getSelectedFile( );
                ultimoDirectorio = seleccionado.getParentFile( ).getAbsolutePath( );

                try
                {
                    mapa.abrir( seleccionado.getAbsolutePath( ) );
                    panelMapa.actualizar( );
                }
                catch( FormatoInvalidoExcepcion e )
                {
                    JOptionPane.showMessageDialog( this, "Hay problemas con el formato del archivo:\n" + e.getMessage( ), "Error", JOptionPane.ERROR_MESSAGE );
                }
                catch( IOException e )
                {
                    JOptionPane.showMessageDialog( this, "Hubo problemas cargando el archivo:\n" + e.getMessage( ), "Error", JOptionPane.ERROR_MESSAGE );
                }
            }
        }
    }

    /**
     * Salva el mapa en el archivo del que se hab�a cargado o donde se hab�a salvado la �ltima vez. <br>
     * Si se trata de un mapa nuevo y no se ha salvado entonces se pregunta el nombre del archivo donde se salvar�. <br>
     * <b>post: </b> Se salv� el mapa.
     */
    public void salvar( )
    {
        String nombreArchivo = mapa.darNombreArchivo( );
        if( nombreArchivo == null )
        {
            salvarComo( );
        }
        else
        {
            try
            {
                mapa.salvar( );
            }
            catch( IOException e )
            {
                JOptionPane.showMessageDialog( this, "Hubo problemas salvando el archivo:\n" + e.getMessage( ), "Error", JOptionPane.ERROR_MESSAGE );
            }
        }
    }

    /**
     * Salva el mapa en un archivo del cual se le pregunta el nombre al usuario. <br>
     * <b>post: </b> Se salv� el mapa en un archivo que se le pregunt� al usuario.
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

                // Si el archivo ya existe hay que pedir confirmaci�n para
                // sobrescribirlo
                if( seleccionado.exists( ) )
                {
                    respuesta = JOptionPane.showConfirmDialog( this, "�Desea sobrescribir el archivo seleccionado?", "Sobrescribir", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE );
                }

                // Si la respuesta fue positiva (o si no fue necesario hacer la
                // pregunta) se graba el archivo
                if( respuesta == JOptionPane.YES_OPTION )
                {
                    try
                    {
                        mapa.salvar( seleccionado.getAbsolutePath( ) );
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
     * Pinta las construcciones.
     * @param g Graphics sobre el que se va a pintar las construcciones.
     */
    public void pintarConstrucciones(Graphics2D g){
        mapa.pintarConstrucciones( g );
    }
    
    /**
     * Este m�todo solicita una confirmaci�n para realizar una acci�n que har�a que el trabajo se perdiera. <br>
     * Presenta una ventana con las opciones "Si","No" y "Cancelar". <br>
     * Si se selecciona "Si", entonces se salva el archivo actual. <br>
     * Si se selecciona "No", el archivo no se salva y se retorna true <br>
     * Si se selecciona "Cancelar", el archivo no se salva pero se retorna false para que la acci�n no se realice.
     * 
     * @return Retorna true si la acci�n se debe realizar; retorna false en caso contrario.
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
     * Retorna la construcci�n seleccionada
     * @return seleccionada
     */
    public IConstruccion darSeleccionada( )
    {
        return seleccionada;
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * M�todo para la extensi�n 1
     */
    public void reqFuncOpcion1( )
    {
        String resultado = mapa.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * M�todo para la extensi�n 2
     */
    public void reqFuncOpcion2( )
    {
        String resultado = mapa.metodo2( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Este m�todo ejecuta la aplicaci�n, creando una nueva interfaz
     * 
     * @param args
     */
    public static void main( String[] args )
    {
        InterfazMapaCiudad interfaz = new InterfazMapaCiudad( );
        interfaz.setVisible( true );
    }
}