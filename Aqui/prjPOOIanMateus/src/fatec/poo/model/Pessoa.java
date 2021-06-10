
package fatec.poo.model;

import java.util.ArrayList;

/**
 *
 * @author Ian e Mateus
 */
public class Pessoa {
    private String cpf;
    private String nome;
    private String endereco;
    private String cidade;
    private String uf;
    private String cep;
    private String ddd;
    private String telefone;
    
    private ArrayList<Pedido> pedidos;
    
    public Pessoa(String cpf, String nome){
        this.cpf = cpf;
        this.nome = nome;
        
        pedidos = new ArrayList <Pedido>();
    }

  
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    
    
    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public String getUf() {
        return uf;
    }

    public String getCep() {
        return cep;
    }

    public String getDdd() {
        return ddd;
    }

    public String getTelefone() {
        return telefone;
    }
    
    
    
    public void addPedido(Pedido p){
        this.pedidos.add(p);
    }
    
    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }  
    
    
    
    public static boolean validarCPF(String cpf) {
        //CPF    = 999.999.999-99 - 11 numeros
        //numCPF = 999.999.999    - 9 numeros
        //numID  = 99             - 2 numeros
        if (cpf.length() != 11) {
            return false;
        }
        
        ArrayList<Integer> listCPF = new ArrayList<Integer>();
        
        int numCPF = Integer.parseInt(cpf.substring(0, 9));
        int numID = Integer.parseInt(cpf.substring(9, 11));
        
        
        for(int i = 0; i < 9; i++){
            listCPF.add(Integer.parseInt(cpf.substring(i, i + 1)));
        }
        
        int teste1 , teste2, testeID1, testeID2, testeID3;
        
        
        teste1 = ( listCPF.get(0)*1 + listCPF.get(1)*2 + listCPF.get(2)*3 + listCPF.get(3)*4 + listCPF.get(4)*5 + listCPF.get(5)*6 + listCPF.get(6)*7 + listCPF.get(7)*8 + listCPF.get(8)*9);
        
        testeID1 = teste1 % 11;
        if(testeID1 == 10){
            testeID1 = 0;
        }
        
        teste2 = ( listCPF.get(0)*11 + listCPF.get(1)*10 + listCPF.get(2)*9 + listCPF.get(3)*8 + listCPF.get(4)*7 + listCPF.get(5)*6 + listCPF.get(6)*5 + listCPF.get(7)*4 + listCPF.get(8)*3 + testeID1*2);
        
        testeID2 = (teste2 * 10) % 11;
        if(testeID2 == 10){
            testeID2 = 0;
        }
        
        testeID3 = (testeID1 * 10) + testeID2;
        
        if(testeID3 == numID){
            return (true);
        }
        else{
            return (false);
        }
    }
}
