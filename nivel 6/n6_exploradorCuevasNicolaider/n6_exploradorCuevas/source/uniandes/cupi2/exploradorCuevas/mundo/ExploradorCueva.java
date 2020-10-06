package uniandes.cupi2.exploradorCuevas.mundo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JOptionPane;





/**
 * Esta clase representa un juego de Explorador de Cueva
 */
public class ExploradorCueva {


	//-----------------------------------------------------------------
	// Atributos
	//-----------------------------------------------------------------
	/**
	 * Archivo del juego que se cargará.
	 */
	private File juegoActual;

	/**
	 * Es el conjunto de casillas del juego. En la posicion (i,j) aparece la casilla de coordenadas en x = i y coordenadas en y = j
	 */
	private Casilla[][]  juegoExplorador;

	/**
	 * Filas del tablero en el que se jugará.
	 */
	private int filasTablero;
	/**
	 * Columnas del tablero en el que se jugará.
	 */
	private int columnasTablero;
	/**
	 * Cantidad de bombas en el juego
	 */
	private int cantidadBombas;
	/**
	 * Cantidad de movimientos que tiene el jugador para llegar al tesoro.
	 */
	private int movimientos;
	/**
	 * Fila en la que se encuentra el jugador
	 */
	private int filaJugador;
	/**
	 * Columna en la que se encuentra el jugador
	 */
	private int columnaJugador;
	/**
	 * Fila en la que se encuentra el tesoro
	 */
	private int filaTesoro;
	/**
	 * Columna en la que se encuentra el tesoro
	 */
	private int columnaTesoro;


	//-----------------------------------------------------------------
	// Constructores
	//-----------------------------------------------------------------
	/**
	 * Es el constructor del mundo del juego. Inicializará el archivo del juego en null.
	 */
	public ExploradorCueva( ) 
	{
		juegoActual = null;
	}


	/**
	 * Carga la información del juego de Explorador Cueva en un objeto de tipo Properties.
	 * @param arch Es el archivo que contiene las características del mapa de juego.
	 * @return un objeto de la clase Properties con la información del archivo.
	 * @throws Exception Se lanza esta excepción si el archivo no existe o si el formato del archivo no es válido y no puede ser leído.
	 */
	private Properties cargarInfoJuego( File arch ) throws Exception
	{
		Properties datos = new Properties( );

		try
		{
			FileInputStream in = new FileInputStream( arch );
			datos.load( in );
			in.close( );
		}
		catch (FileNotFoundException e)
		{
			throw (new Exception ("El archivo no existe"));
		}
		catch( IOException e )
		{
			throw new Exception( "Formato inválido" );
		}

		return datos;
	}

	/**
	 * Inicializa la tabla seleccionada, que la recibe en el parámetro de entrada. <br>
	 * <b>post: </b> El arreglo de casillas fue inicializado abriendo el archivo que venía en el parámetro de entrada.
	 * @param archivo contiene el archivo que se quiere abrir. Esta información es completa y válida.
	 */
	public void inicializarTabla( File archivo )throws Exception
	{
		Properties estadoInicial = cargarInfoJuego(archivo);
		movimientos = Integer.parseInt(estadoInicial.getProperty("explorador.movimientos"));
		filasTablero = Integer.parseInt(estadoInicial.getProperty("explorador.filas"));
		columnasTablero = estadoInicial.getProperty("explorador.fila0").split("").length;
		// Crea el arreglo de casillas, reservando el espacio definido en la propiedad "explorador.filas y explorador.columnas"
		juegoExplorador = new Casilla [filasTablero][columnasTablero];
		// Lee el nombre de cada equipo de la respectiva propiedad y crea el objeto que lo representa
		for (int i = 0 ; i < filasTablero; i++)
		{
			String[] tipos = estadoInicial.getProperty("explorador.fila" + i).split("");
			for (int j = 0; j<tipos.length; j++)
			{
				juegoExplorador[i][j] = new Casilla(tipos[j]);
				if(tipos[j].equals(Casilla.JUGADOR)){
					filaJugador = i;
					columnaJugador = j;
				}
				else if (tipos[j].equals(Casilla.TESORO)){
					filaTesoro = i;
					columnaTesoro = j;
				}
			}

		}
		juegoActual = archivo;
	}




	//-----------------------------------------------------------------
	// Métodos
	//-----------------------------------------------------------------


	/**
	 * Retorna una lista del estado de cada casilla
	 * @return la lista del estado actual de cada casilla
	 */
	public String [][] darEstado()
	{
		String[][] estado = new String[filasTablero][columnasTablero];

		for (int i = 0; i < filasTablero; i++)
		{
			for(int j =0; j < columnasTablero; j++)
			{
				estado[i][j] = juegoExplorador[i][j].darEstado();
			}
		}
		return estado;
	}
	/**
	 * Reinicia el tablero con la organización inicial de las fichas.
	 * @throws Exception Se lanza esta excepción si no hay ningun juego cargado previamente.
	 */
	public void reiniciarTablero() throws Exception
	{
		if(juegoActual != null)
			inicializarTabla(juegoActual);
		else
		{
			throw new Exception("No hay ningun juego cargado.");
		}
	}


	/**
	 * Verifica si el movimiento que se quiere hacer con la ficha roja es válido
	 * @return True si se puede hacer el movimiento, false de lo contrario.
	 * @param posY es la posición final en Y de la ficha que se quiere mover.  posY != null
	 * @param posX es la posición final en X de la ficha que se quiere mover.posX != null
	 */
	public boolean movimientoValido (int posX, int posY)
	{
		int movX = filaJugador + posY;
		int movY = columnaJugador + posX;
		if (movX < 0 || movX >= juegoExplorador[0].length){
			return false;
		}
		if( movY < 0 || movY >= juegoExplorador.length){
			return false;
		}
		if(juegoExplorador[movX][movY].darEstado().equals(Casilla.OBSTACULO)){
			return false;
		}
		return true;
	}


	/**
	 * Mueve al personaje, verificando si se puede hacer el movimiento
	 * @param despY es el desplazamiento en Y de la ficha que se quiere mover.  posY != null
	 * @param despX es el desplazamiento en X de la ficha que se quiere mover.posX != null
	 */
	public void moverse (int despX, int despY) throws Exception
	{
		boolean validarMovimiento = movimientoValido(despX, despY);
		if(validarMovimiento)
		{
			juegoExplorador[filaJugador][columnaJugador].actualizarEstado(Casilla.NADA);
			filaJugador = filaJugador + despY;
			columnaJugador = columnaJugador + despX;
			movimientos --;

		}
		else
		{
			throw new Exception ("Movimiento Invalido");
		}
	}

	public void revisarBomba() throws Exception{

		if(juegoExplorador[filaJugador][columnaJugador].darEstado().equals(Casilla.BOMBA)){
			throw new Exception("¡Pisaste una bomba!\nTu juego ha terminado");
		}
		juegoExplorador[filaJugador][columnaJugador].actualizarEstado(Casilla.JUGADOR);

	}

	public int getBombasFilaActual(){
		int bombas = 0;
		int i = filaJugador;
		for(int j = 0; j < juegoExplorador[i].length;j++){
			if(juegoExplorador[i][j].darEstado().equals(Casilla.BOMBA)){
				bombas++;
			}
		}
		return bombas;
	}
	public int getBombasColumnaActual(){
		int bombas = 0;
		int j = columnaJugador;
		for(int i = 0; i < juegoExplorador.length;i++){
			if(juegoExplorador[i][j].darEstado().equals(Casilla.BOMBA)){
				bombas++;
			}
		}
		return bombas;
	}
	public int getBombasCercanas(int fila, int columna){
		int bombas = 0;
		for(int i = 0; i < juegoExplorador.length;i++){
			for(int j = 0; j < juegoExplorador[i].length;j++){
				if(i<= fila + 1 && i >= fila -1 && j <= columna + 1
						&& j >= columna - 1){
					if(juegoExplorador[i][j].darEstado().equals(Casilla.BOMBA)){
						bombas++;
					}
				}
			}
		}
		return bombas;
	}
	public int getTotalBombas(){
		int bombas = 0;
		for (int i = 0; i < juegoExplorador.length;i++){
			for(int j = 0; j < juegoExplorador[i].length;j++){
				if(juegoExplorador[i][j].darEstado().equals(Casilla.BOMBA)){
					bombas++;
				}
			}
		}
		return bombas;		
	}

	/**
	 * Revisa si el jugador ganó para terminar la partida y mandar el mensaje de finalización.
	 * @throws Exception si existe algún ganador.
	 */
	public void revisarSiGano() throws Exception
	{

		if (filaJugador == filaTesoro && columnaJugador == columnaTesoro)
		{
			throw new Exception("¡Felicidades!\nGanaste el juego");
		}
	}
	/**
	 * Revisa si el jugador ganó para terminar la partida y mandar el mensaje de finalización.
	 * @throws Exception si existe algún ganador.
	 */
	public void revisarSiTieneMovs() throws Exception
	{

		if (movimientos == 0)
		{
			throw new Exception("¡Te has quedado sin movimientos!\n Tu juego ha terminado");
		}
	}

	public int getMovimientos() {
		return movimientos;
	}


	private void setMovimientos(int movimientos) {
		this.movimientos = movimientos;
	}


	public int getFilasTablero() {
		return filasTablero;
	}


	public void setFilasTablero(int filasTablero) {
		this.filasTablero = filasTablero;
	}


	public int getColumnasTablero() {
		return columnasTablero;
	}


	public void setColumnasTablero(int columnasTablero) {
		this.columnasTablero = columnasTablero;
	}


	//-----------------------------------------------------------------
	// Puntos de Extensión
	//-----------------------------------------------------------------
	/**
	 * Es el punto de extensión 1
	 * @return Respuesta 1
	 */
	public String ext1(){

		return ("Opción 1");
	}


	/**
	 * Es el punto de extensión 2
	 * @return Respuesta 2
	 */
	public String ext2(){

		return ("Opción 2");
	}


	public int getFilaJugador() {
		return filaJugador;
	}


	public void setFilaJugador(int filaJugador) {
		this.filaJugador = filaJugador;
	}


	public int getColumnaJugador() {
		return columnaJugador;
	}


	public void setColumnaJugador(int columnaJugador) {
		this.columnaJugador = columnaJugador;
	}



}
