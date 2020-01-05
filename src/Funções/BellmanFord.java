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
 * @author escobar
 */
public class BellmanFord {

    int representacao;
    String saida;
    int num_vertice;
    double[] d;
    int[] pi;
    double[] x;
    double[] y;
    int numero_arestas;

    int[] vertice;
    int[] pai;
    GrafoAbstrato Grafo;
    int aux = 0;
    double distancia;

    int[] origem;
    int[] destino;
    double[] peso;

    public BellmanFord(int representacao, Leitura ler, String saida) {
        this.d = new double[ler.getContador() + 1];
        this.pi = new int[ler.getContador() + 1];
        this.x = new double[ler.getContador() + 1];
        this.y = new double[ler.getContador() + 1];
        this.origem = new int[(ler.getContador() + 1) * (ler.getContador() + 1)];
        this.destino = new int[(ler.getContador() + 1) * (ler.getContador() + 1)];
        this.peso = new double[(ler.getContador() + 1) * (ler.getContador() + 1)];

        if (representacao == 1) {
            this.Grafo = new Grafo_MA(ler.getContador() + 1);
            for (double[] i : ler.getArquivo_double()) {
                this.x[aux] = i[0];
                this.y[aux] = i[1];
                aux++;
            }
            aux = 0;
            for (int i = 0; i < ler.getContador(); i++) {
                for (int j = 0; j < ler.getContador(); j++) {
                    this.distancia = DistanciaEuclidiana(x[i], y[i], x[j], y[j]);
                    this.origem[aux] = i;
                    this.destino[aux] = j;
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
                for (int i = 0; i < ler.getContador(); i++) {
                    for (int j = 0; j < ler.getContador(); j++) {
                        this.distancia = DistanciaEuclidiana(x[i], y[i], x[j], y[j]);
                        this.origem[aux] = i;
                        this.destino[aux] = j;
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
        this.numero_arestas = Grafo.getNumeroArestas();
        this.vertice = new int[ler.getContador() + 1];
        this.pai = new int[ler.getContador() + 1];

    }

    public void inicializa(int raiz) {
        for (int i = 0; i < this.num_vertice; i++) {
            this.d[i] = Double.POSITIVE_INFINITY;
            this.pi[i] = -1;
        }
        this.d[raiz] = 0;
    }

    public void relaxa(int origem, int destino, double peso) {
        if (this.d[destino] > (this.d[origem] + peso)) {
            this.d[destino] = (this.d[origem] + peso);
            this.pi[destino] = origem;
        }
    }

    public boolean run(int raiz) {
        inicializa(raiz);
        for (int i = 1; i < this.num_vertice - 1; i++) {
            for (int j = 0; j < this.numero_arestas-1; j++) {
                relaxa(this.origem[j], this.destino[j], this.peso[j]);
            }
        }
        for (int j = 0; j < this.numero_arestas; j++) {
            if (this.d[this.destino[j]] > (this.d[this.origem[j]] + this.peso[j])) {
                return false;
            }
        }
        return true;
    }

    public void bellmanFord(int raiz) {
        if (run(raiz)) {
            Escrita esc = new Escrita(this.num_vertice, this.pi, this.saida, 0);
        }else{
            // não implementado para o caso negativo
        }
    }

    public double DistanciaEuclidiana(double x1, double y1, double x2, double y2) {
        double distancia = 0;

        distancia = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));

        return distancia;
    }
}
