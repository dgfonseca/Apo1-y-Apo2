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

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import uniandes.cupi2.buscaminas.mundo.CampoMinado;
import uniandes.cupi2.buscaminas.mundo.CampoMinado.EstadoJuego;

/**
 * Esta es la clase principal de la interfaz del buscaminas.
 */
@SuppressWarnings("serial")
public class InterfazBuscaminas extends JFrame
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Indica que en el modo actual se deben marcar las casillas.
     */
    public final static int MODO_MARCAR = 0;

    /**
     * Indica que en el modo actual se deben desmarcar las casillas que están marcadas.
     */
    public final static int MODO_DESMARCAR = 1;

    /**
     * Indica que en el modo actual se deben destapar las casillas.
     */
    public final static int MODO_DESTAPAR = 2;

    /**
     * Ruta del archivo de donde se carga el juego.
     */
    public final static String RUTA_ARCHIVO = "./data/buscaminas.properties";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es el modo actual de juego. Según el modo cambia la acción que se realiza cuando se hace click sobre el campo minado.
     */
    private int modoActual;

    /**
     * Es el campo minado sobre el que se está jugando.
     */
    private CampoMinado campoMinado;

    /**
     * Es el panel donde se muestran los botones para controlar el juego.
     */
    private PanelBotones panelBotones;

    /**
     * Es el panel donde se muestra el estado actual del juego.
     */
    private PanelBuscaminas panelBuscaminas;

    /**
     * Es el panel donde se muestra la barra de estado del juego.
     */
    private PanelEstado panelBarraEstado;

    /**
     * Es el panel donde se muestran las opciones del programa.
     */
    private PanelOpciones panelOpciones;

   //  -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye la interfaz de la aplicación.
     */
    public InterfazBuscaminas( )
    {

        setTitle( "Buscaminas" );
        setSize( 460, 700 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setResizable( false );
        setLocationRelativeTo( null );


        modoActual = MODO_DESTAPAR;

        JLabel labImagen = new JLabel( new ImageIcon( "./data/banner.jpg" ) );
        add( labImagen, BorderLayout.NORTH );

        panelBotones = new PanelBotones( this );
        add( panelBotones, BorderLayout.EAST );

        panelBuscaminas = new PanelBuscaminas( this);
        add( panelBuscaminas, BorderLayout.CENTER );
        
        JPanel panelSur = new JPanel( );
        panelSur.setLayout( new BorderLayout( ) );
        add( panelSur, BorderLayout.SOUTH );

        panelBarraEstado = new PanelEstado( );
        panelSur.add( panelBarraEstado, BorderLayout.CENTER );
        
        panelOpciones = new PanelOpciones( this );
        panelSur.add( panelOpciones, BorderLayout.SOUTH );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Cambia el modo actual.
     * @param pModo El nuevo modo de juego. modo pertenece a {MODO_DESMARCAR, MODO_MARCAR, MODO_DESTAPAR}.
     */
    public void cambiarModo( int pModo )
    {
        modoActual = pModo;
    }

    /**
     * Realiza una jugada en la posición indicada. La jugada que se realiza depende del modo actual.
     * @param pX Coordenada x de la posición donde se está jugando.
     * @param pY Coordenada y de la posición donde se está jugando.
     */
    public void jugar( int pX, int pY )
    {
        switch( modoActual )
        {
            case MODO_MARCAR:
                marcar( pX, pY );
                break;
            case MODO_DESMARCAR:
                desmarcar( pX, pY );
                break;
            case MODO_DESTAPAR:
                destapar( pX, pY );
                break;
        }
    }

    /**
     * Retorna el estado actual del juego.
     * @return El estado actual del juego.
     */
    public EstadoJuego darEstadoJuego( )
    {
        return campoMinado.darEstadoJuego( );
    }

    /**
     * Marca la casilla en la posición indicada. <br>
     * Si la casilla ya está marcada o está destapada o el juego ya terminó se informa al usuario.
     * @param pX Coordenada x de la posición que se va a marcar.
     * @param pY Coordenada y de la posición que se va a marcar.
     */
    private void marcar( int pX, int pY )
    {
        try
        {
            campoMinado.marcar( pX, pY );
            actualizar( );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Error", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Desmarca una posición. <br>
     * Si la casilla no está marcada o el juego ya terminó se informa al usuario.
     * @param pX Coordenada x de la posición que se va a desmarcar.
     * @param pY Coordenada y de la posición que se va a desmarcar.
     */
    private void desmarcar( int pX, int pY )
    {
        try
        {
            campoMinado.desmarcar( pX, pY );
            actualizar( );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Error", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Destapa una posición.<br>
     * Si la casilla no está tapada o el juego ya se terminó se informa al usuario.
     * @param pX Coordenada x de la posición que se va a destapar.
     * @param pY Coordenada y de la posición que se va a destapar.
     */
    private void destapar( int pX, int pY )
    {
        try
        {
            EstadoJuego resultado = campoMinado.destapar( pX, pY );
            actualizar( );

            if( resultado == EstadoJuego.JUEGO_GANADO )
            {
                int tiempo = campoMinado.darTiempoTotal( );
                JOptionPane.showMessageDialog( this, "Ganó en " + tiempo + " segundos", "Juego Terminado", JOptionPane.INFORMATION_MESSAGE );
            }
            else if( resultado == EstadoJuego.JUEGO_PERDIDO )
            {
                JOptionPane.showMessageDialog( this, "Perdió!", "Juego Terminado", JOptionPane.INFORMATION_MESSAGE );
            }
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Error", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Actualiza el panel del buscaminas y la barra de estado.
     */
    private void actualizar( )
    {
        panelBuscaminas.actualizar( campoMinado );
        int numeroMinas = campoMinado.darCantidadMinasRestantes( );

        panelBarraEstado.actualizarMinas( numeroMinas );

    }

    /**
     * Inicia un nuevo juego de buscaminas. El estado inicial del juego es: <br>
     * Todas las casillas están tapadas y sin marcas. <br>
     * Las minas se distribuyeron de manera aleatoria. <br>
     * El tiempo de inicio del juego se inicializa en cero. <br>
     * El modo de juego es destapar.
     */
    public void reiniciar( )
    {
        campoMinado.reiniciarJuego( );
        panelBuscaminas.actualizar( campoMinado );
        panelBuscaminas.actualizar( campoMinado );

        int numeroMinas = campoMinado.darNumeroMinas( );
        panelBarraEstado.actualizarMinas( numeroMinas );

    }
    
	
	/**
	 * Muestra un diálogo para seleccionar un archivo del explorador
	 */
	public void mostrarDialogoCargar() {
		
		//1. creo un objeto de tipo FileChooser, y pongo la ruta en la que quiero que empiece como parámetro
		JFileChooser fc = new JFileChooser( "./data" );
		fc.setDialogTitle( "Seleccionar archivo" );
		
		// 2. showOpenDialog muestra el diálogo para abrir y retorna la opción elegida
		int res = fc.showOpenDialog(this);
		
		//3. si la opción elegida es de continuar "Open" o "Save" dependiendo
		if(res == JFileChooser.APPROVE_OPTION)
		{
			// 3.1 voy a obtener el archivo seleccionado
			// creo una variable de tipo File
			// la inicializo como el archivo seleccionado del FileChooser
			File archivoJuego = fc.getSelectedFile();
			try 
			{
				// 3.2 inicializo el laberinto como un nuevo objeto Laberinto
				// al constructor le entra por parámetro el archivo
		        campoMinado = new CampoMinado( archivoJuego );
				// 3.3. le pido al panel con el juego que pinte el juego cargado
		        panelBuscaminas.inicializar(campoMinado.darFilas(), campoMinado.darColumnas());
		        actualizar( );
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, "Error leyendo el archivo", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}


    // -----------------------------------------------------------------
    // Puntos de extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1.
     */
    public void reqFuncOpcion1( )
    {
        String resultado = campoMinado.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Método para la extensión 2.
     */
    public void reqFuncOpcion2( )
    {
        String resultado = campoMinado.metodo2( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Ejecuta la aplicación.
     * @param pArgs Parámetros de la ejecución. No son necesarios.
     */
    public static void main( String[] pArgs )
    {
        try
        {
            // Unifica la interfaz para Mac y para Windows.
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );

            InterfazBuscaminas ib = new InterfazBuscaminas( );
            ib.setVisible( true );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
    }


}
