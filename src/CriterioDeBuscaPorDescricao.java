import java.util.Comparator;

public class CriterioDeBuscaPorDescricao implements Comparator<ItemDePedido> {

    @Override
    public int compare(ItemDePedido item1, ItemDePedido item2) {
        int resultado = item1.getProduto().descricao.equals(item2.getProduto().descricao) ? 0 : 1;
        return resultado;
    }
}
