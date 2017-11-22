<h1>Vetor</h1>


Aprimeira estrutura que vou implementar é o * **Armazenamento Sequencial** * vetor, ou Array.
<br><br>

Para isso criarei a classe Vetor na qual implementaremos a estrutura de Armazenamento Sequencial
<br><br>

Nele implementei um Array e implementei os métodos para manipulação desse Array.

<br><br>

<code>
	
import java.util.Arrays;

public class Vetor {

    private Aluno[] alunos = new Aluno[1];
    private int totalDeAlunos = 0;


    public void adiciona(Aluno aluno) {
        this.garanteEspaco();
        this.alunos[totalDeAlunos] = aluno;
        totalDeAlunos++;
    }


    private boolean posicaoValida(int posicao) {
    	return posicao >= 0 && posicao <= totalDeAlunos;
	}


    public void adiciona(int posicao, Aluno aluno) {

	    if(!posicaoValida(posicao)) {
	        throw new IllegalArgumentException("posicao invalida");
	    }

	    for(int i = totalDeAlunos - 1; i >= posicao; i-=1) {
	        alunos[i+1] = alunos[i];
	    }

	    alunos[posicao] = aluno;
	    totalDeAlunos++;
	}

    private boolean posicaoOcupada(int posicao) {
    	return posicao >= 0 && posicao < totalDeAlunos;
	}

    public Aluno pega(int posicao) {
        //recebe uma posição e devolve o aluno
        if(!posicaoOcupada) {
        	throw new IllegalArgumentException("Posição inválida");
        }
        return this.alunos[posicao];
    }

    public void remove(int posicao) {
	    for(int i = posicao; i < this.totalDeAlunos; i++) {
	        this.alunos[i] = this.alunos[i+1];
	    }
	    totalDeAlunos--;
	}

    public boolean contem(Aluno aluno) {
        for(int i = 0; i < totalDeAlunos; i++) {
            if(aluno.equals(alunos[i])) {
                return true;
            }
        }
        return false; 
    }


    private void garanteEspaco() {
	    if(totalDeAlunos == alunos.length) {
	        Aluno[] novoArray = new Aluno[alunos.length*2];
	        for(int i = 0; i < alunos.length; i++) {
	            novoArray[i] = alunos[i];
	        }
        this.alunos= novoArray;
    }

}

    public int tamanho() {
        //devolve a quantidade de alunos
        return this.totalDeAlunos;
    }

    public String toString() {
        //facilitará na impressão
        return Arrays.toString(alunos);
    }
}
</code>



<h3>Método adiciona</h3>

O primeiro métoro "adiciona" simplesmente recebe um aluno como parâmetro e armazena na ultima posição livre.<br>
Para verificar a posição livre basta varrer o array até encontrar a primeira opção a apontar para *null*<br>
porém isso é um pouco custoso pois é um algoritmo O(n), desta forma, usei uma variável que armazena a quantidade de alunos contidos no array, que consequentemente é a proxima posição livre. Incremento a cada adição<br><br>

Também implementei um método auxiliar, que é o método privado "garanteEspaco", então quando o método é chamado, ele garante que haja espaço para que seja feito o armazenamento.<br><br>

<h3>Método adiciona (2)</h3>


O segundo método "adiciona" recebe como parâmetro o aluno a ser armazenado e a posição em que ele deve ser armazenado, considerando que o usuário saiba que a primeira posição é a posição "0".<br>
Neste método a complexidade é maior, pois quando inserimos no meio do array, precisamos reorganizar todos elementos do vetor a partir da posição a qual o novo aluno será armazenado, onde o melhor caso é quando a posição passada por parâmetro é a ultima<br>

Neste método temos mais um método auxiliar privado que eh *posicaoVAlida* apenas para validar a posição passada no parâmetro. 
<br><br>

<h3>Método pega</h3>

O método pega, é responsável por buscar e retornar um elemento, nesse caso , aluno, na posição passada por parâmetro.<br>
Possui um algoritmo simples de tempo constante. TAmbém usa o método auxiliar para verificar se a posição passada por parâmetro está ocupada.
<br><br>

<h3>Método Remove</h3>


O método remove, deleta um elemento(aluno) na posição passada por parâmetro. no que diz respeito a deletar o elemento, leva um tempo constante, porém esse método, assim como o segundo método adiciona, precisa reorganizar seus elementos dentro da estrutura, o que é O(n), onde o melhor caso é quando o elemento a ser removido está na ultima opção.
<br><br>

<h3>Método contem</h3>

O método contem possui um algoritmo simples que varre a estrutura até que seja o elemento passado por parâmetro, é um algoritmo o(n), onde o melhor caso é o que o elemento esteja na primeira posicao.<br><br>


<h3>O Array List</h3>

O Java já tem uma implementação de Vetor, é a Classe conhecida por "ArrayList". Ela é bem parecida com tudo o que fizemos até agora e funciona como um Armazenamento Sequencial, possuindo os métodos implementados nesta aula:

ArrayList<Aluno> listaDoJava = new ArrayList<Aluno>();

Apesar dela existir e facilitar nossa vida, foi importante aprendermos como e o que implementar para criarmos uma estrutura de dados.


<h3>Pontos Positivos</h3>


Para recuperar informação em posição pré-definida e inserção de um novo elemento no final da lista são operações rápidas de tempo constante.


<h3>Pontos Negativos</h3>

Para operações como remover um elemento, inserção no meio da estrutura, são operações o(n) que acaba sendo custoso devido a reorganização que deve ser feita na estrutura, após a realização de cada operação.