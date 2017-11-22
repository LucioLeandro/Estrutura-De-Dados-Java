package ed.vetor;

public class Aluno {
	
	private String nome;
	public Aluno(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public boolean equals(Aluno aluno) {
		return this.getNome().equals(aluno.getNome());
	}
	
	
	public String toString() {
		return nome;
	}
	
	
}
