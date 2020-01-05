/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estrutura;

import Execução.*;
import Funções.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author a16026
 */
public class Grafo_LA extends GrafoAbstrato {

    LinkedList<Lista>[] LA1 = null;
    int numero_vertice;

    public Grafo_LA(int vertices) {
        super.representacao = Representacao.LISTA_ADJACENCIA;
        this.numero_vertice = vertices;
        this.criarGrafo(vertices);
    }

    @Override
    public void criarGrafo(int numeroDeVertices) {
        LA1 = new LinkedList[numeroDeVertices];
        for (int i = 0; i < numeroDeVertices; i++) {
            LA1[i] = new LinkedList();
        }
    }

    @Override
    public void setAresta(int origem, int destino, double peso) {
        for (int i = 0; i < LA1[origem].size(); i++) {
            if (LA1[origem].get(i).getDestino() == destino) {
                LA1[origem].get(i).setPeso(peso);
            }
        }
    }

    @Override
    public void addAresta(int origem, int destino, double peso) {
        this.LA1[origem].add(new Lista(destino, peso));
    }

    @Override
    public double getAresta(int origem, int destino) {
        for (Lista i : LA1[origem])
            if(i.getDestino() == destino)
                return i.getPeso();
            

        /*for (int i = 0; i < LA1[origem].size(); i++) {
            if (LA1[origem].get(i).getDestino() == destino) {
                return LA1[origem].get(i).getPeso();
            }
        }*/
        return Double.POSITIVE_INFINITY;
    }

    @Override
    public void removeAresta(int origem, int destino) {
        for (int i = 0; i < LA1[origem].size(); i++) {
            if (LA1[origem].get(i).getDestino() == destino) {
                LA1[origem].remove(i);
            }
        }
    }

    @Override
    public int getNumeroArestas() {
        int cont = 0;
        for (int i = 0; i < LA1.length; i++) {
            for (int j = 0; j < LA1[i].size(); j++) {
                cont++;
            }
        }
        return cont;
    }
    
    @Override
    public int getNumeroVertice() {
        return this.numero_vertice;
    }


    @Override
    public List<Integer> getAdjacentes(int vertice) {
        LinkedList<Integer> aux = new LinkedList<>();

        for(Lista i : LA1[vertice])
            aux.add(i.getDestino());
        
        return aux;
    }
    
    @Override
    public List<Lista> getNosAdjacentes(int vertice) {
        LinkedList<Lista> aux = new LinkedList<>();
        for (Lista i : LA1[vertice])
            aux.add(i);

        return aux;
    }

    @Override
    public Representacao getRepresentacaoComputacional() {
        return Representacao.LISTA_ADJACENCIA;
    }  

    
}
