/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad	de	los	Andes	(Bogotá	- Colombia)
 * Departamento	de	Ingeniería	de	Sistemas	y	Computación
 * Licenciado	bajo	el	esquema	Academic Free License versión 2.1
 * 		
 * Proyecto	Cupi2	(http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_calculadoraNotas
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.calculadoraNotas.mundo;

/**
 * Representa el conjunto de notas del curso APO1, para un estudiante.
 */
public class CalculadoraNotas
{
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Representa el nivel 1
	 */
	// TODO hecho
	private Nivel n1;
	/**
	 * Representa el nivel 2
	 */
	// TODO hecho.
	private Nivel n2;
	/**
	 * Representa el nivel 3
	 */
	// TODO hecho.
	private Nivel n3;
	/**
	 * Representa el nivel 4
	 */
	// TODO hecho.
	private Nivel n4;
	/**
	 * Representa el nivel 5
	 */
	// TODO hecho.
	private Nivel n5;
	/**
	 * Representa el nivel 6
	 */
	// TODO hecho.
	private Nivel n6;
	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Construye una nueva calculadora de notas. <br>
	 * <b>post: </b> Se inicializaron todos los niveles según las reglas del curso .<br>
	 */
	public CalculadoraNotas( )
	{
		n1=new Nivel(1, 0.01, 0.04, 0.05,"Problemas, soluciones y programas" );
		n2=new Nivel(2, 0.02, 0.04, 0.14, "Definición de situaciones y manejo de casos");
		n3=new Nivel(3, 0.02, 0.05, 0.13, "Manejo de grupos de atributos");
		n4=new Nivel(4, 0.02, 0.03, 0.07, "Definición y cumplimiento de responsabilidades");
		n5=new Nivel(5, 0.02, 0.04, 0.07, "Construcción de la interfaz gráfica");
		n6=new Nivel(6, 0.05, 0.06, 0.14, "Manejo de estructuras de dos dimensiones y persistencia");


		// TODO hecho
	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Retorna el nivel 1.
	 * @return Nivel 1.
	 */
	public Nivel darN1( )
	{
		return n1;

		// TODO hecho
	}

	/**
	 * Retorna el nivel 2.
	 * @return Nivel 2.
	 */
	public Nivel darN2( )
	{
		return n2;
		// TODO hecho.
	}

	/**
	 * Retorna el nivel 3.
	 * @return Nivel 3.
	 */
	public Nivel darN3( )
	{
		return n3;
		// TODO hecho.
	}

	/**
	 * Retorna el nivel 4.
	 * @return Nivel 4.
	 */
	public Nivel darN4( )
	{
		return n4;
		// TODO hecho.
	}

	/**
	 * Retorna el nivel 5.
	 * @return Nivel 5.
	 */
	public Nivel darN5( )
	{
		return n5;
		// TODO hecho
	}

	/**
	 * Retorna el nivel 6.
	 * @return Nivel 6.
	 */
	public Nivel darN6( )
	{
		return n6;
		// TODO hecho
	}

	/**
	 * Retorna el promedio de los ejercicios de todos los niveles. <br>
	 * @return Nota promedio de los ejercicios.
	 */
	public double darNotaPromedioEjercicios( )
	{
		double notaPromedio=((n1.darNotaEjercicio()+n2.darNotaEjercicio()+n3.darNotaEjercicio()+n4.darNotaEjercicio()+n5.darNotaEjercicio()+n6.darNotaEjercicio())/6);
		return notaPromedio; 
		// TODO hecho
	}

	/**
	 * Retorna el promedio de los exámenes prácticos de todos los niveles. <br>
	 * @return Promedio de los exámenes prácticos.
	 */
	public double darNotaPromedioPracticos( )
	{
		double promedioPracticos=(n1.darNotaPractico()+n2.darNotaPractico()+n3.darNotaPractico()+n4.darNotaPractico()+n5.darNotaPractico()+n6.darNotaPractico())/6;
		return promedioPracticos;
		// TODO hecho.
	}

	/**
	 * Retorna el promedio de los exámenes teóricos de todos los niveles. <br>
	 * @return Promedio de los exámenes teóricos.
	 */
	public double darNotaPromedioTeoricos( )
	{
		double promedioTeoricos=(n1.darNotaTeorico()+n2.darNotaTeorico()+n3.darNotaTeorico()+n4.darNotaTeorico()+n5.darNotaTeorico()+n6.darNotaTeorico())/6;
		return promedioTeoricos;
		// TODO hecho.
	}

	/**
	 * Retorna la nota final del curso, teniendo en cuenta la nota de cada nivel. <br>
	 * @return Nota definitiva del curso.
	 */
	public double darNotaDefinitiva( )
	{
		double definitivaN1= ((n1.darNotaEjercicio())*0.01)+(n1.darNotaPractico())*0.04+(n1.darNotaTeorico()*0.05);
		double definitivaN2= ((n2.darNotaEjercicio())*0.02)+(n2.darNotaPractico())*0.04+(n2.darNotaTeorico()*0.14);
		double definitivaN3= ((n3.darNotaEjercicio())*0.02)+(n3.darNotaPractico())*0.05+(n3.darNotaTeorico()*0.13);
		double definitivaN4= ((n4.darNotaEjercicio())*0.02)+(n4.darNotaPractico())*0.03+(n4.darNotaTeorico()*0.07);
		double definitivaN5= ((n5.darNotaEjercicio())*0.02)+(n5.darNotaPractico())*0.04+(n5.darNotaTeorico()*0.07);
		double definitivaN6= ((n6.darNotaEjercicio())*0.05)+(n6.darNotaPractico())*0.06+(n6.darNotaTeorico()*0.14);
		double notaDefinitiva= (definitivaN1+definitivaN2+definitivaN3+definitivaN4+definitivaN5+definitivaN6);
		return notaDefinitiva;
		// TODO Parte 3 Punto P: Completar el método según la documentación dada y la descripción del ejercicio.
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
