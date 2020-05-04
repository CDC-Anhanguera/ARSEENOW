/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author aryel.sa
 */
public  class conection {
    public static void main(String[] args) throws SQLException {
        Connection conexao = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/db_estoque", "root","");
        System.out.println("CONECTADO AO BANCO COM SUCESSO!");
        conexao.close();
    }
}
