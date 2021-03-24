package usuario;

public class Usuario implements Comparable<Usuario>{
	
	private String nome;
	private String senha;
	private int id;
	private int pontos;
	
	// Constructor
	
	
	

	public Usuario(String nome, String senha) {
		
		this.nome = nome;
		this.senha = senha;
		this.id = Contador.getInstancia().getIdUnico();
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		
		return id;
	}
	
	public String getNome(String usuarioLogado) {
		return nome;
	}
	
	public  String getSenha() {
		return senha;
	}
	
	public int getPontos() {
		return pontos;
	}

	public  void setPontos(int pontos) {
		this.pontos += pontos;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.nome + " " + this.senha + " " + this.id + " " + this.pontos + " ";
	}

	@Override
	public int compareTo(Usuario u) {
		
		return this.pontos - u.getPontos();
	}

	
}
