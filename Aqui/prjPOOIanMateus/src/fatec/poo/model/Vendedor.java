/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.model;


/**
 *
 * @author Ian e Mateus
 */
public class Vendedor extends Pessoa{
    private double salarioBase;
    private double taxaComissao;
    
    public Vendedor(String cpf, String nome, double salarioBase){
        super(cpf, nome);
        
        this.salarioBase = salarioBase;
    }
    
    
    
    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public void setTaxaComissao(double taxaComissao) {
        this.taxaComissao = taxaComissao;
    }

    
    
    public double getSalarioBase() {
        return salarioBase;
    }

    public double getTaxaComissao() {
        return taxaComissao;
    }
    
    
    
    @Override
    public void addPedido(Pedido p){
        p.setVendedor(this);
        super.addPedido(p);
    }
}
