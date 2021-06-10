
package fatec.poo.model;

import java.util.ArrayList;

/**
 *
 * @author Ian e Mateus
 */
public class Pedido {
    private String numero;
    private String dataEmissao;
    private String dataPagto;
    private boolean formaPagto;
    private boolean situacao;
    
    private Cliente cliente;
    private Vendedor vendedor;
    private ArrayList <ItemPedido> itensPedidos;
    
    public Pedido(String numero, String dataEmissao){
        this.numero = numero;
        this.dataEmissao = dataEmissao;
        
        itensPedidos = new ArrayList<ItemPedido>();
    }

    
    
    public void setDataPagto(String dataPagto) {
        this.dataPagto = dataPagto;
    }

    public void setFormaPagto(boolean formaPagto) {
        this.formaPagto = formaPagto;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }
    
    
    
    public String getNumero() {
        return numero;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public String getDataPagto() {
        return dataPagto;
    }

    public boolean isFormaPagto() {
        return formaPagto;
    }

    public boolean isSituacao() {
        return situacao;
    }
    
    
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
    
    
    
     public Cliente getCliente() {
        return cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }
    
    
    public void addItemPedido(ItemPedido itemPedido) {
        itensPedidos.add(itemPedido);
        itemPedido.setPedido(this);
        
        cliente.setLimiteDisp(cliente.getLimiteDisp() - (itemPedido.getProduto().getPreco() * itemPedido.getQtdeVendida()));
    }
    
    public ArrayList<ItemPedido> getItensPedido() {
        return itensPedidos;
    }
    
    
    public double calcValorTotal() {
        double soma = 0;
        for (int i=0; i<itensPedidos.size(); i++) {
            soma += itensPedidos.get(i).calcValor();
        }
        return soma;
    }
     
    public void removeItemPedido(int i) {
        cliente.setLimiteDisp(cliente.getLimiteDisp() + itensPedidos.get(i).calcValor());
        
        itensPedidos.get(i).setQtdeVendida(0);
        itensPedidos.remove(i);
    }
}
