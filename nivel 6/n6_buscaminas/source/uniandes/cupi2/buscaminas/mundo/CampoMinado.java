/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n6_buscaminas
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.buscaminas.mundo;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import uniandes.cupi2.buscaminas.mundo.Casilla.Tipo;

/**
 * Esta clase representa el campo minado y conoce las casillas que ha jugado el usuario.
 */
public class CampoMinado
{
 // -----------------------------------------------------------------
    // Enumeraciones
    // -----------------------------------------------------------------
    
    /**
     * Enumeradores para los tipos de estado y valor de la casilla.
     */
    public enum EstadoJuego
    {
        /**
         * Indica que el juego debe continuar. <br>
         * No se han destapado todas las casillas que no tienen bomba y no se ha destapado una casilla con bomba.
         */
        CONTINUA_JUEGO,

        /**
         * Indica que el juego fue ganado porque se destaparon todas las casillas que no est�n minadas.
         */
        JUEGO_GANADO,

        /**
         * Indica que el juego fue perdido porque se destap� una casilla que estaba minada.
         */
        JUEGO_PERDIDO;
    }

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la matriz donde se marcan las casillas que se han jugado. <br>
     * Cada casilla puede estar TAPADA, DESTAPADA o MARCADA.
     */
    private Casilla[][] casillasCampoMinado;

    /**
     * Cantidad de columnas del campo minado.
     */
    private int columnas;

    /**
     * Cantidad de filas del campo minado.
     */
    private int filas;

    /**
     * Indica si ya el juego se termin� y el resultado.
     */
    private EstadoJuego estadoJuego;

    /**
     * La hora en la que empez� el juego.
     */
    private long tiempoInicio;

    /**
     * La hora en la que termin� el juego.
     */
    private long tiempoFinal;

    /**
     * La cantidad de minas que hay en el campo minado.
     */
    private int cantidadMinas;

    /**
     * La cantidad de minas faltantes por encontrar.
     */
    private int cantidadFaltantes;
    
	/**
	 * Se va a usar para reiniciar el juego
	 */
	private Properties estadoInicial;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo juego de buscaminas con el tama�o del campo minado y el n�mero de minas especificados en el archivo de entrada. <br>
     * La distribuci�n de las minas se realiza de manera aleatoria. <br>
     * <b>post: </b> Se construy� un nuevo campo minado del tama�o y n�mero de minas especificados en el archivo. <br>
     * Todas las casillas est�n tapadas y desmarcadas. <br>
     * La distribuci�n de las minas se realiz� de manera aleatoria. <br>
     * El tiempo de inicio se inicializ� en cero.
     * @param archivoJuego - File, archivo en donde se encuentra el properties. No es nulo.
     * @throws Exception Se lanza esta excepci�n si hay problemas cargando el archivo.
     */
    public CampoMinado(File archivoJuego) throws Exception
    {
        cargarInfoJuego( archivoJuego );
    }

    /**
     * Carga la informaci�n del campo minado en un objeto de tipo Properties.
     * @param archivoJuego File, archivo en donde se encuentra el properties. No es nulo.
     * @throws Exception Si hay alg�n problema leyendo el properties
     */
    private void cargarInfoJuego( File archivoJuego ) throws Exception
    {
		// 1. Creamos una variable(objeto) de tipo Properties
		// y la inicializamos
        Properties datos = new Properties( );
        
		// 2. Mediante un objeto de tipo FileInputStream tomamos
		// el stream de datos del archivo que recibimos por par�metro
		FileInputStream in = new FileInputStream(archivoJuego);
		
		// 3. Tenemos que llamar el m�todo .load de Properties sobre
		// nuestro objeto para cargar los datos del stream y poderlos
		// manipular
		datos.load(in);
		
		// 5. Vamos a llamar un m�todo que recibe por par�metro los Properties
		// y llena los valores en la matriz
		

		// 4. SIEMPRE cerramos el FileInputStream al terminar la carga
		in.close();
		
		inicializarJuego(datos);
		//inicializarJuego2(datos);
		// guardamos atributos con el estado inicial
		//Nos servir� para reiniciar el juego
		estadoInicial = datos;

    }
    
    /**
     * Permite reiniciar un juego
     */
    public void reiniciarJuego(){
    	inicializarJuego(estadoInicial);
    }
    
    /**
     * Crea un nuevo campo minado de juego, tapando todas las casillas y asignando las minas. El tiempo de inicio del juego se inicializa en 0. <br>
     * <b>post: </b> El campo minado qued� inicializado, sin marcas, con todas las casillas tapadas, con las minas seg�n las posiciones del properties y<br>
     * con el tiempo de inicio en 0. El n�mero de minas destapadas tambi�n se actualiz� en cero.
     */
    public void inicializarJuego(Properties datos )
    {

    	// 1. inicializamos el n�mero de filas y columnas
    	// el m�todo .getProperty(llave), siempre retorna un String
    	String strFilas = datos.getProperty( "buscaminas.filas" );
        filas = Integer.parseInt( strFilas );
        String strColumnas = datos.getProperty( "buscaminas.columnas" );
        columnas = Integer.parseInt( strColumnas );

        //2. Se construye un nuevo campo minado seg�n los valores obtenidos.
        casillasCampoMinado = new Casilla[filas][columnas];
        
        //Inicializamos este atributo en cero (en el pr�ximo ciclo lo actualizaremos)
        cantidadMinas = 0;
        
        //3. Ahora vamos a inicializar la matriz, por cada fila hay una propiedad
        //   Luego recorremos todos los caracteres del string de la propiedad y esos son los valores de cada columna
        //   Para obtener el caracter de un string, usamos la instrucci�n charAt(<pos>) donde la posici�n es un �ndice
        //   Si tenemos la palabra "Hola" y decimos "Hola".charAt(0), nos retorna el caracter 'H'.


        for( int i = 0; i < filas; i++ )
        {
        	//Obtenemos la propiedad que tiene la informaci�n de esta fila
        	String datosFila = datos.getProperty( "buscaminas.fila" + i );
        	//Si i = 2, estamos obteniendo la propiedad "buscaminas.fila2" y letrasFila tendra el valor "0000"
        	//Si i = 3, estamos obteniendo la propiedad "buscaminas.fila3" y letrasFila tendra el valor "000X"
            for( int j = 0; j < columnas; j++ )
            {
            	//Aqui queremos obtener la letra que est� en la posici�n j de datosFila, esta sera la letra que indica 
            	// si la posici�n en la matriz i, j tendr� o no una mina
            	char datosFilaColumna = datosFila.charAt(j);
            	if(datosFilaColumna == 'X'){
            		//Por convenci�n la letra X indica que  hay una mina.
                    casillasCampoMinado[ i ][ j ] = new Casilla( Tipo.MINADA, Tipo.TAPADA, i, j );
                    cantidadMinas++; //Actualizamos la cantidad de minas.
            	}else{
            		//Cualquier otra letra significa que no hay mina
            		casillasCampoMinado[ i ][ j ] = new Casilla( Tipo.VACIA, Tipo.TAPADA, i, j );
            	}
            }
        }


        //Inicializar en el juego el n�mero de minas faltantes.
        cantidadFaltantes = cantidadMinas;
        
        // Se inicializa el estado del juego
        estadoJuego = EstadoJuego.CONTINUA_JUEGO;
        // Se inicializa el tiempo de inicio en cero
        tiempoInicio = 0;

    }
    
    
    /**
     * Crea un nuevo campo minado de juego, tapando todas las casillas y asignando las minas. El tiempo de inicio del juego se inicializa en 0. <br>
     * <b>post: </b> El campo minado qued� inicializado, sin marcas, con todas las casillas tapadas, con las minas seg�n las posiciones del properties y<br>
     * con el tiempo de inicio en 0. El n�mero de minas destapadas tambi�n se actualiz� en cero.
     */
    public void inicializarJuego2(Properties datos )
    {
    	//TODO: Cargar los otros atributos del modelo del mundo a partir del archivo .properties
        
        //Inicializar en el juego el n�mero de minas faltantes.
        cantidadFaltantes = cantidadMinas;
        // Se inicializa el estado del juego
        estadoJuego = EstadoJuego.CONTINUA_JUEGO;
        // Se inicializa el tiempo de inicio en cero
        tiempoInicio = 0;
    }
    

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el n�mero de filas del campo minado.
     * @return N�mero de filas del campo minado.
     */
    public int darFilas( )
    {
        return filas;
    }

    /**
     * Retorna el n�mero de columnas del campo minado.
     * @return N�mero de columnas del campo minado.
     */
    public int darColumnas( )
    {
        return columnas;
    }

    /**
     * Retorna el n�mero de minas del campo minado.
     * @return N�mero de minas del campo minado.
     */
    public int darNumeroMinas( )
    {
        return cantidadMinas;
    }

    /**
     * Devuelve la casilla en la posici�n especificada.
     * @param pFila Fila de la casilla.
     * @param pColumna Columna de la casilla.
     * @return Casilla en la posici�n especificada (pFila, pColumna).
     */
    public Casilla darCasilla( int pFila, int pColumna )
    {
        return casillasCampoMinado[ pFila ][ pColumna ];
    }

    /**
     * Retorna el n�mero de minas que quedan por descubrir seg�n el n�mero de marcas que se han puesto.
     * @return numeroMinas N�mero de minas por descubrir.
     */
    public int darCantidadMinasRestantes( )
    {
        return cantidadFaltantes;
    }

    /**
     * Retorna una representaci�n matricial de las casillas del campo minado. <br>
     * Si el juego no ha terminado se devuelven las casillas con los siguientes estados: <br>
     * Las casillas que est�n tapadas se muestran tapadas a menos que est�n marcadas. <br>
     * De las casillas que est�n destapadas se muestra el n�mero de minas cercanas. Si el juego ya termin� se devuelven las casillas con los siguientes estados: <br>
     * Si el jugador gan�, entonces se muestran las casillas igual que como se mostrar�n si el juego no hubiera terminado. <br>
     * Si el juego termin� y el jugador perdi� entonces las casillas tapadas sin marcar se muestran tapadas a menos que tengan una bomba, en cuyo caso <br>
     * esta se debe mostrar; las casillas marcadas que ten�an una bomba se muestran marcadas, mientras que las marcadas que no ten�an bomba se muestran <br>
     * como marcadas equivocadas; para las casillas destapadas se muestra el n�mero de bombas cercanas excepto para la casilla que conten�a la bomba, <br>
     * en la cual se muestra la bomba estallada.
     * @return Matriz de objetos de tipo Casilla.
     */
    public Casilla[][] darCasillas( )
    {
        Casilla[][] casillasSegunEstado;
        if( estadoJuego == EstadoJuego.CONTINUA_JUEGO )
        {
            casillasSegunEstado = darCasillasEnJuego( );
        }
        else
        {
            casillasSegunEstado = darCasillasFinalJuego( );
        }
        return casillasSegunEstado;
    }

    /**
     * Retorna las casillas como se deben ver durante el juego. <br>
     * Las posiciones que est�n tapadas se muestran tapadas, a menos que est�n marcadas. <br>
     * De las posiciones que est�n destapadas se muestra el n�mero de minas cercanas.
     * @return Matriz de objetos de tipo Casilla.
     */
    private Casilla[][] darCasillasEnJuego( )
    {
        Casilla[][] casillas = new Casilla[filas][columnas];

        for( int i = 0; i < filas; i++ )
        {
            for( int j = 0; j < columnas; j++ )
            {
                if( casillasCampoMinado[ i ][ j ].darEstado( ) == Tipo.TAPADA )
                {
                    casillas[ i ][ j ] = new Casilla( casillasCampoMinado[ i ][ j ].darValor( ), Tipo.TAPADA, i, j );
                }
                else if( casillasCampoMinado[ i ][ j ].darEstado( ) == Tipo.MARCADA )
                {
                    casillas[ i ][ j ] = new Casilla( casillasCampoMinado[ i ][ j ].darValor( ), Tipo.MARCADA, i, j );
                }
                else
                // Tipo.DESTAPADA
                {
                    int minasCercanas = calcularMinasCercanas( i, j );
                    casillas[ i ][ j ] = darCasillaSegunMinas( minasCercanas, i, j );
                }
            }
        }
        return casillas;
    }

    /**
     * Retorna las casillas como se deben ver al finalizar el juego. <br>
     * Si el juego termin� y el jugador gan�, entonces se muestran las casillas igual que como se mostrar�an si el juego no hubiera terminado. <br>
     * Si el juego termin� y el jugador perdi� entonces las casillas tapadas sin marcar se muestran tapadas a menos que tengan una bomba, en cuyo caso esta <br>
     * se debe mostrar; las casillas marcadas que ten�an una bomba se muestran marcadas, mientras que las marcadas que no ten�an bomba se muestran como <br>
     * marcadas equivocadas; para las casillas destapadas se muestra el n�mero de bombas cercanas menos para la casilla que conten�a la bomba, en la cual <br>
     * se muestra la bomba estallada.
     * @return Matriz de objetos de tipo Casilla.
     */
    private Casilla[][] darCasillasFinalJuego( )
    {
        Casilla[][] casillas = new Casilla[filas][columnas];

        for( int i = 0; i < filas; i++ )
        {
            for( int j = 0; j < columnas; j++ )
            {
                switch( casillasCampoMinado[ i ][ j ].darEstado( ) )
                {
                    case TAPADA:
                        if( casillasCampoMinado[ i ][ j ].darValor( ) == Tipo.MINADA )
                        {
                            casillas[ i ][ j ] = new Casilla( casillasCampoMinado[ i ][ j ].darValor( ), Tipo.BOMBA_SIN_ESTALLAR, i, j );
                        }
                        else
                        {
                            casillas[ i ][ j ] = new Casilla( casillasCampoMinado[ i ][ j ].darValor( ), Tipo.TAPADA, i, j );
                        }
                        break;

                    case MARCADA:

                        if( casillasCampoMinado[ i ][ j ].darValor( ) == Tipo.MINADA )
                        {
                            casillas[ i ][ j ] = new Casilla( casillasCampoMinado[ i ][ j ].darValor( ), Tipo.MARCADA, i, j );
                        }
                        else
                        {
                            casillas[ i ][ j ] = new Casilla( casillasCampoMinado[ i ][ j ].darValor( ), Tipo.MARCADA_EQUIVOCADA, i, j );
                        }
                        break;
                    default:
                        if( casillasCampoMinado[ i ][ j ].darValor( ) == Tipo.MINADA )
                        {
                            casillas[ i ][ j ] = new Casilla( casillasCampoMinado[ i ][ j ].darValor( ), Tipo.BOMBA_ESTALLADA, i, j );
                        }
                        else
                        {
                            int minasCercanas = calcularMinasCercanas( i, j );
                            casillas[ i ][ j ] = darCasillaSegunMinas( minasCercanas, i, j );
                        }

                }
            }
        }
        return casillas;

    }

    /**
     * Este m�todo sirve para obtener el tipo correcto de una casilla seg�n el n�mero de minas que haya cerca de ella.
     * @param pMinas Es el n�mero de minas que hay cerca de la casilla. 0 <= pMinas <= 8.
     * @param pFila N�mero de fila de la casilla.
     * @param pColumna N�mero de columna de la casilla.
     * @return Retorna una casilla del tipo correspondiente al n�mero de minas cercanas.
     */
    public Casilla darCasillaSegunMinas( int pMinas, int pFila, int pColumna )
    {
        Tipo tipo = Tipo.CERCA_0;
        switch( pMinas )
        {
            case 0:
                tipo = Tipo.CERCA_0;
                break;
            case 1:
                tipo = Tipo.CERCA_1;
                break;
            case 2:
                tipo = Tipo.CERCA_2;
                break;
            case 3:
                tipo = Tipo.CERCA_3;
                break;
            case 4:
                tipo = Tipo.CERCA_4;
                break;
            case 5:
                tipo = Tipo.CERCA_5;
                break;
            case 6:
                tipo = Tipo.CERCA_6;
                break;
            case 7:
                tipo = Tipo.CERCA_7;
                break;
            case 8:
                tipo = Tipo.CERCA_8;
                break;
        }
        return new Casilla( tipo, tipo, pFila, pColumna );
    }

    /**
     * Este m�todo sirve para saber cuantas minas hay alrededor de una casilla.
     * @param pI Coordenada x de la casilla.
     * @param pJ Coordenada y de la casilla.
     * @return El n�mero de minas que hay cerca de la casilla. 0 <= n�mero <= 8.
     */
    private int calcularMinasCercanas( int pI, int pJ )
    {
        int cercanas = 0;
        int delta = 1;
        for( int r = pI - delta; r <= pI + delta; r++ )
        {
            for( int s = pJ - delta; s <= pJ + delta; s++ )
            {
                if( r >= 0 && r < filas && s >= 0 && s < columnas )
                {
                    if( casillasCampoMinado[ r ][ s ].darValor( ) == Tipo.MINADA )
                    {
                        cercanas++;
                    }
                }
            }
        }
        return cercanas;
    }

    /**
     * Destapa una casilla del campo minado. <br>
     * Si la casilla conten�a una bomba entonces la bomba estalla y termina el juego. <br>
     * Si la casilla no ten�a una bomba, pero estaba cerca de una, entonces la casilla correspondiente ahora deber� indicar el n�mero de bombas cercanas. <br>
     * <b>post: </b> La casilla est� destapada y se actualiz� el estado del juego: n�mero de minas restantes y el tiempo de juego.
     * @param pX La coordenada x de la casilla que se quiere destapar.
     * @param pY La coordenada y de la casilla que se quiere destapar.
     * @return Retorna un c�digo indicando el resultado de la jugada. <br>
     *         El resultado puede ser CONTINUA_JUEGO, si con la jugada el juego no termina. <br>
     *         Puede ser tambi�n JUEGO_GANADO o JUEGO_PERDIDO si con la jugada el juego termina.
     * @throws Exception Si la casilla ya est� destapada o el juego ya termin�.
     */
    public EstadoJuego destapar( int pX, int pY ) throws Exception
    {

        if( casillasCampoMinado[ pX ][ pY ].darEstado( ) == Tipo.DESTAPADA )
        {
            throw new Exception( "La casilla indicada ya est� destapada" );
        }

        if( estadoJuego != EstadoJuego.CONTINUA_JUEGO )
        {
            throw new Exception( "El juego ya termin� y no pueden realizarse m�s jugadas" );
        }

        EstadoJuego resultadoJugada = EstadoJuego.CONTINUA_JUEGO;

        if( calcularMinasCercanas( pX, pY ) == 0 )
        {
            expandir( pX, pY );
        }

        casillasCampoMinado[ pX ][ pY ].cambiarEstado( Tipo.DESTAPADA );
        if( casillasCampoMinado[ pX ][ pY ].darValor( ) == Tipo.MINADA )
        {
            resultadoJugada = EstadoJuego.JUEGO_PERDIDO;
        }
        else
        {
            resultadoJugada = verificarFinal( );
        }
        estadoJuego = resultadoJugada;

        calcularTiempoDeJuego( );

        return resultadoJugada;
    }

    /**
     * Calcula el tiempo actual cada vez que se hace una jugada. Para ello utiliza un objeto de la clase Date.
     */
    private void calcularTiempoDeJuego( )
    {
        if( tiempoInicio == 0 )
        {
            tiempoInicio = ( new Date( ) ).getTime( );
        }
        tiempoFinal = ( new Date( ) ).getTime( );
    }

    /**
     * Este m�todo hace que todas las casillas que est�n cercanas a una casilla sin minas cercanas queden destapadas. <br>
     * Una casilla est� cercana a otra si entre ellas es posible establecer un camino que pasa �nicamente por casillas sin minas cercanas.
     * @param pFila Fila de una casilla sin minas cercanas.
     * @param pColumna Columna de una casilla sin minas cercanas.
     */
    private void expandir( int pFila, int pColumna )
    {
        ArrayList<Casilla> cercanas = new ArrayList<Casilla>( );
        Casilla c = darCasilla( pFila, pColumna );
        cercanas.add( c );

        while( !cercanas.isEmpty( ) )
        {
            Casilla d = cercanas.remove( 0 );
            int i = d.darFila( );
            int j = d.darColumna( );
            casillasCampoMinado[ i ][ j ].cambiarEstado( Tipo.DESTAPADA );

            int delta = 1;
            for( int r = i - delta; r <= i + delta; r++ )
            {
                for( int s = j - delta; s <= j + delta; s++ )
                {
                    if( r >= 0 && r < filas && s >= 0 && s < columnas && ( r != i || s != j ) )
                    {
                        if( casillasCampoMinado[ r ][ s ].darEstado( ) == Tipo.TAPADA )
                        {
                            casillasCampoMinado[ r ][ s ].cambiarEstado( Tipo.DESTAPADA );

                            if( calcularMinasCercanas( r, s ) == 0 )
                            {
                                d = casillasCampoMinado[ r ][ s ];
                                cercanas.add( d );
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Verifica si ya el juego termin�. <br>
     * El juego termina cuando todas las casillas sin minas est�n destapadas o cuando hay una casilla minada que est� destapada.
     * @return Retorna un c�digo indicando el estado del juego. <br>
     *         El resultado puede ser CONTINUA_JUEGO, si el juego no ha terminado. <br>
     *         Puede ser tambi�n JUEGO_GANADO o JUEGO_PERDIDO si el juego ya termin� y el jugador gan� o perdi�, respectivamente.
     */
    private EstadoJuego verificarFinal( )
    {
        boolean sigueJuego = false;

        for( int i = 0; i < filas && !sigueJuego; i++ )
        {
            for( int j = 0; j < columnas && !sigueJuego; j++ )
            {
                if( casillasCampoMinado[ i ][ j ].darValor( ) == Tipo.VACIA && ( casillasCampoMinado[ i ][ j ].darEstado( ) == Tipo.TAPADA || casillasCampoMinado[ i ][ j ].darEstado( ) == Tipo.MARCADA ) )
                {
                    sigueJuego = true;
                }
            }
        }

        EstadoJuego estadoJuegoi = EstadoJuego.CONTINUA_JUEGO;

        if( !sigueJuego )
        {
            estadoJuegoi = EstadoJuego.JUEGO_GANADO;

            boolean finJuego = false;
            for( int i = 0; i < filas && !finJuego; i++ )
            {
                for( int j = 0; j < columnas && !finJuego; j++ )
                {
                    if( casillasCampoMinado[ i ][ j ].darValor( ) == Tipo.MINADA && casillasCampoMinado[ i ][ j ].darEstado( ) == Tipo.DESTAPADA )
                    {
                        finJuego = true; // Estall� una bomba
                        estadoJuegoi = EstadoJuego.JUEGO_PERDIDO;
                    }
                }
            }
        }

        return estadoJuegoi;
    }

    /**
     * Sirve para poner una marca en una casilla. <br>
     * <b>pre: </b> La casilla no est� marcada ni est� destapada y el juego no ha terminado. <br>
     * <b>post: </b> Se marc� la casilla.
     * @param pX La coordenada x de la casilla que se quiere marcar.
     * @param pY La coordenada y de la casilla que se quiere marcar.
     * @throws Exception Si la casilla ya est� marcada o est� destapada o el juego ya termin�.
     */
    public void marcar( int pX, int pY ) throws Exception
    {
        if( casillasCampoMinado[ pX ][ pY ].darEstado( ) == Tipo.MARCADA || casillasCampoMinado[ pX ][ pY ].darEstado( ) == Tipo.DESTAPADA )
        {
            throw new Exception( "La casilla indicada ya est� marcada o destapada" );
        }

        if( estadoJuego != EstadoJuego.CONTINUA_JUEGO )
        {
            throw new Exception( "El juego ya termin� y no pueden realizarse m�s jugadas" );
        }

        casillasCampoMinado[ pX ][ pY ].cambiarEstado( Tipo.MARCADA );
        if( cantidadMinas > 0 )
        {
            cantidadFaltantes--;
        }
    }

    /**
     * Quita una marca de una casilla. <br>
     * <b>post: </b> Se desmarc� la casilla.
     * @param x La coordenada x de la casilla que se quiere desmarcar.
     * @param y La coordenada y de la casilla que se quiere desmarcar.
     * @throws Exception Si la casilla no est� marcada o el juego ya termin�.
     */
    public void desmarcar( int x, int y ) throws Exception
    {
        if( casillasCampoMinado[ x ][ y ].darEstado( ) == Tipo.TAPADA || casillasCampoMinado[ x ][ y ].darEstado( ) == Tipo.DESTAPADA )
        {
            throw new Exception( "La casilla indicada no est� marcada" );
        }

        if( estadoJuego != EstadoJuego.CONTINUA_JUEGO )
        {
            throw new Exception( "El juego ya termin� y no pueden realizarse m�s jugadas" );
        }

        casillasCampoMinado[ x ][ y ].cambiarEstado( Tipo.TAPADA );
        if( cantidadFaltantes < cantidadMinas )
        {
            cantidadFaltantes++;
        }
    }


    /**
     * Genera un n�mero entero aleatorio entre 0 y (pTamRango - 1).
     * @param pTamRango Tama�o del rango.
     * @return N�mero entero entre 0 y (tamRango - 1).
     */
    public int generarNumeroAleatorioEnRango( int pTamRango )
    {
        return ( int ) ( Math.random( ) * pTamRango );
    }

    /**
     * Retorna el tiempo total en segundos que fue necesario para resolver el juego.
     * @return Tiempo.
     */
    public int darTiempoTotal( )
    {
        int tiempo = 0;
        if( tiempoInicio != 0 )
        {
            tiempo = ( int ) ( ( tiempoFinal - tiempoInicio ) / 1000 );
        }
        return tiempo;
    }

    /**
     * Indica si el juego ya est� terminado e informa el resultado.
     * @return Retorna un c�digo indicando el estado del juego. <br>
     *         El resultado puede ser CONTINUA_JUEGO, si el juego no ha terminado. <br>
     *         Puede ser tambi�n JUEGO_GANADO o JUEGO_PERDIDO si el juego ya termin� y el jugador gan� o perdi�, respectivamente.
     */
    public EstadoJuego darEstadoJuego( )
    {
        return estadoJuego;
    }
    
    /**
     * Cuenta cuantas filas tiene m�s de 3 minas
     * pre: La matriz de Casillas ya est� inicializada
     * @return Numero de filas con m�s de 3 minas
     */
    public int numFilasMas3Minas(){
    	int numFilas = 0;
    	for(int i = 0; i < filas; i++){
    		int numMinas = 0;
    		boolean termino = false;
    		for(int j = 0; j< columnas && !termino; j++){
    			if(casillasCampoMinado[i][j].darValor() == Tipo.MINADA){
    				numMinas++;
    			}
    			if(numMinas == 3){
    				termino = true;
    				numFilas++;
    			}
    		}
    	}
    	return numFilas;
    }
    
    /**
     * Retorna el �ndice de la fila que m�s minas tiene.
     * pre: La matriz de Casillas ya est� inicializada
     * @return Indice de la fila con m�s minas
     */
    public int darFilaConMasMinas(){
    	int filaMasMinas = -1;
    	int maxMinas = 0;
    	for(int i = 0; i< filas;i++){
    		int numMinas = 0;
    		for(int j = 0; j<columnas; j++){
    			if(casillasCampoMinado[i][j].darValor() == Tipo.MINADA){
    				numMinas++;
    			}
    		}
    		if(numMinas > maxMinas){
    			filaMasMinas = i;
    			maxMinas = numMinas;
    		}
    	}
    	return filaMasMinas;
    }
    
    /**
     * Cuenta cuantas casillas hay de un tipo dado en el campo minado
     * pre: La matriz de Casillas ya est� inicializada
     * @return n�mero de casillas en el campo minado
     */
    public int contarCasillasTipo(Tipo tipo){
    	int numTipo = 0;
    	for(int i = 0; i< filas; i++){
    		for(int j = 0; j<columnas; j++){
    			if(casillasCampoMinado[i][j].darEstado() == tipo){
    				numTipo++;
    			}
    		}
    	}
    	return numTipo;
    }
    
    /**
     * Cuenta cuantas columnas hay vacias en el campo minado
     * pre: La matriz de Casillas ya est� inicializada
     * @return Cuenta el n�mero de columnas vac�as en el campo Minado
     */
    public int contarColumnasVacias(){
    	int numColumnas = 0;
    	for(int j = 0; j<columnas; j++){
    		boolean termino = false;
    		for(int i = 0; i<filas && !termino;i++){
    			if(casillasCampoMinado[i][j].darValor() == Tipo.MINADA){
    				termino = true;
    			}
    		}
    		if(termino == false){
    			numColumnas++;
    		}
    	}
    	return numColumnas;
    }
    
    /**
     * Se encarga de destapar las minas del borde del campo minado
     * pre: La matriz de Casillas ya est� inicializada
     */
    public void destaparBorde(){
    	for(int i = 0; i<filas; i++){
    		if(i == 0 || i == filas-1){
    			for(int j = 0; j<columnas; j++){
        			casillasCampoMinado[i][j].cambiarEstado(Tipo.DESTAPADA);
    			}
    		}else{
    			casillasCampoMinado[i][0].cambiarEstado(Tipo.DESTAPADA);
    			casillasCampoMinado[i][filas-1].cambiarEstado(Tipo.DESTAPADA);
    		}
    	}
    }
    
    /**
     * Cuenta cuantas minas hay en el borde del campo minado
     * pre: La matriz de Casillas ya est� inicializada
     * @return N�mero de minas en el borde del campo minado
     */
    public int contarMinasBorde(){
    	int numMinas = 0;
    	for(int i = 0; i<filas; i++){
    		if(i == 0 || i == filas-1){
    			for(int j = 0; j<columnas; j++){
        			if(casillasCampoMinado[i][j].darValor() == Tipo.MINADA){
        				numMinas++;
        			}
    			}
    		}else{
    			if(casillasCampoMinado[i][0].darValor() == Tipo.MINADA){
    				numMinas++;
    			}
    			if(casillasCampoMinado[i][filas-1].darValor() == Tipo.MINADA){
    				numMinas++;
    			}
    		}
    	}
    	return numMinas;
    }
    
    /**
     * Cuenta cuantas minas juntas hay en un campo minado
     * pre: La matriz de Casillas ya est� inicializada
     * Hay dos minas juntas si una esta directamente arriba, abajo o a alguno de los lados de la mina
     * Es decir, NO cuentan las diagonales.
     * 
     * Pista: Asegurse de no contar dos veces ;)
     */
    public int dosMinasJuntas(){
    	//TODO: BONO
    	return 0;
    }

    // -----------------------------------------------------------------
    // M�todos de extensi�n
    // -----------------------------------------------------------------

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