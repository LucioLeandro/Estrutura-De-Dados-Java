package ed.lista_ligada;

public class Aluno {
		private String nome;
		private Aluno proximo;
		
		
		public Aluno(String nome, Aluno proximo) {
			this.nome = nome;
			this.proximo = proximo;
		}
		
		
		
		public Aluno getProximo() {
			return proximo;
		}
		
		public String getNome() {
			return nome;
		}
		
		public void setProximo(Aluno aluno) {
			
		}
		
		@Override
		public String toString() {
		return nome;
		}
		
		public boolean equals(Aluno aluno) {
			return this.getNome().equals(aluno.getNome());
		}
}
