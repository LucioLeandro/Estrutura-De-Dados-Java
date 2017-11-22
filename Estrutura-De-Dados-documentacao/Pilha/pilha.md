<h1>Pilhas</h1>

Nos estudos anteriores aprendi sobre listas, onde as mesmas tem referencias para o próximo elemento, e também para o elemento anterior, sendo ótimas para operações onde inserimos elementos no meio da estrutura. Também vi que o Java possui isso implementado por meio da classe LinkedList. <br><br>

Nesse estudo vi uma outra estrutura de dados, chamada pilha. Essa estrutura, tem a característica de guardar diversos estados de uma aplicação, para que se necessário seja possível voltar a estados anteriores.<br><br>

Essa estrutura é do tipo LIFO (last-in first-out), ou seja, o ultimo elemento inserido, é o primeiro elemento a sair. <br>
Diferente das estruturas anteriormente vistas, nessa estrutura, não realizamos operações de inserir, ou remover no meio da estrutura.<br><br>

Tomamos como exemplo uma pliha de pratos, onde o primeiro prato é o que esta na base, e o ultimo prato é o que está no topo, desta forma, para pegarmos o primeiro prato, isto é, o que esta na base, precisamos desempilhar todos os pratos do topo, até que o prato que desejamos, se torne o prato do topo.
Esta é a ideia da pilha.<br<br>


<h3>Implementação</h3>


```
package ed.pilha

public class Pilha {

  public void insere(String nome) {

  }

  public String remove() {
      return "";
  }

  public boolean vazia() {
      return false;
  }
}
```


Estas são as operações que realizamos com uma pilha, onde as principais são, inserir e remover.<br><br>

Lembrando que a pilha segue a regra de inserção de um elemento após o outro e a remoção funciona da mesma forma, sendo que do ultimo elemento até o primeiro.



Para implementar essa estrutura, não é preciso começar do zero, pode-se usar a implementação da classe LinkedList própria do java, ou a implementação de listas, feitas anteriormente nesse estudo.



Usarei a LinkedList.

```
package ed.pilha

import java.util.LinkedList;
import java.util.List;

public class Pilha {

private List<String> nomes = new LinkedList<String>();

...

```
Também implementei o *toString* na classe, onde chamo o toString da classe LinkedList



```
@Override
public String toString() {
  return nomes.toString();
}
```

### Método insere


Implementar este método utilizando o conceito de pilha é bem simples. Já que seguiremos sempre a ordem de inserirmos um elemento apóes o outro basta fazermos :


```
public void insere(String nome) {
  nomes.add(nome);    
}
```


passamos o próximo elemento como parâmetro do método add, que faz exatamente isso, insere o elemento na próxima posição após o ultimo elemento.  

### Método remove

Também é muito simples implementar este método, basta chamar o método remove do LinkedList passando o index do ultimo elemento que é *nomes.size()-1*:  

```
public String remove() throws Exception {
  if(this.vazia()) {
    throw new Exception("A lista está vazia");
  }
  return nomes.remove(nomes.size()-1);
}
```



### Método vazia


Assim como nas outras estruturas, implementamos esse método para verificar se há ou não elementos na estrutura.  

Podemos fazer de duas formas :

```
public boolean vazia() {
  return nomes.size() == 0;
}
```

ou

```
public boolean vazia() {
  return nomes.isEmpty();
}
```




Nessa estrutura chamamos o método inserir, ou empilhar de * **Push** *  
E o método remove ou desempilhar de * **Pop** *  



Desta forma, trocamos os nomes dos métodos na classe pilha, teremos :

```
package ed.pilha;

import java.util.LinkedList;
import java.util.List;

public class Pilha {

	private List<String> nomes = new LinkedList<>();

	public void push(String nome) {
		nomes.add(nome);
	}

	public String pop() {
		return nomes.remove(nomes.size() - 1);
	}

	public boolean vazia() {
		return nomes.isEmpty();
	}

	public String toString() {
		return this.nomes.toString();
	}
}
```

ainda temos outro método, que não foi implementado, É o método Peek


###Método Peek

Como vimos, o pop remove o último elemento da pilha. O método peek trabalha em cima desse elemento também, porém sem removê-lo. Ele apenas o retorna. Se temos, então, a pilha




O java também possue em sua biblioteca a implementação de uma pilha, por meio da classe *STACK*


###Usabilidade das Pilhas

O conceito de pilhas é muito utilizado por compiladores e autômatos. Esta estrutura de dados tem muita usabilidade em ciências da computação. O próprio, e muito conhecido, comando "Desfazer" dos editores de texto, de código, de imagens, etc tem como base as pilhas. Podemos também brincar com palavras e inverter a ordem de suas letras utilizando as pilhas.
