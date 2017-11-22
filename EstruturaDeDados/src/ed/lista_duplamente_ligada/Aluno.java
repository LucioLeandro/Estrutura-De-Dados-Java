package ed.lista_duplamente_ligada;


public class Aluno {
	private String nome;
	private Aluno proximo;
	private Aluno anterior;
	
	
	public Aluno(String nome, Aluno proximo) {
		this.nome = nome;
		this.proximo = proximo;
	}
	
	public Aluno(String nome) {
		this(nome, null);
	}
	
	public Aluno getProximo() {
		return proximo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setProximo(Aluno aluno) {
		
	}
	
	public Aluno getAnterior() {
		return anterior;
	}
	
	public void setAnterior(Aluno anterior) {
		this.anterior = anterior;
	}
	
	@Override
	public String toString() {
	return nome;
	}
	
	public boolean equals(Aluno aluno) {
		return this.getNome().equals(aluno.getNome());
	}
}
