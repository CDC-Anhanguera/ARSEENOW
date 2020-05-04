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
import negocio.Doce;

/**
 *
 * @author aryel.sa
 */
public class DoceDAO implements IDoceDAO {
    private Connection connection;
    
    public DoceDAO (){
        this.connection = new ConFactory().getConnection();;
    }
    
    @Override
    public void adiciona(Doce um_doce) {
        String sql = "insert into doce " + 
                "(nome, valor, quantidade) values (?,?,?)";
        
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            
            stmt.setString(1, um_doce.getNome());
            stmt.setFloat(2, um_doce.getValor());
            stmt.setInt(3, um_doce.getQuantidade());
            
            stmt.execute();
            System.out.println("DOCE CADASTRADO!");
            stmt.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void altera(Doce um_doce) {
        
        int id = um_doce.getId_doce();
        String sql = "UPDATE doce " + 
                "SET nome = ?, valor = ?, quantidade = ? WHERE id_doce = " + id;
        
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            
            stmt.setString(1, um_doce.getNome());
            stmt.setFloat(2, um_doce.getValor());
            stmt.setInt(3, um_doce.getQuantidade());
            
            stmt.execute();
            System.out.println("DOCE ALTERADO!");
            stmt.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(int id) {
        String sql = "DELETE FROM doce WHERE id_doce = " + id;
        
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            
            stmt.execute();
            System.out.println("DOCE DELETADO!");
            stmt.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Doce> listarTodos() {
        try{
            List<Doce> lista_de_doces;
            lista_de_doces = new ArrayList<>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from psicologo");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                Doce doce = new Doce();
                
                doce.setId_doce(rs.getInt("id_doce"));
                doce.setNome(rs.getString("nome"));
                doce.setValor(rs.getFloat("valor"));
                doce.setQuantidade(rs.getInt("quantidade"));
                
                lista_de_doces.add(doce);
            }
            rs.close();
            stmt.close();
            return (ArrayList<Doce>) lista_de_doces;
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Doce getByID(int id) {
        String sql = "SELECT * FROM doce WHERE id_doce = " + id;
        
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            Doce doce = new Doce();
            
             while (rs.next()){
                doce.setId_doce(rs.getInt("id_doce"));
                doce.setNome(rs.getString("nome"));
                doce.setValor(rs.getFloat("valor"));
                doce.setQuantidade(rs.getInt("quantidade"));
            }
             
            stmt.execute();
            stmt.close();
            return doce;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    
}
