/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Execução;

import Estrutura.*;
import Funções.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author a16026
 */
public class Main {

    public static void main(String[] args) {
        
        String representacao = null;
        String f = null;
        String entrada = null;
        String saida = null;
        int tipo = 1;
        int raiz = 0;

        /*for (int i = 0; i < args.length; i++) {
            if ("-rep".equals(args[i])) {
                representacao = args[i + 1];
                i++;
            } else if ("-f".equals(args[i])) {
                f = args[i + 1];;
                i++;
            } else if ("-csvorigem".equals(args[i])) {
                entrada = args[i + 1];
                i++;
            } else if ("-csvdestino".equals(args[i])) {
                saida = args[i + 1];
                i++;
            } else if ("-grafo".equals(args[i])) {
                tipo = Integer.parseInt(args[i + 1]);
                i++;
            } else if ("-verticeinicial".equals(args[i])) {
                raiz = Integer.parseInt(args[i + 1]);
                i++;
            }

        }*/
        
        for (int i = 0; i < args.length; i++) {
            if ("-entrada".equals(args[i])) {
                entrada = args[i + 1];
                i++;
            }else if ("-saida".equals(args[i])) {
                saida = args[i + 1];
                i++;
            } else if ("-inicial".equals(args[i])) {
                raiz = Integer.parseInt(args[i + 1]);
                i++;
            } else if ("-representacao".equals(args[i])) {
                tipo = Integer.parseInt(args[i + 1]);
                i++;
            } else if ("-algoritmo".equals(args[i])) {
                representacao = args[i + 1];
                i++;
            }
        } 
        
        long comecoexecucao = System.nanoTime();
        long meioexecucao = 0;
        long auxexecucao = 0;

        if (representacao.equals("DFS") || representacao.equals("BFS")) {
            Leitura leitura = new Leitura(entrada, 1);
            if (representacao.equals("DFS")) {
                BuscaEmProfundidade DFS = new BuscaEmProfundidade(tipo, leitura, saida);
                if (f.equals("i")) {
                    DFS.DFS_Iterativo();
                } else {
                    DFS.DFS();
                }
            } else {
                BuscaEmLargura BFS = new BuscaEmLargura(tipo, leitura, saida);
                BFS.BFS(raiz);
            }
        }

        if (representacao.equals("Kruskal") || representacao.equals("Prim")) {
            Leitura arquivo = new Leitura(entrada, 0);
            if (representacao.equals("Kruskal")) {
                Kruskal Kruskal = new Kruskal(tipo, arquivo, saida);
                Kruskal.AGM_Kruskal();
            } else {
                Prim Prim = new Prim(tipo, arquivo, saida);
                Prim.AGM_Prim(raiz);
            }
        }
        
        if (representacao.equals("BellmanFord") || representacao.equals("Dijkistra")) {
            Leitura arquivo = new Leitura(entrada, 0);
            meioexecucao = System.nanoTime() - comecoexecucao;
            System.out.println("Leitura: "+meioexecucao/1000000+"ms");
            auxexecucao = System.nanoTime();
            if (representacao.equals("Dijkistra")) {
                Djikstra Djikstra = new Djikstra(tipo, arquivo, saida);
                Djikstra.run(raiz);
            } else {
                BellmanFord BellmanFord = new BellmanFord(tipo, arquivo, saida);
                BellmanFord.bellmanFord(raiz);
            }
        }
        
        long fimexecucao = System.nanoTime() - auxexecucao;
        System.out.println("Execução: "+fimexecucao/1000000+"ms");
        System.out.println("Total: "+(fimexecucao+meioexecucao)/1000000+"ms");
        
        

    }

}
//-rep Dijkstra -f i -csvorigem  v1000.agm -csvdestino Dijkstra.csv -grafo 2
//-entrada v1000.agm -saida Dijkstra.csv -inicial 0 -representacao 1 -algoritmo Dijkstra