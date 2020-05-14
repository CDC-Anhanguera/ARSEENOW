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
 * Classe para manipulação de dados de Produtos no Banco de dados
 * @author aryel.sa
 */

public class ProdutoDAO implements IProdutoDAO {
    private Connection connection;
    
    /**
     * Construtor sem parametros que cria uma conexão ao banco de dados
     * 
     */
    public ProdutoDAO (){
        this.connection = new ConFactory().getConnection();;
    }
    
    /**
     * Metodo usado para adicionar um produto ao banco de dados
     * 
     * @param produto uma instancia da classe de negocio Produto
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
     * @param id numero de identificação de um produto
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
     * @return ArrayList - lista de todos os produtos 
     * @exception  RuntimeException ao buscar os produtos do banco de dados.
     * @see RuntimeException
     */
    @Override
    public ArrayList<Produto> listarTodos() {
        try{
            List<Produto> lista_de_produtos;
            lista_de_produtos = new ArrayList<>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from produto");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                Produto produto = new Produto();
                
                produto.setId(rs.getInt("id_produto"));
                produto.setNome(rs.getString("nome"));
                produto.setValor(rs.getFloat("valor"));
                produto.setQuantidade(rs.getInt("quantidade"));
                
                lista_de_produtos.add(produto);
            }
            rs.close();
            stmt.close();
            return (ArrayList<Produto>) lista_de_produtos;
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Metodo usado para buscar um produto do banco de dados pelo ID
     * 
     * @param ID um id de um produto cadastrado no banco de dados
     * @return ArrayList - lista de todos os produtos 
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
                produto.setId(rs.getInt("id_produto"));
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
    
    /**
     * Metodo usado para buscar um produto do banco de dados pelo nome de um produto
     * 
     * @param nome nome de um produto cadastrado no banco de dados
     * @return ArrayList - lista de produtos com o nome parecido ao passado no parametro
     * @exception  RuntimeException ao buscar os produtos do banco de dados.
     * @see RuntimeException
     */
    @Override
    public ArrayList<Produto> getByNome(String nome) {
        String sql = "SELECT * FROM produto WHERE nome LIKE '%" + nome + "%'";
        try {
            List<Produto> lista_de_produtos;
            lista_de_produtos = new ArrayList<>();
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
             while (rs.next()){
                Produto produto = new Produto();
                
                produto.setId(rs.getInt("id_produto"));
                produto.setNome(rs.getString("nome"));
                produto.setValor(rs.getFloat("valor"));
                produto.setQuantidade(rs.getInt("quantidade"));
                
                lista_de_produtos.add(produto);
            }
             
            stmt.execute();
            stmt.close();
            return (ArrayList<Produto>) lista_de_produtos;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
