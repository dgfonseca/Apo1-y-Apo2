/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_lineasTelefonicas
 * Autor: Equipo Cupi2
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.lineasTelefonicas.mundo;

/**
 * Clase que representa la empresa.
 */
public class Empresa
{

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Línea telefónica número 1.
     */
    private LineaTelefonica linea1;

    /**
     * Línea telefónica número 2.
     */
    private LineaTelefonica linea2;

    /**
     * Línea telefónica número 3.
     */
    private LineaTelefonica linea3;

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Inicializa las líneas telefónicas de la empresa. <br>
     * <b>post: </b> Se inicializaron las 3 líneas telefónicas.
     */
    public Empresa( )
    {
        linea1 = new LineaTelefonica( );
        linea2 = new LineaTelefonica( );
        linea3 = new LineaTelefonica( );
 

        // TODO hecho: Construir linea2 y linea3.

    }

    /**
     * Retorna la línea 1.
     * @return Línea 1.
     */
    public LineaTelefonica darLinea1( )
    {
    	return linea1;
        // TODO hecho PuntoB: Completar el método según la documentación dada.
    }

    /**
     * Retorna la línea 2.
     * @return Línea 2.
     */
    public LineaTelefonica darLinea2( )
    {
    	return linea2;
        // TODO hecho PuntoC: Completar el método según la documentación dada.
    }

    /**
     * Retorna la línea 3.
     * @return Línea 3.
     */
    public LineaTelefonica darLinea3( )
    {
       return linea3;
    	// TODO hecho PuntoD: Completar el método según la documentación dada.
    }

    /**
	 * Retorna el número total de llamadas realizadas.
	 * @return Total de llamadas de las tres líneas.
	 */
	public int darTotalNumeroLlamadas( )
	{
		return (linea1.darNumeroLlamadas()+linea2.darNumeroLlamadas()+linea3.darNumeroLlamadas());
        // TODO hecho Parte3 PuntoE: Completar el método según la documentación dada.
	}

	/**
	 * Retorna el total de minutos consumidos.
	 * @return Total de minutos de las tres líneas.
	 */
	public int darTotalMinutos( )
	{
		return (linea1.darNumeroMinutos()+linea2.darNumeroMinutos()+linea3.darNumeroMinutos());
        // TODO hecho Parte3 PuntoF: Completar el método según la documentación dada.
	}

	/**
	 * Retorna el costo total de las llamadas realizadas.
	 * @return Costo total de las tres líneas.
	 */
	public double darTotalCostoLlamadas( )
	{        
       return (linea1.darCostoLlamadas()+linea2.darCostoLlamadas()+linea3.darCostoLlamadas());
		// TODO hecho Parte3 PuntoG: Completar el método según la documentación dada.
	}

	/**
	 * Retorna el costo promedio de un minuto, según los minutos consumidos. <br>
	 * @return Costo promedio por minuto.
	 */
	public double darCostoPromedioMinuto( )
	{
		return darTotalMinutos()/darTotalCostoLlamadas();
        // TODO hecho Parte3 PuntoH: Completar el método según la documentación dada.
	}

	/**
     * Agrega una llamada local a la línea telefónica 1 <br>
     * <b>post: </b> Se agregó la llamada a la línea 1.
     * @param pMinutos Número de minutos de la llamada. pMinutos > 0.
     */
    public void agregarLlamadaLocalLinea1( int pMinutos )
    {
        linea1.agregarLlamadaLocal( pMinutos );
    }

    /**
     * Agrega una llamada local a la línea telefónica 2. <br>
     * <b>post: </b> Se agregó la llamada a la línea 2.
     * @param pMinutos Número de minutos de la llamada. pMinutos > 0.
     */
    public void agregarLlamadaLocalLinea2( int pMinutos )
    {
    	linea2.agregarLlamadaLocal(pMinutos);
        // TODO hecho Parte3 PuntoI: Completar el método según la documentación dada.
    }

    /**
     * Agrega una llamada local a la línea telefónica 3. <br>
     * <b>post: </b> Se agrega la llamada a la línea 3.
     * @param pMinutos Número de minutos de la llamada. pMinutos > 0.
     */
    public void agregarLlamadaLocalLinea3( int pMinutos )
    {
    	linea3.agregarLlamadaLocal(pMinutos);
        // TODO hecho Parte3 PuntoJ: Completar el método según la documentación dada.
    }

    /**
     * Agrega una llamada de larga distancia a la línea telefónica 1. <br>
     * <b>post: </b> Se agrega la llamada a la línea 1.
     * @param pMinutos Número de minutos de la llamada. pMinutos > 0.
     */
    public void agregarLlamadaLargaDistanciaLinea1( int pMinutos )
    {
    	linea1.agregarLlamadaLargaDistancia( pMinutos );
    }

    /**
     * Agrega una llamada de larga distancia a la línea telefónica 2. <br>
     * <b>post: </b> Se agrega la llamada a la línea 2.
     * @param pMinutos Número de minutos de la llamada. pMinutos > 0.
     */
    public void agregarLlamadaLargaDistanciaLinea2( int pMinutos )
    {
        linea2.agregarLlamadaLargaDistancia(pMinutos);
    	// TODO hecho Parte3 PuntoK: Completar el método según la documentación dada.
    }

    /**
     * Agrega una llamada de larga distancia a la línea telefónica 3. <br>
     * <b>post: </b> Se agrega la llamada a la línea 3.
     * @param pMinutos Número de minutos de la llamada. pMinutos > 0.
     */
    public void agregarLlamadaLargaDistanciaLinea3( int pMinutos )
    {
    	linea3.agregarLlamadaLargaDistancia(pMinutos);
        // TODO hecho Parte3 PuntoL: Completar el método según la documentación dada.
    }

    /**
     * Agrega una llamada a celular a la línea telefónica 1. <br>
     * <b>post: </b> Se agrega la llamada a la línea 1.
     * @param pMinutos Número de minutos de la llamada. pMinutos > 0.
     */
    public void agregarLlamadaCelularLinea1( int pMinutos )
    {
    	linea1.agregarLlamadaCelular( pMinutos );
    }

    /**
     * Agrega una llamada a celular a la línea telefónica 2. <br>
     * <b>post: </b> Se agrega la llamada a la línea 2.
     * @param pMinutos Número de minutos de la llamada. pMinutos > 0.
     */
    public void agregarLlamadaCelularLinea2( int pMinutos )
    {
    	linea2.agregarLlamadaCelular(pMinutos);
        // TODO hecho Parte3 PuntoM: Completar el método según la documentación dada.
    }

    /**
     * Agrega una llamada a celular a la línea telefónica 3. <br>
     * <b>post: </b> Se agrega la llamada a la línea 3.
     * @param pMinutos Número de minutos de la llamada. pMinutos > 0.
     */
    public void agregarLlamadaCelularLinea3( int pMinutos )
    {
    	linea3.agregarLlamadaCelular(pMinutos);
        // TODO hecho Parte3 PuntoN: Completar el método según la documentación dada.
    }

    /**
     * Reinicia todas las líneas telefónicas.
     * <b>post: </b> Se reinició la llamada a la línea 1, 2 y 3.
     */
    public void reiniciar( )
    {
        linea1.reiniciar( );
        linea2.reiniciar();
        linea3.reiniciar();
        // TODO hecho PuntoB: Completar el método para reiniciar las lineas 2 y 3.
    }

    //-----------------------------------------------------------------
    // Puntos de Extensión
    //-----------------------------------------------------------------

    /**
     * Método para la extensión 1.
     * @return Respuesta 1.
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * Método para la extensión 2.
     * @return Respuesta 2.
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }

}
