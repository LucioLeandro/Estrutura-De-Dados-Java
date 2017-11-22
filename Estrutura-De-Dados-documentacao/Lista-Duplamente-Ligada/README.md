<h1>Lista Duplamente Ligada</h1>

No estudo anterior, vi a respeito de *Listas Ligadas*, cuja ideia, é de que um elemento, está ligado ao próximo elemento dentro do Array, desta forma melhorando a implementação e ganhando velocidade na inserção de novos elementos na lista.<br><br>

Apesar de ter implementado o método Remove (em qualquer posição no meio), na Lista Ligada, vi na Lista Duplamente Ligada uma implementação ainda melhor, pois, na Lista Duplamente Ligada (ou Lista duplamente encadeada), os elementos não apontam somente para o seu próximo elemento, mas também para o elemento anterior.

![Lista Duplamente Ligada](http://www.monzy.com/intro/doublell.jpg)

<br><br>

```
public class Aluno {
		private String nome;
		private Aluno proximo;

    ................

```

E também na classe, escrevi o getter e o setter para o novo atributo.<br>

````
private Celula anterior;



public Celula getAnterior() {
    return anterior;
}

public void setAnterior(Celula anterior) {
    this anterior = anterior;
}
````
<h3>Método adicionaNoComeco</h3>

Reescrevi o método feito na Lista Ligada

```
public void adicionaNoComeco(Object elemento) {
  if(this.totalDeElementos == 0) {
      Celula nova = new Celula(elemento);
      this.primeira = nova;
      this.ultima = nova;
  } else {
      Celula nova = new Celula(this.primeira, elemento);
      this.primeira.setAnterior(nova);
      this.primeira = nova;
  }
  this.totalDeElementos++;
}
```

Neste método adicionei o novo comportamento, e sempre que um novo aluno é adicionado, seto o anterior e o próximo aluno do mesmo. <br><br>

<h3>Método adiciona(no fim)</h3>

Muito parecido com o método que expliquei anteriormente, com a diferença de settar apenas o aluno anterior.<br>

-Criamos uma nova célula.
-A última foi apontou a próxima para essa nova célula.
-A nova aponta a anterior para a última atual.
-A última atual agora é a nova célula.

<h3>Método adiciona(em qualquer posição)</h3>

Com a implementação dessa estrutura, para adicionarmos no meio da lista é muito simples, bata que naveguemos pela lista até a posição desejada, e organize as suas setas.

```
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
```

<h3> Método remove(do fim)</h3>


Para removermos o elemento do fim, precisamos da penúltima elemento, que está ligada a ele, porém se existir apenas um elemento da lista basta chamar o método que adiciona no começo :

```
public void removeDoFim() {
		if(this.totalDeElementos == 1) {
			this.remove();
		} else {
			Aluno penultimo = this.ultimo.getAnterior();
			penultimo.setProximo(null);
			this.totalDeElementos--;
		}
	}
```
<h3> Método remove(de qualquer posição)</h3>


Começo já verificando se a posição é a primeira ou a ultima, assim, posso já chamar métodos que são eficientes

```
public void remove(int posicao) {
  if(posicao == 0) {
      this.remove(); // do começo
  } else if (posicao == this.totalDeElementos - 1) {
      this.removeDoFim();
  }
}
```

Depois implementei, o algoritmo responsável para remover um elemento do meio, nesse caso um aluno.

```
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
```
