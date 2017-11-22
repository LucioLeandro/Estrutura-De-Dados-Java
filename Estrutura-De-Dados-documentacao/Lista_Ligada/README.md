<h1>Lista Ligada</h1>

Estudando armazenamento sequencial em Vetores, vi que trata-se de uma boa estrutura de dados para casos como. <br>

- Adicionar elementos no fim do Vetor
- buscar um elemento aleatório com a posição pré-definida
- remover um elemento em uma posição pré-definida.

isto, pois seus algoritmos levam tempo constante para se chegar ao resultado. <br>
Porém outros métodos já não eram tão simples, como : <br>

- Inserir um elemento no meio do Vetor
- Remover no meio do Vetor

Essas são atividades computacionalmente caras, com processo de execução lento.<br>
Devido a isso, estudei uma outra lista, afim de melhorar o código, para que essa adição e remoção no meio do *Array* seja um processo mais rápido.

Para isso, implementei a * **Lista Ligada** * ou * ** Lista Encadeada ** * <br>

A diferença dela para o Vetor é que neste os elementos estão um do lado do outro na memória, enquanto que na Lista Ligada eles estão em lugares diferentes, porém um aponta para o outro indicando o próximo.

<img src="https://www.ime.usp.br/~pf/algoritmos/aulas/img/linked-list.jpg" alt="exemplo lista encadeado"/>

![exemplo lista encadeada](https://www.ime.usp.br/~pf/algoritmos/aulas/img/linked-list.jpg)

Para implementar a estrutura na qual um elemeto também conhecerá o endereço do próximo, criei uma nova classe Aluno, que possuirá uma String nome, e o Aluno seguinte.


```
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


```


E também criei a classe "ListaLigada" e implementei suas funções <br>

```
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

```


<h3>Método Adiciona (no começo da lista)</h3>

A classe desde o começo tem seu atributo "primeira" apontando para null quando está vazia, e ao ser inserido um novo objeto Aluno, setamos este atributo apontando para esse novo aluno inserid. Pensando na implementação de outros métodos, também criei o atributo ultima, que guarda a ultimo aluno, ou seja, o primeiro elemento da lista, também será o ultimo, isto para que outros métodos possam ser implementados com algoritmos de tempo constante.<br><br>


<h3>Método adiciona (no fim da lista)</h3>

Para Listas Ligadas, este método é um pouco mais complexo. O que nos diz se um elemento é o último do array é se ele apontar para um null. Para isso é necessário varrer toda a lista. resolvi este problema criando uma seta para o ultimo elemento, como expliquei no método anterior.

Para finalizar, criei o novo aluno apontando para null, e fiz com que o ultimo elemento apontasse para o novo aluno tornando-o ultimo. E incrementei a variável que armazena o numero total de alunos.<br><br>

<h3>Método Adiciona (no meio da lista)</h3>

Para implementar esse método, criei outros dois métodos auxiliar, um irá indicar quando a posição existir, estando ocupada. E o outro apontará para o aluno no qual queremos inserir o próximo. <br><br>

Imaginemos agora, mais uma vez, que já possuímos uma lista onde um elemento aponta para o outro. O elemento da esquerda deve apontar para o novo, e este para o da direita. Então, em código, fazemos:

```
public void adiciona(int posicao, Aluno aluno) {

  Aluno anterior = this.pega(posicao - 1);
  Aluno nova = new Aluno(aluno.getNome(), anterior.getProximo();
}
```

Dessa forma pegamos a Célula da esquerda (anterior) e a nova no lugar da próxima (anterior.getProximo). Por fim, basta fazer com que a anterior seja a nova e somar 1 no total de elementos: <br>

```
public void adiciona(int posicao, Aluno aluno) {

    Aluno anterior = this.pega(posicao - 1);
    Aluno nova = new Aluno(aluno.getNome(), anterior.getProximo();
    anterior.setProximo(nova);
    this.totalDeElementos++;
}
```

Depois implementei o método para inserir, caso a lista esteja vazia. Na verdade não é preciso, basta verificar se a lista está vazia, e caso ela esteja, chamamos o método adiciona (no começo)<br>

```
public void adiciona(int posicao, Aluno aluno) {

    if(posicao == 0) {
        adicionaNoComeco(elemento);
    } else if (posicao == this.totalDeElementos) {
        adiciona(elemento);
    } else {
        Aluno anterior = this.pega(posicao - 1);
        Aluno nova = new Aluno(aluno.getNome(), anterior.getProximo();
        anterior.setProximo(nova);
        this.totalDeElementos++;
}
```
<h3>Método Remove (do começo)</h3>

Para implementar esse método é bem simples, antes de tudo, verifico se a lista está vazia, e caso esteja lanço uma Exception, caso contrário, é só eu fazer com que o atributo "primeiro" que aponta para o primeiro objeto, aponte para o próximo objeto após ele, já que o proprio objetom, guarda o proximo.
e por fim decremento a variável totalDeAlunos.
<br><br>


<h3>Método Remove (do meio)</h3>


Apesar de eu ter aqui implementado o método, para remover um elemento que esá no meio da lista, é mais trabalhoso, então implementarei uma solução melhor com o estudo da próxima estrutura de dadosm que é a Lista **Duplamente** Liagada.
