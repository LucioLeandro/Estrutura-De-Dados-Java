package ed.lista_ligada;

public class ListaLigada {
	
	private Aluno primeiro = null;
	private Aluno ultimo = null;
	private int totalDeElementos = 0;
	
	
	public void adicionaNoComeco(String nome) {
		Aluno novo = new Aluno(nome, primeiro);
		this.primeiro = novo;
		
		if(this.totalDeElementos == 0) {
			this.ultimo = this.primeiro;
		}
		this.totalDeElementos++;
	}
	
	public void adiciona(String nome) {
		
		if(totalDeElementos == 0) {
			this.adicionaNoComeco(nome);
		} else {
			Aluno novo = new Aluno(nome,null);
			this.ultimo.setProximo(novo);
			this.ultimo = novo;
			this.totalDeElementos++;
		}
		
		
	}
	

	
	public void adiciona(int posicao, Aluno aluno) throws IllegalArgumentException {
		this.posicaoEhValida(posicao);
		
		if(posicao == 0) {
			this.adicionaNoComeco(aluno.getNome());
		} else if(posicao == this.totalDeElementos) {
			this.adiciona(aluno.getNome());
		} else {
			Aluno atual = pega(posicao - 1);
			Aluno proximo = atual.getProximo();
			
			aluno.setProximo(proximo);
			atual.setProximo(aluno);
			
			this.totalDeElementos++;
		}
		
	}
	
	private void posicaoEhValida(int posicao) throws IllegalArgumentException {
		if(posicao > totalDeElementos) {
			throw new IllegalArgumentException("Posição inválida");
		}
		
	}
	
	public Aluno pega(int posicao) throws IllegalArgumentException {
			this.posicaoEhValida(posicao);
			
			Aluno atual = this.primeiro;
			for(int i = 0; i <= posicao; i++) {
				atual = atual.getProximo();
			}
			
			return atual;
	}
	
	public void remove() throws IllegalArgumentException {
		if(this.totalDeElementos == 0) {
			throw new IllegalArgumentException("Lista vazia");
		}
		this.primeiro = this.primeiro.getProximo();
	}
	

	
	public void remove(int posicao) throws IllegalArgumentException {
		this.posicaoEhValida(posicao);
		Aluno anterior = pega(posicao - 1);
		Aluno atual = pega(posicao);
		
		anterior.setProximo(atual.getProximo());
		
		this.totalDeElementos--;
		
	}
	
	public boolean contem(Aluno aluno) {
		Aluno atual = this.primeiro;
		
		for(int i = 0; i < this.totalDeElementos; i++) {
			if(atual.equals(aluno)) {
				return true;
			}
			
			atual = atual.getProximo();
		}
		return false;
	}
	
	public String toString() {
		if(this.totalDeElementos == 0) {
			return "[]";
		}
		
		Aluno atual = primeiro;
		
		StringBuilder sb = new StringBuilder("[");
		
		for(int i = 0; i < this.totalDeElementos; i++) {
			sb.append(atual.getNome() + ",");
			atual = atual.getProximo();
		}
		
		sb.append("]");
		
		return sb.toString();
	}
		

}
