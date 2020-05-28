/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.ArrayList;
import persistencia.IProdutoDAO;
import persistencia.ProdutoDAO;

/**
 * Classe de negocio Produto
 * @author aryel.sa
 */
public class Produto {
    private int id;
    private String nome;
    private float valor;
    private int quantidade;
    
    /**
     * Metodo usado para retornar o id da instancia
     * 
     * @return int - Id do produto 
     */
    public int getId() {
        return id;
    }
    
    /**
     * Metodo usado para inserir ou alterar o id da instancia
     * 
     * @param id - id do produto 
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Metodo usado para retornar o nome da instancia
     * 
     * @return String - nome do produto 
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Metodo usado para inserir ou alterar o nome da instancia
     * 
     * @param nome - nome do produto 
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * Metodo usado para retornar o valor da instancia
     * 
     * @return float - valor do produto 
     */
    public float getValor() {
        return valor;
    }
    
    /**
     * Metodo usado para inserir ou alterar o valor da instancia
     * 
     * @param valor - valor do produto 
     */
    public void setValor(float valor) {
        this.valor = valor;
    }
    
    /**
     * Metodo usado para retornar a quantidade da instancia
     * 
     * @return int - quantidade do produto 
     */
    public int getQuantidade() {
        return quantidade;
    }
    
    /**
     * Metodo usado para inserir ou alterar a quantidade da instancia
     * 
     * @param quantidade - quantidade do produto 
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    /**
     * Metodo usado para persistir a instancia da classe
     */
    public void salvar(){
        IProdutoDAO dao = new ProdutoDAO();
        dao.adiciona(this);
    }
    
    /**
     * Metodo usado para alterar a instancia da classe previamente persistida
     */
    public void altera(){
        IProdutoDAO dao = new ProdutoDAO();
        dao.altera(this);
    }
    
    /**
     * Metodo usado para excluir a instancia da classe previamente persistida
     * 
     * @param id - numero de identificação da instancia a ser excluida
     */
    public static void excluir(int id){
        IProdutoDAO dao = new ProdutoDAO();
        dao.remove(id);
    }
    
    /**
     * Metodo usado para buscar todas as instancia da classe persistidas
     * 
     * @return ArrayList - lista de produtos persistidos
     */
    public static ArrayList<Produto> getAll(){
        IProdutoDAO dao = new ProdutoDAO();
        return dao.listarTodos();
    }
    
    /**
     * Metodo usado para buscar uma a instancia da classe persistida
     * 
     * @param  id  - identificador do produto
     * @return Produto - produto de mesmo id passado como parametro
     */
    public static Produto getByID(int id){
        IProdutoDAO dao = new ProdutoDAO();
        return dao.getByID(id);
    }
    
    /**
     * Metodo usado para buscar uma lista de instancias da classe persistida por nome
     * 
     * @param  nome  - nome do produto
     * @return ArrayList - Lista de produtos com o nome parecido com o nome passado
     */
    public static ArrayList<Produto> getByNome(String nome){
        IProdutoDAO dao = new ProdutoDAO();
        return dao.getByNome(nome);
    }
}
