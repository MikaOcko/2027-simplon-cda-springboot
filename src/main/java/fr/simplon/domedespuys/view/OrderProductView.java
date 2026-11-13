package fr.simplon.domedespuys.view;

public class OrderProductView {
    public interface Id{}
    public interface Quantity{}
    public interface Price{}
    public interface Product{}
    public interface Order{}

    public interface OrderProductListView extends Quantity, Price{}
    public interface OrderProductDetailView extends OrderProductListView,
            Order,
            OrderView.OrderListView,
            Product,
            ProductView.ProductListView{}
}
