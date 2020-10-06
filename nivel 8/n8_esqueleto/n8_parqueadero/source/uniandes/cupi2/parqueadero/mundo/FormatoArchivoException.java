package uniandes.cupi2.parqueadero.mundo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class FormatoArchivoException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

	/**
	 * Exception del formato
	 * @param pCausa Causa exception del carro. pCausa != null && pCausa != "".
	 * <b>post: </b> Se cargo el formato del achivo del parqueadero-
	 */
	public FormatoArchivoException(String pCausa) 
	{
		super(pCausa);
	
		
		
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
