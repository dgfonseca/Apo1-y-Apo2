/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad	de	los	Andes	(Bogotá	- Colombia)
 * Departamento	de	Ingeniería	de	Sistemas	y	Computación
 * Licenciado	bajo	el	esquema	Academic Free License versión 2.1
 * 		
 * Proyecto	Cupi2	(http://cupi2.uniandes.edu.co)
 * Ejercicio: n3_hotel
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.hotel.mundo;

import uniandes.cupi2.hotel.mundo.Habitacion.Categoria;
import uniandes.cupi2.hotel.mundo.Servicio.Tipo;

/**
 * Representa el hotel.
 */
public class Hotel
{

	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------

	/**
	 * Representa la cantidad de habitaciones del hotel.
	 */
	// TODO HECHO Parte 4 Punto A: Declarar la constante CANTIDAD_HABITACIONES según el modelo del mundo.
	public final static int CANTIDAD_HABITACIONES=20;
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------
	/**
	 * 
	 */
	public Habitacion [] habitaciones;
	/**
	 * Representa el conjunto de habitaciones del hotel.
	 */
	// TODO HECHO Parte 4 Punto B: Declarar el atributo habitaciones según el modelo del mundo.

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Construye un nuevo hotel.<br>
	 * Las habitaciones se deberán inicializar con números desde el 1 al 20.<br>
	 * <b>post: </b> Se inicializaron todas las habitaciones con los valores definidos en la documentación.<br>
	 */
	public Hotel( )
	{
		habitaciones=new Habitacion[CANTIDAD_HABITACIONES];
		// TODO HECHO Parte 4 Punto C: Completar el método constructor de la clase.
		// Inicializar los nuevos atributos con la información recibida por parámetro.
		// Debe usar un ciclo para inicializar las habitaciones
	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Retorna la habitación identificada con el número ingresado por parámetro.<br>
	 * <b> pre: </b> El arreglo de habitaciones se encuentra inicializado.<br>
	 * @param pNumeroHabitacion Número de la habitación a consultar.
	 * @return Habitación identificada con el número ingresado, null en caso de no encontrarla.
	 */
	public Habitacion darHabitacion( int pNumeroHabitacion )
	{
		return habitaciones[pNumeroHabitacion];

		// TODO HECHO Parte 4 Punto D: Completar el método según la documentación dada.
	}

	/**
	 * Retorna el consumo de la habitación identificada con el número ingresado por parámetro.<br>
	 * @param pNumeroHabitacion Número de la habitación a consultar. 0 < pNumeroHabitacion <= CANTIDAD_HABITACIONES
	 * @return Consumo de la habitación identificada con el número ingresado por parámetro.
	 */
	public double darConsumo( int pNumeroHabitacion )
	{
		double consumo=0;

		if(habitaciones[pNumeroHabitacion-1].estaOcupada()==true){
			consumo=habitaciones[pNumeroHabitacion-1].darConsumoTotal();
			return consumo;
		}
		else{
			return 0;
		}

	}



	// TODO HECHO Parte 4 Punto E: Completar el método según la documentación dada.


	/**
	 * Retorna la deuda de la habitación identificada con el número ingresado por parámetro.<br>
	 * @param pNumeroHabitacion Número de la habitación a consultar. 0 < pNumeroHabitacion <= CANTIDAD_HABITACIONES
	 * @return Deuda de la habitación identificada con el número ingresado por parámetro.
	 */
	public double darDeuda( int pNumeroHabitacion )
	{
		double deuda=0;
		if(habitaciones[pNumeroHabitacion-1].estaOcupada()==true){
			deuda=habitaciones[pNumeroHabitacion-1].darDeudaTotal();
			return deuda;
		}
		else{
			return 0;
		}

		// TODO HECHO Parte 4 Punto F: Completar el método según la documentación dada.
	}

	/**
	 * Retorna la habitación con mayor consumo dentro del hotel.<br>
	 * En caso de que exista más de una habitación con el mayor consumo, se debe retornar la última habitación encontrada.<br>
	 * En caso de que el mayor consumo encontrado sea 0, se debe retornar null.
	 * @return Habitación con mayor consumo dentro del hotel, null si el mayor consumo encontrado es cero.
	 */
	public Habitacion darHabitacionMayorConsumo( )
	{
		double n=0;
		Habitacion habitacions=null;

		for(int i=0; i<habitaciones.length;i++){
			if(habitaciones[i].darConsumoTotal()>n){
				n=habitaciones[i].darConsumoTotal();
				for(int k=0;k<habitaciones.length;k++){
					habitacions=habitaciones[i];
				}

			}

		}
		return habitacions;
		// TODO HECHO Parte 4 Punto G: Completar el método según la documentación dada.
	}

	/**
	 * Retorna la habitación con mayor deuda dentro del hotel.<br>
	 * En caso de que exista más de una habitación con la mayor deuda, se debe retornar la última habitación encontrado.<br>
	 * En caso de que la mayor deuda encontrada sea 0, se debe retornar null.
	 * @return Habitación con mayor deuda dentro del hotel, null si la mayor deuda encontrada es cero.
	 */
	public Habitacion darHabitacionMayorDeuda( )
	{
		{
			double n=0;
			Habitacion habitacions=null;

			for(int i=0; i<habitaciones.length;i++){
				if(habitaciones[i].darDeudaTotal()>n){
					n=habitaciones[i].darDeudaTotal();
					for(int k=i+1;k<habitaciones.length;k++){
						habitacions=habitaciones[i];
					}

				}

			}
			return habitacions;
		}
		// TODO HECHO Parte 4 Punto H: Completar el método según la documentación dada.
	}

	/**
	 * Retorna la cantidad de habitaciones disponibles en el hotel.<br>
	 * @return Cantidad de habitaciones disponibles en el hotel.
	 */
	public int darCantidadHabitacionesDisponibles( )
	{
		int cantidad=0;
		for(int i=0;i<habitaciones.length;i++){
			if(habitaciones[i].estaOcupada()==false){
				cantidad++;
			}
		}
		return cantidad;
		// TODO HECHO Parte 4 Punto I: Completar el método según la documentación dada.
	}

	/**
	 * Retorna la cantidad de habitaciones ocupadas en el hotel.<br>
	 * @return Cantidad de habitaciones ocupadas en el hotel.
	 */
	public int darCantidadHabitacionesOcupadas( )
	{
		int cantidad=0;
		for(int i=0;i<habitaciones.length;i++){
			if(habitaciones[i].estaOcupada()==true){
				cantidad ++;
			}
		}return cantidad;
		// TODO HECHO Parte 4 Punto J: Completar el método según la documentación dada.
	}

	/**
	 * Retorna la cantidad de servicios adquiridos, de un tipo especificado por parámetro en una habitación específica.<br>
	 * @param pNumeroHabitacion Número de la habitación. 0 < pNumeroHabitacion <= CANTIDAD_HABITACIONES.
	 * @param pTipo Tipo del servicio a consultar. pTipo == {Tipo.MINI_BAR , Tipo.INTERNET, Tipo.SPA, Tipo.PELICULAS}.
	 * @return Retorna la cantidad de servicios del tipo especificado adquiridos en la habitación dada.
	 */
	public int darCantidadServiciosHabitacion( int pNumeroHabitacion, Tipo pTipo )
	{
		int cantidad=0;
		boolean encontro=false;
		for(int i=0;i<habitaciones.length && !encontro;i++){
			if(habitaciones[i].darNumero()==pNumeroHabitacion && habitaciones[i].darServicios().equals(pTipo))
			{
				cantidad= habitaciones[i].darVecesServicioSolicitado(pTipo);
			encontro=true;	
			}
		}
		return cantidad;
		// TODO Parte 4 Punto K: Completar el método según la documentación dada.
	}

	/**
	 * Retorna el servicio más solicitado en la habitación identificada por el número ingresado por parámetro.<br>
	 * @param pNumeroHabitacion Número de la habitación sobre la que se quiere hacer la consulta. 0 < pNumeroHabitacion <= CANTIDAD_HABITACIONES.
	 * @return Tipo del servicio más solicitado en la habitación, null en caso de que la habitación no tenga servicios.
	 */
	public Tipo darServicioMasSolicitado( int pNumeroHabitacion )
	{
		// TODO Parte 4 Punto L: Completar el método según la documentación dada.
	}

	/**
	 * Busca la primera habitación que contenga el huésped identificado con la cédula ingresada por parámetro.<br>
	 * @param pCedulaHuesped Cédula del huésped. pCedulaHuesped != null.
	 * @return Habitación del huésped identificado con la cédula ingresada, null en caso de no encontrarla.
	 */
	public Habitacion buscarHabitacionPorHuesped( String pCedulaHuesped )
	{
		
		// TODO Parte 4 Punto M: Completar el método según la documentación dada.
	}

	/**
	 * Registra un nuevo huésped en la habitación ingresada por parámetro.<br>
	 * <b>post: </b> Se registró el huésped en la habitación identificada con el número ingresado por parámetro.
	 * @param pNumeroHabitacion Número de la habitación. 0 < pNumeroHabitacion <= CANTIDAD_HABITACIONES.
	 * @param pNombre Nombre del huésped. pNombre != null.
	 * @param pCedula Cédula del huésped. pCedula != null.
	 * @return True si fue posible registrar el huésped, false de lo contrario.
	 */
	public boolean registrarHuesped( int pNumeroHabitacion, String pNombre, String pCedula )
	{
		Huesped con=registrarHuesped(pNumeroHabitacion, pNombre, pCedula);
		boolean exito=false;
		if(con==null){
			
	
		}
		// TODO Parte 4 Punto N: Completar el método según la documentación dada.
	}

	/**
	 * Da salida al huésped alojado en la habitación identificada con el número ingresado por parámetro.<br>
	 * <b>post: </b> Se dio salida al huésped de la habitación identificada con el número ingresado por parámetro.
	 * @param pNumeroHabitacion Número de la habitación. 0 < pNumeroHabitacion <= CANTIDAD_HABITACIONES.
	 * @return True si fue posible dar salida al huésped, false de lo contrario.
	 */
	public boolean darSalidaHuesped( int pNumeroHabitacion )
	{
		// TODO Parte 4 Punto O: Completar el método según la documentación dada.
	}

	/**
	 * Adquiere un nuevo servicio en la habitación identificada por el número ingresado por parámetro.<br>
	 * <b>pre: </b> La habitación se encuentra ocupada.<br>
	 * <b>post: </b> Se adquirió un nuevo servicio para en la habitación ingresada por parámetro.
	 * @param pNumeroHabitacion Número de la habitación. 0 < pNumeroHabitacion <= CANTIDAD_HABITACIONES.
	 * @param pTipo Tipo del servicio a adquirir. pTipo == {Tipo.MINI_BAR , Tipo.INTERNET, Tipo.SPA, Tipo.PELICULAS}.
	 * @param pCosto Costo del servicio a adquirir. pCosto > 0.
	 */
	public void adquirirServicio( int pNumeroHabitacion, Tipo pTipo, double pCosto )
	{
		// TODO Parte 4 Punto P: Completar el método según la documentación dada.
	}

	/**
	 * Paga un servicio, dentro de la habitación ingresada por parámetro.<br>
	 * <b>pre: </b> Existe un servicio con el identificador dado.<br>
	 * <b>pos: </b> Se pagó el servicio en la habitación ingresada.<br>
	 * @param pNumeroHabitacion Número de la habitación. 0 < pNumeroHabitacion <= CANTIDAD_HABITACIONES.
	 * @param pIdentificador Identificador del servicio. pIdentificador > 0.
	 */
	public void pagarServicio( int pNumeroHabitacion, int pIdentificador )
	{
		// TODO Parte 4 Punto Q: Completar el método según la documentación dada.
	}

	// -----------------------------------------------------------------
	// Puntos de Extensión
	// -----------------------------------------------------------------

	/**
	 * Extensión 1.
	 * 
	 * @return respuesta1.
	 */
	public String metodo1( )
	{
		return "Respuesta 1";
	}

	/**
	 * Extensión 2.
	 * 
	 * @return respuesta2.
	 */
	public String metodo2( )
	{
		return "Respuesta 2";
	}
}
