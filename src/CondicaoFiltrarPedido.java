import java.util.function.Predicate;

public class CondicaoFiltrarPedido implements Predicate<Pedido> {

    @Override
    public boolean test(Pedido pedido) {
        Predicate<Pedido> predicate = t -> predicate.test(pedido);
        return predicate;
    }
}
