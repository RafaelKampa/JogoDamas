package usuario;
//singleton class  
public final class Contador {

	private static Contador INSTANCIA;

	private int ultimoId;

	private Contador() {
		ultimoId = 0;
	}

	public static Contador getInstancia() {
		// primeira vez inicializa instancia.
		if (INSTANCIA == null) {
			INSTANCIA = new Contador();
		}
		return INSTANCIA;
	}

	public int getIdUnico() {
		//retorna id e depois incrementa.
		return ultimoId++;
	}

	
}