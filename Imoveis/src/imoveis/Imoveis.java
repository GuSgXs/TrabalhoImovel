/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package imoveis;

import java.util.Scanner;

/**
 *
 * @author Aluno
 */
public class Imoveis {

    Scanner ler = new Scanner(System.in);
    
   private String nome;
   private String endereco;
   private double preco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    
     public void dados(){
   
       System.out.println("Digite o NOME:");
       nome=ler.next();
       System.out.println("Digite o ENDERECO:");
       endereco=ler.next();
       System.out.println("Digite o PRECO:");
       preco=ler.nextDouble();
     
   }
}
