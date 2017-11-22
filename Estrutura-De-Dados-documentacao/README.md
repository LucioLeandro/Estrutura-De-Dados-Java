<h1>Estrutura de Dados com Java</h1>


Para o estudo de Estrutura de dados em java trabalharei com um sistema hipotético de uma universidade hipotética, onde preciso armazenar, recuperar, e remover alunos.


Modelei a classe aluno com seu construtor e getter que guarda o nome do aluno, recebido em seu construtor.

Com excessão das estruturas onde não precisarei usar a classe Aluno, todos os pacotes contidos no projeto desse estudo, conterá variações da classe Aluno.   

<code>
	
	public class Aluno {

	    private String nome;

	    public Aluno(String nome) {
	        this.nome = nome;
	    }

	    public String getNome() {
 		   return nome;
		}

	}

</code>

Também implementei os métodos ToString e equals.

<code>
	
	@Override
	public boolean equals(Object obj) {
	    Aluno outro = (Aluno) obj;
	    return outro.getNome().equals(this.nome);
	}

	@Override
	public String toString() {
	    return this.nome;
	}

</code>


A partir disso, implementarei as classes a quais trabalharei com as estruturas de dados

- Vetor
- Lista Ligada
- Lista duplamente Ligada
- Fila
- pilha

para cada uma dessas classes implementarei a estrutura e seus métodos de acesso a elas que são os métodos :

- Adiciona no final
- Adiciona na posição indicada
- pega (recupera o aluno) na posição indicada
- contem (verifica se o aluno está armazenado na estrutura)
- Remove (deleta na posição indicada)


Onde algumas apenas possue o método adiciona, remove, e contem.




