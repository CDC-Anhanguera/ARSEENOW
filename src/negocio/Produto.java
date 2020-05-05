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
 *
 * @author aryel.sa
 */
public class Produto {
    private int id;
    private String nome;
    private float valor;
    private int quantidade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public void salvar(){
        IProdutoDAO dao = new ProdutoDAO();
        dao.adiciona(this);
    }
    
    public void altera(){
        IProdutoDAO dao = new ProdutoDAO();
        dao.altera(this);
    }
    
    public static void altera(Produto produto){
        IProdutoDAO dao = new ProdutoDAO();
        dao.altera(produto);
    }
    
    public static void excluir(int id){
        IProdutoDAO dao = new ProdutoDAO();
        dao.remove(id);
    }

    public static ArrayList<Produto> getAll(){
        IProdutoDAO dao = new ProdutoDAO();
        return dao.listarTodos();
    }
    
    public static Produto getByID(int id){
        IProdutoDAO dao = new ProdutoDAO();
        return dao.getByID(id);
    }
    
}
