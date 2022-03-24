/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projetodeordenacao;

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
    public static void main(String[] args) {
        List<Item> listaItens = new ArrayList();
        
        listaItens.add(new Item("Jogo A", "Acao",5));
        listaItens.add(new Item("Jogo A2", "Acao",4));
        listaItens.add(new Item("Jogo A3", "Acao",3));
        listaItens.add(new Item("Jogo B", "Estrategia",5));
        listaItens.add(new Item("Jogo C", "Corrida",5));
        listaItens.add(new Item("Jogo D", "Cartas",5));
        
        OrdenarListaPorCategoria(listaItens);
        
        for (int i = 0; i < listaItens.size(); i++) {
            System.out.println("Categoria:" + listaItens.get(i).getCategoria());
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
