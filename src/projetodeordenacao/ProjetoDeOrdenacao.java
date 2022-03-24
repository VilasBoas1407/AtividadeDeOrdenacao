/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projetodeordenacao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucas
 */
public class ProjetoDeOrdenacao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws  Exception {
        
       try{
            List<Item> listaItens = new ArrayList();
            
            LerArquivoCSV(listaItens);
            
            OrdenarListaPorCategoria(listaItens);
        
            for (int i = 0; i < listaItens.size(); i++) {
                System.out.println("Categoria:" + listaItens.get(i).getCategoria());
            }
        
       }
       catch(Exception e){
           throw e;
       }

    }
    
    public static void LerArquivoCSV(List<Item> listaItens) throws Exception{
        try{
            String path = "D:/Projetos/ProjetoDeOrdenacao/src/projetodeordenacao/JogosDesordenados.csv";
            BufferedReader br = new BufferedReader(new FileReader(path));
            String linha = "";
            while((linha = br.readLine()) != null){
                String[] jogo = linha.split(",");
                listaItens.add(new Item(jogo[0],jogo[1], Double.parseDouble(jogo[2])));
            }
        }
        catch(FileNotFoundException e){
            throw e;
        }
        
    }
    public static void OrdenarListaPorCategoria(List<Item> listaItens){
        for(int i =0; i < listaItens.size();i ++){
            for(int j = i+1; j < listaItens.size(); j++){
                String categoriaA = listaItens.get(j).getCategoria();
                String categoriaB = listaItens.get(i).getCategoria();
                if(categoriaA.compareTo(categoriaB) < 1){
                    Item temp = listaItens.get(i);
                    listaItens.set(i, listaItens.get(j));
                    listaItens.set(j, temp);
                }
            }
        }
    }
}
