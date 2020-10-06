/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
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
     * L�nea telef�nica n�mero 1.
     */
    private LineaTelefonica linea1;

    /**
     * L�nea telef�nica n�mero 2.
     */
    private LineaTelefonica linea2;

    /**
     * L�nea telef�nica n�mero 3.
     */
    private LineaTelefonica linea3;

    //-----------------------------------------------------------------
    // M�todos
    //-----------------------------------------------------------------

    /**
     * Inicializa las l�neas telef�nicas de la empresa. <br>
     * <b>post: </b> Se inicializaron las 3 l�neas telef�nicas.
     */
    public Empresa( )
    {
        linea1 = new LineaTelefonica( );
        linea2 = new LineaTelefonica( );
        linea3 = new LineaTelefonica( );
 

        // TODO hecho: Construir linea2 y linea3.

    }

    /**
     * Retorna la l�nea 1.
     * @return L�nea 1.
     */
    public LineaTelefonica darLinea1( )
    {
    	return linea1;
        // TODO hecho PuntoB: Completar el m�todo seg�n la documentaci�n dada.
    }

    /**
     * Retorna la l�nea 2.
     * @return L�nea 2.
     */
    public LineaTelefonica darLinea2( )
    {
    	return linea2;
        // TODO hecho PuntoC: Completar el m�todo seg�n la documentaci�n dada.
    }

    /**
     * Retorna la l�nea 3.
     * @return L�nea 3.
     */
    public LineaTelefonica darLinea3( )
    {
       return linea3;
    	// TODO hecho PuntoD: Completar el m�todo seg�n la documentaci�n dada.
    }

    /**
	 * Retorna el n�mero total de llamadas realizadas.
	 * @return Total de llamadas de las tres l�neas.
	 */
	public int darTotalNumeroLlamadas( )
	{
		return (linea1.darNumeroLlamadas()+linea2.darNumeroLlamadas()+linea3.darNumeroLlamadas());
        // TODO hecho Parte3 PuntoE: Completar el m�todo seg�n la documentaci�n dada.
	}

	/**
	 * Retorna el total de minutos consumidos.
	 * @return Total de minutos de las tres l�neas.
	 */
	public int darTotalMinutos( )
	{
		return (linea1.darNumeroMinutos()+linea2.darNumeroMinutos()+linea3.darNumeroMinutos());
        // TODO hecho Parte3 PuntoF: Completar el m�todo seg�n la documentaci�n dada.
	}

	/**
	 * Retorna el costo total de las llamadas realizadas.
	 * @return Costo total de las tres l�neas.
	 */
	public double darTotalCostoLlamadas( )
	{        
       return (linea1.darCostoLlamadas()+linea2.darCostoLlamadas()+linea3.darCostoLlamadas());
		// TODO hecho Parte3 PuntoG: Completar el m�todo seg�n la documentaci�n dada.
	}

	/**
	 * Retorna el costo promedio de un minuto, seg�n los minutos consumidos. <br>
	 * @return Costo promedio por minuto.
	 */
	public double darCostoPromedioMinuto( )
	{
		return darTotalMinutos()/darTotalCostoLlamadas();
        // TODO hecho Parte3 PuntoH: Completar el m�todo seg�n la documentaci�n dada.
	}

	/**
     * Agrega una llamada local a la l�nea telef�nica 1 <br>
     * <b>post: </b> Se agreg� la llamada a la l�nea 1.
     * @param pMinutos N�mero de minutos de la llamada. pMinutos > 0.
     */
    public void agregarLlamadaLocalLinea1( int pMinutos )
    {
        linea1.agregarLlamadaLocal( pMinutos );
    }

    /**
     * Agrega una llamada local a la l�nea telef�nica 2. <br>
     * <b>post: </b> Se agreg� la llamada a la l�nea 2.
     * @param pMinutos N�mero de minutos de la llamada. pMinutos > 0.
     */
    public void agregarLlamadaLocalLinea2( int pMinutos )
    {
    	linea2.agregarLlamadaLocal(pMinutos);
        // TODO hecho Parte3 PuntoI: Completar el m�todo seg�n la documentaci�n dada.
    }

    /**
     * Agrega una llamada local a la l�nea telef�nica 3. <br>
     * <b>post: </b> Se agrega la llamada a la l�nea 3.
     * @param pMinutos N�mero de minutos de la llamada. pMinutos > 0.
     */
    public void agregarLlamadaLocalLinea3( int pMinutos )
    {
    	linea3.agregarLlamadaLocal(pMinutos);
        // TODO hecho Parte3 PuntoJ: Completar el m�todo seg�n la documentaci�n dada.
    }

    /**
     * Agrega una llamada de larga distancia a la l�nea telef�nica 1. <br>
     * <b>post: </b> Se agrega la llamada a la l�nea 1.
     * @param pMinutos N�mero de minutos de la llamada. pMinutos > 0.
     */
    public void agregarLlamadaLargaDistanciaLinea1( int pMinutos )
    {
    	linea1.agregarLlamadaLargaDistancia( pMinutos );
    }

    /**
     * Agrega una llamada de larga distancia a la l�nea telef�nica 2. <br>
     * <b>post: </b> Se agrega la llamada a la l�nea 2.
     * @param pMinutos N�mero de minutos de la llamada. pMinutos > 0.
     */
    public void agregarLlamadaLargaDistanciaLinea2( int pMinutos )
    {
        linea2.agregarLlamadaLargaDistancia(pMinutos);
    	// TODO hecho Parte3 PuntoK: Completar el m�todo seg�n la documentaci�n dada.
    }

    /**
     * Agrega una llamada de larga distancia a la l�nea telef�nica 3. <br>
     * <b>post: </b> Se agrega la llamada a la l�nea 3.
     * @param pMinutos N�mero de minutos de la llamada. pMinutos > 0.
     */
    public void agregarLlamadaLargaDistanciaLinea3( int pMinutos )
    {
    	linea3.agregarLlamadaLargaDistancia(pMinutos);
        // TODO hecho Parte3 PuntoL: Completar el m�todo seg�n la documentaci�n dada.
    }

    /**
     * Agrega una llamada a celular a la l�nea telef�nica 1. <br>
     * <b>post: </b> Se agrega la llamada a la l�nea 1.
     * @param pMinutos N�mero de minutos de la llamada. pMinutos > 0.
     */
    public void agregarLlamadaCelularLinea1( int pMinutos )
    {
    	linea1.agregarLlamadaCelular( pMinutos );
    }

    /**
     * Agrega una llamada a celular a la l�nea telef�nica 2. <br>
     * <b>post: </b> Se agrega la llamada a la l�nea 2.
     * @param pMinutos N�mero de minutos de la llamada. pMinutos > 0.
     */
    public void agregarLlamadaCelularLinea2( int pMinutos )
    {
    	linea2.agregarLlamadaCelular(pMinutos);
        // TODO hecho Parte3 PuntoM: Completar el m�todo seg�n la documentaci�n dada.
    }

    /**
     * Agrega una llamada a celular a la l�nea telef�nica 3. <br>
     * <b>post: </b> Se agrega la llamada a la l�nea 3.
     * @param pMinutos N�mero de minutos de la llamada. pMinutos > 0.
     */
    public void agregarLlamadaCelularLinea3( int pMinutos )
    {
    	linea3.agregarLlamadaCelular(pMinutos);
        // TODO hecho Parte3 PuntoN: Completar el m�todo seg�n la documentaci�n dada.
    }

    /**
     * Reinicia todas las l�neas telef�nicas.
     * <b>post: </b> Se reinici� la llamada a la l�nea 1, 2 y 3.
     */
    public void reiniciar( )
    {
        linea1.reiniciar( );
        linea2.reiniciar();
        linea3.reiniciar();
        // TODO hecho PuntoB: Completar el m�todo para reiniciar las lineas 2 y 3.
    }

    //-----------------------------------------------------------------
    // Puntos de Extensi�n
    //-----------------------------------------------------------------

    /**
     * M�todo para la extensi�n 1.
     * @return Respuesta 1.
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * M�todo para la extensi�n 2.
     * @return Respuesta 2.
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }

}
