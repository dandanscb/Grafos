/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funções;

import Estrutura.GrafoAbstrato;
import Estrutura.Grafo_LA;
import Estrutura.Grafo_MA;
import java.util.LinkedList;
import java.util.Queue;
import static javafx.application.Platform.exit;


/**
 *
 * @author danda
 */
public class BuscaEmLargura {

    public static final int BRANCO = 1;
    public static final int CINZA = 2;
    public static final int PRETO = 3;
    int representacao;
    String saida;
    int[] cor;
    String[] pi;
    int[] d;
    int aux;
    int num_vertice;
    int raiz;
    GrafoAbstrato Grafo;

    public BuscaEmLargura(int representacao, Leitura ler, String saida) {
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
        this.pi = new String[num_vertice];
        this.d = new int[num_vertice];
    }

    public void BFS(int raiz) {
        for (int i = 0; i < this.num_vertice; i++) {
            if (i != raiz) {
                this.cor[i] = BRANCO;
                this.d[i] = Integer.MAX_VALUE;
                this.pi[i] = null;
            }
        }

        this.cor[raiz] = CINZA;
        this.d[raiz] = 0;
        this.pi[raiz] = null;
        Queue<Integer> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            aux = fila.poll();
            for (Integer i : this.Grafo.getAdjacentes(aux)) {
                if (this.cor[i] == BRANCO) {
                    this.cor[i] = CINZA;
                    this.d[i] = this.d[aux] + 1;
                    this.pi[i] = String.valueOf(aux);
                    fila.add(i);
                }
                this.cor[aux] = PRETO;
            }
        }
        
        Escrita esc = new Escrita(this.num_vertice, this.d, this.pi, this.saida);

    }

}
