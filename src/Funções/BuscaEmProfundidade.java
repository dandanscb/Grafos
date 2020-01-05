/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funções;

import Estrutura.*;
import Execução.*;
import Funções.Leitura;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import static javafx.application.Platform.exit;

/**
 *
 * @author danda
 */
public class BuscaEmProfundidade {

    public static final int BRANCO = 1;
    public static final int CINZA = 2;
    public static final int PRETO = 3;
    int representacao;
    String saida;
    int[] cor;
    int[] d;
    int[] f;
    int tempo = 0;
    int num_vertice;
    GrafoAbstrato Grafo;

    public BuscaEmProfundidade(int representacao, Leitura ler, String saida) {
        if (representacao == 1) {
            this.Grafo = new Grafo_MA(ler.getMaior_vertice() - ler.getMenor_vertice() + 1);
            for (int[] i : ler.getArquivo()) {
                Grafo.addAresta(i[0], i[1], 1);
            }
        } else {
            if (representacao == 2) {
                this.Grafo = new Grafo_LA(ler.getMaior_vertice() - ler.getMenor_vertice() + 1);
                for (int[] i : ler.getArquivo()) {
                    Grafo.addAresta(i[0], i[1], 1);
                }
            } else {
                exit();
            }
        }
        this.saida = saida;
        this.num_vertice = Grafo.getNumeroVertice();
        this.cor = new int[num_vertice];
        this.d = new int[num_vertice];
        this.f = new int[num_vertice];
    }

    public void DFS_Iterativo() {

        for (int i = 0; i < this.num_vertice; i++) {
            this.cor[i] = BRANCO;
        }

        int[] vertice;
        vertice = new int[this.num_vertice];
        int aux = 0;
        int loop = 1;
        int x = 0;

        for (int i = 0; i < this.num_vertice; i++) {
            vertice[i] = aux;
            loop = 1;
            x = 0;
            if (this.cor[vertice[i]] == BRANCO) {
                this.cor[vertice[i]] = CINZA;
                this.tempo++;
                this.d[vertice[i]] = this.tempo;
            }
            if (i < (this.num_vertice - 1)) {
                while (loop == 1) {
                    for (Integer j : Grafo.getAdjacentes(vertice[i] - x)) {
                        if (this.cor[j] == BRANCO) {
                            aux = j;
                            loop = 0;
                            break;
                        }
                    }
                    if (loop == 1) {
                        if (this.cor[vertice[i] - x] == CINZA) {
                            this.cor[vertice[i] - x] = PRETO;
                            this.tempo++;
                            this.f[vertice[i] - x] = this.tempo;
                        }
                    }
                    x++;
                }
            } else {
                for (Integer j : Grafo.getAdjacentes(vertice[i])) {
                    if (this.cor[j] == BRANCO) {
                        this.cor[vertice[i]] = CINZA;
                        this.tempo++;
                        this.d[vertice[i]] = this.tempo;
                        this.cor[vertice[i]] = PRETO;
                        this.tempo++;
                        this.f[vertice[i]] = this.tempo;
                    }
                }

                for (int j = (this.num_vertice - 1); j >= 0; j--) {
                    if (this.cor[vertice[j]] == CINZA) {
                        this.cor[vertice[j]] = PRETO;
                        this.tempo++;
                        this.f[vertice[j]] = this.tempo;
                    }
                }
            }

        }
        
        Escrita esc = new Escrita(this.num_vertice, this.d, this.f, this.saida);

    }

    public void DFS() {

        for (int i = 0; i < this.num_vertice; i++) {
            this.cor[i] = BRANCO;
        }

        for (int i = 0; i < this.num_vertice; i++) {
            if (this.cor[i] == BRANCO) {
                DFS_VISIT(i);
            }
        }
        
        Escrita esc = new Escrita(this.num_vertice, this.d, this.f, this.saida);
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
    }

    public int[] getD() {
        return this.d;
    }

    public void setD(int[] d) {
        this.d = d;
    }

    public int[] getF() {
        return this.f;
    }

    public void setF(int[] f) {
        this.f = f;
    }

    public int getNum_vertice() {
        return this.num_vertice;
    }

    public void setNum_vertice(int num_vertice) {
        this.num_vertice = num_vertice;
    }

}
