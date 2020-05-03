/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
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
    public void altera(Doce uma_sessao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Doce> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Doce getByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
