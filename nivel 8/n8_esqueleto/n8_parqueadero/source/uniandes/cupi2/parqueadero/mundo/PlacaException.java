package uniandes.cupi2.parqueadero.mundo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class PlacaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	    // -----------------------------------------------------------------
		// Atributos
		// -----------------------------------------------------------------
	/**
	 * Placa del carro.
	 */
	private String placa;
	
	 /**
	 * mensaje exception;
	 */
	private String mensaje;
	
	
	// -----------------------------------------------------------------
		// Constructores
		// -----------------------------------------------------------------

		/**
		 * Placa Exception
		 * @param pPlaca Placa del carro. pPlaca != null && pPlaca != "".
		 * @param pMensaje Mensaje del carro. pMensaje != null && pMensaje != "".
		 * <b>post: </b> Se creó un carro con la información recibida por parámetro de su placa, marca, modelo y hora de ingreso al parqueadero.
		 */
		public PlacaException( String pPlaca, String pMensaje ){
			super(pMensaje);
			placa=pPlaca;
			mensaje=pMensaje;
			
			
		}
		public void escribirLog() throws IOException{
			FileWriter archivo;
			try{
				archivo=new FileWriter("./data/logError.txt");
				PrintWriter escritor = new PrintWriter(archivo);
				Date fecha=new Date();
				escritor.println("ERROR@"+fecha.toString()+"Error en la salida de datos");
				escritor.close();
				
				
			}
			catch(IOException e){
				e.printStackTrace();
			}
		
			
			
		}
			
			
		}


