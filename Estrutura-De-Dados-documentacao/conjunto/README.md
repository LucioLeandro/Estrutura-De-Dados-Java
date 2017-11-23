# Conjuntos

A ideia dessa estrutura é a mesma do conjunto matemático, onde não temos elementos repetidos, e podemos fazer operações como intersecção, união, e quais elementos estão contidos.

é importante ter em mente, que se não podemos inserir elementos repetidos na lista, a toda tentativa de adição de elemento na lista é preciso verificar se ele este elemento já está contido, e esse é o desafio, pois deveremos ter um método *contains*, que no pior caso varre toda a lista para terminar a sua verificação, e o tempo de execução desse algoritmo é lento, tornando o tempo de execução do método adiciona que antes era constante, em linear.

Para resolver esse problema podemos pensar na seguinte situação :

> Ao entrar em um grande supermercado, é preciso encontrar um sorvete de flocos.
> Para fazer isso da maneira mais rápido, não é preciso percorrer o supermercado inteiro, passando por todos os corredores até encontrar o sorvete.
> Sabemos que os sorvetes, se encontram na seção de congelados, então, vamos diretamente lá.

Então podemos usar essa estratégia, para ter uma melhor implementação do método contains, criando uma espécie de matriz, onde teremos uma lista pra cada seção.  
*Mas como organizar essas listas ?* para este caso usarei a letra inicial como índice, que nesse caso divide a matriz em 26 linhas.

Na implementação criamos, listas de lista.

```
package ed.conjunto

import java.util.LinkedList;
import java.util.List

public class Conjunto {

  private LinkedList<LinkedList<String>> tabela = new LinkedList<LinkedList<String>>();

}
```

podemos criar as 26 listas através do construtor da classe :

```
public class Conjunto {

  private LinkedList<LinkedList<String>> tabela = new LinkedList<LinkedList<String>>();

  public Conjunto() {
      for(int i = 0; i < 26; i++) {
          tabela.add(new LinkedList<String>());
      }
  }

}
```

Obtemos 26 listas, uma para cada letra do alfabeto.<br><br>

### Método calculaIndiceDaTabela


Precisamos criar um método para nos auxiliar a calcular o índice da lista maior, ou a linha da matriz, que vai de 0 a 25.

```
private int calculaIndiceDaTabela(String palavra) {
  return palavra.toLowerCase().charAt(0) % 26;
}
```


Dada uma palavra, conseguimos, assim, calcular o lugar em que ela deve ficar por meio de sua primeira letra.<br><br>

Tal método é muito importante pois é ele que faz o espalhamento dos dados e retorna sempre o mesmo índice para o mesmo conjunto específico de elementos, que possuam , no caso, a mesma letra inicial.

## Métodos adiciona e contem

o método anterior nos auxiliará na implementação do método adiciona e contem :

```
public void adiciona(String palavra) {

    int indice = calculaIndiceDaTabela(palavra);
    List<String> lista = tabela.get(indice);
    lista.add(palavra);
}
```

Garantimos que o elemento não exista na lista, então implementamos o método contem :

```
private boolean contem(String palavra) {
    int indice = calculaIndiceDaTabela(palavra);
    return tabela.get(indice).contains(palavra);
}
```

e no método adiciona fazemos :

```
public void adiciona(String palavra) {
    if(!contem(palavra)) {
        int indice = calculaIndiceDaTabela(palavra);
        List<String> lista = tabela.get(indice);
        lista.add(palavra);
    }
}
```


implementamos também o método toString

```
@Override
public String toString() {
  return tabela.toString();
}
````

### Testando a implementação

Para testar criamos a classe TesteDoConjunto :

```
package ed.conjunto;

import java.util.LinkedList;

public class TesteDeConjunto {

  public static void main(String[] args) {

      Conjunto conjunto = new Conjutno();
      conjunto.adiciona("Lucio");
      System.out.println(conjunto);

      conjunto.adiciona("Lucio");
      System.out.println(conjunto);

      conjunto.adiciona("Leandro");
      System.out.println(conjunto);

      conjunto.adiciona("Geandersonney");
      System.out.println(conjunto);
  }
}
```

Ao rodarmos, percebemos que não temos elementos repetidos, e os elementos inseridos estão organizados em listas de acordo com a primeira letra do nome.<br><br>


### Melhorando a implementação


Nós utilizamos o LinkedList para implementar nosso código, porém conseguimos melhorá-lo ainda mais se mudarmos para o ArrayList, pois sua função que pega um elemento aleatório de uma lista é muito mais rápida. como foi visto nos estudos anteriores,

Então façamos essa mudança:

```
private ArrayList<LinkedList<String>> tabela = new ArrayList<LinkedList<String>>();
```

### Método remove

Implementar o remove é fácil, verificamos se o elemento esta na lista, para fazer essa verificação calculamos o indice, e pesquisamos diretamente na lista correta, e caso conste na lista, o excluimos.

```
public void remove(String palavra) {
    if(contem(palavra)) {
        int indice = calculaIndiceDaTabela(palavra);
        List<String> lista = tabela.get(indice);
        lista.remove(palavra);
    }
}
```


### Set


no Java a estrutura de conjuntos é o *Set* e sua implementação o *HashSet*

```
Set<String> conjuntoDoJava = new HashSet<String>();
```
Essa implementação utiliza o método *hashCode*, da classe Object do java, e então faz o espalhamento dos elementos em seções.
