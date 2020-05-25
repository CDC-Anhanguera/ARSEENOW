/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

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
    
}
