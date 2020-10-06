/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad	de	los	Andes	(Bogot�	- Colombia)
 * Departamento	de	Ingenier�a	de	Sistemas	y	Computaci�n
 * Licenciado	bajo	el	esquema	Academic Free License versi�n 2.1
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
 * Representa una habitaci�n dentro del hotel.
 */
public class Habitacion
{

	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------

	/**
	 * Define las posibles categor�as de la habitaci�n.
	 */
	// TODO HECHO Parte 3 Punto A: Declarar la enumeraci�n Categoria seg�n el modelo del mundo.

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
	 * N�mero de la habitaci�n.
	 */
	// TODO HECHO Parte 3 Punto B: Declarar el atributo numero seg�n el modelo del mundo.
	private int numero;
	/**
	 * Categor�a de la habitaci�n
	 */
	// TODO HECHO Parte 3 Punto C: Declarar el atributo categoria seg�n el modelo del mundo.
	private Categoria categoria;
	/**
	 * Servicios consumidos por la habitaci�n.
	 */
	// TODO HECHO Parte 3 Punto D: Declarar el atributo servicios seg�n el modelo del mundo.
	private ArrayList<Servicio> servicios;
	/**
	 * Hu�sped hospedado en la habitaci�n.
	 */
	// TODO HECHO Parte 3 Punto E: Declarar el atributo huesped seg�n el modelo del mundo.
	private ArrayList<Huesped> huespedes;
	
	/**
	 * Huesped responsable de la habitacion
	 */
	private Huesped responsable;
	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Crea una habitaci�n usando la informaci�n recibida por par�metro. <br>
	 * <b>post: </b> Se inicializaron los atributos pNumero y pCategoria con los valores recibidos por par�metro.<br>
	 * Se inicializ� la lista de servicios.<br>
	 * Se inicializ� el atributo huesped en un arreglo.
	 * @param pNumero N�mero de la habitaci�n. 0 < pNumero < 21
	 * @param pCategoria pCategoria == { Categoria.EJECUTIVA, Categoria.DOBLE, Categoria.SUITE, Categoria.PRESIDENCIAL}

	 */
	public Habitacion( int pNumero, Categoria pCategoria )
	{
		numero=pNumero;
		categoria=pCategoria;
		huespedes=new ArrayList<Huesped>();
		servicios=new ArrayList<Servicio>();
		responsable=null;

		// TODO HECHO Parte 3 Punto F: Completar el m�todo constructor de la clase.
		// Inicializar los nuevos atributos con la informaci�n recibida por par�metro.
	}

	// -----------------------------------------------------------------
	// M�todos
	// -----------------------------------------------------------------

	/**
	 * Retorna el n�mero de la habitaci�n.<br>
	 * @return N�mero de la habitaci�n.
	 */
	public int darNumero( )
	{
		return numero;
		// TODO HECHO Parte 3 Punto G: Completar el m�todo seg�n la documentaci�n dada.
	}

	/**
	 * Retorna la categor�a de la habitaci�n.<br>
	 * @return Categor�a de la habitaci�n.
	 */
	public Categoria darCategoria( )
	{
		return categoria;
		// TODO HECHO Punto H: Completar el m�todo seg�n la documentaci�n dada.
	}

	/**
	 * Retorna la lista de servicios de la habitaci�n.<br>
	 * @return Servicios de la habitaci�n.
	 */
	public ArrayList<Servicio> darServicios( )
	{
		return servicios;

		// TODO HECHO Parte 3 Punto I: Completar el m�todo seg�n la documentaci�n dada.
	}

	/**
	 * Retorna el responsable de la habitaci�n.<br>
	 * @return El Responsable que ocupa la habitaci�n, null si est� desocupada.
	 */
	public Huesped darResponsable( )
	{

		return responsable;
		// TODO HECHO Parte 3 Punto J: Completar el m�todo seg�n la documentaci�n dada.
	}
	
     /**
      * Retorna los huespedes de una habitacion<br>
     * @return Lista de Huespedes
     */
    public ArrayList<Huesped> darHuesped(){
    	 
    		 return huespedes;
    	 }
     
	/**
	 * Retorna el consumo total de la habitaci�n.<br>
	 * @return Consumo total de la habitaci�n.
	 */
	public double darConsumoTotal( )
	{
		double consumo=0;
		for(Servicio servicio:servicios){
			consumo+=servicio.darCosto();


		}
		return consumo;

	}

	// TODO HECHO Parte 3 Punto K: Completar el m�todo seg�n la documentaci�n dada.
	// Debe usar un foreach como parte de la soluci�n


	/**
	 * Retorna la deuda total de la habitaci�n.<br>
	 * @return Deuda total de la habitaci�n.<br>
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
		// TODO HECHO Parte 3 Punto L: Completar el m�todo seg�n la documentaci�n dada.
		// Debe usar un foreach como parte de la soluci�n
	}

	/**
	 * Indica si la habitaci�n se encuentra ocupada.<br>
	 * @return True en caso de que se encuentre ocupada, false de lo contrario.
	 */
	public boolean estaOcupada( )
	{
		boolean ocupado = huespedes !=null;
		return ocupado;



	}
	// TODO HECHO Parte 3 Punto M: Completar el m�todo seg�n la documentaci�n dada.


	/**
     * Permite registrar un hu�sped en la habitaci�n.<br>
     * <b>pre: </b> La habitaci�n ya posee un responsable registrado.<br>
     * <b>post: </b> Se registr� un nuevo hu�sped en la habitaci�n.<br>
     * @param pNombre Nombre del responsable. pNombre != null && pNombre != "".
     * @param pCedula C�dula del responsable. pCedula != null && pCedula != "".
     * @param pEdad Edad del responsable. pEdad > 0.
     * @throws Exception Si se ha alcanzado el l�mite de hu�spedes en la habitaci�n.
     */
    //TODO Parte 3 Punto 11: Modificar el m�todo registrarHuesped para que cumpla con el contrato.
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
		



		// TODO HECHO Parte 3 Punto O: Completar el m�todo seg�n la documentaci�n dada.
	

	/**
	 * Permite dar salida al hu�sped si la habitaci�n est� ocupada y no tiene ning�n servicio por pagar.<br>
	 * <b>post: </b> Se dio salida al hu�sped de la habitaci�n y se eliminaron todos los servicios de la lista.<br>
	 * @return True si se dio salida al hu�sped, false de lo contrario.
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
		// TODO HECHO Parte 3 Punto P: Completar el m�todo seg�n la documentaci�n dada.
	}

	/**
	 * Permite pagar el servicio identificado por par�metro.<br>
	 * <b>pre: </b> Existe un servicio con el identificador pIdentificador.<br>
	 * <b>post: </b> Se pag� el servicio identificado con el par�metro recibido.
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

		// TODO HECHO Parte 3 Punto Q: Completar el m�todo seg�n la documentaci�n dada.
	}

	/**
	 * Permite adquirir un nuevo servicio en la habitaci�n.<br>
	 * El identificador de los servicios es secuencial iniciando en '1' si no hay servicios adquiridos, y debe aumentar en uno por cada nuevo servicio. <br>
	 * <b>pre: </b> La habitaci�n se encuentra ocupada.<br>
	 * <b>post: </b> Se cre� el servicio y se agreg� a la lista de servicios de la habitaci�n.
	 * @param pTipo Tipo del servicio. pTipo == {Tipo.MINI_BAR , Tipo.INTERNET, Tipo.SPA, Tipo.PELICULAS}.
	 * @param pCosto Costo del servicio. pCosto > 0.
	 */
	public void adquirirServicio( Tipo pTipo, double pCosto )
	{
		int v =servicios.size()+1;
		Servicio servicio=new Servicio(v, pTipo, pCosto);
		servicios.add(servicio);

		// TODO HECHO Parte 3 Punto R: Completar el m�todo seg�n la documentaci�n dada.
	}

	/**
	 * Retorna la cantidad de veces que fue solicitado un servicio del tipo ingresado por par�metro.<br>
	 * @param pTipo Tipo del servicio que se quiere consultar. pTipo == {Tipo.MINI_BAR , Tipo.INTERNET, Tipo.SPA, Tipo.PELICULAS}.
	 * @return Cantidad de veces que el servicio identificado con el par�metro fue solicitado.
	 */
	public int darVecesServicioSolicitado( Tipo pTipo )
	{
		int solicitado=0;
		for(Servicio servicio:servicios){
			if(servicio.darTipo()==pTipo)
				solicitado++;
		}
		return solicitado;
		// TODO HECHO Parte 3 Punto S: Completar el m�todo seg�n la documentaci�n dada.
	}

	/**
	 * Retorna el tipo del servicio m�s solicitado en la habitaci�n.<br>
	 * Si hay dos tipos de servicio solicitados el mismo n�mero de veces, puede retornar cualquiera de los dos.
	 * @return Tipo del servicio m�s solicitado, null en caso de que la habitaci�n no tenga servicios.
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
		// TODO HECHO Parte 3 Punto T: Completar el m�todo seg�n la documentaci�n dada.
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
     * Permite registrar la habitaci�n con su responsable.<br>
     * <b>post: </b> Se registr� un nuevo responsable en la habitaci�n.<br>
     * @param pNombre Nombre del responsable. pNombre != null && pNombre != "".
     * @param pCedula C�dula del responsable. pCedula != null && pCedula != "".
     * @param pEdad Edad del responsable. pEdad >= 18.
     * @throws Exception Si la habitaci�n ya tiene un responsable asignado.
     */   
    //TODO HECHO Parte 3 Punto 10: Modificar el m�todo registrarResponsable para que cumpla con el contrato.
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
