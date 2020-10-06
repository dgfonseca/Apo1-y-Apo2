package uniandes.cupi2.parqueadero.mundo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class EstadoParqueaderoException extends Exception {
	 // -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------
	
	private static final String LLENO = "Parqueadero lleno";
	private static final String CERRADO = "Parqueadero Cerrado";
	private static final String INGRESAR_CARRO = "ingresar";
	private static final String SACAR_CARRO = "sacar";
	
	 // -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------
	private String placaSinIngresar;
	private String motivo;
	private String accion;
	/**
	 * Placa Exception
	 * @param pPlaca Placa del carro. pPlaca != null && pPlaca != "".
	 * @param pMotivo Mensaje del carro. pMensaje != null && pMensaje != "".
	 * <b>post: </b> Se creó un carro con la información recibida por parámetro de su placa, marca, modelo y hora de ingreso al parqueadero.
	 */
	public EstadoParqueaderoException(String pMotivo, String pPlaca, String pAccion) 
	{
		super(pMotivo);
		placaSinIngresar=pPlaca;
		accion=pAccion;
		motivo=pMotivo;
		
		
	}
	public void escribirLog(){
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


