package persistencia;
import java.util.ArrayList; 
import negocio.Produto;
/**
 *
 * @author Aryel
 */
public interface IProdutoDAO {
    /**
     * Metodo usado para persistir um produto
     * 
     * @param um_produto uma instancia da classe de negocio Produto
     */
    public void adiciona(Produto um_produto);
    
    /**
     * Metodo usado para alerar um produto previamente persistido
     * 
     * @param um_produto uma instancia da classe de negocio Produto
     */
    public void altera(Produto um_produto);
    
    /**
     * Metodo usado para remover um produto previamente persistido
     * 
     * @param id numero de identificação de um produto
     */
    public void remove(int id);
    
    /**
     * Metodo usado para listar todos os produtos previamente persistido
     * 
     * @return ArrayList - lista de produtos
     */
    public ArrayList<Produto> listarTodos();
    
    /**
     * Metodo usado para buscar um produto previamente persistido
     * 
     * @param id numero de identificação de um produto
     * @return Produto - produto com o id passado
     */
    public Produto getByID(int id);
    
    /**
     * Metodo usado para buscar produtos previamente persistidos pelo nome
     * 
     * @param nome nome(ou parte dele) de um produto
     * @return ArrayList - lista de produtos
     */
    public ArrayList<Produto> getByNome(String nome);
}
