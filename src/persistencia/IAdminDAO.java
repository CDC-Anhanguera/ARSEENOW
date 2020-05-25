/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;
import negocio.Admin;
import java.util.ArrayList; 
/**
 *  
 * @author shaw
 */
public interface IAdminDAO {
    /**
     * Metodo usado para persistir um admin
     * 
     * @param um_admin uma instancia da classe de negocio Admin
     */
    public void adiciona(Admin um_admin);
    
    /**
     * Metodo usado para alterar um admin previamente persistido
     * 
     * @param um_admin uma instancia da classe de negocio Admin
     */
    public void altera(Admin um_admin);     // se não for ter este método tem que tirar isso aq
    /**
     * Metodo usado para remover um admin previamente persistido
     * 
     * @param id numero de identificação de um admin
     */
    public void remove(int id);         // se não for ter este método tem que tirar isso aq
    /**
     * Metodo usado para listar todos os admins previamente persistidos
     * 
     * @return ArrayList - lista de admins
     */
    
    public ArrayList<Admin> listarTodos();  // se não for ter este método tem que tirar isso aq
    
    /**
     * Metodo usado para buscar um admin previamente persistido
     * 
     * @param id numero de identificação de um admin
     * @return Admin - admin com o id passado
     */
    public Admin getByID(int id);
}


