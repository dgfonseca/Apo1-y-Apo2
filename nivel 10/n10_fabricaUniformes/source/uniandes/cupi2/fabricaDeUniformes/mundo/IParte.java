/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n10_FabricaDeUniformes
 * Autor: Equipo Cupi2 2018-1
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.fabricaDeUniformes.mundo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.PrintWriter;

/**
 * Interface que define los m�todos necesarios para una parte del uniforme.
 */
public interface IParte
{

	// -------------------------------------------------------------
	// M�todos
	// -------------------------------------------------------------

	/**
	 * Retorna la coordenada en x del dibujo.
	 * @return Coordenada en x del dibujo.
	 */
	public int darX( );

	/**
	 * Retorna la coordenada en y del dibujo.
	 * @return Coordenada en y del dibujo.
	 */
	public int darY( );

	/**
	 * Retorna el ancho del dibujo.
	 * @return Ancho del dibujo.
	 */
	public int darAncho( );

	/**
	 * Retorna el alto del dibujo.
	 * @return Alto del dibujo.
	 */
	public int darAlto( );

	/**
	 * Retorna el tipo del dibujo.
	 * @return El tipo del dibujo.
	 */
	public String darTipo( );

	/**
	 * Retorna el color del dibujo.
	 * @return Color del dibujo.
	 */
	public Color darColor( );

	/**
	 * Cambia la coordenada x del dibujo.
	 * @param pX Nueva coordenada x del dibujo. pX >= 0.
	 */
	public void cambiarX( int pX );

	/**
	 * Cambia la coordenada y del dibujo.
	 * @param pY Nueva coordenada y del dibujo. pY >= 0.
	 */
	public void cambiarY( int pY );

	/**
	 * Indica si un punto est� dentro de un dibujo.
	 * @param pX Es la coordenada pX del punto buscado.
	 * @param pY Es la coordenada pY del punto buscado.
	 * @return Retorna true si el punto est� dentro del dibujo, false en caso contrario.
	 */
	public boolean estaDentro( int pX, int pY );

	/**
	 * Pinta el dibujo.<br>
	 * <b>post: </b> Se pint� el dibujo en el lienzo.
	 * @param pGraphics La superficie donde se debe pintar el dibujo. pGraphics != null
	 */
	// TODO HECHO Parte1 PuntoA. Realice la declaraci�n del m�todo pintar.
	public void pintar( Graphics2D pGraphics);

	/**
	 * Pinta el dibujo sombreado.<br>
	 * <b>post: </b> Se pint� el dibujo sombreado en el lienzo.
	 * @param pGraphics Superficie donde se debe pintar. pGraphics != null.
	 */
	public void pintarSombreado( Graphics2D pGraphics );

	/**
	 * Pinta el dibujo como seleccionado. <br>
	 * <b>post: </b> Se pint� el contorno del dibujo seleccionada en el lienzo.
	 * @param pGraphics Superficie donde se pinta el rect�ngulo. pGraphics != null.
	 */
	public void pintarSeleccionada( Graphics2D pGraphics );

	/**
	 * Guarda el dibujo en un archivo.<br>
	 * <b>post: </b> Se guard� el dibujo en el archivo.
	 * @param pEscritor Stream donde se va a guardar el dibujo. pEscritor != null.
	 */
	// TODO HECHO Parte1 PuntoB. Realice la declaraci�n del m�todo guardar.
	public void guardar(PrintWriter pEscritor);


}
