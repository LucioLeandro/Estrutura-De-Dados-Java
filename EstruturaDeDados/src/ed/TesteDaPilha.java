package ed;

import ed.pilha.Pilha;

public class TesteDaPilha {
	public static void main(String[] args) {
		Pilha pilha = new Pilha();
		
		pilha.push("L�cio");
		
		System.out.println(pilha);
		
		pilha.push("Leandro");
		
		System.out.println(pilha);
	}
}
