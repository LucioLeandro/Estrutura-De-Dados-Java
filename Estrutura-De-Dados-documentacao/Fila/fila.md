#Fila

Neste estudo aprendi sobre * **FILAS** * , uma estrutura de dados que se assemelha muito com a pilha, porém, ela é uma estrutura de tipo ** *FIFO (First-in, first-out) * ** , ou seja, o primeiro elemento inserido, é o primeiro a sair.



De Maneira análoga, numa fila de um banco, o primeiro cliente da fila, é o primeiro cliente a ser atendido.



Assim como fiz, pra implementar uma pilha, não começarei do zero, e usarei a classe *LinkedList* por debaixo dos panos.



```
package ed.fila;

import java.util.LinkedList;
import java.util.List;

public class Fila {

  private List<String> alunos = new LinkedList<String>();

  //métodos
}
```


E o toString

 ```
 @Override
public String toString() {
    return alunos.toString();
}
 ```


###Método adiciona


Este método funciona igualmente ao da pilha.

```
public void adiciona(String aluno) {
  alunos.add(aluno);
}
```



###Método Remove

É neste método que está a grande diferença. Na estrutura Fila, o elemento a ser removido sempre estará na primeira posição, então :


```
public String remove() throes Exception {
  if(this.vazia()) {
    throw new Exception("A lista está vazia");
  }
  return alunos.remove(0);
}
```


###Método vazia

Aqui não tem segredo


```
public boolean vazia() {
  return alunos.isEmpty();
}
```

###Queue

Assim como o java tem sua implementação de Pilha, Stack, à estrutura de Fila damos o nome *Queue*, implementamos da seguinte forma:  

```
  Queue<String> filaDoJava = new LinkedList<String>();
```

Para as filas os métodos tem o seguinte nomes

-add para adicionar
-poll para remover


```
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

```
