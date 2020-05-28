/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.ArrayList;
import persistencia.AdminDAO;
import persistencia.IAdminDAO;

/**
 * Classe de negócio Admin
 * @author shaw
 */
public class Admin {
    
    private int idAdmin;
    private String login;
    private String nome;
    private String senha;
    
    
    /**
     * Metodo usado para retornar o id do admin
     * 
     * @return int - Id do admin 
     */
    
    
    public int getIdAdmin() {
        return idAdmin;
    }
    
      /**
     * Metodo usado para inserir ou alterar o id do admin
     * 
     * @param id - id do admin 
     */
    
    public void setIdAdmin(int id) {
        this.idAdmin = id;
    }
    
     /**
     * Metodo usado para retornar o valor da instancia
     * 
     * @return string - Id do admin 
     */
    
    public String getLogin() {
        return login;
    }
   
      /**
     * Metodo usado para inserir ou alterar o valor da instancia
     * 
     * @param login  - id do admin 
     */
    
    public void setLogin(String login) {
        this.login = login;
    }

    
      /**
     * Metodo usado para retornar o nome do admin
     * 
     * @return string - Nome do admin 
     */
    
    public String getNome() {
        return nome;
    }

      /**
     * Metodo usado para inserir ou alterar o valor da instancia
     * 
     * @param nome - nome do admin 
     */
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
      /**
     * Metodo usado para retornar a senha do admin
     * 
     * @return string - Senha do admin 
     */
    
    public String getSenha() {
        return senha;
    }
    
     /**
     * Metodo usado para inserir ou alterar o valor da instancia
     * 
     * @param senha - senha do admin 
     */
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    /**
     * Metodo usado para persistir a instancia da classe
     */
    public void salvar(){
        IAdminDAO dao = new AdminDAO();
        dao.adiciona(this);
    }
    
    /**
     * Metodo usado para alterar a instancia da classe previamente persistida
     */
    public void altera(){
        IAdminDAO dao = new AdminDAO();
        dao.altera(this);
    }
    
    /**
     * Metodo usado para excluir a instancia da classe previamente persistida
     * 
     * @param id - numero de identificação da instancia a ser excluida
     */
    public static void excluir(int id){
        IAdminDAO dao = new AdminDAO();
        dao.remove(id);
    }
    
    /**
     * Metodo usado para buscar todas as instancia da classe persistidas
     * 
     * @return ArrayList - lista de produtos persistidos
     */
    public static ArrayList<Admin> getAll(){
        IAdminDAO dao = new AdminDAO();
        return dao.listarTodos();
    }
    
    /**
     * Metodo usado para buscar uma a instancia da classe persistida
     * 
     * @param  id  - identificador do produto
     * @return Produto - produto de mesmo id passado como parametro
     */
    public static Admin getByID(int id){
        IAdminDAO dao = new AdminDAO();
        return dao.getByID(id);
    }
    
    /**
     * Metodo usado para buscar uma lista de instancias da classe persistida por nome
     * 
     * @param  nome  - nome do produto
     * @return ArrayList - Lista de produtos com o nome parecido com o nome passado
     */
    public static ArrayList<Admin> getByNome(String nome){
        IAdminDAO dao = new AdminDAO();
        return dao.getByNome(nome);
    }
    
}
