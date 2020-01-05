/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funções;

import Estrutura.GrafoAbstrato;
import Estrutura.Grafo_LA;
import Estrutura.Grafo_MA;
import Estrutura.Lista;
import java.util.LinkedList;
import static javafx.application.Platform.exit;

/**
 *
 * @author danda
 */
public class Prim {

    int representacao;
    String saida;
    int num_vertice;
    double[] chave;
    int[] pi;
    double[] x;
    double[] y;
    int numero_arestas;
    double[] peso;
    int[] vertice;
    int[] adjacente;
    GrafoAbstrato Grafo;
    LinkedList<Integer> Q = null;
    int aux = 0;
    double distancia;

    public Prim(int representacao, Leitura ler, String saida) {
        this.chave = new double[ler.getContador() + 1];
        this.pi = new int[ler.getContador() + 1];
        this.x = new double[ler.getContador() + 1];
        this.y = new double[ler.getContador() + 1];
        this.peso = new double[(ler.getContador() + 1) * (ler.getContador() + 1)];

        if (representacao == 1) {
            this.Grafo = new Grafo_MA(ler.getContador() + 1);
            for (double[] i : ler.getArquivo_double()) {
                this.x[aux] = i[0];
                this.y[aux] = i[1];
                aux++;
            }
            aux = 0;
            for (int i = 0; i < ler.getContador() + 1; i++) {
                for (int j = 0; j < ler.getContador() + 1; j++) {
                    this.distancia = DistanciaEuclidiana(x[i], y[i], x[j], y[j]);
                    this.peso[aux] = this.distancia;
                    this.Grafo.addAresta(i, j, this.distancia);
                    aux++;
                }
            }

        } else {
            if (representacao == 2) {
                this.Grafo = new Grafo_LA(ler.getContador() + 1);

                for (double[] i : ler.getArquivo_double()) {
                    this.x[aux] = i[0];
                    this.y[aux] = i[1];
                    aux++;
                }
                aux = 0;
                for (int i = 0; i < ler.getContador() + 1; i++) {
                    for (int j = 0; j < ler.getContador() + 1; j++) {
                        this.distancia = DistanciaEuclidiana(x[i], y[i], x[j], y[j]);
                        this.peso[aux] = this.distancia;
                        this.Grafo.addAresta(i, j, this.distancia);
                        aux++;
                    }
                }
            } else {
                exit();
            }
        }
        this.saida = saida;
        this.num_vertice = ler.getContador();
        this.vertice = new int[ler.getContador() + 1];
        this.adjacente = new int[ler.getContador() + 1];

    }

    public void AGM_Prim(int inicio) {
        this.Q = new LinkedList();
        double custo = 0;

        for (int i = 0; i < this.num_vertice; i++) {
            this.chave[i] = Double.POSITIVE_INFINITY;
            this.pi[i] = -1;
            this.Q.add(i);
        }

        this.chave[inicio] = 0;
        int u = 0;
        int incrementa = 0;
        while (!this.Q.isEmpty()) {

            u = extrairMinimo(this.Q);
            if (u != inicio) {
                this.vertice[incrementa] = this.pi[u];
                this.adjacente[incrementa] = u;
                custo = custo + this.Grafo.getAresta(this.vertice[incrementa], this.adjacente[incrementa]);
                incrementa++;
            }
            for (Integer j : this.Grafo.getAdjacentes(u)) {
                if (this.Grafo.getAresta(u, j) < this.chave[j]) {
                    this.chave[j] = this.Grafo.getAresta(u, j);
                    this.pi[j] = u;
                }
            }

        }

        Escrita esc = new Escrita(this.num_vertice, this.vertice, this.adjacente, this.saida, custo, 0);
    }

    public int extrairMinimo(LinkedList Q) {
        int maior = this.num_vertice;
        double compara = 9999999;
        Object loop = 0;

        for (Object i : Q) {
            if (this.chave[(int) i] < compara) {
                compara = this.chave[(int) i];
                maior = (int) i;
                loop = i;
            }
        }

        this.Q.remove(loop);
        return maior;
    }

    public double DistanciaEuclidiana(double x1, double y1, double x2, double y2) {
        double distancia = 0;

        distancia = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));

        return distancia;
    }
}
