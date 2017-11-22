package ed.fila;

import java.util.LinkedList;
import java.util.List;

public class Fila {
	List<String> alunos = new LinkedList<>();
	
	
	public void add(String aluno) {
		alunos.add(aluno);
	}
	
	
	public String poll() throws Exception {
		if(this.vazia()) {
			throw new Exception("A lista está vazia");
		}
		return alunos.remove(0);
	}
	
	
	public boolean vazia() {
		return alunos.isEmpty();
	}
	
	@Override
	public String toString() {
		return alunos.toString();
	}
}
