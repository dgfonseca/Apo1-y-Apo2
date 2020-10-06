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

import uniandes.cupi2.calculadoraNotas.mundo.Nivel.Tipo;

/**
 * Representa el conjunto de notas del curso APO1, de un estudiante.
 */
public class CalculadoraNotas
{
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Representa el nivel 1
	 */
	private Nivel n1;

	/**
	 * Representa el nivel 2
	 */
	private Nivel n2;

	/**
	 * Representa el nivel 3
	 */
	private Nivel n3;

	/**
	 * Representa el nivel 4
	 */
	private Nivel n4;

	/**
	 * Representa el nivel 5
	 */
	private Nivel n5;

	/**
	 * Representa el nivel 6
	 */
	private Nivel n6;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Construye una nueva calculadora de notas. <br>
	 * <b>post: </b> Se inicializaron todos los niveles del curso con la información presentada en el programa del curso.<br>
	 */
	public CalculadoraNotas( )
	{
		// TODO hecho Parte 2 Punto A: Realizar las modificaciones necesarias para que el método constructor se ajuste al modelo del mundo.

		n1 = new Nivel( 1, 0.01, 0.04, 0.05, 0, 0, "Problemas, soluciones y programas", Tipo.ESTRUCTURAL );
		n2 = new Nivel( 2, 0.02, 0.04, 0.14, 0, 0, "Definición de situaciones y manejo de casos", Tipo.ALGORITMICO );
		n3 = new Nivel( 3, 0.02, 0.05, 0.13, 0, 0, "Manejo de grupos de atributos", Tipo.ALGORITMICO );
		n4 = new Nivel( 4, 0.02, 0.03, 0.07, 0, 0, "Definición y cumplimiento de responsabilidades", Tipo.ESTRUCTURAL );
		n5 = new Nivel( 5, 0.02, 0.04, 0.07, 0, 0, "Construcción de la interfaz gráfica", Tipo.GRAFICO );
		n6 = new Nivel( 6, 0.05, 0.06, 0.14, 0, 0, "Manejo de estructuras de dos dimensiones y persistencia", Tipo.ALGORITMICO );    

	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Retorna el nivel correspondiente al número ingresado por parámetro. <br>
	 * @param pNumeroNivel Número del nivel que se quiere obtener. <br>
	 * @return Nivel con el número especificado por parámetro
	 */
	public Nivel darNivel( int pNumeroNivel )
	{
		Nivel nivel=null;
		switch (pNumeroNivel){
		case 1:
			nivel=n1;
			break;
		case 2:
			nivel=n2;
			break;
		case 3:
			nivel=n3;
			break;
		case  4:
			nivel=n4;
			break;
		case  5:
			nivel=n5;
			break;
		case 6:
			nivel=n6;
			break;

		}
		return nivel;
		// TODO Hecho Parte 2 Punto B: Completar el método según la documentación dada.
		// Debe usar 'switch' como parte de la solución.
	}

	/**
	 * Retorna el promedio de los ejercicios de todos los niveles. <br>
	 * @return Promedio de los ejercicios.
	 */
	public double darNotaPromedioEjercicios( )
	{
		double suma = n1.darNotaEjercicio( ) + n2.darNotaEjercicio( ) + n3.darNotaEjercicio( ) + n4.darNotaEjercicio( ) + n5.darNotaEjercicio( ) + n6.darNotaEjercicio( );
		return suma / 6;    
	}

	/**
	 * Retorna el promedio de los exámenes prácticos de todos los niveles. <br>
	 * @return Promedio de los exámenes prácticos.
	 */
	public double darNotaPromedioPracticos( )
	{
		double suma = n1.darNotaPractico( ) + n2.darNotaPractico( ) + n3.darNotaPractico( ) + n4.darNotaPractico( ) + n5.darNotaPractico( ) + n6.darNotaPractico( );
		return suma / 6;    
	}

	/**
	 * Retorna el promedio de los exámenes teóricos de todos los niveles. <br>
	 * @return Promedio de los exámenes teóricos.
	 */
	public double darNotaPromedioTeoricos( )
	{
		double suma = n1.darNotaTeorico( ) + n2.darNotaTeorico( ) + n3.darNotaTeorico( ) + n4.darNotaTeorico( ) + n5.darNotaTeorico( ) + n6.darNotaTeorico( );
		return suma / 6;    
	}

	/**
	 * Retorna la nota final del curso, teniendo en cuenta la nota de cada nivel. <br>
	 * @return Nota definitiva del curso.
	 */
	public double darNotaDefinitiva( )
	{
		double notaDefinitiva = n1.calcularNota( ) + n2.calcularNota( ) + n3.calcularNota( ) + n4.calcularNota( ) + n5.calcularNota( ) + n6.calcularNota( );
		return notaDefinitiva;    
	}

	/**
	 * Retorna el nivel con la peor nota del curso.<br>
	 * En caso de que exista más de un nivel con la nota mínima, se debe retornar el primer nivel encontrado.<br>
	 * @return Nivel con la menor nota.
	 */
	public Nivel darPeorNivel( )
	{   Nivel nivel=n1;
		
		if(n2.calcularNotaSobreCinco()<nivel.calcularNotaSobreCinco()){
			nivel=n2;}
		if(n3.calcularNotaSobreCinco()<nivel.calcularNotaSobreCinco()){
			nivel=n3;}
		if(n4.calcularNotaSobreCinco()<nivel.calcularNotaSobreCinco()){
			nivel=n4;}
		if(n5.calcularNotaSobreCinco()<nivel.calcularNotaSobreCinco()){
			nivel=n5;}
		if(n6.calcularNotaSobreCinco()<nivel.calcularNotaSobreCinco())	{
			nivel=n6;}
		
		return nivel;

		// TODO Parte 2 Punto C: Completar el método según la documentación dada y la descripción del ejercicio.
	}

	/**
	 * Calcula la nota promedio de los niveles del tipo recibido por parámetro. <br>
	 * @param pTipo Tipo del nivel del que se quiere conocer el promedio. pTipo == { Tipo.ESTRUCTURAL, Tipo.ALGORITMICO, Tipo.GRAFICO}. <br>
	 * @return Nota sobre cinco del promedio de los niveles del tipo recibido por parámetro.
	 */
	public double darPromedioPorTipo( Tipo pTipo )
	{
		if(pTipo==Tipo.ESTRUCTURAL){
			return n1.calcularNotaSobreCinco()+n4.calcularNotaSobreCinco()/2;
		}
		else if(pTipo==Tipo.ALGORITMICO){
			return n2.calcularNotaSobreCinco()+n3.calcularNotaSobreCinco()+n6.calcularNotaSobreCinco()/3;
		}
		else{
			return n5.calcularNotaSobreCinco();
		}
		// TODO hecho Parte 2 Punto D: Completar el método según la documentación dada y la descripción del ejercicio.
	}

	/**
	 * Calcula el porcentaje de niveles aprobados, sobre 100.
	 * @return Porcentaje de niveles aprobados.
	 */
	public double darPorcentajeNivelesAprobados( )
	{
		int num=0;
		if(n1.apruebaNivel() == true)
			num++;
		if(n2.apruebaNivel() == true)
			num++;
		if(n3.apruebaNivel() == true)
			num++;
		if(n4.apruebaNivel() == true)
			num++;
		if(n5.apruebaNivel() == true)
			num++;
		if(n6.apruebaNivel() == true)
			num++;
		double pNivelesAprobados = num * 100/6;
		return pNivelesAprobados;
		// TODO hecho Parte 2 Punto E: Completar el método según la documentación dada y la descripción del ejercicio.
	}

	// -----------------------------------------------------------------
	// Puntos de Extensión
	// -----------------------------------------------------------------

	/**
	 * Extensión 1.
	 * @return respuesta1.
	 */
	public String metodo1( )
	{
		return "Respuesta 1";
	}

	/**
	 * Extensión 2.
	 * @return respuesta2.
	 */
	public String metodo2( )
	{
		return "Respuesta 2";
	}
}