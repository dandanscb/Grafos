/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funções;


/**
 *
 * @author danda
 */
import java.io.FileWriter;
import java.io.IOException;

public class Escrita {

    
    public Escrita(int num_vertice, int d[], int f[], String nome){
        try{
            FileWriter writer = new FileWriter(nome);
            
            
            writer.append("Vertice, Descoberto, Finalizado\r\n");
            
            for(int i = 0; i < num_vertice; i++) {
                writer.append(String.valueOf(i));
                writer.append(",");
                writer.append(String.valueOf(d[i]));
                writer.append(",");
                writer.append(String.valueOf(f[i]));
                writer.append("\r\n");
            }
            
            writer.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    public Escrita(int num_vertice, int d[], String pi[], String nome){
        try{
            FileWriter writer = new FileWriter(nome);
            
            writer.append("Vertice, Pai, Distancia\r\n");
            
            for(int i = 0; i < num_vertice; i++) {
                writer.append(String.valueOf(i));
                writer.append(",");
                writer.append(String.valueOf(pi[i]));
                writer.append(",");
                writer.append(String.valueOf(d[i]));
                writer.append("\r\n");
                
            }
            
            writer.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    public Escrita(int num_vertice, int vertice[], int adjacente[], String nome, double conta, int tipo){
        try{
            FileWriter writer = new FileWriter(nome);
            writer.append("Custo AGM:");
            writer.append(String.valueOf(conta));
            writer.append("\r\n");
            writer.append("Vertice, Adjacente\r\n");
            
            for(int i = 0; i < num_vertice; i++) {
                writer.append(String.valueOf(vertice[i]));
                writer.append(",");
                writer.append(String.valueOf(adjacente[i]));
                writer.append("\r\n");
                
            }
            
            writer.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    public Escrita(int num_vertice, int pai[], String nome, int tipo){
        try{
            FileWriter writer = new FileWriter(nome);
            writer.append("\r\n");
            writer.append("Vertice, Adjacente\r\n");
            
            for(int i = 0; i < num_vertice; i++) {
                writer.append(String.valueOf(i));
                writer.append(",");
                writer.append(String.valueOf(pai[i]));
                writer.append("\r\n");
                
            }
            
            writer.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    
}
    