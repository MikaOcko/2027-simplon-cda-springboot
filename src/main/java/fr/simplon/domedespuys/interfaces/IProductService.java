package fr.simplon.domedespuys.interfaces;

import fr.simplon.domedespuys.dto.ProductDTO;
import fr.simplon.domedespuys.entity.Product;

public interface IProductService extends

        ICreate<Product, ProductDTO>,
        IUpdate<Product, ProductDTO>,
        ICollection,
        IGetItem

{
}
