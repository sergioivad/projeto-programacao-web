package entidade;

public abstract class Item {
	
	private int codigo;
	private String titulo;
	private int quantMax;
	private TipoItem tipoItem;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public TipoItem getTipoItem() {
		return tipoItem;
	}

	public void setTipoItem(TipoItem tipoItem) {
		this.tipoItem = tipoItem;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return titulo;
	}

	public void setNome(String nome) {
		this.titulo = nome;
	}

	public int getQuantMax() {
		return quantMax;
	}

	public void setQuantMax(int quantMax) {
		this.quantMax = quantMax;
	}

}