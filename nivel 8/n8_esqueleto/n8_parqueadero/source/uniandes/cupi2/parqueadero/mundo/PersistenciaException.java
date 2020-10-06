package uniandes.cupi2.parqueadero.mundo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class PersistenciaException extends Exception {
	
    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Construye la excepción con el mensaje que se pasa como parámetro y que describe la causa del problema
     * @param causa el mensaje que describe el problema
     */
    public PersistenciaException( String causa )
    {
        super( causa );
    }
	public void escribirLog() {
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
