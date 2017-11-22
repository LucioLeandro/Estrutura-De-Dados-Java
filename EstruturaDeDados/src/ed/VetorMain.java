package ed;

import ed.vetor.Aluno;
import ed.vetor.Vetor;

public class VetorMain {
	public static void main(String[] args) {
		Aluno a1 = new Aluno("Joao");
		Aluno a2 = new Aluno("José");
		
		Vetor lista = new Vetor();
		
		lista.adiciona(a1);
		lista.adiciona(a2);
		System.out.println(lista);
	}
}
