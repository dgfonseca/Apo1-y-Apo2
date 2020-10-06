/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad	de	los	Andes	(Bogot�	- Colombia)
 * Departamento	de	Ingenier�a	de	Sistemas	y	Computaci�n
 * Licenciado	bajo	el	esquema	Academic Free License versi�n 2.1
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
	 * Representa la nota m�nima necesaria para aprobar el nivel.
	 */
	// TODO Hecho Parte 1 Punto A: Declare la constante NOTA_MINIMA seg�n el modelo del mundo.
	static final double NOTA_MINIMA=3;
	/**
	 * Define los posibles tipos de nivel.
	 */
	// TODO Hecho Parte 1 Punto B: Declarar la enumeraci�n Tipo seg�n el modelo del mundo.
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
	 * N�mero del nivel.
	 */
	private int numero;

	/**
	 * Nota del ejercicio.
	 */
	private double notaEjercicio;

	/**
	 * Nota del examen pr�ctico.
	 */
	private double notaPractico;

	/**
	 * Nota del examen te�rico.
	 */
	private double notaTeorico;

	/**
	 * Porcentaje que representa el ejercicio sobre el curso completo.
	 */
	private double porcentajeEjercicio;

	/**
	 * Porcentaje que representa el examen pr�ctico sobre el curso completo.
	 */
	private double porcentajePractico;

	/**
	 * Porcentaje que representa el examen te�rico sobre el curso completo.
	 */
	private double porcentajeTeorico;

	/**
	 * Porcentaje que representa el examen pr�ctico sobre el curso completo, cuando hay anulaci�n.
	 */

	// TODO Hecho Parte 1 Punto C: Declarar el atributo porcentajePracticoAnulacion seg�n el modelo del mundo.

	private double porcentajePracticoAnulacion;

	/**
	 * Porcentaje que representa el examen te�rico sobre el curso completo, cuando hay anulaci�n.
	 */
	// TODO hecho Parte 1 Punto D: Declarar el atributo porcentajeTeoricoAnulacion seg�n el modelo del mundo.
	private double porcentajeTeoricoAnulacion;
	/**
	 * Tema tratado en el nivel.
	 */
	private String tema;

	/**
	 * Tipo del nivel
	 */
	// TODO Hecho  Parte 1 Punto E: Declarar el atributo tipo seg�n el modelo del mundo.
	private Tipo tipo;
	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Crea un nivel usando la informaci�n recibida por par�metro. <br>
	 * <b>post: </b> Se inicializaron los atributos: notaPractico, notaTeorico y notaEjercicio en 0. <br>
	 * Se inicializaron los atributos: numero, porcentajeEjercicio, porcentajePractico, porcentajeTeorico, porcentajePracticoAnulacion, porcentajeTeoricoAnulacion, tema y tipo
	 * con los valores recibidos por par�metro. <br>
	 * @param pNumero N�mero del nivel. 1 <= pNumero <=6
	 * @param pPorcentajeEjercicio Porcentaje que tiene el ejercicio sobre el curso. 0 < pPorcentajeEjercicio < 1.
	 * @param pPorcentajePractico Porcentaje que tiene el examen pr�ctico sobre el curso. 0 < pPorcentajePractico < 1.
	 * @param pPorcentajeTeorico Porcentaje que tiene el examen te�rico sobre el curso. 0 < pPorcentajeTeorico < 1.
	 * @param pPorcentajePracticoAnulacion Porcentaje que tiene el examen pr�ctico sobre el curso, cuando hay anulaci�n. 0 < pPorcentajePractico < 1.
	 * @param pPorcentajeTeoricoAnulacion Porcentaje que tiene el examen te�rico sobre el curso, cuando hay anulaci�n. 0 < pPorcentajeTeorico < 1.
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

		// TODO hecho Parte 1 Punto F: Completar el m�todo constructor de la clase.
		// Inicializar los nuevos atributos con la informaci�n recibida por par�metro.
	}

	// -----------------------------------------------------------------
	// M�todos
	// -----------------------------------------------------------------

	/**
	 * Retorna el n�mero del nivel.
	 * @return N�mero del nivel.
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
	 * Retorna la nota del examen pr�ctico.
	 * @return Nota del examen pr�ctico.
	 */
	public double darNotaPractico( )
	{
		return notaPractico;
	}

	/**
	 * Retorna la nota del examen te�rico.
	 * @return Nota del examen te�rico.
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

	// TODO hecho Parte 1 Punto G: Completar el m�todo para que retorne el tipo.


	/**
	 * Indica si el ejercicio de nivel se anula seg�n la regla presentada en el programa del curso.
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
		// TODO hecho Parte 1 Punto H: Completar el m�todo seg�n la documentaci�n dada.
	}

	/**
	 * Retorna el porcentaje del ejercicio sobre todo el curso, teniendo en cuenta la regla de anulaci�n.
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



		// TODO HECHO Parte 1 Punto I: Modifique el m�todo para que ahora incluya las reglas de anulaci�n.

	}

	/**
	 * Retorna el porcentaje del examen pr�ctico sobre todo el curso, teniendo en cuenta la regla de anulaci�n.
	 * @return Porcentaje que tiene el examen pr�ctico.
	 */
	public double darPorcentajePractico( )
	{
		porcentajePractico=notaPractico/(notaEjercicio+notaPractico+notaTeorico);
		if(notaPractico < (notaEjercicio*0.6) || (notaTeorico < notaEjercicio*0.6)){
			return porcentajePracticoAnulacion;}

		// TODO HECHO Parte 1 Punto J: Modifique el m�todo para que ahora incluya las reglas de anulaci�n.
		else{
			return porcentajePractico;}
	}

	/**
	 * Retorna el porcentaje del examen te�rico sobre todo el curso, teniendo en cuenta la regla de anulaci�n.
	 * @return Porcentaje que tiene el examen te�rico.
	 */
	public double darPorcentajeTeorico( )
	{
		porcentajeTeorico=notaTeorico/(notaEjercicio+notaPractico+notaTeorico);
		if(notaPractico < (notaEjercicio*0.6) || notaTeorico < (notaEjercicio*0.6)){
			return porcentajeTeoricoAnulacion;}
		// TODO HECHO Parte 1 Punto K: Modifique el m�todo para que ahora incluya las reglas de anulaci�n.
		else{
			return porcentajeTeorico;}
	}

	/**
	 * Cambiar la nota del ejercicio por el valor recibido por par�metro. <br>
	 * <b> post: </b> Se modific� la nota del ejercicio.
	 * @param pNotaEjercicio Nueva nota del ejercicio.
	 */
	public void cambiarNotaEjercicio( double pNotaEjercicio )
	{
		notaEjercicio = pNotaEjercicio;
	}

	/**
	 * Cambia la nota del examen pr�ctico por el valor recibido por par�metro. <br>
	 * <b> post: </b> Se modific� la nota del examen pr�ctico.
	 * @param pNotaPractico Nueva nota del examen pr�ctico.
	 */
	public void cambiarNotaPractico( double pNotaPractico )
	{
		notaPractico = pNotaPractico;
	}

	/**
	 * Cambia la nota del examen te�rico por el valor recibido por par�metro. <br>
	 * <b> post: </b> Se modific� la nota del examen te�rico.
	 * @param pNotaTeorico Nueva nota del examen te�rico.
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

		// TODO hecho Parte 1 Punto M: Completar el m�todo seg�n la documentaci�n dada y la descripci�n del ejercicio.
	}

}