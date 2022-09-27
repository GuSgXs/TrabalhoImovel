/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package imoveis;

/**
 *
 * @author Aluno
 */
public class ImovelUsado extends Imoveis {
    
    public double valor(){
    double valoru = this.getPreco()-(getPreco()*5)/100;
        return valoru;
    }
    
    
}
