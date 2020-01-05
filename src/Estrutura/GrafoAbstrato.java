/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estrutura;

import Execução.*;
import Funções.*;
import java.util.List;

/**
 *
 * @author a16013
 */
public abstract class GrafoAbstrato {
    
    Representacao representacao = null;
    
    public abstract void criarGrafo(int numeroDeVertices);
    
    public abstract void setAresta(int origem, int destino, double peso);
    
    public abstract void addAresta(int origem, int destino, double peso);
    
    public abstract double getAresta(int origem, int destino);
    
    public abstract void removeAresta(int origem, int destino);
    
    public abstract int getNumeroArestas();
    
    public abstract int getNumeroVertice();
    
    public abstract List<Integer> getAdjacentes(int vertice);
    
    public abstract List<Lista> getNosAdjacentes(int i);
    
    public abstract Representacao getRepresentacaoComputacional();
    
}
