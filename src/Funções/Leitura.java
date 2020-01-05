/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funções;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Leitura {

    String Arq;
    LinkedList<int[]> Arquivo = new LinkedList();
    int maior_vertice = 0;
    int menor_vertice = 999999999;
    int contador;
    LinkedList<double[]> Arquivo_double = new LinkedList();

    public Leitura(String Arq, int tipo) {
        this.Arq = Arq;
        if (tipo == 1) {
            run(this.Arq);
        } else {
            lerDouble(this.Arq);
        }
    }

    public void run(String arquivoCSV) {

        BufferedReader br = null;
        String linha = "";
        String csvDivisor = ",";
        int tamanho = 2;

        try {

            br = new BufferedReader(new FileReader(arquivoCSV));
            br.readLine();

            while ((linha = br.readLine()) != null) {
                if (linha.equals("")) {
                    break;
                }
                int[] vertice = new int[tamanho];
                String[] ler = linha.split(csvDivisor);
                for (int i = 0; i < tamanho; i++) {
                    vertice[i] = Integer.parseInt(ler[i]);
                }
                for (int i = 0; i < 2; i++) {
                    if(vertice[i] > maior_vertice){
                        maior_vertice = vertice[i];
                    }
                    if(vertice[i] < menor_vertice){
                        menor_vertice = vertice[i];
                    } 
                }
                
                    
                Arquivo.add(vertice);
            }
            
            setMaior_vertice(maior_vertice);
            setArquivo(Arquivo);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void lerDouble(String arquivoCSV) {

        BufferedReader br = null;
        String linha = "";
        String csvDivisor = ",";
        int tamanho = 2;

        try {

            br = new BufferedReader(new FileReader(arquivoCSV));
            br.readLine();

            while ((linha = br.readLine()) != null) {
                if (linha.equals("")) {
                    break;
                }
                double[] vertice = new double[tamanho];
                String[] ler = linha.split(csvDivisor);
                for (int i = 0; i < tamanho; i++) {
                    vertice[i] = Double.parseDouble(ler[i]);
                }

                Arquivo_double.add(vertice);
                this.contador++;
            }
            
            setArquivo_double(Arquivo_double);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getMaior_vertice() {
        return maior_vertice;
    }

    public void setMaior_vertice(int maior_vertice) {
        this.maior_vertice = maior_vertice;
    }

    public int getMenor_vertice() {
        return menor_vertice;
    }

    public void setMenor_vertice(int menor_vertice) {
        this.menor_vertice = menor_vertice;
    }

    public LinkedList<int[]> getArquivo() {
        return Arquivo;
    }

    public void setArquivo(LinkedList<int[]> Arquivo) {
        this.Arquivo = Arquivo;
    }
    
    public int getContador(){
        return contador;
    }
    
    public void setContador(int contador) {
        this.contador = contador;
    }
    
    public LinkedList<double[]> getArquivo_double() {
        return Arquivo_double;
    }

    public void setArquivo_double(LinkedList<double[]> Arquivo) {
        this.Arquivo_double = Arquivo_double;
    }

}
