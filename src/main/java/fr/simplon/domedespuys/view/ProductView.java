package fr.simplon.domedespuys.view;

public class ProductView {
    public interface Id{};
    public interface Label{};
    public interface Description{};
    public interface Price{};
    public interface Slug{};
    public interface CreatedAt{};
    public interface Brand{};
    public interface Images{};
    public interface MainImage{};

    // Infos que l'on affiche
    public interface ProductListView extends
            Label,
            Price,
            Slug,
            MainImage,
            ImageView.Path,
            Brand,
            BrandView.Label {}
    public interface ProductDetailView extends
            ProductListView,
            Description,
            Images,
            ImageView.ImageListView {}
}
