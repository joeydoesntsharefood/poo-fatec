
package fatec.poo.model;


/**
 *
 * @author Ian e Mateus
 */
public class Cliente extends Pessoa {
    private double limiteCred;
    private double limiteDisp;
    
    public Cliente(String cpf, String nome, double limiteCred){
        super(cpf, nome);
        
        this.limiteCred = limiteCred;
        this.limiteDisp = this.limiteCred;

    }

    
    
    public void setLimiteCred(double limiteCred) {
        this.limiteCred = limiteCred;
    }

    public void setLimiteDisp(double limiteDisp) {
        this.limiteDisp = limiteDisp;
    }

    
    
    public double getLimiteCred() {
        return limiteCred;
    }

    public double getLimiteDisp() {
        return limiteDisp;
    }
    
    
    
    @Override
    public void addPedido(Pedido p){
        p.setCliente(this);
        super.addPedido(p);
    }
}
