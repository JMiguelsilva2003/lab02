package estruturaDeDados;

import java.util.Arrays;

public class ClassLista implements Lista {
    int[] lista = new int[20];
    int indice = 0;
    
    @Override
    public boolean buscaElemento(int valor) {
        for (int i = 0; i < this.indice; i++) {
            if (lista[i] == valor) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int minimo() {
        int minimo = lista[0];
        for (int i = 1; i < lista.length; i++) {
            if (lista[i] < minimo) {
                minimo = lista[i];
            }
        }
        return minimo;
    }

    @Override
    public int maximo() {
        int maximo = lista[0];
        for (int i = 1; i < lista.length; i++) {
            if (lista[i] > maximo) {
                maximo = lista[i];
            }
        }
        return maximo;
    }

    @Override
    public int predecessor(int valor) {
        for (int i = 1; i < this.indice; i++) {
            if (lista[i] == valor) {
                return lista[i - 1];
            }
        }
        return -1; 
    }

    @Override
    public int sucessor(int valor) {
        for (int i = 0; i < this.indice - 1; i++) {
            if (lista[i] == valor) {
                return lista[i + 1];
            }
        }
        return -1; 
    }

    @Override
    public void insereElemento(int valor) {
            for (int i = 0; i < lista.length; i++) {
                if (lista[i] == 0) {
                    this.indice ++;
                    lista[i] = valor;
                    return;
                }
            }
    }

    @Override
    public void remove(int valor) {
        for (int i = 0; i < this.indice; i++) {
            if (lista[i] == valor) {
                for (int j = i; j < this.indice - 1; j++) {
                    lista[j] = lista[j + 1];
                }
                lista[this.indice - 1] = 0;
                this.indice--;
                i--;
            }
        }
    }

    @Override
    public int buscaIndice(int valor) {
        for (int i = 0; i < this.indice; i++) {
            if (lista[i] == valor) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void insereElementoPosicao(int valor, int buscaIndice) {
        if (buscaIndice < 0 || buscaIndice > this.indice) {
            System.out.println("Índice de inserção inválido.");
            return;
        }
        for (int i = this.indice; i > buscaIndice; i--) {
            lista[i] = lista[i - 1];
        }
        lista[buscaIndice] = valor;
        this.indice++;
        }

    @Override
    public void insereInicio(int valor) {
        if (this.indice == lista.length) {
            System.out.println("O array está cheio. Não é possível adicionar mais elementos.");
            return;
        }
        for (int i = this.indice; i > 0; i--) {
            lista[i] = lista[i - 1];
        }
        lista[0] = valor;
        this.indice++;

    }

    @Override
    public void insereFim(int valor) {
        if (this.indice == lista.length) {
            System.out.println("O array está cheio. Não é possível adicionar mais elementos.");
            return;
        }
        // Insere o novo valor no final do array e atualiza o tamanho
        lista[this.indice] = valor;
        this.indice++;
    }

    @Override
    public void removeIndice(int indice) {
        if (indice < 0 || indice >= this.indice) {
            System.out.println("Índice inválido.");
            return;
        }
        for (int i = indice; i < this.indice - 1; i++) {
            lista[i] = lista[i + 1];
        }
        lista[this.indice - 1] = 0;
        this.indice--;
    }

    @Override
    public void removeInicio() {
        if (this.indice == 0) {
            System.out.println("O array está vazio. Não há elementos para remover.");
            return;
        }
        for (int i = 0; i < this.indice - 1; i++) {
            lista[i] = lista[i + 1];
        }
        lista[this.indice - 1] = 0;
        this.indice--;
    }

    @Override
    public void removeFim() {
        if (this.indice <= 0) {
            System.out.println("Lista vazia.");
            return;
        }
        this.indice--;
        lista[this.indice - 1] = 0;
    }
}