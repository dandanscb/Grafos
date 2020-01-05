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
public class Kruskal {

    int representacao;
    String saida;
    int num_vertice;
    int num_aresta;
    double[] x;
    double[] y;
    double[] peso;
    int[] vertice;
    int[] adjacente;
    GrafoAbstrato Grafo;
    //LinkedList<KruskalList>[] Kruskal = null;
    LinkedList<Integer>[] A = null;
    int aux = 0;
    double distancia;
    int soma;
    int contador = 0;
    double conta = 0;

    public Kruskal(int representacao, Leitura ler, String saida) {
        this.x = new double[ler.getContador() + 1];
        this.y = new double[ler.getContador() + 1];
        this.soma = ler.getContador() * (ler.getContador() + 1) / 2;
        this.peso = new double[soma];
        /*this.Kruskal = new LinkedList[ler.getContador()];
        for (int i = 0; i < ler.getContador() + 1; i++) {
            this.Kruskal[i] = new LinkedList();
        }*/

        if (representacao == 1) {
            this.Grafo = new Grafo_MA(ler.getContador() + 1);
            for (double[] i : ler.getArquivo_double()) {
                x[aux] = i[0];
                y[aux] = i[1];
                aux++;
            }

            for (int i = 0; i < ler.getContador() + 1; i++) {
                for (int j = i + 1; j < ler.getContador() + 1; j++) {
                    this.distancia = DistanciaEuclidiana(x[i], y[i], x[j], y[j]);
                    this.peso[contador] = this.distancia;
                    this.Grafo.addAresta(i, j, this.distancia);
                    //this.Kruskal[i].add(new KruskalList(i, j, this.distancia));
                    contador++;
                }
            }

        } else {
            if (representacao == 2) {
                this.Grafo = new Grafo_LA(ler.getContador() + 1);

                for (double[] i : ler.getArquivo_double()) {
                    x[aux] = i[0];
                    y[aux] = i[1];
                    aux++;
                }

                for (int i = 0; i < ler.getContador(); i++) {
                    for (int j = i + 1; j < ler.getContador(); j++) {
                        this.distancia = DistanciaEuclidiana(x[i], y[i], x[j], y[j]);
                        this.peso[contador] = this.distancia;
                        this.Grafo.addAresta(i, j, this.distancia);
                        //this.Kruskal[i].add(new KruskalList(i, j, this.distancia));
                        contador++;
                    }
                }
            } else {
                exit();
            }
        }
        this.saida = saida;
        this.num_vertice = Grafo.getNumeroVertice();
        this.num_aresta = Grafo.getNumeroArestas();
        this.vertice = new int[ler.getContador() + 1];
        this.adjacente = new int[ler.getContador() + 1];
    }

    public void AGM_Kruskal() {
        double temp;

        for (int i = 0; i < this.soma / 2; i++) {
            for (int j = (this.soma - 1); j > this.soma / 2; j--) {
                if (this.peso[i] > this.peso[j]) {
                    temp = this.peso[i];
                    this.peso[i] = this.peso[j];
                    this.peso[j] = temp;
                }
            }
        }
        int auxiliar = 0;
        int aux_peso = 0;
        int arruma_i = 0;
        int arruma_j = 0;
        int cont_vet = 0;
        int teste = 0;
        int[] vet;
        vet = new int[this.num_vertice + 1];

        while (auxiliar < 20) {
            for (int i = 0; i < this.num_vertice; i++) {
                for (int j = i + 1; j < this.num_vertice; j++) {
                    if (auxiliar == 21) {
                        System.out.println("123");
                    }
                    if (this.Grafo.getAresta(i, j) == this.peso[aux_peso]) {
                        if (auxiliar < 1) {
                            this.vertice[auxiliar] = i;
                            this.adjacente[auxiliar] = j;
                            this.conta = this.conta + this.peso[aux_peso];
                            vet[cont_vet] = i;
                            cont_vet++;
                            vet[cont_vet] = j;
                            cont_vet++;
                            aux_peso++;
                            auxiliar++;

                            teste = 1;
                            break;
                        } else {
                            for (int m = 0; m < cont_vet + 1; m++) {
                                if (i == vet[m]) {
                                    arruma_i = 1;
                                }
                                if (j == vet[m]) {
                                    arruma_j = 1;
                                }
                            }
                            if (arruma_i == 0 && arruma_j == 0) {
                                this.vertice[auxiliar] = i;
                                this.adjacente[auxiliar] = j;
                                this.conta = this.conta + this.peso[aux_peso];
                                vet[cont_vet] = i;
                                cont_vet++;
                                vet[cont_vet] = j;
                                cont_vet++;
                                aux_peso++;
                                auxiliar++;

                                teste = 1;
                                break;
                            } else {
                                if (arruma_i == 0 && arruma_j == 1) {
                                    this.vertice[auxiliar] = i;
                                    this.adjacente[auxiliar] = j;
                                    this.conta = this.conta + this.peso[aux_peso];
                                    vet[cont_vet] = i;
                                    cont_vet++;
                                    aux_peso++;
                                    auxiliar++;

                                    teste = 1;
                                    break;
                                } else {
                                    if (arruma_j == 0 && arruma_i == 1) {
                                        this.vertice[auxiliar] = i;
                                        this.adjacente[auxiliar] = j;
                                        this.conta = this.conta + this.peso[aux_peso];
                                        vet[cont_vet] = j;
                                        cont_vet++;
                                        aux_peso++;
                                        auxiliar++;

                                        teste = 1;
                                        break;
                                    } else {
                                        teste = 1;
                                        aux_peso++;
                                        break;
                                    }
                                }
                            }
                        }
                    }

                }
                if (teste == 1) {
                    break;
                }
            }
            if (teste == 0) {
                aux_peso++;
            }
            arruma_i = 0;
            arruma_j = 0;
            teste = 0;
        }

        Escrita esc = new Escrita(this.num_vertice, this.vertice, this.adjacente, this.saida, this.conta, 0);
    }

    public double DistanciaEuclidiana(double x1, double y1, double x2, double y2) {
        double distancia = 0;

        distancia = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));

        return distancia;
    }

}


/*
for (int m = 0; m < Grafo.getNumeroVertice(); m++) {
    for (int n = 0; n < Grafo.getNumeroVertice(); n++) {
                        
    }
}

 */
