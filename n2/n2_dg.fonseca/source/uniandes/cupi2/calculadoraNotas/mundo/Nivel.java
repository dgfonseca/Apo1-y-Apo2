/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad	de	los	Andes	(Bogotá	- Colombia)
 * Departamento	de	Ingeniería	de	Sistemas	y	Computación
 * Licenciado	bajo	el	esquema	Academic Free License versión 2.1
 * 		
 * Proyecto	Cupi2	(http://cupi2.uniandes.edu.co)
 * Ejercicio: n2_calculadoraNotas
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.calculadoraNotas.mundo;

/**
 * Representa un nivel dentro del curso.
 */
public class Nivel
{

	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------

	/**
	 * Representa la nota mínima necesaria para aprobar el nivel.
	 */
	// TODO Hecho Parte 1 Punto A: Declare la constante NOTA_MINIMA según el modelo del mundo.
	static final double NOTA_MINIMA=3;
	/**
	 * Define los posibles tipos de nivel.
	 */
	// TODO Hecho Parte 1 Punto B: Declarar la enumeración Tipo según el modelo del mundo.
	public enum Tipo
	{
		ESTRUCTURAL,
		ALGORITMICO,
		GRAFICO,
	}
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Número del nivel.
	 */
	private int numero;

	/**
	 * Nota del ejercicio.
	 */
	private double notaEjercicio;

	/**
	 * Nota del examen práctico.
	 */
	private double notaPractico;

	/**
	 * Nota del examen teórico.
	 */
	private double notaTeorico;

	/**
	 * Porcentaje que representa el ejercicio sobre el curso completo.
	 */
	private double porcentajeEjercicio;

	/**
	 * Porcentaje que representa el examen práctico sobre el curso completo.
	 */
	private double porcentajePractico;

	/**
	 * Porcentaje que representa el examen teórico sobre el curso completo.
	 */
	private double porcentajeTeorico;

	/**
	 * Porcentaje que representa el examen práctico sobre el curso completo, cuando hay anulación.
	 */

	// TODO Hecho Parte 1 Punto C: Declarar el atributo porcentajePracticoAnulacion según el modelo del mundo.

	private double porcentajePracticoAnulacion;

	/**
	 * Porcentaje que representa el examen teórico sobre el curso completo, cuando hay anulación.
	 */
	// TODO hecho Parte 1 Punto D: Declarar el atributo porcentajeTeoricoAnulacion según el modelo del mundo.
	private double porcentajeTeoricoAnulacion;
	/**
	 * Tema tratado en el nivel.
	 */
	private String tema;

	/**
	 * Tipo del nivel
	 */
	// TODO Hecho  Parte 1 Punto E: Declarar el atributo tipo según el modelo del mundo.
	private Tipo tipo;
	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Crea un nivel usando la información recibida por parámetro. <br>
	 * <b>post: </b> Se inicializaron los atributos: notaPractico, notaTeorico y notaEjercicio en 0. <br>
	 * Se inicializaron los atributos: numero, porcentajeEjercicio, porcentajePractico, porcentajeTeorico, porcentajePracticoAnulacion, porcentajeTeoricoAnulacion, tema y tipo
	 * con los valores recibidos por parámetro. <br>
	 * @param pNumero Número del nivel. 1 <= pNumero <=6
	 * @param pPorcentajeEjercicio Porcentaje que tiene el ejercicio sobre el curso. 0 < pPorcentajeEjercicio < 1.
	 * @param pPorcentajePractico Porcentaje que tiene el examen práctico sobre el curso. 0 < pPorcentajePractico < 1.
	 * @param pPorcentajeTeorico Porcentaje que tiene el examen teórico sobre el curso. 0 < pPorcentajeTeorico < 1.
	 * @param pPorcentajePracticoAnulacion Porcentaje que tiene el examen práctico sobre el curso, cuando hay anulación. 0 < pPorcentajePractico < 1.
	 * @param pPorcentajeTeoricoAnulacion Porcentaje que tiene el examen teórico sobre el curso, cuando hay anulación. 0 < pPorcentajeTeorico < 1.
	 * @param pTema Tema tratado en el nivel. pTema != null, pTema != "".
	 * @param pTipo Tipo del nivel. pTipo == { Tipo.ESTRUCTURAL, Tipo.ALGORITMICO, Tipo.GRAFICO}
	 */
	public Nivel( int pNumero, double pPorcentajeEjercicio, double pPorcentajePractico, double pPorcentajeTeorico, double pPorcentajePracticoAnulacion, double pPorcentajeTeoricoAnulacion, String pTema, Tipo pTipo )
	{
		numero = pNumero;
		porcentajeEjercicio = pPorcentajeEjercicio;
		porcentajePractico = pPorcentajePractico;
		porcentajeTeorico = pPorcentajeTeorico;
		tema = pTema;
		porcentajePracticoAnulacion=pPorcentajePracticoAnulacion;
		porcentajeTeoricoAnulacion=pPorcentajeTeoricoAnulacion;
        notaEjercicio = 0;
		notaPractico = 0;
		notaTeorico = 0;

		// TODO hecho Parte 1 Punto F: Completar el método constructor de la clase.
		// Inicializar los nuevos atributos con la información recibida por parámetro.
	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Retorna el número del nivel.
	 * @return Número del nivel.
	 */
	public int darNumero( )
	{
		return numero;
	}

	/**
	 * Retorna la nota del ejercicio.
	 * @return Nota del ejercicio.
	 */
	public double darNotaEjercicio( )
	{
		return notaEjercicio;
	}

	/**
	 * Retorna la nota del examen práctico.
	 * @return Nota del examen práctico.
	 */
	public double darNotaPractico( )
	{
		return notaPractico;
	}

	/**
	 * Retorna la nota del examen teórico.
	 * @return Nota del examen teórico.
	 */
	public double darNotaTeorico( )
	{
		return notaTeorico;
	}

	/**
	 * Retorna el tema.
	 * @return Tema tratado en el nivel.
	 */
	public String darTema( )
	{
		return tema;
	}

	/**
	 * Retorna el tipo.
	 * @return Tipo del nivel.
	 */
	public Tipo darTipo( )
	{
		if(tipo==Tipo.ALGORITMICO){
			return tipo;}
		else if(tipo==Tipo.ESTRUCTURAL){
			return tipo;}
		else if (tipo==Tipo.GRAFICO){
			return tipo;}
		return tipo;

	}

	// TODO hecho Parte 1 Punto G: Completar el método para que retorne el tipo.


	/**
	 * Indica si el ejercicio de nivel se anula según la regla presentada en el programa del curso.
	 * @return True si la nota del ejercicio se anula, false de lo contrario.
	 */
	public boolean estaAnulado( )
	{

		if(notaPractico < (notaEjercicio*0.6) || notaTeorico < (notaEjercicio*0.6)){
			return true;
		}
		else{
			return false;
		}
		// TODO hecho Parte 1 Punto H: Completar el método según la documentación dada.
	}

	/**
	 * Retorna el porcentaje del ejercicio sobre todo el curso, teniendo en cuenta la regla de anulación.
	 * @return Porcentaje que tiene el ejercicio.
	 */
	public double darPorcentajeEjercicio( )
	{
		porcentajeEjercicio=notaEjercicio/(notaEjercicio+notaPractico+notaTeorico);
		if(notaPractico < (notaEjercicio*0.6) || notaTeorico < (notaEjercicio*0.6)){
			return 0;}
		if(porcentajeEjercicio==0.01){
			return porcentajePracticoAnulacion += 0.01;}
		if(porcentajeEjercicio==0.02){
			return porcentajePracticoAnulacion += 0.01;}
		if(porcentajeEjercicio==0.05){
			return porcentajePracticoAnulacion+=0.03;}
		else
		{
			porcentajePracticoAnulacion=0.0;	
		}
		return porcentajePracticoAnulacion;



		// TODO HECHO Parte 1 Punto I: Modifique el método para que ahora incluya las reglas de anulación.

	}

	/**
	 * Retorna el porcentaje del examen práctico sobre todo el curso, teniendo en cuenta la regla de anulación.
	 * @return Porcentaje que tiene el examen práctico.
	 */
	public double darPorcentajePractico( )
	{
		porcentajePractico=notaPractico/(notaEjercicio+notaPractico+notaTeorico);
		if(notaPractico < (notaEjercicio*0.6) || (notaTeorico < notaEjercicio*0.6)){
			return porcentajePracticoAnulacion;}

		// TODO HECHO Parte 1 Punto J: Modifique el método para que ahora incluya las reglas de anulación.
		else{
			return porcentajePractico;}
	}

	/**
	 * Retorna el porcentaje del examen teórico sobre todo el curso, teniendo en cuenta la regla de anulación.
	 * @return Porcentaje que tiene el examen teórico.
	 */
	public double darPorcentajeTeorico( )
	{
		porcentajeTeorico=notaTeorico/(notaEjercicio+notaPractico+notaTeorico);
		if(notaPractico < (notaEjercicio*0.6) || notaTeorico < (notaEjercicio*0.6)){
			return porcentajeTeoricoAnulacion;}
		// TODO HECHO Parte 1 Punto K: Modifique el método para que ahora incluya las reglas de anulación.
		else{
			return porcentajeTeorico;}
	}

	/**
	 * Cambiar la nota del ejercicio por el valor recibido por parámetro. <br>
	 * <b> post: </b> Se modificó la nota del ejercicio.
	 * @param pNotaEjercicio Nueva nota del ejercicio.
	 */
	public void cambiarNotaEjercicio( double pNotaEjercicio )
	{
		notaEjercicio = pNotaEjercicio;
	}

	/**
	 * Cambia la nota del examen práctico por el valor recibido por parámetro. <br>
	 * <b> post: </b> Se modificó la nota del examen práctico.
	 * @param pNotaPractico Nueva nota del examen práctico.
	 */
	public void cambiarNotaPractico( double pNotaPractico )
	{
		notaPractico = pNotaPractico;
	}

	/**
	 * Cambia la nota del examen teórico por el valor recibido por parámetro. <br>
	 * <b> post: </b> Se modificó la nota del examen teórico.
	 * @param pNotaTeorico Nueva nota del examen teórico.
	 */
	public void cambiarNotaTeorico( double pNotaTeorico )
	{
		notaTeorico = pNotaTeorico;
	}

	/**
	 * Calcula el porcentaje total que representa el nivel sobre todo el curso. <br>
	 * @return Porcentaje de la nota del curso que representa el nivel.
	 */
	public double calcularPorcentajeTotal( )
	{
		double porcentajeTotal = porcentajePractico + porcentajeEjercicio + porcentajeTeorico;
		return porcentajeTotal;    
	}

	/**
	 * Calcula el promedio ponderado de las notas del nivel. <br>
	 * @return Promedio ponderado del nivel.
	 */
	public double calcularNota( )
	{
		// TODO Parte 1 Punto L: Realice las modificaciones necesarias, teniendo en cuenta las nuevas restricciones.
		double nota = notaEjercicio * porcentajeEjercicio + notaPractico * porcentajePractico + notaTeorico * porcentajeTeorico;
		double notaAnulacion= notaEjercicio*porcentajeEjercicio+notaPractico*porcentajePracticoAnulacion+notaTeorico*porcentajeTeoricoAnulacion;
		if(estaAnulado()==true)	{
			return notaAnulacion;
		}
		else
			return nota;   
	}

	/**
	 * Calcula la nota obtenida en el nivel, sobre 5.
	 * @return Nota obtenida en el nivel.
	 */
	public double calcularNotaSobreCinco( )
	{
		double nota = ( calcularNota( ) / calcularPorcentajeTotal( ) );
		nota = Math.round( nota * 100.0 ) / 100.0;
		return nota;
	}

	/**
	 * Calcula si se aprueba el nivel.<br>
	 * @return True si aprueba el nivel, false de lo contrario.
	 */
	public boolean apruebaNivel( )
	{
		if(calcularNotaSobreCinco() <= 3.0){
			return false;
		}
		else
			return true;

		// TODO hecho Parte 1 Punto M: Completar el método según la documentación dada y la descripción del ejercicio.
	}

}