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


import java.util.ArrayList;

import uniandes.cupi2.hotel.mundo.Servicio.Tipo;

/**
 * Representa una habitación dentro del hotel.
 */
public class Habitacion
{

	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------

	/**
	 * Define las posibles categorías de la habitación.
	 */
	// TODO HECHO Parte 3 Punto A: Declarar la enumeración Categoria según el modelo del mundo.

	public enum Categoria{
		EJECUTIVA,
		DOBLE,
		SUITE,
		PRESIDENCIAL,

	}
	/**
	 * Define la cantidad de huespedes puede tener la categoria ejecutiva
	 */
	public static int LIMITE_EJECUTIVA=1;
	/**
	 * Define la cantidad de huespedes puede tener la categoria doble
	 */
	public static int LIMITE_DOBLE=2;
	/**
	 * Define la cantidad de huespedes puede tener la categoria suite
	 */
	public static int LIMITE_SUITE=5;
	/**
	 * Define la cantidad de huespedes puede tener la categoria presidencial
	 */
	public static int LIMITE_PRESIDENCIAL=10;
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------
	/**
	 * Número de la habitación.
	 */
	// TODO HECHO Parte 3 Punto B: Declarar el atributo numero según el modelo del mundo.
	private int numero;
	/**
	 * Categoría de la habitación
	 */
	// TODO HECHO Parte 3 Punto C: Declarar el atributo categoria según el modelo del mundo.
	private Categoria categoria;
	/**
	 * Servicios consumidos por la habitación.
	 */
	// TODO HECHO Parte 3 Punto D: Declarar el atributo servicios según el modelo del mundo.
	private ArrayList<Servicio> servicios;
	/**
	 * Huésped hospedado en la habitación.
	 */
	// TODO HECHO Parte 3 Punto E: Declarar el atributo huesped según el modelo del mundo.
	private ArrayList<Huesped> huespedes;
	
	/**
	 * Huesped responsable de la habitacion
	 */
	private Huesped responsable;
	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Crea una habitación usando la información recibida por parámetro. <br>
	 * <b>post: </b> Se inicializaron los atributos pNumero y pCategoria con los valores recibidos por parámetro.<br>
	 * Se inicializó la lista de servicios.<br>
	 * Se inicializó el atributo huesped en un arreglo.
	 * @param pNumero Número de la habitación. 0 < pNumero < 21
	 * @param pCategoria pCategoria == { Categoria.EJECUTIVA, Categoria.DOBLE, Categoria.SUITE, Categoria.PRESIDENCIAL}

	 */
	public Habitacion( int pNumero, Categoria pCategoria )
	{
		numero=pNumero;
		categoria=pCategoria;
		huespedes=new ArrayList<Huesped>();
		servicios=new ArrayList<Servicio>();
		responsable=null;

		// TODO HECHO Parte 3 Punto F: Completar el método constructor de la clase.
		// Inicializar los nuevos atributos con la información recibida por parámetro.
	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Retorna el número de la habitación.<br>
	 * @return Número de la habitación.
	 */
	public int darNumero( )
	{
		return numero;
		// TODO HECHO Parte 3 Punto G: Completar el método según la documentación dada.
	}

	/**
	 * Retorna la categoría de la habitación.<br>
	 * @return Categoría de la habitación.
	 */
	public Categoria darCategoria( )
	{
		return categoria;
		// TODO HECHO Punto H: Completar el método según la documentación dada.
	}

	/**
	 * Retorna la lista de servicios de la habitación.<br>
	 * @return Servicios de la habitación.
	 */
	public ArrayList<Servicio> darServicios( )
	{
		return servicios;

		// TODO HECHO Parte 3 Punto I: Completar el método según la documentación dada.
	}

	/**
	 * Retorna el responsable de la habitación.<br>
	 * @return El Responsable que ocupa la habitación, null si está desocupada.
	 */
	public Huesped darResponsable( )
	{

		return responsable;
		// TODO HECHO Parte 3 Punto J: Completar el método según la documentación dada.
	}
	
     /**
      * Retorna los huespedes de una habitacion<br>
     * @return Lista de Huespedes
     */
    public ArrayList<Huesped> darHuesped(){
    	 
    		 return huespedes;
    	 }
     
	/**
	 * Retorna el consumo total de la habitación.<br>
	 * @return Consumo total de la habitación.
	 */
	public double darConsumoTotal( )
	{
		double consumo=0;
		for(Servicio servicio:servicios){
			consumo+=servicio.darCosto();


		}
		return consumo;

	}

	// TODO HECHO Parte 3 Punto K: Completar el método según la documentación dada.
	// Debe usar un foreach como parte de la solución


	/**
	 * Retorna la deuda total de la habitación.<br>
	 * @return Deuda total de la habitación.<br>
	 */
	public double darDeudaTotal( )
	{
		double deuda=0;
		for(Servicio servicio:servicios){
			if(servicio.estaPagado()==false){
				deuda+=servicio.darCosto();
			}

		}
		return deuda;
		// TODO HECHO Parte 3 Punto L: Completar el método según la documentación dada.
		// Debe usar un foreach como parte de la solución
	}

	/**
	 * Indica si la habitación se encuentra ocupada.<br>
	 * @return True en caso de que se encuentre ocupada, false de lo contrario.
	 */
	public boolean estaOcupada( )
	{
		boolean ocupado = huespedes !=null;
		return ocupado;



	}
	// TODO HECHO Parte 3 Punto M: Completar el método según la documentación dada.


	/**
     * Permite registrar un huésped en la habitación.<br>
     * <b>pre: </b> La habitación ya posee un responsable registrado.<br>
     * <b>post: </b> Se registró un nuevo huésped en la habitación.<br>
     * @param pNombre Nombre del responsable. pNombre != null && pNombre != "".
     * @param pCedula Cédula del responsable. pCedula != null && pCedula != "".
     * @param pEdad Edad del responsable. pEdad > 0.
     * @throws Exception Si se ha alcanzado el límite de huéspedes en la habitación.
     */
    //TODO Parte 3 Punto 11: Modificar el método registrarHuesped para que cumpla con el contrato.
	public void registrarHuesped( String pNombre, String pCedula, int pEdad ) throws Exception
	{
		boolean registrado=false;
				if(estaOcupada()==false){
			huespedes=huespedes.add(pEdad, pCedula, pNombre);
			registrado=true;}
			else{
				throw new Exception("La habitacion ya tiene un responsable asignado");
			}
		}		
		



		// TODO HECHO Parte 3 Punto O: Completar el método según la documentación dada.
	

	/**
	 * Permite dar salida al huésped si la habitación está ocupada y no tiene ningún servicio por pagar.<br>
	 * <b>post: </b> Se dio salida al huésped de la habitación y se eliminaron todos los servicios de la lista.<br>
	 * @return True si se dio salida al huésped, false de lo contrario.
	 */

	public boolean darSalidaHuesped( )
	{
		boolean salio=false;
		if(estaOcupada()==true){
			if(darDeudaTotal()==0){
				huespedes=null;
				salio=true;


			}
			return salio;
		}


		return salio;
		// TODO HECHO Parte 3 Punto P: Completar el método según la documentación dada.
	}

	/**
	 * Permite pagar el servicio identificado por parámetro.<br>
	 * <b>pre: </b> Existe un servicio con el identificador pIdentificador.<br>
	 * <b>post: </b> Se pagó el servicio identificado con el parámetro recibido.
	 * @param pIdentificador Identificador del servicio a pagar. pIdentificador > 0.
	 */
	public void pagarServicio( int pIdentificador )
	{
		boolean termino=false;
		for(int i=0; i<servicios.size()&& !termino;i++){
			Servicio servicio=servicios.get(i);
			if(servicio.darIdentificador()==pIdentificador){
				servicio.pagarServicio();
				termino=true;
			}
		}

		// TODO HECHO Parte 3 Punto Q: Completar el método según la documentación dada.
	}

	/**
	 * Permite adquirir un nuevo servicio en la habitación.<br>
	 * El identificador de los servicios es secuencial iniciando en '1' si no hay servicios adquiridos, y debe aumentar en uno por cada nuevo servicio. <br>
	 * <b>pre: </b> La habitación se encuentra ocupada.<br>
	 * <b>post: </b> Se creó el servicio y se agregó a la lista de servicios de la habitación.
	 * @param pTipo Tipo del servicio. pTipo == {Tipo.MINI_BAR , Tipo.INTERNET, Tipo.SPA, Tipo.PELICULAS}.
	 * @param pCosto Costo del servicio. pCosto > 0.
	 */
	public void adquirirServicio( Tipo pTipo, double pCosto )
	{
		int v =servicios.size()+1;
		Servicio servicio=new Servicio(v, pTipo, pCosto);
		servicios.add(servicio);

		// TODO HECHO Parte 3 Punto R: Completar el método según la documentación dada.
	}

	/**
	 * Retorna la cantidad de veces que fue solicitado un servicio del tipo ingresado por parámetro.<br>
	 * @param pTipo Tipo del servicio que se quiere consultar. pTipo == {Tipo.MINI_BAR , Tipo.INTERNET, Tipo.SPA, Tipo.PELICULAS}.
	 * @return Cantidad de veces que el servicio identificado con el parámetro fue solicitado.
	 */
	public int darVecesServicioSolicitado( Tipo pTipo )
	{
		int solicitado=0;
		for(Servicio servicio:servicios){
			if(servicio.darTipo()==pTipo)
				solicitado++;
		}
		return solicitado;
		// TODO HECHO Parte 3 Punto S: Completar el método según la documentación dada.
	}

	/**
	 * Retorna el tipo del servicio más solicitado en la habitación.<br>
	 * Si hay dos tipos de servicio solicitados el mismo número de veces, puede retornar cualquiera de los dos.
	 * @return Tipo del servicio más solicitado, null en caso de que la habitación no tenga servicios.
	 */
	public Tipo darServicioMasSolicitado( )
	{

		int mini=darVecesServicioSolicitado(Tipo.MINI_BAR);
		int inter=darVecesServicioSolicitado(Tipo.INTERNET);
		int spa=darVecesServicioSolicitado(Tipo.SPA);
		int peli=darVecesServicioSolicitado(Tipo.PELICULAS);
		if(mini>inter && mini>spa && mini>peli){
			return Tipo.MINI_BAR;
		}
		else if(inter>mini&&inter>peli&&inter>spa){
			return Tipo.INTERNET;
		}
		else if(peli>inter&&peli>spa&peli>mini){
			return Tipo.PELICULAS;
		}
		else if(spa>peli&&spa>inter&&spa>mini){
			return Tipo.SPA;
		}
		else {
			return null;
		}
		// TODO HECHO Parte 3 Punto T: Completar el método según la documentación dada.
	}
	 /**
	  * Retorna si la habitacion esta llena o no.<br>
	 * @return true si las habitaciones con su respectiva categoria estan llenas, de lo contrario retorna false.
	 */
	//TODO HECHO Parte 3 Punto 8 Crear contrato
    public boolean seAlcanzoLimite( )
    {
        boolean llena = false;
        if( categoria == Categoria.EJECUTIVA && huespedes.size( ) == LIMITE_EJECUTIVA )
        {
            llena = true;
        }
        else if( categoria == Categoria.DOBLE && huespedes.size( ) == LIMITE_DOBLE )
        {
            llena = true;
        }
        else if( categoria == Categoria.SUITE && huespedes.size( ) == LIMITE_SUITE )
        {
            llena = true;
        }
        else if( categoria == Categoria.PRESIDENCIAL && huespedes.size( ) == LIMITE_PRESIDENCIAL )
        {
            llena = true;
        }
        return llena;
    }
    /**
     * Buscar un huesped determinado usando la cedula
     * <b>pre: </b>  la lista de huespedes esta inicializada<br>
     * <b>post: </b> se obtiene el huesped a solicitar<br>
     * @param pCedula La cedula del huesped a buscar<br>
     * @return el la cedula del huesped, de lo contrario retorna null.
     */
    //TODO HECHO Parte 3 Punto 9 Crear contrato
    public Huesped buscarHuesped( String pCedula )
    {
        Huesped buscado = null;
        for( int i = 0; i < huespedes.size( ) && buscado == null; i++ )
        {
            Huesped huesped = huespedes.get( i );
            if( huesped.darCedula( ).equals( pCedula ) )
            {
                buscado = huesped;
            }
        }
        return buscado;
    }
    /**
     * Permite registrar la habitación con su responsable.<br>
     * <b>post: </b> Se registró un nuevo responsable en la habitación.<br>
     * @param pNombre Nombre del responsable. pNombre != null && pNombre != "".
     * @param pCedula Cédula del responsable. pCedula != null && pCedula != "".
     * @param pEdad Edad del responsable. pEdad >= 18.
     * @throws Exception Si la habitación ya tiene un responsable asignado.
     */   
    //TODO HECHO Parte 3 Punto 10: Modificar el método registrarResponsable para que cumpla con el contrato.
    public void registrarResponsable( String pNombre, String pCedula, int pEdad ) throws Exception
	{
    	if(estaOcupada()==false){
    		huespedes.add(responsable);
    	}
    	else{
    		throw new Exception("La habitacion ya tiene un responsable asignado");
    	}
    	
	}
}
