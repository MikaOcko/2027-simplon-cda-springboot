package fr.simplon.domedespuys.view;

public class OrderView {
    public interface Id{}
    public interface Number{}
    public interface CreatedAt{}
    public interface Status{}
    public interface User{}
    public interface Address{}
    public interface OrderProducts{}

    public interface OrderListView extends Number, Status{}
    public interface OrderDetailView extends
            OrderListView,
            Address,
            CreatedAt,
            UserView.UserDetailView{}
}
