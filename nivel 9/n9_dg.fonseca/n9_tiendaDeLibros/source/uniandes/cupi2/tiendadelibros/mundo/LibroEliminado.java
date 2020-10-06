package uniandes.cupi2.tiendadelibros.mundo;

public class LibroEliminado 
{
	private String tituloLibro;

	private LibroEliminado anterior;

	private LibroEliminado siguiente;

	private LibroEliminado primerLibroEliminado;


	public LibroEliminado(String pTitulo)
	{
		tituloLibro=pTitulo;
		anterior=null;
		siguiente=null;
		primerLibroEliminado=null;

	}
	public LibroEliminado darAnterior(){
		return anterior;
	}
	public LibroEliminado darSiguiente(){
		return siguiente;
	}
	public String darTituloLibro()
	{
		return tituloLibro;
	}
	public void cambiarAnterior(LibroEliminado pLibro)
	{
		anterior=pLibro;

	}
	public void cambiarSiguiente( LibroEliminado pLibro)
	{
	
	siguiente=pLibro;	
		
	}
	
	public void desconectarSiguiente(){
		siguiente=siguiente.siguiente;
	}
	
	public int compararPorTitulo( Libro pLibro )
	{
		int comparacion = tituloLibro.compareTo( pLibro.darTitulo( ) );
		
		 if( comparacion > 0 )
		{
			comparacion = 1;
		}
		else
		{
			comparacion = -1;
		}
		return comparacion;
	}
	
	public LibroEliminado localizarUltimo()
	{
		LibroEliminado actual=primerLibroEliminado;
		if(actual!=null)
		{
			while(actual.darSiguiente()!=null){
				actual=actual.darSiguiente();
			}

		}
		return actual;
	}





}

