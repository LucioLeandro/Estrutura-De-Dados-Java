package ed.lista_duplamente_ligada;

import ed.lista_duplamente_ligada.Aluno;

public class ListaDuplamenteLigada {
	private Aluno primeiro = null;
	private Aluno ultimo = null;
	private int totalDeElementos = 0;
	
	
	public void adicionaNoComeco(String nome) {
		if(totalDeElementos == 0) {
			Aluno novo = new Aluno(nome);
			this.primeiro = novo;
			this.ultimo = novo;
		} else {
			Aluno novo = new Aluno(nome, this.primeiro);
			this.primeiro.setAnterior(novo);
			this.primeiro = novo;
		}
		this.totalDeElementos++;
	}
	
	public void adiciona(String nome) {
		
		if(totalDeElementos == 0) {
			this.adicionaNoComeco(nome);
		} else {
			Aluno novo = new Aluno(nome);
			this.ultimo.setProximo(novo);
			novo.setAnterior(this.ultimo);
			this.ultimo = novo;
			this.totalDeElementos++;
		}
		
		
	}
	
	private Aluno pega(int posicao) throws IllegalArgumentException {
			this.posicaoEhValida(posicao);
			
			Aluno atual = this.primeiro;
			for(int i = 0; i <= posicao; i++) {
				atual = atual.getProximo();
			}
			
			return atual;
	}
	
	public void adiciona(int posicao, String nome) throws IllegalArgumentException {
		this.posicaoEhValida(posicao);
		
		if(posicao == 0) {
			this.adicionaNoComeco(nome);
		} else if(posicao == this.totalDeElementos) {
			this.adiciona(nome);
		} else {
			Aluno anterior = pega(posicao - 1);
			Aluno novo = new Aluno(nome, anterior.getProximo());
			Aluno proxAnterior = anterior.getProximo();
			novo.setAnterior(anterior);
			anterior.setProximo(novo);
			proxAnterior.setAnterior(novo);
			
			this.totalDeElementos++;
		}
	}
	
	private void posicaoEhValida(int posicao) throws IllegalArgumentException {
		if(posicao > totalDeElementos) {
			throw new IllegalArgumentException("Posição inválida");
		}
		
	}

	
	public void remove() throws IllegalArgumentException {
		if(this.totalDeElementos == 0) {
			throw new IllegalArgumentException("Lista vazia");
		}
		this.primeiro = this.primeiro.getProximo();
		this.totalDeElementos--;
	}
	

	
	public void remove(int posicao) throws IllegalArgumentException {
		this.posicaoEhValida(posicao);
		
		if(posicao == 0) {
			this.remove();
		} else if (posicao == totalDeElementos - 1) {
			this.removeDoFim();
		} else {
			Aluno anterior = pega(posicao - 1);
			Aluno atual = anterior.getProximo();
			Aluno proximo = atual.getProximo();
			
			anterior.setProximo(atual.getProximo());
			proximo.setAnterior(atual.getAnterior());
			this.totalDeElementos--;
		}
				
	}
	
	
	public void removeDoFim() {
		if(this.totalDeElementos == 1) {
			this.remove();
		} else {
			Aluno penultimo = this.ultimo.getAnterior();
			penultimo.setProximo(null);
			this.totalDeElementos--;
		}
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
