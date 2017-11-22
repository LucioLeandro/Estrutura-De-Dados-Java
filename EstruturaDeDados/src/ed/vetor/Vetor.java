package ed.vetor;

import java.util.Arrays;

public class Vetor {
	private int totalAlunos = 0;
	private Aluno[] alunos = new Aluno[100];
	
	public void adiciona(Aluno aluno) {
		this.garanteEspaco();
		this.alunos[totalAlunos] = aluno;
		totalAlunos++;
	}
	
	private boolean posicaoValida(int  position) {
		return position >= 0 && position <= totalAlunos;
	}
	
	public void adiciona(int position, Aluno aluno) {
		this.garanteEspaco();
		if(!posicaoValida(position)) {
			throw new IllegalArgumentException("posição não é válida");
		}
		
		for(int i = totalAlunos -1; i >= position; i--) {
			this.alunos[i+1] = this.alunos[i];
		}
		
		this.alunos[position] = aluno;
	}
	
	private boolean posicaoOcupada(int position) {
		return position >=0 && position <= this.totalAlunos;
	}
	public Aluno pega(int position) throws IllegalArgumentException {
		
		if(!posicaoOcupada(position)) {
			throw new IllegalArgumentException("Posicao invalida"); 
		}
		return this.alunos[position];
	}
	
	public void remove(int position) {
		for(int i = position; i < this.totalAlunos - 1; i++) {
			this.alunos[i] = this.alunos[i+1];
		}
		totalAlunos--;
	}
	
	public boolean contem(Aluno aluno) {
		for(int i = 0; i < this.totalAlunos; i++) {
			if(this.alunos[i].equals(aluno) ) {
				return true;
			}
		}
		return false;
	}
	
    private void garanteEspaco() {
	    if(totalAlunos == alunos.length) {
	        Aluno[] novoArray = new Aluno[alunos.length*2];
	        for(int i = 0; i < alunos.length; i++) {
	            novoArray[i] = alunos[i];
	        }
        this.alunos = novoArray;
	    }
    }
	
	public int tamanho() {
		return totalAlunos;
	}
	
	public String toString() {
		return Arrays.toString(alunos);
	}
	
}
