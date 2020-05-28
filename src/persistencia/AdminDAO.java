/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.Admin;

/**
 *  Classe para manipulação de dados de Admin no Banco de dados
 * @author shaw
 */
public class AdminDAO implements IAdminDAO {
    
    
    private Connection connection;   // fazendo conexão com o banco 
    
        /**
     * Construtor sem parametros que cria uma conexão ao banco de dados
     * 
     */
    
    public AdminDAO (){
        this.connection = new ConFactory().getConnection();;
    }
    
    /**
     * Metodo usado para adicionar um admin ao banco de dados
     * 
     * @param admin uma instancia da classe de negocio Admin
     * @exception  RuntimeException ao inserir no banco.
     * @see RuntimeException
     */
    
    @Override
    public void adiciona(Admin admin) {
        // queue sql pra adicionar admin
        String sql = "insert into admin " + 
                "(login, nome, senha)" +
                " values (?,?,?)";
        
        try { // comando de inserção
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            //atributos a serem inseridos 
            stmt.setString(1, admin.getLogin());
            stmt.setString(2, admin.getNome());
            stmt.setString(3, admin.getSenha());

            stmt.execute(); // fun~çao pra executar os comandos
            System.out.println("ADMIN "+ admin.getNome() + " CADASTRADO!");
            stmt.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Metodo usado para alterar um admin do banco de dados
     * 
     * @param admin  uma instancia da classe de negocio Admin
     * @exception  RuntimeException ao alterar no banco.
     * @see RuntimeException
     */
    
    @Override
    public void altera(Admin admin) {   
        
        int id = admin.getIdAdmin();
        String sql = "UPDATE admin " + 
                "SET nome = ?, login = ?, senha = ? WHERE id_admin = " + id;
        
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            
            stmt.setString(1, admin.getNome());
            stmt.setString(2, admin.getLogin());
            stmt.setString(3, admin.getSenha());
            
            stmt.execute();
            System.out.println("ADMINISTRADOR ALTERADO!");
            stmt.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        
    }
    
     /**
     * Metodo usado para remover um admin por id do banco de dados
     * 
     * @param id  uma instancia da classe de negocio Admin
     *  @exception  RuntimeException ao remover o admin do banco de dados.
     * @see RuntimeException
     */
    
    @Override
    public void remove(int id) {    
        String sql = "DELETE FROM admin WHERE id_admin = " + id;
        
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            
            stmt.execute();
            System.out.println("ADMINISTRADOR DELETADO!");
            stmt.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Metodo usado para buscar todos os admin do banco de dados
     * 
     * @return ArrayList - lista de todos os admin 
     * @exception  RuntimeException ao buscar os admin do banco de dados.
     * @see RuntimeException
     */
    
    @Override
    public ArrayList<Admin> listarTodos() { 
         try{
            List<Admin> lista_de_admin;
            lista_de_admin = new ArrayList<>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from admin");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                Admin admin = new Admin();
                
                admin.setIdAdmin(rs.getInt("id_admin"));
                admin.setNome(rs.getString("nome"));
                admin.setLogin(rs.getString("login"));
                admin.setSenha(rs.getString("senha"));
                
                lista_de_admin.add(admin);
            }
            rs.close();
            stmt.close();
            return (ArrayList<Admin>) lista_de_admin;
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Metodo usado para buscar um admin do banco de dados por ID
     * 
     * @param id um id de um admin cadastrado no banco de dados
     * @return ArrayList - lista de todos os admins 
     * @exception  RuntimeException ao buscar os admins do banco de dados.
     * @see RuntimeException
     */
    
    
    @Override
    public Admin getByID(int id) {  
        
        String sql = "select * from admin where id_admin = " + id;
        
         try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            Admin admin = new Admin();
            
             while (rs.next()){
                admin.setIdAdmin(rs.getInt("id_admin"));
                admin.setNome(rs.getString("nome"));
                admin.setLogin(rs.getString("login"));
                admin.setSenha(rs.getString("senha"));
            }
             
            stmt.execute();
            stmt.close();
            return admin;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        
        
        
        
    }
    /**
     * Metodo usado para buscar um admin do banco de dados por ID
     * 
     * @param nome um nome de um admin cadastrado no banco de dados
     * @return ArrayList - lista de todos os admins 
     * @exception  RuntimeException ao buscar os admins do banco de dados.
     * @see RuntimeException
     */
    @Override
    public ArrayList<Admin> getByNome(String nome) {
        
        String sql = "SELECT * FROM admin WHERE nome LIKE '%" + nome + "%'";
        
         try {
             List<Admin> lista_admin;
            lista_admin= new ArrayList<>();
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            Admin admin = new Admin();
            
             while (rs.next()){
                admin.setIdAdmin(rs.getInt("id_admin"));
                admin.setNome(rs.getString("nome"));
                admin.setLogin(rs.getString("login"));
                admin.setSenha(rs.getString("senha"));
                
                lista_admin.add(admin);
            }
             
            stmt.execute();
            stmt.close();
            return (ArrayList<Admin>) lista_admin;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        
        
    }
    
    
    /**
     * Método usado para fazer a checkagem de login e senha no banco de dados
     * @param login  login de alguem cadastrado no banco
     * @param senha  senha de alguem cadastrado no banco
     * @return retorna dizendo se foi possivel logar ou nao
     */
    @Override
    public boolean checkLogin(String login,String senha){
        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean check = false;

        try {

            stmt = connection.prepareStatement("SELECT * FROM admin WHERE login = ? and senha = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);

            rs = stmt.executeQuery();

            if (rs.next()) {

                
                check = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        } /*finally {
            ConnectionFactory.closeConnection(connection, stmt, rs);
        }*/

        return check;    
    
        }

   
    
}
