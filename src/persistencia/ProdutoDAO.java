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
import negocio.Produto;

/**
 *
 * @author aryel.sa
 */

public class ProdutoDAO implements IProdutoDAO {
    private Connection connection;
    
    /**
     * Construtor sem parametros
     * 
     * @param Nenhum
     * @return Nenhum
     */
    public ProdutoDAO (){
        this.connection = new ConFactory().getConnection();;
    }
    
    /**
     * Metodo usado para adicionar um produto ao banco de dados
     * 
     * @param produto uma instancia da classe de negocio Produto
     * @return Nenhum
     * @exception  RuntimeException ao inserir no banco.
     * @see RuntimeException
     */
    @Override
    public void adiciona(Produto produto) {
        String sql = "insert into produto " + 
                "(nome, valor, quantidade) values (?,?,?)";
        
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            
            stmt.setString(1, produto.getNome());
            stmt.setFloat(2, produto.getValor());
            stmt.setInt(3, produto.getQuantidade());
            
            stmt.execute();
            System.out.println("PRODUTO CADASTRADO!");
            stmt.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Metodo usado para alterar um produto do banco de dados
     * 
     * @param produto uma instancia da classe de negocio Produto
     * @return Nenhum
     * @exception  RuntimeException ao alterar o banco de dados.
     * @see RuntimeException
     */
    @Override
    public void altera(Produto produto) {
        
        int id = produto.getId();
        String sql = "UPDATE produto " + 
                "SET nome = ?, valor = ?, quantidade = ? WHERE id_produto = " + id;
        
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            
            stmt.setString(1, produto.getNome());
            stmt.setFloat(2, produto.getValor());
            stmt.setInt(3, produto.getQuantidade());
            
            stmt.execute();
            System.out.println("PRODUTO ALTERADO!");
            stmt.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Metodo usado para remover um produto do banco de dados
     * 
     * @param produto uma instancia da classe de negocio Produto
     * @return Nenhum
     * @exception  RuntimeException ao remover o produto do banco de dados.
     * @see RuntimeException
     */
    @Override
    public void remove(int id) {
        String sql = "DELETE FROM produto WHERE id_produto = " + id;
        
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            
            stmt.execute();
            System.out.println("PRODUTO DELETADO!");
            stmt.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Metodo usado para buscar todos os produtos do banco de dados
     * 
     * @param Nenhum
     * @return Nenhum
     * @exception  RuntimeException ao buscar os produtos do banco de dados.
     * @see RuntimeException
     */
    @Override
    public ArrayList<Produto> listarTodos() {
        try{
            List<Produto> lista_de_doces;
            lista_de_doces = new ArrayList<>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from produto");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                Produto doce = new Produto();
                
                doce.setId(rs.getInt("id_doce"));
                doce.setNome(rs.getString("nome"));
                doce.setValor(rs.getFloat("valor"));
                doce.setQuantidade(rs.getInt("quantidade"));
                
                lista_de_doces.add(doce);
            }
            rs.close();
            stmt.close();
            return (ArrayList<Produto>) lista_de_doces;
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Metodo usado para buscar um produto do banco de dados
     * 
     * @param ID um id de um produto cadastrado no banco de dados
     * @return produto um produto cadastrado no banco de dados
     * @exception  RuntimeException ao buscar os produtos do banco de dados.
     * @see RuntimeException
     */
    @Override
    public Produto getByID(int ID) {
        String sql = "SELECT * FROM produto WHERE id_produto = " + ID;
        
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            Produto produto = new Produto();
            
             while (rs.next()){
                produto.setId(rs.getInt("id_doce"));
                produto.setNome(rs.getString("nome"));
                produto.setValor(rs.getFloat("valor"));
                produto.setQuantidade(rs.getInt("quantidade"));
            }
             
            stmt.execute();
            stmt.close();
            return produto;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    
}
