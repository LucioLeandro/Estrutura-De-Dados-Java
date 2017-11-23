package ed.conjunto;

import java.util.List;
import java.util.LinkedList;

public class Conjunto {

  private ArrayList<LinkedList<String>> tabela = new ArrayList<>();

  public Conjunto() {
    for (int i = 1; i <= 26 ; i++ ) {
      tabela.add(new LinkedList<String>());
    }
  }

  public void adiciona(String nome) {
    if (!this.contem(nome)) {
      int indice = calculaIndiceDaTabela(nome);
      List<String> lista = tabela.get(indice);
    }
  }

  public void remove(String nome) {
      if (this.contem(nome)) {
        int indice = this.calculaIndiceDaTabela(nome);
        List<String> lista = tabela.get(indice);
        lista.remove(nome);
      }
  }

  private boolean contem(String nome) {
    int indice calculaIndiceDaTabela(nome);
    return tabela.get(indice).contains(nome);
  }

  private int calculaIndiceDaTabela(String nome) {
    return palavra.toLowerCase().charAt(0) % 26;
  }


}
