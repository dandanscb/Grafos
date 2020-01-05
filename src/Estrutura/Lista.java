/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estrutura;


import Execução.*;
import Funções.*;
import static Funções.BuscaEmProfundidade.BRANCO;
import static Funções.BuscaEmProfundidade.CINZA;
import static Funções.BuscaEmProfundidade.PRETO;
import java.util.Stack;
/**
 *
 * @author a16026
 */
public class Lista {
    double peso;
    int destino;

    public Lista(int destino, double peso) {
        this.peso = peso;
        this.destino = destino;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getDestino() {
        return destino;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }
    
}
/*public void DFS() {

        for (int i = 0; i < this.num_vertice; i++) {
            this.cor[i] = BRANCO;
        }

        int[] vetor;
        vetor = new int[num_vertice];
        Stack pilha = new Stack();
        int aux = 0;
        int a = 1;
        int x;

        for (int i = 0; i < this.num_vertice; i++) {
            x = 1;
            a = 1;
            vetor[i] = aux;
            this.cor[aux] = CINZA;
            this.tempo++;
            this.d[aux] = this.tempo;
            if (i < this.num_vertice - 1) {
                while (a == 1) {
                    for (Integer j : Grafo.getAdjacentes(vetor[i] + 1 - x)) {
                        if (this.cor[j] == BRANCO) {
                            aux = j;
                            a = 0;
                            break;
                        }
                    }
                    if (a == 1) {
                        this.cor[vetor[i] + 1 - x] = PRETO;
                        this.tempo++;
                        this.f[vetor[i] + 1 - x] = this.tempo;
                    }
                    x++;
                }

            } else {
                for (Integer j : Grafo.getAdjacentes(vetor[i])) {
                    if (this.cor[j] == BRANCO) {
                        aux = j;
                        i++;
                        vetor[i] = aux;
                        pilha.push(aux);
                        this.cor[aux] = CINZA;
                        this.tempo++;
                        this.d[aux] = this.tempo;
                        this.cor[aux] = PRETO;
                        this.tempo++;
                        this.f[aux] = this.tempo;
                        break;
                    }
                }
                /*for (int j = num_vertice - 1; j >= 0; j--) {
                    if (this.cor[vetor[j]] == CINZA) {
                        this.cor[vetor[j]] = PRETO;
                        this.tempo++;
                        this.f[vetor[j]] = this.tempo;
                    }
                }

            }

        }
    }

    public void DFS_VISIT(int u) {
        this.cor[u] = CINZA;
        this.tempo++;
        this.d[u] = this.tempo;

        for (Integer i : Grafo.getAdjacentes(u)) {
            if (this.cor[i] == BRANCO) {
                DFS_VISIT(i);
            }
        }

        this.cor[u] = PRETO;
        this.tempo++;
        this.f[u] = this.tempo;
    }*/