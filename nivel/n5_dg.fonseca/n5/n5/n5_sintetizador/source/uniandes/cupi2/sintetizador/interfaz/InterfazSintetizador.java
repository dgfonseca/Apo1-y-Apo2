package uniandes.cupi2.sintetizador.interfaz;
import java.awt.BorderLayout;


import javax.swing.*;

import uniandes.cupi2.sintetizador.mundo.Efecto;
import uniandes.cupi2.sintetizador.mundo.Nota;
import uniandes.cupi2.sintetizador.mundo.Sintetizador;

@SuppressWarnings("serial")
public class InterfazSintetizador extends JFrame {
	//Atributos
	private Sintetizador sintetizador; 	
	//atributos de la interfaz
	private PanelEfectos panelEfectos;
	/**
	 *  Atributo panel informacion
	 */
	private PanelInformacion panelInformacion;
	/**
	 *  Atributo panel opciones
	 */
	private PanelOpciones panelOpciones;
	/**
	 *  Atributo panel superior
	 */
	private PanelSuperior panelSuperior;
	/**
	 *  Atributo panel teclado
	 */
	private PanelTeclado panelTeclado;

	/**
	 *  Constructor de la clase interfaz
	 *  @throws Exception cuando hay un error al correr la interfaz
	 */

	public InterfazSintetizador() throws Exception{
		try{
			setTitle("Sintetizador");
			setSize(1000,600);
			setResizable(false);
			setDefaultCloseOperation( EXIT_ON_CLOSE );

			//crea el sintetizador
			sintetizador= new Sintetizador();
			setLayout(new BorderLayout());

			//panel teclado
			panelTeclado=new PanelTeclado(this);
			add(panelTeclado, BorderLayout.CENTER);

			//Panel Efectos
			panelEfectos=new PanelEfectos(this);
			add(panelEfectos, BorderLayout.WEST);



			//panel informacion
			panelInformacion=new PanelInformacion(this);
			add(panelInformacion, BorderLayout.EAST);

			//panel opciones
			panelOpciones=new PanelOpciones(this);
			add(panelOpciones, BorderLayout.SOUTH);

			//panel superior
			panelSuperior=new PanelSuperior(this);
			add(panelSuperior, BorderLayout.NORTH);


		}
		catch(Exception e){
			e.printStackTrace( );
			JOptionPane.showMessageDialog( this, e.getMessage( ), "Sintetizador", JOptionPane.ERROR_MESSAGE );
		}

	}

	//metodos


	/**
	 * El boton anterior muestra el efecto anterior al actual, hay exception si ya esta en el primer boton
	 * <b>pre:</b> el sintetizador ya esta inicializado
	 * @throws Exception cuando ya esta en el primer boton
	 */
	public void darAnterior() throws Exception{
		try {
			sintetizador.darAnteriorEfecto();
			Efecto efectoActual = sintetizador.darEfectoActual();
			panelSuperior.actualizar(efectoActual);
			System.out.println(sintetizador.darEfectoActual().darNombre());
			panelInformacion.actualizar(sintetizador.darEfectoActual().darDescripcion()
					, ""+ sintetizador.darEfectoActual().darCalificacion());

		} catch (Exception e) {
			JOptionPane.showMessageDialog( this, e.getMessage( ), "Ver efecto anterior", JOptionPane.WARNING_MESSAGE );
		}



		/**
		 * El boton siguiente muestra el efecto siguiente al actual, hay exception si ya esta en el ultimo boton
		 * <b>pre:</b> el sintetizador ya esta inicializado
		 * @throws Exception cuando ya esta en el primer boton
		 */	
	}
	public void darSiguiente() throws Exception{
		try{
			sintetizador.darSiguienteEfecto();
			Efecto efectoActual=sintetizador.darEfectoActual();
			panelSuperior.actualizar(efectoActual);
			System.out.println(sintetizador.darEfectoActual().darNombre());
			panelInformacion.actualizar(sintetizador.darEfectoActual().darDescripcion()
					, ""+ sintetizador.darEfectoActual().darCalificacion());
		}
		catch (Exception e){
			JOptionPane.showMessageDialog( this, e.getMessage( ), "Ver efecto anterior", JOptionPane.WARNING_MESSAGE );
		}

	}

	/**
	 * Reproduce la nota que esta como parametro
	 * <b>pre:</b> el sintetizador ya esta inicializado
	 * @param pNombreNota, donde pNombreNota!=null, pNombreNota !=""
	 */

	public void reproducir(String pNombreNota){
		sintetizador.reproducir(pNombreNota);
	}

	/**
	 * El boton guardar guarda los efectos demarcados como un parametro, ya sea divertido, fantasia o favorito
	 * <b>pre:</b> el sintetizador ya esta inicializado
	 * @param pDivertidos, donde puede tomar el valor true o false pDivertido!=null.
	 * @param pFantasia, donde puede tomar el valor true o false pFantasia!=null.
	 * @param pFavoritos, donde puede tomar el valor true o false pFavoritos!=null.
	 */

	public void guardar(boolean pDivertidos, boolean pFantasia, boolean pFavoritos){



		sintetizador.guardarEfecto(pFavoritos, pFantasia, pDivertidos);

	}


	/**
	 * Busca el primer efecto. Si no hay ninguno informa al usuario.
	 * <b>pre:</b> el sintetizador ya esta inicializado
	 * @param pNombre, que es el nombre del efecto pNombre!=null, pNombre!="". 
	 * 
	 */
	public void buscarEfecto(){

		String pNombre = JOptionPane.showInputDialog(this, "Introduzca nombre del efecto");

		try{
			sintetizador.buscarPorNombre(pNombre);
			panelSuperior.actualizar(sintetizador.darEfectoActual());
		}catch(Exception e){
			JOptionPane.showMessageDialog( this, "No se encontró ningún efecto con ese nombre", "Buscar por nombre", JOptionPane.ERROR_MESSAGE );

		}


	}

	/**
	 * Busca el primer efecto. Si no hay ninguno informa al usuario.
	 * <b>pre:</b> el sintetizador ya esta inicializado
	 * 
	 */

	public void buscarCalificado(){

		sintetizador.buscarMejorCalificado();
		panelInformacion.actualizar(sintetizador.darEfectoActual().darDescripcion()
				, ""+ sintetizador.darEfectoActual().darCalificacion());

	}

	/**
	 * crea un casillero donde se almacenan todas las notas
	 * <b>pre:</b> el sintetizador ya esta inicializado
	 * @return Notas del sitetizador.
	 * 
	 */


	public Nota[] darNotas(){
		return sintetizador.darNotas();
	}


	/**
	 * Llamado para realizar el método de extensión 1.
	 */

	public void reqFuncOpcion1( )
	{
		String respuesta = sintetizador.metodo1( );
		JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
	}

	/**
	 * Llamado para realizar el método de extensión 2.
	 */
	public void reqFuncOpcion2( )
	{
		String respuesta = sintetizador.metodo2( );
		JOptionPane.showMessageDialog( this, respuesta, "Sarmiento marika", JOptionPane.INFORMATION_MESSAGE );
	}




	public static void main( String[] pArgs )
	{
		try
		{
			// Unifica la interfaz para Mac y para Windows.
			UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );

			InterfazSintetizador interfaz = new InterfazSintetizador( );
			interfaz.setVisible( true );
		}
		catch( Exception e )
		{
			e.printStackTrace( );
		}
	}}