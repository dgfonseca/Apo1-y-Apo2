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
package uniandes.cupi2.parqueadero.mundo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;







/**
 * Esta clase representa un parqueadero con TAMANO puestos. <br>
 * TODO HECHO Parte 1 Punto E: Documente la invariante de la clase.
 * <b>inv: </b> <br>
 * tarifa >=0<br>
 * valorEnCaja >= 0 <br>
 * horaActual>=6 horaActual<=21 <br>
 * abierto !=null
 */
public class Parqueadero
{

	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------

	/**
	 * Indica la cantidad de puestos en el parqueadero.
	 */
	public static final int TAMANO = 40;

	/**
	 * Es la hora a la que se abre el parqueadero.
	 */
	public static final int HORA_INICIAL = 6;

	/**
	 * Es la hora a la que se cierra el parqueadero.
	 */
	public static final int HORA_CIERRE = 20;

	/**
	 * Es la tarifa inicial del parqueadero.
	 */
	public static final int TARIFA_INICIAL = 1200;

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Lista de puestos.
	 */
	private Puesto puestos[];

	/**
	 * Lista de carros.
	 */
	private ArrayList<Carro> carros;

	/**
	 * Tarifa por hora en el parqueadero.
	 */
	private int tarifa;

	/**
	 * Cantidad de dinero en la caja del parqueadero.
	 */
	private double valorEnCaja;

	/**
	 * Hora actual en el parqueadero.
	 */
	private int horaActual;

	/**
	 * Indica si el parqueadero está abierto.
	 */
	private boolean abierto;
	
	private String archivoP;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
     * Construye el parqueadero con su estado a partir de un archivo serializado. <br>
     * <b>post: </b> Se cargó el estado del parqueadero con la información del archivo dado por parámetro. <br>
     * Si hay algún problema cargando el archivo, lanza excepción. <br>
     * Si no existe el archivo seralizado, crea la lista de carros vacía y configura la lista puestos vacíos.
     * @param pRuta Ruta del archivo del cual se cargará el estado del mundo.
     * @throws PersistenciaException Se lanza una excepción si hay algún error cargando los datos del archivo.
     */
    public Parqueadero( String pRuta ) throws PersistenciaException
	{
		horaActual = HORA_INICIAL;
		abierto = true;
		tarifa = TARIFA_INICIAL;
		valorEnCaja = 0;

		puestos = new Puesto[TAMANO];
		for( int i = 0; i < TAMANO; i++ )
		{
			puestos[ i ] = new Puesto( i );
		}

		carros = new ArrayList<Carro>( );
    	 
		


	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Indica si el parqueadero está abierto.
	 * @return Retorna true si el parqueadero está abierto, false en caso contrario.
	 */
	public boolean estaAbierto( )
	{
		return abierto;
	}

	/**
	 * Retorna la lista de puestos en el parqueadero.
	 * @return La lista de puestos.
	 */
	public Puesto[] darPuestos( )
	{
		return puestos;
	}

	/**
	 * Retorna la lista de carros que se encuentran en el parqueadero.
	 * @return La lista de carros que se encuentran en el parqueadero.
	 */
	public ArrayList<Carro> darCarros( )
	{
		return carros;
	}

	/**
	 * Retorna la tarifa por hora que maneja el parqueadero.
	 * @return La tarifa que se está aplicando en el parqueadero.
	 */
	public int darTarifa( )
	{
		return tarifa;
	}

	/**
	 * Retorna la hora actual.
	 * @return La hora actual en el parqueadero.
	 */
	public int darHoraActual( )
	{
		return horaActual;
	}

	/**
	 * Indica la cantidad de dinero que hay en la caja.
	 * @return Los ingresos totales en la caja.
	 */
	public double darMontoCaja( )
	{
		return valorEnCaja;
	}

	/**
	 * Cambia la tarifa del parqueadero.
	 * <b>post: </b> Se cambió la tarifa con la cual se cobran las horas en el parqueadero.
	 * @param pTarifa Nueva tarifa del parqueadero. pTarifa > 0.
	 */
	public void cambiarTarifa( int pTarifa )
	{
		tarifa = pTarifa;

	}

	/**
	 * Indica si un puesto está ocupado.
	 * @param pPuesto El puesto que se desea saber si está ocupado. pPuesto >= 0 && pPuesto < puestos.length.
	 * @return Retorna true si el puesto especificado está ocupado, false en caso contrario.
	 */
	public boolean estaOcupado( int pPuesto )
	{
		boolean ocupado = puestos[ pPuesto ].estaOcupado( );
		return ocupado;
	}

	/**
	 * Avanza una hora en el parqueadero. Si la hora actual es igual a la hora de cierre, el parqueadero se cierra.
	 * <b>post: </b> Se avanzó una hora la hora actual del parqueadero. En caso de alcanzarse la hora de cierre se cerró el parqueadero. <br>
	 */
	public void avanzarHora( )
	{
		if( horaActual < HORA_CIERRE )
		{
			horaActual = ( horaActual + 1 );
		}
		if( horaActual == HORA_CIERRE )
		{
			abierto = false;
		}

	}
	
	   /**
     * Avanza un día en el parqueadero y se abre el parqueadero.
     * <b>pre: </b> El parqueadero se encuentra cerrado. <br>
     * <b>post: </b> Se abre el parqueadero y se aplica la tarifa nocturna a los carros. <br>
     */
    public void siguienteDia( )
    {
        horaActual = HORA_INICIAL;
        abierto = true;
        for(int i = 0; i < carros.size( ); i++)
        {
            Carro carro = carros.get( i );
            carro.avanzarDia( );
        }
        verificarInvariante( );
    }

    /**
     * Retorna un mensaje con la placa del carro que se encuentra en la posición indicada.
     * @param pPosicion Posición del carro. pPosicion >= 0 && pPosicion < puestos.length.
     * @return Mensaje con la placa. 
     * @throws PlacaException En caso de que el puesto esté vacío y no haya placa para retornar.
     */
    public String darPlacaCarro( int pPosicion ) throws PlacaException, IOException
	{
    	try{
		String respuesta = "";
		if( estaOcupado( pPosicion ) )
		{
			respuesta = "Placa: " + puestos[ pPosicion ].darCarro( ).darPlaca( );
		}

		return respuesta;
    	}
    	catch (IOException e){
    		
    		throw new PlacaException("ERROR" + e.getMessage()+ "", "");
    	}
	

	}

    /**
     * Ingresa un carro al parqueadero. <br>
     * <b>pre: </b> La lista de carros y la lista de puestos están inicializadas. <br>
     * <b>post: </b>El carro fue ingresado y agregado a la lista de carros.
     * @param pPlaca Placa del carro que ingresa. pPlaca != null && pPlaca != "".
     * @param pHora Hora de ingreso. pHora >= HORA_INICIAL && pHora < HORA_CIERRE.
     * @param pMarca Marca del carro. pMarca != null && pMarca != "".
     * @param pModelo Modelo del carro. != null && pModelo != "".
     * @return Puesto en el que fue parqueado el carro. <br>
     * @throws Exception 
     */
    public int ingresarCarro( String pPlaca, String pMarca, String pModelo ) throws Exception

	{
		int resultado = 0;
		if( !abierto )
		{
			throw new EstadoParqueaderoException( "El parqueadero se encuentra cerrado", "","");
		}
		else
		{
			if( buscarPuestoCarroPorPlaca( pPlaca.toUpperCase( ) ) != -1 )
			{
				throw new PlacaException( "ERROR"+ new Date().toString() +"Ya se encuentra un carro en el parqueadero con la placa especificada."+""+"", "" );
			}
			resultado = buscarPuestoLibre( );

			Carro carroIngresa = new Carro( pPlaca, horaActual, pMarca, pModelo );
			puestos[ resultado ].ingresarCarro( carroIngresa );
			carros.add( carroIngresa );
		}


		return resultado;
	}

    /**
     * Saca un carro del parqueadero e informa la cantidad de dinero que debe pagar. <br>
     * <b>pre: </b> La lista de puestos y la lista de carros están inicializadas. El carro con la placa especificada existe.<br>
     * <b>post: </b> El puesto fue desocupado y el carro salió del parqueadero.
     * @param pPlaca Placa del carro que va a salir. pPlaca != null && pPlaca != "".
     * @return El valor a pagar.
     * @throws EstadoParqueaderoException Si el parqueadero se encuentra cerrado.
     */
    public int sacarCarro( String pPlaca ) throws EstadoParqueaderoException
	{
		int resultado = 0;

		if( !abierto )
		{
			throw new EstadoParqueaderoException( "El parqueadero se encuentra cerrado."+""+""+""+""+"", pPlaca, pPlaca );
		}

		int numPuesto = buscarPuestoCarroPorPlaca( pPlaca.toUpperCase( ) );
		if(numPuesto == -1)
		{
			throw new Exception( "El carro con la placa especificada no se encuentra en el parqueadero." );
		}

		Carro carro = puestos[ numPuesto ].darCarro( );
		int nHoras = carro.darTiempoEnParqueadero( horaActual );
		int porPagar = nHoras * tarifa;
		valorEnCaja = valorEnCaja + porPagar;
		puestos[ numPuesto ].sacarCarro( );
		carros.remove( carro );
		resultado = porPagar;



		return resultado;
	}

	/**
	 * Indica la cantidad de puestos libres que hay.
	 * @return La cantidad de puestos vacíos en el parqueadero.
	 */
	public int calcularCantidadPuestosLibres( )
	{
		int puestosLibres = 0;
		for( Puesto puesto : puestos )
		{
			if( !puesto.estaOcupado( ) )
			{
				puestosLibres = puestosLibres + 1;
			}
		}
		return puestosLibres;
	}

	/**
     * Busca un puesto libre en el parqueadero y lo retorna.
     * @return Número del puesto libre encontrado.
     * @throws Exception Si no hay ningún puesto libre en el parqueadero.
     */
    private int buscarPuestoLibre( ) throws Exception
	{
		int puesto = -1;
		for( int i = 0; i < TAMANO && puesto < 0; i++ )
		{
			if( !puestos[ i ].estaOcupado( ) )
			{
				puesto = i;
			}
		}

		if( puesto < 0 )
		{
			throw new Exception( "No hay puestos en el parqueadero." );
		}

		return puesto;
	}

	/**
	 * Indica el número de puesto en el que se encuentra el carro con una placa dada.
	 * @param pPlaca Placa del carro que se busca. pPlaca != null && pPlaca != "".
	 * @return Número del puesto en el que se encuentra el carro. Retorna -1 en caso de que el carro no se encuentre en ningún puesto.
	 */
	public int buscarPuestoCarroPorPlaca( String pPlaca )
	{
		int puesto = -1;
		for( int i = 0; i < TAMANO && puesto < 0; i++ )
		{
			if( puestos[ i ].tieneCarroConPlaca( pPlaca ) )
			{
				puesto = i;
			}
		}
		return puesto;
	}

	/**
	 * Ordena ascendentemente los carros en el parqueadero por su marca, utilizando el algoritmo de selección. <br>
	 * <b> post: </b> Los carros en el parqueadero fueron ordenados alfabéticamente por su marca.
	 */
	public void ordenarPorMarca( )
	{
		int inicial;

		for( inicial = 0; inicial < carros.size( ); inicial++ )
		{
			int posicionMenor = inicial;
			Carro carroMenor = carros.get( inicial );

			for( int i = inicial + 1; i < carros.size( ); i++ )
			{
				Carro carroPosicion = ( Carro )carros.get( i );

				if( carroPosicion.compararPorMarca( carroMenor ) < 0 )
				{
					carroMenor = carroPosicion;
					posicionMenor = i;
				}
			}

			if( posicionMenor != inicial )
			{
				Carro temp = ( Carro )carros.get( inicial );
				carros.set( inicial, carroMenor );
				carros.set( posicionMenor, temp );
			}

		}
		verificarInvariante( );
	}

	// TODO HECHO Parte 3 Punto A: Completar el método según su documentación.        


	/**
	 * Ordena descendentemente las carros por su modelo, utilizando el algoritmo de inserción. <br>
	 * <b> post: </b> Las carros fueron ordenados según su modelo.
	 */
	public void ordenarPorModelo( )
	{
		for( int i = 1; i < carros.size( ); i++ )
		{
			Carro porInsertar = ( Carro )carros.get( i );
			boolean termino = false;
			for( int j = i; j > 0 && !termino; j-- )
			{
				Carro actual = ( Carro )carros.get( j - 1 );
				if( actual.compararPorModelo( porInsertar ) > 0 )
				{
					carros.set( j, actual );
					carros.set( j - 1, porInsertar );
				}
				else
					termino = true;
			}
		}
		verificarInvariante( );
	}
	// TODO HECHO Parte 3 Punto B: Completar el método según su documentación.


	/**
	 * Ordena las carros ascendentemente por su hora de ingreso, utilizando el algoritmo de burbuja. <br>
	 * <b> post: </b> Las carros fueron ordenados según su hora de ingreso.
	 */
	public void ordenarPorHoraIngreso( )
	{
		for( int i = carros.size( ); i > 0; i-- )
		{
			for( int j = 0; j < i - 1; j++ )
			{
				Carro p1 = ( Carro )carros.get( j );
				Carro p2 = ( Carro )carros.get( j + 1 );


				if( p1.compararPorHoraIngreso(p2) > 0 )
				{
					carros.set( j, p2 );
					carros.set( j + 1, p1 );
				}
			}
		}
		verificarInvariante( );
		// TODO HECHO Parte 3 Punto C: Completar el método según su documentación.
	}

	/**
     * Busca un carro por su placa en la lista de carros.
     * @param pPlaca Placa del carro buscado. pPlaca != null && pPlaca != "".
     * @return Carro buscado.
     * @throws PlacaException Si no se encontró ningún carro por la placa especificada.
     */
    public Carro buscarCarroPorPlaca( String pPlaca ) throws PlacaException

	{
    	try{
		Carro carro=buscarCarroPorPlaca(pPlaca);
		boolean termino=false;
		for( int i = 0; i < carros.size( ) && !termino; i++ )
		{
			Carro carroPosicion = ( Carro )carros.get( i );
			String nombreCarro = carroPosicion.darPlaca();

			// Los nombres son iguales
			if( nombreCarro.equalsIgnoreCase( pPlaca ) )
			{
				carro = carroPosicion;
				termino = true;
				
			}
			return carro;
		}
    	}
		catch(IOException e){
			throw new PlacaException(pPlaca, pMensaje);
			
		}
    	}
		
		// TODO HECHO Parte 4 Punto A: Completar el método según su documentación.
	

	/**
	 * Encuentra el primer carro que tiene la hora de ingreso especificada por parámetro, utilizando búsqueda binaria.
	 * @param pHoraIngreso Hora de ingreso por la que se realizará la búsqueda. pHoraIngreso > 0.
	 * @return El primer carro encontrado que tiene la hora de ingreso especificada. Si ningún carro satisface esta condición retorna null.
	 */
	public Carro buscarPorHoraIngreso( int pHoraIngreso )
	{
		// TODO HECHO Parte 4 Punto B: Completar el método según su documentación.
		Carro carro=buscarPorHoraIngreso(pHoraIngreso);
		boolean termino=false;
		for( int i = 0; i < carros.size( ) && !termino; i++ )
		{
			Carro carroPosicion = ( Carro )carros.get( i );
			int nombreCarro = carroPosicion.darHoraIngreso();

			// Los nombres son iguales
			if( nombreCarro == pHoraIngreso )
			{
				carro = carroPosicion;
				termino = true;
			}
		}

		return carro;
	}    
	
	/**
     * Genera un reporte con las ganancias estimadas en la hora actual si todos los carros fueran sacados. <br>
     * <b>post: </b> El reporte de las ganancias estimadas fue generado. <br>
     * @param pRuta Ruta donde se desea guardar el archivo con el reporte. pRuta != null && pRutal != "".
     * @throws PersistenciaException Se lanza una excepción si hay un error en la generación del reporte.
     */
    public void generarReporte( String pRuta ) throws PersistenciaException
    {
    	
        try
        {
            FileWriter out = new FileWriter( pRuta, true );
            PrintWriter log = new PrintWriter( out );
            log.println( "---------------------------------------" );
            log.println( "Parqueadero.java :" + new Date( ).toString( ) );
            log.println( "---------------------------------------" );
            for(int i=0;i<carros.size();i++){
            	String carross=carros.get(i).toString();
            	log.println();
            pRuta.printStackTrace( log );
            log.close( );
            out.close( );
        }
        catch( PersistenciaException e )
        {
             pRuta.printStackTrace( );
            e.printStackTrace( );
        }
    }
    	
    	
    	
    	
    }
	
	
	
	/**
     * Guarda el estado del sistema en un archivo serializado. <br>
     * <b>post: </b> Se guardó la lista de puestos, la lista de carros, la hora actual, la tarifa y el valor en caja en el archivo dado. <br>
     * @param pRuta Ruta del archivo donde se guarda el estado del sistema. pRuta != null && pRuta != "".
     * @throws PersistenciaException Se lanza una excepción si hay algún error guardando los datos del archivo.
     */
    public void guardar( String pRuta ) throws PersistenciaException
    {
    	archivoP=pRuta;
    	File archivo=new File(archivoP);
    	
    	
    	try
        {
            ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream(archivo));
           ois.writeObject(carros);
           ois.writeObject(puestos);
           ois.writeObject(horaActual);
           ois.writeObject(tarifa);
           ois.writeObject(valorEnCaja);
            ois.close();
        }
        catch( Exception e )
        {
            PersistenciaException ee=new PersistenciaException("hay error guardando los datos del parqueadero");
           ee.escribirLog();
           throw ee;
        }
    	}
    	
    	
    	
    
        
    /**
     * Carga el estado del sistema de un archivo serializado. <br>
     * <b>post: </b> Se inicializó la lista de puestos y de carros a partir del archivo dado. Se inicializaron igualmente la hora actual, la tarifa y el valor en caja a partir del archivo.<br>
     * @param pArchivo Archivo con la información del sistema. pArchivo != null.
     * @throws PersistenciaException Se lanza una excepción si hay algún error cargando los datos del archivo.
     */
    public void cargar( String pArchivo ) throws PersistenciaException
    {
    	if(!pArchivo.endsWith("data") || !pArchivo.endsWith("txt"));{
    		PersistenciaException v = new PersistenciaException("hay errror");
    		v.escribirLog();
    		throw v;
    	}
    	File acc=new File(pArchivo);
    	if(acc.exists()){
    		try{
    			ObjectInputStream oss= new ObjectInputStream(new FileInputStream(acc));
    			puestos=(Puesto[])oss.readObject();
    			carros=(ArrayList<Carro>)oss.readObject();
    			horaActual=(Integer) oss.readObject();
    			tarifa=(Integer)oss.readObject();
    			valorEnCaja=(Double)oss.readObject();
    			oss.close();
    		}
    		catch(Exception e){
    			PersistenciaException k= new PersistenciaException("error");
    			k.escribirLog();
    			throw k;
    			
    		}
    		
    	}
    	
    	
    }

	// -----------------------------------------------------------------
	// Puntos de Extensión
	// -----------------------------------------------------------------

	/**
	 * Método de extensión 1.
	 * @return Respuesta 1.
	 */
	public String metodo1( )
	{
		return "respuesta 1";
	}

	/**
	 * Método de extensión 2.
	 * @return Respuesta 2.
	 */
	public String metodo2( )
	{
		return "respuesta 2";
	}
	private boolean horaEsValida( )
	{
		return horaActual>=6 && horaActual<=21;
	}
	private boolean valorActualEsValida( )
	{
		return valorEnCaja>=0;
	}
	private boolean tarifaEsValida( )
	{
		return tarifa>=0;
	}

	// -----------------------------------------------------------------
	// Invariante
	// -----------------------------------------------------------------

	// TODO HECHO Parte 1 Punto F: Documente e implemente la invariante de la clase.
	// Si lo necesita, puede crear método privados adicionales.
	private void verificarInvariante()
	{

		assert horaEsValida()  : "Hora incorrecta";
		assert valorActualEsValida()  : "Valor en caja es inferior a 0";
		assert tarifaEsValida() : "Tarifa menor a 0";







	}
}