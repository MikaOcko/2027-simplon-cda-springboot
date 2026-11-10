package fr.simplon.domedespuys.services;

import fr.simplon.domedespuys.dto.ProductDTO;
import fr.simplon.domedespuys.entity.Product;
import fr.simplon.domedespuys.interfaces.IProductService;
import fr.simplon.domedespuys.repository.ProductRepository;

import java.util.List;

public class ProductServiceImpl implements IProductService {

    private ProductRepository productRepository;
    
    @Override
    public List getCollection() {
        return List.of();
    }

    @Override
    public Product create(ProductDTO dto) {
        return null;
    }

    @Override
    public Object getById(String id) {
        return null;
    }

    @Override
    public Product update(String id, ProductDTO dto) {
        return null;
    }
}
