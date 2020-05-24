/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe para gerar conexoes com o banco de dados
 * @author aryel.sa
 */
public class ConFactory {
    
    /**
     * Metodo usado para criar uma conexão com o banco de dados
     * 
     * @return DriverManager
     * @exception RuntimeException ao se conectar ao banco ou executar o comando.
     * @see SQLException
     */
    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/db_estoque", "root","");
        }
        catch (SQLException excecao){
            throw new RuntimeException(excecao);
        }
    }
    
    /**
     * Metodo usado para criar uma conexão com o banco de dados
     * 
     * @param user - usuario da base de dados
     * @param password - senha do usuario da base de dados
     * @return DriverManager
     * @exception RuntimeException ao se conectar ao banco ou executar o comando.
     * @see SQLException
     */
    public Connection getConnection(String user, String password) {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/db_estoque", user, password);
        }
        catch (SQLException excecao){
            throw new RuntimeException(excecao);
        }
    }
}
