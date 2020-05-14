package persistencia;
import java.util.ArrayList; 
import negocio.Produto;
/**
 *
 * @author Aryel
 */
public interface IProdutoDAO {
    public void adiciona(Produto um_produto);
    public void altera(Produto um_produto);
    public void remove(int id);
    public ArrayList<Produto> listarTodos();
    public Produto getByID(int id);
    public ArrayList<Produto> getByNome(String nome);
}
