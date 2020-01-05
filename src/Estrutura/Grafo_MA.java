/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estrutura;

import Execução.*;
import Funções.*;import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author a16013
 */
public final class Grafo_MA extends GrafoAbstrato{
    
    double [][] mat = null;
    int numero_vertice;
    
    public Grafo_MA(int vertices){
        super.representacao = Representacao.MATRIZ_ADJACENCIA;
        this.numero_vertice = vertices;
        this.criarGrafo(vertices);
    }

    @Override
    public void criarGrafo(int numeroDeVertices) {
        this.mat = new double[numeroDeVertices][numeroDeVertices];
        for(int i = 0; i < this.mat.length; i++) {
            for(int j = 0; j < this.mat[i].length; j++) {
                this.mat[i][j] = Double.POSITIVE_INFINITY;
            }
        }
    }

    @Override
    public void setAresta(int origem, int destino, double peso) {
        if(this.mat[origem][destino]!= Double.POSITIVE_INFINITY){
            this.mat[origem][destino] = peso;
        }
    }

    @Override
    public void addAresta(int origem, int destino, double peso) {
        if(this.mat[origem][destino]==Double.POSITIVE_INFINITY){
            this.mat[origem][destino] = peso;
        }
    }

    @Override
    public double getAresta(int origem, int destino) {
        return this.mat[origem][destino];
    }

    @Override
    public void removeAresta(int origem, int destino) {
        if(this.mat[origem][destino]!= Double.POSITIVE_INFINITY){
            this.mat[origem][destino] = Double.POSITIVE_INFINITY;
        }
    }

    @Override
    public int getNumeroArestas() {
        int num_aresta = 0;
        
        for(int i = 0; i < this.mat.length; i++) {
            for(int j = 0; j < this.mat[i].length; j++) {
                num_aresta++;
            }
        }
        
        return num_aresta;
    }
    
    @Override
    public int getNumeroVertice() {
        return this.numero_vertice;
    }


    @Override
    public List<Integer> getAdjacentes(int vertice) {
        LinkedList<Integer> aux = new LinkedList<Integer>();
        for(int j = 0; j < this.mat[vertice].length; j++){
            if(this.mat[vertice][j] != Double.POSITIVE_INFINITY){
                aux.add(j);
            }
        }
        return aux;
    }
    
    @Override
    public List<Lista> getNosAdjacentes(int i) {
        LinkedList<Lista> aux = new LinkedList<>();
        for(int k = 0; k < this.mat[i].length; k++) {
            if(this.mat[i][k] != Double.POSITIVE_INFINITY) {
                aux.add(new Lista (i, this.mat[i][k]));
            }
        }
        return aux;
    }

    @Override
    public Representacao getRepresentacaoComputacional() {
        return Representacao.MATRIZ_ADJACENCIA;
    }
}
