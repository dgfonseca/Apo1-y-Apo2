package uniandes.cupi2.explorador.interfaz;


import java.awt.BorderLayout;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;


import uniandes.cupi2.explorador.mundo.ExploradorCuevas;
import uniandes.cupi2.explorador.mundo.ExploradorCuevas.EstadoJuego;

/**
 * Esta es la clase principal de la interfaz del Explorador.
 */
@SuppressWarnings("serial")
public class InterfazExplorador extends JFrame {

	//
	// Constantes
	// 

	public final static int MODO_MOVERSE = 0;

	/**
	 * Ruta del archivo de donde se carga el juego.
	 */
	public final static String RUTA_ARCHIVO = "./data/explorador.properties";


	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Es el modo actual de juego. Seg�n el modo cambia la acci�n que se realiza cuando se mueve el jugador.
	 */
	private File archivoCargar;

	/**
	 * Es el campo de la cueva sobre el que se est� jugando.
	 */
	private ExploradorCuevas campoCueva;

	/**
	 * Es el panel donde se muestra los movimientos restantes.
	 */
	private PanelMovimientos panelMovimientos;

	/**
	 * Es el panel donde se muestran las opciones del programa.
	 */
	private PanelOpciones panelOpciones;


	/**
	 * Es el panel donde se muestran los botones para controlar el juego.
	 */
	private PanelControles panelControles;

	/**
	 * Es el panel donde se muestra el la matriz actual del juego.
	 */
	private PanelCueva panelCueva;

	/**
	 * Es el panel donde se muestra la informacion del juego.
	 */
	private PanelInformacion panelInformacion;

	//  -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Construye la interfaz de la aplicaci�n.
	 * @throws Exception 
	 */
	public InterfazExplorador( ) throws Exception
	{
		campoCueva = new ExploradorCuevas();

		setTitle( "Explorador de Cuevas" );
		setSize( 800, 700 );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setResizable( false );
		setLocationRelativeTo( null );


		JLabel labImagen = new JLabel( new ImageIcon( "./data/imagenes/banner.png" ) );
		add( labImagen, BorderLayout.NORTH );


		panelCueva = new PanelCueva(this);
		add(panelCueva, BorderLayout.CENTER);



		JPanel panelEste = new JPanel( );
		panelEste.setLayout( new BorderLayout( ) );
		add( panelEste, BorderLayout.EAST );

		panelControles = new PanelControles(this);
		panelEste.add(panelControles, BorderLayout.CENTER);

		panelInformacion = new PanelInformacion();
		panelEste.add(panelInformacion, BorderLayout.SOUTH);

		panelMovimientos = new PanelMovimientos();
		panelEste.add(panelMovimientos, BorderLayout.NORTH);

		panelOpciones = new PanelOpciones(this);
		add(panelOpciones, BorderLayout.SOUTH);
	}



	/**
	 * Inicia un nuevo juego del Explorador. <br>
	 * @throws Exception 
	 * 
	 */
	public void reiniciar( ) throws Exception
	{
		try{
			campoCueva.reiniciarJuego();
			panelCueva.actualizar(campoCueva.darEstadoJuego());
		}
		catch(Exception e){
			JOptionPane	.showMessageDialog(this, "error","Reiniciar", JOptionPane.ERROR_MESSAGE );
		}




	}

	/**
	 * Retorna el estado actual del juego.
	 * @return El estado actual del juego.
	 */
	public String[][] darEstadoJuego( )
	{
		return campoCueva.darEstadoJuego( );
	}
	/**
	 * Muestra un di�logo para seleccionar un archivo del explorador
	 */
	public void mostrarDialogoCargar() {

		JFileChooser fc = new JFileChooser( "./data" );
		fc.setDialogTitle( "Seleccionar archivo" );

		archivoCargar=null;
		int res = fc.showOpenDialog(this);

		if(res == JFileChooser.APPROVE_OPTION)
		{

			archivoCargar = fc.getSelectedFile();
			try 
			{

				campoCueva.inicializarJuego(archivoCargar);
				panelCueva.inicializar(campoCueva.darEstadoJuego());
				actualizar( );
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, "Error leyendo el archivo", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}

	}
	/**
	 * Retorna la fila donde esta el jugador
	 * @return fila donde esta el jugador
	 */
	public int darFilaJugador(){
		return campoCueva.darFilaJugador();
	}

	/**
	 * Retorna la columna donde esta el jugador
	 * @return columna donde esta el jugador
	 */
	public int darColumnaJugador(){
		return campoCueva.darColumnasJugador();
	}


	/**
	 * Actualiza el campo de juego
	 * @throws Exception
	 */
	private void actualizar( ) throws Exception{

		try{
			campoCueva.reiniciarJuego();
			panelCueva.actualizar(campoCueva.darEstadoJuego());
		}
		catch(Exception e){
			JOptionPane	.showMessageDialog(this, "error","Reiniciar", JOptionPane.ERROR_MESSAGE );
		}

	}


	public String darBombasCercanas(int i ,int j){
		return Integer.toString(campoCueva.darBombasCercanas(i, j));
	}
	/**Mueve el jugador a otra posici�n, si el movimiento es v�lido
	 * @param jugada es la direcci�n a la que se quiere mover el jugador.posX != null
	 * @throws Exception 
	 **/
	public void moverJugador(int jugada) throws Exception
	{
		int movimientoX = 0;
		int movimientoY = 0;
		try
		{
			if(jugada == 0){
				movimientoX = -1;
				movimientoY = -1;
			}
			else if (jugada == 1){
				movimientoX = 0;
				movimientoY = -1;
			}
			else if (jugada == 2){
				movimientoX = 1;
				movimientoY = -1;
			}
			else if (jugada == 3){
				movimientoX = -1;
				movimientoY = 0;
			}
			else if (jugada == 5){
				movimientoX = 1;
				movimientoY = 0;
			}
			else if (jugada == 6){
				movimientoX =-1;
				movimientoY = 1;
			}
			else if (jugada == 7){
				movimientoX = 0;
				movimientoY = 1;
			}
			else if (jugada == 8){
				movimientoX = 1;
				movimientoY = 1;
			}
			campoCueva.moverse(movimientoX, movimientoY);

			try{
				campoCueva.revisarBomba();
			}
			catch (Exception e){
				String[][] estado = campoCueva.darEstadoJuego();
				panelCueva.actualizar(estado);
				String mensaje = e.getMessage();
				panelCueva.jugadorPerdioBomba();
				JOptionPane.showMessageDialog(this,mensaje, "se termino", JOptionPane.CANCEL_OPTION);
				reiniciar();
			}
			String[][] estado = campoCueva.darEstadoJuego();
			panelCueva.actualizar(estado);
		}
		catch(Exception e){
			String mensaje = e.getMessage();
			JOptionPane.showMessageDialog(this, mensaje,"invalido",JOptionPane.ERROR_MESSAGE);}
		try{
			campoCueva.gano();
		}
		catch (Exception e)
		{
			String mensaje= e.getMessage();
			JOptionPane.showMessageDialog(this,  mensaje, "Juego finalizado", JOptionPane.INFORMATION_MESSAGE);
			reiniciar();}
	}
	/**
	 * M�todo para la extensi�n 1.
	 */
	public void reqFuncOpcion1( )
	{
		String resultado = campoCueva.metodo1( );
		JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
	}

	/**
	 * M�todo para la extensi�n 2.
	 */
	public void reqFuncOpcion2( )
	{
		String resultado = campoCueva.metodo2( );
		JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
	}


	/**
	 * Ejecuta la aplicaci�n.
	 * @param pArgs Par�metros de la ejecuci�n. No son necesarios.
	 */
	public static void main( String[] pArgs )
	{
		try
		{

			UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );

			InterfazExplorador v = new InterfazExplorador( );
			v.setVisible( true );
		}
		catch( Exception e )
		{
			e.printStackTrace( );
		}
	}

}