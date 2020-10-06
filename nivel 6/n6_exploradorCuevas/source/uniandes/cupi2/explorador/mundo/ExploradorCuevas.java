package uniandes.cupi2.explorador.mundo;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;






/**
 * Esta clase representa el explorador de cuevas y conoce las casillas por donde se ha movilizado el usuario.
 */
public class ExploradorCuevas
{

	//
	// Enumeraciones
	//

	/**
	 * Enumeradores para los tipos de estado.
	 */
	public enum EstadoJuego{

		/**
		 * Indica que el juego debe continuar. <br>
		 * No se ha llegado al tesoro y tampoco esta donde una bomba.
		 */
		CONTINUA_JUEGO,

		/**
		 * Indica que el juego fue ganado porque se llego al tesoro.
		 */
		JUEGO_GANADO,

		/**
		 * Indica que el juego fue perdido porque llego donde estaba la bomba.
		 */
		JUEGO_PERDIDO_BOMBA,

		/**
		 * Indica que el juego fue perdido porque se acabaron los movimientos.
		 */
		JUEGO_PERDIDO_MOVIMIENTOS,




	}
	// 
	// Atributos
	// 
	private File juegoActual; 
	/**
	 * Es la matriz donde se marcan las casillas que se moviliza el jugador. <br>
	 * Cada casilla puede estar VACIA, OBSTACULO, TESORO, BOMBA, JUGADOR O ILUMINADA.
	 */
	private Casilla[][] casillasExploradorCuevas;

	/**
	 * Cantidad de columnas del campo minado.
	 */
	private int columnas;

	/**
	 * Cantidad de filas del campo minado.
	 */
	private int filas;

	/**
	 * Cantidad de columnas del campo minado.
	 */
	private int columnasJugador;

	/**
	 * Cantidad de filas del campo minado.
	 */
	private int filasJugador;

	/**
	 * Cantidad de columnas del campo minado.
	 */
	private int columnasTesoro;

	/**
	 * Cantidad de filas del campo minado.
	 */
	private int filasTesoro;


	/**
	 * Indica si ya el juego se termin� y el resultado.
	 */

	/**
	 * La cantidad de bombas que hay en el campo minado.
	 */
	private int cantidadBombas;

	/**
	 * Se va a usar para reiniciar el juego.
	 */
	

	/**
	 * La cantidad de movimientos restantes.
	 */
	private int cantidadMovimientos;

	// 
	// Constructores
	// 

	/**
	 * Construye un nuevo juego de Explorador cuevas con el tama�o del de la cueva y el n�mero de bombas y tesoros especificados en el archivo de entrada. <br>
	 * <b>post: </b> Se construy� un nuevo explorador de cuevas del tama�o y n�mero de minas especificados en el archivo. <br>   
	 * El tiempo de inicio se inicializ� en cero.
	 * @param archivoJuego - File, archivo en donde se encuentra el properties. No es nulo.
	 * @throws Exception Se lanza esta excepci�n si hay problemas cargando el archivo.
	 */
	public ExploradorCuevas() throws Exception
	{
		juegoActual=null;

	}

	/**
	 * Carga la informaci�n del explorador de cuevas en un objeto de tipo Properties.
	 * @param archivoJuego File, archivo en donde se encuentra el properties. No es nulo.
	 * @throws Exception Si hay alg�n problema leyendo el properties
	 */
	private Properties cargarInfoJuego( File archivoJuego ) throws Exception
	{

		Properties datos = new Properties( );


		try{

			FileInputStream in = new FileInputStream(archivoJuego);
			datos.load(in);	
			in.close();


		}catch(Exception e){


			throw new Exception("formato invalido");
		}


		return datos;

	}
	/**
	 * Permite reiniciar un juego
	 * @throws Exception 
	 */
	public void reiniciarJuego() throws Exception{
		if(juegoActual!=null){
			inicializarJuego(juegoActual);
		}

	}

	/**
	 * Crea un nuevo explorador de cuevas de juego, asignando todos los valores a las casillas. <br>
	 * <b>post: </b> El explorador de cuevas qued� inicializado, con todas las casillas con su respectivo valor, con las bombas seg�n las posiciones del properties y<br>
	 * @throws Exception 
	 */
	public void inicializarJuego(File archivoJuego ) throws Exception
	{

		Properties estadoInicial = cargarInfoJuego(archivoJuego);
		cantidadMovimientos =  Integer.parseInt(estadoInicial.getProperty("explorador.movimientos"));
		filas = Integer.parseInt(estadoInicial.getProperty("explorador.filas"));
		columnas = Integer.parseInt(estadoInicial.getProperty("explorador.columnas"));


		casillasExploradorCuevas = new Casilla[filas][columnas];

		for( int i = 0; i < filas; i++ )
		{
			String[] tipos = estadoInicial.getProperty("explorador.fila"+i).split("");
			for( int j = 0; j <tipos.length; j++ )
			{
				casillasExploradorCuevas[i][j ] = new Casilla(tipos[j]);
				if(tipos[j].equals(Casilla.JUGADOR)){
					filasJugador=i;
					columnasJugador=j;
				}
				else if( tipos[j].equals(Casilla.TESORO)){
					filasTesoro=i;
					columnasTesoro=j;
				}





				juegoActual=archivoJuego;}}


	}

	//
	// M�todos
	// 

	/**
	 * Retorna el n�mero de filas del explorador de cuevas.
	 * @return N�mero de filas del campo minadoexplorador de cuevas.
	 */
	public int darFilas( )
	{
		return filas;
	}

	/**
	 * Retorna el n�mero de columnas del explorador de cuevas.
	 * @return N�mero de columnas del explorador de cuevas.
	 */
	public int darColumnas( )
	{
		return columnas;
	}

	/**
	 * Retorna el n�mero de bombas del explorador de cuevas.
	 * @return N�mero de bombas del explorador de cuevas.
	 */
	public int darNumeroBombas( )
	{
		return cantidadBombas;
	}


	/**
	 * Retorna la cantidad de movimientos restantes.
	 * @return Cantidad de movimientos restantes.
	 */
	public int darCantidadMovimientos(){
		return cantidadMovimientos;
	}

	/**
	 * Devuelve la casilla en la posici�n especificada.
	 * @param pFila Fila de la casilla.
	 * @param pColumna Columna de la casilla.
	 * @return Casilla en la posici�n especificada (pFila, pColumna).
	 */
	public Casilla darCasilla( int pFila, int pColumna )
	{
		return casillasExploradorCuevas[ pFila ][ pColumna ];
	}


	/**
	 * Indica si el juego ya est� terminado e informa el resultado.
	 * @return Retorna un c�digo indicando el estado del juego. <br>
	 *         El resultado puede ser CONTINUA_JUEGO, si el juego no ha terminado. <br>
	 *         Puede ser tambi�n JUEGO_GANADO o JUEGO_PERDIDO_BOMBA o JUEGO_PERDIDO_MOVIMIENTOS si el juego ya termin� y el jugador gan� o perdi�, respectivamente.
	 */
	public String[][] darEstadoJuego( )
	{
		String[][] estadoJuego=new String[filas][columnas];
		for(int i=0; i< filas;i++){
			for(int j=0; j<columnas; j++){
				estadoJuego[i][j]=casillasExploradorCuevas[i][j].darEstado();
			}
		}
		return estadoJuego;
	}


	/**
	 * Retorna si un movimiento es valido o no.
	 * @return un booleano que indica si el movimiento es valido o no
	 */
	public boolean movimientoValido(int pX,int pY){

		int x= filasJugador + pY;
		int y=columnasJugador + pX;
		if(x<0 || x>=casillasExploradorCuevas[0].length){
			return false;
		}
		if(y<0 || y>=casillasExploradorCuevas.length){
			return false;
		}
		if(casillasExploradorCuevas[x][y].darEstado().equals(Casilla.OBSTACULO)){
			return false;
		}
		return true;
	}

	/**
	 * Es el metodo principal pa mover al explorador en la matriz.
	 * @param pX posicion x del jugador en la matriz
	 * @param pY posicion y del jugador en la matriz
	 * @throws Exception si el movimiento es invalido
	 */
	public void moverse(int pX, int pY)throws Exception{
		boolean movimiento=movimientoValido(pX, pY);
		if(movimiento){
			casillasExploradorCuevas[filasJugador][columnasJugador].actualizarEstado(Casilla.NADA);
			filasJugador = filasJugador + pY;
			columnasJugador = columnasJugador + pX;
			cantidadMovimientos--;
		}
		else
		{
			throw new Exception("invalido");
		}


	}

	/**
	 * Revisa la casilla para ver si hay una bomba o no, si hay una perdio el juego
	 * @throws Exception si hay una bomba en la casilla
	 */
	public void revisarBomba() throws Exception{

		if(casillasExploradorCuevas[filasJugador][columnasJugador].darEstado().equals(Casilla.BOMBA)){
			throw new Exception("�Pisaste una bomba y perdiste :(");
		}
		casillasExploradorCuevas[filasJugador][columnasJugador].actualizarEstado(Casilla.JUGADOR);

	}
	/**
	 * revisa si hay bombas cecanas a una casilla
	 * @param fila de la matriz
	 * @param columna de la matriz
	 * @return las bombas cercanas a la casilla
	 */
	public int darBombasCercanas(int fila, int columna){
		int bombas = 0;
		for(int i = 0; i < casillasExploradorCuevas.length;i++){
			for(int j = 0; j < casillasExploradorCuevas[i].length;j++){
				if(i<= fila + 1 && i >= fila -1 && j <= columna + 1
						&& j >= columna - 1){
					if(casillasExploradorCuevas[i][j].darEstado().equals(Casilla.BOMBA)){
						bombas++;
					}
				}
			}
		}
		return bombas;
	}
	/**
	 * retorna la fila donde esta el jugador
	 * @return Fila del jugador
	 */
	public int darFilaJugador(){
		return filasJugador;
	}
	/**
	 * retorna la columna donde esta el jugador
	 * @return columna del jugador
	 */
	public int darColumnasJugador(){
		return columnasJugador;
	}
	/**
	 * revisa si la partida ya se gano
	 * @throws Exception si el jugador esta en la misma posicion del tesoro.
	 */
	public void gano() throws Exception{
		if(filasJugador == filasTesoro && columnasTesoro == columnasJugador){
			throw new Exception("ganaste");
		}
	}
	/**
	 * M�todo 1 de extensi�n al ejemplo.
	 * @return Respuesta 1.
	 */
	public String metodo1( )
	{
		return "Respuesta 1";
	}

	/**
	 * M�todo 2 de extensi�n al ejemplo.
	 * @return Respuesta 2.
	 */
	public String metodo2( )
	{
		return "Respuesta 2";
	}









}



