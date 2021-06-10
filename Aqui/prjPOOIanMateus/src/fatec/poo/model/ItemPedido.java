
package fatec.poo.model;

/**
 *
 * @author Ian e Mateus
 */
public class ItemPedido {
    private int sequencia;
    private double qtdeVendida;
    
    private Pedido pedido;
    private Produto produto;
    
    
    
    public ItemPedido(int sequencia, double qtdeVendida, Produto produto){
        this.sequencia = sequencia;
        this.qtdeVendida = qtdeVendida;
        this.produto = produto;
        
        produto.setQtdeEstoque(produto.getQtdeEstoque() - getQtdeVendida());
    }

    public ItemPedido(ItemPedido Ped) {
        this.sequencia = Ped.getSequencia();
        this.qtdeVendida = Ped.getQtdeVendida();
        this.produto = Ped.getProduto();
    }
    
    
    
    public void setQtdeVendida(double qtdeVendida) {
        produto.setQtdeEstoque(produto.getQtdeEstoque() - (qtdeVendida - this.qtdeVendida));
        this.qtdeVendida = qtdeVendida;
    }
    
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    
    
    
    public int getSequencia() {
        return sequencia;
    }

    public double getQtdeVendida() {
        return qtdeVendida;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public Produto getProduto() {
        return produto;
    }
    
    
    
    public double calcValor() {
        return produto.getPreco() * qtdeVendida;
    }
}
