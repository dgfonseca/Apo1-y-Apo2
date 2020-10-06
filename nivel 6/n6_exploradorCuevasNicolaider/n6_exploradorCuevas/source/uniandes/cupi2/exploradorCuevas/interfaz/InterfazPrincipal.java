package uniandes.cupi2.exploradorCuevas.interfaz;

import java.awt.*;
import java.io.*;


import javax.swing.*;

import uniandes.cupi2.exploradorCuevas.mundo.*;


@SuppressWarnings("serial")

/**
 * Es la clase principal de la interfaz
 */
public class InterfazPrincipal extends JFrame {


	//-----------------------------------------------------------------
	// Atributos
	//-----------------------------------------------------------------



	/**
	 * Es una referencia al tablero y el explorador del mundo.
	 */
	private ExploradorCueva explorador;

	/**
	 * Posici�n en Y del bot�n
	 */
	private int posicionTempY;

	/**
	 * Posici�n en X del bot�n
	 */
	private int posicionTempX;

	/**
	 * Posici�n en X del bot�n
	 */

	/**
	 * Archivo donde se encuentra el juego que se cargar�
	 */
	private File archivo;


	//-----------------------------------------------------------------
	// Atributos de la Interfaz
	//-----------------------------------------------------------------
	/**
	 * Es el panel donde se muestran las opciones que se tienen
	 */
	private Opciones opciones;

	/**
	 * Es el panel donde se muestra el tablero del juego
	 */
	private TableroInterfaz tableroInterfaz;

	/**
	 * Es el panel donde se muestran las caracteristicas y los botones del juego
	 */
	private PanelCaracteristicas panelCaracteristicas;

	/**
	 * Es el panel donde se muestra el encabezado del juego
	 */
	private JPanel subImagen;


	//-----------------------------------------------------------------
	// Constructores
	//-----------------------------------------------------------------

	/**
	 * Construye la interfaz principal e inicializa el juego indicando que no se ha cargado la informaci�n de ning�n archivo
	 */
	public InterfazPrincipal ()
	{

		setSize( 810, 680 );
		setTitle( "Explorador de Cuevas" );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		setLocationRelativeTo(null);
		setResizable(false);



		subImagen = new JPanel();
		subImagen.setLayout (new BorderLayout());
		ImageIcon icono = new ImageIcon ("data/imagenes/banner.png");
		JLabel imagen = new JLabel(icono, JLabel.CENTER);
		subImagen.add(imagen, BorderLayout.CENTER);
		add (subImagen, BorderLayout.NORTH);

		explorador = new ExploradorCueva();


		tableroInterfaz = new TableroInterfaz(this );

		add(tableroInterfaz, BorderLayout.CENTER );
		panelCaracteristicas = new PanelCaracteristicas(this);
		add(panelCaracteristicas,BorderLayout.EAST);


		opciones = new Opciones(this);

		add(opciones, BorderLayout.SOUTH);


		posicionTempX = -1;
		posicionTempY= -1;

	}

	/**
	 * Carga el tablero a partir de un archivo seleccionado por el usuario
	 */
	public void cargar ()
	{
		JFileChooser fc = new JFileChooser ("./data");
		fc.setDialogTitle("Seleccionar archivo");

		archivo = null;
		int resp = fc.showOpenDialog(this);
		if ( resp == JFileChooser.APPROVE_OPTION)
		{ 
			archivo = fc.getSelectedFile();

			try
			{


				// Crea el modelo del mundo, pas�ndole como par�metro el archivo del cual se debe cargar
				explorador.inicializarTabla(archivo);
				tableroInterfaz.iniciarTabla(explorador.darEstado());
			}
			catch( Exception e )
			{
				explorador = null;
				JOptionPane.showMessageDialog( this, "Hubo problemas cargan"
						+ "do el juego: \n" + e.getMessage( ), "Error", JOptionPane.ERROR_MESSAGE );
				e.printStackTrace( );
			}
		}
	}


	/**Mueve el jugador a otra posici�n, si el movimiento es v�lido
	 * @param jugada es la direcci�n a la que se quiere mover el jugador.posX != null
	 **/
	public void moverJugador(int jugada)
	{
		int despX = 0;
		int despY = 0;
		try
		{
			if(jugada == 0){
				despX = -1;
				despY = -1;
			}
			else if (jugada == 1){
				despX = 0;
				despY = -1;
			}
			else if (jugada == 2){
				despX = 1;
				despY = -1;
			}
			else if (jugada == 3){
				despX = -1;
				despY = 0;
			}
			else if (jugada == 5){
				despX = 1;
				despY = 0;
			}
			else if (jugada == 6){
				despX =-1;
				despY = 1;
			}
			else if (jugada == 7){
				despX = 0;
				despY = 1;
			}
			else if (jugada == 8){
				despX = 1;
				despY = 1;
			}
			explorador.moverse(despX, despY);
			try{
				explorador.revisarBomba();
			}
			catch (Exception e){
				String[][] nuevoEstado = explorador.darEstado();
				tableroInterfaz.actualizar(nuevoEstado);
				panelCaracteristicas.actualizar();
				String mensaje = e.getMessage();
				tableroInterfaz.quemarJugador();
				JOptionPane.showMessageDialog(this,  mensaje, "Juego finalizado", JOptionPane.INFORMATION_MESSAGE);
				reiniciar();

			}
			String[][] nuevoEstado = explorador.darEstado();
			tableroInterfaz.actualizar(nuevoEstado);
			panelCaracteristicas.actualizar();
			try 
			{
				explorador.revisarSiGano();
			}

			catch (Exception e)
			{
				String mensaje= e.getMessage();
				JOptionPane.showMessageDialog(this,  mensaje, "Juego finalizado", JOptionPane.INFORMATION_MESSAGE);
				reiniciar();
			}
			if(explorador.getMovimientos() == 0){
				JOptionPane.showMessageDialog(this,  "�Te has quedado sin movimientos!\n Tu juego ha terminado", "Juego finalizado", JOptionPane.INFORMATION_MESSAGE);
				reiniciar();
			}
			
		}
		catch (Exception e)
		{
			String mensaje = e.getMessage();
			JOptionPane.showMessageDialog(this, mensaje, "Movimiento inv�lido" , JOptionPane.ERROR_MESSAGE);
		}

	}	

	/**
	 * Reinicia el tablero con la configuraci�n inicial
	 */
	public void reiniciar() 
	{

		try
		{
			explorador.reiniciarTablero();
			panelCaracteristicas.actualizarCaracteristicas();
			tableroInterfaz.actualizar(explorador.darEstado());
		}
		catch (Exception e)
		{
			String mensaje = e.getMessage();
			JOptionPane.showMessageDialog(this, mensaje, "Reiniciar juego", JOptionPane.ERROR_MESSAGE);

		}

	}




	//-----------------------------------------------------------------
	// Puntos de Extensi�n
	//-----------------------------------------------------------------
	/**
	 * Ejecuta el punto de extensi�n 1
	 */
	public void metodo1(){

		String mensaje = explorador.ext1();
		JOptionPane.showMessageDialog(this,mensaje , "Metodo 1", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Ejecuta el punto de extensi�n 2
	 */
	public void metodo2(){

		String mensaje = explorador.ext2();
		JOptionPane.showMessageDialog(this,mensaje , "Metodo 2", JOptionPane.INFORMATION_MESSAGE);
	}



	//-----------------------------------------------------------------
	// Programa principal
	//-----------------------------------------------------------------

	/**
	 * Ejecuta la aplicaci�n
	 * @param args Estos par�metros no se usan.
	 */
	public static void main( String[] args )
	{
		InterfazPrincipal ic = new InterfazPrincipal( );
		ic.setVisible (true);
	}

	public void actualizarCaracteristicas() {
		panelCaracteristicas.actualizarCaracteristicas();

	}

	public int getMovimientos() {
		return explorador.getMovimientos();
	}

	public String getTotalBombas() {
		return Integer.toString(explorador.getTotalBombas());
	}

	public String getBombasFilaActual() {
		return Integer.toString(explorador.getBombasFilaActual());
	}

	public String getBombasColumnaActual() {
		return Integer.toString(explorador.getBombasColumnaActual());
	}
	public int getFilaJugador(){
		return explorador.getFilaJugador();
	}
	public int getColumnaJugador(){
		return explorador.getColumnaJugador();
	}

	public String getBombasCercanas(int i, int j) {
		return Integer.toString(explorador.getBombasCercanas(i, j));
	}


}
