/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package imoveis;

/**
 *
 * @author Aluno
 */
public class ImovelNovo extends Imoveis {

    public double valor() {
        double valorn = this.getPreco() + (getPreco() * 10) / 100;
        return valorn;
    }

}
