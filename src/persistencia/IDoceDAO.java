package persistencia;
import java.util.ArrayList; 
import negocio.Doce;
/**
 *
 * @author Aryel
 */
public interface IDoceDAO {
    public void adiciona(Doce um_doce);
    public void altera(Doce um_doce);
    public void remove(int id);
    public ArrayList<Doce> listarTodos();
    public Doce getByID(int id);
}
