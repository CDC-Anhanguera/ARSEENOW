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
    
    public void adiciona(Admin um_admin);
    public void altera(Admin um_admin);     // se não for ter este método tem que tirar isso aq
    public void remove(int id);         // se não for ter este método tem que tirar isso aq
    public ArrayList<Admin> listarTodos();  // se não for ter este método tem que tirar isso aq
    public Admin getByID(int id);
}


